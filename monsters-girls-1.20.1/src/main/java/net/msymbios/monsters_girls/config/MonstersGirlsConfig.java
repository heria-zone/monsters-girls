package net.msymbios.monsters_girls.config;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.biome.BiomeKeys;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.config.internal.SimpleConfig;
import net.msymbios.monsters_girls.config.internal.ConfigProvider;
import net.msymbios.monsters_girls.entity.enums.EntityAttribute;
import net.msymbios.monsters_girls.entity.enums.EntityVariant;
import net.msymbios.monsters_girls.entity.internal.InternalMetric;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class MonstersGirlsConfig {

    // -- Variables --
    public static SimpleConfig CONFIG;
    private static ConfigProvider PROVIDER;

    // -- Methods --
    public static void register() {
        create();
        assign();
    } // register ()

    private static void create() {
        PROVIDER = new ConfigProvider();
        String additional = "\n";

        // GENERAL
        PROVIDER.addComment("[General]");
        PROVIDER.addKeyValuePair(new Pair<>("general.look-range", 6.0F),             "How much should the head rotate while looking");
        PROVIDER.addKeyValuePair(new Pair<>("general.attack-chance", 5),           "Probability of attacking when attacked");
        PROVIDER.addKeyValuePair(new Pair<>("general.global-heal", true),          "Probability of attacking when attacked");
        PROVIDER.addKeyValuePair(new Pair<>("general.heal-interval", 50),          "Automatic recovery interval");
        PROVIDER.addKeyValuePair(new Pair<>("general.wary-time", 50),              "Time while being in combat mode", additional);

        // ENTITY | BEE GIRL
        PROVIDER.addComment("[Bee Girl]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.movement-fly-speed", 0.8F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.defence", 0.5F),                "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.bee.girl.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA JACK'O LANTERN
        PROVIDER.addComment("[Gourdragora Jack'O Lantern]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.max-health", 20F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.attack-damage", 7F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.defence", 3F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA JACK'O LANTERN BIG
        PROVIDER.addComment("[Gourdragora Jack'O Lantern Big]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.max-health", 30F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.attack-damage", 12F),           "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.defence", 5F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.knockback-attack", 3F),         "Knockback Attack");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.knockback-resistance", 5F),     "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.follow-distance-max", 12F),     "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.spawn-weight", 10),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_big.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA JACK'O LANTERN MINI
        PROVIDER.addComment("[Gourdragora Jack'O Lantern Mini]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.attack-damage", 5F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.defence", 1F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.jack_lantern_mini.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA PUMPKIN
        PROVIDER.addComment("[Gourdragora Pumpkin]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.max-health", 20F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.attack-damage", 7F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.defence", 3F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.spawn-weight", 10),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA PUMPKIN BIG
        PROVIDER.addComment("[Gourdragora Pumpkin Big]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.max-health", 30F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.attack-damage", 12F),           "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.defence", 5F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.knockback-attack", 3F),         "Knockback Attack");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.knockback-resistance", 5F),     "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.follow-distance-max", 12F),     "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.spawn-weight", 5),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_big.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | GOURDRAGORA PUMPKIN MINI
        PROVIDER.addComment("[Gourdragora Pumpkin Mini]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.attack-damage", 5F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.attack-speed", 1F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.movement-follow-owner", 0.7F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.defence", 1F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.spawn-weight", 10),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.gourdragora.pumpkin_mini.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MANDRAKE BROWN
        PROVIDER.addComment("[Mandrake Brown]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.max-health", 10F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.movement-follow-owner", 0.3F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.knockback-resistance", 0.2F),   "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.brown.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MANDRAKE GREEN
        PROVIDER.addComment("[Mandrake Green]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.max-health", 10F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.movement-follow-owner", 0.3F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.knockback-resistance", 0.2F),   "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.green.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MANDRAKE GLOW BERRY
        PROVIDER.addComment("[Mandrake Fruit Glow Berry]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.max-health", 10F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.movement-follow-owner", 0.3F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.knockback-resistance", 0.2F),   "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.glow_berry.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MANDRAKE CHORUS
        PROVIDER.addComment("[Mandrake Fruit Chorus]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.max-health", 10F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.movement-follow-owner", 0.3F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.knockback-resistance", 0.2F),   "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mandrake.chorus.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM BROWN
        PROVIDER.addComment("[Mushroom Brown]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.brown.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM CRIMSON
        PROVIDER.addComment("[Mushroom Crimson]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM CRIMSON RARE
        PROVIDER.addComment("[Mushroom Crimson Rare]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.crimson_rare.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM ENDER PUFFBALL
        PROVIDER.addComment("[Mushroom Ender Puffball]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ender_puffball.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM INFERNAL
        PROVIDER.addComment("[Mushroom Infernal]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.infernal.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM INK CAP
        PROVIDER.addComment("[Mushroom Ink Cap]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.spawn-weight", 10),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.ink_cap.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM MOLTEN
        PROVIDER.addComment("[Mushroom Molten]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.spawn-weight", 40),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.molten.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM FLY AGARIC RED
        PROVIDER.addComment("[Mushroom Fly Agaric Red]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_red.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM FLY AGARIC YELLOW
        PROVIDER.addComment("[Mushroom Fly Agaric Yellow]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.fly_agaric_yellow.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM SOUL WANDERER
        PROVIDER.addComment("[Mushroom Soul Wanderer]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.soul_wanderer.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM WARPED
        PROVIDER.addComment("[Mushroom Warped]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM WARPED RARE
        PROVIDER.addComment("[Mushroom Warped Rare]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.warped_rare.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | MUSHROOM SNOWBALL
        PROVIDER.addComment("[Mushroom Snowball]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.attack-damage", 2F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.movement-melee-attack", 0.3F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.mushroom.snowball.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | SLIME BLUE
        PROVIDER.addComment("[Slime Blue]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.max-health", 15F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.attack-damage", 5F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.movement-melee-attack", 0.8F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.movement-follow-owner", 0.6F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.knockback-resistance", 1F),     "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.spawn-weight", 25),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.slime.blue.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | SPOOK PEACH
        PROVIDER.addComment("[Spook Peach]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.max-health", 20F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.movement-melee-attack", 0.9F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.movement-follow-owner", 0.8F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.movement-fly-speed", 0.8F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.knockback-resistance", 1F),     "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.peach.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | SPOOK TEAL
        PROVIDER.addComment("[Spook Teal]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.max-health", 20F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.movement-melee-attack", 0.9F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.movement-follow-owner", 0.8F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.movement-wander-around", 0.6F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.movement-fly-speed", 0.8F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.movement-speed", 0.6F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.defence", 0F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.knockback-resistance", 1F),     "Knockback Resistance");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.spook.teal.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | WISP BLUE
        PROVIDER.addComment("[Wisp Blue]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.max-health", 18F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.attack-speed", 1.2F),           "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.movement-melee-attack", 0.5F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.wisp.movement-fly-speed", 0.5F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.defence", 0.5F),                "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.spawn-weight", 20),             "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.blue.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | WISP GREEN
        PROVIDER.addComment("[Wisp Green]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.max-health", 18F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.attack-speed", 1.2F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.movement-melee-attack", 0.5F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.movement-fly-speed", 0.5F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.defence", 0.5F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.green.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group", additional);

        // ENTITY | WISP YELLOW
        PROVIDER.addComment("[Wisp Yellow]");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.max-health", 18F),              "Maximum Health");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.attack-damage", 3F),            "Attack Damage");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.attack-speed", 1.2F),             "Attack Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.movement-melee-attack", 0.5F),  "Movement speed when it is melee attacking");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.movement-follow-owner", 0.4F),  "Movement speed when following player");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.movement-wander-around", 0.3F), "Movement speed while it is wandering around");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.movement-fly-speed", 0.5F),     "Movement Speed when its flying");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.movement-speed", 0.3F),         "Movement Speed");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.defence", 0.5F),                  "Defence");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.follow-distance-max", 7F),      "Maximum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.follow-distance-min", 2F),      "Minimum distance allowed while following");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.spawn-weight", 20),             "How frequent should this mob spawn");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.spawn-min-group", 1),           "Minimum mobs allowed to spawn in a group");
        PROVIDER.addKeyValuePair(new Pair<>("entity.wisp.yellow.spawn-max-group", 2),           "Maximum mobs allowed to spawn in a group");

    } // create ()

    private static void assign() {
        CONFIG = SimpleConfig.of(MonstersGirls.MODID + "-config").provider(PROVIDER).request();

        // GENERAL
        InternalMetric.LOOK_RANGE               = CONFIG.getOrDefault("general.look-range", 6.0F);
        InternalMetric.ATTACK_CHANCE            = CONFIG.getOrDefault("general.attack-chance", 5);
        InternalMetric.GLOBAL_AUTO_HEAL         = CONFIG.getOrDefault("general.global-heal", true);
        InternalMetric.GLOBAL_HEAL_INTERVAL     = CONFIG.getOrDefault("general.heal-interval", 50);
        InternalMetric.WARY_TIME                = CONFIG.getOrDefault("general.wary-time", 50);

        Predicate<LivingEntity> generalAvoidEntities = entity -> entity instanceof Monster && !(entity instanceof CreeperEntity);

        // ENTITY | BEE GIRL
        InternalMetric.ATTRIBUTES.put(EntityVariant.Bee, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.bee.girl.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.bee.girl.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.bee.girl.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.bee.girl.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.bee.girl.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.bee.girl.movement-wander-around", 0.6F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.bee.girl.movement-fly-speed", 0.8F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.bee.girl.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.bee.girl.defence", 0.5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.bee.girl.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.bee.girl.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.Bee, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.bee.girl.spawn-weight", 20),
                CONFIG.getOrDefault("entity.bee.girl.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.bee.girl.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.SUNFLOWER_PLAINS), generalAvoidEntities));

        // ENTITY | GOURDRAGORA JACK'O LANTERN
        InternalMetric.ATTRIBUTES.put(EntityVariant.JackOLantern, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.jack_lantern.max-health", 20F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.jack_lantern.attack-damage", 7F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.jack_lantern.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.jack_lantern.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.jack_lantern.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.jack_lantern.defence", 3F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.JackOLantern, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern.spawn-weight", 20),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST), generalAvoidEntities));

        // ENTITY | GOURDRAGORA JACK'O LANTERN BIG
        InternalMetric.ATTRIBUTES.put(EntityVariant.JackOLanternBig, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.max-health", 30F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.attack-damage", 12F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.defence", 5F));
            put(EntityAttribute.KNOCKBACK_ATTACK,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.knockback-attack", 3F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.knockback-resistance", 5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.follow-distance-max", 12F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.JackOLanternBig, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.spawn-weight", 10),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_big.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST), generalAvoidEntities));

        // ENTITY | GOURDRAGORA JACK'O LANTERN MINI
        InternalMetric.ATTRIBUTES.put(EntityVariant.JackOLanternMini, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.attack-damage", 5F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.defence", 1F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.JackOLanternMini, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.spawn-weight", 20),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.jack_lantern_mini.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST), generalAvoidEntities));

        // ENTITY | GOURDRAGORA PUMPKIN
        InternalMetric.ATTRIBUTES.put(EntityVariant.Pumpkin, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.pumpkin.max-health", 20F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.pumpkin.attack-damage", 7F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.pumpkin.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.pumpkin.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.pumpkin.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.pumpkin.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.pumpkin.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.pumpkin.defence", 3F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.pumpkin.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.pumpkin.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.Pumpkin, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.pumpkin.spawn-weight", 10),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin.spawn-max-group", 2),
                List.of(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS), generalAvoidEntities));

        // ENTITY | GOURDRAGORA PUMPKIN BIG
        InternalMetric.ATTRIBUTES.put(EntityVariant.PumpkinBig, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.max-health", 30F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.attack-damage", 12F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.defence", 5F));
            put(EntityAttribute.KNOCKBACK_ATTACK,       CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.knockback-attack", 3F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.knockback-resistance", 5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.follow-distance-max", 12F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.PumpkinBig, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.spawn-weight", 5),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_big.spawn-max-group", 2),
                List.of(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS), generalAvoidEntities));

        // ENTITY | GOURDRAGORA PUMPKIN MINI
        InternalMetric.ATTRIBUTES.put(EntityVariant.PumpkinMini, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.attack-damage", 5F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.attack-speed", 1F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.movement-follow-owner", 0.7F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.defence", 1F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.PumpkinMini, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.spawn-weight", 10),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.gourdragora.pumpkin_mini.spawn-max-group", 2),
                List.of(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS), generalAvoidEntities));

        // ENTITY | MANDRAKE BROWN
        InternalMetric.ATTRIBUTES.put(EntityVariant.MandrakeBrown, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mandrake.brown.max-health", 10F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mandrake.brown.movement-follow-owner", 0.3F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mandrake.brown.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mandrake.brown.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mandrake.brown.defence", 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.mandrake.brown.knockback-resistance", 0.2F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mandrake.brown.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mandrake.brown.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MandrakeBrown, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mandrake.brown.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mandrake.brown.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mandrake.brown.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST), generalAvoidEntities));

        // ENTITY | MANDRAKE GREEN
        InternalMetric.ATTRIBUTES.put(EntityVariant.MandrakeGreen, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mandrake.green.max-health", 10F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mandrake.green.movement-follow-owner", 0.3F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mandrake.green.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mandrake.green.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mandrake.green.defence", 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.mandrake.green.knockback-resistance", 0.2F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mandrake.green.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mandrake.green.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MandrakeGreen, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mandrake.green.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mandrake.green.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mandrake.green.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST), generalAvoidEntities));

        // ENTITY | MANDRAKE GLOW BERRY
        InternalMetric.ATTRIBUTES.put(EntityVariant.MandrakeGlowBerry, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mandrake.glow_berry.max-health", 10F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mandrake.glow_berry.movement-follow-owner", 0.3F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mandrake.glow_berry.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mandrake.glow_berry.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mandrake.glow_berry.defence", 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.mandrake.glow_berry.knockback-resistance", 0.2F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mandrake.glow_berry.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mandrake.glow_berry.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MandrakeGlowBerry, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mandrake.glow_berry.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mandrake.glow_berry.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mandrake.glow_berry.spawn-max-group", 2),
                List.of(BiomeKeys.LUSH_CAVES), generalAvoidEntities));

        // ENTITY | MANDRAKE CHORUS
        InternalMetric.ATTRIBUTES.put(EntityVariant.MandrakeChorus, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mandrake.chorus.max-health", 10F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mandrake.chorus.movement-follow-owner", 0.3F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mandrake.chorus.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mandrake.chorus.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mandrake.chorus.defence", 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE,   CONFIG.getOrDefault("entity.mandrake.chorus.knockback-resistance", 0.2F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mandrake.chorus.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mandrake.chorus.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MandrakeChorus, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mandrake.chorus.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mandrake.chorus.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mandrake.chorus.spawn-max-group", 2),
                List.of(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS), generalAvoidEntities));

        // ENTITY | MUSHROOM BROWN
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomBrown, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.brown.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.brown.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.brown.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.brown.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.brown.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.brown.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.brown.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.brown.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.brown.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.brown.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomBrown,                InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.brown.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.brown.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.brown.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA), generalAvoidEntities));

        // ENTITY | MUSHROOM CRIMSON
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomCrimson, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.crimson.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.crimson.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.crimson.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.crimson.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.crimson.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.crimson.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.crimson.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.crimson.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.crimson.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.crimson.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomCrimson,              InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.crimson.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.crimson.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.crimson.spawn-max-group", 2),
                List.of(BiomeKeys.CRIMSON_FOREST), generalAvoidEntities));

        // ENTITY | MUSHROOM CRIMSON RARE
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomCrimsonRare, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.crimson_rare.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.crimson_rare.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.crimson_rare.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.crimson_rare.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.crimson_rare.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.crimson_rare.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.crimson_rare.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.crimson_rare.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.crimson_rare.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.crimson_rare.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomCrimsonRare,          InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.crimson_rare.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.crimson_rare.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.crimson_rare.spawn-max-group", 2),
                List.of(BiomeKeys.CRIMSON_FOREST), generalAvoidEntities));

        // ENTITY | MUSHROOM ENDER PUFFBALL
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomEnderPuffball, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.ender_puffball.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.ender_puffball.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.ender_puffball.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.ender_puffball.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.ender_puffball.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.ender_puffball.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.ender_puffball.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.ender_puffball.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.ender_puffball.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.ender_puffball.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomEnderPuffball,        InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.ender_puffball.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.ender_puffball.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.ender_puffball.spawn-max-group", 2),
                List.of(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS), generalAvoidEntities));

        // ENTITY | MUSHROOM INFERNAL
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomInfernal, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.infernal.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.infernal.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.infernal.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.infernal.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.infernal.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.infernal.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.infernal.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.infernal.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.infernal.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.infernal.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomInfernal,             InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.infernal.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.infernal.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.infernal.spawn-max-group", 2),
                List.of(BiomeKeys.NETHER_WASTES), generalAvoidEntities));

        // ENTITY | MUSHROOM INK CAP
        InternalMetric.ATTRIBUTES.put(EntityVariant.FungusInkCap, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.ink_cap.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.ink_cap.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.ink_cap.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.ink_cap.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.ink_cap.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.ink_cap.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.ink_cap.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.ink_cap.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.ink_cap.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.ink_cap.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.FungusInkCap,                 InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.ink_cap.spawn-weight", 10),
                CONFIG.getOrDefault("entity.mushroom.ink_cap.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.ink_cap.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST), generalAvoidEntities));

        // ENTITY | MUSHROOM MOLTEN
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomMolten, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.molten.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.molten.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.molten.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.molten.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.molten.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.molten.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.molten.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.molten.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.molten.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.molten.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomMolten,               InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.molten.spawn-weight", 40),
                CONFIG.getOrDefault("entity.mushroom.molten.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.molten.spawn-max-group", 2),
                List.of(BiomeKeys.BASALT_DELTAS), generalAvoidEntities));

        // ENTITY | MUSHROOM FLY AGARIC RED
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomFlyAgaricRed, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomFlyAgaricRed,         InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_red.spawn-max-group", 2),
                List.of(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.MUSHROOM_FIELDS, BiomeKeys.TAIGA), generalAvoidEntities));

        // ENTITY | MUSHROOM FLY AGARIC YELLOW
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomFlyAgaricYellow, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomFlyAgaricYellow,      InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.fly_agaric_yellow.spawn-max-group", 2),
                List.of(BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), generalAvoidEntities));

        // ENTITY | MUSHROOM SOUL WANDERER
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomSoulWanderer, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.soul_wanderer.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.soul_wanderer.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.soul_wanderer.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.soul_wanderer.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.soul_wanderer.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.soul_wanderer.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.soul_wanderer.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.soul_wanderer.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.soul_wanderer.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.soul_wanderer.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomSoulWanderer,         InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.soul_wanderer.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.soul_wanderer.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.soul_wanderer.spawn-max-group", 2),
                List.of(BiomeKeys.SOUL_SAND_VALLEY), generalAvoidEntities));

        // ENTITY | MUSHROOM WARPED
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomWarped, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.warped.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.warped.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.warped.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.warped.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.warped.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.warped.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.warped.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.warped.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.warped.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.warped.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomWarped,               InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.warped.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.warped.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.warped.spawn-max-group", 2),
                List.of(BiomeKeys.WARPED_FOREST), generalAvoidEntities));

        // ENTITY | MUSHROOM WARPED RARE
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomWarpedRare, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.warped_rare.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.warped_rare.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.warped_rare.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.warped_rare.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.warped_rare.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.warped_rare.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.warped_rare.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.warped_rare.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.warped_rare.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.warped_rare.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomWarpedRare,           InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.warped_rare.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.warped_rare.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.warped_rare.spawn-max-group", 2),
                List.of(BiomeKeys.WARPED_FOREST), generalAvoidEntities));

        // ENTITY | MUSHROOM SNOWBALL
        InternalMetric.ATTRIBUTES.put(EntityVariant.MushroomSnowball, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.mushroom.snowball.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.mushroom.snowball.attack-damage", 2F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.mushroom.snowball.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.mushroom.snowball.movement-melee-attack", 0.3F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.mushroom.snowball.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.mushroom.snowball.movement-wander-around", 0.3F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.mushroom.snowball.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.mushroom.snowball.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.mushroom.snowball.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.mushroom.snowball.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.MushroomSnowball,             InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.mushroom.snowball.spawn-weight", 20),
                CONFIG.getOrDefault("entity.mushroom.snowball.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.mushroom.snowball.spawn-max-group", 2),
                List.of(BiomeKeys.SNOWY_BEACH, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_SLOPES, BiomeKeys.SNOWY_TAIGA, BiomeKeys.ICE_SPIKES, BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.FROZEN_PEAKS), generalAvoidEntities));

        // ENTITY | SLIME BLUE
        InternalMetric.ATTRIBUTES.put(EntityVariant.SlimeBlue, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.slime.blue.max-health", 15F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.slime.blue.attack-damage", 5F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.slime.blue.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.slime.blue.movement-melee-attack", 0.8F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.slime.blue.movement-follow-owner", 0.6F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.slime.blue.movement-wander-around", 0.6F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.slime.blue.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.slime.blue.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.slime.blue.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.slime.blue.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.SlimeBlue, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.slime.blue.spawn-weight", 25),
                CONFIG.getOrDefault("entity.slime.blue.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.slime.blue.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST), generalAvoidEntities));

        // ENTITY | SPOOK PEACH
        InternalMetric.ATTRIBUTES.put(EntityVariant.SpookPeach, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.spook.peach.max-health", 20F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.spook.peach.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.spook.peach.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.spook.peach.movement-melee-attack", 0.9F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.spook.peach.movement-follow-owner", 0.8F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.spook.peach.movement-wander-around", 0.6F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.spook.peach.movement-fly-speed", 0.8F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.spook.peach.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.spook.peach.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.spook.peach.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.spook.peach.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.SpookPeach, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.spook.peach.spawn-weight", 20),
                CONFIG.getOrDefault("entity.spook.peach.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.spook.peach.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST, BiomeKeys.FOREST), generalAvoidEntities));

        // ENTITY | SPOOK TEAL
        InternalMetric.ATTRIBUTES.put(EntityVariant.SpookTeal, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.spook.teal.max-health", 20F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.spook.teal.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.spook.teal.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.spook.teal.movement-melee-attack", 0.9F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.spook.teal.movement-follow-owner", 0.8F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.spook.teal.movement-wander-around", 0.6F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.spook.teal.movement-fly-speed", 0.8F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.spook.teal.movement-speed", 0.6F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.spook.teal.defence", 0F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.spook.teal.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.spook.teal.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.SpookTeal, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.spook.teal.spawn-weight", 20),
                CONFIG.getOrDefault("entity.spook.teal.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.spook.teal.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST, BiomeKeys.FOREST), generalAvoidEntities));

        // ENTITY | WISP BLUE
        InternalMetric.ATTRIBUTES.put(EntityVariant.WispBlue, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.wisp.blue.max-health", 18F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.wisp.blue.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.wisp.blue.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.wisp.blue.movement-melee-attack", 0.5F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.wisp.blue.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.wisp.blue.movement-wander-around", 0.3F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.wisp.blue.movement-fly-speed", 0.5F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.wisp.blue.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.wisp.blue.defence", 0.5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.wisp.blue.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.wisp.blue.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.WispBlue, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.wisp.blue.spawn-weight", 20),
                CONFIG.getOrDefault("entity.wisp.blue.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.wisp.blue.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP), generalAvoidEntities));

        // ENTITY | WISP GREEN
        InternalMetric.ATTRIBUTES.put(EntityVariant.WispGreen, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.wisp.green.max-health", 18F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.wisp.green.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.wisp.green.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.wisp.green.movement-melee-attack", 0.5F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.wisp.green.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.wisp.green.movement-wander-around", 0.3F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.wisp.green.movement-fly-speed", 0.5F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.wisp.green.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.wisp.green.defence", 0.5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.wisp.green.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.wisp.green.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.WispGreen, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.wisp.green.spawn-weight", 20),
                CONFIG.getOrDefault("entity.wisp.green.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.wisp.green.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP), generalAvoidEntities));

        // ENTITY | WISP YELLOW
        InternalMetric.ATTRIBUTES.put(EntityVariant.WispYellow, new HashMap<>() {{
            put(EntityAttribute.MAX_HEALTH,             CONFIG.getOrDefault("entity.wisp.yellow.max-health", 18F));
            put(EntityAttribute.ATTACK_DAMAGE,          CONFIG.getOrDefault("entity.wisp.yellow.attack-damage", 3F));
            put(EntityAttribute.ATTACK_SPEED,           CONFIG.getOrDefault("entity.wisp.yellow.attack-speed", 1.2F));
            put(EntityAttribute.MOVEMENT_MELEE_ATTACK,  CONFIG.getOrDefault("entity.wisp.yellow.movement-melee-attack", 0.5F));
            put(EntityAttribute.MOVEMENT_FOLLOW_OWNER,  CONFIG.getOrDefault("entity.wisp.yellow.movement-follow-owner", 0.4F));
            put(EntityAttribute.MOVEMENT_WANDER_AROUND, CONFIG.getOrDefault("entity.wisp.yellow.movement-wander-around", 0.3F));
            put(EntityAttribute.FLYING_SPEED,           CONFIG.getOrDefault("entity.wisp.yellow.movement-fly-speed", 0.5F));
            put(EntityAttribute.MOVEMENT_SPEED,         CONFIG.getOrDefault("entity.wisp.yellow.movement-speed", 0.3F));
            put(EntityAttribute.DEFENSE,                CONFIG.getOrDefault("entity.wisp.yellow.defence", 0.5F));
            put(EntityAttribute.FOLLOW_RANGE_MAX,       CONFIG.getOrDefault("entity.wisp.yellow.follow-distance-max", 7F));
            put(EntityAttribute.FOLLOW_RANGE_MIN,       CONFIG.getOrDefault("entity.wisp.yellow.follow-distance-min", 2F));
        }});

        InternalMetric.SETTINGS.put(EntityVariant.WispYellow, InternalMetric.setSetting(
                CONFIG.getOrDefault("entity.wisp.yellow.spawn-weight", 20),
                CONFIG.getOrDefault("entity.wisp.yellow.spawn-min-group", 1),
                CONFIG.getOrDefault("entity.wisp.yellow.spawn-max-group", 2),
                List.of(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP), generalAvoidEntities));

    } // assign ()

} // Class MonstersGirlsConfig