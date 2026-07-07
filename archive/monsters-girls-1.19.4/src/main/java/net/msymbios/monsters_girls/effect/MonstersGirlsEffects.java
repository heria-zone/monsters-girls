package net.msymbios.monsters_girls.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.effect.custom.SpookEffect;

public class MonstersGirlsEffects {

    // -- Variables --
    public static StatusEffect SPOOKED = register(MonstersGirlsID.SPOOKED, new SpookEffect(StatusEffectCategory.HARMFUL, -5418225));

    // -- Methods --
    private static StatusEffect register(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MonstersGirls.MODID, name), effect);
    } // registerEffect ()

    public static void register() {
        //SPOOKED = registerEffect("spooked", new SpookEffect(StatusEffectCategory.HARMFUL, -5418225));
    } // register ()

} // Class MonstersGirlsEffects