package net.heriazone.monsters_girls.entity;

import net.heriazone.hzlib.api.entity.NativeEntity;
import net.heriazone.hzlib.api.entity.features.*;
import net.heriazone.hzlib.api.entity.features.SoundFeature;
import net.heriazone.hzlib.api.entity.features.emanation.*;
import net.heriazone.hzlib.api.nbt.DataField;
import net.heriazone.hzlib.framework.entity.data.CombatData;
import net.heriazone.hzlib.framework.entity.enums.EntityState;
import net.heriazone.monsters_girls.entity.data.MonsterFields;
import net.heriazone.monsters_girls.entity.feature.BellyFeature;
import net.heriazone.monsters_girls.entity.BellyLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>Specialized entity class for monster-based mods with belly system and state management.<p>
 * <p>
 * <b>Architecture:</b> Extends NativeEntity with monster-specific features including
 * belly mechanics, state management, and preference systems. Serves as the base class
 * for MonstersEntity and other monster implementations.
 * <p>
 * <b>Design Decision:</b> Uses CombatData for base statistics and adds monster-specific
 * features like belly system, planting abilities, and behavioral states without the
 * complex leveling system used by robots.
 * <p>
 * <b>Belly System:</b> Implements texture-based belly progression using feathers (reduce)
 * and apples (increase) to modify the monster's appearance and state.
 * <p>
 * <b>Thread Safety:</b> EntityDataAccessor fields are synchronized automatically.
 * State modifications should occur on server thread.
 */
public abstract class MonsterEntity extends NativeEntity {

    // -- Entity Data Accessors --

    /**
     * <p>Synchronized belly level — tracks how far the belly has progressed (0–4).<p>
     * <p>
     * <b>Belly System:</b> Replaces the old {@code HAS_BELLY} boolean. An int in the range
     * {@code [0, BellyLevel.CHUNKY.getLevel()]} (0–4) is stored and synced. The value is
     * clamped to {@code [0, BellyFeature.getMaxLevel()]} at write time. CONDITIONAL overlay
     * slots evaluate {@code RenderConditions.bellyAtLeast(n)} against this value each frame.
     * Entities whose family has no {@link BellyFeature} registered always stay at 0 and
     * ignore apple / feather interactions entirely.
     */
    protected static final EntityDataAccessor<Integer> BELLY_LEVEL =
            SynchedEntityData.defineId(MonsterEntity.class, EntityDataSerializers.INT);

    // Monster Preferences
    protected static final EntityDataAccessor<Boolean> PLANTING_ENABLED = SynchedEntityData.defineId(MonsterEntity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> SOUND_ENABLED    = SynchedEntityData.defineId(MonsterEntity.class, EntityDataSerializers.BOOLEAN);

    // -- Overlay Slot Pool --

    /**
     * Pre-declared synced data accessors for persistent overlay slots (RANDOM + INTERACTIVE).
     * <p>
     * <b>Why here and not NativeEntity:</b> Only monster entities currently use
     * {@link net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature}. Declaring the
     * pool on {@code MonsterEntity} keeps robot entity ID sequences unchanged (robots have no
     * overlay slots in this release). Robot migration is planned as a follow-up (ADR_017).
     * <p>
     * <b>Pool size = 2 (sufficient for Sprint 10):</b> Persistent slots are only consumed by
     * RANDOM and INTERACTIVE modes. CONDITIONAL (belly) and ALWAYS (emissive) slots carry no
     * persistent state and consume no pool entries. Audit of current usage:
     * <ul>
     *   <li>Mushroom families — 1 RANDOM hat slot → pool[0]</li>
     *   <li>Mandrake FLOWER — 1 RANDOM hair slot → pool[0]</li>
     *   <li>Gourdragora — 1 INTERACTIVE carving slot → pool[0]</li>
     *   <li>Wisp / Spook / Warped — belly CONDITIONAL + emissive ALWAYS → 0 pool entries</li>
     * </ul>
     * Maximum concurrent persistent slots per entity type = 1. Pool[1] is a pre-declared buffer
     * for any future second persistent slot without requiring a SynchedEntityData ID reshuffle.
     * No expansion to 3 is needed for Sprint 10 — belly does not require a persistent slot.
     */
    private static final EntityDataAccessor<String> OVERLAY_SLOT_0 =
            SynchedEntityData.defineId(MonsterEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> OVERLAY_SLOT_1 =
            SynchedEntityData.defineId(MonsterEntity.class, EntityDataSerializers.STRING);

    private static final List<EntityDataAccessor<String>> MONSTER_OVERLAY_POOL =
            List.of(OVERLAY_SLOT_0, OVERLAY_SLOT_1);

    // Combat and Behavior Timers — inherited from InternalEntity:
    // waryTimer, autoHealTimer, combatMode, autoHeal are defined in NativeEntity base.
    protected int plantingCooldown = 0;
    protected boolean canPlant = true;
    protected boolean hasEffects = false;

    /** Per-entity runtime state for {@link EmanationFeature} — threshold cooldown. */
    protected final EmanationState emanationState = new EmanationState();

    // -- Combat Data Object --

    /**
     * <p>Combat data container for base statistics.<p>
     * <p>
     * <b>Design Decision:</b> Uses CombatData instead of CombatLevelStats since
     * monsters don't have the complex leveling system that robots use.
     */
    protected CombatData combatData;

    // -- Constructor --

    /**
     * Creates monster entity with specified entity type and world.
     * <p>
     * <b>State Impact:</b> Initializes combat data and delegates variant initialization
     * to the framework.
     * <p>
     * <b>Variant Initialization:</b> Variant setup is intentionally left to the
     * framework's two-phase process:
     * <ul>
     *   <li>{@code applyBaseAttributes()} — upgrades the "default" placeholder to the
     *       entity-type's registered default variant from {@code TextureVariantFeature}.</li>
     *   <li>{@code finalizeSpawn()} → {@code initializeSpawnVariants()} — selects a
     *       valid registered variant (random or biome-driven if {@code BiomeAppearanceFeature}
     *       is present) before the first render tick.</li>
     * </ul>
     * Hardcoding {@code key + "_default"} here bypasses both phases and would set an
     * unregistered key for any entity type that doesn't have a {@code "_default"} entry
     * in {@code VariantRegistries.TEXTURES}, causing a null-texture render crash.
     *
     * @param entityType  Minecraft's entity type for registration
     * @param world       world instance where entity exists
     * @param nativeEntity the entity type configuration driving variants and combat stats
     */
    protected MonsterEntity(EntityType<? extends TamableAnimal> entityType, Level world, MonstersFamily<? extends MonstersFamily<?>> nativeEntity) {
        super(entityType, world, nativeEntity);

        // Sync combatData from the type descriptor so NBT serialization captures
        // the correct stats rather than CombatData's uninitialized defaults (0.25 moveSpeed, 0 elsewhere).
        // Without this, addAdditionalSaveData() persists the blank CombatData, and on reload
        // readAdditionalSaveData() restores those wrong values, causing the "fast on first spawn,
        // normal after reload" bug — because applyBaseAttributes() (below) reads from nativeEntity.getData()
        // correctly, but that gets clobbered by the NBT round-trip using the blank combatData.
        this.combatData = new CombatData();
        if (nativeEntity != null) {
            CombatData src = nativeEntity.getData();
            this.combatData.setMaxHealth(src.getMaxHealth());
            this.combatData.setAttackDamage(src.getAttackDamage());
            this.combatData.setAttackSpeed(src.getAttackSpeed());
            this.combatData.setArmor(src.getArmor());
            this.combatData.setArmorToughness(src.getArmorToughness());
            this.combatData.setKnockbackResistance(src.getKnockbackResistance());
            this.combatData.setMoveSpeed(src.getMoveSpeed());
        }

        // Framework resolves variants:
        //   applyBaseAttributes() → entity-specific default from TextureVariantFeature
        //   finalizeSpawn()       → random or biome-driven selection
        applyBaseAttributes();

        this.entityData.set(STATE, MonsterState.MOVE.getId());

        // registerGoals() is called by Minecraft's Mob constructor (via super above) before
        // nativeEntity is assigned, so every goal reads the null-fallback speed of 0.6f.
        // Re-register now that nativeEntity is set so goals use the correct configured speed.
        this.goalSelector.removeAllGoals(g -> true);
        this.targetSelector.removeAllGoals(g -> true);
        registerGoals();

        registerNativeGoals();

        // Register SynchedEntityData accessors for persistent overlay slots (RANDOM + INTERACTIVE).
        // Must be called after nativeEntity is set and after super() has completed defineSynchedData().
        registerOverlayData();
    } // Constructor: MonsterEntity ()

    // -- Inherited Methods --

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(BELLY_LEVEL, 0);
        builder.define(PLANTING_ENABLED, true);
        builder.define(SOUND_ENABLED, true);
        // Register the pre-declared overlay slot pool so all monster entity subclasses
        // always have these IDs in a fixed position — even those whose entity type has
        // no OverlayFeature (the slots simply remain as empty strings and are unused).
        for (EntityDataAccessor<String> accessor : MONSTER_OVERLAY_POOL) {
            builder.define(accessor, "");
        }
    } // defineSynchedData ()

    @Override
    protected List<EntityDataAccessor<String>> getOverlaySlotPool() {
        return MONSTER_OVERLAY_POOL;
    } // getOverlaySlotPool ()

    @Override
    public boolean isFood(ItemStack itemStack) {
        AtomicBoolean canEat = new AtomicBoolean(false);
        nativeEntity.getFeature(FoodFeature.class).ifPresent(food -> {
            canEat.set(food.isFood(itemStack));
        });
        return canEat.get();
    } // isFood ()

    @Override
    protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource damageSource, boolean bl) {
        super.dropCustomDeathLoot(serverLevel, damageSource, bl);
        nativeEntity.getFeature(DropFeature.class).ifPresent(drop -> {
            this.spawnAtLocation(drop.createDropStack());
        });
    } // dropCustomDeathLoot ()

    @Override
    public void aiStep() {
        super.aiStep();

        if (!level().isClientSide()) {
            // ON_THRESHOLD emanations — checked every tick, guarded by EmanationState cooldown
            if (nativeEntity != null) {
                nativeEntity.getFeature(EmanationFeature.class).ifPresent(f -> {
                    List<EmanationRule> thresholdRules = f.getRulesFor(EmanationTrigger.ON_THRESHOLD);
                    if (!thresholdRules.isEmpty()) {
                        EmanationContext ctx = EmanationContext.onThreshold(this);
                        thresholdRules.forEach(rule -> rule.tryFire(ctx, emanationState));
                    }
                });
            }

            if (!isPlantingEnabled()) return; // NBT flag check
            if (plantingCooldown > 0) {plantingCooldown--;return;} // Cooldown check

            nativeEntity.getFeature(PlantingFeature.class).ifPresent(this::tryPlant);
        }
    } // aiStep ()

    // -- Custom Methods --

    protected void registerNativeGoals() {
        if (nativeEntity == null) return;
        nativeEntity.getFeature(FoodFeature.class).ifPresent(food -> {
            Ingredient temptIngredient = food.getTemptingIngredient();
            if (temptIngredient != Ingredient.EMPTY) {
                this.goalSelector.addGoal(3, new TemptGoal(this, 0.8, temptIngredient, false));
            }
        });
    } // registerNativeGoals ()

    /**
     * Handles ON_GIFT emanation rules after taming food check.
     * <p>
     * <b>Wire point:</b> Runs after {@code super.onCommonInteraction()} so taming food
     * is checked first. ON_GIFT rules only fire when the entity is tamed — untamed
     * entities don't know the giver well enough to feel happy about a gift.
     * <p>
     * <b>First-match-wins for gifts:</b> A gift has one meaning per item — the first
     * matching rule fires, others are skipped. This mirrors how ExchangeFeature handles
     * item sequences: the player gave one thing, one blessing flows back.
     */
    @Override
    protected InteractionResult onCommonInteraction(Player player, InteractionHand hand, ItemStack stack) {
        InteractionResult result = super.onCommonInteraction(player, hand, stack);

        if (!level().isClientSide && isTame() && nativeEntity != null && !stack.isEmpty()) {
            nativeEntity.getFeature(EmanationFeature.class).ifPresent(f -> {
                EmanationContext ctx = EmanationContext.onGift(this, player, stack);
                for (EmanationRule rule : f.getRulesFor(EmanationTrigger.ON_GIFT)) {
                    if (rule.tryFire(ctx, emanationState)) break; // first match wins
                }
            });
        }

        return result;
    } // onCommonInteraction ()

    private void tryPlant(PlantingFeature feature) {
        for (PlantingFeature.PlantItem entry : feature.getEntries()) {
            boolean planted = false;

            for (int i = 0; i < feature.getMaxAttempts(); i++) {
                BlockPos candidate = blockPosition().offset(
                        random.nextInt(feature.getSearchRadius() * 2 + 1) - feature.getSearchRadius(), 0,
                        random.nextInt(feature.getSearchRadius() * 2 + 1) - feature.getSearchRadius()
                );
                if (tryPlantAt(entry, candidate)) { planted = true; break; }
            }

            if (!planted) tryPlantAt(entry, blockPosition()); // fallback

            plantingCooldown = feature.resolveCooldown(entry); // reset
        }
    } // tryPlant ()

    private boolean tryPlantAt(PlantingFeature.PlantItem entry, BlockPos pos) {
        if (entry.getDirection() == PlantingFeature.PlantDirection.UP) {
            // Ceiling planting: block above candidate must be a valid ceiling block,
            // candidate itself must be air. Plant hangs downward from the ceiling.
            BlockState ceiling = level().getBlockState(pos.above());
            BlockState target  = level().getBlockState(pos);
            if (entry.isValidCeiling(ceiling) && target.isAir()) {
                level().setBlock(pos, entry.getPlant().defaultBlockState(), 3);
                return true;
            }
        } else {
            // Floor planting (DOWN, default): block below candidate must be a valid
            // surface, candidate itself must be air.
            BlockState below  = level().getBlockState(pos.below());
            BlockState target = level().getBlockState(pos);
            if (entry.isValidSurface(below) && target.isAir()) {
                level().setBlock(pos, entry.getPlant().defaultBlockState(), 3);
                return true;
            }
        }
        return false;
    } // tryPlantAt ()

    // -- Data Pipeline Hooks --

    /**
     * Supplies live field values to {@link net.heriazone.hzlib.api.nbt.EntityDataSchema#writeTo}.
     * Dispatches on {@link MonsterFields} constants by identity — no string keys.
     * Falls back to the field's declared default for any unrecognised handle.
     */
    @Override
    @SuppressWarnings("unchecked")
    protected <T> T provideFieldValue(DataField<T> field) {
        if (field == MonsterFields.BELLY_LEVEL)       return (T) Integer.valueOf(getBellyLevel());
        if (field == MonsterFields.PLANTING_ENABLED)  return (T) Boolean.valueOf(isPlantingEnabled());
        if (field == MonsterFields.SOUND_ENABLED)     return (T) Boolean.valueOf(isSoundEnabled());
        return field.getDefaultValue();
    } // provideFieldValue ()

    /**
     * Applies values loaded from NBT to entity state.
     * Pushes each value into both the logical accessor and its
     * {@code SynchedEntityData} register — NBT is authoritative on load.
     */
    @Override
    @SuppressWarnings("unchecked")
    protected <T> void consumeFieldValue(DataField<T> field, T value) {
        if (field == MonsterFields.BELLY_LEVEL)      { setBellyLevel((Integer) value);       return; }
        if (field == MonsterFields.PLANTING_ENABLED) { setPlantingEnabled((Boolean) value);  return; }
        if (field == MonsterFields.SOUND_ENABLED)    { setSoundEnabled((Boolean) value);     return; }
    } // consumeFieldValue ()

    // -- Belly System --

    /**
     * Returns the current belly level (0 = SLIM / none).
     * <p>
     * Overrides {@link net.heriazone.hzlib.api.entity.NativeEntity#getBellyLevel()} to
     * return the live synced value rather than the default {@code 0}.
     */
    @Override
    public int getBellyLevel() {
        try { return this.entityData.get(BELLY_LEVEL); }
        catch (Exception e) { return 0; }
    } // getBellyLevel ()

    /**
     * Sets the belly level, clamped to {@code [0, BellyLevel.CHUNKY.getLevel()]}.
     * The effective upper bound is further clamped at write time inside
     * {@link #handleBellyProgression} to the family's {@link BellyFeature#getMaxLevel()}.
     *
     * @param level raw belly level integer
     */
    public void setBellyLevel(int level) {
        this.entityData.set(BELLY_LEVEL, Math.max(0, Math.min(level, BellyLevel.CHUNKY.getLevel())));
    } // setBellyLevel ()

    /**
     * Handles belly level progression via apple (increment) and feather (decrement).
     * <p>
     * <b>Gate:</b> Returns {@code false} immediately if the entity's family has no
     * {@link BellyFeature} registered — entities without this feature ignore apple and
     * feather entirely. This is the single source of truth for belly eligibility.
     * <p>
     * <b>Apple:</b> Increments belly level up to {@link BellyFeature#getMaxLevel()}.
     * The item is consumed (unless the player is in creative mode).
     * <p>
     * <b>Feather:</b> Decrements belly level down to 0. The feather is intentionally
     * <em>not</em> consumed — decreasing belly is a deliberate owner choice and should
     * not cost the player an item.
     *
     * @param stack  item held by the interacting player
     * @param player interacting player
     * @return {@code true} if belly level changed and the interaction was consumed
     */
    protected boolean handleBellyProgression(ItemStack stack, Player player) {
        if (nativeEntity == null || level().isClientSide) return false;

        // Belly interaction is owner-only on tamed entities
        if (!isTame() || !isOwnedBy(player)) return false;

        // Gate: family must declare BellyFeature — absence means no belly interaction
        var featureOpt = nativeEntity.getFeature(BellyFeature.class);
        if (featureOpt.isEmpty()) return false;
        BellyFeature feature = featureOpt.get();

        int current = getBellyLevel();
        int maxLevel = feature.getMaxLevel().getLevel();

        if (stack.is(Items.APPLE)) {
            if (current >= maxLevel) return false; // already at cap
            setBellyLevel(current + 1);
            if (!player.getAbilities().instabuild) stack.shrink(1);
            playSound(net.minecraft.sounds.SoundEvents.GENERIC_EAT, 0.5f, 1.0f);
            return true;
        }

        if (stack.is(Items.FEATHER)) {
            if (current <= 0) return false; // already at floor
            setBellyLevel(current - 1);
            // Feather is NOT consumed — deliberate design decision
            playSound(net.minecraft.sounds.SoundEvents.ITEM_PICKUP, 0.5f, 1.2f);
            return true;
        }

        return false;
    } // handleBellyProgression ()

    // -- Monster Preferences --

    /**
     * Returns planting preference.
     *
     * @return true if planting is enabled
     */
    public boolean isPlantingEnabled() {
        try {
            return this.entityData.get(PLANTING_ENABLED);
        } catch (Exception e) {
            return true;
        }
    } // isPlantingEnabled ()

    /**
     * Sets planting preference.
     * <p>
     * <b>Behavior Impact:</b> When enabled, monster can plant crops or flowers
     * automatically while following the player.
     *
     * @param enabled true to enable planting
     */
    public void setPlantingEnabled(boolean enabled) {
        this.entityData.set(PLANTING_ENABLED, enabled);
    } // setPlantingEnabled ()

    /**
     * Returns sound preference.
     *
     * @return true if sounds are enabled
     */
    public boolean isSoundEnabled() {
        try {
            return this.entityData.get(SOUND_ENABLED);
        } catch (Exception e) {
            return true;
        }
    } // isSoundEnabled ()

    /**
     * Sets sound preference.
     * <p>
     * <b>Audio Impact:</b> When disabled, monster won't play ambient sounds
     * but will still play hurt/death sounds.
     *
     * @param enabled true to enable sounds
     */
    public void setSoundEnabled(boolean enabled) {
        this.entityData.set(SOUND_ENABLED, enabled);
    } // setSoundEnabled ()

    // -- Combat Data Access --

    /**
     * Returns current combat data.
     * <p>
     * <b>Thread Safety:</b> Returns reference to internal object. Callers should
     * not modify returned object directly.
     *
     * @return combat data object
     */
    public CombatData getCombatData() {
        return this.combatData;
    } // getCombatData ()

    /**
     * Updates combat data with new values.
     * <p>
     * <b>State Impact:</b> Updates entity attributes to match new combat data.
     *
     * @param newCombatData new combat data to apply
     */
    public void setCombatData(CombatData newCombatData) {
        if (newCombatData == null) return;
        
        this.combatData = newCombatData;
        updateAttributesFromCombatData();
    } // setCombatData ()

    /**
     * Updates entity attributes based on combat data.
     * <p>
     * <b>Attribute Sync:</b> Ensures Minecraft entity attributes match the
     * values stored in combat data for consistent behavior.
     */
    protected void updateAttributesFromCombatData() {
        if (combatData == null) return;
        
        // Update max health
        if (this.getAttribute(Attributes.MAX_HEALTH) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(combatData.getMaxHealth());
        }
        
        // Update attack damage
        if (this.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(combatData.getAttackDamage());
        }
        
        // Update movement speed
        if (this.getAttribute(Attributes.MOVEMENT_SPEED) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(combatData.getMoveSpeed());
        }
        
        // Update armor
        if (this.getAttribute(Attributes.ARMOR) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.ARMOR)).setBaseValue(combatData.getArmor());
        }
        
        // Update armor toughness
        if (this.getAttribute(Attributes.ARMOR_TOUGHNESS) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.ARMOR_TOUGHNESS)).setBaseValue(combatData.getArmorToughness());
        }
        
        // Update knockback resistance
        if (this.getAttribute(Attributes.KNOCKBACK_RESISTANCE) != null) {
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).setBaseValue(combatData.getKnockbackResistance());
        }
    } // updateAttributesFromCombatData ()

    // -- Abstract Contract Implementations --

    /**
     * Recalculates attributes from {@link #combatData}.
     * Delegates to {@link #updateAttributesFromCombatData()}.
     */
    @Override
    protected void recalculateAttributes() {
        updateAttributesFromCombatData();
    } // recalculateAttributes ()

    /**
     * Monsters don't drop a core item — no-op.
     * Override in concrete monster subclasses if a drop is needed.
     */
    @Override
    protected void handleItemDrop() {
        // Monsters don't drop a core item by default
    } // handleItemDrop ()

    /**
     * Activates combat mode when attacking a target.
     *
     * @param target the entity being attacked
     */
    @Override
    protected void handleAttackTarget(Entity target) {
        handleActivateCombatMode();
    } // handleAttackTarget ()

    /**
     * Fires ON_ATTACK emanation rules when this entity successfully strikes a target.
     * <p>
     * <b>Wire point:</b> Delegates to {@link EmanationFeature} after Minecraft's base
     * attack logic, ensuring the attack actually landed before emanations fire.
     */
    @Override
    public boolean doHurtTarget(Entity target) {
        boolean result = super.doHurtTarget(target);
        if (result && !level().isClientSide && target instanceof LivingEntity living
                && nativeEntity != null) {
            nativeEntity.getFeature(EmanationFeature.class).ifPresent(f ->
                f.getRulesFor(EmanationTrigger.ON_ATTACK).forEach(rule ->
                    rule.tryFire(EmanationContext.onAttack(this, living), emanationState)));
        }
        return result;
    } // doHurtTarget ()

    /**
     * Fires ON_HURT emanation rules when this entity takes damage.
     * <p>
     * <b>Wire point:</b> Delegates to {@link EmanationFeature} after Minecraft's base
     * hurt logic, ensuring the damage actually applied before emanations fire.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);
        if (result && !level().isClientSide && nativeEntity != null) {
            LivingEntity attacker = source.getEntity() instanceof LivingEntity l ? l : null;
            nativeEntity.getFeature(EmanationFeature.class).ifPresent(f ->
                f.getRulesFor(EmanationTrigger.ON_HURT).forEach(rule ->
                    rule.tryFire(EmanationContext.onHurt(this, attacker), emanationState)));
        }
        return result;
    } // hurt ()

    /**
     * Applies standard damage — no protection reduction for monsters.
     *
     * @param source damage source
     * @param amount raw damage amount
     * @return always true (damage is applied)
     */
    @Override
    protected boolean handleDamage(DamageSource source, float amount) {
        handleActivateCombatMode();
        return true;
    } // handleDamage ()

    /**
     * Monsters are not registered in the robot registry — no-op.
     */
    @Override
    protected void registerRobot() {
        // Monsters don't use the robot registry
    } // registerRobot ()

    /**
     * Monsters are not registered in the robot registry — no-op.
     */
    @Override
    protected void ensureRegistered() {
        // Monsters don't use the robot registry
    } // ensureRegistered ()

    /**
     * Monsters are not registered in the robot registry — no-op.
     */
    @Override
    protected void unregisterRobot() {
        // Monsters don't use the robot registry
    } // unregisterRobot ()

    // -- Monster-Specific Interactions --

    @Override
    protected InteractionResult handleSpecificInteractions(Player player, InteractionHand hand, ItemStack stack) {
        // Handle belly progression
        if (handleBellyProgression(stack, player)) {
            return InteractionResult.SUCCESS;
        }
        
        // Handle preference interactions
        if (handlePreferenceInteractions(player, hand, stack) != InteractionResult.PASS) {
            return InteractionResult.SUCCESS;
        }
        
        // Handle state interactions
        if (handleStateInteractions(player, hand, stack) != InteractionResult.PASS) {
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    } // handleSpecificInteractions ()

    /**
     * Handles preference-related interactions.
     * <p>
     * <b>Preference Items:</b> Buttons for notifications, note blocks for sounds,
     * hoes for planting preferences.
     *
     * @param player interacting player
     * @param hand interaction hand
     * @param stack item stack in hand
     * @return interaction result
     */
    protected InteractionResult handlePreferenceInteractions(Player player, InteractionHand hand, ItemStack stack) {
        if (!isOwnedBy(player)) return InteractionResult.PASS;
        
        // Button toggles notifications
        if (stack.is(Items.OAK_BUTTON)) {
            if (!this.level().isClientSide) {
                setNotificationEnabled(!isNotificationEnabled());
            }
            return InteractionResult.SUCCESS;
        }
        
        // Note block toggles sounds
        if (stack.is(Items.NOTE_BLOCK)) {
            if (!this.level().isClientSide) {
                setSoundEnabled(!isSoundEnabled());
            }
            return InteractionResult.SUCCESS;
        }
        
        // Wooden hoe toggles planting (if monster can plant)
        if (canPlant && stack.is(Items.WOODEN_HOE)) {
            if (!this.level().isClientSide) {
                setPlantingEnabled(!isPlantingEnabled());
            }
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    } // handlePreferenceInteractions ()

    /**
     * Handles state-related interactions.
     * <p>
     * <b>State Control:</b> Items that don't have specific functions can be used
     * to toggle between REST and MOVE states.
     *
     * @param player interacting player
     * @param hand interaction hand
     * @param stack item stack in hand
     * @return interaction result
     */
    protected InteractionResult handleStateInteractions(Player player, InteractionHand hand, ItemStack stack) {
        if (!isOwnedBy(player)) return InteractionResult.PASS;
        
        // Check if item can be used for state interaction
        if (canInteractForState(stack)) {
            if (!this.level().isClientSide) {
                // Toggle between REST and MOVE states
                if (getCurrentState() == EntityState.Standby) {
                    setCurrentState(EntityState.Follow);
                } else {
                    setCurrentState(EntityState.Standby);
                }
            }
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    } // handleStateInteractions ()

    /**
     * Checks if item can be used for state interactions.
     * <p>
     * <b>Exclusion Logic:</b> Items with specific functions (belly progression,
     * preferences) should not trigger state changes.
     *
     * @param stack item stack to check
     * @return true if item can trigger state changes
     */
    protected boolean canInteractForState(ItemStack stack) {
        // Exclude items with specific functions
        return !stack.is(Items.FEATHER) && !stack.is(Items.APPLE) && 
               !stack.is(Items.OAK_BUTTON) && !stack.is(Items.NOTE_BLOCK) && 
               !stack.is(Items.WOODEN_HOE) && !stack.is(Items.COOKIE) &&
               !stack.is(Items.HONEYCOMB) && !stack.is(Items.HONEY_BOTTLE) &&
               !stack.is(Items.BOOK) && !stack.is(Items.WRITABLE_BOOK);
    } // canInteractForState ()

    // -- Sound System Override --


    /**
     * Returns the step sound from {@link SoundFeature}, variant-aware.
     * <p>
     * Uses {@code getModelVariant()} as the variant key so size variants (e.g.
     * Gourdragora big) can each have their own distinct step sound.
     * Falls back to the block surface sound (Minecraft default) if not configured.
     */
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) { // TODO: FIX THE STOMP SOUND
        if (nativeEntity == null) {
            super.playStepSound(pos, state);
            return;
        }

        nativeEntity.getFeature(SoundFeature.class)
                .map(f -> f.getSound(SoundFeature.SoundType.STEP, getModelVariant()))
                .ifPresentOrElse(
                        sound -> playSound(sound, 0.15f, 1.0f), () -> super.playStepSound(pos, state)
                );
    } // getStepSound ()

    /**
     * Returns the ambient sound from {@link SoundFeature}, variant-aware.
     * <p>
     * Uses {@code getModelVariant()} as the variant key so Gourdragora's mini/default/mega
     * sizes each resolve their own ambient sound pool. Respects the {@code SOUND_ENABLED}
     * player preference — when disabled, no ambient sound plays.
     */
    @Override
    protected SoundEvent getAmbientSound() {
        if (!isSoundEnabled()) return null;
        if (nativeEntity == null) return null;
        return nativeEntity.getFeature(SoundFeature.class)
                .map(f -> f.getSound(SoundFeature.SoundType.AMBIENT, getModelVariant()))
                .orElse(null);
    } // getAmbientSound ()

    /**
     * Returns the hurt sound from {@link SoundFeature}.
     * <p>
     * Hurt/death sounds are intentionally NOT gated by {@code SOUND_ENABLED} —
     * combat feedback is always audible regardless of the ambient sound preference.
     */
    @Override
    protected SoundEvent getHurtSound(net.minecraft.world.damagesource.DamageSource source) {
        if (nativeEntity == null) return super.getHurtSound(source);
        return nativeEntity.getFeature(SoundFeature.class)
                .map(f -> f.getSound(SoundFeature.SoundType.HURT))
                .orElseGet(() -> super.getHurtSound(source));
    } // getHurtSound ()

    /**
     * Returns the death sound from {@link SoundFeature}.
     */
    @Override
    protected SoundEvent getDeathSound() {
        if (nativeEntity == null) return super.getDeathSound();
        return nativeEntity.getFeature(SoundFeature.class)
                .map(f -> f.getSound(SoundFeature.SoundType.DEATH))
                .orElseGet(super::getDeathSound);
    } // getDeathSound ()

    // -- NBT Serialization --

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        
        // Monster states
        nbt.putInt("BellyLevel", getBellyLevel());
        
        // Monster preferences
        nbt.putBoolean("PlantingEnabled", isPlantingEnabled());
        nbt.putBoolean("SoundEnabled", isSoundEnabled());

        // Note: combat stats (health, speed, damage, etc.) are intentionally NOT persisted.
        // They are always re-sourced from nativeEntity.getData() on load, so code changes
        // take effect immediately on existing entities without a /kill + respawn cycle.
        
        // Behavior timers and flags (server-only data)
        nbt.putInt("WaryTimer", waryTimer);
        nbt.putInt("AutoHealTimer", autoHealTimer);
        nbt.putBoolean("CombatMode", combatMode);
        nbt.putBoolean("AutoHeal", autoHeal);
        nbt.putBoolean("CanPlant", canPlant);
        nbt.putBoolean("HasEffects", hasEffects);

        // Emanation state (threshold cooldown)
        CompoundTag emanationTag = new CompoundTag();
        emanationState.save(emanationTag);
        if (!emanationTag.isEmpty()) nbt.put("EmanationState", emanationTag);
    } // addAdditionalSaveData ()

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        
        // Monster states — BellyLevel int (new), with migration from old HasBelly boolean
        if (nbt.contains("BellyLevel")) {
            setBellyLevel(nbt.getInt("BellyLevel"));
        } else if (nbt.contains("HasBelly")) {
            // Migration: old boolean saves — true → TUMMY (now level 3), false → 0 (no belly)
            setBellyLevel(nbt.getBoolean("HasBelly") ? BellyLevel.TUMMY.getLevel() : 0);
        }
        
        // Monster preferences
        if (nbt.contains("PlantingEnabled")) {
            setPlantingEnabled(nbt.getBoolean("PlantingEnabled"));
        }
        if (nbt.contains("SoundEnabled")) {
            setSoundEnabled(nbt.getBoolean("SoundEnabled"));
        }
        
        // Combat data — always re-sync from nativeEntity so that any stat changes
        // made in code are picked up immediately when existing entities load.
        // We do NOT read combat stats back from NBT — nativeEntity is the sole
        // authoritative source for base stats. Persisting them was the original
        // "fast on first spawn, normal after reload" bug; loading them back re-introduces it.
        if (nativeEntity != null) {
            CombatData src = nativeEntity.getData();
            combatData.setMaxHealth(src.getMaxHealth());
            combatData.setAttackDamage(src.getAttackDamage());
            combatData.setAttackSpeed(src.getAttackSpeed());
            combatData.setArmor(src.getArmor());
            combatData.setArmorToughness(src.getArmorToughness());
            combatData.setKnockbackResistance(src.getKnockbackResistance());
            combatData.setMoveSpeed(src.getMoveSpeed());
            updateAttributesFromCombatData();
        }
        
        // Behavior timers and flags
        if (nbt.contains("WaryTimer")) {
            waryTimer = nbt.getInt("WaryTimer");
        }
        if (nbt.contains("AutoHealTimer")) {
            autoHealTimer = nbt.getInt("AutoHealTimer");
        }
        if (nbt.contains("CombatMode")) {
            combatMode = nbt.getBoolean("CombatMode");
        }
        if (nbt.contains("AutoHeal")) {
            autoHeal = nbt.getBoolean("AutoHeal");
        }
        if (nbt.contains("CanPlant")) {
            canPlant = nbt.getBoolean("CanPlant");
        }
        if (nbt.contains("HasEffects")) {
            hasEffects = nbt.getBoolean("HasEffects");
        }

        // Emanation state (threshold cooldown)
        if (nbt.contains("EmanationState")) emanationState.load(nbt.getCompound("EmanationState"));
    } // readAdditionalSaveData ()

    // -- Child Creation --

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob otherParent) {
        // Monsters don't breed naturally
        return null;
    } // getBreedOffspring ()

    // -- Monster State Enum --

    /**
     * <p>Enumeration of monster behavioral states.<p>
     * <p>
     * <b>State Management:</b> Each state corresponds to different AI behaviors
     * and animation patterns. States affect how monsters respond to player
     * commands and environmental stimuli.
     */
    public enum MonsterState {
        REST(0, "rest"),
        MOVE(1, "move"),
        COMBAT(2, "combat"),
        IDLE(3, "idle");

        private final int id;
        private final String key;

        MonsterState(int id, String key) {
            this.id = id;
            this.key = key;
        }

        public int getId() {
            return id;
        }

        public String getKey() {
            return key;
        }

        /**
         * Returns monster state by ID with fallback.
         *
         * @param id state ID
         * @return monster state, defaults to REST if invalid
         */
        public static MonsterState byId(int id) {
            for (MonsterState state : values()) {
                if (state.id == id) {
                    return state;
                }
            }
            return REST;
        }

        /**
         * Returns monster state by key with fallback.
         *
         * @param key state key
         * @return monster state, defaults to REST if invalid
         */
        public static MonsterState byKey(String key) {
            for (MonsterState state : values()) {
                if (state.key.equals(key)) {
                    return state;
                }
            }
            return REST;
        }
    } // Enum: MonsterState

} // Class: MonsterEntity