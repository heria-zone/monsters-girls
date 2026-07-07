package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.InkCapBedEntity;

public class InkCapBedModel extends AnimatedGeoModel<InkCapBedEntity> {
	@Override
	public ResourceLocation getAnimationResource(InkCapBedEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/inkcapmushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InkCapBedEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/inkcapmushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InkCapBedEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
