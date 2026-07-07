package net.heriazone.monsters_girls.source;

import net.heriazone.hzlib.api.items.InternalItems;
import net.heriazone.monsters_girls.Monsters;
import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.heriazone.monsters_girls.item.GenesisPowderItem;
import net.heriazone.monsters_girls.item.MonstersArmorMaterials;
import net.heriazone.monsters_girls.item.MonstersStewItem;
import net.heriazone.monsters_girls.item.MushroomHatItem;
import net.heriazone.monsters_girls.item.MushroomHatItem.HatShape;
import net.heriazone.monsters_girls.item.TooltipItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;

import java.util.ArrayList;
import java.util.List;

public class MonstersItems extends InternalItems {

    // -- Variables --

    // MISCELLANEOUS
    public static final Item POWDER_GENESIS = register(MonstersIdentifier.getId(MonstersConstant.POWDER_GENESIS), new GenesisPowderItem(new Item.Properties().rarity(Rarity.RARE)));

    // FOOD
    public static final Item SPECTRAL_CAKE = register(MonstersIdentifier.getId(MonstersConstant.SPECTRAL_CAKE), new TooltipItem(new Item.Properties().food(MonstersFood.SPECTRAL_CAKE).fireResistant().rarity(Rarity.UNCOMMON), new ArrayList<>(List.of("tooltip.monsters_girls.spectral_cake"))));
    public static final Item CANDIES = register(MonstersIdentifier.getId(MonstersConstant.CANDIES), new TooltipItem(new Item.Properties().food(MonstersFood.CANDIES).rarity(Rarity.COMMON), new ArrayList<>(List.of("tooltip.monsters_girls.candies"))));

    // STEWS — given by mushroom gals via ExchangeFeature (bowl → stew).
    // Each stew applies its custom effect on consumption and returns an empty bowl.
    // Registration lives in Fabric (needs Registry.register); effect logic lives in Common (MonstersStewItem).

    /** Infernal / Crimson / Warped → Fire Resistance 3 s (60 ticks). */
    public static final Item STEW_NETHER = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_NETHER),
            new MonstersStewItem(net.minecraft.world.effect.MobEffects.FIRE_RESISTANCE, 60,
                    new Item.Properties().food(MonstersFood.STEW_NETHER).fireResistant()
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_nether"))));

    /** Inkcap → Poisonous effect 30 s (600 ticks). */
    public static final Item STEW_POISON = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_POISON),
            new MonstersStewItem(MonstersEffects.POISONOUS, 600,
                    new Item.Properties().food(MonstersFood.STEW_POISON)
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_poison"))));

    /** Molten → Blazing effect 30 s (600 ticks). */
    public static final Item STEW_MOLTEN = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_MOLTEN),
            new MonstersStewItem(MonstersEffects.BLAZING, 600,
                    new Item.Properties().food(MonstersFood.STEW_MOLTEN).fireResistant()
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_molten"))));

    /** Puffball → Puffy effect 30 s (600 ticks). */
    public static final Item STEW_PUFFBALL = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_PUFFBALL),
            new MonstersStewItem(MonstersEffects.PUFFY, 600,
                    new Item.Properties().food(MonstersFood.STEW_PUFFBALL)
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_puffball"))));

    /** Snowball → Chilly effect 30 s (600 ticks). */
    public static final Item STEW_SNOWBALL = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_SNOWBALL),
            new MonstersStewItem(MonstersEffects.CHILLY, 600,
                    new Item.Properties().food(MonstersFood.STEW_SNOWBALL)
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_snowball"))));

    /** Soul Wanderer → Soul Wanderer's Touch 30 s (600 ticks). */
    public static final Item STEW_SOUL_WANDERER = register(
            MonstersIdentifier.getId(MonstersConstant.STEW_SOUL_WANDERER),
            new MonstersStewItem(MonstersEffects.SOUL_WANDERERS_TOUCH, 600,
                    new Item.Properties().food(MonstersFood.STEW_SOUL_WANDERER)
                            .rarity(Rarity.UNCOMMON).craftRemainder(Items.BOWL), new ArrayList<>(List.of("tooltip.monsters_girls.stew_soul_wanderer"))));

    // BLOCK ITEMS — custom mushroom/fungus plant blocks
    // Registered in Fabric because BlockItem needs the Fabric item registry infrastructure.
    // Block instances live in Common (MonstersBlocks).

    /** Inkcap Mushroom block item. */
    public static final Item INKCAP_MUSHROOM = register(
            MonstersIdentifier.getId(MonstersConstant.INKCAP_MUSHROOM),
            new BlockItem(MonstersBlocks.INKCAP_MUSHROOM, new Item.Properties()));

    /** Molten Fungus block item. */
    public static final Item MOLTEN_FUNGUS = register(
            MonstersIdentifier.getId(MonstersConstant.MOLTEN_FUNGUS),
            new BlockItem(MonstersBlocks.MOLTEN_FUNGUS, new Item.Properties().fireResistant()));

    /** Ender Mushroom block item. */
    public static final Item ENDER_MUSHROOM = register(
            MonstersIdentifier.getId(MonstersConstant.ENDER_MUSHROOM),
            new BlockItem(MonstersBlocks.ENDER_MUSHROOM, new Item.Properties()));

    /** Snowball Mushroom block item. */
    public static final Item SNOWBALL_MUSHROOM = register(
            MonstersIdentifier.getId(MonstersConstant.SNOWBALL_MUSHROOM),
            new BlockItem(MonstersBlocks.SNOWBALL_MUSHROOM, new Item.Properties()));

    /** Soul Wanderer Fungus block item. */
    public static final Item SOUL_WANDERER_FUNGUS = register(
            MonstersIdentifier.getId(MonstersConstant.SOUL_WANDERER_FUNGUS),
            new BlockItem(MonstersBlocks.SOUL_WANDERER_FUNGUS, new Item.Properties()));

    // SPAWNS
    // BEE
    public static final Item BEE_HONEY_SPAWN = registerItem(MonstersConstant.SPAWN_BEE_HONEY,   MonstersEntities.BEE_HONEY,   64);

    // GLOBBERIE
    public static final Item GLOBBERIE_SPAWN = registerItem(MonstersConstant.SPAWN_GLOBBERIE,          MonstersEntities.GLOBBERIE,          64);

    // GOURDRAGORA — 3 entity variants (ADR_011: collapsed from 9 size-specific spawn items)
    public static final Item GOURDRAGORA_GOLDEN_SPAWN = registerItem(MonstersConstant.SPAWN_GOURDRAGORA_GOLDEN, MonstersEntities.GOURDRAGORA_GOLDEN, 64);
    public static final Item GOURDRAGORA_LUMINA_SPAWN = registerItem(MonstersConstant.SPAWN_GOURDRAGORA_LUMINA, MonstersEntities.GOURDRAGORA_LUMINA, 64);
    public static final Item GOURDRAGORA_JACKO_SPAWN  = registerItem(MonstersConstant.SPAWN_GOURDRAGORA_JACKO,  MonstersEntities.GOURDRAGORA_JACKO,  64);

    // MAIDEN OF THE SKIES — purple colored spawn egg (no custom texture, uses vanilla template)
    // Shell: 0x6000FF (purple), Spots: 0x120A4A (dark indigo)
    public static final Item MAIDEN_SPAWN = register(
            MonstersIdentifier.getId(MonstersConstant.SPAWN_MAIDEN),
            new SpawnEggItem(MonstersEntities.MAIDEN, 0x6000FF, 0x120A4A, new Item.Properties().stacksTo(64)));

    // SLIME
    public static final Item SLIME_BLUE_SPAWN = registerItem(MonstersConstant.SPAWN_SLIME_BLUE, MonstersEntities.SLIME_BLUE, 64);

    public static final Item MANDRAKE_CHORUS_SPAWN = registerItem(MonstersConstant.SPAWN_MANDRAKE_CHORUS, MonstersEntities.MANDRAKE_CHORUS, 64);
    public static final Item MANDRAKE_FLOWER_SPAWN = registerItem(MonstersConstant.SPAWN_MANDRAKE_FLOWER, MonstersEntities.MANDRAKE_FLOWER, 64);
    public static final Item MANDRAKE_FRUCTUS_SPAWN =  registerItem(MonstersConstant.SPAWN_MANDRAKE_FRUCTUS,  MonstersEntities.MANDRAKE_FRUCTUS, 64);

    public static final Item MUSHROOM_BROWN_SPAWN        = registerItem(MonstersConstant.SPAWN_MUSHROOM_BROWN,         MonstersEntities.MUSHROOM_BROWN,         64);
    public static final Item MUSHROOM_AMANITA_SPAWN      = registerItem(MonstersConstant.SPAWN_MUSHROOM_AMANITA,       MonstersEntities.MUSHROOM_AMANITA,       64);
    public static final Item MUSHROOM_CRIMSON_SPAWN      = registerItem(MonstersConstant.SPAWN_MUSHROOM_CRIMSON,       MonstersEntities.MUSHROOM_CRIMSON,       64);
    public static final Item MUSHROOM_INFERNAL_SPAWN     = registerItem(MonstersConstant.SPAWN_MUSHROOM_INFERNAL,      MonstersEntities.MUSHROOM_INFERNAL,      64);
    public static final Item MUSHROOM_INKCAPS_SPAWN      = registerItem(MonstersConstant.SPAWN_MUSHROOM_INKCAPS,       MonstersEntities.MUSHROOM_INKCAPS,       64);
    public static final Item MUSHROOM_MOLTEN_SPAWN       = registerItem(MonstersConstant.SPAWN_MUSHROOM_MOLTEN,        MonstersEntities.MUSHROOM_MOLTEN,        64);
    public static final Item MUSHROOM_PUFFBALL_SPAWN     = registerItem(MonstersConstant.SPAWN_MUSHROOM_PUFFBALL,      MonstersEntities.MUSHROOM_PUFFBALL,      64);
    public static final Item MUSHROOM_SNOWBALL_SPAWN     = registerItem(MonstersConstant.SPAWN_MUSHROOM_SNOWBALL,      MonstersEntities.MUSHROOM_SNOWBALL,      64);
    public static final Item MUSHROOM_SOUL_WANDERER_SPAWN = registerItem(MonstersConstant.SPAWN_MUSHROOM_SOUL_WANDERER, MonstersEntities.MUSHROOM_SOUL_WANDERER, 64);
    public static final Item MUSHROOM_WARPED_SPAWN       = registerItem(MonstersConstant.SPAWN_MUSHROOM_WARPED,        MonstersEntities.MUSHROOM_WARPED,        64);

    public static final Item SPOOK_CREAM_SPAWN = registerItem(MonstersConstant.SPAWN_SPOOK_CREAM, MonstersEntities.SPOOK_CREAM, 64);
    public static final Item SPOOK_PEACH_SPAWN = registerItem(MonstersConstant.SPAWN_SPOOK_PEACH, MonstersEntities.SPOOK_PEACH, 64);
    public static final Item SPOOK_TEAL_SPAWN =  registerItem(MonstersConstant.SPAWN_SPOOK_TEAL,  MonstersEntities.SPOOK_TEAL, 64);

    public static final Item WISP_BLUE_SPAWN =   registerItem(MonstersConstant.SPAWN_WISP_BLUE,   MonstersEntities.WISP_BLUE, 64);
    public static final Item WISP_GREEN_SPAWN =  registerItem(MonstersConstant.SPAWN_WISP_GREEN,  MonstersEntities.WISP_GREEN, 64);
    public static final Item WISP_YELLOW_SPAWN = registerItem(MonstersConstant.SPAWN_WISP_YELLOW, MonstersEntities.WISP_YELLOW, 64);

    // -- Methods --

    /**
     * Registers robot core item with specified properties.
     * <p>
     * <b>Usage:</b> For crafting materials and robot storage items.
     *
     * @param name the registry name
     * @param rarity the item rarity level
     * @param stack the maximum stack size
     * @return the registered item instance
     */
    private static Item registerItem(String name, Rarity rarity, int stack) {
        return register(MonstersIdentifier.getId(name), new Item(new Item.Properties().rarity(rarity).stacksTo(stack)));
    } // registerItem()

    /**
     * Registers spawn egg item for robot entity.
     * <p>
     * <b>NBT Support:</b> Spawn eggs can store robot customization data (color,
     * level, name) which transfers to spawned entity.
     *
     * @param name the registry name
     * @param mob the entity type
     * @param stack the maximum stack size
     * @return the registered spawn egg instance
     */
    private static Item registerItem(String name, EntityType<? extends Mob> mob, int stack) {
        return register(MonstersIdentifier.getId(name), new SpawnEggItem(mob, 0xFFFFFF, 0xFFFFFF, new Item.Properties().stacksTo(stack)));
    } // registerItem()

    /**
     * Registers items and adds them to creative tabs.
     * <p>
     * <b>Timing:</b> Must be called during mod initialization, after
     * {@code MonstersArmorMaterials.register()} — hat constructors consume
     * armor material holders.
     */
    public static void register() {
        Monsters.LOGGER.info("Registering Items: " + Monsters.MODID);
        registerHatItems();
    } // register()

    /**
     * Registers all 12 mushroom hat items as {@link MushroomHatItem} (GeoItem subclass).
     * <p>
     * <b>Why here:</b> {@link MushroomHatItem} requires GeckoLib which is only on the Fabric
     * classpath. Common's {@code MonstersBlockItems} skips hat registration — these are the
     * sole registrations.
     * <p>
     * Shape → bone mapping: FAT=wide flat, VERY_FAT=extra wide, SKINNY=narrow tall,
     * TALL=medium funnel, VERY_TALL=tall funnel with brim.
     */
    private static void registerHatItems() {
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_BROWN), MushroomHatItem.of(MonstersArmorMaterials.BROWN_MUSHROOM,        HatShape.FAT, "hat_brown_mushroom",              new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_CRIMSON), MushroomHatItem.of(MonstersArmorMaterials.CRIMSON_FUNGUS,        HatShape.TALL, "hat_crimson_fungus",              new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_CRIMSON_RARE), MushroomHatItem.of(MonstersArmorMaterials.CRIMSON_RARE_FUNGUS,   HatShape.TALL, "hat_crimson_rare_fungus",         new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_ENDER_PUFFBALL), MushroomHatItem.of(MonstersArmorMaterials.ENDER_PUFFBALL,        HatShape.VERY_FAT, "hat_ender_puffball_mushroom",     new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_FLY_RED_AGARIC), MushroomHatItem.of(MonstersArmorMaterials.FLY_RED_AGARIC,        HatShape.FAT, "hat_fly_red_agaric_mushroom",    new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_FLY_YELLOW_AGARIC), MushroomHatItem.of(MonstersArmorMaterials.FLY_YELLOW_AGARIC,     HatShape.FAT, "hat_fly_yellow_agaric_mushroom", new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_INFERNAL), MushroomHatItem.of(MonstersArmorMaterials.INFERNAL_MUSHROOM,     HatShape.VERY_TALL, "hat_infernal_mushroom",          new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_INK_CAP), MushroomHatItem.of(MonstersArmorMaterials.INK_CAP_MUSHROOM,      HatShape.SKINNY, "hat_ink_cap_mushroom",           new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_MOLTEN), MushroomHatItem.of(MonstersArmorMaterials.MOLTEN_FUNGUS,         HatShape.VERY_TALL, "hat_molten_fungus",              new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_SOUL_WANDERER), MushroomHatItem.of(MonstersArmorMaterials.SOUL_WANDERER_FUNGUS,  HatShape.VERY_TALL, "hat_soul_wanderer_mushroom",     new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_WARPED), MushroomHatItem.of(MonstersArmorMaterials.WARPED_FUNGUS,         HatShape.TALL, "hat_warped_fungus",              new Item.Properties()));
        register(MonstersIdentifier.getId(MonstersConstant.HAT_MUSHROOM_WARPED_RARE), MushroomHatItem.of(MonstersArmorMaterials.WARPED_RARE_FUNGUS,    HatShape.TALL, "hat_warped_rare_fungus",         new Item.Properties()));
    } // registerHatItems ()

} // Class: MonstersItems