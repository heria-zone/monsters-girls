package net.msymbios.monsters_girls.client;

import net.fabricmc.api.ClientModInitializer;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;

public class MonstersGirlsClient implements ClientModInitializer  {

    // -- Inherited Methods --
    @Override
    public void onInitializeClient() {
        MonstersGirlsBlocks.registerRender();
        MonstersGirlsEntities.registerRender();
    } // onInitializeClient ()

} // Class MonstersGirlsClient