package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.enums.*;

import java.util.HashMap;
import java.util.function.Predicate;

public class InternalMetric {

    // -- RPG --
    public static boolean GlobalAutoHeal = true;            // Enable automatic recovery
    public static int AutoHealInterval = 50;                // Automatic recovery interval
    public static int WaryTime = 50;                        // Time while being in combat mode

    // -- Attribute --
    public static float MeleeAttackMovement = 1.0F;                   // Movement speed when it is melee attacking
    public static float FollowOwnerMovement = 1.0F;                   // Movement speed when following player
    public static float WanderAroundMovement = 0.6F;                  // Movement speed while it is wandering around
    public static float FollowBehindDistance = 10.0F;
    public static float FollowCloseDistance= 2.0F;
    public static float LookAtRange = 8.0F;
    public static int AttackChance = 5;
    public static Predicate<LivingEntity> AvoidAttackingEntities = entity -> entity instanceof Monster && !(entity instanceof CreeperEntity);

    // -- Variables --
    public static final HashMap<EntityVariant, HashMap<EntityTexture, Identifier>> TEXTURES = new HashMap<>(){{
        put(EntityVariant.MandrakeBrown, setTexture("mandrake/mandrake_girl_brown", false));
        put(EntityVariant.MandrakeGreen, setTexture("mandrake/mandrake_girl_green", false));
        put(EntityVariant.Crimson, setTexture("mushroom/mushroom_girl_crimson", true));
        put(EntityVariant.CrimsonRare, setTexture("mushroom/mushroom_girl_crimson_rare", true));
        put(EntityVariant.FlyAgaric, setTexture("mushroom/mushroom_girl_red", true));
        put(EntityVariant.AmanitaYellow, setTexture("mushroom/mushroom_girl_yellow", true));
        put(EntityVariant.InkCap, setTexture("mushroom/mushroom_girl_ink_cap", true));
        put(EntityVariant.Warped, setTexture("mushroom/mushroom_girl_warped", true));
        put(EntityVariant.WarpedRare, setTexture("mushroom/mushroom_girl_warped_rare", true));
    }};

    public static final HashMap<EntityVariant, HashMap<EntityAttribute, InternalAttribute>> ATTRIBUTES = new HashMap<>(){{
        put(EntityVariant.MandrakeBrown, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.MandrakeGreen, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.Crimson, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.CrimsonRare, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.FlyAgaric, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.AmanitaYellow, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.InkCap, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.Warped, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
        put(EntityVariant.WarpedRare, setAttribute(30F, 5F, 1.2F, 0.4F, 5F));
    }};

    // Todo: correct the models, its not working
    public static final HashMap<EntityVariant, HashMap<EntityModel, Identifier>> ANIMATORS = new HashMap<>() {{
        put(EntityVariant.MandrakeBrown, setAnimator(EntityModel.Mandrake,"mushroom_girl"));
        put(EntityVariant.MandrakeGreen, setAnimator(EntityModel.Mandrake,"mushroom_girl"));
        put(EntityVariant.InkCap, setAnimator(EntityModel.Fungus,"mushroom_girl"));
        put(EntityVariant.Warped, setAnimator(EntityModel.Mushroom,"mushroom_girl"));
        put(EntityVariant.WarpedRare, setAnimator(EntityModel.Mushroom,"mushroom_girl"));
    }};

    public static final HashMap<EntityVariant, HashMap<EntityModel, Identifier>> MODELS = new HashMap<>(){{
        put(EntityVariant.MandrakeBrown, setModel(EntityModel.Mandrake,"geo/mandrake_girl.geo.json"));
        put(EntityVariant.MandrakeGreen, setModel(EntityModel.Mandrake,"geo/mandrake_girl.geo.json"));
        put(EntityVariant.InkCap, setModel(EntityModel.Fungus,"geo/mushroom_girl_ink_cap.geo.json"));
        put(EntityVariant.Warped, setModel(EntityModel.Mushroom,"geo/mushroom_girl.geo.json"));
        put(EntityVariant.WarpedRare, setModel(EntityModel.Mushroom,"geo/mushroom_girl.geo.json"));
    }};

    // -- Methods --
    public static Identifier getAnimator(EntityVariant variant, EntityModel model) { return ANIMATORS.get(variant).get(model); } // getAnimator ()

    private static HashMap<EntityModel, Identifier> setAnimator(EntityModel model, String suffix){
        var path = "animations/";
        return new HashMap<>() {{
            put(model,    new Identifier(MonstersGirlsMod.MODID, path + suffix + ".animation.json"));
        }};
    } // setAnimator ()

    public static Identifier getTexture(EntityVariant variant, EntityTexture texture) {
        return TEXTURES.get(variant).get(texture);
    } // getTexture ()

    public static int getTextureCount(EntityVariant variant) {
        return TEXTURES.get(variant).size();
    } // getTextureCount ()

    private static HashMap<EntityTexture, Identifier> setTexture(String suffix, boolean belly){
        var path = "textures/entity/";
        return new HashMap<>() {{
            put(EntityTexture.DEFAULT,  new Identifier(MonstersGirlsMod.MODID, path + suffix + ".png"));                    // Default
            if(belly) put(EntityTexture.BELLY,    new Identifier(MonstersGirlsMod.MODID, path + suffix + "_belly.png"));    // Belly
        }};
    } // setTexture ()

    public static Identifier getModel(EntityVariant variant, EntityModel model) {
        return MODELS.get(variant).get(model);
    } // getAttributeValue ()

    private static HashMap<EntityModel, Identifier> setModel(EntityModel model, String suffix){
        return new HashMap<>() {{put(model, new Identifier(MonstersGirlsMod.MODID, suffix));}};
    } // setModel ()

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