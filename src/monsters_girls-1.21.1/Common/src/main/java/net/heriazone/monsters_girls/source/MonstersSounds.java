package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

/**
 * <p>Registry for all custom {@link SoundEvent}s added by Monsters &amp; Girls.</p>
 * <p>
 * <b>Single source of truth:</b> Every sound key defined in {@code sounds.json} has
 * exactly one corresponding {@link Holder} here. All code referencing a sound must use
 * these holders — never reference string keys directly.
 * <p>
 * <b>Architecture:</b> Uses vanilla {@link BuiltInRegistries#SOUND_EVENT} directly,
 * same pattern as {@link MonstersEffects} — no loader-specific API required. Holders
 * are populated in {@link #register()} and are valid for use anywhere after that call.
 * <p>
 * <b>Initialization:</b> {@link #register()} is called from {@code Monsters.init()}
 * in the Common entry point, before items or entities are registered.
 * <p>
 * <b>Category grouping:</b> Sounds are grouped by entity family, then by trigger type
 * (AMBIENT, HURT, DEATH, ATTACK, INTERACT) within each family — matching the
 * {@link net.heriazone.hzlib.api.entity.features.SoundFeature.SoundType} taxonomy.
 * <p>
 * <b>Design reference:</b> ADR_016 — Sound &amp; Animation Lifecycle System.
 */
public class MonstersSounds {

    // =========================================================
    // MANDRAKE — 3 entity-type variants with distinct ambients
    // =========================================================

    /** Mandrake Chorus ambient — "mandrakesounds" (deep earthy calls). */
    public static Holder<SoundEvent> MANDRAKE_CHORUS_AMBIENT;

    /**
     * Mandrake Flower ambient — "mandrake_song" (humming/singing).
     * <p>
     * <b>Dual use:</b> Also fires as an animation-linked INTERACT sound when the
     * {@code sing} or {@code sing2} specials play (see ADR_016 animation-linked sounds).
     */
    public static Holder<SoundEvent> MANDRAKE_FLOWER_AMBIENT;

    /** Mandrake Fructus ambient — "fruity_mandrake" (fruity vocal sounds). */
    public static Holder<SoundEvent> MANDRAKE_FRUCTUS_AMBIENT;

    /** Mandrake hurt — shared across all three variants. */
    public static Holder<SoundEvent> MANDRAKE_HURT;

    /** Mandrake death — shared across all three variants. */
    public static Holder<SoundEvent> MANDRAKE_DEATH;

    // =========================================================
    // MUSHROOM GALS
    // =========================================================

    /** Standard mushroom gal ambient — random idle vocalisations. */
    public static Holder<SoundEvent> MUSHROOM_AMBIENT;

    /**
     * Weird mushroom gal ambient — used by Inkcap and other "creepy" families.
     * Distinct from the standard ambient for sonic variety.
     */
    public static Holder<SoundEvent> MUSHROOM_AMBIENT_WEIRD;

    /** Mushroom gal greeting — plays when a player approaches or pets a tamed gal. */
    public static Holder<SoundEvent> MUSHROOM_GREET;

    /** Weird mushroom gal greeting — Inkcap variant of the greeting sound. */
    public static Holder<SoundEvent> MUSHROOM_GREET_WEIRD;

    // =========================================================
    // SLIME GAL
    // =========================================================

    /** Slime gal ambient — bubbly idle sounds. */
    public static Holder<SoundEvent> SLIME_AMBIENT;

    /** Slime gal hurt. */
    public static Holder<SoundEvent> SLIME_HURT;

    /**
     * Slime gal pop — plays when the slime performs a special bounce/pop action.
     * Animation-linked INTERACT sound.
     */
    public static Holder<SoundEvent> SLIME_POP;

    // =========================================================
    // WISP GAL
    // =========================================================

    /** Wisp gal ambient — ghostly laughs and murmurs. */
    public static Holder<SoundEvent> WISP_AMBIENT;

    /** Wisp gal hurt. */
    public static Holder<SoundEvent> WISP_HURT;

    /** Wisp gal death. */
    public static Holder<SoundEvent> WISP_DEATH;

    /**
     * Wisp gal Vex-kill sound — plays when Wisp instantly kills a Vex.
     * Triggered in {@code WispEntity.doHurtTarget()} on Vex/Phantom targets.
     */
    public static Holder<SoundEvent> WISP_VEX_KILL;

    // =========================================================
    // SPOOK GAL
    // =========================================================

    /** Spook gal ambient — haunting laughs. */
    public static Holder<SoundEvent> SPOOK_AMBIENT;

    /** Spook gal hurt. */
    public static Holder<SoundEvent> SPOOK_HURT;

    /** Spook gal attack — plays on melee swing. */
    public static Holder<SoundEvent> SPOOK_ATTACK;

    // =========================================================
    // GOURDRAGORA — variant-keyed by MODEL_VARIANT (size)
    // =========================================================

    /**
     * Gourdragora default-size ambient — giggles and singing.
     * <p>
     * <b>Variant key:</b> {@code "gourdragora_girl_default"} in {@code SoundFeature}.
     */
    public static Holder<SoundEvent> GOURDRAGORA_AMBIENT;

    /**
     * Gourdragora mega/big-size ambient — deeper, louder giggles.
     * <p>
     * <b>Variant key:</b> {@code "gourdragora_girl_big"} in {@code SoundFeature}
     * (the model key returned by {@code appearance.getModelKey()} for the big variant).
     * The sound event name is {@code mega_gourdragora_giggles} in sounds.json.
     * <p>
     * <b>Naming note:</b> The constant is named MEGA to match the sounds.json event name;
     * the variant key uses "big" to match the model variant key. These are intentionally
     * different — "big" is the internal model identifier, "mega" is the audio identity.
     */
    public static Holder<SoundEvent> GOURDRAGORA_MEGA_AMBIENT;

    /**
     * Gourdragora mini-size ambient — higher-pitched giggles.
     * <p>
     * <b>Variant key:</b> {@code "gourdragora_girl_mini"} in {@code SoundFeature}
     * (the shared model key, without color prefix).
     */
    public static Holder<SoundEvent> GOURDRAGORA_MINI_AMBIENT;

    /**
     * Gourdragora roar — plays on attack/special reaction.
     * Animation-linked ATTACK or INTERACT sound.
     */
    public static Holder<SoundEvent> GOURDRAGORA_ROAR;

    // =========================================================
    // GLOBBERIE GAL
    // =========================================================

    /** Globberie gal death. */
    public static Holder<SoundEvent> GLOBBERIE_DEATH;

    // =========================================================
    // PUFFBALL GAL (Ender Mushroom Gal)
    // =========================================================

    /**
     * Puffball deflating — plays when the puff-out animation fires.
     * Animation-linked INTERACT sound keyed to {@code "puff_out"} animation.
     */
    public static Holder<SoundEvent> PUFFBALL_PUFF_OUT;

    /**
     * Puffball inflating — plays when the puff-up animation fires.
     * Animation-linked INTERACT sound keyed to {@code "puff_up"} animation.
     */
    public static Holder<SoundEvent> PUFFBALL_PUFF_IN;

    // =========================================================
    // Registration
    // =========================================================

    /**
     * Registers all custom sound events into the vanilla registry.
     * <p>
     * <b>Call once</b> from {@code Monsters.init()} before items or entities are registered.
     * All holders are populated immediately and safe to reference anywhere after this call.
     */
    public static void register() {
        // MANDRAKE
        MANDRAKE_CHORUS_AMBIENT  = sound(MonstersConstant.SOUND_MANDRAKE_CHORUS_AMBIENT);
        MANDRAKE_FLOWER_AMBIENT  = sound(MonstersConstant.SOUND_MANDRAKE_FLOWER_AMBIENT);
        MANDRAKE_FRUCTUS_AMBIENT = sound(MonstersConstant.SOUND_MANDRAKE_FRUCTUS_AMBIENT);
        MANDRAKE_HURT            = sound(MonstersConstant.SOUND_MANDRAKE_HURT);
        MANDRAKE_DEATH           = sound(MonstersConstant.SOUND_MANDRAKE_DEATH);

        // MUSHROOM
        MUSHROOM_AMBIENT       = sound(MonstersConstant.SOUND_MUSHROOM_AMBIENT);
        MUSHROOM_AMBIENT_WEIRD = sound(MonstersConstant.SOUND_MUSHROOM_AMBIENT_WEIRD);
        MUSHROOM_GREET         = sound(MonstersConstant.SOUND_MUSHROOM_GREET);
        MUSHROOM_GREET_WEIRD   = sound(MonstersConstant.SOUND_MUSHROOM_GREET_WEIRD);

        // SLIME
        SLIME_AMBIENT = sound(MonstersConstant.SOUND_SLIME_AMBIENT);
        SLIME_HURT    = sound(MonstersConstant.SOUND_SLIME_HURT);
        SLIME_POP     = sound(MonstersConstant.SOUND_SLIME_POP);

        // WISP
        WISP_AMBIENT  = sound(MonstersConstant.SOUND_WISP_AMBIENT);
        WISP_HURT     = sound(MonstersConstant.SOUND_WISP_HURT);
        WISP_DEATH    = sound(MonstersConstant.SOUND_WISP_DEATH);
        WISP_VEX_KILL = sound(MonstersConstant.SOUND_WISP_VEX_KILL);

        // SPOOK
        SPOOK_AMBIENT = sound(MonstersConstant.SOUND_SPOOK_LAUGH);
        SPOOK_HURT    = sound(MonstersConstant.SOUND_SPOOK_HURT);
        SPOOK_ATTACK  = sound(MonstersConstant.SOUND_SPOOK_ATTACK);

        // GOURDRAGORA
        GOURDRAGORA_AMBIENT      = sound(MonstersConstant.SOUND_GOURDRAGORA_AMBIENT);
        GOURDRAGORA_MEGA_AMBIENT = sound(MonstersConstant.SOUND_GOURDRAGORA_MEGA_AMBIENT);
        GOURDRAGORA_MINI_AMBIENT = sound(MonstersConstant.SOUND_GOURDRAGORA_MINI_AMBIENT);
        GOURDRAGORA_ROAR         = sound(MonstersConstant.SOUND_GOURDRAGORA_ROAR);

        // GLOBBERIE
        GLOBBERIE_DEATH = sound(MonstersConstant.SOUND_GLOBBERIE_DEATH);

        // PUFFBALL
        PUFFBALL_PUFF_OUT = sound(MonstersConstant.SOUND_PUFFBALL_PUFF_OUT);
        PUFFBALL_PUFF_IN  = sound(MonstersConstant.SOUND_PUFFBALL_PUFF_IN);
    } // register ()

    // -- Private Helpers --

    /**
     * Registers a sound event using a fixed-range event (volume baked into the JSON).
     * All Monsters &amp; Girls sounds are fixed-range — their distance is determined by
     * the {@code sounds.json} entry, not by code.
     */
    private static Holder<SoundEvent> sound(String key) {
        return Registry.registerForHolder(
                BuiltInRegistries.SOUND_EVENT,
                MonstersIdentifier.getId(key),
                SoundEvent.createFixedRangeEvent(MonstersIdentifier.getId(key), 16.0f));
    } // sound ()

} // Class: MonstersSounds
