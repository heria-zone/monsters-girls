package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.heriazone.hzlib.api.groups.InternalGroups;
import net.heriazone.monsters_girls.Monsters;
import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;

public class MonstersGroups extends InternalGroups {

    // -- Variables --

    /**
     * Default creative tab for Legacy variant items.
     * <p>
     * <b>Contents:</b> Robot cores, spawn eggs, and related items.
     */
    public static final CreativeModeTab DEFAULT_TAB = register(
            MonstersIdentifier.getId(MonstersConstant.DEFAULT_GROUP),
            registerGroup(MonstersIdentifier.getTabTranslation(MonstersConstant.DEFAULT_GROUP), MonstersItems.POWDER_GENESIS)
    );

    /**
     * Registry key for default tab, used for item group event registration.
     */
    public static final ResourceKey<CreativeModeTab> DEFAULT_KEY = registerKey(MonstersIdentifier.getId(MonstersConstant.DEFAULT_GROUP));

    // -- Methods --

    /**
     * Registers creative tabs with Fabric registry.
     * <p>
     * <b>Order:</b> Misc → food/drinks → potions → spawn eggs all go to the default
     * tab. Wood sets, huge blocks, and hats each get dedicated modifying events, so
     * they land in logical groups without polluting {@code addMiscItems}.
     */
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(MonstersGroups::addSpawnEggs);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(MonstersGroups::addFoodAndDrinkItems);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(MonstersGroups::addPotionItems);

        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addMiscItems);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addWoodSetItems);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addNaturalBlocks);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addDecorationBlocks);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addHatItems);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addFoodAndDrinkItems);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addPotionItems);
        ItemGroupEvents.modifyEntriesEvent(MonstersGroups.DEFAULT_KEY).register(MonstersGroups::addSpawnEggs);

        Monsters.LOGGER.info("Registering CreativeTabs for: " + Monsters.MODID);
    } // register()

    /**
     * Adds food and drink items (stews, treats) to both the vanilla Food & Drinks tab
     * and the mod's default tab.
     * <p>
     * Ordering: treats first, then stews grouped by family type (overworld → nether → special).
     */
    private static void addFoodAndDrinkItems(FabricItemGroupEntries entries) {
        // Treats
        entries.accept(MonstersItems.CANDIES);
        entries.accept(MonstersItems.SPECTRAL_CAKE);

        // Overworld mushroom stews
        entries.accept(MonstersItems.STEW_POISON);
        entries.accept(MonstersItems.STEW_PUFFBALL);
        entries.accept(MonstersItems.STEW_SNOWBALL);

        // Nether mushroom stews (shared by Infernal, Crimson, Warped)
        entries.accept(MonstersItems.STEW_NETHER);

        // Special mushroom stews
        entries.accept(MonstersItems.STEW_MOLTEN);
        entries.accept(MonstersItems.STEW_SOUL_WANDERER);
    } // addFoodAndDrinkItems ()

    /**
     * Adds all custom potions, splash potions, lingering potions, and tipped arrows
     * to the vanilla Food &amp; Drinks tab and the mod's default tab.
     * <p>
     * Grouped per effect, each tier in order: regular → long → strong (where applicable).
     * All four forms are listed together so players can compare them at a glance.
     * <p>
     * <b>Note:</b> Fabric does not expose a dedicated Brewing tab — potions live in
     * Food &amp; Drinks in vanilla Fabric creative mode.
     */
    private static void addPotionItems(FabricItemGroupEntries entries) {
        // Potions

        // -- Poisonous --
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.LONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.STRONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.LONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.STRONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.LONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.STRONG_POISONOUS));

        // -- Chilly --
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.CHILLY));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.LONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.STRONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.CHILLY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.LONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.STRONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.CHILLY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.LONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.STRONG_CHILLY));

        // -- Blazing (no Strong tier) --
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.BLAZING));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.LONG_BLAZING));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.BLAZING));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.LONG_BLAZING));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.BLAZING));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.LONG_BLAZING));

        // -- Soul Wanderer's Touch (no Strong tier) --
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.LONG_SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.LONG_SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.LONG_SOUL_WANDERERS_TOUCH));

        // -- Puffy --
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.PUFFY));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.LONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.POTION,           MonstersPotions.STRONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.PUFFY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.LONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.SPLASH_POTION,    MonstersPotions.STRONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.PUFFY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.LONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.LINGERING_POTION, MonstersPotions.STRONG_PUFFY));


        // Tipped Arrows

        // -- Poisonous --
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.LONG_POISONOUS));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.STRONG_POISONOUS));

        // -- Chilly --
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.CHILLY));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.LONG_CHILLY));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.STRONG_CHILLY));

        // -- Blazing --
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.BLAZING));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.LONG_BLAZING));

        // -- Soul Wanderer's Touch --
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.SOUL_WANDERERS_TOUCH));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.LONG_SOUL_WANDERERS_TOUCH));

        // -- Puffy --
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.PUFFY));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.LONG_PUFFY));
        entries.accept(PotionContents.createItemStack(Items.TIPPED_ARROW,     MonstersPotions.STRONG_PUFFY));

    } // addPotionItems ()

    /**
     * Adds spawn eggs to vanilla spawn eggs creative tab.
     */
    private static void addSpawnEggs(FabricItemGroupEntries entries) {
        entries.accept(MonstersItems.BEE_HONEY_SPAWN);
        entries.accept(MonstersItems.GLOBBERIE_SPAWN);
        entries.accept(MonstersItems.GOURDRAGORA_GOLDEN_SPAWN);
        entries.accept(MonstersItems.GOURDRAGORA_LUMINA_SPAWN);
        entries.accept(MonstersItems.GOURDRAGORA_JACKO_SPAWN);
        entries.accept(MonstersItems.MAIDEN_SPAWN);
        entries.accept(MonstersItems.SLIME_BLUE_SPAWN);
        entries.accept(MonstersItems.MANDRAKE_CHORUS_SPAWN);
        entries.accept(MonstersItems.MANDRAKE_FLOWER_SPAWN);
        entries.accept(MonstersItems.MANDRAKE_FRUCTUS_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_BROWN_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_AMANITA_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_CRIMSON_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_INFERNAL_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_INKCAPS_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_MOLTEN_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_PUFFBALL_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_SNOWBALL_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_SOUL_WANDERER_SPAWN);
        entries.accept(MonstersItems.MUSHROOM_WARPED_SPAWN);
        entries.accept(MonstersItems.SPOOK_CREAM_SPAWN);
        entries.accept(MonstersItems.SPOOK_PEACH_SPAWN);
        entries.accept(MonstersItems.SPOOK_TEAL_SPAWN);
        entries.accept(MonstersItems.WISP_BLUE_SPAWN);
        entries.accept(MonstersItems.WISP_GREEN_SPAWN);
        entries.accept(MonstersItems.WISP_YELLOW_SPAWN);
    } // addSpawnEggs ()

    /**
     * Adds miscellaneous non-food mod items to the mod's default tab.
     * Includes custom mushroom/fungus plant blocks under Natural blocks group.
     */
    private static void addMiscItems(FabricItemGroupEntries entries) {
        entries.accept(MonstersItems.POWDER_GENESIS);

        // Custom mushroom/fungus plant blocks — genesis triggers + planting targets
        entries.accept(MonstersItems.INKCAP_MUSHROOM);
        entries.accept(MonstersItems.MOLTEN_FUNGUS);
        entries.accept(MonstersItems.ENDER_MUSHROOM);
        entries.accept(MonstersItems.SNOWBALL_MUSHROOM);
        entries.accept(MonstersItems.SOUL_WANDERER_FUNGUS);

        // Mandrake flower plant — placed by Mandrake Flower entity via PlantingFeature
        if (MonstersBlockItems.MANDRAKE_FLOWER_PLANT != null)
            entries.accept(MonstersBlockItems.MANDRAKE_FLOWER_PLANT);
    } // addMiscItems ()

    /**
     * Adds all three wood-set block items in family order (Ender Puffball → Molten Fungus →
     * Soul Wanderer). Within each family: structural (block/stem/hyphae) → stripped → planks
     * → derived (stairs, slab) → functional (fence, gate, door, trapdoor, plate, button)
     * → shroomlight.
     * <p>
     * <b>Design:</b> Groups mirror the order in {@link MonstersBlocks#register()} so the
     * two files are trivially diffable.
     */
    private static void addWoodSetItems(FabricItemGroupEntries entries) {
        // -- Ender Puffball --
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_BLOCK);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_STEM);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_HYPHAE);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_STRIPPED_STEM);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_STRIPPED_HYPHAE);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_PLANKS);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_STAIRS);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_SLAB);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_FENCE);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_FENCE_GATE);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_PRESSURE_PLATE);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_BUTTON);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_DOOR);
        entries.accept(MonstersBlockItems.ENDER_PUFFBALL_TRAPDOOR);
        entries.accept(MonstersBlockItems.SHROOMLIGHT_ENDER);

        // -- Molten Fungus --
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_BLOCK);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_STEM);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_HYPHAE);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_STRIPPED_STEM);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_PLANKS);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_STAIRS);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_SLAB);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_FENCE);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_FENCE_GATE);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_PRESSURE_PLATE);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_BUTTON);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_DOOR);
        entries.accept(MonstersBlockItems.MOLTEN_FUNGUS_TRAPDOOR);
        entries.accept(MonstersBlockItems.SHROOMLIGHT_MOLTEN);

        // -- Soul Wanderer --
        entries.accept(MonstersBlockItems.SOUL_WANDERER_BLOCK);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_STEM);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_HYPHAE);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_STRIPPED_STEM);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_STRIPPED_HYPHAE);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_PLANKS);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_STAIRS);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_SLAB);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_FENCE);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_FENCE_GATE);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_PRESSURE_PLATE);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_BUTTON);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_DOOR);
        entries.accept(MonstersBlockItems.SOUL_WANDERER_TRAPDOOR);
        // -- Snowball Mushroom --
        entries.accept(MonstersBlockItems.SNOWBALL_LOG);
        entries.accept(MonstersBlockItems.SNOWBALL_WOOD);
        entries.accept(MonstersBlockItems.SNOWBALL_STRIPPED_LOG);
        entries.accept(MonstersBlockItems.SNOWBALL_STRIPPED_WOOD);
        entries.accept(MonstersBlockItems.SNOWBALL_PLANKS);
        entries.accept(MonstersBlockItems.SNOWBALL_STAIRS);
        entries.accept(MonstersBlockItems.SNOWBALL_SLAB);
        entries.accept(MonstersBlockItems.SNOWBALL_FENCE);
        entries.accept(MonstersBlockItems.SNOWBALL_FENCE_GATE);
        entries.accept(MonstersBlockItems.SNOWBALL_PRESSURE_PLATE);
        entries.accept(MonstersBlockItems.SNOWBALL_BUTTON);
        entries.accept(MonstersBlockItems.SNOWBALL_DOOR);
        entries.accept(MonstersBlockItems.SNOWBALL_TRAPDOOR);
        entries.accept(MonstersBlockItems.SNOWBALL_MUSHROOM_BLOCK);
        entries.accept(MonstersBlockItems.SNOWBALL_SHROOMLIGHT);

        // -- Ender Willow --
        entries.accept(MonstersBlockItems.ENDER_WILLOW_LOG);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_WOOD);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_STRIPPED_LOG);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_STRIPPED_WOOD);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_PLANKS);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_STAIRS);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_SLAB);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_FENCE);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_FENCE_GATE);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_PRESSURE_PLATE);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_BUTTON);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_DOOR);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_TRAPDOOR);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_LEAVES);
        entries.accept(MonstersBlockItems.ENDER_WILLOW_SAPLING);
    } // addWoodSetItems ()

    /**
     * Adds Inkcap block variants and all 12 huge decorative mushroom/fungus blocks.
     * Ordered by biome theme: overworld → nether → end → special.
     */
    private static void addNaturalBlocks(FabricItemGroupEntries entries) {
        // Inkcap colour variants
        entries.accept(MonstersBlockItems.INK_CAP_BLACK_MUSHROOM_BLOCK);
        entries.accept(MonstersBlockItems.INK_CAP_GREY_MUSHROOM_BLOCK);
        entries.accept(MonstersBlockItems.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

        // Huge decorative mushrooms (overworld)
        entries.accept(MonstersBlockItems.HUGE_BROWN_MUSHROOM);
        entries.accept(MonstersBlockItems.HUGE_FLY_RED_AGARIC);
        entries.accept(MonstersBlockItems.HUGE_FLY_YELLOW_AGARIC);
        entries.accept(MonstersBlockItems.HUGE_INK_CAP_MUSHROOM);
        // Huge decorative mushrooms (nether)
        entries.accept(MonstersBlockItems.HUGE_CRIMSON_FUNGUS);
        entries.accept(MonstersBlockItems.HUGE_CRIMSON_RARE_FUNGUS);
        entries.accept(MonstersBlockItems.HUGE_INFERNAL_MUSHROOM);
        entries.accept(MonstersBlockItems.HUGE_MOLTEN_FUNGUS);
        entries.accept(MonstersBlockItems.HUGE_WARPED_FUNGUS);
        entries.accept(MonstersBlockItems.HUGE_WARPED_RARE_FUNGUS);
        // Huge decorative mushrooms (end / soul)
        entries.accept(MonstersBlockItems.HUGE_ENDER_PUFFBALL);
        entries.accept(MonstersBlockItems.HUGE_SOUL_WANDERER);
    } // addNaturalBlocks ()

    /**
     * Adds decoration block items: Ender Moss, Glow Berry Bush, Jar, and two Urn variants.
     */
    private static void addDecorationBlocks(FabricItemGroupEntries entries) {
        entries.accept(MonstersBlockItems.ENDER_MOSS);
        entries.accept(MonstersBlockItems.GLOW_BERRY_BUSH);
        entries.accept(MonstersBlockItems.JAR);
        entries.accept(MonstersBlockItems.URN_MOLTEN);
        entries.accept(MonstersBlockItems.URN_CRIMSON);
    } // addDecorationBlocks ()

    /**
     * Adds all 12 hat items to the mod's default tab.
     * <p>
     * Hats are registered by Fabric's {@code MonstersItems} (not Common's {@code MonstersBlockItems})
     * so they're looked up from {@link net.minecraft.core.registries.BuiltInRegistries#ITEM} at
     * tab-build time. This avoids referencing null fields from the Common module.
     */
    private static void addHatItems(FabricItemGroupEntries entries) {
        String[] hatKeys = {
            // Overworld hats
            MonstersConstant.HAT_MUSHROOM_BROWN,
            MonstersConstant.HAT_MUSHROOM_FLY_RED_AGARIC,
            MonstersConstant.HAT_MUSHROOM_FLY_YELLOW_AGARIC,
            MonstersConstant.HAT_MUSHROOM_INK_CAP,
            // Nether hats
            MonstersConstant.HAT_MUSHROOM_CRIMSON,
            MonstersConstant.HAT_MUSHROOM_CRIMSON_RARE,
            MonstersConstant.HAT_MUSHROOM_INFERNAL,
            MonstersConstant.HAT_MUSHROOM_MOLTEN,
            MonstersConstant.HAT_MUSHROOM_WARPED,
            MonstersConstant.HAT_MUSHROOM_WARPED_RARE,
            // End / soul hats
            MonstersConstant.HAT_MUSHROOM_ENDER_PUFFBALL,
            MonstersConstant.HAT_MUSHROOM_SOUL_WANDERER
        };
        for (String key : hatKeys) {
            net.minecraft.world.item.Item hat =
                    net.minecraft.core.registries.BuiltInRegistries.ITEM.get(MonstersIdentifier.getId(key));
            if (hat != null && hat != net.minecraft.world.item.Items.AIR) {
                entries.accept(hat);
            }
        }
    } // addHatItems ()

} // Class: MonstersGroups