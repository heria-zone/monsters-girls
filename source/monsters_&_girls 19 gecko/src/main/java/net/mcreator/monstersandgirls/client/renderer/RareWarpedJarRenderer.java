
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.RareWarpedJarModel;
import net.mcreator.monstersandgirls.entity.layer.RareWarpedJarLayer;
import net.mcreator.monstersandgirls.entity.RareWarpedJarEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class RareWarpedJarRenderer extends GeoEntityRenderer<RareWarpedJarEntity> {
	public RareWarpedJarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RareWarpedJarModel());
		this.shadowRadius = 0f;
		this.addLayer(new RareWarpedJarLayer(this));
	}

	@Override
	public RenderType getRenderType(RareWarpedJarEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
