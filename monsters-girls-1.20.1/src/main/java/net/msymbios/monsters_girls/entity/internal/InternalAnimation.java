package net.msymbios.monsters_girls.entity.internal;

import net.msymbios.monsters_girls.entity.enums.EntityState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public final class InternalAnimation {

    // -- Variables --
    public static final RawAnimation  IDLE = RawAnimation.begin().thenLoop("idle");
    public static final RawAnimation  REST = RawAnimation.begin().thenLoop("rest");
    public static final RawAnimation  WALK = RawAnimation.begin().thenLoop("walk");
    public static final RawAnimation  WAVE = RawAnimation.begin().then ("wave", Animation.LoopType.PLAY_ONCE);
    public static final RawAnimation  ATTACK = RawAnimation.begin().then ("attack", Animation.LoopType.PLAY_ONCE);
    public static final RawAnimation HURT = RawAnimation.begin().then ("hurt", Animation.LoopType.PLAY_ONCE);

    // -- Methods --
    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> attackAnimation(T animatable) {
        return new AnimationController<>(animatable, "Attack", 5, state -> {
            if (animatable.handSwinging) return state.setAndContinue(ATTACK);
            state.getController().forceAnimationReset();
            return PlayState.STOP;
        });
    } // attackAnimation ()

    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> locomotionAnimation(T entity) {
        return new AnimationController<T>(entity, "Locomotion", 0, state -> {
            if (state.isMoving()) return state.setAndContinue(WALK);
            else if(entity.getCurrentState() == EntityState.Sit) return state.setAndContinue(REST);
            else return state.setAndContinue(IDLE);
        });
    } // locomotionAnimation ()

    public static <T extends InternalEntity & GeoAnimatable> void headAnimation(GeoModel renderer, AnimationState<T> event) {
        CoreGeoBone head = renderer.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = event.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * ((float) Utility.PI / 180F));
            head.setRotY(entityData.netHeadYaw() * ((float) Utility.PI / 180F));
        }
    } // headAnimation ()

} // Class InternalAnimation