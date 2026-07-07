package net.msymbios.monsters_girls.entity.client.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.MushroomCrimsonRareEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomCrimsonRareModel extends AnimatedGeoModel<MushroomCrimsonRareEntity> {

    // -- Methods --
    @Override
    public Identifier getModelLocation(MushroomCrimsonRareEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelLocation ()

    @Override
    public Identifier getTextureLocation(MushroomCrimsonRareEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureLocation ()

    @Override
    public Identifier getAnimationFileLocation(MushroomCrimsonRareEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationFileLocation ()

    @Override
    public void setLivingAnimations(MushroomCrimsonRareEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomCrimsonRareModel