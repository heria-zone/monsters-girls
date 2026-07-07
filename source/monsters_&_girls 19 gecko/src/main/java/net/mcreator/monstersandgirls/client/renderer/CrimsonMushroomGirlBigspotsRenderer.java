
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.CrimsonMushroomGirlBigspotsModel;
import net.mcreator.monstersandgirls.entity.layer.CrimsonMushroomGirlBigspotsLayer;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGirlBigspotsEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonMushroomGirlBigspotsRenderer extends GeoEntityRenderer<CrimsonMushroomGirlBigspotsEntity> {
	public CrimsonMushroomGirlBigspotsRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CrimsonMushroomGirlBigspotsModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new CrimsonMushroomGirlBigspotsLayer(this));
	}

	@Override
	public RenderType getRenderType(CrimsonMushroomGirlBigspotsEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
