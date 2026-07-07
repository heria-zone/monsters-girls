
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.BlueWispModel;
import net.mcreator.monstersandgirls.entity.layer.BlueWispLayer;
import net.mcreator.monstersandgirls.entity.BlueWispEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BlueWispRenderer extends GeoEntityRenderer<BlueWispEntity> {
	public BlueWispRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BlueWispModel());
		this.shadowRadius = 0.1f;
		this.addLayer(new BlueWispLayer(this));
	}

	@Override
	public RenderType getRenderType(BlueWispEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
