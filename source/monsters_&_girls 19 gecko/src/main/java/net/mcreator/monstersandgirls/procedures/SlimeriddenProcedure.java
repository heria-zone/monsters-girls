package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SlimeriddenProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double previousRecipe = 0;
		if ((entity.getVehicle()) instanceof BlueSlimeGirlEntity) {
			MonstersAndGirlsMod.queueServerWork(5, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("slime digestion").bypassArmor(), 2);
				if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20, 2, false, false));
				if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 2, false, true));
				if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 2, false, true));
			});
		}
	}
}
