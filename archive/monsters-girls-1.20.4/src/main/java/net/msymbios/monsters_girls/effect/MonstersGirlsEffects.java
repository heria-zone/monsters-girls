package net.msymbios.monsters_girls.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.msymbios.monsters_girls.common.effect.InternalEffects;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.effect.custom.*;

public class MonstersGirlsEffects extends InternalEffects {

    // -- Variables --

    public static final StatusEffect BLAZING = register(MonstersGirlsID.getId(MonstersGirlsID.BLAZING_EFFECT), new BlazingEffect(StatusEffectCategory.BENEFICIAL, -13312));
    public static final StatusEffect CHILLY = register(MonstersGirlsID.getId(MonstersGirlsID.CHILLY_EFFECT), new ChillyEffect(StatusEffectCategory.NEUTRAL, -3342337));
    public static final StatusEffect POISONOUS = register(MonstersGirlsID.getId(MonstersGirlsID.POISONOUS_EFFECT), new PoisonousEffect(StatusEffectCategory.HARMFUL, -8866045));
    public static final StatusEffect PUFFY = register(MonstersGirlsID.getId(MonstersGirlsID.PUFFY_EFFECT), new PuffyEffect(StatusEffectCategory.NEUTRAL, -433673));
    public static final StatusEffect SOUL_WANDERER_TOUCH = register(MonstersGirlsID.getId(MonstersGirlsID.SOUL_WANDERER_TOUCH_EFFECT), new SoulWanderersTouchEffect(StatusEffectCategory.BENEFICIAL, -16742494));
    public static final StatusEffect SPOOKED = register(MonstersGirlsID.getId(MonstersGirlsID.SPOOKED_EFFECT), new SpookEffect(StatusEffectCategory.HARMFUL, -5418225));

} // Class MonstersGirlsEffects