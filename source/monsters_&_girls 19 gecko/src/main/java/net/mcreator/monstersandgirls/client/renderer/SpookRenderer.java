
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.SpookModel;
import net.mcreator.monstersandgirls.entity.layer.SpookLayer;
import net.mcreator.monstersandgirls.entity.SpookEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpookRenderer extends GeoEntityRenderer<SpookEntity> {
	public SpookRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SpookModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new SpookLayer(this));
	}

	@Override
	public RenderType getRenderType(SpookEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
