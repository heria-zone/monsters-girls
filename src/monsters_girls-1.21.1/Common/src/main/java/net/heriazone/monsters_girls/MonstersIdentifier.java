package net.heriazone.monsters_girls;

import net.heriazone.hzlib.framework.common.InternalIdentifier;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class MonstersIdentifier extends InternalIdentifier {

    // -- Singleton Instance --

    protected static MonstersIdentifier INSTANCE = new MonstersIdentifier();

    // -- Abstract Method Implementation --

    @Override
    protected String getModId() {
        return Monsters.MODID;
    } // getModId ()

    // -- Static Accessor Methods --

    public static String MODID () {
        return INSTANCE.getModId();
    } // MODID ()

    /**
     * Creates translation component for entity variant.
     *
     * @param key variant identifier key
     * @return translatable component for variant name
     */
    public static MutableComponent getVariantTranslation(final String key) {
        return INSTANCE.getTranslation("variant.", key);
    } // getVariantTranslation ()

    /**
     * Creates translation component for creative tab.
     *
     * @param key tab identifier key
     * @return translatable component for tab name
     */
    public static MutableComponent getTabTranslation(final String key) {
        return INSTANCE.getTranslation("tab.", key);
    } // getTabTranslation ()

    /**
     * Creates translation component for message.
     *
     * @param key message identifier key
     * @return translatable component for message text
     */
    public static MutableComponent getMessageTranslation(final String key) {
        return INSTANCE.getTranslation("msg.", key);
    } // getMessageTranslation ()

    /**
     * Creates basic translation component.
     *
     * @param key translation key
     * @return translatable component
     */
    public static MutableComponent getTranslation(final String key) {
        return INSTANCE.getTranslationInternal(key);
    } // getTranslation ()

    /**
     * Creates translation component with category prefix.
     *
     * @param category translation category (e.g., "item.", "block.")
     * @param key translation key
     * @return translatable component
     */
    public static MutableComponent getTranslation(final String category, final String key) {
        return INSTANCE.getTranslationInternal(category, key);
    } // getTranslation ()

    /**
     * Creates translation component with format arguments.
     *
     * @param key translation key
     * @param objects format arguments for translation
     * @return translatable component with formatted text
     */
    public static MutableComponent getTranslation(final String key, Object... objects) {
        return INSTANCE.getTranslationInternal(key, objects);
    } // getTranslation ()

    /**
     * Creates translation component with category and format arguments.
     *
     * @param category translation category
     * @param key translation key
     * @param objects format arguments for translation
     * @return translatable component with formatted text
     */
    public static MutableComponent getTranslation(final String category, final String key, Object... objects) {
        return INSTANCE.getTranslationInternal(category, key, objects);
    } // getTranslation ()

    /**
     * Creates ResourceLocation for mod resource.
     *
     * @param path resource path
     * @return ResourceLocation with mod namespace
     */
    public static ResourceLocation getId(final String path) {
        return INSTANCE.getIdInternal(path);
    } // getId ()

    /**
     * Creates ResourceLocation with custom namespace.
     * <p>
     * <b>Usage:</b> Allows referencing resources from other mods or Minecraft itself.
     *
     * @param namespace resource namespace (mod ID)
     * @param path resource path
     * @return ResourceLocation with specified namespace
     */
    public static ResourceLocation getId(final String namespace, final String path) {
        return INSTANCE.getIdInternal(namespace, path);
    } // getId ()

} // Class: MonstersIdentifier