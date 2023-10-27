package net.msymbios.monsters_girls.world.internal;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.enums.EntitySetting;
import net.msymbios.monsters_girls.entity.enums.EntityVariant;
import net.msymbios.monsters_girls.entity.internal.InternalMetric;

import java.util.Calendar;
import java.util.List;

public class MonstersGirlsSpawn {

    // -- Methods --
    public static void generate () {
        // BIOMES MODIFICATION
        if(Calendar.getInstance().get(Calendar.MONTH) == Calendar.OCTOBER) {
            registerSpawnBiomes(EntityVariant.JackOLantern, MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN);
            registerSpawnBiomes(EntityVariant.JackOLanternBig, MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_BIG);
            registerSpawnBiomes(EntityVariant.JackOLanternMini, MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_MINI);

            SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraJackOLanternEntity::isValidNaturalSpawn);
            SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_BIG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraJackOLanternBigEntity::isValidNaturalSpawn);
            SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_MINI, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraJackOLanternMiniEntity::isValidNaturalSpawn);
        }

        registerSpawnBiomes(EntityVariant.Pumpkin, MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN);
        registerSpawnBiomes(EntityVariant.PumpkinBig, MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_BIG);
        registerSpawnBiomes(EntityVariant.PumpkinMini, MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_MINI);

        registerSpawnBiomes(EntityVariant.MandrakeGreen, MonstersGirlsEntities.MANDRAKE_GIRL_GREEN);
        registerSpawnBiomes(EntityVariant.MandrakeBrown, MonstersGirlsEntities.MANDRAKE_GIRL_BROWN);
        registerSpawnBiomes(EntityVariant.MandrakeGlowBerry, MonstersGirlsEntities.MANDRAKE_GIRL_GLOW_BERRY);
        registerSpawnBiomes(EntityVariant.MandrakeChorus, MonstersGirlsEntities.MANDRAKE_GIRL_CHORUS);

        registerSpawnBiomes(EntityVariant.MushroomFlyAgaricYellow, MonstersGirlsEntities.MUSHROOM_GIRL_AMANITA_YELLOW);
        registerSpawnBiomes(EntityVariant.MushroomBrown, MonstersGirlsEntities.MUSHROOM_GIRL_BROWN);
        registerSpawnBiomes(EntityVariant.MushroomCrimson, MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON);
        registerSpawnBiomes(EntityVariant.MushroomCrimsonRare, MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON_RARE);
        registerSpawnBiomes(EntityVariant.MushroomEnderPuffball, MonstersGirlsEntities.MUSHROOM_GIRL_ENDER_PUFFBALL);
        registerSpawnBiomes(EntityVariant.MushroomInfernal, MonstersGirlsEntities.MUSHROOM_GIRL_INFERNAL);
        registerSpawnBiomes(EntityVariant.FungusInkCap, MonstersGirlsEntities.MUSHROOM_GIRL_INK_CAP);
        registerSpawnBiomes(EntityVariant.MushroomMolten, MonstersGirlsEntities.MUSHROOM_GIRL_MOLTEN);
        registerSpawnBiomes(EntityVariant.MushroomFlyAgaricRed, MonstersGirlsEntities.MUSHROOM_GIRL_FLY_AGARIC);
        registerSpawnBiomes(EntityVariant.MushroomSoulWanderer, MonstersGirlsEntities.MUSHROOM_GIRL_SOUL_WANDERER);
        registerSpawnBiomes(EntityVariant.MushroomWarped, MonstersGirlsEntities.MUSHROOM_GIRL_WARPED);
        registerSpawnBiomes(EntityVariant.MushroomWarpedRare, MonstersGirlsEntities.MUSHROOM_GIRL_WARPED_RARE);
        registerSpawnBiomes(EntityVariant.MushroomSnowball, MonstersGirlsEntities.MUSHROOM_GIRL_SNOWBALL);

        registerSpawnBiomes(EntityVariant.Slime, MonstersGirlsEntities.SLIME_GIRL);

        registerSpawnBiomes(EntityVariant.SpookTeal, MonstersGirlsEntities.SPOOK_GIRL_TEAL);
        registerSpawnBiomes(EntityVariant.SpookPeach, MonstersGirlsEntities.SPOOK_GIRL_PEACH);

        registerSpawnBiomes(EntityVariant.WispBlue, MonstersGirlsEntities.WISP_GIRL_BLUE);
        registerSpawnBiomes(EntityVariant.WispGreen, MonstersGirlsEntities.WISP_GIRL_GREEN);
        registerSpawnBiomes(EntityVariant.WispYellow, MonstersGirlsEntities.WISP_GIRL_YELLOW);

        // SPAWN RESTRICTION
        SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraPumpkinEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_BIG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraPumpkinBigEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_MINI, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GourdragoraPumpkinMiniEntity::isValidNaturalSpawn);

        SpawnRestriction.register(MonstersGirlsEntities.MANDRAKE_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeGreenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MANDRAKE_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeBrownEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MANDRAKE_GIRL_GLOW_BERRY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeGlowBerryEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MANDRAKE_GIRL_CHORUS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MandrakeChorusEntity::isValidNaturalSpawn);

        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_AMANITA_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomFlyAgaricYellowEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_BROWN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomBrownEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomCrimsonEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomCrimsonRareEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_ENDER_PUFFBALL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomEnderPuffballEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_INFERNAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomInfernalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_INK_CAP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomInkCapEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_MOLTEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomMoltenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_FLY_AGARIC, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomFlyAgaricRedEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_SOUL_WANDERER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomSoulWandererEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_WARPED, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomWarpedEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_WARPED_RARE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomWarpedRareEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.MUSHROOM_GIRL_SNOWBALL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MushroomSnowballEntity::isValidNaturalSpawn);

        SpawnRestriction.register(MonstersGirlsEntities.SLIME_GIRL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SlimeGirlEntity::isValidNaturalSpawn);

        SpawnRestriction.register(MonstersGirlsEntities.SPOOK_GIRL_TEAL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpookTealEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.SPOOK_GIRL_PEACH, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpookPeachEntity::isValidNaturalSpawn);

        SpawnRestriction.register(MonstersGirlsEntities.WISP_GIRL_BLUE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispBlueEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.WISP_GIRL_GREEN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispGreenEntity::isValidNaturalSpawn);
        SpawnRestriction.register(MonstersGirlsEntities.WISP_GIRL_YELLOW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WispYellowEntity::isValidNaturalSpawn);
    } // generate ()

    private static void registerSpawnBiomes(EntityVariant variant, EntityType<?> entityType) {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey((List<RegistryKey<Biome>>)InternalMetric.SETTINGS.get(variant).get(EntitySetting.BiomesSelector).getValue()),
                SpawnGroup.CREATURE,
                entityType,
                (int)InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnWeight).getValue(),
                (int)InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnMinGroup).getValue(),
                (int)InternalMetric.SETTINGS.get(variant).get(EntitySetting.SpawnMaxGroup).getValue());
    } // registry ()

} // Class MonstersGirlsSpawn