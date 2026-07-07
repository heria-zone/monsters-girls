package net.heriazone.monsters_girls.item;

import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;

/**
 * <p>Registers one {@link ArmorMaterial} per mushroom/fungus hat family.<p>
 * <p>
 * <b>Architecture:</b> In 1.21.1, {@code ArmorMaterial} is a record registered via
 * {@link Registry#registerForHolder} into {@link BuiltInRegistries#ARMOR_MATERIAL}.
 * The returned {@link Holder} is what {@link ArmorItem} consumes — this class holds those
 * holders as {@code public static} fields for reference from {@code MonstersItems}.
 * <p>
 * <b>Shared stats:</b> All hats are cosmetic head-slot items — identical stats across all 12.
 * Defense 2 (head slot only), enchantability 28 (leather-tier, generous for enchanting),
 * elytra equip sound (soft, thematic). No toughness or knockback resistance.
 * <p>
 * <b>Repair ingredients:</b> Each material uses the closest available vanilla item as a
 * placeholder. Replace with the corresponding {@code MonstersItems} block item once the
 * creative tab and recipe system is live (Phase F).
 * <p>
 * <b>Initialization:</b> Call {@link #register()} from {@code Monsters.init()} after
 * {@code MonstersBlocks.register()} and <em>before</em> {@code MonstersItems.register()} —
 * hat item constructors consume these holders.
 */
public class MonstersArmorMaterials {

    // -- Shared stats --

    private static final int DEFENSE_HEAD  = 2;
    private static final int ENCHANTABILITY = 28;
    private static final float TOUGHNESS   = 0.0f;
    private static final float KNOCKBACK   = 0.0f;

    // -- Material holders (one per hat family) --

    public static Holder<ArmorMaterial> BROWN_MUSHROOM;
    public static Holder<ArmorMaterial> CRIMSON_FUNGUS;
    public static Holder<ArmorMaterial> CRIMSON_RARE_FUNGUS;
    public static Holder<ArmorMaterial> ENDER_PUFFBALL;
    public static Holder<ArmorMaterial> FLY_RED_AGARIC;
    public static Holder<ArmorMaterial> FLY_YELLOW_AGARIC;
    public static Holder<ArmorMaterial> INFERNAL_MUSHROOM;
    public static Holder<ArmorMaterial> INK_CAP_MUSHROOM;
    public static Holder<ArmorMaterial> MOLTEN_FUNGUS;
    public static Holder<ArmorMaterial> SOUL_WANDERER_FUNGUS;
    public static Holder<ArmorMaterial> WARPED_FUNGUS;
    public static Holder<ArmorMaterial> WARPED_RARE_FUNGUS;

    // -- Registration --

    public static void register() {
        BROWN_MUSHROOM       = make(MonstersConstant.HAT_MUSHROOM_BROWN,          Ingredient.of(Items.BROWN_MUSHROOM));
        CRIMSON_FUNGUS       = make(MonstersConstant.HAT_MUSHROOM_CRIMSON,         Ingredient.of(Items.CRIMSON_FUNGUS));
        CRIMSON_RARE_FUNGUS  = make(MonstersConstant.HAT_MUSHROOM_CRIMSON_RARE,    Ingredient.of(Items.CRIMSON_FUNGUS));
        // ENDER_PUFFBALL: no direct vanilla item — chorus fruit is thematically closest
        ENDER_PUFFBALL       = make(MonstersConstant.HAT_MUSHROOM_ENDER_PUFFBALL,  Ingredient.of(Items.CHORUS_FRUIT));
        FLY_RED_AGARIC       = make(MonstersConstant.HAT_MUSHROOM_FLY_RED_AGARIC,  Ingredient.of(Items.RED_MUSHROOM));
        // FLY_YELLOW_AGARIC: no exact vanilla item — brown mushroom is closest available
        FLY_YELLOW_AGARIC    = make(MonstersConstant.HAT_MUSHROOM_FLY_YELLOW_AGARIC, Ingredient.of(Items.BROWN_MUSHROOM));
        // INFERNAL: magma cream is the closest "infernal" material before huge block item exists
        INFERNAL_MUSHROOM    = make(MonstersConstant.HAT_MUSHROOM_INFERNAL,        Ingredient.of(Items.MAGMA_CREAM));
        INK_CAP_MUSHROOM     = make(MonstersConstant.HAT_MUSHROOM_INK_CAP,         Ingredient.of(Items.INK_SAC));
        MOLTEN_FUNGUS        = make(MonstersConstant.HAT_MUSHROOM_MOLTEN,          Ingredient.of(Items.MAGMA_CREAM));
        SOUL_WANDERER_FUNGUS = make(MonstersConstant.HAT_MUSHROOM_SOUL_WANDERER,   Ingredient.of(Items.SOUL_SAND));
        WARPED_FUNGUS        = make(MonstersConstant.HAT_MUSHROOM_WARPED,          Ingredient.of(Items.WARPED_FUNGUS));
        WARPED_RARE_FUNGUS   = make(MonstersConstant.HAT_MUSHROOM_WARPED_RARE,     Ingredient.of(Items.WARPED_FUNGUS));
    } // register ()

    // -- Private helpers --

    /**
     * Builds and registers one armor material.
     * <p>
     * Layer ID matches the hat's registry key — the engine resolves the worn texture from
     * {@code assets/monsters_girls/textures/models/armor/{key}_layer_1.png}.
     *
     * @param key             registry path, doubles as armor layer texture ID
     * @param repairIngredient item accepted by anvils to repair the hat
     * @return registered {@link Holder} consumed by {@link ArmorItem}
     */
    private static Holder<ArmorMaterial> make(String key, Ingredient repairIngredient) {
        ArmorMaterial material = new ArmorMaterial(
                Map.of(ArmorItem.Type.HELMET, DEFENSE_HEAD),
                ENCHANTABILITY,
                SoundEvents.ARMOR_EQUIP_ELYTRA,
                () -> repairIngredient,
                List.of(new ArmorMaterial.Layer(MonstersIdentifier.getId(key))),
                TOUGHNESS,
                KNOCKBACK
        );
        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                MonstersIdentifier.getId(key),
                material
        );
    } // make ()

} // Class: MonstersArmorMaterials
