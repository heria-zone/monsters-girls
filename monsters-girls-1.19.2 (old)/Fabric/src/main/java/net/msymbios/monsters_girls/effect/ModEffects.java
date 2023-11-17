package net.msymbios.monsters_girls.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.effect.custom.SpookEffect;

public class ModEffects {

    // -- Variables --
    public static StatusEffect SPOOKED;

    // -- Methods --
    public static StatusEffect registerEffect(String name, StatusEffect effect) {
        return net.minecraft.util.registry.Registry.register(Registry.STATUS_EFFECT, new Identifier(MonstersGirlsMod.MODID, name), effect);
    } // registerEffect ()

    public static void register() {
        SPOOKED = registerEffect("spooked", new SpookEffect(StatusEffectCategory.HARMFUL, -5418225));
    } // register ()

} // Class ModEffects