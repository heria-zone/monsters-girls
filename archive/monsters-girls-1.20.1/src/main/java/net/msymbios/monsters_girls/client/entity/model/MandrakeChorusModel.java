package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MandrakeChorusModel extends GeoModel<MandrakeChorusEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MandrakeChorusEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MandrakeChorusEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MandrakeChorusEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(MandrakeChorusEntity animatable, long instanceId, AnimationState<MandrakeChorusEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()
} // Class MandrakeChorusModel