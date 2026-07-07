package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MushroomWarpedModel extends GeoModel<MushroomWarpedEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomWarpedEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomWarpedEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomWarpedEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(MushroomWarpedEntity animatable, long instanceId, AnimationState<MushroomWarpedEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class MushroomWarpedModel