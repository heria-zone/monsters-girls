package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.InfernalJarEntity;

public class InfernalJarModel extends AnimatedGeoModel<InfernalJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(InfernalJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/fatmushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InfernalJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/fatmushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InfernalJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
