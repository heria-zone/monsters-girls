package net.heriazone.monsters_girls.entity.custom;

import net.heriazone.hzlib.api.entity.features.SizeVariantFeature;
import net.heriazone.hzlib.api.entity.variants.interfaces.ICompositeAppearance;

import java.util.Optional;

/**
 * Size-coupled composite appearance for Gourdragora variants.
 * <p>
 * <b>Architecture:</b> Extends the data carried by a plain {@link net.heriazone.hzlib.framework.entity.variants.StandardAppearanceVariant}
 * with a direct {@link SizeVariantFeature.SizeConfig} reference. The entity reads
 * {@link #getSizeConfig()} at spawn and on NBT load — no separate size-key lookup,
 * no string concatenation.
 * <p>
 * <b>Why not StandardAppearanceVariant:</b> That class intentionally returns
 * {@code Optional.empty()} from {@code getSizeConfig()}. Gourdragora appearance and
 * physical size are inseparable — this class makes that coupling explicit in the type.
 */
public final class GourdragoraAppearance implements ICompositeAppearance {

    // -- Fields --

    private final String key;
    private final String display;
    private final String textureKey;
    private final String modelKey;
    private final String animatorKey;
    private final int    priority;
    private final SizeVariantFeature.SizeConfig sizeConfig;

    // -- Constructor --

    /**
     * @param key         global appearance key (e.g. {@code "gourdragora_golden_mini"})
     * @param display     human-readable name
     * @param textureKey  per-color, per-size texture key
     * @param modelKey    shared model key (e.g. {@code "gourdragora_girl_mini"})
     * @param animatorKey shared animator key
     * @param priority    selection priority
     * @param sizeConfig  size configuration — stat multipliers, hitbox, scale
     */
    public GourdragoraAppearance(String key, String display,
                                  String textureKey, String modelKey, String animatorKey,
                                  int priority, SizeVariantFeature.SizeConfig sizeConfig) {
        this.key          = key;
        this.display      = display;
        this.textureKey   = textureKey;
        this.modelKey     = modelKey;
        this.animatorKey  = animatorKey;
        this.priority     = priority;
        this.sizeConfig   = sizeConfig;
    } // Constructor: GourdragoraAppearance ()

    // -- ICompositeAppearance --

    @Override public String getTextureKey()  { return textureKey;  }
    @Override public String getModelKey()    { return modelKey;    }
    @Override public String getAnimatorKey() { return animatorKey; }

    /**
     * Returns the size configuration tied to this appearance.
     * <p>
     * The entity calls {@code sizeConfig.applyTo(this)} immediately after resolving
     * this appearance at spawn and on NBT load — no secondary feature lookup needed.
     */
    @Override
    public Optional<SizeVariantFeature.SizeConfig> getSizeConfig() {
        return Optional.of(sizeConfig);
    } // getSizeConfig ()

    // -- IVariant --

    @Override public String  getKey()                   { return key;      }
    @Override public String  getDisplay()               { return display;  }
    @Override public int     getPriority()              { return priority; }
    @Override public boolean isAvailable(String entity) { return true;     }

} // Class: GourdragoraAppearance
