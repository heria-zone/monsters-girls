
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.monstersandgirls.world.biome.SpookyForestBiome;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<Biome> SPOOKY_FOREST = REGISTRY.register("spooky_forest", SpookyForestBiome::createBiome);
}
