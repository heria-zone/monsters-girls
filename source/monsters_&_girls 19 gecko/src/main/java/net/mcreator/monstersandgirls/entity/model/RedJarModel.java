package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.RedJarEntity;

public class RedJarModel extends AnimatedGeoModel<RedJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/size1mushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/size1mushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
