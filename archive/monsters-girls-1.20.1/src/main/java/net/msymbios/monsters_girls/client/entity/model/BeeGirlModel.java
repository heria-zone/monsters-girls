package net.msymbios.monsters_girls.client.entity.model;

import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.entity.custom.BeeGirlEntity;
import net.msymbios.monsters_girls.entity.internal.InternalAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class BeeGirlModel extends GeoModel<BeeGirlEntity> {

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
    public void setCustomAnimations(BeeGirlEntity animatable, long instanceId, AnimationState<BeeGirlEntity> event) {
        InternalAnimation.headAnimation(this, event);
    } // setCustomAnimations ()

} // Class BeeGirlModel