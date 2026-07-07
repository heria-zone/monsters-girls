package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.FlyTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Bee entity implementation — a flying tamable entity with belly progression
 * and GeckoLib animation support.</p>
 * <p>
 * <b>Behavior:</b> Flying entity that follows its owner, wanders when idle,
 * and retaliates when attacked.
 * <p>
 * <b>Taming:</b> Accepts honeycomb and honey bottles via {@link BeeFamily}'s FoodFeature.
 */
public class BeeEntity extends FlyTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Bee entity with the specified entity type and bee variant.
     *
     * @param entityType the Minecraft EntityType for this bee
     * @param level      the world/level this entity exists in
     * @param beeType    the BeeFamily variant
     */
    public BeeEntity(EntityType<? extends BeeEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> beeType) {
        super(entityType, level, beeType);
    } // Constructor: BeeEntity ()

} // Class: BeeEntity