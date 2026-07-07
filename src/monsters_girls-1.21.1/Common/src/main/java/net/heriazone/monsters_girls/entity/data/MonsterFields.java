package net.heriazone.monsters_girls.entity.data;

import net.heriazone.hzlib.api.nbt.DataField;
import net.heriazone.hzlib.api.nbt.DataType;

/**
 * <p>Single source of truth for all monster entity NBT field handles.<p>
 * <p>
 * <b>Design:</b> Mirrors {@code RobotFields} in LovelyLib. Every persisted field a
 * {@link net.heriazone.monsters_girls.entity.MonsterEntity} owns is declared here as a
 * typed {@link DataField} constant. NBT key strings are encapsulated — no literals at
 * call sites.
 * <p>
 * <b>Scope:</b> These are the fields common to all monster families. Family-specific
 * fields (e.g. {@code HUNGER_WATCH_COOLDOWN} on Gourdragora) are declared in their
 * respective family's schema override once those entity subclasses are implemented.
 */
public final class MonsterFields {

    private MonsterFields() {}

    // -- Belly system --

    /**
     * Belly progression level (0 = no belly, 1–5 = BellyLevel.SLIM–CHUNKY).
     * <p>
     * 0 is the sentinel for "no belly" — families without {@link net.heriazone.monsters_girls.entity.feature.BellyFeature}
     * always remain at 0. Apple/feather interactions are gated on feature presence.
     * <p>
     * <b>Migration note:</b> The 1.20.4 save encoded belly as a {@code TextureID} offset
     * rather than a separate field. {@link net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG}
     * handles the disambiguation using each family's declared {@code baseTextureCount}.
     */
    public static final DataField<Integer> BELLY_LEVEL =
            DataField.of("BellyLevel", DataType.INT, 0, v -> v >= 0 && v <= 5);

    /**
     * Legacy boolean belly field from 1.20.4 saves where {@code Belly = true} was stored
     * instead of the numeric level. {@link net.heriazone.monsters_girls.entity.data.migration.MigrationStep_V1_MG}
     * converts this to {@code BELLY_LEVEL = 2} (TUMMY) on migration.
     * <p>
     * <b>Not registered in any schema</b> — exists only as a migration bridge constant
     * so the key string "Belly" is defined in one place.
     */
    public static final DataField<Boolean> BELLY_LEGACY =
            DataField.of("Belly", DataType.BOOLEAN, false);

    // -- Preferences --

    /** Whether the entity performs autonomous planting when {@link net.heriazone.hzlib.api.entity.features.PlantingFeature} is declared. */
    public static final DataField<Boolean> PLANTING_ENABLED =
            DataField.of("Plant", DataType.BOOLEAN, true);

    /** Whether the entity plays ambient sounds. Hurt and death sounds ignore this flag. */
    public static final DataField<Boolean> SOUND_ENABLED =
            DataField.of("Sound", DataType.BOOLEAN, true);

} // Class: MonsterFields
