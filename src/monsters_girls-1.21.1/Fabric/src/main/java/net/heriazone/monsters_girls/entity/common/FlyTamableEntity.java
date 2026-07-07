package net.heriazone.monsters_girls.entity.common;

import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;

public class FlyTamableEntity extends WildTamableEntity {

    // -- Constructors --

    /**
     * Creates a new Spook entity with the specified entity type and spook variant.
     *
     * @param entityType the Minecraft EntityType for this spook
     * @param nativeType the NativeEntity
     * @param level the world/level this entity exists in
     */
    public FlyTamableEntity(EntityType<? extends FlyTamableEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> nativeType) {
        super(entityType, level, nativeType);

        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new LookControl(this);

        this.setPathfindingMalus(PathType.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(PathType.COCOA, -1.0F);
        this.setPathfindingMalus(PathType.FENCE, -1.0F);
    } // Constructor: FlyTamableEntity ()

    // -- AI Goals --

    /**
     * Overrides ground wander goal with the flying variant.
     * <p>
     * <b>Speed contract:</b> Goal speed parameters are multipliers applied on top of
     * the entity's {@code MOVEMENT_SPEED} attribute by the pathfinder at runtime.
     * Effective speed = attribute × goal multiplier. All other goals (float, sit,
     * attack, follow, look, targets) come from {@link WildTamableEntity#registerGoals()}
     * via super.
     */
    @Override
    protected void registerGoals() {
        //float configuredSpeed = nativeEntity != null ? (float) nativeEntity.getData().getMoveSpeed() : 0.6f;
        //double liveAttr = this.getAttributeValue(Attributes.MOVEMENT_SPEED);
        //Monsters.LOGGER.info(
        //    "[Goals/Fly] {} | configured moveSpeed={} | live MOVEMENT_SPEED attr={} | " +
        //    "attack mult=1.0 (eff={}) | follow mult=1.1 (eff={}) | wander mult=0.8 (eff={})",
        //    nativeEntity != null ? nativeEntity.getKey() : "unknown",
        //    configuredSpeed,
        //    String.format("%.4f", liveAttr),
        //    String.format("%.4f", liveAttr * 1.0),
        //    String.format("%.4f", liveAttr * 1.1),
        //    String.format("%.4f", liveAttr * 0.8)
        //);

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1, 10.0f, 2.0F));
        // Flying wander replaces WaterAvoidingRandomStrollGoal
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 0.8));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    } // registerGoals ()

    // -- Inherited Methods --

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return level.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    } // getWalkTargetValue ()

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level) {
            @Override
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }
        };
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(false);
        navigation.setCanOpenDoors(true);
        return navigation;
    } // createNavigation ()

    @Override
    protected void checkFallDamage(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
        // Flying entities don't take fall damage
    } // checkFallDamage ()

    @Override
    protected void jumpInLiquid(TagKey<Fluid> tagKey) {
        this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.01, 0.0));
    } // jumpInLiquid ()

} // Class: FlyTamableEntity