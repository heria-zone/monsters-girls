package net.msymbios.monsters_girls.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.data.provider.*;

public class MonstersGirlsData implements DataGeneratorEntrypoint {

	// -- Inherited Method --
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MonstersGirlsBlockTagProvider::new);
		pack.addProvider(MonstersGirlsItemTagProvider::new);
		pack.addProvider(MonstersGirlsLootTableProvider::new);
		pack.addProvider(MonstersGirlsModelProvider::new);
		pack.addProvider(MonstersGirlsRecipeProvider::new);

		MonstersGirls.LOGGER.info(MonstersGirls.MODID + ": Data Generators Loaded!");
	} // onInitializeDataGenerator ()

} // Class MonstersGirlsData