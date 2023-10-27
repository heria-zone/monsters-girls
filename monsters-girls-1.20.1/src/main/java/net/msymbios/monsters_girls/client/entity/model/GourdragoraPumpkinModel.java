package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.GourdragoraPumpkinEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GourdragoraPumpkinModel extends GeoModel<GourdragoraPumpkinEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(GourdragoraPumpkinEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(GourdragoraPumpkinEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(GourdragoraPumpkinEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(GourdragoraPumpkinEntity animatable, long instanceId, AnimationState<GourdragoraPumpkinEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class GourdragoraPumpkinModel