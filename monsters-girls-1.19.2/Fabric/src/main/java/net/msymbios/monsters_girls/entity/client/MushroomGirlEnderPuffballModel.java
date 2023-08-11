package net.msymbios.monsters_girls.entity.client;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.entity.custom.MushroomGirlEnderPuffballEntity;
import net.msymbios.monsters_girls.entity.enums.EntityAnimator;
import net.msymbios.monsters_girls.entity.enums.EntityModel;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomGirlEnderPuffballModel extends AnimatedGeoModel<MushroomGirlEnderPuffballEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomGirlEnderPuffballEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityModel.MushroomFat.getName());
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomGirlEnderPuffballEntity animatable) {
        return animatable.getTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomGirlEnderPuffballEntity animatable) {
        return new Identifier(MonstersGirlsMod.MODID, EntityAnimator.Variant.getName());
    } // getAnimationResource ()

    @Override
    public void setLivingAnimations(MushroomGirlEnderPuffballEntity animatable, Integer uniqueID, AnimationEvent event){
        super.setLivingAnimations(animatable, uniqueID, event);
        InternalAnimation.headAnimation(this, event);
    } // setLivingAnimations ()

} // Class MushroomGirlEnderPuffballModel