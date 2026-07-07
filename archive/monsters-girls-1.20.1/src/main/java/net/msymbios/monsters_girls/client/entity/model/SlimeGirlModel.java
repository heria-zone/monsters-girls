package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.SlimeGirlEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class SlimeGirlModel extends GeoModel<SlimeGirlEntity> {

    // -- Methods --
    @Override
    public Identifier getModelResource(SlimeGirlEntity animatable) {
        return animatable.getCurrentModel();
    } // getModelResource ()

    @Override
    public Identifier getTextureResource(SlimeGirlEntity animatable) {
        return animatable.getCurrentTexture();
    } // getTextureResource ()

    @Override
    public Identifier getAnimationResource(SlimeGirlEntity animatable) {
        return animatable.getAnimator();
    } // getAnimationResource ()

    @Override
    public void setCustomAnimations(SlimeGirlEntity animatable, long instanceId, AnimationState<SlimeGirlEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class SlimeGirlModel