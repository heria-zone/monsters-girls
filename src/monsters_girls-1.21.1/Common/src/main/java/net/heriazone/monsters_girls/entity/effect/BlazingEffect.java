package net.heriazone.monsters_girls.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

/**
 * <p>Blazing — wraps any entity carrying this effect in protective fire.<p>
 * <p>
 * <b>Mechanics (self-contained — applied to whoever holds the effect, by any source):</b>
 * <ul>
 *   <li><b>On attack:</b> sets the target on fire for 4 s (80 ticks).</li>
 *   <li><b>Fire immunity:</b> the holder's fire ticks are cleared each tick via
 *       {@link #applyEffectTick}, granting effective fire damage immunity.</li>
 * </ul>
 * <p>
 * <b>Note:</b> Does not grant lava immunity — only fire tick damage.
 * Consistent with vanilla Fire Resistance behavior.
 * <p>
 * <b>Architecture:</b> On-attack fire is applied by {@code MonstersEffectCallbacks}.
 * Fire immunity runs in {@link #applyEffectTick} — no entity subclass override needed.
 * <p>
 * Given by: Molten Gal (bowl → molten stew). Also obtainable as a potion.
 */
public class BlazingEffect extends MobEffect {

    // -- Constants --

    /** Seconds the attacked target stays on fire. */
    private static final int FIRE_SECONDS = 4;

    // -- Constructor --

    /**
     * Molten orange (0xFF6A00), BENEFICIAL category.
     */
    public BlazingEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF6A00);
    } // Constructor: BlazingEffect ()

    // -- Tick Logic --

    /**
     * Clears fire ticks each game tick, granting effective fire immunity.
     *
     * @param entity    the entity holding this effect
     * @param amplifier the current amplifier (unused)
     */
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.clearFire();
        return true;
    } // applyEffectTick ()

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true; // run every tick so fire never sticks
    } // shouldApplyEffectTickThisTick ()

    // -- Combat Callbacks (invoked by MonstersEffectCallbacks) --

    /**
     * Called when the {@code holder} successfully attacks {@code target}.
     * Sets the target on fire.
     *
     * @param holder the entity carrying the Blazing effect
     * @param target the entity being attacked
     */
    public static void onAttack(LivingEntity holder, LivingEntity target) {
        target.igniteForSeconds(FIRE_SECONDS);
    } // onAttack ()

    @Override
    public boolean isInstantenous() {
        return false;
    } // isInstantaneous ()

} // Class: BlazingEffect
