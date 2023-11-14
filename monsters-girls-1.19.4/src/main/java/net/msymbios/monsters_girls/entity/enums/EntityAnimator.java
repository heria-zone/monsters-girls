package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityAnimator {

    // -- Enum --
    Endercaris(0, "endercaris"),
    Mandrake(1, "mandrake"),
    MandrakeFruity(2, "mandrake_fruity"),
    MandrakeFruityChorus(3, "mandrake_fruity_chorus"),
    Mushroom(4, "mushroom"),
    MushroomFat(5, "mushroom_fat"),
    MushroomInflated(6, "mushroom_inflated"),
    MushroomInkCap(7, "mushroom_ink_cap"),
    Slime(8, "slime"),
    Spook(9, "spook"),
    Wisp(10, "wisp"),
    Gourdragora(11,"gourdragora"),
    GourdragoraMini(12, "gourdragora_mini"),
    Bee(13, "bee");

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