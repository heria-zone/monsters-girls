package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.*;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MushroomBrownModel extends GeoModel<MushroomBrownEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(MushroomBrownEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(MushroomBrownEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(MushroomBrownEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(MushroomBrownEntity animatable, long instanceId, AnimationState<MushroomBrownEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class MushroomBrownModel