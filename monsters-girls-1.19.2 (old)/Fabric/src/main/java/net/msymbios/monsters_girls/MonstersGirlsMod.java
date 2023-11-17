package net.msymbios.monsters_girls;

import net.fabricmc.api.ModInitializer;
import net.msymbios.monsters_girls.block.ModBlocks;
import net.msymbios.monsters_girls.effect.ModEffects;
import net.msymbios.monsters_girls.entity.ModEntities;
import net.msymbios.monsters_girls.item.ModItems;
import net.msymbios.monsters_girls.potion.ModPotions;
import net.msymbios.monsters_girls.world.feature.ModConfiguredFeatures;
import net.msymbios.monsters_girls.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class MonstersGirlsMod implements ModInitializer {

	// -- Variables --
	public static final String MODID = "monsters_girls";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	// -- Methods --
	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGen.generateWorldGen();

		GeckoLib.initialize();

		ModEntities.registerAttribute();

		ModEffects.register();
		ModPotions.register();
	} // onInitialize ()

} // Class MonstersGirls