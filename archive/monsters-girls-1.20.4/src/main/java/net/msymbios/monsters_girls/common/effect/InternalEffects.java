package net.msymbios.monsters_girls.common.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InternalEffects {

    // -- Methods --

    protected static StatusEffect register(Identifier name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, name, effect);
    } // register ()

} // Class InternalEffects