package net.msymbios.monsters_girls.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;

import java.util.concurrent.CompletableFuture;

public class MonstersGirlsBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    // -- Constructor --
    public MonstersGirlsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    } // Constructor MonstersGirlsBlockTagProvider ()

    // -- Inherited Method --
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(MonstersGirlsBlocks.SHROOMLIGHT_ENDER)
                .add(MonstersGirlsBlocks.SHROOMLIGHT_MOLTEN)
                .add(MonstersGirlsBlocks.SHROOMLIGHT_SOUL)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_BLOCK)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_BLOCK)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_BLOCK)

                .add(MonstersGirlsBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK)
                .add(MonstersGirlsBlocks.INK_CAP_GREY_MUSHROOM_BLOCK)
                .add(MonstersGirlsBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK)

                .add(MonstersGirlsBlocks.GLOW_BERRY_BUSH);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_PLANKS)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_PLANKS)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_PLANKS)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STAIRS)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STAIRS)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STAIRS)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_SLAB)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_SLAB)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_SLAB)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_FENCE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE_GATE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE_GATE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_FENCE_GATE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_PRESSURE_PLATE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_PRESSURE_PLATE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_BUTTON)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_BUTTON)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_BUTTON)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_DOOR)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_DOOR)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_DOOR)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_TRAPDOOR)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_TRAPDOOR)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(MonstersGirlsBlocks.JAR)
                .add(MonstersGirlsBlocks.URN_MOLTEN)
                .add(MonstersGirlsBlocks.URN_CRIMSON)

                .add(MonstersGirlsBlocks.ENDER_MOSS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_BLOCK)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_BLOCK)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_BLOCK)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM)

                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE)

                .add(MonstersGirlsBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK)
                .add(MonstersGirlsBlocks.INK_CAP_GREY_MUSHROOM_BLOCK)
                .add(MonstersGirlsBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK)

                .add(MonstersGirlsBlocks.URN_MOLTEN)
                .add(MonstersGirlsBlocks.URN_CRIMSON)

                .add(MonstersGirlsBlocks.ENDER_MOSS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_STAIRS)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_STAIRS)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_SLAB)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_SLAB)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_SLAB);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE_GATE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE_GATE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_PRESSURE_PLATE)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_BUTTON)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_BUTTON)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_BUTTON);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_DOOR)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_DOOR)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(MonstersGirlsBlocks.ENDER_PUFFBALL_TRAPDOOR)
                .add(MonstersGirlsBlocks.MOLTEN_FUNGUS_TRAPDOOR)
                .add(MonstersGirlsBlocks.SOUL_WANDERER_TRAPDOOR);

    } // configure ()
    
} // Class MonstersGirlsBlockTagProvider