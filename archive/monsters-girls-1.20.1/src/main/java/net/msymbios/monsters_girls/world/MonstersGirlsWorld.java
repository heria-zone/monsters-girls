package net.msymbios.monsters_girls.world;

import net.msymbios.monsters_girls.world.internal.FlowersGenerator;
import net.msymbios.monsters_girls.world.internal.MonstersGirlsSpawn;

public class MonstersGirlsWorld {

    // -- Methods --
    public static void generate() {
        FlowersGenerator.generate();
        MonstersGirlsSpawn.generate();
    } // generate ()

} // Class MonstersGirlsWorld