package net.msymbios.monsters_girls.entity.client;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlBrownEntity;
import net.msymbios.monsters_girls.entity.enums.EntityAnimator;
import net.msymbios.monsters_girls.entity.enums.EntityModel;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomGirlBrownModel extends AnimatedGeoModel<MushroomGirlBrownEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomGirlBrownEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityModel.MushroomFat.getName());
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomGirlBrownEntity animatable) {
        return animatable.getTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomGirlBrownEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityAnimator.Variant.getName());
    } // getAnimationResource ()

    @Override
    public void setLivingAnimations(MushroomGirlBrownEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomGirlBrownModel