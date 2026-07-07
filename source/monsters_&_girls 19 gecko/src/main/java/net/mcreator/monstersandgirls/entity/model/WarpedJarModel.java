package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.WarpedJarEntity;

public class WarpedJarModel extends AnimatedGeoModel<WarpedJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/size1mushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/size1mushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
