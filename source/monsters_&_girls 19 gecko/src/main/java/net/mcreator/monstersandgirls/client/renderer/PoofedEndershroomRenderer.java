
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.PoofedEndershroomModel;
import net.mcreator.monstersandgirls.entity.layer.PoofedEndershroomLayer;
import net.mcreator.monstersandgirls.entity.PoofedEndershroomEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PoofedEndershroomRenderer extends GeoEntityRenderer<PoofedEndershroomEntity> {
	public PoofedEndershroomRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PoofedEndershroomModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new PoofedEndershroomLayer(this));
	}

	@Override
	public RenderType getRenderType(PoofedEndershroomEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
