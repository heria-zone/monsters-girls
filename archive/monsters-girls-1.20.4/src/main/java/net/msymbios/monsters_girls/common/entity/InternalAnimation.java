package net.msymbios.monsters_girls.common.entity;

import net.msymbios.monsters_girls.entity.internal.enums.EntityAnimation;
import net.msymbios.monsters_girls.entity.internal.enums.EntityState;
import net.msymbios.monsters_girls.common.util.internal.Utility;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public final class InternalAnimation {

    // -- Methods --

    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> attackAnimation(T animatable) {
        return new AnimationController<>(animatable, "Attack", 5, state -> {
            if(!animatable.nativeEntity.checkAnimation(EntityAnimation.ATTACK)) return PlayState.CONTINUE;
            state.getController().forceAnimationReset();
            if (animatable.handSwinging) return state.setAndContinue(animatable.nativeEntity.getAnimation(EntityAnimation.ATTACK));
            return PlayState.STOP;
        });
    } // attackAnimation ()

    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> locomotionAnimation(T entity) {
        return new AnimationController<T>(entity, "Locomotion", 0, state -> {
            if (state.isMoving() && entity.nativeEntity.checkAnimation(EntityAnimation.WALK)) return state.setAndContinue(entity.nativeEntity.getAnimation(EntityAnimation.WALK));
            else if(entity.getCurrentState() == EntityState.REST && entity.nativeEntity.checkAnimation(EntityAnimation.REST)) return state.setAndContinue(entity.nativeEntity.getAnimation(EntityAnimation.REST));
            else if(entity.nativeEntity.checkAnimation(EntityAnimation.IDLE)) return state.setAndContinue(entity.nativeEntity.getAnimation(EntityAnimation.IDLE));
            else return PlayState.CONTINUE;
        });
    } // locomotionAnimation ()

    public static <T extends InternalEntity & GeoAnimatable> void headAnimation(GeoModel renderer, AnimationState<T> event) {
        CoreGeoBone head = renderer.getAnimationProcessor().getBone("head2");
        if (head != null) {
            EntityModelData entityData = event.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * ((float) Utility.PI / 180F));
            head.setRotY(entityData.netHeadYaw() * ((float) Utility.PI / 180F));
        }
    } // headAnimation ()

} // Class InternalAnimation