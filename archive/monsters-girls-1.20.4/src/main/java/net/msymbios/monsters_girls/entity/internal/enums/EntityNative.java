package net.msymbios.monsters_girls.entity.internal.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityNative {

    // -- Enum --

    BEE(0, "bee"),
    GOURDRAGORA(1, "gourdragora"),
    MANDRAGORA(3, "mandragora"),
    MUSHROOM(4, "mushroom"),
    SLIME(5, "slime"),
    SPOOK(6, "spook"),
    WISP(7, "wisp");

    // -- Variables --

    private static final EntityNative[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityNative::getId)).toArray(EntityNative[]::new);

    private final int m_id;

    private final String m_name;

    // -- Constructor --

    EntityNative(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor RobotTexture

    // -- Methods --

    public static EntityNative byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityNative byName(String name) {
        for (EntityNative item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()

} // Enum EntityNative