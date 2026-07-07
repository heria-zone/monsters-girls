package net.heriazone.monsters_girls;

public class MonstersConstant {

    // -- Entities --

    // MANDRAKE
    public static final String MANDRAKE_CHORUS = "mandrake_chorus_girl";
    public static final String MANDRAKE_FLOWER = "mandrake_flower_girl";
    public static final String MANDRAKE_FRUCTUS = "mandrake_fructus_girl";

    // MUSHROOM
    public static final String MUSHROOM_BROWN        = "mushroom_brown_girl";
    public static final String MUSHROOM_AMANITA      = "mushroom_amanita_girl";
    public static final String MUSHROOM_CRIMSON      = "mushroom_crimson_girl";
    public static final String MUSHROOM_INFERNAL     = "mushroom_infernal_girl";
    public static final String MUSHROOM_INKCAPS      = "mushroom_inkcaps_girl";
    public static final String MUSHROOM_MOLTEN       = "mushroom_molten_girl";
    public static final String MUSHROOM_PUFFBALL     = "mushroom_puffball_girl";
    public static final String MUSHROOM_FLUFFBALL    = "mushroom_fluffball_girl";
    public static final String MUSHROOM_SNOWBALL     = "mushroom_snowball_girl";
    public static final String MUSHROOM_SNOWBALL_PROJECTILE = "mushroom_snowball_projectile";
    public static final String MANDRAKE_CHORUS_SPIT         = "mandrake_chorus_spit";
    public static final String MUSHROOM_SOUL_WANDERER = "mushroom_soul_wanderer_girl";
    public static final String MUSHROOM_WARPED       = "mushroom_warped_girl";

    // BEE
    public static final String BEE_HONEY = "bee_girl_default";
    public static final String BEE_FIRELY    = "bee_girl_firely";
    public static final String BEE_PIXIE     = "bee_girl_pixie";
    public static final String BEE_SILK_MOTH = "bee_girl_silk_moth";
    public static final String BEE_BLACK_MOTH = "bee_girl_black_moth";

    // GLOBBERIE
    public static final String GLOBBERIE_PINK          = "globberie_girl_pink";
    public static final String GLOBBERIE_PINK_TWINTAILS = "globberie_girl_pink_twintails";
    public static final String GLOBBERIE_YELLOW        = "globberie_girl_yellow";

    // GOURDRAGORA — 3 entity variants (ADR_011: collapsed from 9 size-specific registrations)
    public static final String GOURDRAGORA_GOLDEN = "gourdragora_girl_golden";
    public static final String GOURDRAGORA_LUMINA = "gourdragora_girl_lumina";
    public static final String GOURDRAGORA_JACKO  = "gourdragora_girl_jacko";
    // Legacy constants kept for world save compatibility (old worlds may reference these)
    public static final String GOURDRAGORA_GOLDEN_MINI    = "gourdragora_girl_golden_mini";
    public static final String GOURDRAGORA_GOLDEN_DEFAULT = "gourdragora_girl_golden_default";
    public static final String GOURDRAGORA_GOLDEN_BIG     = "gourdragora_girl_golden_big";
    public static final String GOURDRAGORA_LUMINA_MINI    = "gourdragora_girl_lumina_mini";
    public static final String GOURDRAGORA_LUMINA_DEFAULT = "gourdragora_girl_lumina_default";
    public static final String GOURDRAGORA_LUMINA_BIG     = "gourdragora_girl_lumina_big";
    public static final String GOURDRAGORA_JACKO_MINI     = "gourdragora_girl_jacko_mini";
    public static final String GOURDRAGORA_JACKO_DEFAULT  = "gourdragora_girl_jacko_default";
    public static final String GOURDRAGORA_JACKO_BIG      = "gourdragora_girl_jacko_big";

    // MAIDEN OF THE SKIES
    public static final String MAIDEN = "maiden_of_the_skies";

    // SLIME
    public static final String SLIME_BLUE = "slime_girl_blue";

    // SPOOK
    public static final String SPOOK_CREAM = "spook_girl_cream";
    public static final String SPOOK_PEACH = "spook_girl_peach";
    public static final String SPOOK_TEAL = "spook_girl_teal";

    // WISP
    public static final String WISP_BLUE = "wisp_girl_blue";
    public static final String WISP_GREEN = "wisp_girl_green";
    public static final String WISP_YELLOW = "wisp_girl_yellow";

    // -- Items Group --

    public static final String DEFAULT_GROUP = "default_group";

    // -- ITEMS --

    // MISC
    public static final String POWDER_GENESIS = "powder_genesis";

    // FOOD
    public static final String SPECTRAL_CAKE = "spectral_cake";
    public static final String CANDIES = "candies";

    // STEWS — given by mushroom gals via ExchangeFeature (bowl → stew)
    public static final String STEW_NETHER       = "stew_nether";        // Infernal, Crimson, Warped → Fire Resistance
    public static final String STEW_POISON       = "stew_poison";        // Inkcap → Poisonous effect
    public static final String STEW_MOLTEN       = "stew_molten";        // Molten → Blazing effect
    public static final String STEW_PUFFBALL     = "stew_puffball";      // Puffball → Puffy effect
    public static final String STEW_SNOWBALL     = "stew_snowball";      // Snowball → Chilly effect
    public static final String STEW_SOUL_WANDERER = "stew_soul_wanderer"; // Soul Wanderer → Soul Wanderer's Touch

    // -- BLOCKS — custom mushroom/fungus plant blocks (genesis triggers + planting targets)

    // ENDER PUFFBALL WOOD SET — full fungal building set (15 blocks)
    public static final String ENDER_PUFFBALL_BLOCK           = "ender_puffball_block";
    public static final String ENDER_PUFFBALL_STEM            = "ender_puffball_stem";
    public static final String ENDER_PUFFBALL_HYPHAE          = "ender_puffball_hyphae";
    public static final String ENDER_PUFFBALL_STRIPPED_STEM   = "ender_puffball_stripped_stem";
    public static final String ENDER_PUFFBALL_STRIPPED_HYPHAE = "ender_puffball_stripped_hyphae";
    public static final String ENDER_PUFFBALL_PLANKS          = "ender_puffball_planks";
    public static final String ENDER_PUFFBALL_STAIRS          = "ender_puffball_stairs";
    public static final String ENDER_PUFFBALL_SLAB            = "ender_puffball_slab";
    public static final String ENDER_PUFFBALL_FENCE           = "ender_puffball_fence";
    public static final String ENDER_PUFFBALL_FENCE_GATE      = "ender_puffball_fence_gate";
    public static final String ENDER_PUFFBALL_PRESSURE_PLATE  = "ender_puffball_pressure_plate";
    public static final String ENDER_PUFFBALL_BUTTON          = "ender_puffball_button";
    public static final String ENDER_PUFFBALL_DOOR            = "ender_puffball_door";
    public static final String ENDER_PUFFBALL_TRAPDOOR        = "ender_puffball_trapdoor";
    public static final String SHROOMLIGHT_ENDER              = "shroomlight_ender";

    // MOLTEN FUNGUS WOOD SET — full fungal building set (15 blocks)
    public static final String MOLTEN_FUNGUS_BLOCK            = "molten_fungus_block";
    public static final String MOLTEN_FUNGUS_STEM             = "molten_fungus_stem";
    public static final String MOLTEN_FUNGUS_HYPHAE           = "molten_fungus_hyphae";
    public static final String MOLTEN_FUNGUS_STRIPPED_STEM    = "molten_fungus_stripped_stem";
    public static final String MOLTEN_FUNGUS_STRIPPED_HYPHAE  = "molten_fungus_stripped_hyphae";
    public static final String MOLTEN_FUNGUS_PLANKS           = "molten_fungus_planks";
    public static final String MOLTEN_FUNGUS_STAIRS           = "molten_fungus_stairs";
    public static final String MOLTEN_FUNGUS_SLAB             = "molten_fungus_slab";
    public static final String MOLTEN_FUNGUS_FENCE            = "molten_fungus_fence";
    public static final String MOLTEN_FUNGUS_FENCE_GATE       = "molten_fungus_fence_gate";
    public static final String MOLTEN_FUNGUS_PRESSURE_PLATE   = "molten_fungus_pressure_plate";
    public static final String MOLTEN_FUNGUS_BUTTON           = "molten_fungus_button";
    public static final String MOLTEN_FUNGUS_DOOR             = "molten_fungus_door";
    public static final String MOLTEN_FUNGUS_TRAPDOOR         = "molten_fungus_trapdoor";
    public static final String SHROOMLIGHT_MOLTEN             = "shroomlight_molten";

    // SOUL WANDERER WOOD SET — full fungal building set, emissive (15 blocks)
    public static final String SOUL_WANDERER_BLOCK            = "soul_wanderer_block";
    public static final String SOUL_WANDERER_STEM             = "soul_wanderer_stem";
    public static final String SOUL_WANDERER_HYPHAE           = "soul_wanderer_hyphae";
    public static final String SOUL_WANDERER_STRIPPED_STEM    = "soul_wanderer_stripped_stem";
    public static final String SOUL_WANDERER_STRIPPED_HYPHAE  = "soul_wanderer_stripped_hyphae";
    public static final String SOUL_WANDERER_PLANKS           = "soul_wanderer_planks";
    public static final String SOUL_WANDERER_STAIRS           = "soul_wanderer_stairs";
    public static final String SOUL_WANDERER_SLAB             = "soul_wanderer_slab";
    public static final String SOUL_WANDERER_FENCE            = "soul_wanderer_fence";
    public static final String SOUL_WANDERER_FENCE_GATE       = "soul_wanderer_fence_gate";
    public static final String SOUL_WANDERER_PRESSURE_PLATE   = "soul_wanderer_pressure_plate";
    public static final String SOUL_WANDERER_BUTTON           = "soul_wanderer_button";
    public static final String SOUL_WANDERER_DOOR             = "soul_wanderer_door";
    public static final String SOUL_WANDERER_TRAPDOOR         = "soul_wanderer_trapdoor";
    public static final String SHROOMLIGHT_SOUL               = "shroomlight_soul";

    // INKCAP MUSHROOM BLOCK VARIANTS — colour variants of the large inkcap block (3 blocks)
    public static final String INK_CAP_BLACK_MUSHROOM_BLOCK      = "ink_cap_black_mushroom_block";
    public static final String INK_CAP_GREY_MUSHROOM_BLOCK       = "ink_cap_grey_mushroom_block";
    public static final String INK_CAP_LIGHT_GREY_MUSHROOM_BLOCK = "ink_cap_light_grey_mushroom_block";

    // HUGE DECORATIVE MUSHROOM / FUNGUS BLOCKS — directional display blocks (12 blocks)
    public static final String HUGE_BROWN_MUSHROOM      = "huge_brown_mushroom";
    public static final String HUGE_CRIMSON_FUNGUS      = "huge_crimson_fungus";
    public static final String HUGE_CRIMSON_RARE_FUNGUS = "huge_crimson_rare_fungus";
    public static final String HUGE_ENDER_PUFFBALL      = "huge_ender_puffball_mushroom";
    public static final String HUGE_FLY_RED_AGARIC      = "huge_fly_red_agaric_mushroom";
    public static final String HUGE_FLY_YELLOW_AGARIC   = "huge_fly_yellow_agaric_mushroom";
    public static final String HUGE_INFERNAL_MUSHROOM   = "huge_infernal_mushroom";
    public static final String HUGE_INK_CAP_MUSHROOM    = "huge_ink_cap_mushroom";
    public static final String HUGE_MOLTEN_FUNGUS       = "huge_molten_fungus";
    public static final String HUGE_SOUL_WANDERER       = "huge_soul_wanderer_mushroom";
    public static final String HUGE_WARPED_FUNGUS       = "huge_warped_fungus";
    public static final String HUGE_WARPED_RARE_FUNGUS  = "huge_warped_rare_fungus";

    // SNOWBALL WOOD SET — fungal set, snow/ice theme (15 blocks)
    public static final String SNOWBALL_LOG              = "snowball_log";
    public static final String SNOWBALL_WOOD             = "snowball_wood";
    public static final String SNOWBALL_STRIPPED_LOG     = "snowball_stripped_log";
    public static final String SNOWBALL_STRIPPED_WOOD    = "snowball_stripped_wood";
    public static final String SNOWBALL_PLANKS           = "snowball_planks";
    public static final String SNOWBALL_STAIRS           = "snowball_stairs";
    public static final String SNOWBALL_SLAB             = "snowball_slab";
    public static final String SNOWBALL_FENCE            = "snowball_fence";
    public static final String SNOWBALL_FENCE_GATE       = "snowball_fence_gate";
    public static final String SNOWBALL_PRESSURE_PLATE   = "snowball_pressure_plate";
    public static final String SNOWBALL_BUTTON           = "snowball_button";
    public static final String SNOWBALL_DOOR             = "snowball_door";
    public static final String SNOWBALL_TRAPDOOR         = "snowball_trapdoor";
    public static final String SNOWBALL_MUSHROOM_BLOCK   = "snowball_mushroom_block";
    public static final String SNOWBALL_SHROOMLIGHT      = "snowball_shroomlight";

    // ENDER WILLOW WOOD SET — tree set, End theme (15 blocks)
    public static final String ENDER_WILLOW_LOG              = "ender_willow_log";
    public static final String ENDER_WILLOW_WOOD             = "ender_willow_wood";
    public static final String ENDER_WILLOW_STRIPPED_LOG     = "ender_willow_stripped_log";
    public static final String ENDER_WILLOW_STRIPPED_WOOD    = "ender_willow_stripped_wood";
    public static final String ENDER_WILLOW_PLANKS           = "ender_willow_planks";
    public static final String ENDER_WILLOW_STAIRS           = "ender_willow_stairs";
    public static final String ENDER_WILLOW_SLAB             = "ender_willow_slab";
    public static final String ENDER_WILLOW_FENCE            = "ender_willow_fence";
    public static final String ENDER_WILLOW_FENCE_GATE       = "ender_willow_fence_gate";
    public static final String ENDER_WILLOW_PRESSURE_PLATE   = "ender_willow_pressure_plate";
    public static final String ENDER_WILLOW_BUTTON           = "ender_willow_button";
    public static final String ENDER_WILLOW_DOOR             = "ender_willow_door";
    public static final String ENDER_WILLOW_TRAPDOOR         = "ender_willow_trapdoor";
    public static final String ENDER_WILLOW_LEAVES           = "ender_willow_leaves";
    public static final String ENDER_WILLOW_SAPLING          = "ender_willow_sapling";

    // DECORATION BLOCKS — environment dressing and interactive plants (5 blocks)
    public static final String ENDER_MOSS      = "ender_moss";
    public static final String GLOW_BERRY_BUSH = "glow_berry_bush";
    public static final String JAR             = "jar";
    public static final String URN_MOLTEN      = "urn_molten";
    public static final String URN_CRIMSON     = "urn_crimson";

    // -- ITEMS — hats (ArmorItem, head slot, one per mushroom/fungus family)

    public static final String HAT_MUSHROOM_BROWN           = "hat_mushroom_brown";
    public static final String HAT_MUSHROOM_CRIMSON         = "hat_mushroom_crimson";
    public static final String HAT_MUSHROOM_CRIMSON_RARE    = "hat_mushroom_crimson_rare";
    public static final String HAT_MUSHROOM_ENDER_PUFFBALL  = "hat_mushroom_ender_puffball";
    public static final String HAT_MUSHROOM_FLY_RED_AGARIC  = "hat_mushroom_fly_red_agaric";
    public static final String HAT_MUSHROOM_FLY_YELLOW_AGARIC = "hat_mushroom_fly_yellow_agaric";
    public static final String HAT_MUSHROOM_INFERNAL        = "hat_mushroom_infernal";
    public static final String HAT_MUSHROOM_INK_CAP         = "hat_mushroom_ink_cap";
    public static final String HAT_MUSHROOM_MOLTEN          = "hat_mushroom_molten";
    public static final String HAT_MUSHROOM_SOUL_WANDERER   = "hat_mushroom_soul_wanderer";
    public static final String HAT_MUSHROOM_WARPED          = "hat_mushroom_warped";
    public static final String HAT_MUSHROOM_WARPED_RARE     = "hat_mushroom_warped_rare";

    // BLOCKS — custom mushroom/fungus plant blocks (genesis triggers + planting targets)

    // MANDRAKE FLOWER PLANT — plantable block placed by Mandrake Flower entity
    public static final String MANDRAKE_FLOWER_PLANT = "mandrake_flower_plant";

    public static final String INKCAP_MUSHROOM       = "inkcap_mushroom";
    public static final String MOLTEN_FUNGUS         = "molten_fungus";
    public static final String ENDER_MUSHROOM        = "ender_mushroom";
    public static final String SNOWBALL_MUSHROOM     = "snowball_mushroom";
    public static final String SOUL_WANDERER_FUNGUS  = "soul_wanderer_fungus";

    // POTTED — flower pot variants of the custom blocks
    public static final String POTTED_INKCAP_MUSHROOM       = "potted_inkcap_mushroom";
    public static final String POTTED_MOLTEN_FUNGUS         = "potted_molten_fungus";
    public static final String POTTED_ENDER_MUSHROOM        = "potted_ender_mushroom";
    public static final String POTTED_SNOWBALL_MUSHROOM     = "potted_snowball_mushroom";
    public static final String POTTED_SOUL_WANDERER_FUNGUS  = "potted_soul_wanderer_fungus";

    // -- ITEMS SPAWN

    // MANDRAKE
    public static final String SPAWN_MANDRAKE_CHORUS = "spawn_mandrake_chorus_girl";
    public static final String SPAWN_MANDRAKE_FLOWER = "spawn_mandrake_flower_girl";
    public static final String SPAWN_MANDRAKE_FRUCTUS = "spawn_mandrake_fructus_girl";

    // MUSHROOM
    public static final String SPAWN_MUSHROOM_BROWN         = "spawn_mushroom_brown_girl";
    public static final String SPAWN_MUSHROOM_AMANITA       = "spawn_mushroom_amanita_girl";
    public static final String SPAWN_MUSHROOM_CRIMSON       = "spawn_mushroom_crimson_girl";
    public static final String SPAWN_MUSHROOM_INFERNAL      = "spawn_mushroom_infernal_girl";
    public static final String SPAWN_MUSHROOM_INKCAPS       = "spawn_mushroom_inkcaps_girl";
    public static final String SPAWN_MUSHROOM_MOLTEN        = "spawn_mushroom_molten_girl";
    public static final String SPAWN_MUSHROOM_PUFFBALL      = "spawn_mushroom_puffball_girl";
    public static final String SPAWN_MUSHROOM_FLUFFBALL     = "spawn_mushroom_fluffball_girl";
    public static final String SPAWN_MUSHROOM_SNOWBALL      = "spawn_mushroom_snowball_girl";
    public static final String SPAWN_MUSHROOM_SOUL_WANDERER = "spawn_mushroom_soul_wanderer_girl";
    public static final String SPAWN_MUSHROOM_WARPED        = "spawn_mushroom_warped_girl";

    // BEE
    public static final String SPAWN_BEE_HONEY = "spawn_bee_girl_default";
    public static final String SPAWN_BEE_FIRELY    = "spawn_bee_girl_firely";
    public static final String SPAWN_BEE_PIXIE     = "spawn_bee_girl_pixie";
    public static final String SPAWN_BEE_SILK_MOTH = "spawn_bee_girl_silk_moth";
    public static final String SPAWN_BEE_BLACK_MOTH = "spawn_bee_girl_black_moth";

    // GLOBBERIE
    public static final String SPAWN_GLOBBERIE = "spawn_globberie_girl_pink";
    public static final String SPAWN_GLOBBERIE_PINK_TWINTAILS = "spawn_globberie_girl_pink_twintails";
    public static final String SPAWN_GLOBBERIE_YELLOW        = "spawn_globberie_girl_yellow";

    // GOURDRAGORA — 3 entity variants (ADR_011: collapsed from 9 size-specific spawn items)
    public static final String SPAWN_GOURDRAGORA_GOLDEN = "spawn_gourdragora_golden_girl";
    public static final String SPAWN_GOURDRAGORA_LUMINA = "spawn_gourdragora_lumina_girl";
    public static final String SPAWN_GOURDRAGORA_JACKO  = "spawn_gourdragora_jacko_girl";
    // Legacy spawn constants kept for world save compatibility
    public static final String SPAWN_GOURDRAGORA_GOLDEN_MINI    = "spawn_gourdragora_girl_golden_mini";
    public static final String SPAWN_GOURDRAGORA_GOLDEN_DEFAULT = "spawn_gourdragora_girl_golden_default";
    public static final String SPAWN_GOURDRAGORA_GOLDEN_BIG     = "spawn_gourdragora_girl_golden_big";
    public static final String SPAWN_GOURDRAGORA_LUMINA_MINI    = "spawn_gourdragora_girl_lumina_mini";
    public static final String SPAWN_GOURDRAGORA_LUMINA_DEFAULT = "spawn_gourdragora_girl_lumina_default";
    public static final String SPAWN_GOURDRAGORA_LUMINA_BIG     = "spawn_gourdragora_girl_lumina_big";
    public static final String SPAWN_GOURDRAGORA_JACKO_MINI     = "spawn_gourdragora_girl_jacko_mini";
    public static final String SPAWN_GOURDRAGORA_JACKO_DEFAULT  = "spawn_gourdragora_girl_jacko_default";
    public static final String SPAWN_GOURDRAGORA_JACKO_BIG      = "spawn_gourdragora_girl_jacko_big";

    // MAIDEN OF THE SKIES
    public static final String SPAWN_MAIDEN = "spawn_maiden_of_the_skies";

    // SLIME
    public static final String SPAWN_SLIME_BLUE = "spawn_slime_girl_blue";

    // SPOOK
    public static final String SPAWN_SPOOK_CREAM = "spawn_spook_girl_cream";
    public static final String SPAWN_SPOOK_PEACH = "spawn_spook_girl_peach";
    public static final String SPAWN_SPOOK_TEAL = "spawn_spook_girl_teal";

    // WISP
    public static final String SPAWN_WISP_BLUE = "spawn_wisp_girl_blue";
    public static final String SPAWN_WISP_GREEN = "spawn_wisp_girl_green";
    public static final String SPAWN_WISP_YELLOW = "spawn_wisp_girl_yellow";

    // -- Sounds --

    // MANDRAKE
    public static final String SOUND_MANDRAKE_CHORUS_AMBIENT = "mandrakesounds";
    public static final String SOUND_MANDRAKE_FLOWER_AMBIENT = "mandrake_song";
    public static final String SOUND_MANDRAKE_FRUCTUS_AMBIENT = "fruity_mandrake";
    public static final String SOUND_MANDRAKE_HURT            = "mandrakehurt";
    public static final String SOUND_MANDRAKE_DEATH           = "mandrakedies";

    // SPOOK
    public static final String SOUND_SPOOK_ATTACK = "spookattacking";
    public static final String SOUND_SPOOK_HURT   = "spookhurt";
    public static final String SOUND_SPOOK_LAUGH  = "spooklaugh";

    // WISP
    public static final String SOUND_WISP_DEATH   = "wispdeath";
    public static final String SOUND_WISP_AMBIENT = "wisplaughs";
    public static final String SOUND_WISP_HURT    = "wisphurt";
    public static final String SOUND_WISP_VEX_KILL = "vexiskill";

    // MUSHROOM
    public static final String SOUND_MUSHROOM_AMBIENT      = "mushroomgirlsounds";
    public static final String SOUND_MUSHROOM_AMBIENT_WEIRD = "weirdmushroomgirlsounds";
    public static final String SOUND_MUSHROOM_GREET        = "mushroomgirlsayshi";
    public static final String SOUND_MUSHROOM_GREET_WEIRD  = "weirdmushroomgalsayshi";

    // SLIME
    public static final String SOUND_SLIME_AMBIENT = "slimegirlsounds";
    public static final String SOUND_SLIME_HURT    = "slimegirlhurt";
    public static final String SOUND_SLIME_POP     = "slimepop";

    // GOURDRAGORA
    public static final String SOUND_GOURDRAGORA_AMBIENT      = "gourdragora_giggles";
    public static final String SOUND_GOURDRAGORA_MEGA_AMBIENT = "mega_gourdragora_giggles";
    public static final String SOUND_GOURDRAGORA_MINI_AMBIENT = "mini_gourdragora_giggles";
    public static final String SOUND_GOURDRAGORA_ROAR         = "gourdragora_roar";

    // GLOBBERIE
    public static final String SOUND_GLOBBERIE_DEATH = "globberie_dies";

    // PUFFBALL (Ender Mushroom Gal)
    public static final String SOUND_PUFFBALL_PUFF_OUT = "enderpuffballgalhuffs";
    public static final String SOUND_PUFFBALL_PUFF_IN  = "enderpuffballgalpuffs";

    // -- Textures --

    public static final String TEXTURE_ENTITY_PATH = "textures/entity/";
    public static final String TEXTURE_LAYER_PATH = "textures/layer/";
    public static final String TEXTURE_EXTENSION = ".png";

    public static final String MODEL_PATH = "geo/";
    public static final String MODEL_EXTENSION = ".geo.json";

    public static final String ANIMATOR_PATH = "animations/";
    public static final String ANIMATOR_EXTENSION = ".animation.json";

    // -- Translations --



} // Class: MonstersConstant