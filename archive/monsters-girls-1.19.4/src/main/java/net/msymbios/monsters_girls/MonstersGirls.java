package net.msymbios.monsters_girls;

import net.fabricmc.api.ModInitializer;

import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.config.MonstersGirlsConfig;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;
import net.msymbios.monsters_girls.world.MonstersGirlsWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class MonstersGirls implements ModInitializer {

	// -- Variables --
	public static final String MODID = "monsters_girls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	// -- Inherited Method --
	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		MonstersGirlsConfig.register();

		MonstersGirlsItems.register();
		MonstersGirlsBlocks.register();

		MonstersGirlsWorld.generate();
		MonstersGirlsEntities.registerAttribute();
	} // onInitialize ()

} // Class MonstersGirls