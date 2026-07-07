
package net.mcreator.monstersandgirls.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstersandgirls.procedures.SpookedActiveTickConditionProcedure;

public class SpookedMobEffect extends MobEffect {
	public SpookedMobEffect() {
		super(MobEffectCategory.HARMFUL, -5418225);
	}

	@Override
	public String getDescriptionId() {
		return "effect.monsters_and_girls.spooked";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SpookedActiveTickConditionProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
