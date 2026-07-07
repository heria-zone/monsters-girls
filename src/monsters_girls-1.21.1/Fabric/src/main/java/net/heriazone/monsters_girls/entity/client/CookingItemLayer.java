package net.heriazone.monsters_girls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.heriazone.hzlib.api.layer.IInternalRenderLayer;
import net.heriazone.monsters_girls.entity.common.WildTamableEntity;
import net.heriazone.monsters_girls.entity.custom.MushroomMoltenEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;

/**
 * Render layer that draws up to 4 cooking {@link ItemStack} items hovering above
 * Molten Gal's head in a 2×2 grid.
 * <p>
 * <b>Architecture:</b> Implements {@link IInternalRenderLayer}{@code <WildTamableEntity>}
 * so it plugs into {@link net.heriazone.hzlib.api.entity.NativeRenderer#addLayer}
 * on the shared {@code WildTamableRenderer}. The entity is narrowed to
 * {@link MushroomMoltenEntity} via {@code instanceof} inside each method —
 * non-Molten entities are simply skipped.
 * <p>
 * <b>Loader-specific:</b> Touches {@code ItemRenderer} which differs per mod loader;
 * lives in the Fabric module.
 * <p>
 * <b>Visual:</b> Items spin slowly on the Y axis in a 2×2 grid above the entity's
 * bounding box top. Empty slots are not rendered.
 */
public class CookingItemLayer implements IInternalRenderLayer<WildTamableEntity> {

    // -- Layout constants --

    /** Vertical offset above the entity's bounding box top (blocks). */
    private static final float Y_OFFSET = 0.35f;

    /** Uniform scale applied to each rendered item. */
    private static final float ITEM_SCALE = 0.35f;

    /** Half-spread of the 2×2 grid along X and Z axes (blocks). */
    private static final float SPREAD = 0.22f;

    /**
     * Per-slot X/Z offsets for the 2×2 grid layout.
     * Indices: [slot][0 = X, 1 = Z]
     */
    private static final float[][] GRID = {
            {-SPREAD, -SPREAD},
            { SPREAD, -SPREAD},
            {-SPREAD,  SPREAD},
            { SPREAD,  SPREAD}
    };

    // -- IInternalRenderLayer --

    /** Only renders when the entity is a {@link MushroomMoltenEntity} with at least one occupied slot. */
    @Override
    public boolean shouldRender(WildTamableEntity entity, float partialTick) {
        if (!(entity instanceof MushroomMoltenEntity molten)) return false;
        for (int i = 0; i < MushroomMoltenEntity.COOK_SLOTS; i++) {
            if (!molten.getCookSlot(i).isEmpty()) return true;
        }
        return false;
    } // shouldRender ()

    /**
     * Renders each occupied cook slot as a floating, spinning item above the entity's head.
     */
    @Override
    public void render(PoseStack poseStack, WildTamableEntity entity,
                       BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer,
                       float partialTick, int packedLight, int packedOverlay) {

        if (!(entity instanceof MushroomMoltenEntity molten)) return;

        float yTop = molten.getBbHeight() + Y_OFFSET;
        float spin = (molten.tickCount + partialTick) * 2.0f;

        for (int i = 0; i < MushroomMoltenEntity.COOK_SLOTS; i++) {
            ItemStack stack = molten.getCookSlot(i);
            if (stack.isEmpty()) continue;

            poseStack.pushPose();
            poseStack.translate(GRID[i][0], yTop, GRID[i][1]);
            poseStack.mulPose(Axis.YP.rotationDegrees(spin));
            poseStack.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);

            Minecraft.getInstance().getItemRenderer().renderStatic(
                    stack,
                    ItemDisplayContext.GROUND,
                    packedLight,
                    OverlayTexture.NO_OVERLAY,
                    poseStack,
                    bufferSource,
                    molten.level(),
                    molten.getId() * MushroomMoltenEntity.COOK_SLOTS + i);

            poseStack.popPose();
        }
    } // render ()

} // Class: CookingItemLayer
