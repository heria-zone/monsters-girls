
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.WarpedMushroomGalBigSpotsModel;
import net.mcreator.monstersandgirls.entity.layer.WarpedMushroomGalBigSpotsLayer;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalBigSpotsEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WarpedMushroomGalBigSpotsRenderer extends GeoEntityRenderer<WarpedMushroomGalBigSpotsEntity> {
	public WarpedMushroomGalBigSpotsRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new WarpedMushroomGalBigSpotsModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new WarpedMushroomGalBigSpotsLayer(this));
	}

	@Override
	public RenderType getRenderType(WarpedMushroomGalBigSpotsEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
