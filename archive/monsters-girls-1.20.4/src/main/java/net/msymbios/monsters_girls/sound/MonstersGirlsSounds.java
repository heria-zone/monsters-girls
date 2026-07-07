package net.msymbios.monsters_girls.sound;

import net.minecraft.sound.SoundEvent;
import net.msymbios.monsters_girls.common.sound.InternalSounds;
import net.msymbios.monsters_girls.config.MonstersGirlsID;

public class MonstersGirlsSounds extends InternalSounds {

    // -- Variables --

    public static SoundEvent SPOOK_ATTACK = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_SPOOK_ATTACK));
    public static SoundEvent SPOOK_LAUGH = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_SPOOK_LAUGH));
    public static SoundEvent SPOOK_HURT = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_SPOOK_HURT));

    public static SoundEvent WISP_DEATH = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_WISP_DEATH));
    public static SoundEvent WISP_LAUGH = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_WISP_LAUGH));
    public static SoundEvent WISP_HURT = register(MonstersGirlsID.getId(MonstersGirlsID.SOUND_WISP_HURT));

} // Class MonstersGirlsSounds