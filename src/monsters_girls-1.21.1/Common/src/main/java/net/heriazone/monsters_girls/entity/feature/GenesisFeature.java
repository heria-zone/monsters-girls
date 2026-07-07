package net.heriazone.monsters_girls.entity.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.*;

/**
 * <p>Declares the block trigger that causes Genesis Powder to spawn this entity.<p>
 * <p>
 * <b>Lookup:</b> Entries support optional dimension and biome conditions. Resolution
 * picks the most specific match — dimension+biome beats dimension-only beats unconditional.
 * <p>
 * <b>Separation of concerns:</b> The feature on the entity type declares intent.
 * The static registry is the runtime artifact the item queries via {@link #resolve}.
 */
public class GenesisFeature {

    // -- Constants --

    private static final Map<Block, List<ConditionalEntry>> LOOKUP = new HashMap<>();

    // -- Fields --

    private final Set<Block>              triggerBlocks;
    private final ResourceKey<Level>      dimension; // null = any
    private final Set<ResourceKey<Biome>> biomes;    // empty = all biomes in dimension

    // -- Constructor --

    /** Single trigger block, unconditional. */
    public GenesisFeature(Block triggerBlock) {
        this(Set.of(Objects.requireNonNull(triggerBlock)), null);
    } // Constructor: GenesisFeature ()

    /** Multiple trigger blocks, unconditional. */
    public GenesisFeature(Set<Block> triggerBlocks) {
        this(triggerBlocks, null);
    } // Constructor: GenesisFeature ()

    /** Single trigger block, dimension-scoped with optional biomes. */
    @SafeVarargs
    public GenesisFeature(Block triggerBlock, ResourceKey<Level> dimension, ResourceKey<Biome>... biomes) {
        this(Set.of(Objects.requireNonNull(triggerBlock)), dimension, biomes);
    } // Constructor: GenesisFeature ()

    /** Multiple trigger blocks, dimension-scoped with optional biomes. */
    @SafeVarargs
    public GenesisFeature(Set<Block> triggerBlocks, ResourceKey<Level> dimension, ResourceKey<Biome>... biomes) {
        this.triggerBlocks = new HashSet<>(Objects.requireNonNull(triggerBlocks));
        this.dimension     = dimension;
        this.biomes        = new HashSet<>(Arrays.asList(biomes));
    } // Constructor: GenesisFeature ()

    // -- Accessors --

    /** Block Genesis Powder must target to spawn this entity. */
    public Set<Block> getTriggerBlocks() { return triggerBlocks; }
    public ResourceKey<Level>      getDimension()    { return dimension;    }
    public Set<ResourceKey<Biome>> getBiomes()       { return biomes;       }

    // -- Static Registry --

    /**
     * Registers the entity type against this feature's declared conditions.
     * Called from {@code registerMushroomFeatures()} after entity types are initialized.
     */
    public static void register(GenesisFeature feature, EntityType<?> entityType) {
        ConditionalEntry entry = new ConditionalEntry(entityType, feature.dimension, feature.biomes);
        for (Block block : feature.triggerBlocks) addEntry(block, entry);
    } // register ()
    
    /** Registers an unconditional entry — matches any dimension and biome. */
    public static void register(Block block, EntityType<?> entityType) {
        addEntry(block, new ConditionalEntry(entityType, null, Collections.emptySet()));
    } // register ()

    /**
     * Registers a conditional entry.
     * Omitting biomes matches all biomes within the given dimension.
     */
    @SafeVarargs
    public static void register(Block block, EntityType<?> entityType, ResourceKey<Level> dimension, ResourceKey<Biome>... biomes) {
        addEntry(block, new ConditionalEntry(entityType, dimension, new HashSet<>(Arrays.asList(biomes))));
    } // register ()

    /**
     * Resolves the entity type for the given block and world context.
     * Returns null if no entry matches.
     */
    public static EntityType<?> resolve(Block block, ServerLevel level, BlockPos pos) {
        List<ConditionalEntry> entries = LOOKUP.get(block);
        if (entries == null) return null;

        return entries.stream()
                .filter(e -> e.matches(level, pos))
                .max(Comparator.comparingInt(ConditionalEntry::specificity))
                .map(e -> e.entityType)
                .orElse(null);
    } // resolve ()

    // -- Private --

    private static void addEntry(Block block, ConditionalEntry entry) {
        LOOKUP.computeIfAbsent(Objects.requireNonNull(block), k -> new ArrayList<>()).add(entry);
    } // addEntry ()

    // =========================================================================
    // ConditionalEntry — inner class
    // =========================================================================

    /**
     * <p>Pairs an entity type with optional dimension and biome constraints.<p>
     * <p>
     * <b>Specificity:</b> Dimension+biome (2) > dimension-only (1) > unconditional (0).
     * Ensures the most contextually accurate entry wins when multiple entries share a block.
     */
    private static class ConditionalEntry {

        // -- Fields --

        final EntityType<?>           entityType;
        final ResourceKey<Level>      dimension; // null = any
        final Set<ResourceKey<Biome>> biomes;    // empty = all biomes in dimension

        // -- Constructor --

        ConditionalEntry(EntityType<?> entityType, ResourceKey<Level> dimension, Set<ResourceKey<Biome>> biomes) {
            this.entityType = entityType;
            this.dimension  = dimension;
            this.biomes     = biomes;
        } // Constructor: ConditionalEntry ()

        // -- Methods --

        boolean matches(ServerLevel level, BlockPos pos) {
            if (dimension != null && !level.dimension().equals(dimension)) return false;
            if (!biomes.isEmpty()) {
                ResourceKey<Biome> current = level.getBiome(pos).unwrapKey().orElse(null);
                if (current == null || !biomes.contains(current)) return false;
            }
            return true;
        } // matches ()

        int specificity() {
            if (dimension == null) return 0;
            return biomes.isEmpty() ? 1 : 2;
        } // specificity ()

    } // Class: ConditionalEntry

} // Class: GenesisFeature