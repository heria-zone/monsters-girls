package net.msymbios.monsters_girls.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PoisonousEffect extends StatusEffect {

    // -- Constructor --

    public PoisonousEffect(StatusEffectCategory category, int color) {
        super(category, color);
    } // Constructor PoisonousEffect ()

    // -- Inherited Methods --

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the effect every tick
        return true;
    } // canApplyUpdateEffect ()

    // Called when the effect is applied.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity == null) return;
        if (entity.getWorld().isClient()) return;
        //entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10, amplifier, true, false));
        super.applyUpdateEffect(entity, amplifier);
    } // applyUpdateEffect ()

} // Class PoisonousEffect