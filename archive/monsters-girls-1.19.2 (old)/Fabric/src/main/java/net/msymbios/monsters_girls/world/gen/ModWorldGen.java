package net.msymbios.monsters_girls.world.gen;

public class ModWorldGen {

    // -- Method --
    public static void generateWorldGen() {
        ModFlowerGeneration.generateFlowers();
        ModEntitySpawn.register();
    } // generateWorldGen ()

} // Class ModWorldGen