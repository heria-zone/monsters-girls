package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.GourdragoraJackOLanternMiniEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GourdragoraJackOLanternMiniModel extends AnimatedGeoModel<GourdragoraJackOLanternMiniEntity> {

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
    public void setLivingAnimations(GourdragoraJackOLanternMiniEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class GourdragoraJackOLanternMiniModel