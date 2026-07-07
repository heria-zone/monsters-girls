package net.heriazone.monsters_girls.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

/**
 * <p>Poisonous — turns any entity carrying this effect into a venomous combatant.<p>
 * <p>
 * <b>Mechanics (self-contained — applied to whoever holds the effect, by any source):</b>
 * <ul>
 *   <li><b>On attack:</b> applies Poison II (80 ticks / 4 s) to the target.</li>
 *   <li><b>On receiving damage:</b> applies Poison II (80 ticks / 4 s) to the attacker.</li>
 *   <li><b>Immunity:</b> the holder cannot receive the vanilla Poison effect while
 *       Poisonous is active — enforced by {@link #isImmuneTo(MobEffect)}.</li>
 * </ul>
 * <p>
 * <b>Architecture:</b> On-hit logic is NOT in the entity — it is invoked from
 * {@code MonstersEffectCallbacks} (Fabric event callbacks) which call
 * {@link #onAttack} and {@link #onHurt}. This keeps the mechanic identical
 * whether the effect comes from a stew, a potion, a splash potion, or {@code /effect}.
 * <p>
 * Given by: Inkcap Gal (bowl → poison stew). Also obtainable as a potion.
 */
public class PoisonousEffect extends MobEffect {

    // -- Constants --

    /** Duration applied to attacked/attacker targets (ticks). */
    private static final int POISON_DURATION = 80;  // 4 s
    /** Amplifier for the poison applied to others (0 = Poison I, 1 = Poison II). */
    private static final int POISON_AMPLIFIER = 1;

    // -- Constructor --

    /**
     * Deep purple (0x7A2DAA), BENEFICIAL category.
     */
    public PoisonousEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x7A2DAA);
    } // Constructor: PoisonousEffect ()

    // -- Combat Callbacks (invoked by MonstersEffectCallbacks) --

    /**
     * Called when the {@code holder} successfully attacks {@code target}.
     * Applies Poison to the target.
     *
     * @param holder the entity carrying the Poisonous effect
     * @param target the entity being attacked
     */
    public static void onAttack(LivingEntity holder, LivingEntity target) {
        target.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_DURATION, POISON_AMPLIFIER));
    } // onAttack ()

    /**
     * Called when the {@code holder} receives damage from {@code attacker}.
     * Applies Poison to the attacker (retaliatory venom).
     *
     * @param holder   the entity carrying the Poisonous effect
     * @param attacker the entity that dealt damage
     */
    public static void onHurt(LivingEntity holder, LivingEntity attacker) {
        attacker.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_DURATION, POISON_AMPLIFIER));
    } // onHurt ()

    // -- Immunity --

    /**
     * Grants immunity to vanilla Poison while Poisonous is active.
     * <p>
     * Checked by {@code LivingEntity.addEffect()} before applying any effect.
     * Returning {@code true} here causes vanilla to silently drop Poison applications.
     *
     * @param effect the effect being applied
     * @return true if the effect should be blocked
     */
    public boolean isImmuneTo(MobEffect effect) {
        return effect == MobEffects.POISON.value();
    } // isImmuneTo ()

    @Override
    public boolean isInstantenous() {
        return false;
    } // isInstantenous ()

} // Class: PoisonousEffect
