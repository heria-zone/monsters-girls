package net.msymbios.monsters_girls.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.item.MonstersGirlsItems;
import net.msymbios.monsters_girls.tag.MonstersGirlsTags;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class MonstersGirlsRecipeProvider extends FabricRecipeProvider {

    // -- Constructor --
    public MonstersGirlsRecipeProvider(FabricDataOutput output) {
        super(output);
    } // Constructor MonstersGirlsRecipeProvider ()

    // -- Inherited Method --
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerPlanksRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS, MonstersGirlsTags.ENDER_PUFFBALL_LOGS, 4);
        offerPlanksRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS, MonstersGirlsTags.MOLTEN_LOGS, 4);
        offerPlanksRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_PLANKS, MonstersGirlsTags.SOUL_LOGS, 4);

        offer4ShapedRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_HYPHAE, MonstersGirlsItems.ENDER_PUFFBALL_STEM);
        offer4ShapedRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_HYPHAE, MonstersGirlsItems.MOLTEN_FUNGUS_STEM);
        offer4ShapedRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_HYPHAE, MonstersGirlsItems.SOUL_WANDERER_STEM);

        offer4ShapedRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_HYPHAE, MonstersGirlsItems.ENDER_PUFFBALL_STRIPPED_STEM);
        offer4ShapedRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_HYPHAE, MonstersGirlsItems.MOLTEN_FUNGUS_STRIPPED_STEM);
        offer4ShapedRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_STRIPPED_HYPHAE, MonstersGirlsItems.SOUL_WANDERER_STRIPPED_STEM);

        offerStairsRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_STAIRS, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerStairsRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_STAIRS, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerStairsRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_STAIRS, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MonstersGirlsItems.ENDER_PUFFBALL_SLAB, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MonstersGirlsItems.MOLTEN_FUNGUS_SLAB, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MonstersGirlsItems.SOUL_WANDERER_SLAB, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerFenceRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_FENCE, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerFenceRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_FENCE, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerFenceRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_FENCE, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerFenceGateRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_FENCE_GATE, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerFenceGateRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_FENCE_GATE, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerFenceGateRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_FENCE_GATE, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerPressurePlateRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_PRESSURE_PLATE, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerPressurePlateRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_PRESSURE_PLATE, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerPressurePlateRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_PRESSURE_PLATE, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerSingleOutputShapelessRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_BUTTON, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS, "has_ender_puffball_button");
        offerSingleOutputShapelessRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_BUTTON, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS, "has_molten_fungus_button");
        offerSingleOutputShapelessRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_BUTTON, MonstersGirlsItems.SOUL_WANDERER_PLANKS, "has_soul_wanderer_button");

        offerDoorRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_DOOR, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerDoorRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_DOOR, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerDoorRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_DOOR, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offerTrapdoorRecipe(exporter, MonstersGirlsItems.ENDER_PUFFBALL_TRAPDOOR, MonstersGirlsItems.ENDER_PUFFBALL_PLANKS);
        offerTrapdoorRecipe(exporter, MonstersGirlsItems.MOLTEN_FUNGUS_TRAPDOOR, MonstersGirlsItems.MOLTEN_FUNGUS_PLANKS);
        offerTrapdoorRecipe(exporter, MonstersGirlsItems.SOUL_WANDERER_TRAPDOOR, MonstersGirlsItems.SOUL_WANDERER_PLANKS);

        offer2ShapelessRecipe(exporter, RecipeCategory.FOOD, MonstersGirlsItems.SPECTRAL_CAKE, Items.CAKE, MonstersGirlsItems.SOUL_WANDERER_FUNGUS, "food", 1);
        offer3ShapelessRecipe(exporter, RecipeCategory.MISC, MonstersGirlsItems.POWDER_GENESIS, Items.GOLDEN_APPLE, Items.BONE_MEAL, MonstersGirlsTags.MUSHROOMS, "misc", 1);

        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_BROWN, MonstersGirlsItems.HUGE_BROWN_MUSHROOM, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_CRIMSON, MonstersGirlsItems.HUGE_CRIMSON_FUNGUS, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_CRIMSON_RARE, MonstersGirlsItems.HUGE_CRIMSON_RARE_FUNGUS, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_ENDER_PUFFBALL, MonstersGirlsItems.HUGE_ENDER_PUFFBALL, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_FLY_RED_AGARIC, MonstersGirlsItems.HUGE_FLY_RED_AGARIC, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_FLY_YELLOW_AGARIC, MonstersGirlsItems.HUGE_FLY_YELLOW_AGARIC, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_INFERNAL, MonstersGirlsItems.HUGE_INFERNAL_MUSHROOM, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_INK_CAP, MonstersGirlsItems.HUGE_INK_CAP_MUSHROOM, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_MOLTEN, MonstersGirlsItems.HUGE_MOLTEN_FUNGUS, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_SOUL_WANDERER, MonstersGirlsItems.HUGE_SOUL_WANDERER, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_WARPED, MonstersGirlsItems.HUGE_WARPED_FUNGUS, "hat", 1);
        offerShapelessRecipe(exporter, MonstersGirlsItems.HAT_MUSHROOM_WARPED_RARE, MonstersGirlsItems.HUGE_WARPED_RARE_FUNGUS, "hat", 1);

        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_BROWN_MUSHROOM, Items.BROWN_MUSHROOM, Items.BROWN_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_CRIMSON_FUNGUS, Items.CRIMSON_FUNGUS, Items.CRIMSON_FUNGUS, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_CRIMSON_RARE_FUNGUS, Items.CRIMSON_FUNGUS, Items.RED_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_ENDER_PUFFBALL, MonstersGirlsItems.ENDER_PUFFBALL_MUSHROOM, MonstersGirlsItems.ENDER_PUFFBALL_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_FLY_RED_AGARIC, Items.RED_MUSHROOM, Items.RED_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_FLY_YELLOW_AGARIC, Items.RED_MUSHROOM, Items.BROWN_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_INFERNAL_MUSHROOM, MonstersGirlsItems.MOLTEN_FUNGUS, Items.RED_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_INK_CAP_MUSHROOM, MonstersGirlsItems.INK_CAP_MUSHROOM, MonstersGirlsItems.INK_CAP_MUSHROOM, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_MOLTEN_FUNGUS, MonstersGirlsItems.MOLTEN_FUNGUS, MonstersGirlsItems.MOLTEN_FUNGUS, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_SOUL_WANDERER, MonstersGirlsItems.SOUL_WANDERER_FUNGUS, MonstersGirlsItems.SOUL_WANDERER_FUNGUS, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_WARPED_FUNGUS, Items.WARPED_FUNGUS, Items.WARPED_FUNGUS, "mushrooms", 1);
        offer2SameShapelessRecipe(exporter, RecipeCategory.DECORATIONS, MonstersGirlsItems.HUGE_WARPED_RARE_FUNGUS, Items.WARPED_FUNGUS, Items.BROWN_MUSHROOM, "mushrooms", 1);

        offerShapelessRecipe(exporter, Items.GLOW_BERRIES, MonstersGirlsItems.GLOW_BERRY_BUSH, "misc", 1);
    } // generate ()

    // -- Methods --
    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offerStairsRecipe ()

    public static void offerFenceRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createFenceRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offerFenceRecipe ()

    public static void offerFenceGateRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offerFenceGateRecipe ()

    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createDoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offerDoorRecipe ()

    public static void offerTrapdoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createTrapdoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offerTrapdoorRecipe ()

    public static void offer4ShapedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3)
                .input('#', input)
                .pattern("##")
                .pattern("##").criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offer4ShapedRecipe ()

    public static void offer2ShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder.create(category, output, outputCount).
                input(input1).
                input(input2).group(group).
                criterion(RecipeProvider.hasItem(input1), RecipeProvider.conditionsFromItem(input1)).
                criterion(RecipeProvider.hasItem(input2), RecipeProvider.conditionsFromItem(input2)).
                offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offer2ShapelessRecipe ()

    public static void offer2SameShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder.create(category, output, outputCount).
                input(input1).
                input(input2).group(group).
                criterion(RecipeProvider.hasItem(input1), RecipeProvider.conditionsFromItem(input1)).
                offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offer2SameShapelessRecipe ()

    public static void offer3ShapelessRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input1, ItemConvertible input2, TagKey<Item> input3, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder.create(category, output, outputCount).
                input(input1).
                input(input2).
                input(input3).group(group).
                criterion(RecipeProvider.hasItem(input1), RecipeProvider.conditionsFromItem(input1)).
                criterion(RecipeProvider.hasItem(input2), RecipeProvider.conditionsFromItem(input2)).
                criterion("has_mushrooms", RecipeProvider.conditionsFromTag(input3)).
                offerTo(exporter, new Identifier(getRecipeName(output)));
    } // offer3ShapelessRecipe ()

} // Class MonstersGirlsRecipeProvider