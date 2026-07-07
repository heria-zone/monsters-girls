
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstersandgirls.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.MonstersAndGirlsMod;

public class MonstersAndGirlsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MonstersAndGirlsMod.MODID);
	public static final RegistryObject<SoundEvent> VEXISKILL = REGISTRY.register("vexiskill", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "vexiskill")));
	public static final RegistryObject<SoundEvent> MUSHROOMGALSOUND = REGISTRY.register("mushroomgalsound", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "mushroomgalsound")));
	public static final RegistryObject<SoundEvent> ENDERMUSHROOMGALSOUND = REGISTRY.register("endermushroomgalsound", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "endermushroomgalsound")));
	public static final RegistryObject<SoundEvent> ENDERPUFFBALLGALHUFFS = REGISTRY.register("enderpuffballgalhuffs", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "enderpuffballgalhuffs")));
	public static final RegistryObject<SoundEvent> ENDERPUFFBALLGALPUFFS = REGISTRY.register("enderpuffballgalpuffs", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "enderpuffballgalpuffs")));
	public static final RegistryObject<SoundEvent> MANDRAKESOUNDS = REGISTRY.register("mandrakesounds", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "mandrakesounds")));
	public static final RegistryObject<SoundEvent> MANDRAKEHURT = REGISTRY.register("mandrakehurt", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "mandrakehurt")));
	public static final RegistryObject<SoundEvent> MANDRAKEDIES = REGISTRY.register("mandrakedies", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "mandrakedies")));
	public static final RegistryObject<SoundEvent> WISPDEATH = REGISTRY.register("wispdeath", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "wispdeath")));
	public static final RegistryObject<SoundEvent> WISPLAUGHS = REGISTRY.register("wisplaughs", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "wisplaughs")));
	public static final RegistryObject<SoundEvent> WISPHURT = REGISTRY.register("wisphurt", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "wisphurt")));
	public static final RegistryObject<SoundEvent> SPOOKATTACKING = REGISTRY.register("spookattacking", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "spookattacking")));
	public static final RegistryObject<SoundEvent> SPOOKHURT = REGISTRY.register("spookhurt", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "spookhurt")));
	public static final RegistryObject<SoundEvent> SPOOKLAUGH = REGISTRY.register("spooklaugh", () -> new SoundEvent(new ResourceLocation("monsters_and_girls", "spooklaugh")));
}
