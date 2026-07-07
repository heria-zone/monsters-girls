package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.msymbios.monsters_girls.common.entity.InternalEntityType;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.entity.internal.enums.*;
import net.msymbios.monsters_girls.sound.MonstersGirlsSounds;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.*;

/**
 * The Internal Variant contains properties used to determine textures, spawning and stats.
 * <p>
 * NOTE: If the key of anything type changes it must be reflected in the find method using the version.
 */
public class WispVariant extends InternalEntityType<WispVariant> {

    // -- Variables --

    /**
     * The list of all available variant entities.
     */
    public static final List<WispVariant> VARIANTS = new ArrayList<>();

    public static final WispVariant BLUE    = create(MonstersGirlsID.WISP_BLUE).addCombat(18F, 3F, 1.2F, 0.1F, 0.2F, 0F, 0.6F);
    public static final WispVariant GREEN   = create(MonstersGirlsID.WISP_GREEN).addCombat(18F, 3F, 1.2F, 0.1F, 0.2F, 0F, 0.6F);
    public static final WispVariant YELLOW  = create(MonstersGirlsID.WISP_YELLOW).addCombat(18F, 3F, 1.2F, 0.1F, 0.2F, 0F, 0.6F);

    static {
        // WISP BLUE
        BLUE.addSounds();
        BLUE.addAnimations(EntityAnimation.Idle, EntityAnimation.Walk, EntityAnimation.Rest, EntityAnimation.Attack);
        BLUE.addTextures(false,EntityTexture.DEFAULT);
        BLUE.addFoods(Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.RAW_GOLD);
        BLUE.addSpawn(20, 1, 2, BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP);

        // WISP GREEN
        GREEN.addSounds();
        GREEN.addAnimations(EntityAnimation.Idle, EntityAnimation.Walk, EntityAnimation.Rest, EntityAnimation.Attack);
        GREEN.addTextures(false,EntityTexture.DEFAULT);
        GREEN.addFoods(Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.RAW_GOLD);
        GREEN.addSpawn(20, 1, 2, BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP);

        // WISP YELLOW
        YELLOW.addSounds();
        YELLOW.addAnimations(EntityAnimation.Idle, EntityAnimation.Walk, EntityAnimation.Rest, EntityAnimation.Attack);
        YELLOW.addTextures(false, EntityTexture.DEFAULT, EntityTexture.TUMMY);
        YELLOW.addFoods(Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.RAW_GOLD);
        YELLOW.addSpawn(20, 1, 2, BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP);
    }

    // -- Constructors --

    public WispVariant(@NotNull String key) {
        super(key, EntityNative.WISP);
    } // Constructor WispVariant ()

    // -- Custom Methods --

    /**
     * Creates and adds a new entity type to the list of entities types.
     *
     * @param key the key used to identify the entity type (for things like translation text components).
     * @return the instance of the entity type.
     */
    @NotNull
    protected static WispVariant create(@NotNull String key) {
        WispVariant entityNative = new WispVariant(key);
        VARIANTS.add(entityNative);
        return entityNative;
    } // create ()

    /**
     * Adds textures to the WispVariant.
     *
     * @param overrideDefault indicates whether to override the default texture.
     * @param textureSet      the set of textures to add.
     * @return the updated WispVariant instance.
     */
    protected WispVariant addTextures(boolean overrideDefault, EntityTexture... textureSet) {
        // Construct the path for the textures
        var path = "textures/entity/" + this.nativeEntity.getName() + "/" + key;                 // Example: "textures/entity/wisp/wisp_girl_blue"
        // Map to store the textures
        this.textures = new HashMap<>() {{
            // Loop through the given texture set
            for (EntityTexture texture : textureSet) {
                // Switch based on the texture type
                switch (texture) {
                    case SLIM -> put(EntityTexture.SLIM,                MonstersGirlsID.getId(path + "_slim.png"));      // Slim
                    case DEFAULT -> {
                        // Add default texture based on override condition
                        if(overrideDefault) put(EntityTexture.DEFAULT,  MonstersGirlsID.getId(path + "_default.png"));   // Default
                        else put(EntityTexture.DEFAULT,                 MonstersGirlsID.getId(path + ".png"));           // Default
                    }
                    case TUMMY -> put(EntityTexture.TUMMY,              MonstersGirlsID.getId(path + "_tummy.png"));     // Tummy
                    case INFLATED -> put(EntityTexture.INFLATED,        MonstersGirlsID.getId(path + "_inflated.png"));  // Inflated
                    case CHUNKY -> put(EntityTexture.CHUNKY,            MonstersGirlsID.getId(path + "_chunky.png"));    // Chunky
                }
            }
        }};
        return this;
    } // addTextures ()

    /**
     * Adds default sounds to the WispVariant entity.
     *
     * @return the updated WispVariant instance with default sounds added.
     */
    protected WispVariant addSounds() {
        // Initialize a new HashMap for storing sounds
        this.sounds = new HashMap<>() {{
            // Add default sounds for different actions
            put(EntitySound.DEFAULT,    MonstersGirlsSounds.WISP_LAUGH);    // Default
            put(EntitySound.HURT,       MonstersGirlsSounds.WISP_HURT);     // Hurt
            put(EntitySound.DEATH,      MonstersGirlsSounds.WISP_DEATH);    // Death
        }};
        return this;
    } // addSounds ()

    /**
     * Adds animations to the WispVariant entity based on the provided animation set.
     *
     * @param animationSet the set of animations to add
     * @return the updated WispVariant instance with animations added
     */
    protected WispVariant addAnimations(EntityAnimation... animationSet) {
        // Map to store the animations
        this.animations = new HashMap<>() {{
            // Loop through the given animation set
            for (EntityAnimation animation : animationSet) {
                // Switch based on the animation type
                switch (animation) {
                    case Idle -> put(EntityAnimation.Idle,          RawAnimation.begin().thenLoop(EntityAnimation.Idle.getName()));                                 // Idle
                    case Walk -> put(EntityAnimation.Walk,          RawAnimation.begin().thenLoop(EntityAnimation.Walk.getName()));                                 // Walk
                    case Attack -> put(EntityAnimation.Attack,      RawAnimation.begin().then(EntityAnimation.Attack.getName(), Animation.LoopType.PLAY_ONCE));     // Attack
                    case Interact -> put(EntityAnimation.Interact,  RawAnimation.begin().then(EntityAnimation.Interact.getName(), Animation.LoopType.PLAY_ONCE));   // Interact
                    case Rest -> put(EntityAnimation.Rest,          RawAnimation.begin().thenLoop(EntityAnimation.Rest.getName()));                                 // Rest
                    case Wave -> put(EntityAnimation.Wave,          RawAnimation.begin().then(EntityAnimation.Wave.getName(), Animation.LoopType.PLAY_ONCE));       // Wave
                    case Hurt -> put(EntityAnimation.Hurt,          RawAnimation.begin().then(EntityAnimation.Hurt.getName(), Animation.LoopType.PLAY_ONCE));       // Hurt
                }
            }
        }};
        return this;
    } // addAnimations ()

    /**
     * Adds spawn information to the WispVariant entity.
     *
     * @param weight    the weight of the spawn.
     * @param minGroup  the minimum group size for spawning.
     * @param maxGroup  the maximum group size for spawning.
     * @param biomes    the biomes where the entity can spawn.
     * @return the updated WispVariant instance with spawn information added.
     */
    protected WispVariant addSpawn(int weight, int minGroup, int maxGroup, RegistryKey<Biome>... biomes) {
        this.spawnWeight = weight;
        this.spawnMinGroup = minGroup;
        this.spawnMaxGroup = maxGroup;
        this.spawnBiomes = List.of(biomes);
        return this;
    } // addAnimations ()

    /**
     * Adds the given items as foods to blockling type.
     *
     * @param items the items to add as foods.
     */
    private WispVariant addFoods(@NotNull Item... items) {
        this.foods.addAll(Arrays.asList(items));
        return this;
    } // addFoods ()

    /**
     * @param stack the food stack.
     * @return the variant type that eats the given food.
     */
    @NotNull
    public static WispVariant findByFood(@NotNull ItemStack stack) {
        return findByFood(stack.getItem());
    } // findByFood ()

    /**
     * @param item the food item.
     * @return the variant type that eats the given food.
     */
    @NotNull
    public static WispVariant findByFood(@NotNull Item item) {
        return Objects.requireNonNull(VARIANTS.stream().filter(blocklingType -> blocklingType.isFood(item)).findFirst().orElse(null));
    } // findByFood ()

} // Class WispVariant