package net.msymbios.monsters_girls.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.entity.enums.*;
import net.msymbios.monsters_girls.entity.internal.*;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.*;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class MandrakeBrownEntity extends InternalEntity implements GeoEntity {

    // -- Variables --
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // -- Properties --
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MAX_HEALTH))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.ATTACK_DAMAGE))
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.ATTACK_SPEED))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.MOVEMENT_SPEED))
                .add(EntityAttributes.GENERIC_ARMOR, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.ARMOR))
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, InternalMetric.getAttribute(EntityVariant.MandrakeBrown, EntityAttribute.ARMOR_TOUGHNESS));
    } // setAttributes ()

    // -- Constructor --
    public MandrakeBrownEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.category = EntityCategory.Mandrake;
        this.variant = EntityVariant.MandrakeBrown;
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

    @Override
    protected void handlePlanting (WorldAccess world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        if (entity.isOnGround()) {
            BlockPos blockPos = new BlockPos((int)x, (int)y, (int)z);
            if (world.isSpaceEmpty(new Box(blockPos))) {
                if ((world.getBlockState(new BlockPos((int)x, (int)y - 1, (int)z))).getBlock() == Blocks.GRASS_BLOCK) {
                    if (Math.random() < 0.0005) world.setBlockState(blockPos, MonstersGirlsBlocks.MANDRAKE_FLOWER.getDefaultState(), 3);
                }
            }
        }
    } // handlePlanting ()

    @Override
    protected void handleNegativeEffect(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null) return;
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1000, 1));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 1000, 2));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1000, 2));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1000, 2));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1000, 1));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 1000, 1));
        if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
            _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1000, 1));
    } // handleNegativeEffect ()

    @Override
    protected void handleEffect(Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null) return;
        if (entity instanceof TameableEntity _tamEnt && _tamEnt.isTamed()) {
            if (itemstack.isOf(Items.COOKIE)) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
                    _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10000, 1));
                if (!(sourceentity instanceof PlayerEntity player && player.getAbilities().creativeMode)) itemstack.decrement(1);
            }

            if (itemstack.isOf(Items.BONE_MEAL)) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
                    _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 10000, 1));
                if (!(sourceentity instanceof PlayerEntity player && player.getAbilities().creativeMode)) itemstack.decrement(1);
            }

            if (itemstack.isOf(Items.CLAY_BALL)) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
                    _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 10000, 1));
                if (!(sourceentity instanceof PlayerEntity player && player.getAbilities().creativeMode)) itemstack.decrement(1);
            }

            if (itemstack.isOf(Items.WATER_BUCKET)) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
                    _entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 10000, 2));
                if (!(sourceentity instanceof PlayerEntity player && player.getAbilities().creativeMode)) itemstack.decrement(1);
            }
        }
    } // handleEffect ()

    // -- Built-In Methods --
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, InternalMetric.MeleeAttackMovement, false));
        this.goalSelector.add(4, new FollowOwnerGoal(this, InternalMetric.FollowOwnerMovement, InternalMetric.FollowBehindDistance, InternalMetric.FollowCloseDistance, false));
        this.goalSelector.add(4, new TemptGoal(this, InternalMetric.MovementSpeed, Ingredient.ofItems(new ItemConvertible[]{Items.COOKIE}), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, InternalMetric.WanderAroundMovement));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, InternalMetric.LookAtRange));
        this.goalSelector.add(6, new LookAtEntityGoal(this, InternalEntity.class, InternalMetric.LookAtRange));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal(this, MobEntity.class, InternalMetric.AttackChance, false, false, InternalMetric.AvoidAttackingEntities));
        this.targetSelector.add(5, new UniversalAngerGoal(this, true));
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