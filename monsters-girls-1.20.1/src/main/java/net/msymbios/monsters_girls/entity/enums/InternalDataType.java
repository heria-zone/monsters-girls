package net.msymbios.monsters_girls.entity.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum InternalDataType {

    // -- Enum --
    Integer(0),
    Float(1),
    Biomes(2),
    BiomesList(3),
    EntityType(4),
    PredicateLivingEntity(5),
    Item(6),
    Block(7),
    StatusEffect(8);

    // -- Variables --
    private static final InternalDataType[] CODEC = Arrays.stream(values()).sorted(Comparator.comparingInt(InternalDataType::getId)).toArray(InternalDataType[]::new);

    private final int m_id;


    // -- Constructor --
    InternalDataType(int id) {
        this.m_id = id;
    } // Constructor InternalDataType


    // -- Methods --
    public static InternalDataType byId(int id) {
        if (id < 0 || id >= CODEC.length) id = 0;
        return CODEC[id];
    } // byId ()

    public int getId() {
        return this.m_id;
    } // getId ()

} // Enum InternalDataType