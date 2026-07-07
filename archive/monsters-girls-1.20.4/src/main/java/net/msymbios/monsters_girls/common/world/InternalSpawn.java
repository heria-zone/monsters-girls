package net.msymbios.monsters_girls.common.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.msymbios.monsters_girls.common.entity.InternalEntityType;

/**
 * This class handles the registration of entity types.
 */
public class InternalSpawn {

    // -- Methods --

    /**
     * Registers the entity type with the specified variant, entity type, spawn group, predicate, location, and heightmap.
     *
     * @param variant   the internal entity type variant.
     * @param entityType the entity type to register.
     * @param predicate the spawn predicate for the entity type.
     */
    protected static<T extends MobEntity> void register(InternalEntityType<?> variant, EntityType<T> entityType, SpawnRestriction.SpawnPredicate<T> predicate) {
        register(variant, entityType, SpawnGroup.CREATURE, predicate, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES);
    } // register ()

    /**
     * Registers the entity type with the specified variant, entity type, spawn group, predicate, location, and heightmap.
     *
     * @param variant   the internal entity type variant.
     * @param entityType the entity type to register.
     * @param group     the spawn group for the entity type.
     * @param predicate the spawn predicate for the entity type.
     * @param location  the spawn location for the entity type.
     * @param heightmap the heightmap type for the entity type.
     */
    protected static<T extends MobEntity> void register(InternalEntityType<?> variant, EntityType<T> entityType, SpawnGroup group, SpawnRestriction.SpawnPredicate<T> predicate, SpawnRestriction.Location location, Heightmap.Type heightmap) {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(variant.spawnBiomes), group, entityType, variant.spawnWeight, variant.spawnMinGroup, variant.spawnMaxGroup);
        SpawnRestriction.register(entityType, location, heightmap, predicate);
    } // register ()

} // Class InternalSpawn