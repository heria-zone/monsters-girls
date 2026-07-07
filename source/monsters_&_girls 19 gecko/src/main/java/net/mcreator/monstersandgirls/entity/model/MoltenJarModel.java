package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.MoltenJarEntity;

public class MoltenJarModel extends AnimatedGeoModel<MoltenJarEntity> {
	@Override
	public ResourceLocation getAnimationResource(MoltenJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/fatmushroombed.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MoltenJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/fatmushroombed.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MoltenJarEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
