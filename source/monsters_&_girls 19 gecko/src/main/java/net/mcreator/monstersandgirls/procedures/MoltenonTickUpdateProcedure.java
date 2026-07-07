package net.mcreator.monstersandgirls.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModBlocks;
import net.mcreator.monstersandgirls.entity.StationCarpetEntity;
import net.mcreator.monstersandgirls.entity.MoltenMushroomGalEntity;

import java.util.Comparator;

public class MoltenonTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double generator_distance = 0;
		if (entity.isOnGround()) {
			if (world.isEmptyBlock(new BlockPos(x, y, z))) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BASALT) {
					if (Math.random() < 0.0005) {
						world.setBlock(new BlockPos(x, y, z), MonstersAndGirlsModBlocks.MOLTEN_FUNGUS.get().defaultBlockState(), 3);
					}
				}
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BLACKSTONE) {
					if (Math.random() < 0.0005) {
						world.setBlock(new BlockPos(x, y, z), MonstersAndGirlsModBlocks.MOLTEN_FUNGUS.get().defaultBlockState(), 3);
					}
				}
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.MAGMA_BLOCK) {
					if (Math.random() < 0.0005) {
						world.setBlock(new BlockPos(x, y, z), MonstersAndGirlsModBlocks.MOLTEN_FUNGUS.get().defaultBlockState(), 3);
					}
				}
			}
		}
		if (entity.isOnGround()) {
			if (world.isEmptyBlock(new BlockPos(x, y, z - 1))) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.BASALT) {
					if (Math.random() < 5e-7) {
						world.setBlock(new BlockPos(x, y, z - 1), MonstersAndGirlsModBlocks.HUGE_MAGMA_FUNGUS.get().defaultBlockState(), 3);
					}
				}
				if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.BLACKSTONE) {
					if (Math.random() < 5e-7) {
						world.setBlock(new BlockPos(x, y, z - 1), MonstersAndGirlsModBlocks.HUGE_MAGMA_FUNGUS.get().defaultBlockState(), 3);
					}
				}
				if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.MAGMA_BLOCK) {
					if (Math.random() < 5e-7) {
						world.setBlock(new BlockPos(x, y, z - 1), MonstersAndGirlsModBlocks.HUGE_MAGMA_FUNGUS.get().defaultBlockState(), 3);
					}
				}
			}
		}
		if ((entity instanceof Player _plr ? _plr.getAbilities().getWalkingSpeed() : 0) == 0) {
			if (Math.random() < 0.0005) {
				if (entity instanceof MoltenMushroomGalEntity) {
					((MoltenMushroomGalEntity) entity).setAnimation("belly");
				}
			}
			if (Math.random() < 0.0005) {
				if (entity instanceof MoltenMushroomGalEntity) {
					((MoltenMushroomGalEntity) entity).setAnimation("wave");
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
		if (!world.getEntitiesOfClass(Strider.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			entity.startRiding(((Entity) world.getEntitiesOfClass(Strider.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)));
		}
	}
}
