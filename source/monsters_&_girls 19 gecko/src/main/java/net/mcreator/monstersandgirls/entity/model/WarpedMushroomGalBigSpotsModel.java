package net.mcreator.monstersandgirls.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.monstersandgirls.entity.WarpedMushroomGalBigSpotsEntity;

public class WarpedMushroomGalBigSpotsModel extends AnimatedGeoModel<WarpedMushroomGalBigSpotsEntity> {
	@Override
	public ResourceLocation getAnimationResource(WarpedMushroomGalBigSpotsEntity entity) {
		return new ResourceLocation("monsters_and_girls", "animations/mushroomgirl.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarpedMushroomGalBigSpotsEntity entity) {
		return new ResourceLocation("monsters_and_girls", "geo/mushroomgirl.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarpedMushroomGalBigSpotsEntity entity) {
		return new ResourceLocation("monsters_and_girls", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(WarpedMushroomGalBigSpotsEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head3");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
