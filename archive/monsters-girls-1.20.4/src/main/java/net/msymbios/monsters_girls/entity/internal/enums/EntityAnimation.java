package net.msymbios.monsters_girls.entity.internal.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityAnimation {

    // -- Enum --

    IDLE(0, "idle"),
    WALK(1, "walk"),
    ATTACK(2, "attack"),
    INTERACT(3, "interact"),
    REST(4,"rest"),
    WAVE(5,"wave"),
    HURT(5,"hurt");

    // -- Variables --

    private static final EntityAnimation[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityAnimation::getId)).toArray(EntityAnimation[]::new);

    private final int m_id;

    private final String m_name;

    // -- Constructor --

    EntityAnimation(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor EntityAnimation ()

    // -- Methods --

    public static EntityAnimation byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityAnimation byName(String name) {
        for (EntityAnimation item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()

} // Enum EntityAnimation