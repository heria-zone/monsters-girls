package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.FlyTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Globberie entity implementation — a flying tamable entity with slim/normal/tummy
 * belly progression and GeckoLib animation support.</p>
 * <p>
 * <b>Behavior:</b> Flying entity that follows its owner, wanders when idle,
 * and retaliates when attacked.
 * <p>
 * <b>Taming:</b> Accepts slime balls via {@link GlobberieFamily}'s FoodFeature.
 */
public class GlobberieEntity extends FlyTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Globberie entity with the specified entity type and globberie variant.
     *
     * @param entityType    the Minecraft EntityType for this globberie
     * @param level         the world/level this entity exists in
     * @param globberieType the GlobberieFamily variant
     */
    public GlobberieEntity(EntityType<? extends GlobberieEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> globberieType) {
        super(entityType, level, globberieType);
    } // Constructor: GlobberieEntity ()

} // Class: GlobberieEntity