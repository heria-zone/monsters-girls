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
    public static SoundEvent SPOOK_HURT = register(MonstersGirlsID. SPOOK_HURT);
    public static SoundEvent SPOOK_LAUGH = register(MonstersGirlsID.SPOOK_LAUGH);

    // -- Methods --
    private static SoundEvent register(String name){
        var soundID = new Identifier(MonstersGirls.MODID, name);
        return Registry.register(Registries.SOUND_EVENT, soundID, SoundEvent.of(soundID));
    } // registerSound ()

} // Class MonstersGirlsSounds