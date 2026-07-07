package net.heriazone.monsters_girls.entity;

/**
 * Ordered belly progression levels for monster entities.
 * <p>
 * <b>Architecture:</b> Lives in the monsters mod, not HZLib — belly is a monsters-specific
 * cosmetic mechanic with no relevance to other HZLib consumers (robots, etc.).
 * {@link net.heriazone.hzlib.api.rendering.RenderConditions#bellyAtLeast} accepts a raw
 * {@code int} so it stays HZLib-clean; callers pass {@link #getLevel()} here.
 * <p>
 * <b>Level 0 is reserved as "no belly"</b> — it has no authored texture and the
 * CONDITIONAL belly overlay evaluates to false for all entries (since every declared
 * level starts at 1). This means a freshly spawned or feather-reduced entity shows
 * a clean base texture with no belly overlay at all.
 * <p>
 * <b>Progression:</b> Apple increments level (capped by
 * {@link net.heriazone.monsters_girls.entity.feature.BellyFeature#getMaxLevel()}),
 * feather decrements (floor 0). Levels without an authored texture render nothing —
 * progression still tracks correctly, only the visual is absent for that step.
 */
public enum BellyLevel {

    SLIM    (1),
    CHUBBY  (2),
    TUMMY   (3),
    INFLATED(4),
    CHUNKY  (5);

    private final int level;

    BellyLevel(int level) {
        this.level = level;
    } // Constructor: BellyLevel ()

    /** Raw integer value used for synced entity data and predicate comparisons. */
    public int getLevel() {
        return level;
    } // getLevel ()

    /**
     * Looks up the enum constant for the given raw level integer.
     * Returns {@code null} for level 0 — that is the "no belly" sentinel, not a
     * named level. Falls back to {@link #SLIM} for any other out-of-range value
     * so the system degrades gracefully on corrupt NBT or future level additions.
     *
     * @param level raw integer level (0 = no belly, 1–5 = named levels)
     * @return matching {@code BellyLevel}, {@code null} if level 0, or {@link #SLIM} fallback
     */
    public static BellyLevel byLevel(int level) {
        if (level == 0) return null; // 0 = no belly — not a named level
        for (BellyLevel b : values()) {
            if (b.level == level) return b;
        }
        return SLIM; // out-of-range fallback
    } // byLevel ()

} // Enum: BellyLevel
