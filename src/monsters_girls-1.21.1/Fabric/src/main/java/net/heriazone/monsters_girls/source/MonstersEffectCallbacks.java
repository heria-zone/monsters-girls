package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.heriazone.monsters_girls.entity.effect.*;
import net.heriazone.monsters_girls.source.MonstersEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

/**
 * <p>Wires Fabric server-side living entity event callbacks for all custom combat effects.<p>
 * <p>
 * <b>Architecture:</b> Custom effect combat logic lives in the {@code MobEffect} subclass
 * (e.g. {@link PoisonousEffect#onAttack}), not in any entity class. This ensures the
 * behavior is identical regardless of how the effect is applied — stew, potion, splash
 * potion, or {@code /effect}. Fabric events are the bridge between Minecraft's entity
 * system and those effect-owned static methods.
 * <p>
 * <b>Separation of concerns:</b>
 * <ul>
 *   <li>Common ({@code entity/effect/}) — behavior definition, static callback methods</li>
 *   <li>Fabric ({@code source/MonstersEffectCallbacks}) — event registration only</li>
 * </ul>
 * <p>
 * Call {@link #register()} once from {@code MonstersGirls.onInitialize()}.
 */
public class MonstersEffectCallbacks {

    // -- Registration --

    /**
     * Registers all combat effect callbacks against Fabric server living entity events.
     * <p>
     * <b>Events used:</b>
     * <ul>
     *   <li>{@code ServerLivingEntityEvents.AFTER_DAMAGE} — fires after damage is applied.
     *       Used to retroactively apply effects to the attacker (e.g. Poisonous on-hurt).</li>
     *   <li>{@code ServerLivingEntityEvents.ALLOW_DAMAGE} — not used here; on-attack effects
     *       are applied in the damage handler by checking damage source entity.</li>
     * </ul>
     */
    public static void register() {
        registerPoisonousCallbacks();
        registerChillyCallbacks();
        registerBlazingCallbacks();
        registerSoulWanderersTouchCallbacks();
        // Puffy has no on-hit logic — fully tick-driven via applyEffectTick.
    } // register ()

    // -- Per-effect callback wiring --

    /**
     * Poisonous: infect the target when holder attacks; infect the attacker when holder is hit.
     */
    private static void registerPoisonousCallbacks() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, appliedDamage, blocked) -> {
            // entity = the one that received damage
            // source.getEntity() = the one that dealt damage (if any)

            if (!(source.getEntity() instanceof LivingEntity attacker)) return;

            // Attacker has Poisonous → infect target (the one who got hit)
            if (attacker.hasEffect(MonstersEffects.POISONOUS)) {
                PoisonousEffect.onAttack(attacker, entity);
            }

            // Entity has Poisonous → infect the attacker (retaliatory venom)
            if (entity.hasEffect(MonstersEffects.POISONOUS)) {
                PoisonousEffect.onHurt(entity, attacker);
            }
        });
    } // registerPoisonousCallbacks ()

    /**
     * Chilly: slow and partially freeze the target when holder attacks.
     */
    private static void registerChillyCallbacks() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, appliedDamage, blocked) -> {
            if (!(source.getEntity() instanceof LivingEntity attacker)) return;
            if (attacker.hasEffect(MonstersEffects.CHILLY)) {
                ChillyEffect.onAttack(attacker, entity);
            }
        });
    } // registerChillyCallbacks ()

    /**
     * Blazing: set target on fire when holder attacks.
     */
    private static void registerBlazingCallbacks() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, appliedDamage, blocked) -> {
            if (!(source.getEntity() instanceof LivingEntity attacker)) return;
            if (attacker.hasEffect(MonstersEffects.BLAZING)) {
                BlazingEffect.onAttack(attacker, entity);
            }
        });
    } // registerBlazingCallbacks ()

    /**
     * Soul Wanderer's Touch: inflict Wither on target and grant holder Regeneration on attack.
     */
    private static void registerSoulWanderersTouchCallbacks() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, appliedDamage, blocked) -> {
            if (!(source.getEntity() instanceof LivingEntity attacker)) return;
            if (attacker.hasEffect(MonstersEffects.SOUL_WANDERERS_TOUCH)) {
                SoulWanderersTouchEffect.onAttack(attacker, entity);
            }
        });
    } // registerSoulWanderersTouchCallbacks ()

} // Class: MonstersEffectCallbacks
