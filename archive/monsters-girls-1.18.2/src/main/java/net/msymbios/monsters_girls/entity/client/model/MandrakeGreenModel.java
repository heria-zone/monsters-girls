package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MandrakeGreenEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MandrakeGreenModel extends AnimatedGeoModel<MandrakeGreenEntity> {

    // -- Methods --
    @Override
    public Identifier getModelLocation(MandrakeGreenEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelLocation ()

    @Override
    public Identifier getTextureLocation(MandrakeGreenEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureLocation ()

    @Override
    public Identifier getAnimationFileLocation(MandrakeGreenEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationFileLocation ()

    @Override
    public void setLivingAnimations(MandrakeGreenEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MandrakeGreenModel