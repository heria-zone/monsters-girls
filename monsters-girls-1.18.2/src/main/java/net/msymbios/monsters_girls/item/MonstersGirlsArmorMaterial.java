package net.msymbios.monsters_girls.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.Util;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.config.MonstersGirlsID;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum MonstersGirlsArmorMaterial implements ArmorMaterial {

    // -- Enum --
    BROWN_MUSHROOM(MonstersGirlsID.HAT_MUSHROOM_BROWN, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.BROWN_MUSHROOM, MonstersGirlsBlocks.HUGE_BROWN_MUSHROOM)),
    CRIMSON_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_CRIMSON, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.CRIMSON_FUNGUS)),
    CRIMSON_RARE_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_CRIMSON_RARE, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.CRIMSON_FUNGUS)),
    ENDER_PUFFBALL(MonstersGirlsID.HAT_MUSHROOM_ENDER_PUFFBALL, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsItems.ENDER_PUFFBALL_MUSHROOM, MonstersGirlsBlocks.HUGE_ENDER_PUFFBALL)),
    FLY_RED_AGARIC(MonstersGirlsID.HAT_MUSHROOM_FLY_RED_AGARIC, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.RED_MUSHROOM, MonstersGirlsBlocks.HUGE_FLY_RED_AGARIC)),
    FLY_YELLOW_AGARIC(MonstersGirlsID.HAT_MUSHROOM_FLY_YELLOW_AGARIC, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsBlocks.HUGE_FLY_YELLOW_AGARIC)),
    INFERNAL_MUSHROOM_(MonstersGirlsID.HAT_MUSHROOM_INFERNAL, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsBlocks.HUGE_INFERNAL_MUSHROOM)),
    INK_CAP_MUSHROOM(MonstersGirlsID.HAT_MUSHROOM_INK_CAP, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsBlocks.HUGE_INK_CAP_MUSHROOM)),
    MOLTEN_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_MOLTEN, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsBlocks.HUGE_MOLTEN_FUNGUS)),
    SOUL_WANDERER_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_SOUL_WANDERER, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(MonstersGirlsBlocks.HUGE_SOUL_WANDERER)),
    WARPED_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_WARPED, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.WARPED_FUNGUS, MonstersGirlsBlocks.HUGE_WARPED_FUNGUS)),
    WARPED_RARE_FUNGUS(MonstersGirlsID.HAT_MUSHROOM_WARPED_RARE, 16, (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> map.put(EquipmentSlot.HEAD, 2)), 28, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.WARPED_FUNGUS, MonstersGirlsBlocks.HUGE_WARPED_FUNGUS));

    // -- Variables --
    private static final EnumMap BASE_DURABILITY = (EnumMap) Util.make(new EnumMap(EquipmentSlot.class), (map) -> {
        map.put(EquipmentSlot.HEAD, 13);
        map.put(EquipmentSlot.CHEST, 15);
        map.put(EquipmentSlot.LEGS, 16);
        map.put(EquipmentSlot.FEET, 11);
    });
    private final String name;
    private final EnumMap<EquipmentSlot, Integer> protectionAmounts;
    private final int durabilityMultiplier, enchantability;
    private final float toughness, knockbackResistance;
    private final SoundEvent equipSound;
    private final Lazy<Ingredient> repairIngredientSupplier;

    // -- Constructor --
    MonstersGirlsArmorMaterial(String name, int durabilityMultiplier, EnumMap<EquipmentSlot, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    } // Constructor MonstersGirlsArmorMaterial

    // -- Inherited Methods --

    @Override
    public int getDurability(EquipmentSlot slot) {
        return (Integer) BASE_DURABILITY.get(slot) * this.durabilityMultiplier;
    } // getDurability ()

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts.get(slot);
    } // getProtectionAmount ()

    @Override
    public int getEnchantability() {return this.enchantability;} // getEnchantability ()

    @Override
    public SoundEvent getEquipSound() {return this.equipSound;} // getEquipSound ()

    @Override
    public Ingredient getRepairIngredient() {return this.repairIngredientSupplier.get();} // getRepairIngredient ()

    @Override
    public String getName() {return this.name;} // getName ()

    @Override
    public float getToughness() {return this.toughness;} // getToughness ()

    @Override
    public float getKnockbackResistance() {return this.knockbackResistance;} // getKnockbackResistance ()

} // Class MonstersGirlsArmorMaterial