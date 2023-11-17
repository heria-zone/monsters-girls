package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.item.internal.EnchantedItem;
import net.msymbios.monsters_girls.item.internal.SpawnItem;
import net.msymbios.monsters_girls.item.internal.TooltipItem;

import java.util.ArrayList;
import java.util.List;

public class MonstersGirlsItems {

    // -- Variables --
    public static final Item POWDER_GENESIS = register(MonstersGirlsID.POWDER_GENESIS, new EnchantedItem(new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP).rarity(Rarity.RARE)));

    // HAT
    public static final Item HAT_MUSHROOM_BROWN = register(MonstersGirlsID.HAT_MUSHROOM_BROWN, new ArmorItem(MonstersGirlsArmorMaterial.BROWN_MUSHROOM, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_CRIMSON = register(MonstersGirlsID.HAT_MUSHROOM_CRIMSON, new ArmorItem(MonstersGirlsArmorMaterial.CRIMSON_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_CRIMSON_RARE = register(MonstersGirlsID.HAT_MUSHROOM_CRIMSON_RARE, new ArmorItem(MonstersGirlsArmorMaterial.CRIMSON_RARE_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_ENDER_PUFFBALL = register(MonstersGirlsID.HAT_MUSHROOM_ENDER_PUFFBALL, new ArmorItem(MonstersGirlsArmorMaterial.ENDER_PUFFBALL, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_FLY_RED_AGARIC = register(MonstersGirlsID.HAT_MUSHROOM_FLY_RED_AGARIC, new ArmorItem(MonstersGirlsArmorMaterial.FLY_RED_AGARIC, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_FLY_YELLOW_AGARIC = register(MonstersGirlsID.HAT_MUSHROOM_FLY_YELLOW_AGARIC, new ArmorItem(MonstersGirlsArmorMaterial.FLY_YELLOW_AGARIC, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_INFERNAL = register(MonstersGirlsID.HAT_MUSHROOM_INFERNAL, new ArmorItem(MonstersGirlsArmorMaterial.INFERNAL_MUSHROOM_, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_INK_CAP = register(MonstersGirlsID.HAT_MUSHROOM_INK_CAP, new ArmorItem(MonstersGirlsArmorMaterial.INK_CAP_MUSHROOM, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_MOLTEN = register(MonstersGirlsID.HAT_MUSHROOM_MOLTEN, new ArmorItem(MonstersGirlsArmorMaterial.MOLTEN_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_SOUL_WANDERER = register(MonstersGirlsID.HAT_MUSHROOM_SOUL_WANDERER, new ArmorItem(MonstersGirlsArmorMaterial.SOUL_WANDERER_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_WARPED = register(MonstersGirlsID.HAT_MUSHROOM_WARPED, new ArmorItem(MonstersGirlsArmorMaterial.WARPED_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item HAT_MUSHROOM_WARPED_RARE = register(MonstersGirlsID.HAT_MUSHROOM_WARPED_RARE, new ArmorItem(MonstersGirlsArmorMaterial.WARPED_RARE_FUNGUS, EquipmentSlot.HEAD, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));

    // FOOD
    public static final Item SPECTRAL_CAKE = register(MonstersGirlsID.SPECTRAL_CAKE, new TooltipItem(new ArrayList<>(List.of("tooltip.monsters_girls.spectral_cake")), new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP).food(MonstersGirlsFoodComponent.SPECTRAL_CAKE).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item CANDIES = register(MonstersGirlsID.CANDIES, new TooltipItem(new ArrayList<>(List.of("tooltip.monsters_girls.candies")), new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP).food(MonstersGirlsFoodComponent.CANDIES).fireproof().rarity(Rarity.COMMON)));

    // SPAWN EGG
    public static final Item SPAWN_BEE_GIRL = register(MonstersGirlsID.SPAWN_BEE_GIRL, new SpawnItem(MonstersGirlsEntities.BEE_GIRL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_BIG = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_BIG, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_BIG, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_MINI = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_JACK_LANTERN_MINI, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_JACK_LANTERN_MINI, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_PUMPKIN = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_PUMPKIN, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_PUMPKIN_BIG = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_BIG, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_BIG, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_GOURDRAGORA_GIRL_PUMPKIN_MINI = register(MonstersGirlsID.SPAWN_GOURDRAGORA_GIRL_PUMPKIN_MINI, new SpawnItem(MonstersGirlsEntities.GOURDRAGORA_GIRL_PUMPKIN_MINI, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MANDRAKE_GIRL_BROWN = register(MonstersGirlsID.SPAWN_MANDRAKE_GIRL_BROWN, new SpawnItem(MonstersGirlsEntities.MANDRAKE_GIRL_BROWN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MANDRAKE_GIRL_CHORUS = register(MonstersGirlsID.SPAWN_MANDRAKE_GIRL_CHORUS, new SpawnItem(MonstersGirlsEntities.MANDRAKE_GIRL_CHORUS, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MANDRAKE_GIRL_GLOW_BERRY = register(MonstersGirlsID.SPAWN_MANDRAKE_GIRL_GLOW_BERRY, new SpawnItem(MonstersGirlsEntities.MANDRAKE_GIRL_GLOW_BERRY, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MANDRAKE_GIRL_GREEN = register(MonstersGirlsID.SPAWN_MANDRAKE_GIRL_GREEN, new SpawnItem(MonstersGirlsEntities.MANDRAKE_GIRL_GREEN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_CRIMSON = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_CRIMSON, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_CRIMSON_RARE = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_CRIMSON_RARE, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_CRIMSON_RARE, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_FLY_AGARIC_RED = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_RED, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_FLY_AGARIC, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_FLY_AGARIC_YELLOW = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_YELLOW, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_AMANITA_YELLOW, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_INK_CAP = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_INK_CAP, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_INK_CAP, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_WARPED = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_WARPED, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_WARPED, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_WARPED_RARE = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_WARPED_RARE, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_WARPED_RARE, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_BROWN = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_BROWN, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_BROWN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_ENDER_PUFFBALL = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_ENDER_PUFFBALL, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_ENDER_PUFFBALL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_INFERNAL = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_INFERNAL, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_INFERNAL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_MOLTEN = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_MOLTEN, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_MOLTEN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_SOUL_WANDERER = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_SOUL_WANDERER, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_SOUL_WANDERER, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_MUSHROOM_GIRL_SNOWBALL = register(MonstersGirlsID.SPAWN_MUSHROOM_GIRL_SNOWBALL, new SpawnItem(MonstersGirlsEntities.MUSHROOM_GIRL_SNOWBALL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_SLIME_GIRL = register(MonstersGirlsID.SPAWN_SLIME_GIRL, new SpawnItem(MonstersGirlsEntities.SLIME_GIRL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_SPOOK_GIRL_PEACH = register(MonstersGirlsID.SPAWN_SPOOK_GIRL_PEACH, new SpawnItem(MonstersGirlsEntities.SPOOK_GIRL_PEACH, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_SPOOK_GIRL_TEAL = register(MonstersGirlsID.SPAWN_SPOOK_GIRL_TEAL, new SpawnItem(MonstersGirlsEntities.SPOOK_GIRL_TEAL, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_WISP_GIRL_BLUE = register(MonstersGirlsID.SPAWN_WISP_GIRL_BLUE, new SpawnItem(MonstersGirlsEntities.WISP_GIRL_BLUE, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_WISP_GIRL_GREEN = register(MonstersGirlsID.SPAWN_WISP_GIRL_GREEN, new SpawnItem(MonstersGirlsEntities.WISP_GIRL_GREEN, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    public static final Item SPAWN_WISP_GIRL_YELLOW = register(MonstersGirlsID.SPAWN_WISP_GIRL_YELLOW, new SpawnItem(MonstersGirlsEntities.WISP_GIRL_YELLOW, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));

    // -- BlockItem --
    public static final Item INK_CAP_BLACK_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_BLACK_MUSHROOM_BLOCK, MonstersGirlsBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK);
    public static final Item INK_CAP_GREY_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_GREY_MUSHROOM_BLOCK, MonstersGirlsBlocks.INK_CAP_GREY_MUSHROOM_BLOCK);
    public static final Item INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = register(MonstersGirlsID.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK, MonstersGirlsBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

    public static final Item SHROOMLIGHT_ENDER = register(MonstersGirlsID.SHROOMLIGHT_ENDER, MonstersGirlsBlocks.SHROOMLIGHT_ENDER);
    public static final Item SHROOMLIGHT_MOLTEN = register(MonstersGirlsID.SHROOMLIGHT_MOLTEN, MonstersGirlsBlocks.SHROOMLIGHT_MOLTEN);
    public static final Item SHROOMLIGHT_SOUL = register(MonstersGirlsID.SHROOMLIGHT_SOUL, MonstersGirlsBlocks.SHROOMLIGHT_SOUL);

    public static final Item ENDER_PUFFBALL_BLOCK = register(MonstersGirlsID.ENDER_PUFFBALL_BLOCK, MonstersGirlsBlocks.ENDER_PUFFBALL_BLOCK);
    public static final Item MOLTEN_FUNGUS_BLOCK = register(MonstersGirlsID.MOLTEN_FUNGUS_BLOCK, MonstersGirlsBlocks.MOLTEN_FUNGUS_BLOCK);
    public static final Item SOUL_WANDERER_BLOCK = register(MonstersGirlsID.SOUL_WANDERER_BLOCK, MonstersGirlsBlocks.SOUL_WANDERER_BLOCK);

    public static final Item ENDER_PUFFBALL_STEM = register(MonstersGirlsID.ENDER_PUFFBALL_STEM, MonstersGirlsBlocks.ENDER_PUFFBALL_STEM);
    public static final Item MOLTEN_FUNGUS_STEM = register(MonstersGirlsID.MOLTEN_FUNGUS_STEM, MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM);
    public static final Item SOUL_WANDERER_STEM = register(MonstersGirlsID.SOUL_WANDERER_STEM, MonstersGirlsBlocks.SOUL_WANDERER_STEM);

    public static final Item ENDER_PUFFBALL_HYPHAE = register(MonstersGirlsID.ENDER_PUFFBALL_HYPHAE, MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE);
    public static final Item MOLTEN_FUNGUS_HYPHAE = register(MonstersGirlsID.MOLTEN_FUNGUS_HYPHAE, MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE);
    public static final Item SOUL_WANDERER_HYPHAE = register(MonstersGirlsID.SOUL_WANDERER_HYPHAE, MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE);

    public static final Item ENDER_PUFFBALL_STRIPPED_STEM = register(MonstersGirlsID.ENDER_PUFFBALL_STRIPPED_STEM, MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM);
    public static final Item MOLTEN_FUNGUS_STRIPPED_STEM = register(MonstersGirlsID.MOLTEN_FUNGUS_STRIPPED_STEM, MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM);
    public static final Item SOUL_WANDERER_STRIPPED_STEM = register(MonstersGirlsID.SOUL_WANDERER_STRIPPED_STEM, MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM);

    public static final Item ENDER_PUFFBALL_STRIPPED_HYPHAE = register(MonstersGirlsID.ENDER_PUFFBALL_STRIPPED_HYPHAE, MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE);
    public static final Item MOLTEN_FUNGUS_STRIPPED_HYPHAE = register(MonstersGirlsID.MOLTEN_FUNGUS_STRIPPED_HYPHAE, MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
    public static final Item SOUL_WANDERER_STRIPPED_HYPHAE = register(MonstersGirlsID.SOUL_WANDERER_STRIPPED_HYPHAE, MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE);

    public static final Item ENDER_PUFFBALL_PLANKS = register(MonstersGirlsID.ENDER_PUFFBALL_PLANKS, MonstersGirlsBlocks.ENDER_PUFFBALL_PLANKS);
    public static final Item MOLTEN_FUNGUS_PLANKS = register(MonstersGirlsID.MOLTEN_FUNGUS_PLANKS, MonstersGirlsBlocks.MOLTEN_FUNGUS_PLANKS);
    public static final Item SOUL_WANDERER_PLANKS = register(MonstersGirlsID.SOUL_WANDERER_PLANKS, MonstersGirlsBlocks.SOUL_WANDERER_PLANKS);

    public static final Item ENDER_PUFFBALL_STAIRS = register(MonstersGirlsID.ENDER_PUFFBALL_STAIRS, MonstersGirlsBlocks.ENDER_PUFFBALL_STAIRS);
    public static final Item MOLTEN_FUNGUS_STAIRS = register(MonstersGirlsID.MOLTEN_FUNGUS_STAIRS, MonstersGirlsBlocks.MOLTEN_FUNGUS_STAIRS);
    public static final Item SOUL_WANDERER_STAIRS = register(MonstersGirlsID.SOUL_WANDERER_STAIRS, MonstersGirlsBlocks.SOUL_WANDERER_STAIRS);

    public static final Item ENDER_PUFFBALL_SLAB = register(MonstersGirlsID.ENDER_PUFFBALL_SLAB, MonstersGirlsBlocks.ENDER_PUFFBALL_SLAB);
    public static final Item MOLTEN_FUNGUS_SLAB = register(MonstersGirlsID.MOLTEN_FUNGUS_SLAB, MonstersGirlsBlocks.MOLTEN_FUNGUS_SLAB);
    public static final Item SOUL_WANDERER_SLAB = register(MonstersGirlsID.SOUL_WANDERER_SLAB, MonstersGirlsBlocks.SOUL_WANDERER_SLAB);

    public static final Item ENDER_PUFFBALL_FENCE = register(MonstersGirlsID.ENDER_PUFFBALL_FENCE, MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE);
    public static final Item MOLTEN_FUNGUS_FENCE = register(MonstersGirlsID.MOLTEN_FUNGUS_FENCE, MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE);
    public static final Item SOUL_WANDERER_FENCE = register(MonstersGirlsID.SOUL_WANDERER_FENCE, MonstersGirlsBlocks.SOUL_WANDERER_FENCE);

    public static final Item ENDER_PUFFBALL_FENCE_GATE = register(MonstersGirlsID.ENDER_PUFFBALL_FENCE_GATE, MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE_GATE);
    public static final Item MOLTEN_FUNGUS_FENCE_GATE = register(MonstersGirlsID.MOLTEN_FUNGUS_FENCE_GATE, MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE_GATE);
    public static final Item SOUL_WANDERER_FENCE_GATE = register(MonstersGirlsID.SOUL_WANDERER_FENCE_GATE, MonstersGirlsBlocks.SOUL_WANDERER_FENCE_GATE);

    public static final Item ENDER_PUFFBALL_PRESSURE_PLATE = register(MonstersGirlsID.ENDER_PUFFBALL_PRESSURE_PLATE, MonstersGirlsBlocks.ENDER_PUFFBALL_PRESSURE_PLATE);
    public static final Item MOLTEN_FUNGUS_PRESSURE_PLATE = register(MonstersGirlsID.MOLTEN_FUNGUS_PRESSURE_PLATE, MonstersGirlsBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE);
    public static final Item SOUL_WANDERER_PRESSURE_PLATE = register(MonstersGirlsID.SOUL_WANDERER_PRESSURE_PLATE, MonstersGirlsBlocks.SOUL_WANDERER_PRESSURE_PLATE);

    public static final Item ENDER_PUFFBALL_BUTTON = register(MonstersGirlsID.ENDER_PUFFBALL_BUTTON, MonstersGirlsBlocks.ENDER_PUFFBALL_BUTTON);
    public static final Item MOLTEN_FUNGUS_BUTTON = register(MonstersGirlsID.MOLTEN_FUNGUS_BUTTON, MonstersGirlsBlocks.MOLTEN_FUNGUS_BUTTON);
    public static final Item SOUL_WANDERER_BUTTON = register(MonstersGirlsID.SOUL_WANDERER_BUTTON, MonstersGirlsBlocks.SOUL_WANDERER_BUTTON);

    public static final Item ENDER_PUFFBALL_DOOR = register(MonstersGirlsID.ENDER_PUFFBALL_DOOR, MonstersGirlsBlocks.ENDER_PUFFBALL_DOOR);
    public static final Item MOLTEN_FUNGUS_DOOR = register(MonstersGirlsID.MOLTEN_FUNGUS_DOOR, MonstersGirlsBlocks.MOLTEN_FUNGUS_DOOR);
    public static final Item SOUL_WANDERER_DOOR = register(MonstersGirlsID.SOUL_WANDERER_DOOR, MonstersGirlsBlocks.SOUL_WANDERER_DOOR);

    public static final Item ENDER_MOSS = register(MonstersGirlsID.ENDER_MOSS, MonstersGirlsBlocks.ENDER_MOSS);

    public static final Item ENDER_PUFFBALL_TRAPDOOR = register(MonstersGirlsID.ENDER_PUFFBALL_TRAPDOOR, MonstersGirlsBlocks.ENDER_PUFFBALL_TRAPDOOR);
    public static final Item MOLTEN_FUNGUS_TRAPDOOR = register(MonstersGirlsID.MOLTEN_FUNGUS_TRAPDOOR, MonstersGirlsBlocks.MOLTEN_FUNGUS_TRAPDOOR);
    public static final Item SOUL_WANDERER_TRAPDOOR = register(MonstersGirlsID.SOUL_WANDERER_TRAPDOOR, MonstersGirlsBlocks.SOUL_WANDERER_TRAPDOOR);

    public static final Item HUGE_BROWN_MUSHROOM = register(MonstersGirlsID.HUGE_BROWN_MUSHROOM, MonstersGirlsBlocks.HUGE_BROWN_MUSHROOM);
    public static final Item HUGE_CRIMSON_FUNGUS = register(MonstersGirlsID.HUGE_CRIMSON_FUNGUS, MonstersGirlsBlocks.HUGE_CRIMSON_FUNGUS);
    public static final Item HUGE_CRIMSON_RARE_FUNGUS = register(MonstersGirlsID.HUGE_CRIMSON_RARE_FUNGUS, MonstersGirlsBlocks.HUGE_CRIMSON_RARE_FUNGUS);
    public static final Item HUGE_ENDER_PUFFBALL = register(MonstersGirlsID.HUGE_ENDER_PUFFBALL, MonstersGirlsBlocks.HUGE_ENDER_PUFFBALL);
    public static final Item HUGE_FLY_RED_AGARIC = register(MonstersGirlsID.HUGE_FLY_RED_AGARIC, MonstersGirlsBlocks.HUGE_FLY_RED_AGARIC);
    public static final Item HUGE_FLY_YELLOW_AGARIC = register(MonstersGirlsID.HUGE_FLY_YELLOW_AGARIC, MonstersGirlsBlocks.HUGE_FLY_YELLOW_AGARIC);
    public static final Item HUGE_INFERNAL_MUSHROOM = register(MonstersGirlsID.HUGE_INFERNAL_MUSHROOM, MonstersGirlsBlocks.HUGE_INFERNAL_MUSHROOM);
    public static final Item HUGE_INK_CAP_MUSHROOM = register(MonstersGirlsID.HUGE_INK_CAP_MUSHROOM, MonstersGirlsBlocks.HUGE_INK_CAP_MUSHROOM);
    public static final Item HUGE_MOLTEN_FUNGUS = register(MonstersGirlsID.HUGE_MOLTEN_FUNGUS, MonstersGirlsBlocks.HUGE_MOLTEN_FUNGUS);
    public static final Item HUGE_SOUL_WANDERER = register(MonstersGirlsID.HUGE_SOUL_WANDERER, MonstersGirlsBlocks.HUGE_SOUL_WANDERER);
    public static final Item HUGE_WARPED_FUNGUS = register(MonstersGirlsID.HUGE_WARPED_FUNGUS, MonstersGirlsBlocks.HUGE_WARPED_FUNGUS);
    public static final Item HUGE_WARPED_RARE_FUNGUS = register(MonstersGirlsID.HUGE_WARPED_RARE_FUNGUS, MonstersGirlsBlocks.HUGE_WARPED_RARE_FUNGUS);

    public static final Item MANDRAKE_FLOWER = register(MonstersGirlsID.MANDRAKE_FLOWER, MonstersGirlsBlocks.MANDRAKE_FLOWER);
    public static final Item ENDER_PUFFBALL_MUSHROOM = register(MonstersGirlsID.ENDER_PUFFBALL_MUSHROOM, MonstersGirlsBlocks.ENDER_PUFFBALL_MUSHROOM);
    public static final Item INK_CAP_MUSHROOM = register(MonstersGirlsID.INK_CAP_MUSHROOM, MonstersGirlsBlocks.INK_CAP_MUSHROOM);
    public static final Item MOLTEN_FUNGUS = register(MonstersGirlsID.MOLTEN_FUNGUS, MonstersGirlsBlocks.MOLTEN_FUNGUS);
    public static final Item SOUL_WANDERER_FUNGUS = register(MonstersGirlsID.SOUL_WANDERER_FUNGUS, MonstersGirlsBlocks.SOUL_WANDERER_FUNGUS);

    public static final Item GLOW_BERRY_BUSH = register(MonstersGirlsID.GLOW_BERRY_BUSH, MonstersGirlsBlocks.GLOW_BERRY_BUSH);

    public static final Item JAR = register(MonstersGirlsID.JAR, MonstersGirlsBlocks.JAR);
    public static final Item URN_MOLTEN = register(MonstersGirlsID.URN_MOLTEN, MonstersGirlsBlocks.URN_MOLTEN);
    public static final Item URN_CRIMSON = register(MonstersGirlsID.URN_CRIMSON, MonstersGirlsBlocks.URN_CRIMSON);

    // -- Methods --
    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirls.MODID, name), item);
    } // register ()

    private static Item register(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirls.MODID, name), new BlockItem(block, new FabricItemSettings().group(MonstersGirlsItemsGroup.DEFAULT_GROUP)));
    } // register

    public static void register() {
        MonstersGirls.LOGGER.debug("Registering Items for: " + MonstersGirls.MODID);
    } // generate ()

} // Class MonstersGirlsItems