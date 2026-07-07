package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.FlyTamableEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.level.Level;

/**
 * <p>Wisp entity implementation — a flying tamable entity with Vex/Phantom hunting
 * behaviour, belly progression, and GeckoLib animations.</p>
 * <p>
 * <b>Combat:</b> Adds Vex and Phantom as nearest-attackable targets on top of the
 * base flying goal set; instantly kills them on a successful hit.
 * <p>
 * <b>Belly system:</b> Handled entirely by the base class via {@code BellyFeature} —
 * apple increments level, feather decrements. No override needed here; the family
 * declares the cap and the base class executes it.
 */
public class WispEntity extends FlyTamableEntity {

    // -- Constructors --

    public WispEntity(EntityType<? extends WispEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> wispType) {
        super(entityType, level, wispType);
    } // Constructor: WispEntity ()

    // -- AI Goals --

    /**
     * Extends the common flying goal set with Vex and Phantom hunting targets.
     */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Vex.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Phantom.class, false));
    } // registerGoals ()

    // -- Combat Behavior --

    /**
     * Instantly kills Vex and Phantom targets; falls back to normal damage otherwise.
     */
    @Override
    public boolean doHurtTarget(Entity target) {
        if (target instanceof Vex || target instanceof Phantom) {
            target.kill();
            return true;
        }
        return super.doHurtTarget(target);
    } // doHurtTarget ()

} // Class: WispEntity