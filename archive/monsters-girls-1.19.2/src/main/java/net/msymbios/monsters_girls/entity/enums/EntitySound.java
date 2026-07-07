package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntitySound {

    // -- Enum --
    ATTACK(0, "attack"),
    DEFAULT(1, "default"),
    DEATH(2, "death"),
    HURT(3, "hurt"),
    HUFF(4, "huff"),
    LAUGH(5, "laugh"),
    PUFF(6, "puff"),
    SPECIAL(7, "special");

    // -- Variables --
    private static final EntitySound[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntitySound::getId)).toArray(EntitySound[]::new);

    private final int m_id;

    private final String m_name;

    // -- Constructor --
    EntitySound(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor EntitySound

    // -- Methods --
    public static EntitySound byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntitySound byName(String name) {
        for (EntitySound item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()
    
} // Enum EntitySound