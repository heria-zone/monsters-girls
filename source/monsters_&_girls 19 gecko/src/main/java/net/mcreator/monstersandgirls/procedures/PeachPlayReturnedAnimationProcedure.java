package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.entity.Entity;

public class PeachPlayReturnedAnimationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.isPassenger()) {
			return "ride";
		}
		return "empty";
	}
}
