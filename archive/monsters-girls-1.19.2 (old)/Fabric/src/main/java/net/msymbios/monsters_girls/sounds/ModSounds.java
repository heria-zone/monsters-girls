package net.msymbios.monsters_girls.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;

public class ModSounds {

    // -- Variables --
    public static SoundEvent VEX_SKILL = registerSound("vexiskill");
    public static SoundEvent MUSHROOM_GIRL = registerSound("mushroomgalsound");
    public static SoundEvent MUSHROOM_GIRL_ENDER = registerSound("endermushroomgalsound");
    public static SoundEvent ENDER_PUFFBALL_HUFFS = registerSound("enderpuffballgalhuffs");
    public static SoundEvent ENDER_PUFFBALL_PUFFS = registerSound("enderpuffballgalpuffs");
    public static SoundEvent MANDRAKE_SOUND = registerSound("mandrakesounds");
    public static SoundEvent MANDRAKE_HURT = registerSound("mandrakehurt");
    public static SoundEvent MANDRAKE_DEATH = registerSound("mandrakedies");
    public static SoundEvent WISP_DEATH = registerSound("wispdeath");
    public static SoundEvent WISP_LAUGH = registerSound("wisplaughs");
    public static SoundEvent WISP_HURT = registerSound("wisphurt");
    public static SoundEvent SPOOK_ATTACK = registerSound("spookattacking");
    public static SoundEvent SPOOK_HURT = registerSound("spookhurt");
    public static SoundEvent SPOOK_LAUGH = registerSound("spooklaugh");

    // -- Methods --
    public static SoundEvent registerSound (String name){
        var soundID = new Identifier(MonstersGirlsMod.MODID, name);
        return Registry.register(Registry.SOUND_EVENT, soundID, new SoundEvent(soundID));
    } // registerSound ()

} // Class ModSounds