package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.SizeVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.CompositeAppearanceFeature;
import net.heriazone.hzlib.api.entity.variants.interfaces.ICompositeAppearance;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.WildTamableEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Gourdragora entity — tamable with three size appearance variants (mini, default, big)
 * and GeckoLib animation support.<p>
 * <p>
 * <b>Spawn initialization:</b> Picks a random {@link net.heriazone.hzlib.api.entity.variants.interfaces.IAppearanceVariant} composite from
 * {@link net.heriazone.hzlib.api.entity.features.variants.AppearanceVariantFeature} — setting texture, model, and animator in one call.
 * Size stats are then applied via {@link SizeVariantFeature} using the appearance's model key.
 * <p>
 * <b>Dynamic hitbox:</b> {@link #getDefaultDimensions} reads {@code MODEL_VARIANT} on every
 * pose change — no separate entity type registrations needed per size.
 * <p>
 * <b>NBT persistence:</b> Stat multipliers are re-applied on load since {@code MODEL_VARIANT}
 * is restored by the base class before {@link #readAdditionalSaveData} runs.
 */
public class GourdragoraEntity extends WildTamableEntity {

    // -- Constants --

    /** Cooldown in ticks between pumpkin pie drops (60 seconds = 1200 ticks). */
    private static final int HUNGER_WATCH_COOLDOWN_TICKS = 1200;

    /** Hunger level below which pumpkin pie drops are triggered (< 11 = below half). */
    private static final int HUNGER_WATCH_THRESHOLD = 11;

    /** Chance per tick that a pie drops when hunger is low and cooldown has expired (2 %). */
    private static final float HUNGER_WATCH_CHANCE = 0.02f;

    // -- Fields --

    /**
     * Server-side cooldown countdown (ticks). When this reaches 0 the hunger-watch
     * check is eligible to fire again. Persisted to NBT so the cooldown survives
     * world reloads and prevents a pie avalanche on chunk-reload.
     */
    private int hungerWatchCooldown = 0;

    /**
     * Sets model and animator to the default geo file immediately so the entity renders
     * correctly before {@link #initializeSpawnVariants} runs at spawn time.
     */
    public GourdragoraEntity(EntityType<? extends GourdragoraEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> gourdragoraType) {
        super(entityType, level, gourdragoraType);
    } // Constructor: GourdragoraEntity ()

    // -- Dynamic Hitbox --

    /**
     * Returns dimensions for the current size and pose.
     * Reads {@code MODEL_VARIANT} (geo file name) to look up the matching
     * {@link SizeVariantFeature.SizeConfig} — O(1) HashMap lookup.
     */
    @Override
    public @NotNull EntityDimensions getDefaultDimensions(Pose pose) {
        if (nativeEntity == null) return super.getDefaultDimensions(pose);
        return nativeEntity.getFeature(SizeVariantFeature.class)
                .map(feature -> feature.getDimensionsForPose(getModelVariant(), pose))
                .orElseGet(() -> super.getDefaultDimensions(pose));
    } // getDefaultDimensions ()

    // -- Spawn Initialization --

    /**
     * Picks a size-weighted appearance composite at spawn and applies all three variant
     * dimensions at once, then applies size stat multipliers from the composite's model key.
     * <p>
     * <b>Weighted selection:</b> Delegates to {@link SizeVariantFeature#pickWeightedRandom()}
     * to honour the Mini=40, Default=40, Big=20 spawn weight distribution declared on
     * {@link GourdragoraFamily#SIZE_FEATURE}. The selected {@link SizeVariantFeature.SizeConfig}
     * model key is matched against the registered appearance composites to find the appearance
     * whose model key matches — ensuring texture, model, and animator stay coherent.
     * <p>
     * Falls back to {@code getRandomVariant} (uniform) if no {@link SizeVariantFeature} is
     * registered, so the entity never fails to spawn.
     */
    @Override
    protected void initializeSpawnVariants(ServerLevelAccessor world, MobSpawnType reason) {
        if (nativeEntity == null) return;

        nativeEntity.getFeature(CompositeAppearanceFeature.class).ifPresent(appearanceFeature -> {
            // Attempt weighted size selection first
            nativeEntity.getFeature(SizeVariantFeature.class).ifPresentOrElse(sizeFeature -> {
                SizeVariantFeature.SizeConfig chosenSize = sizeFeature.pickWeightedRandom();

                // Derive the appearance variant key using the declared sizeLabel —
                // no string surgery needed. Convention: "{entityKey}_{sizeLabel}".
                String appearanceKey = nativeEntity.getKey() + "_" + chosenSize.getSizeLabel();
                ICompositeAppearance appearance = appearanceFeature.getVariant(nativeEntity.getKey(), appearanceKey);
                if (appearance == null) {
                    appearance = appearanceFeature.getRandomVariant(nativeEntity.getKey());
                }
                if (appearance == null) return;

                setTextureVariant(appearance.getTextureKey());
                setModelVariant(appearance.getModelKey());
                setAnimatorVariant(appearance.getAnimatorKey());
                // getSizeConfig() now carries the SizeConfig directly — no secondary lookup
                appearance.getSizeConfig().ifPresentOrElse(
                        sc -> sc.applyTo(this),
                        () -> chosenSize.applyTo(this));

            }, () -> {
                // No SizeVariantFeature — fall back to uniform random appearance selection
                ICompositeAppearance appearance = appearanceFeature.getRandomVariant(nativeEntity.getKey());
                if (appearance == null) return;
                setTextureVariant(appearance.getTextureKey());
                setModelVariant(appearance.getModelKey());
                setAnimatorVariant(appearance.getAnimatorKey());
                appearance.getSizeConfig().ifPresent(sc -> sc.applyTo(this));
            });
        });

        refreshDimensions();
    } // initializeSpawnVariants ()

    // -- Hunger Watch --

    /**
     * Ticks the hunger-watch system on the server side.
     * <p>
     * <b>Logic:</b>
     * <ol>
     *   <li>Only runs server-side, only when tamed and owner is online.</li>
     *   <li>Decrements {@link #hungerWatchCooldown} each tick; check is skipped while non-zero.</li>
     *   <li>When cooldown reaches 0: if owner's food level is below {@link #HUNGER_WATCH_THRESHOLD}
     *       (half bar), there is a {@link #HUNGER_WATCH_CHANCE} (2 %) chance per tick to drop
     *       a Pumpkin Pie at the entity's feet.</li>
     *   <li>On drop: resets cooldown to {@link #HUNGER_WATCH_COOLDOWN_TICKS} (60 s).</li>
     * </ol>
     * <p>
     * <b>Design:</b> The 2 % per-tick rate with a 60 s cooldown means roughly one pie
     * every ~50 ticks on average after the cooldown expires, never more than one per
     * 60 s. The cooldown prevents a sustained pie stream when the owner stays hungry.
     */
    @Override
    public void aiStep() {
        super.aiStep();

        if (level().isClientSide || !isTame()) return;

        // Decrement cooldown every tick regardless of owner hunger state
        if (hungerWatchCooldown > 0) {
            hungerWatchCooldown--;
            return;
        }

        // Cooldown expired — check owner hunger
        LivingEntity owner = getOwner();
        if (!(owner instanceof Player ownerPlayer)) return;

        FoodData food = ownerPlayer.getFoodData();
        if (food.getFoodLevel() < HUNGER_WATCH_THRESHOLD
                && random.nextFloat() < HUNGER_WATCH_CHANCE) {
            // Drop a Pumpkin Pie at entity feet and reset cooldown
            spawnAtLocation(new ItemStack(Items.PUMPKIN_PIE));
            playSound(SoundEvents.GENERIC_EAT, 0.6f, 1.0f + random.nextFloat() * 0.2f);
            hungerWatchCooldown = HUNGER_WATCH_COOLDOWN_TICKS;
        }
    } // aiStep ()

    // -- Carving Interaction --

    /**
     * Handles shears interaction: cycles the entity's carving pattern to the next stage
     * and damages the shears by 1 durability point — matching vanilla pumpkin carving behaviour.
     * <p>
     * <b>Architecture:</b> Delegates to {@link #cycleOverlaySlot(String)} with
     * {@link GourdragoraFamily#SLOT_CARVING}, which advances the INTERACTIVE slot's index
     * through the pool declared on this variant's {@link net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature}.
     * No hardcoded pattern list here — adding a new carving stage to the type definition
     * automatically extends the cycle without touching this class.
     * <p>
     * <b>Side effects (server-side only):</b>
     * <ul>
     *   <li>Carving slot advanced to next stage (synced via {@code SynchedEntityData})</li>
     *   <li>Carve sound played at entity position</li>
     *   <li>Shears lose 1 durability</li>
     * </ul>
     */
    @Override
    protected InteractionResult handleSpecificInteractions(Player player, InteractionHand hand, ItemStack stack) {
        if (stack.getItem() instanceof ShearsItem) {
            if (!level().isClientSide) {
                cycleOverlaySlot(GourdragoraFamily.SLOT_CARVING);
                playSound(SoundEvents.PUMPKIN_CARVE, 1.0F, 1.0F);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            }
            return InteractionResult.sidedSuccess(level().isClientSide);
        }
        // All non-shears interactions (sit toggle, state changes, belly, preferences)
        // are handled by the parent class. Always delegate — do not swallow with PASS.
        return super.handleSpecificInteractions(player, hand, stack);
    } // handleSpecificInteractions ()

    // -- NBT Persistence --

    /**
     * Persists {@link #hungerWatchCooldown} alongside the standard NBT written by the
     * base class. Also writes an {@code addAdditionalSaveData} override so the cooldown
     * survives world reloads.
     */
    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("HungerWatchCooldown", hungerWatchCooldown);
    } // addAdditionalSaveData ()

    /**
     * Re-applies size stat multipliers after load and restores {@link #hungerWatchCooldown}.
     * {@code MODEL_VARIANT} is restored by the base class before this runs.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("HungerWatchCooldown")) {
            hungerWatchCooldown = nbt.getInt("HungerWatchCooldown");
        }
        if (nativeEntity != null) {
            nativeEntity.getFeature(SizeVariantFeature.class).ifPresent(feature ->
                    feature.getConfig(getModelVariant()).applyTo(this));
            refreshDimensions();
        }
    } // readAdditionalSaveData ()

} // Class: GourdragoraEntity