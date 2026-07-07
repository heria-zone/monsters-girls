package net.heriazone.monsters_girls.source;

import net.heriazone.monsters_girls.MonstersIdentifier;
import net.heriazone.monsters_girls.entity.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

/**
 * <p>Registry for all custom {@link MobEffect} types added by Monsters &amp; Girls.<p>
 * <p>
 * <b>Architecture:</b> Uses vanilla {@link BuiltInRegistries#MOB_EFFECT} directly
 * — no loader-specific API required. This class lives in Common so that effect
 * holders can be referenced from Common code (stew item on-use callbacks,
 * entity combat overrides) without any Fabric dependency.
 * <p>
 * <b>Initialization:</b> Call {@link #register()} once during mod init (from
 * {@code Monsters.init()} in the Common entry point). The Fabric initializer
 * calls {@code Monsters.init()} before any item or entity registration, so
 * effect holders are always populated before they are referenced.
 * <p>
 * <b>Texture path convention:</b> Each effect's icon is resolved automatically
 * by Minecraft from {@code assets/monsters_girls/textures/mob_effect/<key>.png}.
 * All five textures are already authored and present in the Common resources.
 */
public class MonstersEffects {

    // -- Effect Holders --

    /**
     * Poisonous — attacker infects targets with Poison; holder immune to Poison.
     * <p>Applied by: Inkcap Gal stew and Inkcap Gal combat aura.
     */
    public static Holder<MobEffect> POISONOUS;

    /**
     * Chilly — attacker slows and freezes targets; holder immune to Freezing.
     * <p>Applied by: Snowball Gal stew and Snowball Gal combat aura.
     */
    public static Holder<MobEffect> CHILLY;

    /**
     * Blazing — holder immune to fire; attacks set targets on fire.
     * <p>Applied by: Molten Gal stew and Molten Gal combat aura.
     */
    public static Holder<MobEffect> BLAZING;

    /**
     * Soul Wanderer's Touch — attacks inflict Wither + grant holder Regeneration;
     * holder immune to Wither; 2× damage to undead.
     * <p>Applied by: Soul Wanderer Gal stew and Soul Wanderer Gal combat aura.
     */
    public static Holder<MobEffect> SOUL_WANDERERS_TOUCH;

    /**
     * Puffy — high jump boost + slow falling.
     * <p>Applied by: Puffball Gal stew. Also granted passively by nearby tamed Puffball Gal.
     */
    public static Holder<MobEffect> PUFFY;

    // -- Registration --

    /**
     * Registers all custom mob effects into the vanilla registry.
     * <p>
     * <b>Call once</b> from {@code Monsters.init()} before items or entities are registered.
     * Holders are populated immediately and safe to reference anywhere after this call.
     */
    public static void register() {
        POISONOUS          = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MonstersIdentifier.getId("poisonous"),            new PoisonousEffect());
        CHILLY             = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MonstersIdentifier.getId("chilly"),               new ChillyEffect());
        BLAZING            = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MonstersIdentifier.getId("blazing"),              new BlazingEffect());
        SOUL_WANDERERS_TOUCH = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MonstersIdentifier.getId("soul_wanderers_touch"), new SoulWanderersTouchEffect());
        PUFFY              = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, MonstersIdentifier.getId("puffy"),                new PuffyEffect());
    } // register ()

} // Class: MonstersEffects
