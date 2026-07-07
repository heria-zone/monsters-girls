
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.InkCapBedModel;
import net.mcreator.monstersandgirls.entity.InkCapBedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class InkCapBedRenderer extends GeoEntityRenderer<InkCapBedEntity> {
	public InkCapBedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new InkCapBedModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(InkCapBedEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
