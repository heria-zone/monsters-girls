package net.msymbios.monsters_girls.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomAmanitaYellowEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomAmanitaYellowModel extends AnimatedGeoModel<MushroomAmanitaYellowEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomAmanitaYellowEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomAmanitaYellowEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomAmanitaYellowEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setLivingAnimations(MushroomAmanitaYellowEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomAmanitaYellowModel