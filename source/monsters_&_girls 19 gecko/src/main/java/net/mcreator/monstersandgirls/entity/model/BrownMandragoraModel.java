package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstersandgirls.entity.BrownMandragoraEntity;

public class BrownMandragoraModel extends AnimatedGeoModel<BrownMandragoraEntity> {
	@Override
	public ResourceLocation getAnimationResource(BrownMandragoraEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/mandrake.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BrownMandragoraEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/mandrake.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BrownMandragoraEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

}
