package net.msymbios.monsters_girls.common.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class InternalSounds {

    // -- Methods --

    protected static SoundEvent register(Identifier name) {
        return Registry.register(Registries.SOUND_EVENT, name, SoundEvent.of(name));
    } // register ()

} // Class InternalSounds