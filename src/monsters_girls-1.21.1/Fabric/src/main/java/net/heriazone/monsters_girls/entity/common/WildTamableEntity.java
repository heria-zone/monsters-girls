package net.heriazone.monsters_girls.entity.common;

import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.animation.AnimationStateManager;
import net.heriazone.hzlib.api.animation.LoopBehavior;
import net.heriazone.hzlib.api.entity.NativeAnimation;
import net.heriazone.hzlib.api.entity.features.*;
import net.heriazone.monsters_girls.entity.MonsterEntity;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.sounds.SoundEvents;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.Map;
import java.util.Random;

/**
 * <p>Shared base entity class for all Monsters &amp; Girls tamable entities, providing
 * GeckoLib animation integration, biome-driven spawn appearance, and a three-controller
 * animation pipeline.<p>
 * <p>
 * <b>Animation controllers:</b>
 * <ol>
 *   <li><b>Locomotion</b> — handles idle, walk, rest, sit, ride via
 *       {@link NativeAnimation#locomotionAnimation}. Pulls the profile from the
 *       current animator variant's {@link AnimationProfile} via
 *       {@link AnimationStateManager}. Also drives idle-timeout special animations
 *       (wave, belly, sing) when the entity has been idle for
 *       {@link #IDLE_SPECIAL_TRIGGER_TICKS} ticks.</li>
 *   <li><b>Attack</b> — one-shot attack animation triggered by {@link #swinging}.</li>
 *   <li><b>Hurt</b> — one-shot hurt animation triggered by the {@code justHurt} flag, plays
 *       once then clears the flag. Only active if the current profile declares a
 *       {@code hurt} pool. Mandrake uses this for the scream-reaction animation.</li>
 * </ol>
 * <p>
 * <b>BiomeAppearance fix:</b> {@code initializeBiomesVariants} only sets the
 * texture variant — model and animator remain at their type defaults. Setting
 * animator to a texture key caused silent profile resolution failure.
 */
public class WildTamableEntity extends MonsterEntity implements GeoEntity, RangedAttackMob {

    // -- Constants --

    /**
     * Trigger name for the hurt one-shot animation registered on the locomotion controller.
     */
    private static final String HURT_TRIGGER = "hurt";

    /**
     * Synced field that carries the name of the currently-active LOOP special animation.
     * <p>
     * <b>Empty string = none active.</b> Set by the server in {@link #customServerAiStep()}
     * when a LOOP special is selected; cleared when the entity moves, enters combat, or
     * takes damage. The Sustained GeckoLib controller reads this on the client to drive the
     * looping animation. Client-side TickableSound management observes this field too.
     * <p>
     * <b>Pattern:</b> Mirrors {@code TEXTURE_VARIANT} / {@code MODEL_VARIANT} —
     * empty string as sentinel is the established convention in this codebase.
     */
    static final EntityDataAccessor<String> ACTIVE_LOOP_SPECIAL =
            SynchedEntityData.defineId(WildTamableEntity.class, EntityDataSerializers.STRING);

    /**
     * Ticks of continuous idle before a special animation is eligible to play.
     * At 20 TPS: 300 = 15 seconds (production), 20 = 1 second (testing).
     */
    private static final int IDLE_SPECIAL_TRIGGER_TICKS = 300;

    /**
     * 1-in-N chance per tick of firing a special once the idle threshold is reached.
     * At 20 TPS: 60 = fires roughly every 3 extra seconds (production), 1 = fires immediately (testing).
     */
    private static final int IDLE_SPECIAL_CHANCE = 60;

    private static final Random SPECIAL_RANDOM = new Random();

    // -- Variables --

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    /** Ticks the entity has spent continuously in idle (not moving, not in combat). */
    private int idleTicks = 0;

    // -- Constructor --

    public WildTamableEntity(EntityType<? extends MonsterEntity> entityType, Level level, MonstersFamily<? extends MonstersFamily<?>> nativeEntity) {
        super(entityType, level, nativeEntity);
    } // Constructor: WildTamableEntity ()

    // -- Synced Data --

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ACTIVE_LOOP_SPECIAL, "");
    } // defineSynchedData ()

    // -- AI Goals --

    /**
     * Registers the common goal set for all tamable ground entities.
     * <p>
     * <b>RangedAttackFeature:</b> When the entity's family declares a
     * {@link RangedAttackFeature}, this method automatically adds
     * {@link RangedAttackGoal} (priority 2) and
     * {@link NearestAttackableTargetGoal}{@code <Monster>} (priority 4).
     * The {@link MeleeAttackGoal} remains at priority 2 as a fallback — when the
     * target closes past the ranged goal's minimum distance, melee takes over.
     * No entity-class override is needed for ranged attack — declare the feature
     * on the family and the goal set auto-wires here.
     * <p>
     * <b>Speed contract:</b> The goal speed parameters are multipliers applied on top
     * of the entity's {@code MOVEMENT_SPEED} attribute at runtime by the pathfinder.
     * Effective speed = attribute × goal multiplier. Multipliers are fixed ratios:
     * <ul>
     *   <li>Attack: ×1.0 — full attribute speed</li>
     *   <li>Follow owner: ×1.1 — slightly faster so the entity keeps up</li>
     *   <li>Wander: ×0.8 — relaxed wandering pace</li>
     * </ul>
     * <p>
     * <b>Subclass extension:</b> Subclasses that only add extra target goals should call
     * {@code super.registerGoals()} then append their additions. Subclasses that need a
     * completely different goal set override without calling super.
     */
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));

        // RangedAttackFeature — auto-wires ranged goal when declared on the family.
        if (nativeEntity != null) {
            nativeEntity.getFeature(RangedAttackFeature.class).ifPresent(feature -> {
                this.goalSelector.addGoal(2, new RangedAttackGoal(this,
                        1.0,
                        feature.getMinInterval(),
                        feature.getMaxInterval(),
                        feature.getAttackRange()));
                this.targetSelector.addGoal(4,
                        new NearestAttackableTargetGoal<>(this, Monster.class, true));
            });
        }
    } // registerGoals ()

    // -- Inherited Methods --

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegister) {
        // 1. Locomotion + hurt trigger + SNAP special triggerables
        buildAndRegisterLocomotionController(controllerRegister);

        // 2. Sustained — drives LOOP special animations (e.g. sing2).
        // Reads ACTIVE_LOOP_SPECIAL synced field: non-empty = loop that animation,
        // empty or moving = stop. Client-side TickableSound observes the same field.
        controllerRegister.add(new AnimationController<>(this, "Sustained",
                AnimationStateManager.LOCOMOTION_TRANSITION_TICKS,
                state -> {
                    String active = entityData.get(ACTIVE_LOOP_SPECIAL);
                    if (active.isEmpty() || state.isMoving()) {
                        return software.bernie.geckolib.animation.PlayState.STOP;
                    }
                    return state.setAndContinue(RawAnimation.begin().thenLoop(active));
                }));

        // 3. Attack — one-shot on swing
        controllerRegister.add(NativeAnimation.attackAnimation(this));

        // 4. Base pose — optional parallel layer (e.g. Gourdragora default's "pose" animation)
        AnimationProfile profile = AnimationStateManager.resolveProfilePublic(this);
        if (profile != null && profile.getBasePoseAnimation() != null) {
            controllerRegister.add(NativeAnimation.basePoseAnimation(this, profile.getBasePoseAnimation()));
        }
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; } // getAnimatableInstanceCache ()

    /**
     * Intercepts damage to trigger the hurt animation via GeckoLib's server-side trigger.
     * <p>
     * <b>Why triggerAnim:</b> GeckoLib's triggerable animation system handles the server→client
     * sync internally. Calling {@code triggerAnim} on the server propagates to clients and
     * fires the registered {@link #HURT_TRIGGER} animation on the locomotion controller,
     * overriding idle/walk for exactly one play-through.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);
        if (result && !level().isClientSide) {
            // Interrupt any active loop special — taking damage breaks sustained animations
            if (!entityData.get(ACTIVE_LOOP_SPECIAL).isEmpty()) {
                entityData.set(ACTIVE_LOOP_SPECIAL, "");
            }
            triggerAnim("Hurt", HURT_TRIGGER);
        }
        return result;
    } // hurt ()

    /**
     * Server-only idle counter and special animation/sound scheduler.
     * <p>
     * Overrides {@link net.heriazone.monsters_girls.entity.MonsterEntity#aiStep()} —
     * calls super first (which handles emanations, planting, etc.) then runs the
     * idle-special logic server-side only.
     * <p>
     * <b>SNAP vs SUSTAIN routing:</b> The selected animation's {@link LoopBehavior} in the
     * {@link net.heriazone.hzlib.api.animation.AnimationPool} is the authoritative source:
     * <ul>
     *   <li>{@link LoopBehavior#PLAY_ONCE} → SNAP path: {@code triggerAnim()} on the locomotion
     *       controller; GeckoLib plays it once and returns to locomotion automatically.</li>
     *   <li>{@link LoopBehavior#LOOP} → SUSTAIN path: {@code ACTIVE_LOOP_SPECIAL} synced field
     *       is set; the Sustained controller reads it and loops the animation until cleared.</li>
     * </ul>
     * <p>
     * <b>Loop special clearing:</b> The loop special is cleared when the entity moves or enters
     * combat. {@link #hurt} also clears it when damage is taken.
     */
    @Override
    public void aiStep() {
        super.aiStep();

        if (level().isClientSide) return;

        boolean isMoving = getDeltaMovement().horizontalDistanceSqr() > 1.0E-5D;
        if (isMoving || combatMode) {
            idleTicks = 0;
            // Clear any active loop special when entity moves or enters combat
            if (!entityData.get(ACTIVE_LOOP_SPECIAL).isEmpty()) {
                entityData.set(ACTIVE_LOOP_SPECIAL, "");
            }
        } else {
            idleTicks++;
            if (idleTicks >= IDLE_SPECIAL_TRIGGER_TICKS
                    && entityData.get(ACTIVE_LOOP_SPECIAL).isEmpty()  // don't stack loop specials
                    && SPECIAL_RANDOM.nextInt(IDLE_SPECIAL_CHANCE) == 0) {

                SelectedSpecial selected = pickRandomSpecialWithBehavior();
                if (selected != null) {
                    if (selected.loop == LoopBehavior.LOOP) {
                        // SUSTAIN path — set synced field; Sustained controller drives the animation.
                        // Sound is not played server-side for SUSTAIN; the client-side TickableSound
                        // observes ACTIVE_LOOP_SPECIAL and manages its own lifecycle.
                        entityData.set(ACTIVE_LOOP_SPECIAL, selected.animName);
                    } else {
                        // SNAP path — fire triggerable; GeckoLib handles sync + one-shot lifecycle.
                        // Also play the INTERACT sound keyed to this animation name, if configured.
                        triggerAnim(AnimationStateManager.ControllerType.LOCOMOTION.getName(), selected.animName);
                        playInteractSound(selected.animName);
                    }
                    idleTicks = 0;
                }
            }
        }
    } // aiStep ()

    // -- RangedAttackMob --

    /**
     * Throws the projectile declared by the family's {@link RangedAttackFeature}.
     * <p>
     * <b>Trajectory:</b> Mirrors vanilla {@code SnowGolem} —
     * a small upward arc ({@code +dist*0.2} on Y) corrects for gravity drop, keeping
     * throws accurate at typical combat distances (4–15 blocks).
     * <p>
     * <b>Sound:</b> Plays {@link net.minecraft.sounds.SoundEvents#LLAMA_SPIT} for spit
     * projectiles and {@link net.minecraft.sounds.SoundEvents#SNOWBALL_THROW} for
     * throwable-item projectiles. Currently uses LLAMA_SPIT as the default; override
     * in subclasses or extend this to be feature-configurable when needed.
     * <p>
     * <b>No-op guard:</b> If the family has no {@link RangedAttackFeature}, this method
     * returns immediately — entities that do not declare ranged attack never throw.
     */
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (nativeEntity == null) return;
        nativeEntity.getFeature(RangedAttackFeature.class).ifPresent(feature -> {
            Projectile projectile = feature.createProjectile(level());
            projectile.setOwner(this);
            projectile.setPos(getX(), getEyeY() - 0.1, getZ());

            double dx   = target.getX() - getX();
            // Aim at the target's body centre (eyeY - 1.1) rather than eyeY so the
            // arc correction lands the projectile at torso height, not above the head.
            double dy   = (target.getEyeY() - 1.1) - projectile.getY();
            double dz   = target.getZ() - getZ();
            double dist = Math.sqrt(dx * dx + dz * dz);

            // Arc correction: +dist*0.1 on Y (matches vanilla LlamaSpit — small lob to
            // counteract gravity drop without overshooting on short throws).
            // Inaccuracy: 10.0f fixed — matches vanilla llama, gives natural spread
            // without the wild variance the previous /random formula produced.
            projectile.shoot(dx, dy + dist * 0.1, dz, 1.5f, 10.0f);

            level().addFreshEntity(projectile);
            playSound(SoundEvents.LLAMA_SPIT, 1.0f, 1.0f + getRandom().nextFloat() * 0.2f);
        });
    } // performRangedAttack ()

    // -- Animation Controller Builders --

    /**
     * Builds and registers the locomotion controller with all triggerable one-shot animations
     * (hurt + specials) attached.
     * <p>
     * <b>Why triggerableAnim for everything one-shot:</b> GeckoLib's triggerable system is
     * the correct API for all one-shot reactions. When triggered from the server via
     * {@code triggerAnim()}, GeckoLib syncs to clients internally, overrides the state handler
     * for one play-through, then returns to normal locomotion. This avoids all the problems
     * we had with flag-based approaches (race conditions, frame restarts, forceAnimationReset).
     * <p>
     * <b>No hurt pool:</b> If the entity's profile has no hurt pool, the hurt trigger is simply
     * not registered — {@code triggerAnim()} calls for it are silently ignored by GeckoLib.
     * The locomotion controller is always registered regardless.
     * <p>
     * <b>Specials:</b> Every special declared in the profile is registered as a triggerable
     * with its exact animation name as the trigger key, so {@code triggerAnim("wave", ...)}
     * fires the wave animation, etc.
     */
    private void buildAndRegisterLocomotionController(AnimatableManager.ControllerRegistrar controllerRegister) {
        AnimationProfile profile = AnimationStateManager.resolveProfilePublic(this);

        // Build the locomotion controller — handles idle/walk/rest/ride every frame
        AnimationController<WildTamableEntity> locomotion = new AnimationController<>(this,
                AnimationStateManager.ControllerType.LOCOMOTION.getName(),
                AnimationStateManager.LOCOMOTION_TRANSITION_TICKS,
                state -> {
                    String animName = AnimationStateManager.getLocomotionAnimation(this, state.isMoving());
                    return state.setAndContinue(RawAnimation.begin().thenLoop(animName));
                });

        // Hurt is handled by a SEPARATE dedicated controller (registered below)
        // so its playback speed can be set independently without affecting idle/walk.

        // Attach each PLAY_ONCE special as a triggerable using its animation name as the key.
        // LOOP specials are handled by the Sustained controller via ACTIVE_LOOP_SPECIAL —
        // they must NOT be registered here, as triggerables are one-shot by definition.
        if (profile != null) {
            for (Map.Entry<String, net.heriazone.hzlib.api.animation.ISpecialAnimation> entry
                    : profile.getSpecialAnimations().entrySet()) {
                if (entry.getValue() instanceof net.heriazone.hzlib.api.animation.AnimationPool pool
                        && AnimationProfile.isUsable(pool)) {
                    // Register all possible animation names from this pool as SNAP triggerables
                    for (net.heriazone.hzlib.api.animation.WeightedAnimation wa : pool.getAnimations()) {
                        if (wa.getLoop() != LoopBehavior.LOOP) {
                            locomotion.triggerableAnim(wa.getName(),
                                    RawAnimation.begin().then(wa.getName(),
                                            software.bernie.geckolib.animation.Animation.LoopType.PLAY_ONCE));
                        }
                    }
                }
            }
        }

        controllerRegister.add(locomotion);

        // -- Dedicated Hurt controller --
        // Separate from locomotion so setAnimationSpeed() only affects the hurt animation.
        // The speed is derived from profile.getHurtAnimationSpeed() — set to
        //   animLength / soundDuration  to make animation end in sync with the sound.
        // Default 1.0 = no change (most entities). Mandrake uses ~0.765 (1.04s / 1.36s).
        if (profile != null && AnimationProfile.isUsable(profile.getHurt())) {
            String hurtName = profile.getHurt().selectNext(SPECIAL_RANDOM);
            if (hurtName != null) {
                LoopBehavior hurtLoop = profile.getHurt().getLoopBehavior(hurtName);
                software.bernie.geckolib.animation.Animation.LoopType geckoLoop =
                        hurtLoop == LoopBehavior.HOLD_LAST_FRAME
                                ? software.bernie.geckolib.animation.Animation.LoopType.HOLD_ON_LAST_FRAME
                                : software.bernie.geckolib.animation.Animation.LoopType.PLAY_ONCE;

                AnimationController<WildTamableEntity> hurtController =
                        new AnimationController<>(this, "Hurt", 0,
                                state -> software.bernie.geckolib.animation.PlayState.STOP);
                hurtController.triggerableAnim(HURT_TRIGGER,
                        RawAnimation.begin().then(hurtName, geckoLoop));

                double speed = profile.getHurtAnimationSpeed();
                if (speed != 1.0) {
                    hurtController.setAnimationSpeed(speed);
                }
                controllerRegister.add(hurtController);
            }
        }
    } // buildAndRegisterLocomotionController ()

    // -- Special Animation Selection --

    /**
     * Holds a selected animation name together with its declared {@link LoopBehavior}.
     * The loop behaviour is the authority for routing: PLAY_ONCE → SNAP path (triggerable),
     * LOOP → SUSTAIN path (ACTIVE_LOOP_SPECIAL synced field).
     */
    private record SelectedSpecial(String animName, LoopBehavior loop) {}

    /**
     * Selects a random special animation from the current profile's special map,
     * returning both the animation name and its declared {@link LoopBehavior} so
     * {@link #customServerAiStep} can route it through the correct path.
     * <p>
     * Returns {@code null} if no specials are declared or the profile is unavailable.
     */
    private SelectedSpecial pickRandomSpecialWithBehavior() {
        if (nativeEntity == null) return null;
        AnimationProfile profile = AnimationStateManager.resolveProfilePublic(this);
        if (profile == null) return null;

        Map<String, net.heriazone.hzlib.api.animation.ISpecialAnimation> specials = profile.getSpecialAnimations();
        if (specials.isEmpty()) return null;

        String[] keys = specials.keySet().toArray(new String[0]);
        String key = keys[SPECIAL_RANDOM.nextInt(keys.length)];
        net.heriazone.hzlib.api.animation.ISpecialAnimation anim = specials.get(key);

        if (anim instanceof net.heriazone.hzlib.api.animation.AnimationPool pool) {
            String animName = pool.selectNext(SPECIAL_RANDOM);
            if (animName == null) return null;
            LoopBehavior loop = pool.getLoopBehavior(animName);
            return new SelectedSpecial(animName, loop);
        }
        // Non-pool specials treated as PLAY_ONCE
        return new SelectedSpecial(key, LoopBehavior.PLAY_ONCE);
    } // pickRandomSpecialWithBehavior ()

    /**
     * Plays the INTERACT sound associated with the given animation name, if one is configured.
     * <p>
     * <b>Animation-linked sounds:</b> {@link SoundFeature} stores sounds keyed by animation
     * name under {@link SoundFeature.SoundType#INTERACT}. This method looks up the sound for
     * the given animation name and plays it server-side at the entity's position.
     * <p>
     * Only called for SNAP (PLAY_ONCE) specials — SUSTAIN specials manage their own sound
     * lifecycle client-side via TickableSound observing {@link #ACTIVE_LOOP_SPECIAL}.
     *
     * @param animationName the animation being triggered
     */
    private void playInteractSound(String animationName) {
        if (nativeEntity == null) return;
        nativeEntity.getFeature(SoundFeature.class).ifPresent(f -> {
            SoundEvent sound = f.getSound(SoundFeature.SoundType.INTERACT, animationName);
            if (sound != null) {
                level().playSound(null, blockPosition(), sound, SoundSource.NEUTRAL, 1.0f, 1.0f);
            }
        });
    } // playInteractSound ()

    /**
     * Selects the texture variant at spawn time.
     * <p>
     * <b>Selection priority:</b>
     * <ol>
     *   <li>Biome-driven — if {@link BiomeAppearanceFeature} is present, resolves the
     *       variant for the spawn biome (with its own default for unmapped biomes).</li>
     *   <li>Random — if no {@link BiomeAppearanceFeature} is configured, falls back to
     *       {@link #initializeRandomVariants()} so entities still get visual variety.</li>
     * </ol>
     *
     * @param world  server level accessor providing biome context
     * @param reason spawn reason
     */
    /**
     * Selects the texture variant at spawn time.
     * <p>
     * <b>Selection priority:</b>
     * <ol>
     *   <li>Conditional — if {@link ConditionalAppearanceFeature} is registered on the family,
     *       evaluates its spawn-context rules (biome, dimension, spawn reason, etc.) and applies
     *       the resolved key.</li>
     *   <li>Random — falls through to {@link #initializeRandomVariants()} when no
     *       {@link ConditionalAppearanceFeature} is registered or no rule matched.</li>
     * </ol>
     * <p>
     * <b>Migration note:</b> Replaces the deleted {@code BiomeAppearanceFeature} path.
     * Families that previously registered {@code BiomeAppearanceFeature} now register
     * {@link ConditionalAppearanceFeature} with {@code AppearanceConditions.inBiome()} rules.
     *
     * @param world  server level accessor providing biome and world context
     * @param reason spawn reason (NATURAL, CHUNK_GENERATION, SPAWNER, etc.)
     */
    @Override
    protected void initializeSpawnVariants(ServerLevelAccessor world, MobSpawnType reason) {
        if (nativeEntity == null) { initializeRandomVariants(); return; }

        nativeEntity.getFeature(ConditionalAppearanceFeature.class)
                .ifPresentOrElse(feature -> {
                    AppearanceContext ctx = AppearanceContext.forSpawn(this, world, blockPosition(), reason);
                    String key = feature.resolve(ctx);
                    if (key != null) {
                        setTextureVariant(key);
                        seedOverlaySlots();
                    } else {
                        initializeRandomVariants();
                    }
                }, this::initializeRandomVariants);
    } // initializeSpawnVariants ()

} // Class: WildTamableEntity