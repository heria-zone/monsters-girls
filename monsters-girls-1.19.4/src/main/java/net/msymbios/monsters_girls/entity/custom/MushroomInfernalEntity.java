package net.msymbios.monsters_girls.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.entity.enums.EntityAttribute;
import net.msymbios.monsters_girls.entity.enums.EntityCategory;
import net.msymbios.monsters_girls.entity.enums.EntityModel;
import net.msymbios.monsters_girls.entity.enums.EntityVariant;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import net.msymbios.monsters_girls.entity.internal.InternalEntity;
import net.msymbios.monsters_girls.entity.internal.InternalMetric;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class MushroomInfernalEntity extends InternalEntity implements GeoEntity  {

    // -- Variables --
    private final AnimatableInstanceCache  cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.ATTACK_DAMAGE))
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.ATTACK_SPEED))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_FLYING_SPEED, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.FLYING_SPEED));
    } // setAttributes ()

    // -- Constructor --
    public MushroomInfernalEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.category = EntityCategory.Mushroom;
        this.variant = EntityVariant.MushroomInfernal;
    } // Constructor MushroomInfernalEntity ()

    // -- Inherited Methods --
    @Override
    public EntityView method_48926() {
        return this.getWorld();
    } // method_48926 ()

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegister) {
        controllerRegister.add(InternalAnimation.locomotionAnimation(this));
        controllerRegister.add(InternalAnimation.attackAnimation(this));
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache  getAnimatableInstanceCache() {
        return cache;
    } // getFactory ()

    // -- Built-In Methods --
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new FollowOwnerGoal(this, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.MOVEMENT_FOLLOW_OWNER), InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.FOLLOW_RANGE_MAX), InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.FOLLOW_RANGE_MIN), false));
        this.goalSelector.add(4, new MeleeAttackGoal(this, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.MOVEMENT_MELEE_ATTACK), false));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(6, new LookAtEntityGoal(this, InternalEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, InternalMetric.getAttribute(EntityVariant.MushroomInfernal, EntityAttribute.MOVEMENT_WANDER_AROUND)));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal(this, MobEntity.class, InternalMetric.ATTACK_CHANCE, false, false, InternalMetric.AvoidAttackingEntities));
        this.targetSelector.add(5, new UniversalAngerGoal(this, false));
    } // initGoals ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, EntityVariant.MushroomInfernal.getName());
        this.dataTracker.startTracking(MODEL_ID, EntityModel.Mushroom.getId());
        this.dataTracker.startTracking(BELLY, true);
    } // initDataTracker ()

} // Class MushroomInfernalEntity