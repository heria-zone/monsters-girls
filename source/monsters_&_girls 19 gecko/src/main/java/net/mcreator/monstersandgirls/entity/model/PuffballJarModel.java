package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.PuffballJarEntity;

public class PuffballJarModel extends AnimatedGeoModel<PuffballJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(PuffballJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/fatmushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PuffballJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/fatmushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PuffballJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
