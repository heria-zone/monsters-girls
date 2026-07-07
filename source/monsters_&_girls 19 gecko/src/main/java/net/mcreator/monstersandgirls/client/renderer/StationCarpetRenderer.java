
package net.mcreator.monstersandgirls.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstersandgirls.entity.StationCarpetEntity;
import net.mcreator.monstersandgirls.client.model.ModelStation;

public class StationCarpetRenderer extends MobRenderer<StationCarpetEntity, ModelStation<StationCarpetEntity>> {
	public StationCarpetRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStation(context.bakeLayer(ModelStation.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(StationCarpetEntity entity) {
		return new ResourceLocation("monsters_and_girls:textures/entities/station.png");
	}
}
