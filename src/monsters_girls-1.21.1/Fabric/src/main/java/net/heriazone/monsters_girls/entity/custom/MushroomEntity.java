package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.animation.AnimationStateManager;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.common.WildTamableEntity;
import net.heriazone.monsters_girls.source.MonstersSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

/**
 * <p>Mushroom entity implementation for all Mushroom family variants.</p>
 * <p>
 * <b>Architecture:</b> All Mushroom variants share this single entity class and are
 * differentiated entirely through their {@link MushroomFamily} descriptor. Variant-specific
 * behaviour — ranged attack, planting, emanation, sounds — is declared on the family
 * descriptor and executed by the base class infrastructure.
 * <p>
 * <b>Puff-jump (PUFFBALL variant only):</b> Autonomous support mechanic that triggers when
 * the tamed owner is nearby. Applies {@code JUMP_BOOST} II + {@code SLOW_FALLING} to the
 * entity (benefiting a riding owner), plays the {@code "wave"} animation, and enforces a
 * 200-tick (10 s) cooldown. Gated on the family key {@code "mushroom_puffball"} — all other
 * mushroom variants are completely unaffected.
 * <p>
 * <b>Ranged attack:</b> No entity-class override needed — {@code WildTamableEntity.registerGoals()}
 * reads {@link net.heriazone.hzlib.api.entity.features.RangedAttackFeature} from the family
 * and auto-wires the goal when the feature is present.
 */
public class MushroomEntity extends WildTamableEntity {

    // -- Puff-jump constants (PUFFBALL only) --

    /** Ticks between autonomous puff-jumps (10 seconds). */
    private static final int PUFF_COOLDOWN_TICKS = 200;

    /** {@code JUMP_BOOST} amplifier — level II (index 1). */
    private static final int JUMP_BOOST_AMPLIFIER = 1;

    /** {@code JUMP_BOOST} duration in ticks (3 s). */
    private static final int JUMP_BOOST_TICKS = 60;

    /** {@code SLOW_FALLING} amplifier — level I (index 0). */
    private static final int SLOW_FALLING_AMPLIFIER = 0;

    /** {@code SLOW_FALLING} duration in ticks (4 s). */
    private static final int SLOW_FALLING_TICKS = 80;

    /** Maximum distance (blocks) from the owner to trigger puff-jump. */
    private static final double PUFF_OWNER_RANGE = 8.0;

    // -- Puff-jump state --

    /** Server-side countdown. Puff-jump is eligible when this reaches 0. */
    private int puffCooldown = 0;

    // -- Constructors --

    public MushroomEntity(EntityType<? extends MushroomEntity> entityType, Level level,
                          MonstersFamily<? extends MonstersFamily<?>> mushroomType) {
        super(entityType, level, mushroomType);
    } // Constructor: MushroomEntity ()

    // -- Puff-jump logic --

    /**
     * Ticks puff-jump on the server side for the PUFFBALL variant.
     * <p>
     * <b>Trigger condition:</b> Entity is tamed, owner is online and within
     * {@link #PUFF_OWNER_RANGE}, owner has positive upward momentum (jumping or
     * climbing), and the cooldown has expired.
     * <p>
     * <b>Effect:</b> Applies {@code JUMP_BOOST} II + {@code SLOW_FALLING} to self
     * (which benefits a riding owner), fires the {@code "wave"} animation via
     * {@code triggerAnim()}, plays the puff-out sound, and resets the cooldown.
     */
    @Override
    public void aiStep() {
        super.aiStep();

        if (level().isClientSide || nativeEntity == null) return;
        if (!"mushroom_puffball".equals(nativeEntity.getKey())) return;
        if (!isTame()) return;

        if (puffCooldown > 0) {
            puffCooldown--;
            return;
        }

        LivingEntity owner = getOwner();
        if (owner == null) return;

        // Trigger when owner is nearby and has upward velocity (jumping/climbing/falling upward)
        boolean ownerNearby    = distanceTo(owner) <= PUFF_OWNER_RANGE;
        boolean ownerJumping   = owner.getDeltaMovement().y > 0.05;

        if (ownerNearby && ownerJumping) {
            // Apply effects
            addEffect(new MobEffectInstance(MobEffects.JUMP, JUMP_BOOST_TICKS, JUMP_BOOST_AMPLIFIER));
            addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, SLOW_FALLING_TICKS, SLOW_FALLING_AMPLIFIER));

            // Trigger the wave animation on the locomotion controller (PLAY_ONCE)
            triggerAnim(AnimationStateManager.ControllerType.LOCOMOTION.getName(), "wave");

            // Play the puff-out sound if configured
            nativeEntity.getFeature(net.heriazone.hzlib.api.entity.features.SoundFeature.class)
                    .ifPresent(sf -> {
                        net.minecraft.sounds.SoundEvent puffSound =
                                sf.getSound(net.heriazone.hzlib.api.entity.features.SoundFeature.SoundType.INTERACT, "puff");
                        if (puffSound != null) playSound(puffSound, 0.6f, 1.0f);
                    });

            puffCooldown = PUFF_COOLDOWN_TICKS;
        }
    } // aiStep ()

} // Class: MushroomEntity
