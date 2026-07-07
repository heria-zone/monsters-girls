package net.heriazone.monsters_girls;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.heriazone.monsters_girls.source.MonstersBlocksClient;
import net.heriazone.monsters_girls.source.MonstersBrewingRecipes;
import net.heriazone.monsters_girls.source.MonstersEffectCallbacks;
import net.heriazone.monsters_girls.source.MonstersEntities;
import net.heriazone.monsters_girls.source.MonstersGroups;
import net.heriazone.monsters_girls.source.MonstersItems;
import net.heriazone.monsters_girls.source.MonstersWorld;

/**
 * <p>Fabric-specific initialization for the Monsters mod.</p>
 * <p>
 * <b>Loader Integration:</b> Implements Fabric's ModInitializer interface
 * to bootstrap the mod within the Fabric ecosystem while delegating
 * core functionality to the common module.
 * <p>
 * <b>Monsters Usage:</b> Customize this class to add Fabric-specific features.
 */
public class MonstersGirls implements ModInitializer, ClientModInitializer {

    /**
     * Fabric mod initialization entry point.
     * <p>
     * <b>Initialization Order:</b> Called by Fabric loader during mod loading phase.
     * Delegates to common initialization while handling Fabric-specific setup.
     */
    @Override
    public void onInitialize() {
        Monsters.LOGGER.info("Initializing Monsters Mod for Fabric");
        
        // Initialize common functionality
        Monsters.init();
        
        // Register Fabric-specific features here
        MonstersGroups.register();
        MonstersItems.register();
        //MonstersEvents.register();
        MonstersEntities.register();
        MonstersEntities.registerFeatures();
        MonstersEffectCallbacks.register();
        MonstersBrewingRecipes.register();
        MonstersWorld.register();

        Monsters.LOGGER.info("Monsters Mod Fabric initialization complete");
    } // onInitialize ()

    /**
     * Fabric client-side initialization entry point.
     * <p>
     * <b>Client Setup:</b> Handles client-only initialization such as
     * rendering registration and input handling setup.
     */
    @Override
    public void onInitializeClient() {
        Monsters.LOGGER.info("Initializing Monsters Mod client for Fabric");
        
        // Initialize client-side functionality
        Monsters.initClient();
        
        // Register client-side features here
        //MonstersItems.registerModel();
        MonstersEntities.registerRender();
        MonstersBlocksClient.registerRenderLayers();
        // GeckoLib armor renderer wiring is done via MushroomHatItem.createGeoRenderer()
        // — no separate registration call needed in GeckoLib 4.x.

        Monsters.LOGGER.info("Monsters Mod Fabric client initialization complete");
    } // onInitializeClient ()

} // Class: MonstersGirls