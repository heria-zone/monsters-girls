package net.msymbios.monsters_girls.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.msymbios.monsters_girls.world.feature.ModPlacedFeatures;

public class ModFlowerGeneration {

    // -- Method --
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.THE_END), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ENDER_PUFFBALL.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ENDER_PUFFBALL.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.INK_CAP_MUSHROOM.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.INK_CAP_MUSHROOM.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOLTEN_FUNGUS.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOLTEN_FUNGUS.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MANDRAKE_FLOWER.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_WANDERER_FUNGUS.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_WANDERER_FUNGUS.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.GLOW_BERRY_BUSH.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ENDER_PUFFBALL.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOLTEN_FUNGUS.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_WANDERER_FUNGUS.getKey().get());
    } // generateFlowers ()

} // Class ModFlowerGeneration