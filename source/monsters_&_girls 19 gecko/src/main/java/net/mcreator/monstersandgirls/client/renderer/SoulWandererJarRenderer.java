
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.SoulWandererJarModel;
import net.mcreator.monstersandgirls.entity.layer.SoulWandererJarLayer;
import net.mcreator.monstersandgirls.entity.SoulWandererJarEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SoulWandererJarRenderer extends GeoEntityRenderer<SoulWandererJarEntity> {
	public SoulWandererJarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SoulWandererJarModel());
		this.shadowRadius = 0f;
		this.addLayer(new SoulWandererJarLayer(this));
	}

	@Override
	public RenderType getRenderType(SoulWandererJarEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
