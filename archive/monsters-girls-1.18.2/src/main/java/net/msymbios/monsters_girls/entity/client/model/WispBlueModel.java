package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.WispBlueEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WispBlueModel extends AnimatedGeoModel<WispBlueEntity> {

    // -- Methods --
    @Override
    public Identifier getModelLocation(WispBlueEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelLocation ()

    @Override
    public Identifier getTextureLocation(WispBlueEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureLocation ()

    @Override
    public Identifier getAnimationFileLocation(WispBlueEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationFileLocation ()

    @Override
    public void setLivingAnimations(WispBlueEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class WispBlueModel