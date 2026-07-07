
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.YellowWispModel;
import net.mcreator.monstersandgirls.entity.layer.YellowWispLayer;
import net.mcreator.monstersandgirls.entity.YellowWispEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class YellowWispRenderer extends GeoEntityRenderer<YellowWispEntity> {
	public YellowWispRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new YellowWispModel());
		this.shadowRadius = 0.1f;
		this.addLayer(new YellowWispLayer(this));
	}

	@Override
	public RenderType getRenderType(YellowWispEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
