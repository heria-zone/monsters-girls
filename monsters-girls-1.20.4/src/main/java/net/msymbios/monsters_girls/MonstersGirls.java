package net.msymbios.monsters_girlss;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class MonstersGirls implements ModInitializer {

	// -- Variables --

	public static final String MOD_ID = "monsters_girls";

	// This logger is used to write text to the console and the log file.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// -- Inherited Methods --
	@Override
	public void onInitialize() {
		GeckoLib.initialize();

		LOGGER.info("Hello Fabric world!");
	} // onInitialize ()

} // Class MonstersGirls