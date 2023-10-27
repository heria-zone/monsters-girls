package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternMiniEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GourdragoraJackOLanternMiniModel extends GeoModel<GourdragoraJackOLanternMiniEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(GourdragoraJackOLanternMiniEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(GourdragoraJackOLanternMiniEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(GourdragoraJackOLanternMiniEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(GourdragoraJackOLanternMiniEntity animatable, long instanceId, AnimationState<GourdragoraJackOLanternMiniEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class GourdragoraJackOLanternMiniModel