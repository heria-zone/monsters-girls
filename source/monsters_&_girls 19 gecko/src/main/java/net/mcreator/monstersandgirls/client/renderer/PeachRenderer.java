
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.PeachModel;
import net.mcreator.monstersandgirls.entity.layer.PeachLayer;
import net.mcreator.monstersandgirls.entity.PeachEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PeachRenderer extends GeoEntityRenderer<PeachEntity> {
	public PeachRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PeachModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new PeachLayer(this));
	}

	@Override
	public RenderType getRenderType(PeachEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
