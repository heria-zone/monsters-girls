package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.entity.Entity;

public class SlimeLoopExternalAnimationsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isVehicle()) {
			return true;
		}
		return false;
	}
}
