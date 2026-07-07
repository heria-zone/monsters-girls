package net.msymbios.monsters_girls.entity.internal;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
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
    private Item itemValue;
    private Block blockValue;
    private StatusEffect effectValue;

    // -- Properties --
    public Object getValue() {
        return switch (dataType) {
            case Float -> floatValue;
            case Integer -> intValue;
            case Biomes -> biomesValue;
            case BiomesList -> biomesListValue;
            case PredicateLivingEntity -> predicateEntityValue;
            case EntityType -> entityTypeValue;
            case Item -> itemValue;
            case Block -> blockValue;
            case StatusEffect -> effectValue;
            default -> null;
        };
    } // getValue ()

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

    public InternalData(Item value) {
        this.dataType = InternalDataType.Item;
        this.itemValue = value;
    } // Construct InternalData ()

    public InternalData(Block value) {
        this.dataType = InternalDataType.Block;
        this.blockValue = value;
    } // Construct InternalData ()

    public InternalData(StatusEffect value) {
        this.dataType = InternalDataType.StatusEffect;
        this.effectValue = value;
    } // Construct InternalData ()

} // Class InternalData