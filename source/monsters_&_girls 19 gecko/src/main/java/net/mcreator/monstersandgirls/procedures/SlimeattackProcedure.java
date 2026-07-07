package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SlimeattackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		double previousRecipe = 0;
		if (sourceentity instanceof BlueSlimeGirlEntity && !sourceentity.isVehicle()) {
			if (sourceentity instanceof BlueSlimeGirlEntity) {
				((BlueSlimeGirlEntity) sourceentity).setAnimation("attack");
			}
		}
	}
}
