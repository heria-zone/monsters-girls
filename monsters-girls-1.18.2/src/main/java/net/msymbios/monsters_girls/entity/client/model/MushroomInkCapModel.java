package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomInkCapEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomInkCapModel extends AnimatedGeoModel<MushroomInkCapEntity> {

    // -- Methods --
    @Override
    public Identifier getModelLocation(MushroomInkCapEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelLocation ()

    @Override
    public Identifier getTextureLocation(MushroomInkCapEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureLocation ()

    @Override
    public Identifier getAnimationFileLocation(MushroomInkCapEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationFileLocation ()

    @Override
    public void setLivingAnimations(MushroomInkCapEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomInkCapModel