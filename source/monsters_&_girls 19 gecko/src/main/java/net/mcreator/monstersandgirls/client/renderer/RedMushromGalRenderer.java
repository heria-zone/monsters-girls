
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.RedMushromGalModel;
import net.mcreator.monstersandgirls.entity.RedMushromGalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class RedMushromGalRenderer extends GeoEntityRenderer<RedMushromGalEntity> {
	public RedMushromGalRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RedMushromGalModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(RedMushromGalEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
