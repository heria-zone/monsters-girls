package net.msymbios.monsters_girls.world;

import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.world.internal.FlowersGenerator;
import net.msymbios.monsters_girls.world.internal.MonstersGirlsSpawn;

public class MonstersGirlsWorld {

    // -- Methods --
    public static void generate() {
        FlowersGenerator.generate();
        MonstersGirlsSpawn.generate();

        MonstersGirls.LOGGER.debug("Generating World Items for: " + MonstersGirls.MODID);
    } // generate ()

} // Class MonstersGirlsWorld