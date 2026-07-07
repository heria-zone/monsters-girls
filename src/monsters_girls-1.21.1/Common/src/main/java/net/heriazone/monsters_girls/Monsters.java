package net.heriazone.monsters_girls;

import net.heriazone.monsters_girls.item.MonstersArmorMaterials;
import net.heriazone.monsters_girls.source.MonstersBlockItems;
import net.heriazone.monsters_girls.source.MonstersBlocks;
import net.heriazone.monsters_girls.source.MonstersEffects;
import net.heriazone.monsters_girls.source.MonstersPotions;
import net.heriazone.monsters_girls.source.MonstersSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Main Monsters mod class providing common initialization and shared functionality.</p>
 * <p>
 * <b>Architecture:</b> Serves as the central coordination point for Monsters mod functionality
 * across all supported mod loaders. Contains shared initialization logic and provides
 * common utilities that work consistently on Fabric, Forge, and NeoForge.
 * <p>
 * <b>Design Pattern:</b> Singleton-style initialization with loader-agnostic design.
 * Each loader calls init() during their respective initialization phases.
 */
public class Monsters {

    // -- Constants --
    
    /**
     * Mod identifier used across all loaders and configurations.
     */
    public static final String MODID = "monsters_girls";
    
    /**
     * Mod display name for user-facing contexts.
     */
    public static final String MOD_NAME = "Monsters & Girls";

    /**
     * Mod version for runtime identification and compatibility checks.
     */
    public static final String VERSION = "2.0.0";

    /**
     * Logger instance for common functionality.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    // -- Initialization State --

    private static boolean initialized = false;

    // -- Custom Methods --
    
    /**
     * Common initialization logic called by all loader-specific entry points.
     * <p>
     * <b>Order is load-bearing:</b> each stage depends on the previous one completing.
     * Effects → Potions → Sounds → Blocks → ArmorMaterials → Items. Entity family
     * constructors (registered after this method) can safely reference all block and
     * item holders once {@code init()} returns.
     * <p>
     * <b>Thread Safety:</b> Safe to call multiple times — idempotent guard on {@link #initialized}.
     */
    public static void init() {
        if (initialized) return;

        LOGGER.info("Initializing {} - for quick Minecraft mod setup", MOD_NAME);

        // Effect holders must exist before items/entities that reference them
        // (stew on-use effects, combat aura sources in family definitions).
        MonstersEffects.register();

        // Potions reference effect holders — must follow effects.
        MonstersPotions.register();

        // Sound event holders must exist before entity family constructors
        // attach SoundFeatures that reference them.
        MonstersSounds.register();

        // Blocks must exist before their BlockItem wrappers in MonstersBlockItems.
        MonstersBlocks.register();

        // Armor material holders must exist before ArmorItem constructors consume them.
        MonstersArmorMaterials.register();

        // Block items (65) and hat items (12) — depends on both blocks and armor materials.
        // Renamed MonstersBlockItems to avoid collision with Fabric-module MonstersItems,
        // which registers stews, spawn eggs, and plant block items via InternalItems at class-load time.
        MonstersBlockItems.register();

        initialized = true;
        LOGGER.info("{} initialization complete", MOD_NAME);
    } // init ()

    /**
     * Performs client-side initialization.
     * <p>
     * <b>Client Integration:</b> Sets up client-specific features
     * such as rendering and input handling.
     */
    public static void initClient() {
        LOGGER.info("Initializing {} client-side features", MOD_NAME);

        // TODO: Initialize client-side features

        LOGGER.info("{} client initialization complete", MOD_NAME);
    } // initClient ()

    /**
     * Get the current mod version for runtime checks and logging.
     *
     * @return mod version string
     */
    public static String getVersion() {
        return VERSION;
    }

    /**
     * Check if the mod has been initialized.
     * <p>
     * <b>Usage:</b> Useful for conditional logic that depends on initialization state.
     *
     * @return true if init() has been called successfully
     */
    public static boolean isInitialized() {
        return initialized;
    }

} // Class: Monsters