package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MushroomFlyAgaricModel extends GeoModel<MushroomFlyAgaricRedEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomFlyAgaricRedEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomFlyAgaricRedEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomFlyAgaricRedEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(MushroomFlyAgaricRedEntity animatable, long instanceId, AnimationState<MushroomFlyAgaricRedEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class MushroomFlyAgaricModel