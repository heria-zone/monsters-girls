package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.heriazone.hzlib.api.entity.features.FoodFeature;
import net.heriazone.hzlib.api.entity.features.exchange.ExchangeFeature;
import net.heriazone.hzlib.api.entity.features.exchange.ExchangeFeedback;
import net.heriazone.hzlib.api.entity.features.exchange.ExchangeRule;
import net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature;
import net.heriazone.monsters_girls.*;
import net.heriazone.monsters_girls.entity.MonstersFamily;
import net.heriazone.monsters_girls.entity.client.SpitProjectileRenderer;
import net.heriazone.monsters_girls.entity.common.*;
import net.heriazone.monsters_girls.entity.custom.*;
import net.heriazone.monsters_girls.entity.feature.GenesisFeature;
import net.heriazone.monsters_girls.source.MonstersBlocks;
import net.heriazone.monsters_girls.entity.projectile.MandrakeSpitProjectile;
import net.heriazone.monsters_girls.entity.projectile.MushroomSnowball;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public class MonstersEntities {

    // -- Entity Type Definitions --

    // BEE (flying)
    public static final EntityType<BeeEntity> BEE_HONEY = register(MonstersConstant.BEE_HONEY,   (type, world) -> new BeeEntity(type, world, BeeFamily.HONEY),   0.5F, 0.9F);

    // GLOBBERIE (flying)
    public static final EntityType<GlobberieEntity> GLOBBERIE = register(MonstersConstant.GLOBBERIE_PINK,          (type, world) -> new GlobberieEntity(type, world, GlobberieFamily.GLOBBERIE),          0.5F, 0.9F);

    // GOURDRAGORA — 3 entity variants (Golden, Lumina, Jack'O).
    public static final EntityType<GourdragoraEntity> GOURDRAGORA_GOLDEN = register(MonstersConstant.GOURDRAGORA_GOLDEN, (type, world) -> new GourdragoraEntity(type, world, GourdragoraFamily.GOLDEN), 0.8F, 1.5F);
    public static final EntityType<GourdragoraEntity> GOURDRAGORA_LUMINA = register(MonstersConstant.GOURDRAGORA_LUMINA, (type, world) -> new GourdragoraEntity(type, world, GourdragoraFamily.LUMINA), 0.8F, 1.5F);
    public static final EntityType<GourdragoraEntity> GOURDRAGORA_JACKO  = register(MonstersConstant.GOURDRAGORA_JACKO,  (type, world) -> new GourdragoraEntity(type, world, GourdragoraFamily.JACKO),  0.8F, 1.5F);

    // MAIDEN OF THE SKIES (flying)
    public static final EntityType<MaidenEntity> MAIDEN = register(MonstersConstant.MAIDEN, (type, world) -> new MaidenEntity(type, world, MaidenFamily.DEFAULT), 0.6F, 1.2F);

    // SLIME
    public static final EntityType<SlimeEntity> SLIME_BLUE = register(MonstersConstant.SLIME_BLUE, (type, world) -> new SlimeEntity(type, world, SlimeFamily.BLUE), 0.6F, 1.0F);

    public static final EntityType<MandrakeEntity> MANDRAKE_CHORUS = register(MonstersConstant.MANDRAKE_CHORUS, (type, world) -> new MandrakeEntity(type, world, MandrakeFamily.CHORUS), 0.4F, 0.8F);
    public static final EntityType<MandrakeEntity> MANDRAKE_FLOWER = register(MonstersConstant.MANDRAKE_FLOWER, (type, world) -> new MandrakeEntity(type, world, MandrakeFamily.FLOWER), 0.4F, 0.8F);
    public static final EntityType<MandrakeEntity> MANDRAKE_FRUCTUS  = register(MonstersConstant.MANDRAKE_FRUCTUS,  (type, world) -> new MandrakeEntity(type, world, MandrakeFamily.FRUCTUS), 0.4F, 0.8F);

    public static final EntityType<MushroomEntity> MUSHROOM_AMANITA      = register(MonstersConstant.MUSHROOM_AMANITA,       (type, world) -> new MushroomEntity(type, world, MushroomFamily.AMANITA),      0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_BROWN        = register(MonstersConstant.MUSHROOM_BROWN,         (type, world) -> new MushroomEntity(type, world, MushroomFamily.BROWN),        0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_CRIMSON      = register(MonstersConstant.MUSHROOM_CRIMSON,       (type, world) -> new MushroomEntity(type, world, MushroomFamily.CRIMSON),      0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_INFERNAL     = register(MonstersConstant.MUSHROOM_INFERNAL,      (type, world) -> new MushroomEntity(type, world, MushroomFamily.INFERNAL),     0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_INKCAPS      = register(MonstersConstant.MUSHROOM_INKCAPS,       (type, world) -> new MushroomEntity(type, world, MushroomFamily.INKCAPS),      0.4F, 0.8F);
    public static final EntityType<net.heriazone.monsters_girls.entity.custom.MushroomMoltenEntity> MUSHROOM_MOLTEN =
            register(MonstersConstant.MUSHROOM_MOLTEN,
                    (type, world) -> new net.heriazone.monsters_girls.entity.custom.MushroomMoltenEntity(type, world, MushroomFamily.MOLTEN),
                    0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_PUFFBALL     = register(MonstersConstant.MUSHROOM_PUFFBALL,      (type, world) -> new MushroomEntity(type, world, MushroomFamily.PUFFBALL),     0.4F, 0.8F);

    /** Fluffball — flying End biome variant of the Puffball mushroom family. */
    public static final EntityType<net.heriazone.monsters_girls.entity.common.FlyTamableEntity> MUSHROOM_FLUFFBALL =
            register(MonstersConstant.MUSHROOM_FLUFFBALL,
                    (type, world) -> new net.heriazone.monsters_girls.entity.common.FlyTamableEntity(type, world, MushroomFamily.FLUFFBALL),
                    0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_SNOWBALL     = register(MonstersConstant.MUSHROOM_SNOWBALL,      (type, world) -> new MushroomEntity(type, world, MushroomFamily.SNOWBALL),     0.4F, 0.8F);

    /** Projectile thrown by Mushroom Snowball girl — applies freeze + slow on entity hit. */
    public static final EntityType<MushroomSnowball> MUSHROOM_SNOWBALL_PROJECTILE =
            Registry.register(BuiltInRegistries.ENTITY_TYPE,
                    net.heriazone.monsters_girls.MonstersIdentifier.getId(MonstersConstant.MUSHROOM_SNOWBALL_PROJECTILE),
                    FabricEntityTypeBuilder.<net.heriazone.monsters_girls.entity.projectile.MushroomSnowball>create(MobCategory.MISC,
                                    MushroomSnowball::new)
                            .dimensions(EntityDimensions.scalable(0.25F, 0.25F))
                            .trackRangeBlocks(4).trackedUpdateRate(10)
                            .build());

    /** Projectile spat by Mandrake Chorus girl — applies Poison + Nausea on entity hit. */
    public static final EntityType<net.heriazone.monsters_girls.entity.projectile.MandrakeSpitProjectile> MANDRAKE_CHORUS_SPIT =
            Registry.register(BuiltInRegistries.ENTITY_TYPE,
                    net.heriazone.monsters_girls.MonstersIdentifier.getId(MonstersConstant.MANDRAKE_CHORUS_SPIT),
                    FabricEntityTypeBuilder.<net.heriazone.monsters_girls.entity.projectile.MandrakeSpitProjectile>create(MobCategory.MISC,
                                    MandrakeSpitProjectile::new)
                            .dimensions(EntityDimensions.scalable(0.25F, 0.25F))
                            .trackRangeBlocks(4).trackedUpdateRate(10)
                            .build());

    public static final EntityType<MushroomEntity> MUSHROOM_SOUL_WANDERER = register(MonstersConstant.MUSHROOM_SOUL_WANDERER, (type, world) -> new MushroomEntity(type, world, MushroomFamily.SOUL_WANDERER), 0.4F, 0.8F);
    public static final EntityType<MushroomEntity> MUSHROOM_WARPED       = register(MonstersConstant.MUSHROOM_WARPED,        (type, world) -> new MushroomEntity(type, world, MushroomFamily.WARPED),       0.4F, 0.8F);

    public static final EntityType<SpookEntity> SPOOK_CREAM = register(MonstersConstant.SPOOK_CREAM, (type, world) -> new SpookEntity(type, world, SpookFamily.CREAM), 0.4F, 0.8F);
    public static final EntityType<SpookEntity> SPOOK_PEACH = register(MonstersConstant.SPOOK_PEACH, (type, world) -> new SpookEntity(type, world, SpookFamily.PEACH), 0.4F, 0.8F);
    public static final EntityType<SpookEntity> SPOOK_TEAL  = register(MonstersConstant.SPOOK_TEAL,  (type, world) -> new SpookEntity(type, world, SpookFamily.TEAL), 0.4F, 0.8F);

    public static final EntityType<WispEntity> WISP_BLUE   = register(MonstersConstant.WISP_BLUE,   (type, world) -> new WispEntity(type, world, WispFamily.BLUE), 0.4F, 0.8F);
    public static final EntityType<WispEntity> WISP_GREEN  = register(MonstersConstant.WISP_GREEN,  (type, world) -> new WispEntity(type, world, WispFamily.GREEN), 0.4F, 0.8F);
    public static final EntityType<WispEntity> WISP_YELLOW = register(MonstersConstant.WISP_YELLOW, (type, world) -> new WispEntity(type, world, WispFamily.YELLOW), 0.4F, 0.8F);

    // -- Registration Methods --

    /**
     * Registers a monster entity type with a fixed creature dimension.
     * <p>
     * <b>Architecture:</b> Generic entry point for all entity registrations, eliminating
     * per-type overloads. The factory lambda captures the variant type and delegates
     * construction to the concrete entity class, keeping registration logic centralized.
     * <p>
     * <b>Design Decision:</b> {@code MonstersFamily} as the variant bound allows all
     * current entity families (Mushroom, Spook, Wisp) to share this method without
     * sacrificing type safety at the call site.
     *
     * @param <E>         concrete entity type, must extend {@link WildTamableEntity}
     * @param name        registry name for the entity
     * @param factory     bi-function that constructs the entity from its type and world
     * @return the registered {@link EntityType}
     */
    @NotNull
    private static <E extends WildTamableEntity> EntityType<E> register(String name, BiFunction<EntityType<E>, Level, E> factory, float height, float width) {
        return Registry.register(
                BuiltInRegistries.ENTITY_TYPE, MonstersIdentifier.getId(name),
                FabricEntityTypeBuilder.<E>create(MobCategory.CREATURE, factory::apply).dimensions(EntityDimensions.scalable(height, width)).build()
        );
    } // register()

    /**
     * Registers entity attributes.
     * <p>
     * <b>Architecture:</b> All attribute builders are produced by the shared factory methods
     * {@link MonstersFamily#createGroundAttributes} and {@link MonstersFamily#createFlyingAttributes},
     * eliminating per-entity boilerplate. Flying entities additionally register
     * {@code FLYING_SPEED}; ground entities do not.
     */
    public static void register() {
        // BEE — flying
        FabricDefaultAttributeRegistry.register(BEE_HONEY,    MonstersFamily.createFlyingAttributes(BeeFamily.HONEY));

        // GLOBBERIE — flying
        FabricDefaultAttributeRegistry.register(GLOBBERIE,          MonstersFamily.createFlyingAttributes(GlobberieFamily.GLOBBERIE));

        // GOURDRAGORA — ground
        FabricDefaultAttributeRegistry.register(GOURDRAGORA_GOLDEN, MonstersFamily.createGroundAttributes(GourdragoraFamily.GOLDEN));
        FabricDefaultAttributeRegistry.register(GOURDRAGORA_LUMINA, MonstersFamily.createGroundAttributes(GourdragoraFamily.LUMINA));
        FabricDefaultAttributeRegistry.register(GOURDRAGORA_JACKO,  MonstersFamily.createGroundAttributes(GourdragoraFamily.JACKO));

        // MAIDEN — flying
        FabricDefaultAttributeRegistry.register(MAIDEN, MonstersFamily.createFlyingAttributes(MaidenFamily.DEFAULT));

        // SLIME — ground
        FabricDefaultAttributeRegistry.register(SLIME_BLUE, MonstersFamily.createGroundAttributes(SlimeFamily.BLUE));

        // MANDRAKE — ground
        FabricDefaultAttributeRegistry.register(MANDRAKE_CHORUS, MonstersFamily.createGroundAttributes(MandrakeFamily.CHORUS));
        FabricDefaultAttributeRegistry.register(MANDRAKE_FLOWER, MonstersFamily.createGroundAttributes(MandrakeFamily.FLOWER));
        FabricDefaultAttributeRegistry.register(MANDRAKE_FRUCTUS, MonstersFamily.createGroundAttributes(MandrakeFamily.FRUCTUS));

        // MUSHROOM — ground
        FabricDefaultAttributeRegistry.register(MUSHROOM_AMANITA,       MonstersFamily.createGroundAttributes(MushroomFamily.AMANITA));
        FabricDefaultAttributeRegistry.register(MUSHROOM_BROWN,         MonstersFamily.createGroundAttributes(MushroomFamily.BROWN));
        FabricDefaultAttributeRegistry.register(MUSHROOM_CRIMSON,       MonstersFamily.createGroundAttributes(MushroomFamily.CRIMSON));
        FabricDefaultAttributeRegistry.register(MUSHROOM_INFERNAL,      MonstersFamily.createGroundAttributes(MushroomFamily.INFERNAL));
        FabricDefaultAttributeRegistry.register(MUSHROOM_INKCAPS,       MonstersFamily.createGroundAttributes(MushroomFamily.INKCAPS));
        FabricDefaultAttributeRegistry.register(MUSHROOM_MOLTEN,
                MonstersFamily.createGroundAttributes(MushroomFamily.MOLTEN));
        FabricDefaultAttributeRegistry.register(MUSHROOM_PUFFBALL,      MonstersFamily.createGroundAttributes(MushroomFamily.PUFFBALL));
        FabricDefaultAttributeRegistry.register(MUSHROOM_FLUFFBALL,     MonstersFamily.createFlyingAttributes(MushroomFamily.FLUFFBALL));
        FabricDefaultAttributeRegistry.register(MUSHROOM_SNOWBALL,      MonstersFamily.createGroundAttributes(MushroomFamily.SNOWBALL));
        FabricDefaultAttributeRegistry.register(MUSHROOM_SOUL_WANDERER, MonstersFamily.createGroundAttributes(MushroomFamily.SOUL_WANDERER));
        FabricDefaultAttributeRegistry.register(MUSHROOM_WARPED,        MonstersFamily.createGroundAttributes(MushroomFamily.WARPED));

        // SPOOK — flying
        FabricDefaultAttributeRegistry.register(SPOOK_CREAM, MonstersFamily.createFlyingAttributes(SpookFamily.CREAM));
        FabricDefaultAttributeRegistry.register(SPOOK_PEACH, MonstersFamily.createFlyingAttributes(SpookFamily.PEACH));
        FabricDefaultAttributeRegistry.register(SPOOK_TEAL,  MonstersFamily.createFlyingAttributes(SpookFamily.TEAL));

        // WISP — flying
        FabricDefaultAttributeRegistry.register(WISP_BLUE,   MonstersFamily.createFlyingAttributes(WispFamily.BLUE));
        FabricDefaultAttributeRegistry.register(WISP_GREEN,  MonstersFamily.createFlyingAttributes(WispFamily.GREEN));
        FabricDefaultAttributeRegistry.register(WISP_YELLOW, MonstersFamily.createFlyingAttributes(WispFamily.YELLOW));
    } // register ()

    /**
     * Registers entity renderers on client side.
     * <p>
     * <b>OverlayFeature bridge:</b> Entities whose {@link MonstersFamily} declares an
     * {@link net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature} use a factory
     * lambda that creates the {@link WildTamableRenderer} and then calls
     * {@link WildTamableRenderer#buildOverlayLayers} with the feature, adding one
     * {@link net.heriazone.hzlib.api.layer.OverlayLayer} per declared slot. Entities with
     * no {@code OverlayFeature} use the plain {@code WildTamableRenderer::new} method reference.
     */
    public static void registerRender() {
        EntityRendererRegistry.register(BEE_HONEY,   WildTamableRenderer::new);

        EntityRendererRegistry.register(GLOBBERIE, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            GlobberieFamily.GLOBBERIE.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });

        // Gourdragora — all three variants have OverlayFeature (carvings + emissive)
        EntityRendererRegistry.register(GOURDRAGORA_GOLDEN, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            GourdragoraFamily.GOLDEN.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(GOURDRAGORA_LUMINA, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            GourdragoraFamily.LUMINA.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(GOURDRAGORA_JACKO, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            GourdragoraFamily.JACKO.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });

        EntityRendererRegistry.register(MAIDEN,     WildTamableRenderer::new);

        EntityRendererRegistry.register(SLIME_BLUE, WildTamableRenderer::new);

        EntityRendererRegistry.register(MANDRAKE_CHORUS, WildTamableRenderer::new);
        // Flower — has OverlayFeature (RANDOM hair + ALWAYS emissive)
        EntityRendererRegistry.register(MANDRAKE_FLOWER, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MandrakeFamily.FLOWER.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MANDRAKE_FRUCTUS,  WildTamableRenderer::new);

        // Mushroom families with OverlayFeature (seasonal costume overlay)
        EntityRendererRegistry.register(MUSHROOM_AMANITA, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.AMANITA.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_BROWN, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.BROWN.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_CRIMSON, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.CRIMSON.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_INFERNAL, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.INFERNAL.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_INKCAPS,       WildTamableRenderer::new);
        EntityRendererRegistry.register(MUSHROOM_MOLTEN, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.MOLTEN.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            // CookingItemLayer renders up to 4 food items floating above Molten Gal's head
            r.addLayer(new net.heriazone.monsters_girls.entity.client.CookingItemLayer());
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_PUFFBALL, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.PUFFBALL.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_FLUFFBALL, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.FLUFFBALL.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_SNOWBALL, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.SNOWBALL.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_SOUL_WANDERER, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.SOUL_WANDERER.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(MUSHROOM_WARPED, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            MushroomFamily.WARPED.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });

        EntityRendererRegistry.register(SPOOK_CREAM, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            SpookFamily.CREAM.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(SPOOK_PEACH, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            SpookFamily.PEACH.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(SPOOK_TEAL, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            SpookFamily.TEAL.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });

        EntityRendererRegistry.register(WISP_BLUE, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            WispFamily.BLUE.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(WISP_GREEN, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            WispFamily.GREEN.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });
        EntityRendererRegistry.register(WISP_YELLOW, ctx -> {
            WildTamableRenderer r = new WildTamableRenderer(ctx);
            WispFamily.YELLOW.getFeature(OverlayFeature.class).ifPresent(r::buildOverlayLayers);
            return r;
        });

        // Snowball projectile — uses vanilla ThrownItemRenderer (snowball item sprite)
        EntityRendererRegistry.register(MUSHROOM_SNOWBALL_PROJECTILE, ThrownItemRenderer::new);

        // Chorus spit projectile — SpitProjectileRenderer gives the vanilla llama spit visual
        // (spinning white orb using minecraft:textures/entity/llama/spit.png).
        EntityRendererRegistry.register(MANDRAKE_CHORUS_SPIT, SpitProjectileRenderer::new);
    } // registerRender ()

    /**
     * Wires Genesis Powder spawn triggers for all registered entity types,
     * and applies any ExchangeFeature rules that depend on Fabric-side item references.
     */
    public static void registerFeatures() {

        // -- Genesis feature registration --
        MushroomFamily.AMANITA.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_AMANITA));
        MushroomFamily.BROWN.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_BROWN));
        MushroomFamily.CRIMSON.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_CRIMSON));
        MushroomFamily.INFERNAL.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_INFERNAL));
        MushroomFamily.WARPED.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_WARPED));
        MushroomFamily.INKCAPS.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_INKCAPS));
        MushroomFamily.MOLTEN.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_MOLTEN));
        MushroomFamily.PUFFBALL.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_PUFFBALL));
        MushroomFamily.FLUFFBALL.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_FLUFFBALL));
        MushroomFamily.SNOWBALL.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_SNOWBALL));
        MushroomFamily.SOUL_WANDERER.getFeature(GenesisFeature.class).ifPresent(f -> GenesisFeature.register(f, MUSHROOM_SOUL_WANDERER));

        // -- Exchange features (bowl → stew) — wired here because MonstersItems lives in Fabric --

        // Infernal: bowl → nether stew (fire resistance)
        MushroomFamily.INFERNAL.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_NETHER))
                        .cooldown(6000)
                        .build())
                .build());

        // Crimson: bowl → nether stew (fire resistance)
        MushroomFamily.CRIMSON.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_NETHER))
                        .cooldown(6000)
                        .build())
                .build());

        // Warped: bowl → nether stew (fire resistance)
        MushroomFamily.WARPED.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_NETHER))
                        .cooldown(6000)
                        .build())
                .build());

        // -- Other entity feature overrides --
        GourdragoraFamily.JACKO.withFeature(FoodFeature.class, new FoodFeature().withFoods(Items.CAKE, MonstersItems.CANDIES));

        // -- Exchange features (bowl → stew) for remaining mushroom families --

        // Inkcaps: bowl → poison stew
        MushroomFamily.INKCAPS.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_POISON))
                        .cooldown(6000)
                        .build())
                .build());

        // Molten: bowl → molten stew (blazing effect)
        MushroomFamily.MOLTEN.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_MOLTEN))
                        .cooldown(6000)
                        .build())
                .build());

        // Puffball: bowl → puffball stew (puffy effect)
        MushroomFamily.PUFFBALL.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_PUFFBALL))
                        .cooldown(6000)
                        .build())
                .build());

        // Snowball: bowl → snowball stew (chilly effect)
        MushroomFamily.SNOWBALL.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_SNOWBALL))
                        .cooldown(6000)
                        .build())
                .build());

        // Soul Wanderer: bowl → soul wanderer stew (soul wanderer's touch effect)
        MushroomFamily.SOUL_WANDERER.withFeature(ExchangeFeature.class, ExchangeFeature.builder()
                .ownerOnly()
                .globalFeedback(ExchangeFeedback.builder()
                        .sound(SoundEvents.BUCKET_FILL)
                        .particle(ExchangeFeedback.ParticleType.HAPPY_VILLAGER)
                        .build())
                .rule(ExchangeRule.builder()
                        .inputs(Items.BOWL)
                        .output(() -> new ItemStack(MonstersItems.STEW_SOUL_WANDERER))
                        .cooldown(6000)
                        .build())
                .build());

        // -- Ranged attack features --
        // Wired here (loader side) because the projectile EntityType lives in MonstersEntities.
        // The family descriptor stays Common-clean; the loader provides the concrete type reference.

        // Snowball Mushroom: throws MushroomSnowball — freeze + slow on hit
        MushroomFamily.SNOWBALL.withFeature(net.heriazone.hzlib.api.entity.features.RangedAttackFeature.class,
                net.heriazone.hzlib.api.entity.features.RangedAttackFeature.of(MUSHROOM_SNOWBALL_PROJECTILE, MushroomSnowball::new).interval(20, 40).range(15.0f));

        // Mandrake Chorus: spits MandrakeSpitProjectile — Poison + Nausea on hit
        MandrakeFamily.CHORUS.withFeature(net.heriazone.hzlib.api.entity.features.RangedAttackFeature.class,
                net.heriazone.hzlib.api.entity.features.RangedAttackFeature.of(MANDRAKE_CHORUS_SPIT, MandrakeSpitProjectile::new).interval(30, 60).range(12.0f));

        // Mandrake Flower: override planting target to use the custom mandrake_flower_plant block
        // (MonstersBlocks is now registered, so the field is non-null at this point).
        MandrakeFamily.FLOWER.withFeature(net.heriazone.hzlib.api.entity.features.PlantingFeature.class,
                net.heriazone.hzlib.api.entity.features.PlantingFeature.builder()
                        .globalCooldown(3600)
                        .entry(net.heriazone.hzlib.api.entity.features.PlantingFeature.PlantItem
                                .of(MonstersBlocks.MANDRAKE_FLOWER_PLANT)
                                .allowedBlocks(
                                        net.minecraft.world.level.block.Blocks.GRASS_BLOCK,
                                        net.minecraft.world.level.block.Blocks.DIRT,
                                        net.minecraft.world.level.block.Blocks.COARSE_DIRT,
                                        net.minecraft.world.level.block.Blocks.PODZOL,
                                        net.minecraft.world.level.block.Blocks.ROOTED_DIRT,
                                        net.minecraft.world.level.block.Blocks.MUD,
                                        net.minecraft.world.level.block.Blocks.MUDDY_MANGROVE_ROOTS)
                                .build())
                        .build());

    } // registerFeatures ()

} // Class: MonstersEntities