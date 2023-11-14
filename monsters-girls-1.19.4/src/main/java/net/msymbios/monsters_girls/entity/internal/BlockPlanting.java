package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.block.Block;

public class BlockPlanting {

    // -- Variables --
    float condition;
    Block block;

    // -- Constructor --
    public BlockPlanting () {} // Constructor BlockPlanting ()

    public BlockPlanting (float condition, Block block) {
        this.condition = condition;
        this.block = block;
    } // Constructor BlockPlanting ()

} // Class BlockPlanting