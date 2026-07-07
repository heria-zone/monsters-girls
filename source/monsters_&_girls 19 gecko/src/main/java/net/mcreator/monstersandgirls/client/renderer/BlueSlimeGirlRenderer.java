
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.BlueSlimeGirlModel;
import net.mcreator.monstersandgirls.entity.BlueSlimeGirlEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BlueSlimeGirlRenderer extends GeoEntityRenderer<BlueSlimeGirlEntity> {
	public BlueSlimeGirlRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BlueSlimeGirlModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(BlueSlimeGirlEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(BlueSlimeGirlEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
