package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityCategory {

    // -- Enum --
    Endercaris(0, "endercaris"),
    Mandrake(1, "mandrake"),
    Mushroom(2, "mushroom"),
    Slime(3, "slime"),
    Spook(4, "spook"),
    Wisp(5, "wisp"),
    Gourdragora(6, "gourdragora"),
    Bee(7, "bee");

    // -- Variables --
    private static final EntityCategory[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityCategory::getId)).toArray(EntityCategory[]::new);

    private final int m_id;

    private final String m_name;


    // -- Constructor --
    EntityCategory(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor EntityCategory


    // -- Methods --
    public static EntityCategory byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityCategory byName(String name) {
        for (EntityCategory item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()

} // Enum EntityCategory