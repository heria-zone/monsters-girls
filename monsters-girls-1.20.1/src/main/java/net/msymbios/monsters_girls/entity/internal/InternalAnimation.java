package net.msymbios.monsters_girls.entity.internal;

import net.msymbios.monsters_girls.entity.enums.EntityAnimation;
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
    public static final RawAnimation  IDLE = RawAnimation.begin().thenLoop(EntityAnimation.Idle.getName());
    public static final RawAnimation  REST = RawAnimation.begin().thenLoop(EntityAnimation.Rest.getName());
    public static final RawAnimation  WALK = RawAnimation.begin().thenLoop(EntityAnimation.Walk.getName());
    public static final RawAnimation  WAVE = RawAnimation.begin().then (EntityAnimation.Wave.getName(), Animation.LoopType.PLAY_ONCE);
    public static final RawAnimation  ATTACK = RawAnimation.begin().then (EntityAnimation.Attack.getName(), Animation.LoopType.PLAY_ONCE);
    public static final RawAnimation HURT = RawAnimation.begin().then (EntityAnimation.Hurt.getName(), Animation.LoopType.PLAY_ONCE);

    // -- Methods --
    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> attackAnimation(T animatable) {
        return new AnimationController<>(animatable, "Attack", 5, state -> {
            if(!InternalMetric.getAnimation(animatable.category, EntityAnimation.Attack)) return PlayState.CONTINUE;
            state.getController().forceAnimationReset();
            if (animatable.handSwinging) return state.setAndContinue(ATTACK);
            return PlayState.STOP;
        });
    } // attackAnimation ()

    public static <T extends InternalEntity & GeoAnimatable> AnimationController<T> locomotionAnimation(T entity) {
        return new AnimationController<T>(entity, "Locomotion", 0, state -> {
            if (state.isMoving() && InternalMetric.getAnimation(entity.category, EntityAnimation.Walk)) return state.setAndContinue(WALK);
            else if(entity.getCurrentState() == EntityState.Sit && InternalMetric.getAnimation(entity.category, EntityAnimation.Rest)) return state.setAndContinue(REST);
            else if(InternalMetric.getAnimation(entity.category, EntityAnimation.Idle)) return state.setAndContinue(IDLE);
            else return PlayState.CONTINUE;
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