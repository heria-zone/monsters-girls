package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Rarity;
import net.msymbios.monsters_girls.MonstersGirls;
import net.msymbios.monsters_girls.common.item.InternalItems;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.entity.MonstersGirlsEntities;
import net.msymbios.monsters_girls.common.item.custom.EnchantedItem;
import net.msymbios.monsters_girls.common.item.custom.SpawnItem;
import net.msymbios.monsters_girls.common.item.custom.TooltipItem;

import java.util.ArrayList;
import java.util.List;

public class MonstersGirlsItems extends InternalItems {

    // -- Variables --

    // MISCELLANEOUS
    public static final Item POWDER_GENESIS = register(MonstersGirlsID.getId(MonstersGirlsID.POWDER_GENESIS), new EnchantedItem(new FabricItemSettings().rarity(Rarity.RARE)));

    // FOOD
    public static final Item CANDIES = register(MonstersGirlsID.getId(MonstersGirlsID.CANDIES), new TooltipItem(new ArrayList<>(List.of(MonstersGirlsID.TOOLTIP_CANDIES)), new FabricItemSettings().food(MonstersGirlsFoodComponent.CANDIES).fireproof().rarity(Rarity.COMMON)));
    public static final Item SPECTRAL_CAKE = register(MonstersGirlsID.getId(MonstersGirlsID.SPECTRAL_CAKE), new TooltipItem(new ArrayList<>(List.of(MonstersGirlsID.TOOLTIP_SPECTRAL_CAKE)), new FabricItemSettings().food(MonstersGirlsFoodComponent.SPECTRAL_CAKE).fireproof().rarity(Rarity.UNCOMMON)));

    // SPAWN
    public static final Item SPAWN_SPOOK_PEACH = register(MonstersGirlsID.getId(MonstersGirlsID.SPAWN_SPOOK_PEACH), new SpawnItem(MonstersGirlsEntities.SPOOK_PEACH, new FabricItemSettings()));
    public static final Item SPAWN_SPOOK_TEAL = register(MonstersGirlsID.getId(MonstersGirlsID.SPAWN_SPOOK_TEAL), new SpawnItem(MonstersGirlsEntities.SPOOK_TEAL, new FabricItemSettings()));

    public static final Item SPAWN_WISP_BLUE = register(MonstersGirlsID.getId(MonstersGirlsID.SPAWN_WISP_BLUE), new SpawnItem(MonstersGirlsEntities.WISP_BLUE, new FabricItemSettings()));
    public static final Item SPAWN_WISP_GREEN = register(MonstersGirlsID.getId(MonstersGirlsID.SPAWN_WISP_GREEN), new SpawnItem(MonstersGirlsEntities.WISP_GREEN, new FabricItemSettings()));
    public static final Item SPAWN_WISP_YELLOW = register(MonstersGirlsID.getId(MonstersGirlsID.SPAWN_WISP_YELLOW), new SpawnItem(MonstersGirlsEntities.WISP_YELLOW, new FabricItemSettings()));

    public static void register() {
        MonstersGirls.LOGGER.info("Registering Items: " + MonstersGirls.MODID );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(MonstersGirlsItems::spawnEggItemsEntry);
        ItemGroupEvents.modifyEntriesEvent(MonstersGirlsItemsGroup.MONSTERS_GIRLS_KEY).register(MonstersGirlsItems::allItemsEntry);
    } // register ()

    private static void spawnEggItemsEntry(FabricItemGroupEntries entries) {
        //entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_BROWN);
        //entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_CHORUS);
        //entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GLOW_BERRY);
        //entries.add(MonstersGirlsItems.SPAWN_MANDRAKE_GIRL_GREEN);

        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_BROWN);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_CRIMSON_RARE);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_RED);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_FLY_AGARIC_YELLOW);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INK_CAP);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_WARPED_RARE);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_ENDER_PUFFBALL);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_INFERNAL);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_MOLTEN);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SOUL_WANDERER);
        //entries.add(MonstersGirlsItems.SPAWN_MUSHROOM_GIRL_SNOWBALL);

        //entries.add(MonstersGirlsItems.SPAWN_SPOOK_GIRL_PEACH);
        //entries.add(MonstersGirlsItems.SPAWN_SPOOK_GIRL_TEAL);

        //entries.accept(MonstersGirlsItems.SPAWN_WISP_GIRL_BLUE);
        //entries.accept(MonstersGirlsItems.SPAWN_WISP_GIRL_GREEN);
        //entries.accept(MonstersGirlsItems.SPAWN_WISP_GIRL_YELLOW);
    } // spawnEggItemsEntry ()

    private static void allItemsEntry(FabricItemGroupEntries entries) {
        entries.add(POWDER_GENESIS);

        entries.add(SPECTRAL_CAKE);
        entries.add(CANDIES);

        entries.add(SPAWN_SPOOK_PEACH);
        entries.add(SPAWN_SPOOK_TEAL);

        entries.add(SPAWN_WISP_BLUE);
        entries.add(SPAWN_WISP_GREEN);
        entries.add(SPAWN_WISP_YELLOW);
    } // allItemsEntry ()

} // Class MonstersGirlsItems