package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.GourdragoraPumpkinMiniEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GourdragoraPumpkinMiniModel extends GeoModel<GourdragoraPumpkinMiniEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(GourdragoraPumpkinMiniEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(GourdragoraPumpkinMiniEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(GourdragoraPumpkinMiniEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(GourdragoraPumpkinMiniEntity animatable, long instanceId, AnimationState<GourdragoraPumpkinMiniEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class GourdragoraPumpkinMiniModel