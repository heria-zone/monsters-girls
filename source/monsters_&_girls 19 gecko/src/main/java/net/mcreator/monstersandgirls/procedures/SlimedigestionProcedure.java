package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SlimedigestionProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double previousRecipe = 0;
		if (sourceentity instanceof BlueSlimeGirlEntity && entity.getBbHeight() <= 2 && entity.getBbWidth() <= 2) {
			entity.startRiding(sourceentity);
		}
	}
}
