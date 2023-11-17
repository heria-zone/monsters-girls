package net.msymbios.monsters_girls.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.effect.ModEffects;

public class ModPotions {

    // -- Variables --
    public static Potion SPOOKED_POTION;

    // -- Methods --
    public static Potion registerPotion(String name, Potion potion) {
        return net.minecraft.util.registry.Registry.register(Registry.POTION, new Identifier(MonstersGirlsMod.MODID, name), potion);
    } // registerPotion ()

    public static void register() {
        SPOOKED_POTION = registerPotion("spooked_potion", new Potion(new StatusEffectInstance(ModEffects.SPOOKED, 200, 1)));
    } // register ()

} // Class ModPotions