package net.msymbios.monsters_girls.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class SpookEffect extends StatusEffect {

    // -- Constructor --
    public SpookEffect(StatusEffectCategory category, int color) {
        super(category, color);
    } // Constructor SpookEffect ()

    // -- Inherited Methods --
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity == null) return;
        if (entity.getWorld().isClient()) return;
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 10, amplifier, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 10, amplifier, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10, amplifier, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, amplifier, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, amplifier, true, false));
        super.applyUpdateEffect(entity, amplifier);
    } // applyUpdateEffect ()

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    } // canApplyUpdateEffect ()

} // Class SpookEffect