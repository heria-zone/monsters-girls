package net.msymbios.monsters_girls;

import net.fabricmc.api.ModInitializer;

import net.msymbios.monsters_girls.common.util.ObjectUtil;
import net.msymbios.monsters_girls.common.util.internal.Version;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;
import net.msymbios.monsters_girls.item.MonstersGirlsItemsGroup;
import net.msymbios.monsters_girls.world.MonstersGirlsWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class MonstersGirls implements ModInitializer {

	// -- Variables --

	// The mod's ID, which is also the mod's namespace.
	public static final String MODID = "monsters_girls";

	// The mod's version.
	public static final Version VERSION = new Version(ObjectUtil.coalesce(MonstersGirls.class.getPackage().getSpecificationVersion(), "99999.0.0.0"));

	// This logger is used to write text to the console and the log file.
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	// -- Inherited Methods --
	@Override
	public void onInitialize() {
		MonstersGirlsItemsGroup.register();
		MonstersGirlsItems.register();

		MonstersGirlsEntities.register();
		MonstersGirlsWorld.register();
	} // onInitialize ()

} // Class MonstersGirls