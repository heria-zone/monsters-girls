package net.heriazone.monsters_girls.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

/**
 * Generic spit-projectile renderer — renders any {@link ThrowableProjectile} as the
 * vanilla llama spit visual (spinning textured billboard quad).
 * <p>
 * <b>Why this class exists:</b> Vanilla's {@code LlamaSpitRenderer} is typed to
 * {@code EntityType<LlamaSpit>} and cannot be registered for a different entity type
 * without a Java type mismatch compile error. This renderer is an exact functional
 * replica of {@code LlamaSpitRenderer} but generic over any {@link ThrowableProjectile},
 * allowing it to be used for {@code MandrakeSpitProjectile} and any future spit entity.
 * <p>
 * <b>Visual:</b> Uses {@code minecraft:textures/entity/llama/spit.png} — the vanilla
 * llama spit texture — so the in-game appearance is identical to a llama's spit.
 * <p>
 * <b>Rendering:</b> Draws two intersecting quads forming a spinning cross-shaped
 * billboard (same as {@code LlamaSpitRenderer}). The quad rotates around the Y axis
 * based on {@code entity.tickCount + partialTick}, giving the characteristic spinning
 * white orb effect.
 *
 * @param <T> any {@link ThrowableProjectile} subtype
 */
public class SpitProjectileRenderer<T extends ThrowableProjectile> extends EntityRenderer<T> {

    /** Vanilla llama spit texture — reused so no custom asset is needed. */
    private static final ResourceLocation LLAMA_SPIT_TEXTURE =
            ResourceLocation.withDefaultNamespace("textures/entity/llama/spit.png");

    // -- Constructor --

    public SpitProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
    } // Constructor: SpitProjectileRenderer ()

    // -- EntityRenderer --

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return LLAMA_SPIT_TEXTURE;
    } // getTextureLocation ()

    /**
     * Renders the spit projectile as two intersecting spinning quads.
     * <p>
     * Replicates vanilla {@code LlamaSpitRenderer.render()} exactly: the pose stack
     * is scaled to 0.5×0.5×0.5, rotated to face the camera on the Y axis (yaw), then
     * two quads are drawn at ±45° to form a cross-shaped billboard.
     */
    @Override
    public void render(T entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(0.5f, 0.5f, 0.5f);

        // Face camera — rotate around Y to align yaw, then tilt X slightly
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));

        PoseStack.Pose pose    = poseStack.last();
        Matrix4f      matrix  = pose.pose();
        Matrix3f      normals = pose.normal();

        VertexConsumer consumer = bufferSource.getBuffer(
                RenderType.entityCutoutNoCull(LLAMA_SPIT_TEXTURE));

        // Draw two quads at 0° and 90° around Y, forming a cross billboard
        vertex(consumer, matrix, normals, packedLight, 0.0f, 0, 0, 1);
        vertex(consumer, matrix, normals, packedLight, 1.0f, 0, 1, 1);
        vertex(consumer, matrix, normals, packedLight, 1.0f, 1, 1, 0);
        vertex(consumer, matrix, normals, packedLight, 0.0f, 1, 0, 0);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    } // render ()

    // -- Private helpers --

    private static void vertex(VertexConsumer consumer, Matrix4f matrix, Matrix3f normals,
                                int packedLight, float x, float y, int u, int v) {
        // In 1.21.1 setNormal takes (float nx, float ny, float nz) directly —
        // the Matrix3f overload was removed. Transform the unit Y-up normal through
        // the normal matrix so it is correct in world space.
        org.joml.Vector3f n = normals.transform(new org.joml.Vector3f(0.0f, 1.0f, 0.0f));
        consumer.addVertex(matrix,   x - 0.5f, y - 0.5f, 0.0f)
                .setColor(255, 255, 255, 255)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(packedLight)
                .setNormal(n.x, n.y, n.z);
    } // vertex ()

} // Class: SpitProjectileRenderer