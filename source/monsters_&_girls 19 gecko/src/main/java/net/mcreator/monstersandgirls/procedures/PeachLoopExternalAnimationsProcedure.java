package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.entity.Entity;

public class PeachLoopExternalAnimationsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isPassenger()) {
			return true;
		}
		return false;
	}
}
