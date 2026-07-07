package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.animation.AnimationProfile;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.SpawnFeature;
import net.heriazone.hzlib.api.entity.features.variants.AnimatorVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.ModelVariantFeature;
import net.heriazone.hzlib.api.entity.features.variants.TextureVariantFeature;
import net.heriazone.hzlib.api.entity.variants.VariantRegistries;
import net.heriazone.hzlib.framework.entity.variants.StandardAnimatorVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardModelVariant;
import net.heriazone.hzlib.framework.entity.variants.StandardTextureVariant;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG;
import net.heriazone.monsters_girls.world.BiomesUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Entity family for the Bee Girl — one entity type, 5 texture variants.<p>
 * <p>
 * <b>Architecture:</b> All bee appearances (honey, firely, pixie, silk_moth, black_moth)
 * are texture variants of the single {@link #HONEY} entity type, not separate entity types.
 * This matches the mushroom/globberie pattern — one entity, multiple skins.
 * <p>
 * <b>Spawn:</b> All overworld forest biomes ({@link BiomesUtils#ForestBiomes}),
 * same biome set as Mandrake Flower. Weight 10, groups of 1–3.
 */
public class BeeFamily extends MonstersFamily<BeeFamily> {

    // -- Constants --

    public static final List<BeeFamily> VARIANTS = new ArrayList<>();

    /**
     * Single registered bee entity. Texture variants (firely, pixie, etc.) are selected
     * at spawn via {@link TextureVariantFeature} — not separate EntityType registrations.
     */
    public static final BeeFamily HONEY = create("bee_girl");

    // -- Static Initialization --

    static {
        registerVariants();

        MigrationStep_V1_MG.registerBaseTextureCount("bee_default",   2);
        MigrationStep_V1_MG.registerBaseTextureCount("bee_firely",    2);
        MigrationStep_V1_MG.registerBaseTextureCount("bee_pixie",     2);
        MigrationStep_V1_MG.registerBaseTextureCount("bee_silk_moth", 2);
        MigrationStep_V1_MG.registerBaseTextureCount("bee_black_moth",2);
    }

    // -- Constructors --

    public BeeFamily(String key) {
        super(key);
        withCombatStats(18.0f, 3.0f, 1.2f, 0.1f, 0.2f, 0.0f, 0.6f);
    } // Constructor: BeeFamily ()

    // -- Factory --

    private static BeeFamily create(String key) {
        BeeFamily v = new BeeFamily(key);
        VARIANTS.add(v);
        return v;
    } // create ()

    // -- Variant Configuration --

    @Override
    protected void configureVariants() {
        // Texture variants match the keys registered in registerVariants() exactly.
        // On spawn, initializeRandomVariants() picks one of these keys; NativeModel
        // resolves the ResourceLocation from VariantRegistries.TEXTURES — must match.
        withFeature(TextureVariantFeature.class, new TextureVariantFeature()
                .withVariants("bee_girl", "bee_honey", "bee_firely", "bee_pixie", "bee_silk_moth", "bee_black_moth")
                .withDefault("bee_girl", "bee_honey"));

        withFeature(ModelVariantFeature.class, new ModelVariantFeature()
                .withVariants("bee_girl", "bee_girl_honey")
                .withDefault("bee_girl", "bee_girl_honey"));

        withFeature(AnimatorVariantFeature.class, new AnimatorVariantFeature()
                .withVariants("bee_girl", "bee_girl_honey")
                .withDefault("bee_girl", "bee_girl_honey"));

        withFeature(FoodFeature.class, new FoodFeature()
                .withFoods(Items.HONEYCOMB, Items.HONEY_BOTTLE));

        // Spawn in all forest biomes — includes birch, jungle, dark, cherry, flower forest.
        withFeature(SpawnFeature.class, new SpawnFeature()
                .withModifications(MobCategory.CREATURE, 10, 1, 3,
                        BiomesUtils.ForestBiomes.toArray(new ResourceKey[0]))
                .withPlacements(SpawnPlacementTypes.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        (type, world, reason, pos, random) ->
                                world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)));
    } // configureVariants ()

    // -- Registration --

    private static void registerVariants() {
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("bee_honey",      "Bee Honey",     getTextureResource("bee", "bee_honey"),     1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("bee_firely",     "Bee Firely",    getTextureResource("bee", "bee_firely"),    1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("bee_pixie",      "Bee Pixie",     getTextureResource("bee", "bee_pixie"),     1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("bee_silk_moth",  "Bee Silk Moth", getTextureResource("bee", "bee_silk_moth"), 1));
        VariantRegistries.TEXTURES.register(new StandardTextureVariant("bee_black_moth", "Bee Black Moth",getTextureResource("bee", "bee_black_moth"),1));

        // Bee is flying — idle + vehicle-sit only, no walk/attack animations.
        AnimationProfile BEE_PROFILE = AnimationProfile.builder().idle("idle").sit("ride").build();

        VariantRegistries.MODELS.register(new StandardModelVariant(       "bee_girl_honey","Bee Model",     getModelResource("bee_girl"),               1));
        VariantRegistries.ANIMATORS.register(new StandardAnimatorVariant( "bee_girl_honey","Bee Animations",getAnimatorResource("bee_girl"),BEE_PROFILE,1));
    } // registerVariants ()

} // Class: BeeFamily
