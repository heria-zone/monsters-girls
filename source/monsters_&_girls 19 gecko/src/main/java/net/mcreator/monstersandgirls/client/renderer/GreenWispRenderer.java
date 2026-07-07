
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.GreenWispModel;
import net.mcreator.monstersandgirls.entity.layer.GreenWispLayer;
import net.mcreator.monstersandgirls.entity.GreenWispEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GreenWispRenderer extends GeoEntityRenderer<GreenWispEntity> {
	public GreenWispRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GreenWispModel());
		this.shadowRadius = 0.1f;
		this.addLayer(new GreenWispLayer(this));
	}

	@Override
	public RenderType getRenderType(GreenWispEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
