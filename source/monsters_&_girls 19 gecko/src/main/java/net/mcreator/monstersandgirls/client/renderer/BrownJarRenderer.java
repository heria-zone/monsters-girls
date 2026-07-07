
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.BrownJarModel;
import net.mcreator.monstersandgirls.entity.BrownJarEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BrownJarRenderer extends GeoEntityRenderer<BrownJarEntity> {
	public BrownJarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BrownJarModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(BrownJarEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
