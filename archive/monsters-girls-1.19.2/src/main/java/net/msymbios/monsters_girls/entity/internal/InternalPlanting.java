package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.block.Block;

import java.util.List;

public class InternalPlanting {

    // -- Variables --
    List<Block> canPlantOn;
    List<BlockPlanting> toBePlant;

    // -- Constructor --
    public InternalPlanting () {} // Constructor BlockPlanting ()

    public InternalPlanting (List<Block> canPlantOn, List<BlockPlanting> toBePlant) {
        this.canPlantOn = canPlantOn;
        this.toBePlant = toBePlant;
    } // Constructor BlockPlanting ()

} // Class InternalPlanting