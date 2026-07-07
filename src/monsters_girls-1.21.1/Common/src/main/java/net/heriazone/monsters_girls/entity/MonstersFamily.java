package net.heriazone.monsters_girls.entity;

import net.heriazone.hzlib.api.entity.NativeEntityFamily;
import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.nbt.EntityDataSchema;
import net.heriazone.hzlib.api.nbt.MigrationChain;
import net.heriazone.monsters_girls.MonstersConstant;
import net.heriazone.monsters_girls.MonstersIdentifier;
import net.heriazone.monsters_girls.entity.data.MonsterFields;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

/**
 * <p>Base entity type for all Monsters &amp; Girls entities, providing common functionality
 * and variant configuration patterns specific to monster entities.</p>
 * <p>
 * <b>Architecture:</b> Extends HZLib NativeEntityFamily to leverage the dynamic variant
 * system while providing monster-specific defaults and configuration patterns.
 * <p>
 * <b>Variant Support:</b> Configures standard texture variants (DEFAULT, TUMMY) for
 * belly progression system, with DEFAULT model and animator variants.
 * <p>
 * <b>Translation:</b> Uses "monsters_girls" namespace for all translation keys,
 * following the pattern "entity.monsters_girls.{key}".
 */
public abstract class MonstersFamily<T extends MonstersFamily<T>> extends NativeEntityFamily<T> {

    // -- Constructors --

    /**
     * Creates a new native entity type with the specified key.
     * 
     * @param key the unique identifier for this entity type
     */
    public MonstersFamily(String key) {
        super(key);
        
        // Set default combat stats for monster entities
        withCombatStats(
            18.0f,  // health
            3.0f,   // attack
            1.2f,   // speed
            0.1f,   // armor
            0.2f,   // toughness
            0.0f,   // knockback resistance
            0.6f    // move speed
        );

        // Note: configureVariants() is already called by NativeEntityFamily constructor.
        // Do NOT call it again here — concrete subclasses override it and register
        // their variants via static registerXxxVariants() blocks.
    } // Constructor: MonstersFamily ()

    // -- Abstract Methods --

    @Override
    protected void configureVariants() {
        // Configure texture variants - DEFAULT and TUMMY for belly progression
        withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));
        
        // Configure model variants - DEFAULT only for most monsters
        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));
        
        // Configure animator variants - DEFAULT only for most monsters
        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants(key, key + "_default")
                .withDefault(key, key + "_default"));
    } // configureVariants ()

    /**
     * Declares the schema (common monster fields) and the V1_MG migration chain.
     * <p>
     * Concrete subclasses that add extra persisted fields should override this,
     * call {@code super.configureSchema()}, then register additional fields on top.
     */
    @Override
    protected void configureSchema() {
        schema = EntityDataSchema.builder()
                .register(MonsterFields.BELLY_LEVEL)
                .register(MonsterFields.PLANTING_ENABLED)
                .register(MonsterFields.SOUND_ENABLED)
                .version("1.0.0")
                .build();

        migrationChain = MigrationChain.builder()
                .addStep(new MigrationStep_V1_MG())
                .build();
    } // configureSchema ()

    @Override
    protected MutableComponent createTranslation(String key) {
        return MonstersIdentifier.getTranslation("entity", key);
    } // createTranslation ()

    // -- Helper Methods --

    /**
     * <p>Creates a ResourceLocation for this mod with the specified path.</p>
     * 
     * @param path the resource path
     * @return ResourceLocation with monsters_girls namespace
     */
    protected static ResourceLocation createResource(String path) {
        return MonstersIdentifier.getId(path);
    } // createResource ()


    /**
     * <p>Creates a texture ResourceLocation for the specified variant.</p>
     * <p>
     * <b>Path Pattern:</b> textures/entity/{key}/{key}_{variant}.png
     * 
     * @param identifier the texture variant name
     * @return ResourceLocation pointing to the texture
     */
    protected static ResourceLocation createTextureResource(String entity, String identifier) {
        return createResource(MonstersConstant.TEXTURE_ENTITY_PATH + entity + "/" + identifier + MonstersConstant.TEXTURE_EXTENSION);
    } // createTextureResource ()

    protected static String getTextureResource (String entity, String identifier) {
        return createTextureResource(entity, identifier).toString();
    } // getTextureResource ()


    /**
     * <p>Creates a layer ResourceLocation for the specified variant.</p>
     * <p>
     * <b>Path Pattern:</b> layers/{key}/{key}_{variant}.png
     *
     * @param identifier the layer variant name
     * @return ResourceLocation pointing to the layer
     */
    protected static ResourceLocation createLayerResource(String entity, String identifier) {
        return createResource(MonstersConstant.TEXTURE_LAYER_PATH + entity + "/" + identifier + MonstersConstant.TEXTURE_EXTENSION);
    } // createLayerResource ()

    protected static String getLayerResource (String entity, String identifier) {
        return createLayerResource(entity, identifier).toString();
    } // getLayerResource ()


    /**
     * <p>Creates a model ResourceLocation for the specified variant.</p>
     * <p>
     * <b>Path Pattern:</b> geo/{key}.geo.json
     * 
     * @param identifier the model variant name (typically ignored for monsters)
     * @return ResourceLocation pointing to the model
     */
    protected static ResourceLocation createModelResource(String identifier) {
        return createResource(MonstersConstant.MODEL_PATH + identifier + MonstersConstant.MODEL_EXTENSION);
    } // createModelResource ()

    protected static String getModelResource (String identifier) {
        return createModelResource(identifier).toString();
    } // getModelResource ()


    /**
     * <p>Creates an animator ResourceLocation for the specified variant.</p>
     * <p>
     * <b>Path Pattern:</b> animations/{key}.animation.json
     * 
     * @param identifier the animator variant name (typically ignored for monsters)
     * @return ResourceLocation pointing to the animations
     */
    protected static ResourceLocation createAnimatorResource(String identifier) {
        return createResource(MonstersConstant.ANIMATOR_PATH + identifier + MonstersConstant.ANIMATOR_EXTENSION);
    } // createAnimatorResource ()

    protected static String getAnimatorResource (String identifier) {
        return createAnimatorResource(identifier).toString();
    } // getAnimatorResource ()

} // Class: MonstersFamily