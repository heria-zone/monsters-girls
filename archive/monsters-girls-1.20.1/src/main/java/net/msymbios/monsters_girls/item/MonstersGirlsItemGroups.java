package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsItemGroups {

    // - Variables --
    public static final ItemGroup DEFAULT_GROUP = register("default_group", register("itemGroup.monsters_girls.default_group"));

    // -- Methods --
    private static ItemGroup register(String name, ItemGroup itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, new Identifier(MonstersGirls.MODID, name), itemGroup);
    } // register ()

    public static ItemGroup register(String translatable) {
        return FabricItemGroup.builder().displayName(Text.translatable(translatable)).icon(() -> new ItemStack(MonstersGirlsItems.POWDER_GENESIS)).entries(((displayContext, entries) -> {
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_BROWN);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_CRIMSON);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_CRIMSON_RARE);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_ENDER_PUFFBALL);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_FLY_RED_AGARIC);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_FLY_YELLOW_AGARIC);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_INFERNAL);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_INK_CAP);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_MOLTEN);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_SOUL_WANDERER);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_WARPED);
            entries.add(MonstersGirlsItems.HAT_MUSHROOM_WARPED_RARE);

            entries.add(MonstersGirlsItems.ENDER_MOSS);
            entries.add(MonstersGirlsItems.SHROOMLIGHT_ENDER);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_BLOCK);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STEM);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_HYPHAE);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_STEM);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_HYPHAE);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_STAIRS);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_SLAB);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_FENCE);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_FENCE_GATE);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_PRESSURE_PLATE);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_BUTTON);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_DOOR);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_TRAPDOOR);

            entries.add(MonstersGirlsItems.INK_CAP_BLACK_MUSHROOM_BLOCK);
            entries.add(MonstersGirlsItems.INK_CAP_GREY_MUSHROOM_BLOCK);
            entries.add(MonstersGirlsItems.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

            entries.add(MonstersGirlsItems.SHROOMLIGHT_MOLTEN);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_BLOCK);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STEM);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_HYPHAE);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_STEM);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_STAIRS);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_SLAB);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_FENCE);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_FENCE_GATE);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_PRESSURE_PLATE);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_BUTTON);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_DOOR);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS_TRAPDOOR);

            entries.add(MonstersGirlsItems.POWDER_GENESIS);

            entries.add(MonstersGirlsItems.SHROOMLIGHT_SOUL);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_BLOCK);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_STEM);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_HYPHAE);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_STEM);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_HYPHAE);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_PLANKS);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_STAIRS);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_SLAB);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_FENCE);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_FENCE_GATE);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_PRESSURE_PLATE);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_BUTTON);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_DOOR);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_TRAPDOOR);

            entries.add(MonstersGirlsItems.SPECTRAL_CAKE);
            entries.add(MonstersGirlsItems.CANDIES);

            entries.add(MonstersGirlsItems.HUGE_BROWN_MUSHROOM);
            entries.add(MonstersGirlsItems.HUGE_CRIMSON_FUNGUS);
            entries.add(MonstersGirlsItems.HUGE_CRIMSON_RARE_FUNGUS);
            entries.add(MonstersGirlsItems.HUGE_ENDER_PUFFBALL);
            entries.add(MonstersGirlsItems.HUGE_FLY_RED_AGARIC);
            entries.add(MonstersGirlsItems.HUGE_FLY_YELLOW_AGARIC);
            entries.add(MonstersGirlsItems.HUGE_INFERNAL_MUSHROOM);
            entries.add(MonstersGirlsItems.HUGE_INK_CAP_MUSHROOM);
            entries.add(MonstersGirlsItems.HUGE_MOLTEN_FUNGUS);
            entries.add(MonstersGirlsItems.HUGE_SOUL_WANDERER);
            entries.add(MonstersGirlsItems.HUGE_WARPED_FUNGUS);
            entries.add(MonstersGirlsItems.HUGE_WARPED_RARE_FUNGUS);

            entries.add(MonstersGirlsItems.MANDRAKE_FLOWER);
            entries.add(MonstersGirlsItems.ENDER_PUFFBALL_MUSHROOM);
            entries.add(MonstersGirlsItems.INK_CAP_MUSHROOM);
            entries.add(MonstersGirlsItems.MOLTEN_FUNGUS);
            entries.add(MonstersGirlsItems.SOUL_WANDERER_FUNGUS);

            entries.add(MonstersGirlsItems.GLOW_BERRY_BUSH);

            entries.add(MonstersGirlsItems.JAR);
            entries.add(MonstersGirlsItems.URN_MOLTEN);
            entries.add(MonstersGirlsItems.URN_CRIMSON);

            entries.add(MonstersGirlsItems.SPAWN_BEE_GIRL);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_BIG);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_MINI);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_BIG);
            entries.add(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_MINI);
            entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_BROWN);
            entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_CHORUS);
            entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GLOW_BERRY);
            entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GREEN);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_BROWN);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON_RARE);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_RED);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_YELLOW);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INK_CAP);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED_RARE);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_ENDER_PUFFBALL);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INFERNAL);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_MOLTEN);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SOUL_WANDERER);
            entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SNOWBALL);
            entries.add(MonstersGirlsItems.SPAWN_SLIME_GIRL);
            entries.add(MonstersGirlsItems.SPAWN_SPOOK_GIRL_PEACH);
            entries.add(MonstersGirlsItems.SPAWN_SPOOK_GIRL_TEAL);
            entries.add(MonstersGirlsItems.SPAWN_WISP_GIRL_BLUE);
            entries.add(MonstersGirlsItems.SPAWN_WISP_GIRL_GREEN);
            entries.add(MonstersGirlsItems.SPAWN_WISP_GIRL_YELLOW);

        })).build();
    } // register ()

    public static void register () {
        MonstersGirls.LOGGER.info("Registering ItemGroups: " + MonstersGirls.MODID);
    } // register ()

} // Class MonstersGirlsItemGroups