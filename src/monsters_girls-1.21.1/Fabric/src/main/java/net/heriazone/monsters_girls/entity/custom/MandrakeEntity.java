package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.WildTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * <p>Mandrake entity implementation extending MonsterEntity from HZLib, providing
 * flying monster behavior with belly progression system and GeckoLib animation support.</p>
 * <p>
 * <b>Behavior:</b> Flying tamable entity that attacks Vex and Phantom entities,
 * supports belly progression through feeding, and uses GeckoLib for animations.
 * <p>
 * <b>Combat:</b> Specializes in aerial combat with moderate health and mobility,
 * automatically targets hostile flying entities like Vex and Phantom.
 * <p>
 * <b>Feeding:</b> Accepts gold-based items (nuggets, ingots, raw gold) for belly
 * progression, with texture changes based on belly state.
 */
public class MandrakeEntity extends WildTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Mandrake entity with the specified entity type and mandrake variant.
     *
     * @param entityType the Minecraft EntityType for this mandrake
     * @param mandrakeType the MandrakeFamily variant (green, blue, yellow)
     * @param level the world/level this entity exists in
     */
    public MandrakeEntity(EntityType<? extends MandrakeEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> mandrakeType) {
        super(entityType, level, mandrakeType);
    } // Constructor: MandrakeEntity ()

} // Class: MandrakeEntity