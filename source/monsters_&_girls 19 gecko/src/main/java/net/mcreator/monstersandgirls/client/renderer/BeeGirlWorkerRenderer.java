
package net.mcreator.monstersandgirls.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstersandgirls.entity.BeeGirlWorkerEntity;
import net.mcreator.monstersandgirls.client.model.ModelBeegirl;

public class BeeGirlWorkerRenderer extends MobRenderer<BeeGirlWorkerEntity, ModelBeegirl<BeeGirlWorkerEntity>> {
	public BeeGirlWorkerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBeegirl(context.bakeLayer(ModelBeegirl.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BeeGirlWorkerEntity entity) {
		return new ResourceLocation("monsters_and_girls:textures/entities/bee1.png");
	}
}
