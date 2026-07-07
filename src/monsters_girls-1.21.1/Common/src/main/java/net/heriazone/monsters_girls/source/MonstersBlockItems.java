package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.heriazone.monsters_girls.item.MonstersArmorMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * <p>Registers all new block items and hat items introduced in Sprint 16.<p>
 * <p>
 * <b>Architecture:</b> Mirrors {@link MonstersBlocks} — uses {@link BuiltInRegistries#ITEM}
 * directly, no loader API. Two registration categories:
 * <ul>
 *   <li><b>Block items</b> (65): one {@link BlockItem} per new block in {@link MonstersBlocks}.
 *       Order mirrors block declaration order so the two classes stay easy to diff.</li>
 *   <li><b>Hat items</b> (12): {@link ArmorItem} instances consuming
 *       {@link MonstersArmorMaterials} holders. Head slot only — cosmetic.</li>
 * </ul>
 * <p>
 * <b>Naming:</b> Named {@code MonstersBlockItems} to avoid collision with the Fabric-module
 * {@code MonstersItems} class, which registers stews, spawn eggs, and plant block items
 * via HZLib's {@code InternalItems} at class-load time.
 * <p>
 * <b>Initialization order:</b> Called from {@code Monsters.init()} after
 * {@code MonstersBlocks.register()} and {@code MonstersArmorMaterials.register()}.
 */
public class MonstersBlockItems {

    // -------------------------------------------------------------------------
    // Mandrake flower plant block item
    // -------------------------------------------------------------------------

    /** Block item for the mandrake flower plant — placed by Mandrake Flower entity. */
    public static Item MANDRAKE_FLOWER_PLANT;

    // -------------------------------------------------------------------------
    // Ender Puffball wood set (15 items)
    // -------------------------------------------------------------------------

    public static Item ENDER_PUFFBALL_BLOCK;
    public static Item ENDER_PUFFBALL_STEM;
    public static Item ENDER_PUFFBALL_HYPHAE;
    public static Item ENDER_PUFFBALL_STRIPPED_STEM;
    public static Item ENDER_PUFFBALL_STRIPPED_HYPHAE;
    public static Item ENDER_PUFFBALL_PLANKS;
    public static Item ENDER_PUFFBALL_STAIRS;
    public static Item ENDER_PUFFBALL_SLAB;
    public static Item ENDER_PUFFBALL_FENCE;
    public static Item ENDER_PUFFBALL_FENCE_GATE;
    public static Item ENDER_PUFFBALL_PRESSURE_PLATE;
    public static Item ENDER_PUFFBALL_BUTTON;
    public static Item ENDER_PUFFBALL_DOOR;
    public static Item ENDER_PUFFBALL_TRAPDOOR;
    public static Item SHROOMLIGHT_ENDER;

    // -------------------------------------------------------------------------
    // Molten Fungus wood set (15 items)
    // -------------------------------------------------------------------------

    public static Item MOLTEN_FUNGUS_BLOCK;
    public static Item MOLTEN_FUNGUS_STEM;
    public static Item MOLTEN_FUNGUS_HYPHAE;
    public static Item MOLTEN_FUNGUS_STRIPPED_STEM;
    public static Item MOLTEN_FUNGUS_STRIPPED_HYPHAE;
    public static Item MOLTEN_FUNGUS_PLANKS;
    public static Item MOLTEN_FUNGUS_STAIRS;
    public static Item MOLTEN_FUNGUS_SLAB;
    public static Item MOLTEN_FUNGUS_FENCE;
    public static Item MOLTEN_FUNGUS_FENCE_GATE;
    public static Item MOLTEN_FUNGUS_PRESSURE_PLATE;
    public static Item MOLTEN_FUNGUS_BUTTON;
    public static Item MOLTEN_FUNGUS_DOOR;
    public static Item MOLTEN_FUNGUS_TRAPDOOR;
    public static Item SHROOMLIGHT_MOLTEN;

    // -------------------------------------------------------------------------
    // Soul Wanderer wood set (15 items)
    // -------------------------------------------------------------------------

    public static Item SOUL_WANDERER_BLOCK;
    public static Item SOUL_WANDERER_STEM;
    public static Item SOUL_WANDERER_HYPHAE;
    public static Item SOUL_WANDERER_STRIPPED_STEM;
    public static Item SOUL_WANDERER_STRIPPED_HYPHAE;
    public static Item SOUL_WANDERER_PLANKS;
    public static Item SOUL_WANDERER_STAIRS;
    public static Item SOUL_WANDERER_SLAB;
    public static Item SOUL_WANDERER_FENCE;
    public static Item SOUL_WANDERER_FENCE_GATE;
    public static Item SOUL_WANDERER_PRESSURE_PLATE;
    public static Item SOUL_WANDERER_BUTTON;
    public static Item SOUL_WANDERER_DOOR;
    public static Item SOUL_WANDERER_TRAPDOOR;
    public static Item SHROOMLIGHT_SOUL;

    // -------------------------------------------------------------------------
    // Inkcap mushroom block variants (3 items)
    // -------------------------------------------------------------------------

    public static Item INK_CAP_BLACK_MUSHROOM_BLOCK;
    public static Item INK_CAP_GREY_MUSHROOM_BLOCK;
    public static Item INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK;

    // -------------------------------------------------------------------------
    // Huge decorative mushroom / fungus blocks (12 items)
    // -------------------------------------------------------------------------

    public static Item HUGE_BROWN_MUSHROOM;
    public static Item HUGE_CRIMSON_FUNGUS;
    public static Item HUGE_CRIMSON_RARE_FUNGUS;
    public static Item HUGE_ENDER_PUFFBALL;
    public static Item HUGE_FLY_RED_AGARIC;
    public static Item HUGE_FLY_YELLOW_AGARIC;
    public static Item HUGE_INFERNAL_MUSHROOM;
    public static Item HUGE_INK_CAP_MUSHROOM;
    public static Item HUGE_MOLTEN_FUNGUS;
    public static Item HUGE_SOUL_WANDERER;
    public static Item HUGE_WARPED_FUNGUS;
    public static Item HUGE_WARPED_RARE_FUNGUS;

    // -------------------------------------------------------------------------
    // Decoration block items (5 items)
    // -------------------------------------------------------------------------

    public static Item ENDER_MOSS;
    public static Item GLOW_BERRY_BUSH;
    public static Item JAR;
    public static Item URN_MOLTEN;
    public static Item URN_CRIMSON;

    // -------------------------------------------------------------------------
    // Snowball Mushroom wood set (15 items)
    // -------------------------------------------------------------------------

    public static Item SNOWBALL_LOG;
    public static Item SNOWBALL_WOOD;
    public static Item SNOWBALL_STRIPPED_LOG;
    public static Item SNOWBALL_STRIPPED_WOOD;
    public static Item SNOWBALL_PLANKS;
    public static Item SNOWBALL_STAIRS;
    public static Item SNOWBALL_SLAB;
    public static Item SNOWBALL_FENCE;
    public static Item SNOWBALL_FENCE_GATE;
    public static Item SNOWBALL_PRESSURE_PLATE;
    public static Item SNOWBALL_BUTTON;
    public static Item SNOWBALL_DOOR;
    public static Item SNOWBALL_TRAPDOOR;
    public static Item SNOWBALL_MUSHROOM_BLOCK;
    public static Item SNOWBALL_SHROOMLIGHT;

    // -------------------------------------------------------------------------
    // Ender Willow wood set (15 items)
    // -------------------------------------------------------------------------

    public static Item ENDER_WILLOW_LOG;
    public static Item ENDER_WILLOW_WOOD;
    public static Item ENDER_WILLOW_STRIPPED_LOG;
    public static Item ENDER_WILLOW_STRIPPED_WOOD;
    public static Item ENDER_WILLOW_PLANKS;
    public static Item ENDER_WILLOW_STAIRS;
    public static Item ENDER_WILLOW_SLAB;
    public static Item ENDER_WILLOW_FENCE;
    public static Item ENDER_WILLOW_FENCE_GATE;
    public static Item ENDER_WILLOW_PRESSURE_PLATE;
    public static Item ENDER_WILLOW_BUTTON;
    public static Item ENDER_WILLOW_DOOR;
    public static Item ENDER_WILLOW_TRAPDOOR;
    public static Item ENDER_WILLOW_LEAVES;
    public static Item ENDER_WILLOW_SAPLING;

    // -------------------------------------------------------------------------
    // Hat items (12 items — ArmorItem, head slot only)
    // -------------------------------------------------------------------------

    public static Item HAT_MUSHROOM_BROWN;
    public static Item HAT_MUSHROOM_CRIMSON;
    public static Item HAT_MUSHROOM_CRIMSON_RARE;
    public static Item HAT_MUSHROOM_ENDER_PUFFBALL;
    public static Item HAT_MUSHROOM_FLY_RED_AGARIC;
    public static Item HAT_MUSHROOM_FLY_YELLOW_AGARIC;
    public static Item HAT_MUSHROOM_INFERNAL;
    public static Item HAT_MUSHROOM_INK_CAP;
    public static Item HAT_MUSHROOM_MOLTEN;
    public static Item HAT_MUSHROOM_SOUL_WANDERER;
    public static Item HAT_MUSHROOM_WARPED;
    public static Item HAT_MUSHROOM_WARPED_RARE;

    // -------------------------------------------------------------------------
    // Registration
    // -------------------------------------------------------------------------

    /**
     * Registers all block items and hat items.
     * <p>
     * Called from {@code Monsters.init()} after {@code MonstersBlocks.register()} and
     * {@code MonstersArmorMaterials.register()} — block and material holders must exist first.
     */
    public static void register() {
        registerBlockItems();
        registerHatItems();
    } // register ()

    // -------------------------------------------------------------------------
    // Private — block item registration
    // -------------------------------------------------------------------------

    private static void registerBlockItems() {

        // -- Mandrake flower plant --
        MANDRAKE_FLOWER_PLANT = blockItem(MonstersConstant.MANDRAKE_FLOWER_PLANT, MonstersBlocks.MANDRAKE_FLOWER_PLANT);

        // -- Ender Puffball wood set --
        ENDER_PUFFBALL_BLOCK          = blockItem(MonstersConstant.ENDER_PUFFBALL_BLOCK,          MonstersBlocks.ENDER_PUFFBALL_BLOCK);
        ENDER_PUFFBALL_STEM           = blockItem(MonstersConstant.ENDER_PUFFBALL_STEM,           MonstersBlocks.ENDER_PUFFBALL_STEM);
        ENDER_PUFFBALL_HYPHAE         = blockItem(MonstersConstant.ENDER_PUFFBALL_HYPHAE,         MonstersBlocks.ENDER_PUFFBALL_HYPHAE);
        ENDER_PUFFBALL_STRIPPED_STEM  = blockItem(MonstersConstant.ENDER_PUFFBALL_STRIPPED_STEM,  MonstersBlocks.ENDER_PUFFBALL_STRIPPED_STEM);
        ENDER_PUFFBALL_STRIPPED_HYPHAE = blockItem(MonstersConstant.ENDER_PUFFBALL_STRIPPED_HYPHAE, MonstersBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE);
        ENDER_PUFFBALL_PLANKS         = blockItem(MonstersConstant.ENDER_PUFFBALL_PLANKS,         MonstersBlocks.ENDER_PUFFBALL_PLANKS);
        ENDER_PUFFBALL_STAIRS         = blockItem(MonstersConstant.ENDER_PUFFBALL_STAIRS,         MonstersBlocks.ENDER_PUFFBALL_STAIRS);
        ENDER_PUFFBALL_SLAB           = blockItem(MonstersConstant.ENDER_PUFFBALL_SLAB,           MonstersBlocks.ENDER_PUFFBALL_SLAB);
        ENDER_PUFFBALL_FENCE          = blockItem(MonstersConstant.ENDER_PUFFBALL_FENCE,          MonstersBlocks.ENDER_PUFFBALL_FENCE);
        ENDER_PUFFBALL_FENCE_GATE     = blockItem(MonstersConstant.ENDER_PUFFBALL_FENCE_GATE,     MonstersBlocks.ENDER_PUFFBALL_FENCE_GATE);
        ENDER_PUFFBALL_PRESSURE_PLATE = blockItem(MonstersConstant.ENDER_PUFFBALL_PRESSURE_PLATE, MonstersBlocks.ENDER_PUFFBALL_PRESSURE_PLATE);
        ENDER_PUFFBALL_BUTTON         = blockItem(MonstersConstant.ENDER_PUFFBALL_BUTTON,         MonstersBlocks.ENDER_PUFFBALL_BUTTON);
        ENDER_PUFFBALL_DOOR           = blockItem(MonstersConstant.ENDER_PUFFBALL_DOOR,           MonstersBlocks.ENDER_PUFFBALL_DOOR);
        ENDER_PUFFBALL_TRAPDOOR       = blockItem(MonstersConstant.ENDER_PUFFBALL_TRAPDOOR,       MonstersBlocks.ENDER_PUFFBALL_TRAPDOOR);
        SHROOMLIGHT_ENDER             = blockItem(MonstersConstant.SHROOMLIGHT_ENDER,             MonstersBlocks.SHROOMLIGHT_ENDER);

        // -- Molten Fungus wood set --
        MOLTEN_FUNGUS_BLOCK           = blockItem(MonstersConstant.MOLTEN_FUNGUS_BLOCK,           MonstersBlocks.MOLTEN_FUNGUS_BLOCK);
        MOLTEN_FUNGUS_STEM            = blockItem(MonstersConstant.MOLTEN_FUNGUS_STEM,            MonstersBlocks.MOLTEN_FUNGUS_STEM);
        MOLTEN_FUNGUS_HYPHAE          = blockItem(MonstersConstant.MOLTEN_FUNGUS_HYPHAE,          MonstersBlocks.MOLTEN_FUNGUS_HYPHAE);
        MOLTEN_FUNGUS_STRIPPED_STEM   = blockItem(MonstersConstant.MOLTEN_FUNGUS_STRIPPED_STEM,   MonstersBlocks.MOLTEN_FUNGUS_STRIPPED_STEM);
        MOLTEN_FUNGUS_STRIPPED_HYPHAE = blockItem(MonstersConstant.MOLTEN_FUNGUS_STRIPPED_HYPHAE, MonstersBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
        MOLTEN_FUNGUS_PLANKS          = blockItem(MonstersConstant.MOLTEN_FUNGUS_PLANKS,          MonstersBlocks.MOLTEN_FUNGUS_PLANKS);
        MOLTEN_FUNGUS_STAIRS          = blockItem(MonstersConstant.MOLTEN_FUNGUS_STAIRS,          MonstersBlocks.MOLTEN_FUNGUS_STAIRS);
        MOLTEN_FUNGUS_SLAB            = blockItem(MonstersConstant.MOLTEN_FUNGUS_SLAB,            MonstersBlocks.MOLTEN_FUNGUS_SLAB);
        MOLTEN_FUNGUS_FENCE           = blockItem(MonstersConstant.MOLTEN_FUNGUS_FENCE,           MonstersBlocks.MOLTEN_FUNGUS_FENCE);
        MOLTEN_FUNGUS_FENCE_GATE      = blockItem(MonstersConstant.MOLTEN_FUNGUS_FENCE_GATE,      MonstersBlocks.MOLTEN_FUNGUS_FENCE_GATE);
        MOLTEN_FUNGUS_PRESSURE_PLATE  = blockItem(MonstersConstant.MOLTEN_FUNGUS_PRESSURE_PLATE,  MonstersBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE);
        MOLTEN_FUNGUS_BUTTON          = blockItem(MonstersConstant.MOLTEN_FUNGUS_BUTTON,          MonstersBlocks.MOLTEN_FUNGUS_BUTTON);
        MOLTEN_FUNGUS_DOOR            = blockItem(MonstersConstant.MOLTEN_FUNGUS_DOOR,            MonstersBlocks.MOLTEN_FUNGUS_DOOR);
        MOLTEN_FUNGUS_TRAPDOOR        = blockItem(MonstersConstant.MOLTEN_FUNGUS_TRAPDOOR,        MonstersBlocks.MOLTEN_FUNGUS_TRAPDOOR);
        SHROOMLIGHT_MOLTEN            = blockItem(MonstersConstant.SHROOMLIGHT_MOLTEN,            MonstersBlocks.SHROOMLIGHT_MOLTEN);

        // -- Soul Wanderer wood set --
        SOUL_WANDERER_BLOCK           = blockItem(MonstersConstant.SOUL_WANDERER_BLOCK,           MonstersBlocks.SOUL_WANDERER_BLOCK);
        SOUL_WANDERER_STEM            = blockItem(MonstersConstant.SOUL_WANDERER_STEM,            MonstersBlocks.SOUL_WANDERER_STEM);
        SOUL_WANDERER_HYPHAE          = blockItem(MonstersConstant.SOUL_WANDERER_HYPHAE,          MonstersBlocks.SOUL_WANDERER_HYPHAE);
        SOUL_WANDERER_STRIPPED_STEM   = blockItem(MonstersConstant.SOUL_WANDERER_STRIPPED_STEM,   MonstersBlocks.SOUL_WANDERER_STRIPPED_STEM);
        SOUL_WANDERER_STRIPPED_HYPHAE = blockItem(MonstersConstant.SOUL_WANDERER_STRIPPED_HYPHAE, MonstersBlocks.SOUL_WANDERER_STRIPPED_HYPHAE);
        SOUL_WANDERER_PLANKS          = blockItem(MonstersConstant.SOUL_WANDERER_PLANKS,          MonstersBlocks.SOUL_WANDERER_PLANKS);
        SOUL_WANDERER_STAIRS          = blockItem(MonstersConstant.SOUL_WANDERER_STAIRS,          MonstersBlocks.SOUL_WANDERER_STAIRS);
        SOUL_WANDERER_SLAB            = blockItem(MonstersConstant.SOUL_WANDERER_SLAB,            MonstersBlocks.SOUL_WANDERER_SLAB);
        SOUL_WANDERER_FENCE           = blockItem(MonstersConstant.SOUL_WANDERER_FENCE,           MonstersBlocks.SOUL_WANDERER_FENCE);
        SOUL_WANDERER_FENCE_GATE      = blockItem(MonstersConstant.SOUL_WANDERER_FENCE_GATE,      MonstersBlocks.SOUL_WANDERER_FENCE_GATE);
        SOUL_WANDERER_PRESSURE_PLATE  = blockItem(MonstersConstant.SOUL_WANDERER_PRESSURE_PLATE,  MonstersBlocks.SOUL_WANDERER_PRESSURE_PLATE);
        SOUL_WANDERER_BUTTON          = blockItem(MonstersConstant.SOUL_WANDERER_BUTTON,          MonstersBlocks.SOUL_WANDERER_BUTTON);
        SOUL_WANDERER_DOOR            = blockItem(MonstersConstant.SOUL_WANDERER_DOOR,            MonstersBlocks.SOUL_WANDERER_DOOR);
        SOUL_WANDERER_TRAPDOOR        = blockItem(MonstersConstant.SOUL_WANDERER_TRAPDOOR,        MonstersBlocks.SOUL_WANDERER_TRAPDOOR);
        SHROOMLIGHT_SOUL              = blockItem(MonstersConstant.SHROOMLIGHT_SOUL,              MonstersBlocks.SHROOMLIGHT_SOUL);

        // -- Inkcap mushroom block variants --
        INK_CAP_BLACK_MUSHROOM_BLOCK      = blockItem(MonstersConstant.INK_CAP_BLACK_MUSHROOM_BLOCK,      MonstersBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK);
        INK_CAP_GREY_MUSHROOM_BLOCK       = blockItem(MonstersConstant.INK_CAP_GREY_MUSHROOM_BLOCK,       MonstersBlocks.INK_CAP_GREY_MUSHROOM_BLOCK);
        INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = blockItem(MonstersConstant.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK, MonstersBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

        // -- Huge decorative mushroom / fungus blocks --
        HUGE_BROWN_MUSHROOM      = blockItem(MonstersConstant.HUGE_BROWN_MUSHROOM,      MonstersBlocks.HUGE_BROWN_MUSHROOM);
        HUGE_CRIMSON_FUNGUS      = blockItem(MonstersConstant.HUGE_CRIMSON_FUNGUS,      MonstersBlocks.HUGE_CRIMSON_FUNGUS);
        HUGE_CRIMSON_RARE_FUNGUS = blockItem(MonstersConstant.HUGE_CRIMSON_RARE_FUNGUS, MonstersBlocks.HUGE_CRIMSON_RARE_FUNGUS);
        HUGE_ENDER_PUFFBALL      = blockItem(MonstersConstant.HUGE_ENDER_PUFFBALL,      MonstersBlocks.HUGE_ENDER_PUFFBALL);
        HUGE_FLY_RED_AGARIC      = blockItem(MonstersConstant.HUGE_FLY_RED_AGARIC,      MonstersBlocks.HUGE_FLY_RED_AGARIC);
        HUGE_FLY_YELLOW_AGARIC   = blockItem(MonstersConstant.HUGE_FLY_YELLOW_AGARIC,   MonstersBlocks.HUGE_FLY_YELLOW_AGARIC);
        HUGE_INFERNAL_MUSHROOM   = blockItem(MonstersConstant.HUGE_INFERNAL_MUSHROOM,   MonstersBlocks.HUGE_INFERNAL_MUSHROOM);
        HUGE_INK_CAP_MUSHROOM    = blockItem(MonstersConstant.HUGE_INK_CAP_MUSHROOM,    MonstersBlocks.HUGE_INK_CAP_MUSHROOM);
        HUGE_MOLTEN_FUNGUS       = blockItem(MonstersConstant.HUGE_MOLTEN_FUNGUS,       MonstersBlocks.HUGE_MOLTEN_FUNGUS);
        HUGE_SOUL_WANDERER       = blockItem(MonstersConstant.HUGE_SOUL_WANDERER,       MonstersBlocks.HUGE_SOUL_WANDERER);
        HUGE_WARPED_FUNGUS       = blockItem(MonstersConstant.HUGE_WARPED_FUNGUS,       MonstersBlocks.HUGE_WARPED_FUNGUS);
        HUGE_WARPED_RARE_FUNGUS  = blockItem(MonstersConstant.HUGE_WARPED_RARE_FUNGUS,  MonstersBlocks.HUGE_WARPED_RARE_FUNGUS);

        // -- Decoration blocks --
        ENDER_MOSS      = blockItem(MonstersConstant.ENDER_MOSS,      MonstersBlocks.ENDER_MOSS);
        GLOW_BERRY_BUSH = blockItem(MonstersConstant.GLOW_BERRY_BUSH, MonstersBlocks.GLOW_BERRY_BUSH);
        JAR             = blockItem(MonstersConstant.JAR,             MonstersBlocks.JAR);
        URN_MOLTEN      = blockItem(MonstersConstant.URN_MOLTEN,      MonstersBlocks.URN_MOLTEN);
        URN_CRIMSON     = blockItem(MonstersConstant.URN_CRIMSON,     MonstersBlocks.URN_CRIMSON);

        // -- Snowball Mushroom wood set --
        SNOWBALL_LOG            = blockItem(MonstersConstant.SNOWBALL_LOG,            MonstersBlocks.SNOWBALL_LOG);
        SNOWBALL_WOOD           = blockItem(MonstersConstant.SNOWBALL_WOOD,           MonstersBlocks.SNOWBALL_WOOD);
        SNOWBALL_STRIPPED_LOG   = blockItem(MonstersConstant.SNOWBALL_STRIPPED_LOG,   MonstersBlocks.SNOWBALL_STRIPPED_LOG);
        SNOWBALL_STRIPPED_WOOD  = blockItem(MonstersConstant.SNOWBALL_STRIPPED_WOOD,  MonstersBlocks.SNOWBALL_STRIPPED_WOOD);
        SNOWBALL_PLANKS         = blockItem(MonstersConstant.SNOWBALL_PLANKS,         MonstersBlocks.SNOWBALL_PLANKS);
        SNOWBALL_STAIRS         = blockItem(MonstersConstant.SNOWBALL_STAIRS,         MonstersBlocks.SNOWBALL_STAIRS);
        SNOWBALL_SLAB           = blockItem(MonstersConstant.SNOWBALL_SLAB,           MonstersBlocks.SNOWBALL_SLAB);
        SNOWBALL_FENCE          = blockItem(MonstersConstant.SNOWBALL_FENCE,          MonstersBlocks.SNOWBALL_FENCE);
        SNOWBALL_FENCE_GATE     = blockItem(MonstersConstant.SNOWBALL_FENCE_GATE,     MonstersBlocks.SNOWBALL_FENCE_GATE);
        SNOWBALL_PRESSURE_PLATE = blockItem(MonstersConstant.SNOWBALL_PRESSURE_PLATE, MonstersBlocks.SNOWBALL_PRESSURE_PLATE);
        SNOWBALL_BUTTON         = blockItem(MonstersConstant.SNOWBALL_BUTTON,         MonstersBlocks.SNOWBALL_BUTTON);
        SNOWBALL_DOOR           = blockItem(MonstersConstant.SNOWBALL_DOOR,           MonstersBlocks.SNOWBALL_DOOR);
        SNOWBALL_TRAPDOOR       = blockItem(MonstersConstant.SNOWBALL_TRAPDOOR,       MonstersBlocks.SNOWBALL_TRAPDOOR);
        SNOWBALL_MUSHROOM_BLOCK = blockItem(MonstersConstant.SNOWBALL_MUSHROOM_BLOCK, MonstersBlocks.SNOWBALL_MUSHROOM_BLOCK);
        SNOWBALL_SHROOMLIGHT    = blockItem(MonstersConstant.SNOWBALL_SHROOMLIGHT,    MonstersBlocks.SNOWBALL_SHROOMLIGHT);

        // -- Ender Willow wood set --
        ENDER_WILLOW_LOG           = blockItem(MonstersConstant.ENDER_WILLOW_LOG,           MonstersBlocks.ENDER_WILLOW_LOG);
        ENDER_WILLOW_WOOD          = blockItem(MonstersConstant.ENDER_WILLOW_WOOD,          MonstersBlocks.ENDER_WILLOW_WOOD);
        ENDER_WILLOW_STRIPPED_LOG  = blockItem(MonstersConstant.ENDER_WILLOW_STRIPPED_LOG,  MonstersBlocks.ENDER_WILLOW_STRIPPED_LOG);
        ENDER_WILLOW_STRIPPED_WOOD = blockItem(MonstersConstant.ENDER_WILLOW_STRIPPED_WOOD, MonstersBlocks.ENDER_WILLOW_STRIPPED_WOOD);
        ENDER_WILLOW_PLANKS        = blockItem(MonstersConstant.ENDER_WILLOW_PLANKS,        MonstersBlocks.ENDER_WILLOW_PLANKS);
        ENDER_WILLOW_STAIRS        = blockItem(MonstersConstant.ENDER_WILLOW_STAIRS,        MonstersBlocks.ENDER_WILLOW_STAIRS);
        ENDER_WILLOW_SLAB          = blockItem(MonstersConstant.ENDER_WILLOW_SLAB,          MonstersBlocks.ENDER_WILLOW_SLAB);
        ENDER_WILLOW_FENCE         = blockItem(MonstersConstant.ENDER_WILLOW_FENCE,         MonstersBlocks.ENDER_WILLOW_FENCE);
        ENDER_WILLOW_FENCE_GATE    = blockItem(MonstersConstant.ENDER_WILLOW_FENCE_GATE,    MonstersBlocks.ENDER_WILLOW_FENCE_GATE);
        ENDER_WILLOW_PRESSURE_PLATE = blockItem(MonstersConstant.ENDER_WILLOW_PRESSURE_PLATE, MonstersBlocks.ENDER_WILLOW_PRESSURE_PLATE);
        ENDER_WILLOW_BUTTON        = blockItem(MonstersConstant.ENDER_WILLOW_BUTTON,        MonstersBlocks.ENDER_WILLOW_BUTTON);
        ENDER_WILLOW_DOOR          = blockItem(MonstersConstant.ENDER_WILLOW_DOOR,          MonstersBlocks.ENDER_WILLOW_DOOR);
        ENDER_WILLOW_TRAPDOOR      = blockItem(MonstersConstant.ENDER_WILLOW_TRAPDOOR,      MonstersBlocks.ENDER_WILLOW_TRAPDOOR);
        ENDER_WILLOW_LEAVES        = blockItem(MonstersConstant.ENDER_WILLOW_LEAVES,        MonstersBlocks.ENDER_WILLOW_LEAVES);
        ENDER_WILLOW_SAPLING       = blockItem(MonstersConstant.ENDER_WILLOW_SAPLING,       MonstersBlocks.ENDER_WILLOW_SAPLING);

    } // registerBlockItems ()

    // -------------------------------------------------------------------------
    // Private — hat item registration
    // -------------------------------------------------------------------------

    private static void registerHatItems() {
        // Hats are registered exclusively in Fabric's MonstersItems.registerHatItems()
        // using MushroomHatItem (GeoItem subclass, GeckoLib-dependent).
        // Common cannot register them because GeckoLib is a Fabric-only compile dependency.
        // Fields remain null until Fabric's registration populates them at startup.
        //
        // Registration order: Monsters.init() (Common) → MonstersItems.register() (Fabric)
        // Both run in onInitialize(), Common first, so by the time Fabric registers the hats
        // the armor material holders are already available.
    } // registerHatItems ()

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    /**
     * Registers a {@link BlockItem} wrapping the given block under {@code name}.
     * Uses vanilla {@link Item.Properties} — no loader-specific settings needed.
     */
    private static Item blockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM,
                MonstersIdentifier.getId(name),
                new BlockItem(block, new Item.Properties()));
    } // blockItem ()

    /**
     * Registers an arbitrary {@link Item} under {@code name}.
     * Used for hat items which aren't {@link BlockItem} wrappers.
     */
    private static Item item(String name, Item i) {
        return Registry.register(BuiltInRegistries.ITEM,
                MonstersIdentifier.getId(name), i);
    } // item ()

} // Class: MonstersBlockItems
