package net.heriazone.monsters_girls.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

/**
 * <p>Chilly — turns any entity carrying this effect into a frost conduit.<p>
 * <p>
 * <b>Mechanics (self-contained — applied to whoever holds the effect, by any source):</b>
 * <ul>
 *   <li><b>On attack:</b> applies Slowness II (100 ticks / 5 s) to the target,
 *       and boosts its freeze ticks by 70 (roughly half of the freeze threshold).</li>
 *   <li><b>Immunity:</b> the holder's freeze ticks are zeroed each tick via
 *       {@link #applyEffectTick}, preventing powder snow accumulation.</li>
 * </ul>
 * <p>
 * <b>Architecture:</b> On-attack logic is invoked from {@code MonstersEffectCallbacks}.
 * The freeze immunity tick-drain runs in {@link #applyEffectTick} — no entity
 * subclass override needed.
 * <p>
 * Given by: Snowball Gal (bowl → snowball stew). Also obtainable as a potion.
 */
public class ChillyEffect extends MobEffect {

    // -- Constants --

    private static final int SLOW_DURATION  = 100;  // 5 s
    private static final int SLOW_AMPLIFIER = 1;    // Slowness II
    /** Freeze ticks added to target per hit (140 = full freeze threshold in vanilla). */
    private static final int FREEZE_BOOST   = 70;

    // -- Constructor --

    /**
     * Icy blue (0x5AB8E8), BENEFICIAL category.
     */
    public ChillyEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x5AB8E8);
    } // Constructor: ChillyEffect ()

    // -- Tick Logic --

    /**
     * Drains the holder's freeze ticks each game tick, granting effective freeze immunity.
     * <p>
     * Called by Minecraft every tick while the effect is active
     * (when {@link #shouldApplyEffectTickThisTick} returns true, which for
     * a 0-amplifier effect is every tick).
     *
     * @param entity    the entity holding this effect
     * @param amplifier the current amplifier (unused — immunity is flat)
     */
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.setTicksFrozen(0);
        return true;
    } // applyEffectTick ()

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true; // run every tick so freeze never accumulates
    } // shouldApplyEffectTickThisTick ()

    // -- Combat Callbacks (invoked by MonstersEffectCallbacks) --

    /**
     * Called when the {@code holder} successfully attacks {@code target}.
     * Slows and partially freezes the target.
     *
     * @param holder the entity carrying the Chilly effect
     * @param target the entity being attacked
     */
    public static void onAttack(LivingEntity holder, LivingEntity target) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, SLOW_DURATION, SLOW_AMPLIFIER));
        target.setTicksFrozen(Math.min(target.getTicksFrozen() + FREEZE_BOOST, target.getTicksRequiredToFreeze()));
    } // onAttack ()

    @Override
    public boolean isInstantenous() {
        return false;
    } // isInstantaneous ()

} // Class: ChillyEffect
