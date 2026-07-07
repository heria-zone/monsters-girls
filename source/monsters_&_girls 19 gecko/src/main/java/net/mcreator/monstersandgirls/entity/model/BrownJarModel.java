package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.BrownJarEntity;

public class BrownJarModel extends AnimatedGeoModel<BrownJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(BrownJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/fatmushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BrownJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/fatmushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BrownJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
