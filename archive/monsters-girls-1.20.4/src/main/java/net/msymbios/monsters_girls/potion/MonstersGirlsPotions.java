package net.msymbios.monsters_girls.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.msymbios.monsters_girls.common.potion.InternalPotion;
import net.msymbios.monsters_girls.config.MonstersGirlsID;
import net.msymbios.monsters_girls.effect.MonstersGirlsEffects;

public class MonstersGirlsPotions extends InternalPotion {

    // -- Variables --

    public static final Potion BLAZING_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.BLAZING_POTION), MonstersGirlsEffects.BLAZING, 0, 0);
    public static final Potion CHILLY_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.CHILLY_POTION), MonstersGirlsEffects.CHILLY, 0, 0);
    public static final Potion POISONOUS_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.POISONOUS_POTION), MonstersGirlsEffects.POISONOUS, 0, 0);
    public static final Potion PUFFY_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.PUFFY_POTION), MonstersGirlsEffects.PUFFY, 0, 0);
    public static final Potion SOUL_WANDERER_TOUCH_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.SOUL_WANDERER_TOUCH_POTION), MonstersGirlsEffects.SOUL_WANDERER_TOUCH, 0, 0);
    public static final Potion SPOOKED_POTION = register(MonstersGirlsID.getId(MonstersGirlsID.SPOOKED_POTION), MonstersGirlsEffects.SPOOKED, 0, 0);

    // -- Methods --

    public static void register () {
        //registerRecipe(BLAZING_POTION, Ingredient.of(MonstersGirlsEffects.BLAZING), CHILLY_POTION);
    } // register ()

    protected static void registerRecipe (Potion input, Ingredient ingredient, Potion output) {
        FabricBrewingRecipeRegistry.registerPotionRecipe(input, ingredient, (Potion) Registries.POTION.getEntry(output));
    } // register ()

} // Class MonstersGirlsPotions