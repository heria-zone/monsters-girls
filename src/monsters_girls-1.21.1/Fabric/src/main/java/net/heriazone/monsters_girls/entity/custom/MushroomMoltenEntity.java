package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

/**
 * <p>Molten Gal entity — a Mushroom family variant that can cook food on her head
 * like a campfire, accepting up to 4 raw food items simultaneously.</p>
 * <p>
 * <b>Architecture:</b> Extends {@link MushroomEntity} to inherit all base mushroom
 * behaviour. The campfire cooking mechanic is specific to this subclass — no HZLib
 * feature is introduced because only one entity uses it (single-consumer rule).
 * <p>
 * <b>Cook slots:</b> Four {@link ItemStack} synced fields backed by
 * {@link EntityDataSerializers#ITEM_STACK}. Cook timers are server-side only
 * (not synced) — clients don't need them; only the item stacks are displayed.
 * <p>
 * <b>Recipe resolution:</b> Uses {@code RecipeType.CAMPFIRE_COOKING} — the same
 * recipe type as vanilla campfires, so all campfire cooking recipes work without
 * any custom recipe type.
 * <p>
 * <b>Interaction:</b>
 * <ul>
 *   <li>Right-click with cookable food → place in first empty slot (item consumed)</li>
 *   <li>Right-click with empty hand → extract first finished cooked item, or no-op</li>
 * </ul>
 * <p>
 * <b>Loader scope:</b> Lives in the Fabric module because it references
 * {@link net.minecraft.world.item.crafting.RecipeManager} and
 * {@code RecipeType} which are safely accessible from Fabric.
 */
public class MushroomMoltenEntity extends MushroomEntity {

    // -- Cook slot count --

    /** Number of simultaneous cook slots — mirrors the vanilla campfire. */
    public static final int COOK_SLOTS = 4;

    // -- Synced entity data (item stacks — visible to client for rendering) --

    private static final EntityDataAccessor<ItemStack> COOK_SLOT_0 =
            SynchedEntityData.defineId(MushroomMoltenEntity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<ItemStack> COOK_SLOT_1 =
            SynchedEntityData.defineId(MushroomMoltenEntity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<ItemStack> COOK_SLOT_2 =
            SynchedEntityData.defineId(MushroomMoltenEntity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<ItemStack> COOK_SLOT_3 =
            SynchedEntityData.defineId(MushroomMoltenEntity.class, EntityDataSerializers.ITEM_STACK);

    @SuppressWarnings("unchecked")
    private static final EntityDataAccessor<ItemStack>[] COOK_SLOTS_DATA =
            new EntityDataAccessor[]{ COOK_SLOT_0, COOK_SLOT_1, COOK_SLOT_2, COOK_SLOT_3 };

    // -- Server-side cook timers (not synced — client doesn't need them) --

    private final int[] cookTimers   = new int[COOK_SLOTS];
    private final int[] cookDuration = new int[COOK_SLOTS]; // recipe cookingTime for each slot

    // -- Constructor --

    public MushroomMoltenEntity(EntityType<? extends MushroomMoltenEntity> type, Level level,
                                MonstersFamily<? extends MonstersFamily<?>> family) {
        super(type, level, family);
    } // Constructor ()

    // -- SynchedEntityData --

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        for (EntityDataAccessor<ItemStack> slot : COOK_SLOTS_DATA) {
            builder.define(slot, ItemStack.EMPTY);
        }
    } // defineSynchedData ()

    // -- Cook Slot API --

    /** Returns the item currently in cook slot {@code index} (0–3). */
    public ItemStack getCookSlot(int index) {
        if (index < 0 || index >= COOK_SLOTS) return ItemStack.EMPTY;
        try { return entityData.get(COOK_SLOTS_DATA[index]); }
        catch (Exception e) { return ItemStack.EMPTY; }
    } // getCookSlot ()

    private void setCookSlot(int index, ItemStack stack) {
        if (index < 0 || index >= COOK_SLOTS) return;
        entityData.set(COOK_SLOTS_DATA[index], stack != null ? stack : ItemStack.EMPTY);
    } // setCookSlot ()

    private int firstEmptySlot() {
        for (int i = 0; i < COOK_SLOTS; i++) {
            if (getCookSlot(i).isEmpty()) return i;
        }
        return -1;
    } // firstEmptySlot ()

    /** Returns the index of the first fully-cooked slot, or -1 if none. */
    private int firstDoneSlot() {
        for (int i = 0; i < COOK_SLOTS; i++) {
            if (!getCookSlot(i).isEmpty() && cookDuration[i] > 0
                    && cookTimers[i] >= cookDuration[i]) return i;
        }
        return -1;
    } // firstDoneSlot ()

    // -- aiStep: tick cook timers, emit smoke, drop cooked results --

    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide) return;

        for (int i = 0; i < COOK_SLOTS; i++) {
            ItemStack item = getCookSlot(i);
            if (item.isEmpty()) continue;

            // Emit smoke particles above head while cooking (server-level cast)
            if (level() instanceof ServerLevel serverLevel && cookTimers[i] < cookDuration[i]) {
                double px = getX() + (random.nextDouble() - 0.5) * 0.4;
                double py = getY() + getBbHeight() + 0.5 + i * 0.15;
                double pz = getZ() + (random.nextDouble() - 0.5) * 0.4;
                serverLevel.sendParticles(ParticleTypes.SMOKE, px, py, pz, 1, 0, 0.05, 0, 0.01);
            }

            cookTimers[i]++;

            if (cookDuration[i] > 0 && cookTimers[i] >= cookDuration[i]) {
                // Cooking complete — find the cooked result and drop it
                Optional<ItemStack> result = findCookResult(item);
                setCookSlot(i, ItemStack.EMPTY);
                cookTimers[i]   = 0;
                cookDuration[i] = 0;
                result.ifPresent(cooked -> spawnAtLocation(cooked));
            }
        }
    } // aiStep ()

    // -- Interaction: place food / extract cooked item --

    @Override
    protected InteractionResult handleSpecificInteractions(Player player, InteractionHand hand,
                                                           ItemStack stack) {
        if (level().isClientSide) return InteractionResult.PASS;

        // Owner-only
        if (!isOwnedBy(player)) return super.handleSpecificInteractions(player, hand, stack);

        // Empty hand → extract first done item
        if (stack.isEmpty()) {
            int done = firstDoneSlot();
            if (done >= 0) {
                ItemStack cooked = findCookResult(getCookSlot(done))
                        .orElse(getCookSlot(done).copy());
                setCookSlot(done, ItemStack.EMPTY);
                cookTimers[done]   = 0;
                cookDuration[done] = 0;
                player.getInventory().add(cooked);
                return InteractionResult.SUCCESS;
            }
            return super.handleSpecificInteractions(player, hand, stack);
        }

        // Held item → place in first empty slot if it is a campfire cooking ingredient
        int empty = firstEmptySlot();
        if (empty >= 0) {
            Optional<Integer> duration = findCookDuration(stack);
            if (duration.isPresent()) {
                setCookSlot(empty, stack.copyWithCount(1));
                cookTimers[empty]   = 0;
                cookDuration[empty] = duration.get();
                if (!player.getAbilities().instabuild) stack.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }

        return super.handleSpecificInteractions(player, hand, stack);
    } // handleSpecificInteractions ()

    // -- Recipe helpers --

    /**
     * Finds the cooked result for the given input in {@code RecipeType.CAMPFIRE_COOKING}.
     * Returns empty if the item has no campfire cooking recipe.
     */
    private Optional<ItemStack> findCookResult(ItemStack input) {
        if (input.isEmpty()) return Optional.empty();
        List<RecipeHolder<CampfireCookingRecipe>> recipes =
                level().getRecipeManager().getAllRecipesFor(RecipeType.CAMPFIRE_COOKING);
        for (RecipeHolder<CampfireCookingRecipe> holder : recipes) {
            if (holder.value().getIngredients().get(0).test(input)) {
                return Optional.of(holder.value().getResultItem(level().registryAccess()).copy());
            }
        }
        return Optional.empty();
    } // findCookResult ()

    /**
     * Returns the cook duration in ticks for the given input, or empty if not cookable.
     */
    private Optional<Integer> findCookDuration(ItemStack input) {
        if (input.isEmpty()) return Optional.empty();
        List<RecipeHolder<CampfireCookingRecipe>> recipes =
                level().getRecipeManager().getAllRecipesFor(RecipeType.CAMPFIRE_COOKING);
        for (RecipeHolder<CampfireCookingRecipe> holder : recipes) {
            if (holder.value().getIngredients().get(0).test(input)) {
                return Optional.of(holder.value().getCookingTime());
            }
        }
        return Optional.empty();
    } // findCookDuration ()

    // -- NBT --

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);

        ListTag slotList = new ListTag();
        for (int i = 0; i < COOK_SLOTS; i++) {
            CompoundTag slotTag = new CompoundTag();
            slotTag.putInt("Slot",     i);
            slotTag.putInt("Timer",    cookTimers[i]);
            slotTag.putInt("Duration", cookDuration[i]);
            if (!getCookSlot(i).isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                getCookSlot(i).save(level().registryAccess(), itemTag);
                slotTag.put("Item", itemTag);
            }
            slotList.add(slotTag);
        }
        nbt.put("CookSlots", slotList);
    } // addAdditionalSaveData ()

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);

        if (nbt.contains("CookSlots", Tag.TAG_LIST)) {
            ListTag slotList = nbt.getList("CookSlots", Tag.TAG_COMPOUND);
            for (int j = 0; j < slotList.size(); j++) {
                CompoundTag slotTag = slotList.getCompound(j);
                int i = slotTag.getInt("Slot");
                if (i < 0 || i >= COOK_SLOTS) continue;
                cookTimers[i]   = slotTag.getInt("Timer");
                cookDuration[i] = slotTag.getInt("Duration");
                if (slotTag.contains("Item")) {
                    ItemStack loaded = ItemStack.parseOptional(
                            level().registryAccess(), slotTag.getCompound("Item"));
                    setCookSlot(i, loaded);
                }
            }
        }
    } // readAdditionalSaveData ()

} // Class: MushroomMoltenEntity
