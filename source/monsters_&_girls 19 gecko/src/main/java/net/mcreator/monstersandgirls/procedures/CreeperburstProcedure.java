package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CreeperburstProcedure {
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
		if (entity instanceof BlueSlimeGirlEntity && entity.isVehicle() && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity && sourceentity instanceof Creeper) {
			if (entity instanceof BlueSlimeGirlEntity) {
				((BlueSlimeGirlEntity) entity).setAnimation("empty");
			}
			if (entity instanceof BlueSlimeGirlEntity) {
				((BlueSlimeGirlEntity) entity).setAnimation("boom2");
			}
		}
	}
}
