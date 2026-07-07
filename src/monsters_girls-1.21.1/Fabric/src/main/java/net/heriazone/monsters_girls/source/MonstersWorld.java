package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.heriazone.hzlib.api.entity.features.SpawnFeature;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.custom.BeeFamily;
import net.heriazone.monsters_girls.entity.custom.GlobberieFamily;
import net.heriazone.monsters_girls.entity.custom.GourdragoraFamily;
import net.heriazone.monsters_girls.entity.custom.MaidenFamily;
import net.heriazone.monsters_girls.entity.custom.MandrakeFamily;
import net.heriazone.monsters_girls.entity.custom.MushroomFamily;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Calendar;

public class MonstersWorld {

    // -- Methods --

    public static void register() {
        generateSpawn();
    } // register ()

    private static void generateSpawn() {
        // -- Overworld mushroom gals --
        registerSpawn(MonstersEntities.MUSHROOM_AMANITA,  MushroomFamily.AMANITA);
        registerSpawn(MonstersEntities.MUSHROOM_BROWN,    MushroomFamily.BROWN);
        // -- Nether mushroom gals --
        registerSpawn(MonstersEntities.MUSHROOM_INFERNAL, MushroomFamily.INFERNAL);
        registerSpawn(MonstersEntities.MUSHROOM_CRIMSON,  MushroomFamily.CRIMSON);
        registerSpawn(MonstersEntities.MUSHROOM_WARPED,   MushroomFamily.WARPED);
        registerSpawn(MonstersEntities.MUSHROOM_MOLTEN,   MushroomFamily.MOLTEN);
        registerSpawn(MonstersEntities.MUSHROOM_SOUL_WANDERER, MushroomFamily.SOUL_WANDERER);
        // -- Snowy mushroom gals --
        registerSpawn(MonstersEntities.MUSHROOM_SNOWBALL, MushroomFamily.SNOWBALL);
        // -- End mushroom gals --
        registerSpawn(MonstersEntities.MUSHROOM_PUFFBALL, MushroomFamily.PUFFBALL);
        // -- Inkcaps: genesis-only, no natural spawn --

        // -- Gourdragora --
        registerSpawn(MonstersEntities.GOURDRAGORA_GOLDEN, GourdragoraFamily.GOLDEN);
        registerSpawn(MonstersEntities.GOURDRAGORA_LUMINA, GourdragoraFamily.LUMINA);
        if(Calendar.getInstance().get(Calendar.MONTH) == Calendar.OCTOBER) registerSpawn(MonstersEntities.GOURDRAGORA_JACKO, GourdragoraFamily.JACKO);

        // -- Mandrake --
        registerSpawn(MonstersEntities.MANDRAKE_CHORUS, MandrakeFamily.CHORUS);
        registerSpawn(MonstersEntities.MANDRAKE_FLOWER, MandrakeFamily.FLOWER);
        registerSpawn(MonstersEntities.MANDRAKE_FRUCTUS, MandrakeFamily.FRUCTUS);

        // -- Bee — all forest biomes (overworld) --
        registerSpawn(MonstersEntities.BEE_HONEY, BeeFamily.HONEY);

        // -- Globberie — all End biomes --
        registerSpawn(MonstersEntities.GLOBBERIE, GlobberieFamily.GLOBBERIE);

        // -- Maiden of the Skies — all End biomes (defined in MaidenFamily) --
        registerSpawn(MonstersEntities.MAIDEN, MaidenFamily.DEFAULT);
    } // generateSpawn ()

    private static void registerSpawn(EntityType<? extends Mob> entityType, MonstersFamily<? extends MonstersFamily<?>> nativeEntity) {
        if (!nativeEntity.hasFeature(SpawnFeature.class)) return;
        nativeEntity.getFeature(SpawnFeature.class).ifPresent(spawn -> {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(spawn.getBiomes()),
                    spawn.getCategory(),
                    entityType,
                    spawn.getWeight(), spawn.getMinGroupSize(), spawn.getMaxGroupSize()
            );

            if (spawn.hasPlacement())
                registerPlacement(entityType, spawn.getPlacement(), spawn.getHeightmap(), spawn.getSpawnPredicate());
        });
    } // registerSpawn ()

    @SuppressWarnings("unchecked")
    private static <T extends Mob> void registerPlacement(EntityType<T> entityType, SpawnPlacementType placement, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<?> predicate) {
        SpawnPlacements.register(entityType, placement, heightmap, (SpawnPlacements.SpawnPredicate<T>) predicate);
    } // registerPlacement ()

} // Class: MonstersWorld