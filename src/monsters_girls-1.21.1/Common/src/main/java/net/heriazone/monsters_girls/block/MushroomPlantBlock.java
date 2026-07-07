package net.heriazone.monsters_girls.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * <p>A simple non-growing mushroom/fungus plant block for custom genesis triggers and planting targets.<p>
 * <p>
 * <b>Design:</b> Extends {@link BushBlock} — the vanilla base for small cross-shaped plants
 * (no collision, requires solid floor, correct bounding box). {@code BushBlock} is abstract in
 * 1.21.1, requiring this concrete subclass.
 * <p>
 * <b>codec():</b> Required by the 1.21 block data system. Uses {@link Block#simpleCodec}
 * which creates a {@link MapCodec} backed solely by the block's {@link BlockBehaviour.Properties}.
 * This is the standard vanilla pattern for all simple block subclasses.
 * <p>
 * <b>Placement surfaces:</b> Accepts an optional {@link TagKey} to restrict which block faces
 * are valid placement surfaces. Each mushroom family targets different blocks (grass/mycelium for
 * Inkcap, magma/basalt for Molten, end stone for Ender, etc.). Passing {@code null} falls back to
 * vanilla {@link BushBlock#mayPlaceOn} (any block tagged {@code minecraft:dirt} or solid surface).
 * <p>
 * <b>No spreading:</b> Unlike vanilla mushrooms, these blocks do not spread or grow into huge
 * mushrooms. They are purely decorative and functional as genesis trigger / planting target blocks.
 */
public class MushroomPlantBlock extends BushBlock {

    // -- Codec --

    /**
     * Block codec required by the 1.21 data-driven block system.
     * <p>
     * {@code simpleCodec} creates a {@link MapCodec} that encodes/decodes this block
     * purely from its {@link BlockBehaviour.Properties}. All simple, stateless block
     * subclasses follow this pattern in vanilla (e.g. {@code DeadBushBlock}, {@code TallGrassBlock}).
     */
    public static final MapCodec<MushroomPlantBlock> CODEC = simpleCodec(MushroomPlantBlock::new);

    // -- Fields --

    /**
     * Optional tag restricting valid placement surfaces.
     * {@code null} = vanilla BushBlock default (any suitable solid surface).
     */
    private final TagKey<Block> allowedSurfaceTag;

    // -- Constructors --

    /**
     * Creates a mushroom plant block that can be placed on any suitable solid surface.
     * Used by {@link #CODEC} and for basic construction without surface restrictions.
     *
     * @param properties block behaviour properties
     */
    public MushroomPlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.allowedSurfaceTag = null;
    } // Constructor: MushroomPlantBlock ()

    /**
     * Creates a mushroom plant block restricted to blocks matching the given tag.
     *
     * @param properties         block behaviour properties
     * @param allowedSurfaceTag  tag whose member blocks are valid placement surfaces
     */
    public MushroomPlantBlock(BlockBehaviour.Properties properties, TagKey<Block> allowedSurfaceTag) {
        super(properties);
        this.allowedSurfaceTag = allowedSurfaceTag;
    } // Constructor: MushroomPlantBlock ()

    // -- Block contract --

    /**
     * Returns the block's codec.
     * <p>
     * Required abstract implementation — delegates to the static {@link #CODEC}.
     *
     * @return the {@link MapCodec} for this block type
     */
    @Override
    public MapCodec<? extends BushBlock> codec() {
        return CODEC;
    } // codec ()

    // -- Placement --

    /**
     * Determines whether this plant may rest on the given block.
     * <p>
     * If an {@code allowedSurfaceTag} was provided, only blocks in that tag are valid.
     * Otherwise, delegates to {@link BushBlock#mayPlaceOn}, which accepts any block
     * tagged {@code minecraft:dirt} or a small set of hardcoded surfaces.
     *
     * @param state the state of the block directly below this plant
     * @param level the block getter
     * @param pos   position of the block below
     * @return true if placement is allowed
     */
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        if (allowedSurfaceTag != null) {
            return state.is(allowedSurfaceTag);
        }
        return super.mayPlaceOn(state, level, pos);
    } // mayPlaceOn ()

} // Class: MushroomPlantBlock
