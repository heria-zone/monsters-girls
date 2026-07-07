package net.msymbios.monsters_girls.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class BlazingEffect extends StatusEffect {

    // -- Constructor --

    public BlazingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    } // Constructor BlazingEffect ()

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

} // Class BlazingEffect