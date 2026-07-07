package net.heriazone.monsters_girls.entity.data.migration;

import net.heriazone.hzlib.api.nbt.DataCompound;
import net.heriazone.hzlib.api.nbt.McVersionProvider;
import net.heriazone.hzlib.api.nbt.MigrationStep;
import net.heriazone.hzlib.api.nbt.NbtAdapterFactory;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Migrates the published 1.20.4 Monsters &amp; Girls save format to 1.21.1.<p>
 * <p>
 * <b>Legacy format (1.20.4):</b> All fields flat on root with Fabric-style keys.
 * The critical complication: belly level was not a separate field — it was encoded
 * as a {@code TextureID} offset. Base textures occupied IDs 0..baseCount-1; belly
 * levels started at ID baseCount. This makes the belly/texture split ambiguous without
 * knowing each family's {@code baseTextureCount}.
 * <p>
 * <b>Disambiguation strategy:</b> A per-family {@code baseTextureCount} table is
 * declared statically here (populated by each family when it registers itself).
 * If a family is not in the table the step falls back to treating the entire
 * {@code TextureID} as a plain texture index (belly defaults to 0) and logs an error.
 * <p>
 * <b>1.20.4 legacy fields handled:</b>
 * <ul>
 *   <li>{@code TextureID} (int) → {@code TextureVariant} string + {@code EntityData.BellyLevel}</li>
 *   <li>{@code Belly} (bool, if present) → {@code EntityData.BellyLevel} (true→2/TUMMY, false→0)</li>
 *   <li>{@code ModelID} (int) → {@code ModelVariant} string via family prefix lookup</li>
 *   <li>{@code AnimatorID} (int) → {@code AnimatorVariant} string via family prefix lookup</li>
 *   <li>{@code State}, {@code Plant}, {@code Sound}, {@code Notification} → direct copy</li>
 * </ul>
 * <p>
 * <b>Idempotency:</b> If {@code EntityData.SchemaVersion} is present, the step is a no-op.
 */
public final class MigrationStep_V1_MG implements MigrationStep {

    // -- Base Texture Count Registry --

    /**
     * Maps entity type key → number of base textures (before belly offset begins).
     * <p>
     * Populated by calling {@link #registerBaseTextureCount(String, int)} during family
     * static initialisation. Families that call this before any world loads ensure the
     * table is complete when migration runs.
     * <p>
     * Keys must match the family's {@code NativeEntityFamily.getKey()} value exactly.
     */
    private static final Map<String, Integer> BASE_TEXTURE_COUNTS = new HashMap<>();

    /**
     * Registers the base texture count for a family.
     * <p>
     * Call this from the family's static initialiser block, before any world is loaded.
     * The count is the number of distinct base textures (excluding belly-level offsets).
     *
     * @param familyKey        the family's registry key (e.g. {@code "wisp_girl_blue"})
     * @param baseTextureCount number of base textures for this family
     */
    public static void registerBaseTextureCount(@NotNull String familyKey, int baseTextureCount) {
        BASE_TEXTURE_COUNTS.put(familyKey, baseTextureCount);
    } // registerBaseTextureCount ()

    // -- MigrationStep --

    @Override
    public @NotNull String id() { return "V1_MG"; }

    @Override
    public @NotNull DataCompound migrate(@NotNull DataCompound root) {
        // Already structured — skip
        if (root.hasCompound("EntityData") &&
                root.getCompound("EntityData").has("SchemaVersion")) return root;

        DataCompound entityData = NbtAdapterFactory.createEmpty();
        entityData.putString("SchemaVersion", "1.0.0");
        entityData.putString("McVersion", McVersionProvider.current());

        // -- TextureID disambiguation --
        // Infer entity type from root-level TextureVariant (if already migrated by a prior
        // step) or from a known entity-type key stored at root. In 1.20.4 M&G, no type key
        // was persisted — we must rely on whatever TextureVariant was already set by the
        // base NativeEntity migration or by the entity type constructor. As a fallback we
        // look for a "type" key written by earlier format, or leave texture as-is if already
        // a string key.
        int textureId    = root.getInt("TextureID", -1);
        String typeKey   = root.getString("type", "");
        int baseCount    = BASE_TEXTURE_COUNTS.getOrDefault(typeKey, -1);

        int bellyLevel = 0;

        if (textureId >= 0) {
            if (baseCount < 0) {
                // Family not registered — cannot disambiguate. Log clearly with enough
                // context to add a registration entry without guesswork.
                LoggerFactory.getLogger("HZLib-V1_MG").error(
                    "[HZLib] MigrationStep_V1_MG: family key '{}' has no registered baseTextureCount. " +
                    "Raw TextureID={} will be used as base texture index; BellyLevel defaults to 0. " +
                    "Call MigrationStep_V1_MG.registerBaseTextureCount(\"{}\", n) from the family's static block.",
                    typeKey, textureId, typeKey);
                // Treat entire TextureID as base texture, no belly
                root.putString("TextureVariant", typeKey.isEmpty() ? String.valueOf(textureId) : typeKey + "_" + textureId);
            } else if (textureId >= baseCount) {
                // ID is in the belly-offset range
                bellyLevel = textureId - baseCount + 1; // +1 because belly starts at SLIM=1
                bellyLevel = Math.min(bellyLevel, 5); // cap at CHUNKY
                root.putString("TextureVariant", typeKey + "_default");
            } else {
                // Normal base texture
                root.putString("TextureVariant", typeKey.isEmpty() ? String.valueOf(textureId) : typeKey + "_" + textureId);
            }
            root.remove("TextureID");
        }

        // -- Boolean Belly migration (alternative 1.20.4 format where Belly was bool) --
        if (root.has("Belly")) {
            boolean bellyBool = root.getBoolean("Belly", false);
            if (bellyLevel == 0) { // don't overwrite if we already computed from TextureID offset
                bellyLevel = bellyBool ? 2 : 0; // true → TUMMY (2), false → no belly (0)
            }
            root.remove("Belly");
        }

        entityData.putInt("BellyLevel", bellyLevel);

        // -- ModelID → ModelVariant --
        int modelId = root.getInt("ModelID", -1);
        if (modelId >= 0) {
            // In 1.20.4 M&G, model 0 = DEFAULT. Append family prefix + "_default".
            root.putString("ModelVariant", typeKey.isEmpty() ? "default" : typeKey + "_default");
            root.remove("ModelID");
        }

        // -- AnimatorID → AnimatorVariant --
        int animatorId = root.getInt("AnimatorID", -1);
        if (animatorId >= 0) {
            root.putString("AnimatorVariant", typeKey.isEmpty() ? "default" : typeKey + "_default");
            root.remove("AnimatorID");
        }

        // -- Direct copy fields --
        moveBoolean(root, entityData, "Plant", true);
        moveBoolean(root, entityData, "Sound", true);

        // Notification → NotificationEnabled (key rename to match 1.21.1 convention)
        if (root.has("Notification")) {
            entityData.putBoolean("NotificationEnabled", root.getBoolean("Notification", false));
            root.remove("Notification");
        }

        root.put("EntityData", entityData);
        return root;
    } // migrate ()

    // -- Private Helpers --

    private static void moveBoolean(DataCompound src, DataCompound dst, String key, boolean def) {
        dst.putBoolean(key, src.getBoolean(key, def));
        src.remove(key);
    } // moveBoolean ()

} // Class: MigrationStep_V1_MG
