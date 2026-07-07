package net.msymbios.monsters_girls.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

public class MandrakeBrownEntity extends InternalEntity implements GeoEntity {

    // -- Variables --
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.KNOCKBACK_RESISTANCE))
                .add(EntityAttributes.GENERIC_FLYING_SPEED, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.FLYING_SPEED));
    } // setAttributes ()

    // -- Constructor --
    public MandrakeBrownEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.category = EntityCategory.Mandrake;
        this.variant = EntityVariant.MandrakeBrown;
        this.hasEffects = true;
    } // Constructor MandrakeBrownEntity ()

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
        this.goalSelector.add(3, new FollowOwnerGoal(this, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MOVEMENT_FOLLOW_OWNER), InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.FOLLOW_RANGE_MAX), InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.FOLLOW_RANGE_MIN), false));
        this.goalSelector.add(4, new TemptGoal(this, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MOVEMENT_SPEED), Ingredient.ofItems(new ItemConvertible[]{Items.COOKIE}), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MOVEMENT_WANDER_AROUND)));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(6, new LookAtEntityGoal(this, InternalEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(7, new LookAroundGoal(this));
    } // initGoals ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, EntityVariant.MandrakeBrown.getName());
        this.dataTracker.startTracking(MODEL_ID, EntityModel.Mandrake.getId());
        this.dataTracker.startTracking(BELLY, true);
    } // initDataTracker ()

} // Class MandrakeBrownEntity