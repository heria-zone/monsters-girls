package net.mcreator.monstersandgirls.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monstersandgirls.init.MonstersAndGirlsModParticleTypes;
import net.mcreator.monstersandgirls.entity.YellowWispEntity;
import net.mcreator.monstersandgirls.entity.GreenWispEntity;
import net.mcreator.monstersandgirls.entity.BlueWispEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VexscaredProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof BlueWispEntity) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 5, 1, 1, 1, 1);
			if (entity instanceof Vex) {
				entity.hurt(DamageSource.GENERIC, 20);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5, false);
					}
				}
			} else if (entity instanceof Phantom) {
				entity.hurt(DamageSource.GENERIC, 10);
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				entity.hurt(DamageSource.HOT_FLOOR, 7);
			}
		}
		if (sourceentity instanceof GreenWispEntity) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MonstersAndGirlsModParticleTypes.GREEN_FLAME.get()), x, y, z, 5, 1, 1, 1, 1);
			if (entity instanceof Vex) {
				entity.hurt(DamageSource.GENERIC, 20);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5, false);
					}
				}
			} else if (entity instanceof Phantom) {
				entity.hurt(DamageSource.GENERIC, 10);
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				entity.hurt(DamageSource.HOT_FLOOR, 7);
			}
		}
		if (sourceentity instanceof YellowWispEntity) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 5, 1, 1, 1, 1);
			if (entity instanceof Vex) {
				entity.hurt(DamageSource.GENERIC, 20);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("monsters_and_girls:vexiskill")), SoundSource.HOSTILE, 1, 5, false);
					}
				}
			} else if (entity instanceof Phantom) {
				entity.hurt(DamageSource.GENERIC, 10);
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				entity.hurt(DamageSource.HOT_FLOOR, 7);
			}
		}
	}
}
