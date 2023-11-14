package net.msymbios.monsters_girls.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.effect.MonstersGirlsEffects;

public class MonstersGirlsPotions {

    // -- Variables --
    public static Potion SPOOKED_POTION = register(MonstersGirlsID.SPOOKED_POTION, new Potion(new StatusEffectInstance(MonstersGirlsEffects.SPOOKED, 200, 1)));

    // -- Methods --
    private static Potion register(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(MonstersGirls.MODID, name), potion);
    } // registerPotion ()

    public static void register() {

    } // register ()

} // Class MonstersGirlsPotions