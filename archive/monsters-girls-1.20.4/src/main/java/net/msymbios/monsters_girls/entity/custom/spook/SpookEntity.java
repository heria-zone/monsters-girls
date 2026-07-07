package net.msymbios.monsters_girls.entity.custom.spook;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.common.entity.custom.FlyingTamableEntity;
import net.msymbios.monsters_girls.common.entity.InternalAnimation;
import net.msymbios.monsters_girls.entity.internal.SpookVariant;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

import java.util.function.Predicate;

public abstract class SpookEntity extends FlyingTamableEntity implements GeoEntity {

    // -- Variables --

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE = entity -> {
        EntityType<?> entityType = entity.getType();
        return entityType == EntityType.PLAYER;
    };

    // -- Constructor --

    public SpookEntity(EntityType<? extends SpookEntity> entityType, World world) {
        super(entityType, world);
    } // Constructor SpookEntity ()

    // -- Inherited Methods --

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar  controllerRegister) {
        controllerRegister.add(InternalAnimation.locomotionAnimation(this));
        controllerRegister.add(InternalAnimation.attackAnimation(this));
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; } // getFactory ()

    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof VexEntity || target instanceof PhantomEntity) {
            target.kill();
            onAttacking(target);
            return true;
        } else return super.tryAttack(target);
    } // tryAttack ()

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(3, new AttackGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.add(6, new LookAtEntityGoal(this, MobEntity.class, 8F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(1, new AttackWithOwnerGoal(this));
        this.targetSelector.add(2, new UntamedActiveTargetGoal<>(this, PlayerEntity.class, false, FOLLOW_TAMED_PREDICATE));
        this.targetSelector.add(3, new RevengeGoal(this));
    } // initGoals ()

    // -- Custom Methods --

    /**
     * @return the additional attributes to add to the entity.
     */
    public static DefaultAttributeContainer createAttributes(SpookVariant variant) {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, variant.getMaxHealth())
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, variant.getAttackDamage())
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, variant.getAttackSpeed())
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, variant.getMoveSpeed())
                .add(EntityAttributes.GENERIC_FLYING_SPEED, variant.getMoveSpeed())
                .add(EntityAttributes.GENERIC_ARMOR, variant.getArmour())
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, variant.getArmourToughness())
                .build();
    } // createAttributes ()

} // Class SpookEntity