package net.msymbios.monsters_girls.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;
import net.msymbios.monsters_girls.tag.MonstersGirlsTags;

import java.util.concurrent.CompletableFuture;

public class MonstersGirlsItemTagProvider extends FabricTagProvider.ItemTagProvider {

    // -- Constructor --
    public MonstersGirlsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    } // Constructor MonstersGirlsItemTagProvider ()
    
    // -- Inherited Method --
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(MonstersGirlsTags.ENDER_PUFFBALL_LOGS)
                .add(MonstersGirlsItems.ENDER_PUFFBALL_STEM)
                .add(MonstersGirlsItems.ENDER_PUFFBALL_HYPHAE)
                .add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_STEM)
                .add(MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_HYPHAE);

        getOrCreateTagBuilder(MonstersGirlsTags.MOLTEN_LOGS)
                .add(MonstersGirlsItems.MOLTEN_FUNGUS_STEM)
                .add(MonstersGirlsItems.MOLTEN_FUNGUS_HYPHAE)
                .add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_STEM)
                .add(MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE);

        getOrCreateTagBuilder(MonstersGirlsTags.SOUL_LOGS)
                .add(MonstersGirlsItems.SOUL_WANDERER_STEM)
                .add(MonstersGirlsItems.SOUL_WANDERER_HYPHAE)
                .add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_STEM)
                .add(MonstersGirlsItems.SOUL_WANDERER_STRIPPED_HYPHAE);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(MonstersGirlsItems.ENDER_PUFFBALL_PLANKS)
                .add(MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS)
                .add(MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        getOrCreateTagBuilder(MonstersGirlsTags.MUSHROOMS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM)
                .add(Items.WARPED_FUNGUS)
                .add(Items.CRIMSON_FUNGUS)
                .add(MonstersGirlsItems.HUGE_BROWN_MUSHROOM)
                .add(MonstersGirlsItems.HUGE_CRIMSON_FUNGUS)
                .add(MonstersGirlsItems.HUGE_CRIMSON_RARE_FUNGUS)
                .add(MonstersGirlsItems.HUGE_ENDER_PUFFBALL)
                .add(MonstersGirlsItems.HUGE_FLY_RED_AGARIC)
                .add(MonstersGirlsItems.HUGE_FLY_YELLOW_AGARIC)
                .add(MonstersGirlsItems.HUGE_INFERNAL_MUSHROOM)
                .add(MonstersGirlsItems.HUGE_INK_CAP_MUSHROOM)
                .add(MonstersGirlsItems.HUGE_MOLTEN_FUNGUS)
                .add(MonstersGirlsItems.HUGE_SOUL_WANDERER)
                .add(MonstersGirlsItems.HUGE_WARPED_FUNGUS)
                .add(MonstersGirlsItems.HUGE_WARPED_RARE_FUNGUS);

    } // configure ()

} // Class MonstersGirlsItemTagProvider