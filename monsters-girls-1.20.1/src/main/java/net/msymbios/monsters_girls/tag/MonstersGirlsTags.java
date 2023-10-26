package net.msymbios.monsters_girls.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsTags {

    // -- Variables --
    public static final TagKey<Item> ENDER_PUFFBALL_LOGS = MonstersGirlsTags.of("ender_puffball_logs");
    public static final TagKey<Item> MOLTEN_LOGS = MonstersGirlsTags.of("molten_logs");
    public static final TagKey<Item> SOUL_LOGS = MonstersGirlsTags.of("soul_logs");
    public static final TagKey<Item> MUSHROOMS = MonstersGirlsTags.of("mushrooms");

    // -- Methods --
    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(MonstersGirls.MODID, id));
    } // of ()

} // Class MonstersGirlsTags