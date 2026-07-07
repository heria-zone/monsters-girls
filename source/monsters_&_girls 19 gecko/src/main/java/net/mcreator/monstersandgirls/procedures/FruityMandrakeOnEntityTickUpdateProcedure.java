package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModBlocks;
import net.mcreator.monstersandgirls.entity.StationCarpetEntity;

import java.util.Comparator;

public class FruityMandrakeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double generator_distance = 0;
		if (entity.isOnGround()) {
			if (world.isEmptyBlock(new BlockPos(x, y, z))) {
				if (world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude()) {
					if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) <= 2) {
						if (Math.random() < 0.002) {
							world.setBlock(new BlockPos(x, y, z), MonstersAndGirlsModBlocks.GLOW_BERRY_BUSH.get().defaultBlockState(), 3);
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(StationCarpetEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			entity.startRiding(((Entity) world.getEntitiesOfClass(StationCarpetEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)));
		}
	}
}
