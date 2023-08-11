package net.msymbios.monsters_girls.entity.client;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlSoulWandererEntity;
import net.msymbios.monsters_girls.entity.enums.EntityAnimator;
import net.msymbios.monsters_girls.entity.enums.EntityModel;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomGirlSoulWandererModel extends AnimatedGeoModel<MushroomGirlSoulWandererEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomGirlSoulWandererEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityModel.Mushroom.getName());
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomGirlSoulWandererEntity animatable) {
        return animatable.getTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomGirlSoulWandererEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityAnimator.Variant.getName());
    } // getAnimationResource ()

    @Override
    public void setLivingAnimations(MushroomGirlSoulWandererEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomGirlSoulWandererModel