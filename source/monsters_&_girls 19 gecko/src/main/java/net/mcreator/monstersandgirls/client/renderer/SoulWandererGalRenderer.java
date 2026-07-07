
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.SoulWandererGalModel;
import net.mcreator.monstersandgirls.entity.layer.SoulWandererGalLayer;
import net.mcreator.monstersandgirls.entity.SoulWandererGalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SoulWandererGalRenderer extends GeoEntityRenderer<SoulWandererGalEntity> {
	public SoulWandererGalRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SoulWandererGalModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new SoulWandererGalLayer(this));
	}

	@Override
	public RenderType getRenderType(SoulWandererGalEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
