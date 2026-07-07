package net.heriazone.monsters_girls.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.resources.ResourceLocation;

/**
 * <p>Puffy — fills any entity carrying this effect with buoyant spores for aerial mobility.<p>
 * <p>
 * <b>Mechanics (self-contained — applied to whoever holds the effect, by any source):</b>
 * <ul>
 *   <li><b>Jump Boost:</b> delivered via a {@code JUMP_STRENGTH} attribute modifier,
 *       equivalent to Jump Boost III. Applied when the effect is added, removed on expiry.</li>
 *   <li><b>Slow Falling:</b> refreshed each tick via {@link #applyEffectTick} — granting
 *       Slow Falling (1 tick) continuously so it never actually expires.</li>
 * </ul>
 * <p>
 * <b>Design decision — attribute vs stacked Slow Falling:</b> Using {@code JUMP_STRENGTH}
 * directly means the jump boost stacks correctly with vanilla Jump Boost potions through
 * Minecraft's attribute system. The Slow Falling trick (1-tick refresh) ensures the
 * rendering and physics are applied cleanly with zero residual when Puffy expires.
 * <p>
 * Given by: Puffball Gal (bowl → puffball stew). Also obtainable as a potion.
 * Also applied passively while a tamed Puffball Gal is nearby (proximity aura — future feature).
 */
public class PuffyEffect extends MobEffect {

    // -- Constants --

    /** ResourceLocation key for the jump strength attribute modifier. */
    private static final ResourceLocation JUMP_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath("monsters_girls", "puffy_jump");

    /**
     * Jump strength delta — vanilla Jump Boost I = +0.1, II = +0.2, III = +0.3.
     * 0.3 gives a noticeably high jump without being absurd.
     */
    private static final double JUMP_BOOST_VALUE = 0.3;

    // -- Constructor --

    /**
     * Soft lavender (0xC8A2E8), BENEFICIAL category.
     */
    public PuffyEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xC8A2E8);
    } // Constructor: PuffyEffect ()

    // -- Attribute Modifiers --

    /**
     * Registers the JUMP_STRENGTH attribute modifier when the effect is applied.
     * <p>
     * Called automatically by Minecraft when {@code MobEffectInstance} is added.
     * The modifier is removed automatically via {@link #removeAttributeModifiers}
     * when the effect expires.
     *
     * @param attributeMap the attribute map of the entity receiving the effect
     * @param amplifier    current amplifier (scales jump boost linearly)
     */
    @Override
    public void addAttributeModifiers(AttributeMap attributeMap, int amplifier) {
        var attr = attributeMap.getInstance(Attributes.JUMP_STRENGTH);
        if (attr != null) {
            attr.removeModifier(JUMP_MODIFIER_ID);
            attr.addTransientModifier(new AttributeModifier(
                    JUMP_MODIFIER_ID,
                    JUMP_BOOST_VALUE * (amplifier + 1),
                    AttributeModifier.Operation.ADD_VALUE));
        }
    } // addAttributeModifiers ()

    /**
     * Removes the JUMP_STRENGTH attribute modifier when the effect expires.
     *
     * @param attributeMap the attribute map of the entity
     */
    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        var attr = attributeMap.getInstance(Attributes.JUMP_STRENGTH);
        if (attr != null) {
            attr.removeModifier(JUMP_MODIFIER_ID);
        }
    } // removeAttributeModifiers ()

    // -- Tick Logic --

    /**
     * Continuously refreshes Slow Falling (1 tick) on the holder.
     * <p>
     * Because Slow Falling is refreshed before it can expire, the holder
     * experiences it uninterrupted for the full Puffy duration without
     * ever holding a long-duration Slow Falling instance.
     *
     * @param entity    the entity holding this effect
     * @param amplifier the current amplifier (unused for slow falling)
     */
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 0, false, false));
        return true;
    } // applyEffectTick ()

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true; // apply every tick to keep Slow Falling refreshed
    } // shouldApplyEffectTickThisTick ()

    @Override
    public boolean isInstantenous() {
        return false;
    } // isInstantaneous ()

} // Class: PuffyEffect
