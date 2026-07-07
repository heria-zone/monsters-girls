package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum EntitySetting {

    // -- Enum --
    PredicateEntitySelector(0),
    BiomesSelector(1),
    EntityType(2),
    SpawnWeight(3),
    SpawnMinGroup(4),
    SpawnMaxGroup(5);


    // -- Variables --
    private static final EntitySetting[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(EntitySetting::getId)).toArray(EntitySetting[]::new);

    private final int m_id;


    // -- Constructor --
    EntitySetting(int id) {
        this.m_id = id;
    } // Constructor EntitySetting


    // -- Methods --
    public static EntitySetting byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

} // Enum EntitySetting