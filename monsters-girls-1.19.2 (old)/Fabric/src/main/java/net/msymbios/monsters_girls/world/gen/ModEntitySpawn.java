package net.msymbios.monsters_girls.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.msymbios.monsters_girls.entity.ModEntities;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.enums.*;
import net.msymbios.monsters_girls.entity.internal.InternalMetric;

public class ModEntitySpawn {

    // -- Methods --
    public static void register() {
        // BIOMES MODIFICATION
        registerSpawnBiomes(EntityVariant.MandrakeGreen, ModEntities.MANDRAKE_GIRL_GREEN);
        registerSpawnBiomes(EntityVariant.MandrakeBrown, ModEntities.MANDRAKE_GIRL_BROWN);
        registerSpawnBiomes(EntityVariant.MandrakeGlowBerry, ModEntities.MANDRAKE_GIRL_GLOW_BERRY);
        registerSpawnBiomes(EntityVariant.MandrakeChorus, ModEntities.MANDRAKE_GIRL_CHORUS);

        registerSpawnBiomes(EntityVariant.MushroomAmanitaYellow, ModEntities.MUSHROOM_GIRL_AMANITA_YELLOW);
        registerSpawnBiomes(EntityVariant.MushroomBrown, ModEntities.MUSHROOM_GIRL_BROWN);
        registerSpawnBiomes(EntityVariant.MushroomCrimson, ModEntities.MUSHROOM_GIRL_CRIMSON);
        registerSpawnBiomes(EntityVariant.MushroomCrimsonRare, ModEntities.MUSHROOM_GIRL_CRIMSON_RARE);
        registerSpawnBiomes(EntityVariant.MushroomEnderPuffball, ModEntities.MUSHROOM_GIRL_ENDER_PUFFBALL);
        registerSpawnBiomes(EntityVariant.MushroomInfernal, ModEntities.MUSHROOM_GIRL_INFERNAL);
        registerSpawnBiomes(EntityVariant.FungusInkCap, ModEntities.MUSHROOM_GIRL_INK_CAP);
        registerSpawnBiomes(EntityVariant.MushroomMolten, ModEntities.MUSHROOM_GIRL_MOLTEN);
        registerSpawnBiomes(EntityVariant.MushroomFlyAgaric, ModEntities.MUSHROOM_GIRL_FLY_AGARIC);
        registerSpawnBiomes(EntityVariant.MushroomSoulWanderer, ModEntities.MUSHROOM_GIRL_SOUL_WANDERER);
        registerSpawnBiomes(EntityVariant.MushroomWarped, ModEntities.MUSHROOM_GIRL_WARPED);
        registerSpawnBiomes(EntityVariant.MushroomWarpedRare, ModEntities.MUSHROOM_GIRL_WARPED_RARE);
        registerSpawnBiomes(EntityVariant.MushroomSnowball, ModEntities.MUSHROOM_GIRL_SNOWBALL);

        registerSpawnBiomes(EntityVariant.SpookTeal, ModEntities.SPOOK_GIRL_TEAL);
        registerSpawnBiomes(EntityVariant.SpookPeach, ModEntities.SPOOK_GIRL_PEACH);

        registerSpawnBiomes(EntityVariant.WispBlue, ModEntities.WISP_GIRL_BLUE);
        registerSpawnBiomes(EntityVariant.WispGreen, ModEntities.WISP_GIRL_GREEN);
        registerSpawnBiomes(EntityVariant.WispYellow, ModEntities.WISP_GIRL_YELLOW);

        // SPAWN RESTRICTION
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeGreenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeBrownEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_GLOW_BERRY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeGlowBerryEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MANDRAKE_GIRL_CHORUS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeChorusEntity::isValidNaturalSpawn);

        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_AMANITA_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomAmanitaYellowEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomBrownEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_CRIMSON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomCrimsonEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_CRIMSON_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomCrimsonRareEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_ENDER_PUFFBALL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomEnderPuffballEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_INFERNAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomInfernalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_INK_CAP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomInkCapEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_MOLTEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomMoltenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_FLY_AGARIC, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomFlyAgaricEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_SOUL_WANDERER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomSoulWandererEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_WARPED, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomWarpedEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_WARPED_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomWarpedRareEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.MUSHROOM_GIRL_SNOWBALL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomSnowballEntity::isValidNaturalSpawn);

        SpawnRestriction.register(ModEntities.SPOOK_GIRL_TEAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpookTealEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SPOOK_GIRL_PEACH, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpookPeachEntity::isValidNaturalSpawn);

        SpawnRestriction.register(ModEntities.WISP_GIRL_BLUE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispBlueEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.WISP_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispGreenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.WISP_GIRL_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispYellowEntity::isValidNaturalSpawn);
    } // register ()

    private static void registerSpawnBiomes(EntityVariant variant, EntityType<?> entityType) {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(InternalMetric.SETTINGS.get(variant).get(EntitySetting.BiomesSelector).getBiomesListValue()),
                SpawnGroup.CREATURE,
                entityType,
                InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnWeight).getIntValue(),
                InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnMinGroup).getIntValue(),
                InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnMaxGroup).getIntValue());
    } // registry ()

} // Class ModEntitySpawn