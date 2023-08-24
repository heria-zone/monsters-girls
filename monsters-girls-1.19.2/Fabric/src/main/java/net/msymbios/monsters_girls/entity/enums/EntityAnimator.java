package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityAnimator {

    // -- Enum --
    Endercaris(0, "endercaris"),
    Mandrake(1, "mandrake"),
    Mushroom(2, "mushroom"),
    MushroomFat(3, "mushroom_fat"),
    MushroomInflated(4, "mushroom_inflated"),
    Slime(5, "slime"),
    Spook(6, "spook"),
    Wisp(7, "wisp");

    // -- Variables --
    private static final EntityAnimator[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityAnimator::getId)).toArray(EntityAnimator[]::new);

    private final int m_id;

    private final String m_name;


    // -- Constructor --
    EntityAnimator(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor EntityAnimator ()


    // -- Methods --
    public static EntityAnimator byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityAnimator byName(String name) {
        for (EntityAnimator item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()

} // Enum EntityAnimator