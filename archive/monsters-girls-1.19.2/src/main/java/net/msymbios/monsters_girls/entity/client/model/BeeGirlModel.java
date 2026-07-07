package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.BeeGirlEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeeGirlModel extends AnimatedGeoModel<BeeGirlEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(BeeGirlEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(BeeGirlEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(BeeGirlEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setLivingAnimations(BeeGirlEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class BeeGirlModel