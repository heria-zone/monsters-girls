package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MushroomSoulWandererModel extends GeoModel<MushroomSoulWandererEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomSoulWandererEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomSoulWandererEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomSoulWandererEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(MushroomSoulWandererEntity animatable, long instanceId, AnimationState<MushroomSoulWandererEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class MushroomSoulWandererModel