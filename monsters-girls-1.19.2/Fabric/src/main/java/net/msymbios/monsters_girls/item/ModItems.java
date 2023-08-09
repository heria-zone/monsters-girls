package net.msymbios.monsters_girls.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.msymbios.monsters_girls.MonstersGirlsMod;
import net.msymbios.monsters_girls.item.custom.EnchantedItem;

public class ModItems {

    // -- Variables --
    public static final Item ITEM_GROUP_ICON = registerItem("item_group_icon", new Item(new FabricItemSettings()));

    public static final Item POWDER_GENESIS = registerItem("powder_genesis", new EnchantedItem(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));

    public static final Item BROWN_MUSHROOM_HAT = registerItem("brown_mushroom_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item CRIMSON_FUNGUS_HAT = registerItem("crimson_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item CRIMSON_RARE_FUNGUS_HAT = registerItem("crimson_rare_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item ENDER_PUFFBALL_HAT = registerItem("ender_puffball_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item FLY_RED_AGARIC_HAT = registerItem("fly_red_agaric_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item FLY_YELLOW_AGARIC_HAT = registerItem("fly_yellow_agaric_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item INFERNAL_MUSHROOM_HAT = registerItem("infernal_mushroom_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item INK_CAP_MUSHROOM_HAT = registerItem("ink_cap_mushroom_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item MOLTEN_FUNGUS_HAT = registerItem("molten_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item SOUL_WANDERER_FUNGUS_HAT = registerItem("soul_wanderer_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item WARPED_FUNGUS_HAT = registerItem("warped_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));
    public static final Item WARPED_RARE_FUNGUS_HAT = registerItem("warped_rare_fungus_hat", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));

    public static final Item SPECTRAL_CAKE = registerItem("spectral_cake", new Item(new FabricItemSettings().group(ModItemsGroup.MONSTERS_GIRLS)));

    // -- Methods --
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MonstersGirlsMod.MODID, name), item);
    } // registerItem ()

    public static void registerModItems() {
        MonstersGirlsMod.LOGGER.debug(MonstersGirlsMod.MODID + ": Registering Items");
    } // registerModItems ()

} // Class ModItems