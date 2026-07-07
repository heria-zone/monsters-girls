package net.msymbios.monsters_girls.common.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InternalPotion {

    // -- Methods --

    protected static Potion register(Identifier name, Potion potion) {
        return Registry.register(Registries.POTION, name, potion);
    } // register ()

    protected static Potion register(Identifier name, StatusEffect effect, int duration, int amplifier) {
        return register(name, new Potion(new StatusEffectInstance((StatusEffect) Registries.STATUS_EFFECT.getEntry(effect), duration, amplifier)));
    } // register ()

} // Class InternalPotion