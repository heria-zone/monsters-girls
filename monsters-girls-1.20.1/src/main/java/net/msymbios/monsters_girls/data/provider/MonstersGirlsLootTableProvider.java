package net.msymbios.monsters_girls.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.msymbios.monsters_girls.block.MonstersGirlsBlocks;

public class MonstersGirlsLootTableProvider  extends FabricBlockLootTableProvider {

    // -- Constructor --
    public MonstersGirlsLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    } // Constructor MonstersGirlsLootTableProvider ()

    // -- Inherited Method --
    @Override
    public void generate() {
        // SHROOMLIGHT
        addDrop(MonstersGirlsBlocks.SHROOMLIGHT_ENDER);
        addDrop(MonstersGirlsBlocks.SHROOMLIGHT_MOLTEN);
        addDrop(MonstersGirlsBlocks.SHROOMLIGHT_SOUL);

        addDropWithSilkTouch(MonstersGirlsBlocks.INK_CAP_BLACK_MUSHROOM_BLOCK);
        addDropWithSilkTouch(MonstersGirlsBlocks.INK_CAP_GREY_MUSHROOM_BLOCK);
        addDropWithSilkTouch(MonstersGirlsBlocks.INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK);

        addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_PUFFBALL_STEM);
        addDropWithSilkTouch(MonstersGirlsBlocks.MOLTEN_FUNGUS_STEM);
        addDropWithSilkTouch(MonstersGirlsBlocks.SOUL_WANDERER_STEM);

        addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_PUFFBALL_HYPHAE);
        addDropWithSilkTouch(MonstersGirlsBlocks.MOLTEN_FUNGUS_HYPHAE);
        addDropWithSilkTouch(MonstersGirlsBlocks.SOUL_WANDERER_HYPHAE);

        addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_STEM);
        addDropWithSilkTouch(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_STEM);
        addDropWithSilkTouch(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_STEM);

        addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_PUFFBALL_STRIPPED_HYPHAE);
        addDropWithSilkTouch(MonstersGirlsBlocks.MOLTEN_FUNGUS_STRIPPED_HYPHAE);
        addDropWithSilkTouch(MonstersGirlsBlocks.SOUL_WANDERER_STRIPPED_HYPHAE);

        addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_PUFFBALL_BLOCK);
        addDropWithSilkTouch(MonstersGirlsBlocks.MOLTEN_FUNGUS_BLOCK);
        addDropWithSilkTouch(MonstersGirlsBlocks.SOUL_WANDERER_BLOCK);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_PLANKS);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_PLANKS);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_PLANKS);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_STAIRS);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_STAIRS);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_STAIRS);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_SLAB);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_SLAB);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_SLAB);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_FENCE);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_FENCE_GATE);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_FENCE_GATE);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_FENCE_GATE);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_PRESSURE_PLATE);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_PRESSURE_PLATE);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_PRESSURE_PLATE);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_BUTTON);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_BUTTON);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_BUTTON);

        doorDrops(MonstersGirlsBlocks.ENDER_PUFFBALL_DOOR);
        doorDrops(MonstersGirlsBlocks.MOLTEN_FUNGUS_DOOR);
        doorDrops(MonstersGirlsBlocks.SOUL_WANDERER_DOOR);

        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_TRAPDOOR);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS_TRAPDOOR);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_TRAPDOOR);

        addDrop(MonstersGirlsBlocks.HUGE_BROWN_MUSHROOM);
        addDrop(MonstersGirlsBlocks.HUGE_CRIMSON_FUNGUS);
        addDrop(MonstersGirlsBlocks.HUGE_CRIMSON_RARE_FUNGUS);
        addDrop(MonstersGirlsBlocks.HUGE_ENDER_PUFFBALL);
        addDrop(MonstersGirlsBlocks.HUGE_FLY_RED_AGARIC);
        addDrop(MonstersGirlsBlocks.HUGE_FLY_YELLOW_AGARIC);
        addDrop(MonstersGirlsBlocks.HUGE_INFERNAL_MUSHROOM);
        addDrop(MonstersGirlsBlocks.HUGE_INK_CAP_MUSHROOM);
        addDrop(MonstersGirlsBlocks.HUGE_MOLTEN_FUNGUS);
        addDrop(MonstersGirlsBlocks.HUGE_SOUL_WANDERER);
        addDrop(MonstersGirlsBlocks.HUGE_WARPED_FUNGUS);
        addDrop(MonstersGirlsBlocks.HUGE_WARPED_RARE_FUNGUS);

        addDrop(MonstersGirlsBlocks.MANDRAKE_FLOWER);
        addDrop(MonstersGirlsBlocks.ENDER_PUFFBALL_MUSHROOM);
        addDrop(MonstersGirlsBlocks.INK_CAP_MUSHROOM);
        addDrop(MonstersGirlsBlocks.MOLTEN_FUNGUS);
        addDrop(MonstersGirlsBlocks.SOUL_WANDERER_FUNGUS);

        //addDropWithSilkTouch(MonstersGirlsBlocks.ENDER_MOSS);
        addDrop(MonstersGirlsBlocks.GLOW_BERRY_BUSH);
        addDrop(MonstersGirlsBlocks.JAR);

        //addDrop(MonstersGirlsBlocks.URN_MOLTEN, copperLikeOreDrops(MonstersGirlsBlocks.URN_MOLTEN, MonstersGirlsItems.SALT));
        //addDrop(MonstersGirlsBlocks.URN_CRIMSON, copperLikeOreDrops(MonstersGirlsBlocks.URN_CRIMSON, MonstersGirlsItems.SALT));
    } // generate ()

    // -- Methods --

} // Class MonstersGirlsLootTableProvider