
package net.mcreator.monstersandgirls.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstersandgirls.entity.model.CrimsonMushroomGalModel;
import net.mcreator.monstersandgirls.entity.layer.CrimsonMushroomGalLayer;
import net.mcreator.monstersandgirls.entity.CrimsonMushroomGalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonMushroomGalRenderer extends GeoEntityRenderer<CrimsonMushroomGalEntity> {
	public CrimsonMushroomGalRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CrimsonMushroomGalModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new CrimsonMushroomGalLayer(this));
	}

	@Override
	public RenderType getRenderType(CrimsonMushroomGalEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
