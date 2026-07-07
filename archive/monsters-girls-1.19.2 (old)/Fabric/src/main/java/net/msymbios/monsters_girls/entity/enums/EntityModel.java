package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntityModel {

    // -- Enum --
    Mandrake(0, "mandrake"),
    MandrakeFruit(1, "mandrake_fruit"),
    MandrakeFruitChorus(2, "mandrake_fruit_chorus"),
    Mushroom(3, "mushroom"),
    MushroomFat(4, "mushroom_fat"),
    MushroomFungus(5, "mushroom_fungus"),
    MushroomInflated(6, "mushroom_fungus_inflated"),
    Spook(7, "spook"),
    Wisp(8, "wisp");

    // -- Variables --
    private static final EntityModel[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntityModel::getId)).toArray(EntityModel[]::new);

    private final int m_id;

    private final String m_name;


    // -- Constructor --
    EntityModel(int id, String name) {
        this.m_id = id;
        this.m_name = name;
    } // Constructor RobotModel


    // -- Methods --
    public static EntityModel byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

    public static EntityModel byName(String name) {
        for (EntityModel item : CODEC) {
            if (item.getName().equals(name))
                return item;
        }
        return null; // or throw an exception if the name is not found
    } // byName ()

    public String getName() {
        return this.m_name;
    } // getName ()

} // Enum EntityModel