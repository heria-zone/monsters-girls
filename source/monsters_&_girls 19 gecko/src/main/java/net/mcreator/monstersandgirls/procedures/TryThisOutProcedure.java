package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import net.mcreator.monstersandgirls.network.MonstersAndGirlsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TryThisOutProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDirection()) == Direction.NORTH) {
			MonstersAndGirlsModVariables.MapVariables.get(world).Playerfacing = 1;
			MonstersAndGirlsModVariables.MapVariables.get(world).syncData(world);
		} else if ((entity.getDirection()) == Direction.WEST) {
			MonstersAndGirlsModVariables.MapVariables.get(world).Playerfacing = 2;
			MonstersAndGirlsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((entity.getDirection()) == Direction.SOUTH) {
			MonstersAndGirlsModVariables.MapVariables.get(world).Playerfacing = 3;
			MonstersAndGirlsModVariables.MapVariables.get(world).syncData(world);
		} else if ((entity.getDirection()) == Direction.EAST) {
			MonstersAndGirlsModVariables.MapVariables.get(world).Playerfacing = 4;
			MonstersAndGirlsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
