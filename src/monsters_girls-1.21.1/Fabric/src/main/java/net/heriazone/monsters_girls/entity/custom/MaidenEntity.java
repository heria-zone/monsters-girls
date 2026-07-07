package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.FlyTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Maiden of the Skies entity implementation (Amplectobelua) — a powerful flying
 * tamable entity with GeckoLib animation support.</p>
 * <p>
 * <b>Behavior:</b> Flying entity that hunts Vex and Phantom mobs, follows its owner,
 * and uses aerial combat.
 * <p>
 * <b>Taming:</b> Accepts cookies via {@link MaidenFamily}'s FoodFeature.
 */
public class MaidenEntity extends FlyTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Maiden entity with the specified entity type and maiden variant.
     *
     * @param entityType the Minecraft EntityType for this maiden
     * @param level      the world/level this entity exists in
     * @param maidenType the MaidenFamily variant
     */
    public MaidenEntity(EntityType<? extends MaidenEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> maidenType) {
        super(entityType, level, maidenType);
    } // Constructor: MaidenEntity ()

} // Class: MaidenEntity
