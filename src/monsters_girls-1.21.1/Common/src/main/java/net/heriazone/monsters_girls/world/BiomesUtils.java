package net.heriazone.monsters_girls.world;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;

public class BiomesUtils {

    // -- Variables --

    public static final List<ResourceKey<Biome>> ConiferousBiomes = List.of(
            Biomes.TAIGA,
            Biomes.SNOWY_TAIGA,
            Biomes.OLD_GROWTH_PINE_TAIGA,
            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
            Biomes.WINDSWEPT_FOREST,
            Biomes.GROVE
    );

    public static final List<ResourceKey<Biome>> BirchForestBiomes = List.of(
            Biomes.BIRCH_FOREST,
            Biomes.OLD_GROWTH_BIRCH_FOREST
    );

    public static final List<ResourceKey<Biome>> JungleForestBiomes = List.of(
            Biomes.JUNGLE,
            Biomes.BAMBOO_JUNGLE,
            Biomes.SPARSE_JUNGLE
    );

    public static final List<ResourceKey<Biome>> ForestBiomesNoConiferous = List.of(
            Biomes.FOREST,
            Biomes.BIRCH_FOREST,
            Biomes.OLD_GROWTH_BIRCH_FOREST,
            Biomes.DARK_FOREST,
            Biomes.JUNGLE,
            Biomes.BAMBOO_JUNGLE,
            Biomes.SPARSE_JUNGLE,
            Biomes.CHERRY_GROVE,
            Biomes.FLOWER_FOREST
    );

    public static final List<ResourceKey<Biome>> ForestBiomes = List.of(
            Biomes.FOREST,
            Biomes.BIRCH_FOREST,
            Biomes.OLD_GROWTH_BIRCH_FOREST,
            Biomes.DARK_FOREST,
            Biomes.JUNGLE,
            Biomes.BAMBOO_JUNGLE,
            Biomes.SPARSE_JUNGLE,
            Biomes.CHERRY_GROVE,
            Biomes.FLOWER_FOREST,
            Biomes.TAIGA,
            Biomes.SNOWY_TAIGA,
            Biomes.OLD_GROWTH_PINE_TAIGA,
            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
            Biomes.WINDSWEPT_FOREST,
            Biomes.GROVE
    );

    // -- Nether biome groups --

    /** All nether biomes — used for broad nether spawn rules. */
    public static final List<ResourceKey<Biome>> NetherBiomes = List.of(
            Biomes.NETHER_WASTES,
            Biomes.CRIMSON_FOREST,
            Biomes.WARPED_FOREST,
            Biomes.SOUL_SAND_VALLEY,
            Biomes.BASALT_DELTAS
    );

    /** Crimson Forest only — home of the Crimson Gal. */
    public static final List<ResourceKey<Biome>> CrimsonForestBiomes = List.of(
            Biomes.CRIMSON_FOREST
    );

    /** Warped Forest only — home of the Warped Gal. */
    public static final List<ResourceKey<Biome>> WarpedForestBiomes = List.of(
            Biomes.WARPED_FOREST
    );

    /** Soul Sand Valley — home of the Soul Wanderer Gal. */
    public static final List<ResourceKey<Biome>> SoulSandValleyBiomes = List.of(
            Biomes.SOUL_SAND_VALLEY
    );

    // -- Snowy biome groups --

    /** Cold and snowy biomes — home of the Snowball Gal. */
    public static final List<ResourceKey<Biome>> SnowyBiomes = List.of(
            Biomes.ICE_SPIKES,
            Biomes.SNOWY_PLAINS,
            Biomes.SNOWY_TAIGA,
            Biomes.FROZEN_PEAKS,
            Biomes.JAGGED_PEAKS,
            Biomes.SNOWY_SLOPES
    );

    // -- End biome groups --

    /** End biomes — home of the Puffball Gal. */
    public static final List<ResourceKey<Biome>> EndBiomes = List.of(
            Biomes.THE_END,
            Biomes.END_HIGHLANDS,
            Biomes.END_MIDLANDS,
            Biomes.SMALL_END_ISLANDS,
            Biomes.END_BARRENS
    );

    // -- Methods --

    /**
     * Returns true if the biome is a coniferous (taiga/spruce) forest.
     *
     * @param biomeKey biome registry key
     * @return true if coniferous
     */
    public static boolean isConiferous(ResourceKey<Biome> biomeKey) {
        return ConiferousBiomes.contains(biomeKey);
    } // isConiferous ()

    /**
     * Returns true if the biome is a birch forest.
     *
     * @param biomeKey biome registry key
     * @return true if birch forest
     */
    public static boolean isBirchForest(ResourceKey<Biome> biomeKey) {
        return BirchForestBiomes.contains(biomeKey);
    } // isBirchForest ()

} // Class: BiomesUtils