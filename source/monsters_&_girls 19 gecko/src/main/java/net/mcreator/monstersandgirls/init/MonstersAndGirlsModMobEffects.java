
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstersandgirls.potion.SpookedMobEffect;
import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<MobEffect> SPOOKED = REGISTRY.register("spooked", () -> new SpookedMobEffect());
}
