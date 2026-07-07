
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<Potion> POTION_OF_LEVITATION = REGISTRY.register("potion_of_levitation", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 3600, 0, false, true)));
	public static final RegistryObject<Potion> WITCHERING = REGISTRY.register("witchering", () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 3600, 0, false, true)));
}
