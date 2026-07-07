
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<SimpleParticleType> GREEN_FLAME = REGISTRY.register("green_flame", () -> new SimpleParticleType(true));
}
