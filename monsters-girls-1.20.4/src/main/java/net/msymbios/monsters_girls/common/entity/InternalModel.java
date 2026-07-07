package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public abstract class InternalModel<T extends InternalEntity & GeoEntity> extends GeoModel<T> {

    // -- Methods --

    @Override
    public Identifier getModelResource(T animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(T animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(T animatable) {
        return animatable.getCurrentAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class InternalModel