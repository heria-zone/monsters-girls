package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternBigEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GourdragoraJackOLanternBigModel extends GeoModel<GourdragoraJackOLanternBigEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(GourdragoraJackOLanternBigEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(GourdragoraJackOLanternBigEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(GourdragoraJackOLanternBigEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(GourdragoraJackOLanternBigEntity animatable, long instanceId, AnimationState<GourdragoraJackOLanternBigEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class GourdragoraJackOLanternBigModel