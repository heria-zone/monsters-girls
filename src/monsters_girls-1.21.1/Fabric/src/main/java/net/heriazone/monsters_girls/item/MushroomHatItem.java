package net.heriazone.monsters_girls.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

import java.util.function.Consumer;

/**
 * A mushroom-cap helmet rendered via GeckoLib using the shared {@code mushroomhat.geo.json}.
 * <p>
 * <b>Architecture:</b> One geo model, 5 shape bones ({@link HatShape}), 12 textures. Each hat
 * activates one bone — the renderer hides the other 4 each frame via bone visibility. The worn
 * texture is the corresponding {@code huge_*} block texture from {@code monsters_girls:block/}.
 * <p>
 * <b>Module placement:</b> Lives in Fabric (not Common) because GeckoLib is a Fabric-only
 * compile dependency in this project. Item registration for hats is done in Fabric's
 * {@code MonstersItems.java} rather than Common's {@code MonstersBlockItems}.
 * <p>
 * <b>GeckoLib 4.x registration:</b> {@link #createGeoRenderer} is the standard GeckoLib 4
 * renderer wiring point — no separate client entry-point call needed.
 */
public class MushroomHatItem extends ArmorItem implements GeoItem {

    // -------------------------------------------------------------------------
    // HatShape — bone selector
    // -------------------------------------------------------------------------

    /**
     * Maps a mushroom family to its bone in {@code mushroomhat.geo.json}.
     * Names must match the geo file exactly.
     */
    public enum HatShape {
        FAT("fat"),       // wide flat — Brown, Fly Agarics
        VERY_FAT("veryfat"),  // extra wide — Ender Puffball
        SKINNY("skinny"), // narrow tall — Ink Cap
        TALL("tall"),     // medium funnel — Crimson, Warped variants
        VERY_TALL("verytall"); // tall with brim — Soul Wanderer, Molten, Infernal

        private final String boneName;
        HatShape(String b) { this.boneName = b; }
        public String getBoneName() { return boneName; }
    } // Enum: HatShape

    // -------------------------------------------------------------------------
    // Fields
    // -------------------------------------------------------------------------

    private final HatShape shape;
    /** Block texture used for worn rendering, e.g. {@code monsters_girls:textures/armor/hat_brown_mushroom}. */
    private final ResourceLocation wornTexture;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public MushroomHatItem(Holder<ArmorMaterial> material, HatShape shape,
                           ResourceLocation wornTexture, Properties properties) {
        super(material, Type.HELMET, properties);
        this.shape       = shape;
        this.wornTexture = wornTexture;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    } // Constructor: MushroomHatItem ()

    // -------------------------------------------------------------------------
    // Accessors
    // -------------------------------------------------------------------------

    public HatShape        getHatShape()    { return shape; }
    public ResourceLocation getWornTexture() { return wornTexture; }

    // -------------------------------------------------------------------------
    // GeoItem — GeckoLib 4.x wiring
    // -------------------------------------------------------------------------

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        // Provide a concrete GeoRenderProvider directly — do NOT call GeoRenderProvider.of(this)
        // which internally calls getRenderProvider() on this item, which calls createGeoRenderer()
        // again via the memoized AnimatableInstanceCache lambda, causing infinite recursion.
        consumer.accept(new GeoRenderProvider() {
            private MushroomHatRenderer renderer;

            @Override
            public @Nullable <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(
                    @Nullable T livingEntity,
                    ItemStack itemStack,
                    @Nullable EquipmentSlot equipmentSlot,
                    @Nullable HumanoidModel<T> original) {
                if (renderer == null) renderer = new MushroomHatRenderer();
                return renderer;
            }
        });
    } // createGeoRenderer ()

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // Static cosmetic — no animation needed.
    } // registerControllers ()

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

    // -------------------------------------------------------------------------
    // Factory
    // -------------------------------------------------------------------------

    /**
     * Builds a hat resolving the texture as {@code monsters_girls:block/{blockTex}}.
     *
     * @param material  armor material from {@link net.heriazone.monsters_girls.item.MonstersArmorMaterials}
     * @param shape     geo bone to activate
     * @param blockTex  block texture name, e.g. {@code "huge_brown_mushroom"}
     */
    public static MushroomHatItem of(Holder<ArmorMaterial> material, HatShape shape,
                                     String blockTex, Properties properties) {
        // GeckoLib resolves textures from the full resource path without any automatic prefix —
        // must include "textures/" explicitly, so it maps to assets/monsters_girls/textures/armor/*.png
        return new MushroomHatItem(material, shape,
                ResourceLocation.fromNamespaceAndPath("monsters_girls", "textures/armor/" + blockTex + ".png"),
                properties);
    } // of ()

} // Class: MushroomHatItem