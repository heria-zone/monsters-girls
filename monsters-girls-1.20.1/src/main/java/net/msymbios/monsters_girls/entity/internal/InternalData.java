package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.msymbios.monsters_girls.entity.enums.InternalDataType;

import java.util.List;
import java.util.function.Predicate;

public class InternalData {

    // -- Variables --
    public InternalDataType dataType;

    // VALUES
    private float floatValue;
    private int intValue;
    private RegistryKey<Biome> biomesValue;
    private List<RegistryKey<Biome>> biomesListValue;

    private Predicate<LivingEntity> predicateEntityValue;
    private EntityType<?> entityTypeValue;

    // -- Properties --
    public float getFloatValue() {
        if(dataType == InternalDataType.Float) return this.floatValue;
        else return -1F;
    } // getFloatValue ()

    public int getIntValue() {
        if(dataType == InternalDataType.Integer) return this.intValue;
        else return -1;
    } // getIntValue ()

    public RegistryKey<Biome> getBiomesValue() {
        if(dataType == InternalDataType.Biomes) return this.biomesValue;
        else return null;
    } // getBiomesValue ()

    public List<RegistryKey<Biome>> getBiomesListValue() {
        if(dataType == InternalDataType.BiomesList) return this.biomesListValue;
        else return null;
    } // getBiomesListValue ()

    public Predicate<LivingEntity> getPredicateEntityValue() {
        if(dataType == InternalDataType.PredicateLivingEntity) return this.predicateEntityValue;
        else return null;
    } // getPredicateEntityValue ()

    public EntityType<?> getEntityTypeValue() {
        if(dataType == InternalDataType.EntityType) return this.entityTypeValue;
        else return null;
    } // getEntityTypeValue ()

    // -- Construct --
    public InternalData(float value) {
        this.dataType = InternalDataType.Float;
        this.floatValue = value;
    } // Construct InternalData ()

    public InternalData(int value) {
        this.dataType = InternalDataType.Integer;
        this.intValue = value;
    } // Construct InternalData ()

    public InternalData(RegistryKey<Biome> value) {
        this.dataType = InternalDataType.Biomes;
        this.biomesValue = value;
    } // Construct InternalData ()

    public InternalData(List<RegistryKey<Biome>> value) {
        this.dataType = InternalDataType.BiomesList;
        this.biomesListValue = value;
    } // Construct InternalData ()

    public InternalData(Predicate<LivingEntity> value) {
        this.dataType = InternalDataType.PredicateLivingEntity;
        this.predicateEntityValue = value;
    } // Construct InternalData ()

    public InternalData(EntityType<?> value) {
        this.dataType = InternalDataType.EntityType;
        this.entityTypeValue = value;
    } // Construct InternalData ()

} // Class InternalData