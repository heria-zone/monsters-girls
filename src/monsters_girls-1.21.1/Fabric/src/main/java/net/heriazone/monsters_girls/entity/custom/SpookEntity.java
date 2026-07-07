package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.FlyTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Spook entity implementation — a flying tamable entity with belly progression
 * and GeckoLib animation support.</p>
 * <p>
 * <b>Behavior:</b> Flying entity that follows its owner, wanders when idle,
 * and retaliates when attacked.
 * <p>
 * <b>Belly system:</b> Handled entirely by the base class via {@link net.heriazone.monsters_girls.entity.feature.BellyFeature} —
 * apple increments belly level, feather decrements. The family declares SLIM and TUMMY
 * caps per color; the base class executes the progression. No override needed here.
 */
public class SpookEntity extends FlyTamableEntity {

    // -- Constructors --

    public SpookEntity(EntityType<? extends SpookEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> spookType) {
        super(entityType, level, spookType);
    } // Constructor: SpookEntity ()

} // Class: SpookEntity