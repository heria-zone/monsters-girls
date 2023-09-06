package net.msymbios.monsters_girls.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.msymbios.monsters_girls.entity.ModEntities;

import java.util.ArrayList;
import java.util.List;

public class ModEntitySpawn {

    // -- Methods --
    public static void register() {
        registerSpawn(new ArrayList<>(List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST)), ModEntities.MANDRAKE_GIRL_GREEN, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST)), ModEntities.MANDRAKE_GIRL_BROWN, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);


        registerSpawn(new ArrayList<>(List.of(BiomeKeys.LUSH_CAVES)), ModEntities.MANDRAKE_GIRL_GLOW_BERRY, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_GLOW_BERRY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS)), ModEntities.MANDRAKE_GIRL_CHORUS, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_CHORUS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);


        registerSpawn(new ArrayList<>(List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA)), ModEntities.MUSHROOM_GIRL_BROWN, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.CRIMSON_FOREST)), ModEntities.MUSHROOM_GIRL_CRIMSON, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_CRIMSON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.CRIMSON_FOREST)), ModEntities.MUSHROOM_GIRL_CRIMSON_RARE, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_CRIMSON_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS)), ModEntities.MUSHROOM_GIRL_ENDER_PUFFBALL, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_ENDER_PUFFBALL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.NETHER_WASTES)), ModEntities.MUSHROOM_GIRL_INFERNAL, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_INFERNAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.FOREST, BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST)), ModEntities.MUSHROOM_GIRL_INK_CAP, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_INK_CAP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.BASALT_DELTAS)), ModEntities.MUSHROOM_GIRL_MOLTEN, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_MOLTEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.TAIGA)), ModEntities.MUSHROOM_GIRL_FLY_AGARIC, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_FLY_AGARIC, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.SOUL_SAND_VALLEY)), ModEntities.MUSHROOM_GIRL_SOUL_WANDERER, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_SOUL_WANDERER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.WARPED_FOREST)), ModEntities.MUSHROOM_GIRL_WARPED, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_WARPED, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.WARPED_FOREST)), ModEntities.MUSHROOM_GIRL_WARPED_RARE, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_WARPED_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)), ModEntities.MUSHROOM_GIRL_AMANITA_YELLOW, 15, 1, 1);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_AMANITA_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);


        registerSpawn(new ArrayList<>(List.of(BiomeKeys.DARK_FOREST, BiomeKeys.FOREST)), ModEntities.SPOOK_GIRL_TEAL, 15, 1, 1);
        SpawnRestriction.register(ModEntities.SPOOK_GIRL_TEAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.DARK_FOREST, BiomeKeys.FOREST)), ModEntities.SPOOK_GIRL_PEACH, 15, 1, 1);
        SpawnRestriction.register(ModEntities.SPOOK_GIRL_PEACH, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);


        registerSpawn(new ArrayList<>(List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP)), ModEntities.WISP_GIRL_BLUE, 15, 1, 1);
        SpawnRestriction.register(ModEntities.WISP_GIRL_BLUE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP)), ModEntities.WISP_GIRL_GREEN, 15, 1, 1);
        SpawnRestriction.register(ModEntities.WISP_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        registerSpawn(new ArrayList<>(List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP)), ModEntities.WISP_GIRL_YELLOW, 15, 1, 1);
        SpawnRestriction.register(ModEntities.WISP_GIRL_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

    } // register ()

    private static void registerSpawn (List<RegistryKey<Biome>> biomes, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(biomes), SpawnGroup.CREATURE, entityType, weight, minGroupSize, maxGroupSize);
    } // registerSpawn ()

} // Class ModEntitySpawn