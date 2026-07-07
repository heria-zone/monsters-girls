package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.MonstersIdentifier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

/**
 * <p>Registry for all custom {@link Potion} types added by Monsters &amp; Girls.<p>
 * <p>
 * <b>Architecture:</b> Uses vanilla {@link BuiltInRegistries#POTION} directly —
 * no loader-specific API required. Lives in Common so holders can be referenced
 * from Common code and by the Fabric brewing recipe registration.
 * <p>
 * <b>Potion tiers follow vanilla conventions:</b>
 * <ul>
 *   <li><b>Regular</b>  — 3 min (3 600 ticks), amplifier 0</li>
 *   <li><b>Long</b>     — 8 min (9 600 ticks), amplifier 0  (brewed with Redstone)</li>
 *   <li><b>Strong</b>   — 1 min 30 s (1 800 ticks), amplifier 1  (brewed with Glowstone)</li>
 * </ul>
 * Effects that are purely passive or binary (Blazing, Soul Wanderer's Touch) don't
 * benefit from a Strong tier — amplifier 0 already gives the full behavior.
 * They still get a Long variant.
 * <p>
 * <b>Initialization:</b> Call {@link #register()} once from {@code Monsters.init()},
 * after {@code MonstersEffects.register()} — effects must be registered first.
 * Brewing recipes are wired separately in Fabric's {@code MonstersPotions.registerBrewingRecipes()}.
 * <p>
 * <b>Translation key generation:</b> The {@code String name} argument passed to the
 * {@link Potion} constructor is used verbatim to build the item name translation key:
 * {@code item.minecraft.<item_type>.effect.<name>}. To produce namespaced keys like
 * {@code item.minecraft.potion.effect.monsters_girls.poisonous}, the name must be
 * {@code "poisonous"} — <em>not</em> just {@code "poisonous"}.
 * The registry ResourceLocation (used for the registry id) is separate from this name.
 */
public class MonstersPotions {

    // -------------------------------------------------------------------------
    // Poisonous — Inkcap Gal
    // -------------------------------------------------------------------------

    /** Potion of Poisonous (3 min). Brewed: Awkward + Fermented Spider Eye. */
    public static Holder<Potion> POISONOUS;
    /** Potion of Poisonous (8 min). Brewed: Poisonous + Redstone. */
    public static Holder<Potion> LONG_POISONOUS;
    /** Potion of Poisonous II (1 min 30 s). Brewed: Poisonous + Glowstone. */
    public static Holder<Potion> STRONG_POISONOUS;

    // -------------------------------------------------------------------------
    // Chilly — Snowball Gal
    // -------------------------------------------------------------------------

    /** Potion of Chilly (3 min). Brewed: Awkward + Snowball. */
    public static Holder<Potion> CHILLY;
    /** Potion of Chilly (8 min). Brewed: Chilly + Redstone. */
    public static Holder<Potion> LONG_CHILLY;
    /** Potion of Chilly II (1 min 30 s). Brewed: Chilly + Glowstone. */
    public static Holder<Potion> STRONG_CHILLY;

    // -------------------------------------------------------------------------
    // Blazing — Molten Gal
    // -------------------------------------------------------------------------

    /** Potion of Blazing (3 min). Brewed: Awkward + Fire Charge. */
    public static Holder<Potion> BLAZING;
    /** Potion of Blazing (8 min). Brewed: Blazing + Redstone. */
    public static Holder<Potion> LONG_BLAZING;

    // -------------------------------------------------------------------------
    // Soul Wanderer's Touch — Soul Wanderer Gal
    // -------------------------------------------------------------------------

    /** Potion of Soul Wanderer's Touch (3 min). Brewed: Awkward + Nether Wart (dark). */
    public static Holder<Potion> SOUL_WANDERERS_TOUCH;
    /** Potion of Soul Wanderer's Touch (8 min). Brewed: Soul Wanderer's Touch + Redstone. */
    public static Holder<Potion> LONG_SOUL_WANDERERS_TOUCH;

    // -------------------------------------------------------------------------
    // Puffy — Puffball Gal
    // -------------------------------------------------------------------------

    /** Potion of Puffy (3 min). Brewed: Awkward + Chorus Fruit. */
    public static Holder<Potion> PUFFY;
    /** Potion of Puffy (8 min). Brewed: Puffy + Redstone. */
    public static Holder<Potion> LONG_PUFFY;
    /** Potion of Puffy II (1 min 30 s). Brewed: Puffy + Glowstone. */
    public static Holder<Potion> STRONG_PUFFY;

    // -------------------------------------------------------------------------
    // Registration
    // -------------------------------------------------------------------------

    /**
     * Registers all custom potions into {@link BuiltInRegistries#POTION}.
     * <p>
     * <b>Call after</b> {@code MonstersEffects.register()} — effect holders must exist first.
     * Call from {@code Monsters.init()}.
     */
    public static void register() {
        // -- Poisonous --
        POISONOUS = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("poisonous"),
                new Potion("poisonous",
                        new MobEffectInstance(MonstersEffects.POISONOUS, 3600, 0)));

        LONG_POISONOUS = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("long_poisonous"),
                new Potion("long_poisonous",
                        new MobEffectInstance(MonstersEffects.POISONOUS, 9600, 0)));

        STRONG_POISONOUS = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("strong_poisonous"),
                new Potion("strong_poisonous",
                        new MobEffectInstance(MonstersEffects.POISONOUS, 1800, 1)));

        // -- Chilly --
        CHILLY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("chilly"),
                new Potion("chilly",
                        new MobEffectInstance(MonstersEffects.CHILLY, 3600, 0)));

        LONG_CHILLY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("long_chilly"),
                new Potion("long_chilly",
                        new MobEffectInstance(MonstersEffects.CHILLY, 9600, 0)));

        STRONG_CHILLY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("strong_chilly"),
                new Potion("strong_chilly",
                        new MobEffectInstance(MonstersEffects.CHILLY, 1800, 1)));

        // -- Blazing --
        BLAZING = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("blazing"),
                new Potion("blazing",
                        new MobEffectInstance(MonstersEffects.BLAZING, 3600, 0)));

        LONG_BLAZING = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("long_blazing"),
                new Potion("long_blazing",
                        new MobEffectInstance(MonstersEffects.BLAZING, 9600, 0)));

        // -- Soul Wanderer's Touch --
        SOUL_WANDERERS_TOUCH = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("soul_wanderers_touch"),
                new Potion("soul_wanderers_touch",
                        new MobEffectInstance(MonstersEffects.SOUL_WANDERERS_TOUCH, 3600, 0)));

        LONG_SOUL_WANDERERS_TOUCH = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("long_soul_wanderers_touch"),
                new Potion("long_soul_wanderers_touch",
                        new MobEffectInstance(MonstersEffects.SOUL_WANDERERS_TOUCH, 9600, 0)));

        // -- Puffy --
        PUFFY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("puffy"),
                new Potion("puffy",
                        new MobEffectInstance(MonstersEffects.PUFFY, 3600, 0)));

        LONG_PUFFY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("long_puffy"),
                new Potion("long_puffy",
                        new MobEffectInstance(MonstersEffects.PUFFY, 9600, 0)));

        STRONG_PUFFY = Registry.registerForHolder(BuiltInRegistries.POTION,
                MonstersIdentifier.getId("strong_puffy"),
                new Potion("strong_puffy",
                        new MobEffectInstance(MonstersEffects.PUFFY, 1800, 1)));
    } // register ()

} // Class: MonstersPotions
