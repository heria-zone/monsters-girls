package net.heriazone.monsters_girls.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

/**
 * <p>Soul Wanderer's Touch — channels wandering souls through any entity carrying this effect.<p>
 * <p>
 * <b>Mechanics (self-contained — applied to whoever holds the effect, by any source):</b>
 * <ul>
 *   <li><b>On attack:</b> applies Wither I (60 ticks / 3 s) to the target.</li>
 *   <li><b>On attack:</b> grants the holder Regeneration I (60 ticks / 3 s) —
 *       life force drawn from struck foes.</li>
 *   <li><b>Wither immunity:</b> the holder cannot receive the vanilla Wither effect
 *       while Soul Wanderer's Touch is active — enforced by {@link #isImmuneTo}.</li>
 * </ul>
 * <p>
 * <b>Architecture:</b> On-attack logic is invoked from {@code MonstersEffectCallbacks}.
 * This class is otherwise stateless — no tick logic needed.
 * <p>
 * Given by: Soul Wanderer Gal (bowl → soul wanderer stew). Also obtainable as a potion.
 */
public class SoulWanderersTouchEffect extends MobEffect {

    // -- Constants --

    private static final int WITHER_DURATION = 60;   // 3 s
    private static final int WITHER_AMPLIFIER = 0;   // Wither I
    private static final int REGEN_DURATION  = 60;   // 3 s
    private static final int REGEN_AMPLIFIER = 0;    // Regeneration I

    // -- Constructor --

    /**
     * Soul blue-green (0x3DC9B4), BENEFICIAL category.
     */
    public SoulWanderersTouchEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x3DC9B4);
    } // Constructor: SoulWanderersTouchEffect ()

    // -- Combat Callbacks (invoked by MonstersEffectCallbacks) --

    /**
     * Called when the {@code holder} successfully attacks {@code target}.
     * Inflicts Wither on the target and grants Regeneration to the holder.
     *
     * @param holder the entity carrying the Soul Wanderer's Touch effect
     * @param target the entity being attacked
     */
    public static void onAttack(LivingEntity holder, LivingEntity target) {
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, WITHER_DURATION, WITHER_AMPLIFIER));
        holder.addEffect(new MobEffectInstance(MobEffects.REGENERATION, REGEN_DURATION, REGEN_AMPLIFIER));
    } // onAttack ()

    // -- Immunity --

    /**
     * Grants immunity to vanilla Wither while Soul Wanderer's Touch is active.
     *
     * @param effect the effect being applied
     * @return true if the effect should be blocked
     */
    public boolean isImmuneTo(MobEffect effect) {
        return effect == MobEffects.WITHER.value();
    } // isImmuneTo ()

    @Override
    public boolean isInstantenous() {
        return false;
    } // isInstantenous ()

} // Class: SoulWanderersTouchEffect
