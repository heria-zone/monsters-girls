package net.msymbios.monsters_girls.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.config.MonstersGirlsID;

public class MonstersGirlsSounds {

    // -- Variables --
    public static SoundEvent VEX_SKILL = register(MonstersGirlsID.VEX_SKILL);
    public static SoundEvent MUSHROOM_GIRL = register(MonstersGirlsID.MUSHROOM_GIRL);
    public static SoundEvent MUSHROOM_GIRL_ENDER = register(MonstersGirlsID.MUSHROOM_GIRL_ENDER);
    public static SoundEvent ENDER_PUFFBALL_HUFFS = register(MonstersGirlsID.ENDER_PUFFBALL_HUFFS);
    public static SoundEvent ENDER_PUFFBALL_PUFFS = register(MonstersGirlsID.ENDER_PUFFBALL_PUFFS);
    public static SoundEvent MANDRAKE_SOUND = register(MonstersGirlsID.MANDRAKE_SOUND);
    public static SoundEvent MANDRAKE_HURT = register(MonstersGirlsID.MANDRAKE_HURT);
    public static SoundEvent MANDRAKE_DEATH = register(MonstersGirlsID.MANDRAKE_DEATH);
    public static SoundEvent WISP_DEATH = register(MonstersGirlsID.WISP_DEATH);
    public static SoundEvent WISP_LAUGH = register(MonstersGirlsID.WISP_LAUGH);
    public static SoundEvent WISP_HURT = register(MonstersGirlsID.WISP_HURT);
    public static SoundEvent SPOOK_ATTACK = register(MonstersGirlsID.SPOOK_ATTACK);
    public static SoundEvent SPOOK_HURT = register(MonstersGirlsID.SPOOK_HURT);
    public static SoundEvent SPOOK_LAUGH = register(MonstersGirlsID.SPOOK_LAUGH);
    public static SoundEvent MUSHROOM_GIRL_SOUNDS = register(MonstersGirlsID.MUSHROOM_GIRL_SOUNDS);
    public static SoundEvent MUSHROOM_GIRL_HI = register(MonstersGirlsID.MUSHROOM_GIRL_HI);
    public static SoundEvent SLIME_GIRL_SOUNDS = register(MonstersGirlsID.SLIME_GIRL_SOUNDS);
    public static SoundEvent SLIME_GIRL_HOP = register(MonstersGirlsID.SLIME_GIRL_HOP);
    public static SoundEvent SLIME_GIRL_HURT = register(MonstersGirlsID.SLIME_GIRL_HURT);
    public static SoundEvent MUSHROOM_GIRL_WEIRD_HI = register(MonstersGirlsID.MUSHROOM_GIRL_WEIRD_HI);
    public static SoundEvent MUSHROOM_GIRL_WEIRD_SOUNDS = register(MonstersGirlsID.MUSHROOM_GIRL_WEIRD_SOUNDS);
    public static SoundEvent GOURDRAGORA_ROAR = register(MonstersGirlsID.GOURDRAGORA_ROAR);
    public static SoundEvent GOURDRAGORA_GIGGLES = register(MonstersGirlsID.GOURDRAGORA_GIGGLES);
    public static SoundEvent GOURDRAGORA_MINI_GIGGLES = register(MonstersGirlsID.GOURDRAGORA_MINI_GIGGLES);

    // -- Methods --
    private static SoundEvent register(String name){
        var soundID = new Identifier(MonstersGirls.MODID, name);
        return Registry.register(Registries.SOUND_EVENT, soundID, SoundEvent.of(soundID));
    } // register ()

} // Class MonstersGirlsSounds