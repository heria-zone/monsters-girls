package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityVariant {

    // -- Enum --
    AmanitaYellow(0, "amanita_yellow"),
    EnderPuffball(1, "ender_puffball"),
    EnderCaris(2, "ender_caris"),
    Boletus(3, "boletus"),
    Crimson(4, "crimson"),
    CrimsonRare(5, "crimson_rare"),
    FlyAgaric(6, "fly_agaric"),
    Infernal(7, "infernal"),
    InkCap(8, "ink_cap"),
    MandrakeBrown(9, "mandrake_brown"),
    MandrakeFruity(10, "mandrake_fruity"),
    MandrakeGreen(11, "mandrake_green"),
    Molten(12, "molten"),
    SpookTeal(13, "spook_teal"),
    SpookPeach(14, "spook_peach"),
    Warped(15, "warped"),
    WarpedRare(16, "warped_rare"),
    WispBlue(17, "wisp_blue"),
    WispGreen(18, "wisp_green"),
    WispYellow(19, "wisp_yellow"),
    SoulWanderer(20, "soul_wanderer");


    // -- Variables --
    private static final EntityVariant[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityVariant::getId)).toArray(EntityVariant[]::new);

    private final int m_id;

    private final String m_name;


    // -- Constructor --
    EntityVariant(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor VanillaVariant


    // -- Methods --
    public static EntityVariant byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityVariant byName(String name) {
        for (EntityVariant item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getId ()

} // Enum EntityVariant