package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityVariant {

    // -- Enum --
    MushroomAmanitaYellow(0, "mushroom_amanita_yellow"),
    MushroomEnderPuffball(1, "mushroom_ender_puffball"),
    EnderCaris(2, "ender_caris"),
    MushroomBrown(3, "mushroom_brown"),
    MushroomCrimson(4, "mushroom_crimson"),
    MushroomCrimsonRare(5, "mushroom_crimson_rare"),
    MushroomFlyAgaric(6, "mushroom_fly_agaric"),
    MushroomInfernal(7, "mushroom_infernal"),
    FungusInkCap(8, "fungus_ink_cap"),
    MandrakeBrown(9, "mandrake_brown"),
    MandrakeGlowBerry(10, "mandrake_glow_berry"),
    MandrakeGreen(11, "mandrake_green"),
    MandrakeChorus(10, "mandrake_chorus"),
    MushroomMolten(12, "mushroom_molten"),
    MushroomSnowball(13, "mushroom_snowball"),
    SpookTeal(14, "spook_teal"),
    SpookPeach(15, "spook_peach"),
    MushroomWarped(16, "mushroom_warped"),
    MushroomWarpedRare(76, "mushroom_warped_rare"),
    WispBlue(18, "wisp_blue"),
    WispGreen(19, "wisp_green"),
    WispYellow(20, "wisp_yellow"),
    MushroomSoulWanderer(21, "mushroom_soul_wanderer");

    // -- Variables --
    private static final EntityVariant[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityVariant::getId)).toArray(EntityVariant[]::new);

    private final int m_id;

    private final String m_name;


    // -- Constructor --
    EntityVariant(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor EntityVariant


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