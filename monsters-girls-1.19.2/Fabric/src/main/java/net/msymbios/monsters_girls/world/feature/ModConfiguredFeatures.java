package net.msymbios.monsters_girls.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.block.ModBlocks;

public class ModConfiguredFeatures {

    // -- Variables --
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ENDER_PUFFBALL =
            register("mushroom_ender_puffball", Feature.FLOWER, 1, Feature.SIMPLE_BLOCK, ModBlocks.ENDER_PUFFBALL);

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> INK_CAP_MUSHROOM =
            register("mushroom_ink_cap", Feature.FLOWER, 1, Feature.SIMPLE_BLOCK, ModBlocks.INK_CAP_MUSHROOM);

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MOLTEN_FUNGUS =
            register("mushroom_molten_fungus", Feature.FLOWER, 1, Feature.SIMPLE_BLOCK, ModBlocks.MOLTEN_FUNGUS);

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MANDRAKE =
            register("flower_mandrake", Feature.FLOWER, 2, Feature.SIMPLE_BLOCK, ModBlocks.MANDRAKE);

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SOUL_WANDERER_FUNGUS =
            register("mushroom_soul_wanderer_fungus", Feature.FLOWER, 1, Feature.SIMPLE_BLOCK, ModBlocks.SOUL_WANDERER_FUNGUS);

    public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> HUGE_ENDER_PUFFBALL =
            ConfiguredFeatures.register("huge_ender_puffball_planted",
                    Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                            ModBlocks.ENDER_PUFFBALL_BLOCK.getDefaultState(),
                            ModBlocks.ENDER_PUFFBALL_STEM.getDefaultState(),
                            ModBlocks.ENDER_PUFFBALL_BLOCK.getDefaultState(),
                            ModBlocks.ENDER_SHROOMLIGHT.getDefaultState(), true));
    public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> HUGE_MOLTEN_FUNGUS =
            ConfiguredFeatures.register("huge_molten_fungus_planted",
                    Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                            ModBlocks.MOLTEN_FUNGUS_BLOCK.getDefaultState(),
                            ModBlocks.MOLTEN_FUNGUS_STEM.getDefaultState(),
                            ModBlocks.MOLTEN_FUNGUS_BLOCK.getDefaultState(),
                            ModBlocks.MOLTEN_SHROOMLIGHT.getDefaultState(), true));
    public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> HUGE_INK_CAP =
            ConfiguredFeatures.register("huge_ink_cap_planted",
                    Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                            ModBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK.getDefaultState(),
                            Blocks.MUSHROOM_STEM.getDefaultState(),
                            ModBlocks.INK_CAP_GREY_MUSHROOM_BLOCK.getDefaultState(),
                            ModBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK.getDefaultState(), true));
    public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> HUGE_SOUL_WANDERER_FUNGUS =
            ConfiguredFeatures.register("huge_soul_wanderer_planted",
                    Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(
                            ModBlocks.SOUL_WANDERER_BLOCK.getDefaultState(),
                            ModBlocks.SOUL_WANDERER_STEM.getDefaultState(),
                            ModBlocks.SOUL_WANDERER_BLOCK.getDefaultState(),
                            ModBlocks.SOUL_SHROOMLIGHT.getDefaultState(), true));

    // -- Methods --
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> register (String name, Feature<RandomPatchFeatureConfig> feature, int tries, Feature<SimpleBlockFeatureConfig> featurePlaced, Block block) {
        return ConfiguredFeatures.register(name, feature, ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(featurePlaced, new SimpleBlockFeatureConfig(BlockStateProvider.of(block)))));
    } // register ()

    public static void registerConfiguredFeatures() {
        MonstersGirlsMod.LOGGER.debug("Registering the Configured Features for " + MonstersGirlsMod.MODID);
    } // registerConfiguredFeatures ()

} // Class ModConfiguredFeatures