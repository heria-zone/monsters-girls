
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.WarpedJarModel;
import net.mcreator.monstersandgirls.entity.layer.WarpedJarLayer;
import net.mcreator.monstersandgirls.entity.WarpedJarEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WarpedJarRenderer extends GeoEntityRenderer<WarpedJarEntity> {
	public WarpedJarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new WarpedJarModel());
		this.shadowRadius = 0f;
		this.addLayer(new WarpedJarLayer(this));
	}

	@Override
	public RenderType getRenderType(WarpedJarEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
