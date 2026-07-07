
package net.mcreator.monstersandgirls.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.monstersandgirls.entity.FruityMandrakeEntity;
import net.mcreator.monstersandgirls.client.model.ModelfruityMandrake;

public class FruityMandrakeRenderer extends MobRenderer<FruityMandrakeEntity, ModelfruityMandrake<FruityMandrakeEntity>> {
	public FruityMandrakeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelfruityMandrake(context.bakeLayer(ModelfruityMandrake.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<FruityMandrakeEntity, ModelfruityMandrake<FruityMandrakeEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("monsters_and_girls:textures/entities/mandrake_fruiting_emissive.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FruityMandrakeEntity entity) {
		return new ResourceLocation("monsters_and_girls:textures/entities/mandrake_fruiting.png");
	}
}
