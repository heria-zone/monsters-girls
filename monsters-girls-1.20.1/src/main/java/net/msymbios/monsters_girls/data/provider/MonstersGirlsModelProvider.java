package net.msymbios.monsters_girls.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;

public class MonstersGirlsModelProvider extends FabricModelProvider {

    // -- Constructor --
    public MonstersGirlsModelProvider(FabricDataOutput output) {
        super(output);
    } // Constructor MonstersGirlsModelProvider ()

    // -- Inherited Method --
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
        // SHROOMLIGHT
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.SHROOMLIGHT_ENDER, MonstersGirlsID.SHROOMLIGHT_ENDER);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.SHROOMLIGHT_MOLTEN, MonstersGirlsID.SHROOMLIGHT_MOLTEN);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.SHROOMLIGHT_SOUL, MonstersGirlsID.SHROOMLIGHT_SOUL);

        // MUSHROOM BLOCK
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.ENDER_PUFFBALL_BLOCK, MonstersGirlsID.ENDER_PUFFBALL_BLOCK);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.MOLTEN_FUNGUS_BLOCK, MonstersGirlsID.MOLTEN_FUNGUS_BLOCK);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.SOUL_WANDERER_BLOCK, MonstersGirlsID.SOUL_WANDERER_BLOCK);

        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK, MonstersGirlsID.INK_CAP_BLACK_MUSHROOM_BLOCK);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.INK_CAP_GREY_MUSHROOM_BLOCK, MonstersGirlsID.INK_CAP_GREY_MUSHROOM_BLOCK);
        registerSimpleCubeAll(modelGenerator, MonstersGirlsBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK, MonstersGirlsID.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

        // STEM BLOCK
        modelGenerator.registerLog(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM).stem(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM).wood(MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE);
        modelGenerator.registerLog(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM).stem(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM).wood(MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE);
        modelGenerator.registerLog(MonstersGirlsBlocks.SOUL_WANDERER_STEM).stem(MonstersGirlsBlocks.SOUL_WANDERER_STEM).wood(MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE);

        modelGenerator.registerLog(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM).stem(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM).wood(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE);
        modelGenerator.registerLog(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM).stem(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM).wood(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
        modelGenerator.registerLog(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM).stem(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM).wood(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE);

        // PLANKS
        registerParentedItemModel(modelGenerator, MonstersGirlsBlocks.ENDER_PUFFBALL_PLANKS, MonstersGirlsID.ENDER_PUFFBALL_PLANKS);
        registerParentedItemModel(modelGenerator, MonstersGirlsBlocks.MOLTEN_FUNGUS_PLANKS, MonstersGirlsID.MOLTEN_FUNGUS_PLANKS);
        registerParentedItemModel(modelGenerator, MonstersGirlsBlocks.SOUL_WANDERER_PLANKS, MonstersGirlsID.SOUL_WANDERER_PLANKS);

        modelGenerator.registerCubeAllModelTexturePool(MonstersGirlsBlocks.ENDER_PUFFBALL_PLANKS)
                .stairs(MonstersGirlsBlocks.ENDER_PUFFBALL_STAIRS)
                .slab(MonstersGirlsBlocks.ENDER_PUFFBALL_SLAB)
                .fence(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE)
                .fenceGate(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE_GATE)
                .pressurePlate(MonstersGirlsBlocks.ENDER_PUFFBALL_PRESSURE_PLATE)
                .button(MonstersGirlsBlocks.ENDER_PUFFBALL_BUTTON);

        modelGenerator.registerCubeAllModelTexturePool(MonstersGirlsBlocks.MOLTEN_FUNGUS_PLANKS)
                .stairs(MonstersGirlsBlocks.MOLTEN_FUNGUS_STAIRS)
                .slab(MonstersGirlsBlocks.MOLTEN_FUNGUS_SLAB)
                .fence(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE)
                .fenceGate(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE_GATE)
                .pressurePlate(MonstersGirlsBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE)
                .button(MonstersGirlsBlocks.MOLTEN_FUNGUS_BUTTON);

        modelGenerator.registerCubeAllModelTexturePool(MonstersGirlsBlocks.SOUL_WANDERER_PLANKS)
                .stairs(MonstersGirlsBlocks.SOUL_WANDERER_STAIRS)
                .slab(MonstersGirlsBlocks.SOUL_WANDERER_SLAB)
                .fence(MonstersGirlsBlocks.SOUL_WANDERER_FENCE)
                .fenceGate(MonstersGirlsBlocks.SOUL_WANDERER_FENCE_GATE)
                .pressurePlate(MonstersGirlsBlocks.SOUL_WANDERER_PRESSURE_PLATE)
                .button(MonstersGirlsBlocks.SOUL_WANDERER_BUTTON);

        modelGenerator.registerDoor(MonstersGirlsBlocks.ENDER_PUFFBALL_DOOR);
        modelGenerator.registerDoor(MonstersGirlsBlocks.MOLTEN_FUNGUS_DOOR);
        modelGenerator.registerDoor(MonstersGirlsBlocks.SOUL_WANDERER_DOOR);

        modelGenerator.registerTrapdoor(MonstersGirlsBlocks.ENDER_PUFFBALL_TRAPDOOR);
        modelGenerator.registerTrapdoor(MonstersGirlsBlocks.MOLTEN_FUNGUS_TRAPDOOR);
        modelGenerator.registerTrapdoor(MonstersGirlsBlocks.SOUL_WANDERER_TRAPDOOR);

    } // generateBlockStateModels ()

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(MonstersGirlsItems.POWDER_GENESIS, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_BROWN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_CRIMSON, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_CRIMSON_RARE, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_ENDER_PUFFBALL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_FLY_RED_AGARIC, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_FLY_YELLOW_AGARIC, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_INFERNAL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_INK_CAP, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_MOLTEN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_SOUL_WANDERER, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_WARPED, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HAT_MUSHROOM_WARPED_RARE, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.SPECTRAL_CAKE, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.CANDIES, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.HUGE_BROWN_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_CRIMSON_FUNGUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_CRIMSON_RARE_FUNGUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_ENDER_PUFFBALL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_FLY_RED_AGARIC, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_FLY_YELLOW_AGARIC, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_INFERNAL_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_INK_CAP_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_MOLTEN_FUNGUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_SOUL_WANDERER, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_WARPED_FUNGUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.HUGE_WARPED_RARE_FUNGUS, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.MANDRAKE_FLOWER, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.ENDER_PUFFBALL_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.INK_CAP_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.MOLTEN_FUNGUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SOUL_WANDERER_FUNGUS, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.JAR, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.URN_MOLTEN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.URN_CRIMSON, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.GLOW_BERRY_BUSH, Models.GENERATED);

        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_BIG, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_MINI, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_BIG, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_MINI, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_BROWN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_CHORUS, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GLOW_BERRY, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GREEN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_BROWN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON_RARE, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_RED, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_YELLOW, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INK_CAP, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED_RARE, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_ENDER_PUFFBALL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INFERNAL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_MOLTEN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SOUL_WANDERER, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SNOWBALL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_SLIME_GIRL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_SPOOK_GIRL_PEACH, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_SPOOK_GIRL_TEAL, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_WISP_GIRL_BLUE, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_WISP_GIRL_GREEN, Models.GENERATED);
        itemModelGenerator.register(MonstersGirlsItems.SPAWN_WISP_GIRL_YELLOW, Models.GENERATED);
    } // generateItemModels ()

    // -- Methods --
    private void registerSimpleCubeAll(BlockStateModelGenerator blockStateModelGenerator, Block block, String id) {
        blockStateModelGenerator.registerSimpleCubeAll(block);
        blockStateModelGenerator.registerParentedItemModel(block, new Identifier(MonstersGirls.MODID,"block/" + id));
    } // registerSimpleCubeAll ()

    private void registerParentedItemModel(BlockStateModelGenerator blockStateModelGenerator, Block block, String id) {
        blockStateModelGenerator.registerParentedItemModel(block, new Identifier(MonstersGirls.MODID,"block/" + id));
    } // registerParentedItemModel ()

} // Class MonstersGirlsModelProvider