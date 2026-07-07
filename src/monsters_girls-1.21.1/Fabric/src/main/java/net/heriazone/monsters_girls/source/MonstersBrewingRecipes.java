package net.heriazone.monsters_girls.source;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.heriazone.monsters_girls.source.MonstersPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;

/**
 * <p>Registers all custom potion brewing recipes for Monsters &amp; Girls.<p>
 * <p>
 * <b>Architecture:</b> Potion <em>registration</em> (declaring the Potion type and
 * its effects) lives in Common ({@link MonstersPotions}). Brewing <em>recipes</em>
 * live here in Fabric because {@code FabricBrewingRecipeRegistryBuilder} is a
 * Fabric API class.
 * <p>
 * <b>Recipe chain per effect (vanilla convention):</b>
 * <pre>
 *   Awkward Potion + [ingredient] → Regular
 *   Regular        + Redstone     → Long
 *   Regular        + Glowstone    → Strong  (amplifier effects only)
 * </pre>
 * <p>
 * <b>Ingredients — verified non-clashing with vanilla 1.21.1:</b>
 * <ul>
 *   <li><b>Poisonous</b>    — Fermented Spider Eye: Spider Eye alone already produces vanilla Poison
 *       from Awkward, so the fermented variant is used instead. Thematically it
 *       fits "corrupted venom" and is not used as an Awkward base in vanilla.</li>
 *   <li><b>Chilly</b>       — Snowball: no vanilla recipe uses Snowball as an Awkward ingredient.</li>
 *   <li><b>Blazing</b>      — Fire Charge: Blaze Powder alone already produces vanilla Strength
 *       from Awkward, so Fire Charge is used instead. No vanilla recipe uses it as a brew base.</li>
 *   <li><b>Soul Wanderer's Touch</b> — Soul Sand: no vanilla recipe uses Soul Sand as an Awkward ingredient.</li>
 *   <li><b>Puffy</b>        — Chorus Fruit: no vanilla recipe uses Chorus Fruit as an Awkward ingredient.</li>
 * </ul>
 * <p>
 * <b>Tipped arrows:</b> No brewing registration needed. Tipped arrows are crafted via the vanilla
 * shapeless recipe (8 arrows + 1 lingering potion), which automatically applies to any registered
 * lingering potion including custom ones. Creative tab entries for tipped arrows are handled in
 * {@code MonstersGroups} via {@code PotionContents.createItemStack(Items.TIPPED_ARROW, potion)}.
 * <p>
 * Call {@link #register()} from {@code MonstersGirls.onInitialize()} after
 * {@code Monsters.init()} so potions are registered before recipes are wired.
 */
public class MonstersBrewingRecipes {

    /**
     * Wires all brewing recipes using Fabric's {@code FabricBrewingRecipeRegistryBuilder.BUILD} event.
     * <p>
     * Must be called once during mod initialization, after {@code MonstersPotions.register()}.
     */
    public static void register() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {

            // -- Poisonous (Fermented Spider Eye — Spider Eye alone clashes with vanilla Poison) --
            builder.addMix(Potions.AWKWARD,           Items.FERMENTED_SPIDER_EYE, MonstersPotions.POISONOUS);
            builder.addMix(MonstersPotions.POISONOUS,  Items.REDSTONE,             MonstersPotions.LONG_POISONOUS);
            builder.addMix(MonstersPotions.POISONOUS,  Items.GLOWSTONE_DUST,       MonstersPotions.STRONG_POISONOUS);

            // -- Chilly (Snowball — no vanilla recipe uses this as an Awkward base) --
            builder.addMix(Potions.AWKWARD,           Items.SNOWBALL,       MonstersPotions.CHILLY);
            builder.addMix(MonstersPotions.CHILLY,     Items.REDSTONE,       MonstersPotions.LONG_CHILLY);
            builder.addMix(MonstersPotions.CHILLY,     Items.GLOWSTONE_DUST, MonstersPotions.STRONG_CHILLY);

            // -- Blazing (Fire Charge — Blaze Powder alone clashes with vanilla Strength) --
            builder.addMix(Potions.AWKWARD,           Items.FIRE_CHARGE,   MonstersPotions.BLAZING);
            builder.addMix(MonstersPotions.BLAZING,    Items.REDSTONE,      MonstersPotions.LONG_BLAZING);
            // No Strong Blazing — fire immunity + on-fire don't scale with amplifier.

            // -- Soul Wanderer's Touch (Soul Sand — no vanilla recipe uses this as an Awkward base) --
            builder.addMix(Potions.AWKWARD,                    Items.SOUL_SAND, MonstersPotions.SOUL_WANDERERS_TOUCH);
            builder.addMix(MonstersPotions.SOUL_WANDERERS_TOUCH, Items.REDSTONE, MonstersPotions.LONG_SOUL_WANDERERS_TOUCH);
            // No Strong Soul Wanderer's Touch — wither on-hit and regen don't scale with amplifier.

            // -- Puffy (Chorus Fruit — no vanilla recipe uses this as an Awkward base) --
            builder.addMix(Potions.AWKWARD,           Items.CHORUS_FRUIT,   MonstersPotions.PUFFY);
            builder.addMix(MonstersPotions.PUFFY,      Items.REDSTONE,       MonstersPotions.LONG_PUFFY);
            builder.addMix(MonstersPotions.PUFFY,      Items.GLOWSTONE_DUST, MonstersPotions.STRONG_PUFFY);

        });
    } // register ()

} // Class: MonstersBrewingRecipes