package net.msymbios.monsters_girls.config;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.msymbios.monsters_girls.MonstersGirls;

public class MonstersGirlsID {

    // -- Entities --

    // SPOOK
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

    // -- ITEMS SPAWN

    // SPOOK
    public static final String SPAWN_SPOOK_PEACH = "spawn_spook_girl_peach";
    public static final String SPAWN_SPOOK_TEAL = "spawn_spook_girl_teal";

    // WISP
    public static final String SPAWN_WISP_BLUE = "spawn_wisp_girl_blue";
    public static final String SPAWN_WISP_GREEN = "spawn_wisp_girl_green";
    public static final String SPAWN_WISP_YELLOW = "spawn_wisp_girl_yellow";

    // -- Sounds --

    // MANDRAGORA
    public static final String SOUND_MANDRAKE_SOUND = "mandrakesounds";
    public static final String SOUND_MANDRAKE_HURT = "mandrakehurt";
    public static final String SOUND_MANDRAKE_DEATH = "mandrakedies";

    // SPOOK
    public static final String SOUND_SPOOK_ATTACK = "spookattacking";
    public static final String SOUND_SPOOK_HURT = "spookhurt";
    public static final String SOUND_SPOOK_LAUGH = "spooklaugh";

    // WISP
    public static final String SOUND_WISP_DEATH = "wispdeath";
    public static final String SOUND_WISP_LAUGH = "wisplaughs";
    public static final String SOUND_WISP_HURT = "wisphurt";

    // -- Textures --

    public static final String TEXTURE_ENTITY_PATH = "textures/entity/";
    public static final String TEXTURE_EXTENSION = ".png";

    // -- Translations --

    // -- Tabs

    public static final String TRANS_DEFAULT_ITEM_GROUP = "itemGroup." + DEFAULT_GROUP;

    // -- Messages

    public static final String TRANS_MSG_NOTIFICATION = "msg.notification";
    public static final String TRANS_MSG_SOUND = "msg.sound";
    public static final String TRANS_MSG_PLANT = "msg.plant";

    public static final String TRANS_MSG_OFF = "msg.off";
    public static final String TRANS_MSG_ON = "msg.on";

    // -- Tooltips

    public static final String TOOLTIP_CANDIES = "tooltip.candies";
    public static final String TOOLTIP_SPECTRAL_CAKE = "tooltip.spectral_cake";

    // -- Entities

    public static final String VARIANT_PREFIX = "variant.";

    // WISP
    public static final String WISP_VARIANT_BLUE = "wisp_girl_blue";
    public static final String WISP_VARIANT_GREEN = "wisp_girl_green";
    public static final String WISP_VARIANT_YELLOW = "wisp_girl_yellow";

    // -- EFFECTS --

    public static final String BLAZING_EFFECT = "blazing";
    public static final String CHILLY_EFFECT = "chilly";
    public static final String POISONOUS_EFFECT = "poisonous";
    public static final String PUFFY_EFFECT = "puffy";
    public static final String SOUL_WANDERER_TOUCH_EFFECT = "soul_wanderers_touch";
    public static final String SPOOKED_EFFECT = "spooked";

    // -- POTIONS --

    public static final String BLAZING_POTION = "blazing_potion";
    public static final String CHILLY_POTION = "chilly_potion";
    public static final String POISONOUS_POTION = "poisonous_potion";
    public static final String PUFFY_POTION = "puffy_potion";
    public static final String SOUL_WANDERER_TOUCH_POTION = "soul_wanderers_touch_potion";
    public static final String SPOOKED_POTION = "spooked_potion";

    // -- Methods --

    public static Identifier getTexture (final String key) {
        return getId(TEXTURE_ENTITY_PATH + key + TEXTURE_EXTENSION);
    } // getTexture ()

    public static MutableText getTooltipTranslation(final String key) {
        return getTranslation("tooltip." + MonstersGirls.MODID + "." + key);
    } // getTooltipTranslation ()

    public static MutableText getTranslation(final String key) {
        return Text.translatable(MonstersGirls.MODID + "." + key);
    } // getTranslation ()

    public static MutableText getTranslation(final String key, Object... objects) {
        return Text.translatable(MonstersGirls.MODID + "." + key, objects);
    } // getTranslation ()

    public static Identifier getId(final String path) {
        return Identifier.of(MonstersGirls.MODID, path);
    } // getId ()

    public static Identifier getId(final String namespace, final String path) {
        if (namespace == null || namespace.isEmpty()) return getId(path);
        return Identifier.of(namespace, path);
    } // getId ()

} // Class MonstersGirlsID