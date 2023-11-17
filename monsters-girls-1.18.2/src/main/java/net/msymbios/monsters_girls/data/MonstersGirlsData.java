package net.msymbios.monsters_girls.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsData implements DataGeneratorEntrypoint {

	// -- Inherited Methods --
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		MonstersGirls.LOGGER.info(MonstersGirls.MODID + ": Data Generators Loaded!");
	} // onInitializeDataGenerator ()

} // Class MonstersGirlsData