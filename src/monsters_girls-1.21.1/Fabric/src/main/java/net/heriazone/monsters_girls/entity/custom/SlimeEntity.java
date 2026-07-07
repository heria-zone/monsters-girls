package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.WildTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Slime entity implementation — a ground-based tamable entity with GeckoLib
 * animation support.</p>
 * <p>
 * <b>Taming:</b> Accepts slime balls via {@link SlimeFamily}'s FoodFeature.
 */
public class SlimeEntity extends WildTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Slime entity with the specified entity type and slime variant.
     *
     * @param entityType the Minecraft EntityType for this slime
     * @param level      the world/level this entity exists in
     * @param slimeType  the SlimeFamily variant
     */
    public SlimeEntity(EntityType<? extends SlimeEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> slimeType) {
        super(entityType, level, slimeType);
    } // Constructor: SlimeEntity ()

} // Class: SlimeEntity