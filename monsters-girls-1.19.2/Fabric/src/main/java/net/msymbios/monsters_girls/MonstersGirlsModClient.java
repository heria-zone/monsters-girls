package net.msymbios.monsters_girls;

import net.fabricmc.api.ClientModInitializer;
import net.msymbios.monsters_girls.block.ModBlocks;
import net.msymbios.monsters_girls.entity.ModEntities;

public class MonstersGirlsModClient implements ClientModInitializer {

    // -- Method --
    @Override
    public void onInitializeClient() {
        ModBlocks.registerBlockRender();
        ModEntities.registerEntityRenderer();
    } // onInitializeClient ()

} // Class MonstersGirlsModClient
