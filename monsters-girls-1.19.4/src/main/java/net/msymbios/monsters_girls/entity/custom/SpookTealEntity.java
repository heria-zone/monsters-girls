package net.msymbios.monsters_girls.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.msymbios.monsters_girls.effect.MonstersGirlsEffects;
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

public class SpookTealEntity extends InternalEntity implements GeoEntity  {

    // -- Variables --
    private final AnimatableInstanceCache  cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.ATTACK_DAMAGE))
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.ATTACK_SPEED))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.KNOCKBACK_RESISTANCE))
                .add(EntityAttributes.GENERIC_FLYING_SPEED, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.FLYING_SPEED))
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.FOLLOW_RANGE_MAX));
    } // setAttributes ()

    // -- Constructor --
    public SpookTealEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.category = EntityCategory.Spook;
        this.variant = EntityVariant.SpookTeal;
        this.canPlant = false;
    } // Constructor SpookTealEntity ()

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
        this.goalSelector.add(2, new FlyGoal(this, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.FLYING_SPEED)));
        this.goalSelector.add(3, new MeleeAttackGoal(this, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MOVEMENT_MELEE_ATTACK), false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MOVEMENT_SPEED), InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.FOLLOW_RANGE_MAX), InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.FOLLOW_RANGE_MIN), false));
        this.goalSelector.add(4, new TemptGoal(this, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MOVEMENT_SPEED), Ingredient.ofItems(new ItemConvertible[]{Items.SOUL_LANTERN}), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, InternalMetric.getAttribute(EntityVariant.SpookTeal, EntityAttribute.MOVEMENT_WANDER_AROUND)));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(6, new LookAtEntityGoal(this, InternalEntity.class, InternalMetric.LOOK_RANGE));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal(this, MobEntity.class, InternalMetric.ATTACK_CHANCE, false, false, InternalMetric.AvoidAttackingEntities));
        this.targetSelector.add(5, new UniversalAngerGoal(this, true));
    } // initGoals ()

    @Override
    public void onAttacking(Entity target) {
        super.onAttacking(target);
        //if (target instanceof LivingEntity _entity && !_entity.getWorld().isClient()) _entity.addStatusEffect(new StatusEffectInstance(MonstersGirlsEffects.SPOOKED, 200, 1));
        if (target instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 2));
    } // onAttacking ()

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) return false;

        if(source.getSource() instanceof ArrowEntity) return false;
        if(source.isOf(DamageTypes.FALL)) return false;
        if(source.isOf(DamageTypes.CACTUS)) return false;
        if(source.isOf(DamageTypes.DROWN)) return false;
        if(source.isOf(DamageTypes.LIGHTNING_BOLT)) return false;
        if(source.isOf(DamageTypes.EXPLOSION)) return false;
        if(source.isOf(DamageTypes.FALLING_ANVIL)) return false;
        if(source.isOf(DamageTypes.DRAGON_BREATH)) return false;
        if(source.isOf(DamageTypes.WITHER)) return false;
        if(isTamed()){
            if(source.getSource() instanceof PlayerEntity) return false;
        }

        return super.damage(source, amount);
    } // damage ()

    // -- Save
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, EntityVariant.SpookTeal.getName());
        this.dataTracker.startTracking(MODEL_ID, EntityModel.Spook.getId());
        this.dataTracker.startTracking(BELLY, true);
    } // initDataTracker ()

} // Class SpookTealEntity