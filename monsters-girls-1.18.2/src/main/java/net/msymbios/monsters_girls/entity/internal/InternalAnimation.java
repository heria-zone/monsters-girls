package net.msymbios.monsters_girls.entity.internal;

import net.msymbios.monsters_girls.entity.enums.EntityAnimation;
import net.msymbios.monsters_girls.entity.enums.EntityState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public final class InternalAnimation {

    // -- Variables --
    public static final AnimationBuilder IDLE = new AnimationBuilder().addAnimation(EntityAnimation.Idle.getName(), ILoopType.EDefaultLoopTypes.LOOP);
    public static final AnimationBuilder  REST = new AnimationBuilder().addAnimation(EntityAnimation.Rest.getName(), ILoopType.EDefaultLoopTypes.LOOP);
    public static final AnimationBuilder  WALK = new AnimationBuilder().addAnimation(EntityAnimation.Walk.getName(), ILoopType.EDefaultLoopTypes.LOOP);
    public static final AnimationBuilder  WAVE = new AnimationBuilder().addAnimation (EntityAnimation.Wave.getName(), ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    public static final AnimationBuilder  ATTACK = new AnimationBuilder().addAnimation (EntityAnimation.Attack.getName(), ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    public static final AnimationBuilder HURT = new AnimationBuilder().addAnimation (EntityAnimation.Hurt.getName(), ILoopType.EDefaultLoopTypes.PLAY_ONCE);

    // -- Methods --
    public static <T extends InternalEntity & IAnimatable> AnimationController<T> attackAnimation(T animatable) {
        return new AnimationController<>(animatable, "Attack", 5, state -> {
            if(!InternalMetric.getAnimation(animatable.category, EntityAnimation.Attack)) return PlayState.CONTINUE;
            if (animatable.handSwinging) {
                state.getController().setAnimation(ATTACK);
                return PlayState.CONTINUE;
            }
            state.getController().clearAnimationCache();
            return PlayState.STOP;
        });
    } // attackAnimation ()

    public static <T extends InternalEntity & IAnimatable> AnimationController<T> locomotionAnimation(T entity) {
        return new AnimationController<T>(entity, "Locomotion", 0, state -> {
            if (state.isMoving() && InternalMetric.getAnimation(entity.category, EntityAnimation.Walk)) state.getController().setAnimation(WALK);
            else if(entity.getCurrentState() == EntityState.Sit && InternalMetric.getAnimation(entity.category, EntityAnimation.Rest)) state.getController().setAnimation(REST);
            else if(InternalMetric.getAnimation(entity.category, EntityAnimation.Idle)) state.getController().setAnimation(IDLE);
            else return PlayState.CONTINUE;
            return PlayState.CONTINUE;
        });
    } // locomotionAnimation ()

    public static void headAnimation (AnimatedGeoModel renderer, AnimationEvent event) {
        IBone head = renderer.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) event.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Utility.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Utility.PI / 180F));
        }
    } // headAnimation ()

} // Class InternalAnimation