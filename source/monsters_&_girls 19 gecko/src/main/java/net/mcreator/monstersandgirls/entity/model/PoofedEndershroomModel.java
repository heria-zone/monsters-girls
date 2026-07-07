package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.PoofedEndershroomEntity;

public class PoofedEndershroomModel extends AnimatedGeoModel<PoofedEndershroomEntity> {
	@Override
	public ResourceLocation getAnimationResource(PoofedEndershroomEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/puffedpuffballgirl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PoofedEndershroomEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/puffedpuffballgirl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PoofedEndershroomEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
