
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.BrownMandragoraModel;
import net.mcreator.monstersandgirls.entity.layer.BrownMandragoraLayer;
import net.mcreator.monstersandgirls.entity.BrownMandragoraEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BrownMandragoraRenderer extends GeoEntityRenderer<BrownMandragoraEntity> {
	public BrownMandragoraRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BrownMandragoraModel());
		this.shadowRadius = 0.2f;
		this.addLayer(new BrownMandragoraLayer(this));
	}

	@Override
	public RenderType getRenderType(BrownMandragoraEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.7f, 0.7f, 0.7f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
