package net.heriazone.monsters_girls.entity.feature;

import net.heriazone.monsters_girls.entity.BellyLevel;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

/**
 * Declares the belly overlay capabilities for a monster entity family.
 * <p>
 * <b>Architecture:</b> Attached to a {@link net.heriazone.monsters_girls.entity.MonstersFamily}
 * via {@code withFeature(BellyFeature.class, new BellyFeature()...)}. Absence of this
 * feature on a family means the entity ignores apple and feather entirely — the gate
 * is feature presence, not a boolean flag or entity-class conditional.
 * <p>
 * <b>Texture gap rule:</b> Levels without a declared texture simply render nothing.
 * Progression still tracks through all levels — only the visual is absent for
 * undeclared steps. This allows families to declare only the levels they have
 * authored assets for while still supporting the full 0–4 range in data.
 * <p>
 * <b>Overlay wiring:</b> The texture paths declared here are for documentation and
 * max-level enforcement only. The actual CONDITIONAL overlay slot entries are declared
 * separately on the {@link net.heriazone.hzlib.api.entity.features.overlay.OverlayFeature}
 * in the family class, referencing the same paths. This separation keeps the rendering
 * concern in the overlay system and the progression concern in this feature.
 * <p>
 * <b>Usage example:</b>
 * <pre>{@code
 * withFeature(BellyFeature.class, new BellyFeature()
 *     .maxLevel(BellyLevel.TUMMY)
 *     .texture(BellyLevel.SLIM,  "monsters_girls:textures/layer/wisp/wisp_blue_belly_slim.png")
 *     .texture(BellyLevel.TUMMY, "monsters_girls:textures/layer/wisp/wisp_blue_belly_tummy.png"))
 * }</pre>
 */
public class BellyFeature {

    // -- Fields --

    /** Maximum belly level this family can reach. Apple interactions clamp here. */
    private BellyLevel maxLevel = BellyLevel.TUMMY;

    /** Authored overlay texture paths keyed by level. Levels not present = no visual. */
    private final Map<BellyLevel, String> textures = new EnumMap<>(BellyLevel.class);

    // -- Builder Methods --

    /**
     * Sets the maximum belly level for this family.
     * Apple interactions will not increment past this level.
     *
     * @param max the cap level
     * @return this instance for chaining
     */
    public BellyFeature maxLevel(BellyLevel max) {
        this.maxLevel = max;
        return this;
    } // maxLevel ()

    /**
     * Registers an authored texture path for the given belly level.
     * Levels without a registered texture render nothing but still participate
     * in the numeric progression.
     *
     * @param level       the belly level this texture represents
     * @param texturePath full resource location string (e.g. {@code "monsters_girls:textures/layer/..."})
     * @return this instance for chaining
     */
    public BellyFeature texture(BellyLevel level, String texturePath) {
        textures.put(level, texturePath);
        return this;
    } // texture ()

    // -- Accessors --

    /**
     * Returns the maximum belly level cap declared for this family.
     * {@code MonsterEntity.handleBellyProgression()} clamps increments here.
     */
    public BellyLevel getMaxLevel() {
        return maxLevel;
    } // getMaxLevel ()

    /**
     * Returns {@code true} if an overlay texture has been authored for {@code level}.
     * Levels that return {@code false} are tracked in data but render no overlay.
     */
    public boolean hasTextureFor(BellyLevel level) {
        return textures.containsKey(level);
    } // hasTextureFor ()

    /**
     * Returns the registered texture path for {@code level}, or {@link Optional#empty()}
     * if no texture was declared for that level.
     *
     * @param level the belly level to look up
     * @return texture path wrapped in Optional
     */
    public Optional<String> getTexturePath(BellyLevel level) {
        return Optional.ofNullable(textures.get(level));
    } // getTexturePath ()

} // Class: BellyFeature
