package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeBrownEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MandrakeBrownModel extends AnimatedGeoModel<MandrakeBrownEntity> {

    // -- Methods --
    @Override
    public Identifier getModelLocation(MandrakeBrownEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelLocation ()

    @Override
    public Identifier getTextureLocation(MandrakeBrownEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureLocation ()

    @Override
    public Identifier getAnimationFileLocation(MandrakeBrownEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationFileLocation ()

    @Override
    public void setLivingAnimations(MandrakeBrownEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MandrakeBrownModel