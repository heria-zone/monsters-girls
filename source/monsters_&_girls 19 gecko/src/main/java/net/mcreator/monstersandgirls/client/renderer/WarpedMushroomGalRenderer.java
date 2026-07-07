
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.WarpedMushroomGalModel;
import net.mcreator.monstersandgirls.entity.layer.WarpedMushroomGalLayer;
import net.mcreator.monstersandgirls.entity.WarpedMushroomGalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WarpedMushroomGalRenderer extends GeoEntityRenderer<WarpedMushroomGalEntity> {
	public WarpedMushroomGalRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new WarpedMushroomGalModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new WarpedMushroomGalLayer(this));
	}

	@Override
	public RenderType getRenderType(WarpedMushroomGalEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
