package net.msymbios.monsters_girls.world;

import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.common.world.InternalSpawn;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.entity.custom.wisp.*;
import net.msymbios.monsters_girls.entity.internal.WispVariant;

public class MonstersGirlsSpawn extends InternalSpawn {

    // -- Methods --

    public static void register() {
        MonstersGirls.LOGGER.info("Registering Entities Spawns: " + MonstersGirls.MODID );

        // Register Wisps entity
        register(WispVariant.BLUE, MonstersGirlsEntities.WISP_BLUE, WispBlueEntity::isValidNaturalSpawn);
        register(WispVariant.GREEN, MonstersGirlsEntities.WISP_GREEN, WispGreenEntity::isValidNaturalSpawn);
        register(WispVariant.YELLOW, MonstersGirlsEntities.WISP_YELLOW, WispYellowEntity::isValidNaturalSpawn);
    } // register ()

} // Class MonstersGirlsSpawn