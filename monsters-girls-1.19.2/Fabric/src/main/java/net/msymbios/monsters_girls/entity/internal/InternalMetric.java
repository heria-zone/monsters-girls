package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.enums.*;
import net.msymbios.monsters_girls.sounds.ModSounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class InternalMetric {

    // -- RPG --
    public static boolean GlobalAutoHeal = true;            // Enable automatic recovery
    public static int AutoHealInterval = 50;                // Automatic recovery interval
    public static int WaryTime = 50;                        // Time while being in combat mode

    // -- Attribute --
    public static float MeleeAttackMovement = 1.0F;                     // Movement speed when it is melee attacking
    public static float MovementSpeed = 1.0F;                           // Movement speed when it is melee attacking
    public static float FollowOwnerMovement = 1.0F;                     // Movement speed when following player
    public static float WanderAroundMovement = 0.6F;                    // Movement speed while it is wandering around
    public static float FollowBehindDistance = 7.0F;
    public static float FollowCloseDistance= 2.0F;
    public static float LookAtRange = 6.0F;
    public static int AttackChance = 5;
    public static Predicate<LivingEntity> AvoidAttackingEntities = entity -> entity instanceof Monster && !(entity instanceof CreeperEntity);

    // -- Variables --
    public static HashMap<EntitySound, List<EntityVariant>> ENTITY_SOUND = new HashMap<>(){{

        put(EntitySound.DEFAULT, new ArrayList<>(List.of(
                EntityVariant.MandrakeBrown,
                EntityVariant.MandrakeChorus,
                EntityVariant.MandrakeGreen,
                EntityVariant.MandrakeGlowBerry,

                EntityVariant.MushroomAmanitaYellow,
                EntityVariant.MushroomBrown,
                EntityVariant.MushroomCrimson,
                EntityVariant.MushroomCrimsonRare,
                EntityVariant.MushroomEnderPuffball,
                EntityVariant.MushroomInfernal,
                EntityVariant.FungusInkCap,
                EntityVariant.MushroomMolten,
                EntityVariant.MushroomFlyAgaric,
                EntityVariant.MushroomSoulWanderer,
                EntityVariant.MushroomWarped,
                EntityVariant.MushroomWarpedRare,

                EntityVariant.SpookPeach,
                EntityVariant.SpookTeal,

                EntityVariant.WispBlue,
                EntityVariant.WispGreen,
                EntityVariant.WispYellow
        )));

        put(EntitySound.HURT, new ArrayList<>(List.of(
                EntityVariant.MandrakeBrown,
                EntityVariant.MandrakeChorus,
                EntityVariant.MandrakeGreen,
                EntityVariant.MandrakeGlowBerry,

                EntityVariant.SpookPeach,
                EntityVariant.SpookTeal,

                EntityVariant.WispBlue,
                EntityVariant.WispGreen,
                EntityVariant.WispYellow
        )));

        put(EntitySound.DEATH, new ArrayList<>(List.of(
                EntityVariant.MandrakeBrown,
                EntityVariant.MandrakeChorus,
                EntityVariant.MandrakeGreen,
                EntityVariant.MandrakeGlowBerry,

                EntityVariant.WispBlue,
                EntityVariant.WispGreen,
                EntityVariant.WispYellow
        )));

        put(EntitySound.ATTACK, new ArrayList<>(List.of(
                EntityVariant.SpookPeach,
                EntityVariant.SpookTeal
        )));
    }};

    public static HashMap<EntityCategory, HashMap<EntityVariant, EntityAnimator>> ENTITY_ANIMATOR = new HashMap<>(){{
        put(EntityCategory.Mandrake, new HashMap<>() {{
            put(EntityVariant.MandrakeBrown,        EntityAnimator.Mandrake);
            put(EntityVariant.MandrakeGreen,        EntityAnimator.Mandrake);
            put(EntityVariant.MandrakeGlowBerry,    EntityAnimator.Mandrake);
            put(EntityVariant.MandrakeChorus,       EntityAnimator.Mandrake);
        }});

        put(EntityCategory.Mushroom, new HashMap<>() {{
            put(EntityVariant.MushroomAmanitaYellow,        EntityAnimator.Mushroom);
            put(EntityVariant.MushroomBrown,                EntityAnimator.MushroomFat);
            put(EntityVariant.MushroomCrimson,              EntityAnimator.Mushroom);
            put(EntityVariant.MushroomCrimsonRare,          EntityAnimator.Mushroom);
            put(EntityVariant.MushroomEnderPuffball,        EntityAnimator.MushroomInflated);
            put(EntityVariant.MushroomInfernal,             EntityAnimator.MushroomFat);
            put(EntityVariant.FungusInkCap,                 EntityAnimator.Mushroom);
            put(EntityVariant.MushroomMolten,               EntityAnimator.MushroomFat);
            put(EntityVariant.MushroomFlyAgaric,            EntityAnimator.Mushroom);
            put(EntityVariant.MushroomSoulWanderer,         EntityAnimator.Mushroom);
            put(EntityVariant.MushroomWarped,               EntityAnimator.Mushroom);
            put(EntityVariant.MushroomWarpedRare,           EntityAnimator.Mushroom);
        }});

        put(EntityCategory.Spook, new HashMap<>() {{
            put(EntityVariant.SpookPeach,           EntityAnimator.Spook);
            put(EntityVariant.SpookTeal,            EntityAnimator.Spook);
        }});

        put(EntityCategory.Wisp, new HashMap<>() {{
            put(EntityVariant.WispBlue,             EntityAnimator.Wisp);
            put(EntityVariant.WispGreen,            EntityAnimator.Wisp);
            put(EntityVariant.WispYellow,           EntityAnimator.Wisp);
        }});
    }};

    public static HashMap<EntityCategory, HashMap<EntityVariant, EntityModel>> ENTITY_MODEL = new HashMap<>(){{
        put(EntityCategory.Mandrake, new HashMap<>() {{
            put(EntityVariant.MandrakeBrown,        EntityModel.Mandrake);
            put(EntityVariant.MandrakeGreen,        EntityModel.Mandrake);
            put(EntityVariant.MandrakeGlowBerry,    EntityModel.MandrakeFruit);
            put(EntityVariant.MandrakeChorus,       EntityModel.MandrakeFruit);
        }});

        put(EntityCategory.Mushroom, new HashMap<>() {{
            put(EntityVariant.MushroomAmanitaYellow,    EntityModel.Mushroom);
            put(EntityVariant.MushroomBrown,            EntityModel.MushroomFat);
            put(EntityVariant.MushroomCrimson,          EntityModel.Mushroom);
            put(EntityVariant.MushroomCrimsonRare,      EntityModel.Mushroom);
            put(EntityVariant.MushroomEnderPuffball,    EntityModel.MushroomInflated);
            put(EntityVariant.MushroomInfernal,         EntityModel.MushroomFat);
            put(EntityVariant.FungusInkCap,             EntityModel.MushroomFungus);
            put(EntityVariant.MushroomMolten,           EntityModel.MushroomFat);
            put(EntityVariant.MushroomFlyAgaric,        EntityModel.Mushroom);
            put(EntityVariant.MushroomSoulWanderer,     EntityModel.Mushroom);
            put(EntityVariant.MushroomWarped,           EntityModel.Mushroom);
            put(EntityVariant.MushroomWarpedRare,       EntityModel.Mushroom);
        }});

        put(EntityCategory.Spook, new HashMap<>() {{
            put(EntityVariant.SpookPeach,           EntityModel.Spook);
            put(EntityVariant.SpookTeal,            EntityModel.Spook);
        }});

        put(EntityCategory.Wisp, new HashMap<>() {{
            put(EntityVariant.WispBlue,             EntityModel.Wisp);
            put(EntityVariant.WispGreen,            EntityModel.Wisp);
            put(EntityVariant.WispYellow,           EntityModel.Wisp);
        }});
    }};

    public static HashMap<EntityTexture, List<EntityVariant>> ENTITY_TEXTURE = new HashMap<>(){{
        put(EntityTexture.DEFAULT, new ArrayList<>(List.of(
                EntityVariant.MandrakeBrown,
                EntityVariant.MandrakeChorus,
                EntityVariant.MandrakeGreen,
                EntityVariant.MandrakeGlowBerry,

                EntityVariant.MushroomAmanitaYellow,
                EntityVariant.MushroomBrown,
                EntityVariant.MushroomCrimson,
                EntityVariant.MushroomCrimsonRare,
                EntityVariant.MushroomEnderPuffball,
                EntityVariant.MushroomInfernal,
                EntityVariant.FungusInkCap,
                EntityVariant.MushroomMolten,
                EntityVariant.MushroomFlyAgaric,
                EntityVariant.MushroomSoulWanderer,
                EntityVariant.MushroomWarped,
                EntityVariant.MushroomWarpedRare,

                EntityVariant.SpookPeach,
                EntityVariant.SpookTeal,

                EntityVariant.WispBlue,
                EntityVariant.WispGreen,
                EntityVariant.WispYellow
        )));

        put(EntityTexture.BELLY, new ArrayList<>(List.of(
                EntityVariant.MushroomAmanitaYellow,
                EntityVariant.MushroomBrown,
                EntityVariant.MushroomCrimson,
                EntityVariant.MushroomCrimsonRare,
                EntityVariant.MushroomEnderPuffball,
                EntityVariant.MushroomInfernal,
                EntityVariant.FungusInkCap,
                EntityVariant.MushroomMolten,
                EntityVariant.MushroomFlyAgaric,
                EntityVariant.MushroomSoulWanderer,
                EntityVariant.MushroomWarped,
                EntityVariant.MushroomWarpedRare,

                EntityVariant.SpookPeach,
                EntityVariant.SpookTeal,

                EntityVariant.WispYellow
        )));
    }};

    public static HashMap<EntityVariant, HashMap<EntitySound, SoundEvent>> SOUND = new HashMap<>(){{
        HashMap<EntitySound, SoundEvent> mandrakeMap = new HashMap<>() {{
            put(EntitySound.DEFAULT, ModSounds.MANDRAKE_SOUND);
            put(EntitySound.HURT, ModSounds.MANDRAKE_HURT);
            put(EntitySound.DEATH, ModSounds.MANDRAKE_DEATH);
        }};
        HashMap<EntitySound, SoundEvent> mushroomMap = new HashMap<>() {{
            put(EntitySound.DEFAULT, ModSounds.MUSHROOM_GIRL);
        }};
        HashMap<EntitySound, SoundEvent> spookMap = new HashMap<>() {{
            put(EntitySound.ATTACK, ModSounds.SPOOK_ATTACK);
            put(EntitySound.DEFAULT, ModSounds.SPOOK_LAUGH);
            put(EntitySound.HURT, ModSounds.SPOOK_HURT);
        }};
        HashMap<EntitySound, SoundEvent> wispMap = new HashMap<>() {{
            put(EntitySound.DEFAULT, ModSounds.WISP_LAUGH);
            put(EntitySound.HURT, ModSounds.WISP_HURT);
            put(EntitySound.DEATH, ModSounds.WISP_DEATH);
        }};

        put(EntityVariant.MandrakeBrown,            mandrakeMap);
        put(EntityVariant.MandrakeChorus,           mandrakeMap);
        put(EntityVariant.MandrakeGlowBerry,        mandrakeMap);
        put(EntityVariant.MandrakeGreen,            mandrakeMap);

        put(EntityVariant.MushroomAmanitaYellow,    mushroomMap);
        put(EntityVariant.MushroomBrown,            mushroomMap);
        put(EntityVariant.MushroomCrimson,          mushroomMap);
        put(EntityVariant.MushroomCrimsonRare,      mushroomMap);
        put(EntityVariant.MushroomEnderPuffball,    new HashMap<>() {{put(EntitySound.DEFAULT, ModSounds.MUSHROOM_GIRL_ENDER);}});
        put(EntityVariant.MushroomInfernal,         mushroomMap);
        put(EntityVariant.FungusInkCap,             mushroomMap);
        put(EntityVariant.MushroomMolten,           mushroomMap);
        put(EntityVariant.MushroomFlyAgaric,        mushroomMap);
        put(EntityVariant.MushroomSoulWanderer,     mushroomMap);
        put(EntityVariant.MushroomWarped,           mushroomMap);
        put(EntityVariant.MushroomWarpedRare,       mushroomMap);

        put(EntityVariant.SpookPeach,               spookMap);
        put(EntityVariant.SpookTeal,                spookMap);

        put(EntityVariant.WispBlue,                 wispMap);
        put(EntityVariant.WispGreen,                wispMap);
        put(EntityVariant.WispYellow,               wispMap);
    }};

    public static HashMap<EntityAnimator, Identifier> ANIMATOR = new HashMap<>() {{
        put(EntityAnimator.Mandrake,    new Identifier(MonstersGirlsMod.MODID, "animations/mandrake_girl.animation.json"));
        put(EntityAnimator.Mushroom,    new Identifier(MonstersGirlsMod.MODID, "animations/mushroom_girl.animation.json"));
        put(EntityAnimator.MushroomFat,    new Identifier(MonstersGirlsMod.MODID, "animations/mushroom_girl_fat.animation.json"));
        put(EntityAnimator.MushroomInflated,    new Identifier(MonstersGirlsMod.MODID, "animations/mushroom_girl_inflated.animation.json"));
        put(EntityAnimator.Spook,    new Identifier(MonstersGirlsMod.MODID, "animations/spook_girl.animation.json"));
        put(EntityAnimator.Wisp,    new Identifier(MonstersGirlsMod.MODID, "animations/wisp_girl.animation.json"));
    }};

    public static HashMap<EntityModel, Identifier> MODEL = new HashMap<>() {{
        put(EntityModel.Mandrake,           new Identifier(MonstersGirlsMod.MODID, "geo/mandrake_girl.geo.json"));
        put(EntityModel.MandrakeFruit,      new Identifier(MonstersGirlsMod.MODID, "geo/mandrake_girl_fruit.geo.json"));
        put(EntityModel.Mushroom,           new Identifier(MonstersGirlsMod.MODID, "geo/mushroom_girl.geo.json"));
        put(EntityModel.MushroomFat,        new Identifier(MonstersGirlsMod.MODID, "geo/mushroom_girl_fat.geo.json"));
        put(EntityModel.MushroomInflated,   new Identifier(MonstersGirlsMod.MODID, "geo/mushroom_girl_inflated.geo.json"));
        put(EntityModel.MushroomFungus,     new Identifier(MonstersGirlsMod.MODID, "geo/mushroom_girl_ink_cap.geo.json"));
        put(EntityModel.Spook,              new Identifier(MonstersGirlsMod.MODID, "geo/spook_girl.geo.json"));
        put(EntityModel.Wisp,               new Identifier(MonstersGirlsMod.MODID, "geo/wisp_girl.geo.json"));
    }};

    public static HashMap<EntityVariant, HashMap<EntityTexture, Identifier>> TEXTURE = new HashMap<>(){{
        put(EntityVariant.MandrakeBrown,    setTexture("mandrake/mandrake_girl_brown", false));
        put(EntityVariant.MandrakeChorus,    setTexture("mandrake/mandrake_girl_chorus", false));
        put(EntityVariant.MandrakeGlowBerry,    setTexture("mandrake/mandrake_girl_glow_berry", false));
        put(EntityVariant.MandrakeGreen,    setTexture("mandrake/mandrake_girl_green", false));

        put(EntityVariant.MushroomAmanitaYellow,    setTexture("mushroom/mushroom_girl_yellow", true));
        put(EntityVariant.MushroomBrown,          setTexture("mushroom/mushroom_girl_brown", true));
        put(EntityVariant.MushroomCrimson,          setTexture("mushroom/mushroom_girl_crimson", true));
        put(EntityVariant.MushroomCrimsonRare,      setTexture("mushroom/mushroom_girl_crimson_rare", true));
        put(EntityVariant.MushroomEnderPuffball,    setTexture("mushroom/mushroom_girl_ender_puffball", true));
        put(EntityVariant.MushroomInfernal,         setTexture("mushroom/mushroom_girl_infernal", true));
        put(EntityVariant.FungusInkCap,           setTexture("mushroom/mushroom_girl_ink_cap", true));
        put(EntityVariant.MushroomMolten,           setTexture("mushroom/mushroom_girl_molten", true));
        put(EntityVariant.MushroomFlyAgaric,        setTexture("mushroom/mushroom_girl_red", true));
        put(EntityVariant.MushroomSoulWanderer,     setTexture("mushroom/mushroom_girl_soul_wanderer", true));
        put(EntityVariant.MushroomWarped,           setTexture("mushroom/mushroom_girl_warped", true));
        put(EntityVariant.MushroomWarpedRare,       setTexture("mushroom/mushroom_girl_warped_rare", true));

        put(EntityVariant.SpookPeach,           setTexture("spook/spook_girl_peach", true));
        put(EntityVariant.SpookTeal,            setTexture("spook/spook_girl_teal", true));

        put(EntityVariant.WispBlue,             setTexture("wisp/wisp_girl_blue", false));
        put(EntityVariant.WispGreen,            setTexture("wisp/wisp_girl_green", false));
        put(EntityVariant.WispYellow,           setTexture("wisp/wisp_girl_yellow", true));
    }};

    public static HashMap<EntityVariant, HashMap<EntityAttribute, InternalAttribute>> ATTRIBUTES = new HashMap<>(){{
        var mushroomAttribute = new HashMap<EntityAttribute, InternalAttribute>(){{
            put(EntityAttribute.MAX_HEALTH, new InternalAttribute(EntityAttribute.MAX_HEALTH, 15F));                // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, new InternalAttribute(EntityAttribute.ATTACK_DAMAGE, 2F));           // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, new InternalAttribute(EntityAttribute.ATTACK_SPEED, 1.2F));           // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED, new InternalAttribute(EntityAttribute.MOVEMENT_SPEED, 0.3F));       // Movement Speed
            put(EntityAttribute.DEFENSE, new InternalAttribute(EntityAttribute.DEFENSE, 0F));                       // Defense
            put(EntityAttribute.ARMOR, new InternalAttribute(EntityAttribute.ARMOR, 0F));
            put(EntityAttribute.ARMOR_TOUGHNESS, new InternalAttribute(EntityAttribute.ARMOR_TOUGHNESS, 0F));
            put(EntityAttribute.FOLLOW_RANGE, new InternalAttribute(EntityAttribute.FOLLOW_RANGE, 7F));
        }};

        var mandrakeFruityAttribute = new HashMap<EntityAttribute, InternalAttribute>(){{
            put(EntityAttribute.MAX_HEALTH, new InternalAttribute(EntityAttribute.MAX_HEALTH, 10F));                 // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, new InternalAttribute(EntityAttribute.ATTACK_DAMAGE, 0F));           // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, new InternalAttribute(EntityAttribute.ATTACK_SPEED, 0F));        // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED, new InternalAttribute(EntityAttribute.MOVEMENT_SPEED, 0.3F));  // Movement Speed
            put(EntityAttribute.DEFENSE, new InternalAttribute(EntityAttribute.DEFENSE, 0.1F));                      // Defense
            put(EntityAttribute.ARMOR, new InternalAttribute(EntityAttribute.ARMOR, 0F));
            put(EntityAttribute.ARMOR_TOUGHNESS, new InternalAttribute(EntityAttribute.ARMOR_TOUGHNESS, 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE, new InternalAttribute(EntityAttribute.KNOCKBACK_RESISTANCE, 0.2F));
        }};
        var spookAttribute = new HashMap<EntityAttribute, InternalAttribute>(){{
            put(EntityAttribute.MAX_HEALTH, new InternalAttribute(EntityAttribute.MAX_HEALTH, 20F));                // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, new InternalAttribute(EntityAttribute.ATTACK_DAMAGE, 3F));           // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, new InternalAttribute(EntityAttribute.ATTACK_SPEED, 1.2F));           // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED, new InternalAttribute(EntityAttribute.MOVEMENT_SPEED, 0.3F));       // Movement Speed
            put(EntityAttribute.DEFENSE, new InternalAttribute(EntityAttribute.DEFENSE, 0F));                       // Defense
            put(EntityAttribute.ARMOR, new InternalAttribute(EntityAttribute.ARMOR, 0F));
            put(EntityAttribute.ARMOR_TOUGHNESS, new InternalAttribute(EntityAttribute.ARMOR_TOUGHNESS, 0F));
            put(EntityAttribute.KNOCKBACK_RESISTANCE, new InternalAttribute(EntityAttribute.KNOCKBACK_RESISTANCE, 1F));
            put(EntityAttribute.FLYING_SPEED, new InternalAttribute(EntityAttribute.FLYING_SPEED, 0.8F));
            put(EntityAttribute.FOLLOW_RANGE, new InternalAttribute(EntityAttribute.FOLLOW_RANGE, 7F));
        }};
        var wispAttribute = new HashMap<EntityAttribute, InternalAttribute>(){{
            put(EntityAttribute.MAX_HEALTH, new InternalAttribute(EntityAttribute.MAX_HEALTH, 18F));                 // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, new InternalAttribute(EntityAttribute.ATTACK_DAMAGE, 3F));           // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, new InternalAttribute(EntityAttribute.ATTACK_SPEED, 1.2F));        // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED, new InternalAttribute(EntityAttribute.MOVEMENT_SPEED, 0.3F));  // Movement Speed
            put(EntityAttribute.DEFENSE, new InternalAttribute(EntityAttribute.DEFENSE, 0.5F));                      // Defense
            put(EntityAttribute.ARMOR, new InternalAttribute(EntityAttribute.ARMOR, 0F));
            put(EntityAttribute.ARMOR_TOUGHNESS, new InternalAttribute(EntityAttribute.ARMOR_TOUGHNESS, 0F));
            put(EntityAttribute.KNOCKBACK_ATTACK, new InternalAttribute(EntityAttribute.KNOCKBACK_ATTACK, 0.3F));
            put(EntityAttribute.FLYING_SPEED, new InternalAttribute(EntityAttribute.FLYING_SPEED, 0.8F));
            put(EntityAttribute.FOLLOW_RANGE, new InternalAttribute(EntityAttribute.FOLLOW_RANGE, 7F));
        }};
        
        put(EntityVariant.MandrakeGreen, setAttribute(15F, 2F, 1.2F, 0.3F, 0.2F));
        put(EntityVariant.MandrakeBrown, setAttribute(15F, 2F, 1.2F, 0.3F, 0.2F));
        put(EntityVariant.MandrakeChorus, mandrakeFruityAttribute);
        put(EntityVariant.MandrakeGlowBerry, mandrakeFruityAttribute);

        put(EntityVariant.MushroomAmanitaYellow, mushroomAttribute);
        put(EntityVariant.MushroomBrown, mushroomAttribute);
        put(EntityVariant.MushroomCrimson, mushroomAttribute);
        put(EntityVariant.MushroomCrimsonRare, mushroomAttribute);
        put(EntityVariant.MushroomEnderPuffball, mushroomAttribute);
        put(EntityVariant.MushroomInfernal, mushroomAttribute);
        put(EntityVariant.FungusInkCap, mushroomAttribute);
        put(EntityVariant.MushroomMolten, mushroomAttribute);
        put(EntityVariant.MushroomFlyAgaric, mushroomAttribute);
        put(EntityVariant.MushroomSoulWanderer, mushroomAttribute);
        put(EntityVariant.MushroomWarped, mushroomAttribute);
        put(EntityVariant.MushroomWarpedRare, mushroomAttribute);

        put(EntityVariant.SpookPeach, spookAttribute);
        put(EntityVariant.SpookTeal, spookAttribute);

        put(EntityVariant.WispBlue, wispAttribute);
        put(EntityVariant.WispGreen, wispAttribute);
        put(EntityVariant.WispYellow, wispAttribute);
    }};

    // -- Methods --

    // SOUND
    public static SoundEvent getSound(EntityVariant variant) {
        EntitySound defaultSound = EntitySound.DEFAULT;
        if (ENTITY_SOUND.containsKey(defaultSound) && ENTITY_SOUND.get(defaultSound).contains(variant)) {
            if (SOUND.containsKey(variant) && SOUND.get(variant).containsKey(defaultSound))
                return SOUND.get(variant).get(defaultSound);
        }

        // Return a default or error identifier if the combination is not found
        return null;
    } // getSound ()

    public static SoundEvent getSound(EntityVariant variant, EntitySound sound) {
        if (ENTITY_SOUND.containsKey(sound) && ENTITY_SOUND.get(sound).contains(variant)) {
            if (SOUND.containsKey(variant) && SOUND.get(variant).containsKey(sound))
                return SOUND.get(variant).get(sound);
        }

        // If the texture doesn't exist for the specified variant, return the default texture
        if (SOUND.containsKey(variant) && SOUND.get(variant).containsKey(EntitySound.DEFAULT))
            return SOUND.get(variant).get(EntitySound.DEFAULT);

        // Return a default or error identifier if the combination is not found
        return null;
    } // getSound ()

    // ANIMATOR
    public static Identifier getAnimator(EntityCategory entity, EntityVariant variant) {
        HashMap<EntityVariant, EntityAnimator> variantMap = ENTITY_ANIMATOR.get(entity);
        if (variantMap != null) {
            EntityAnimator selectedAnimator = variantMap.get(variant);
            if (selectedAnimator != null && ANIMATOR.containsKey(selectedAnimator)) return ANIMATOR.get(selectedAnimator);
        }
        return null; // Animator not found
    } // getAnimator ()

    public static Identifier getAnimator(EntityCategory entity, EntityVariant variant, EntityAnimator animator) {
        HashMap<EntityVariant, EntityAnimator> variantMap = ENTITY_ANIMATOR.get(entity);
        if (variantMap != null) {
            EntityAnimator selectedAnimator = variantMap.get(variant);
            if (selectedAnimator != null && selectedAnimator == animator) return ANIMATOR.get(animator);
        }
        return null; // Animator not found for the specified parameters
    } // getAnimator ()

    // MODEL
    public static Identifier getModel(EntityCategory entity, EntityVariant variant) {
        if (ENTITY_MODEL.containsKey(entity) && ENTITY_MODEL.get(entity).containsKey(variant)) {
            EntityModel model = ENTITY_MODEL.get(entity).get(variant);
            if (MODEL.containsKey(model)) return MODEL.get(model);
        }
        // Return a default or error identifier if the combination is not found
        return new Identifier(MonstersGirlsMod.MODID, "geo/mandrake_girl.geo.json");
    } // getModel ()

    public static Identifier getModel(EntityCategory entity, EntityVariant variant, EntityModel model) {
        if (ENTITY_MODEL.containsKey(entity) && ENTITY_MODEL.get(entity).containsKey(variant)) {
            EntityModel actualModel = ENTITY_MODEL.get(entity).get(variant);
            if (actualModel == model && MODEL.containsKey(model)) return MODEL.get(model);
        }
        // Return a default or error identifier if the combination is not found
        return new Identifier(MonstersGirlsMod.MODID, "geo/mandrake_girl.geo.json");
    } // getModel ()

    // TEXTURE
    public static Identifier getTexture(EntityVariant variant) {
        EntityTexture defaultTexture = EntityTexture.DEFAULT;
        if (ENTITY_TEXTURE.containsKey(defaultTexture) && ENTITY_TEXTURE.get(defaultTexture).contains(variant)) {
            if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(defaultTexture))
                return TEXTURE.get(variant).get(defaultTexture);
        }

        // Return a default or error identifier if the combination is not found
        return new Identifier(MonstersGirlsMod.MODID, "textures/entity/mandrake/mandrake_girl_brown.png");
    } // getTexture ()

    public static Identifier getTexture(EntityVariant variant, EntityTexture texture) {
        if (ENTITY_TEXTURE.containsKey(texture) && ENTITY_TEXTURE.get(texture).contains(variant)) {
            if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(texture))
                return TEXTURE.get(variant).get(texture);
        }

        // If the texture doesn't exist for the specified variant, return the default texture
        if (TEXTURE.containsKey(variant) && TEXTURE.get(variant).containsKey(EntityTexture.DEFAULT))
            return TEXTURE.get(variant).get(EntityTexture.DEFAULT);

        // Return a default or error identifier if the combination is not found
        return new Identifier(MonstersGirlsMod.MODID, "textures/entity/mandrake/mandrake_girl_brown.png");
    } // getTexture ()

    public static int getTextureNumber(EntityVariant variant, EntityTexture targetTexture) {
        if (TEXTURE.containsKey(variant)) {
            HashMap<EntityTexture, Identifier> textureMap = TEXTURE.get(variant);

            int textureNumber = 0;
            for (EntityTexture texture : textureMap.keySet()) {
                textureNumber++;
                if (texture == targetTexture) break;
            }

            return textureNumber;
        }

        return 0; // Variant not found
    } // getTextureNumber ()

    private static HashMap<EntityTexture, Identifier> setTexture(String suffix, boolean belly){
        var path = "textures/entity/";
        return new HashMap<>() {{
            put(EntityTexture.DEFAULT,  new Identifier(MonstersGirlsMod.MODID, path + suffix + ".png"));                    // Default
            if(belly) put(EntityTexture.BELLY,    new Identifier(MonstersGirlsMod.MODID, path + suffix + "_belly.png"));    // Belly
        }};
    } // setTexture ()

    // ATTRIBUTE
    public static float getAttribute(EntityVariant variant, EntityAttribute attribute) {
        InternalAttribute entityAttribute = ATTRIBUTES.get(variant).get(attribute);
        return entityAttribute == null ? 0F : entityAttribute.value;
    } // getAttribute ()

    private static HashMap<EntityAttribute, InternalAttribute> setAttribute(float health, float damage, float attackSpeed, float movementSpeed, float defence){
        return new HashMap<>(){{
            put(EntityAttribute.MAX_HEALTH, new InternalAttribute(EntityAttribute.MAX_HEALTH, health));                 // Max Health
            put(EntityAttribute.ATTACK_DAMAGE, new InternalAttribute(EntityAttribute.ATTACK_DAMAGE, damage));           // Attack Damage
            put(EntityAttribute.ATTACK_SPEED, new InternalAttribute(EntityAttribute.ATTACK_SPEED, attackSpeed));        // Attack Speed
            put(EntityAttribute.MOVEMENT_SPEED, new InternalAttribute(EntityAttribute.MOVEMENT_SPEED, movementSpeed));  // Movement Speed
            put(EntityAttribute.DEFENSE, new InternalAttribute(EntityAttribute.DEFENSE, defence));                      // Defense
            put(EntityAttribute.ARMOR, new InternalAttribute(EntityAttribute.ARMOR, 0F));
            put(EntityAttribute.ARMOR_TOUGHNESS, new InternalAttribute(EntityAttribute.ARMOR_TOUGHNESS, 0F));
        }};
    } // setAttribute ()

} // Class InternalMetric