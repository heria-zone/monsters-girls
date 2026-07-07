package net.heriazone.monsters_girls.source;

import net.minecraft.world.food.FoodProperties;

/**
 * <p>Defines food properties for all custom consumables in the mod.<p>
 * <p>
 * <b>Design:</b> Treat items (cake, candies) are intentionally low nutrition —
 * they are gifting currency, not sustenance. Stew items follow vanilla stew
 * conventions: moderate nutrition with {@code alwaysEat()} so they can be
 * consumed regardless of hunger, matching the "gift from a companion" usage.
 */
public class MonstersFood {

    // -- Variables --

    /** Low-nutrition spectral treat; always consumable for gifting interactions. */
    public static final FoodProperties SPECTRAL_CAKE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.3F)
            .alwaysEdible().build();

    /** Low-nutrition candy; always consumable for gifting interactions. */
    public static final FoodProperties CANDIES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.3F)
            .alwaysEdible().build();

    // -------------------------------------------------------------------------
    // Stews — given by mushroom gals via ExchangeFeature (bowl → stew).
    // All stews match vanilla mushroom stew nutrition (6 / 0.6) and are
    // always edible so they can be consumed mid-combat.
    // The actual on-use effect is applied in MonstersStewItem.finishUsingItem().
    // -------------------------------------------------------------------------

    /**
     * Nether stew — Infernal, Crimson, Warped Gals.
     * On use: Fire Resistance for 3 s (60 ticks).
     */
    public static final FoodProperties STEW_NETHER = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

    /**
     * Poison stew — Inkcap Gal.
     * On use: Poisonous effect for 30 s (600 ticks).
     */
    public static final FoodProperties STEW_POISON = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

    /**
     * Molten stew — Molten Gal.
     * On use: Blazing effect for 30 s (600 ticks).
     */
    public static final FoodProperties STEW_MOLTEN = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

    /**
     * Puffball stew — Puffball Gal.
     * On use: Puffy effect for 30 s (600 ticks).
     */
    public static final FoodProperties STEW_PUFFBALL = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

    /**
     * Snowball stew — Snowball Gal.
     * On use: Chilly effect for 30 s (600 ticks).
     */
    public static final FoodProperties STEW_SNOWBALL = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

    /**
     * Soul Wanderer stew — Soul Wanderer Gal.
     * On use: Soul Wanderer's Touch for 30 s (600 ticks).
     */
    public static final FoodProperties STEW_SOUL_WANDERER = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).alwaysEdible().build();

} // Class: MonstersFood