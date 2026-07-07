package net.heriazone.monsters_girls.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

/**
 * A decorative block whose collision shape and facing direction rotate with player placement.
 * <p>
 * <b>Design:</b> Holds a {@code Map<Direction, VoxelShape>} so each facing variant has its own
 * pre-computed shape — avoids per-tick shape rotation math. Used by huge mushroom decorations,
 * jars, and urns which all have asymmetric hitboxes.
 * <p>
 * <b>Placement:</b> Faces toward the player's look direction on placement, matching vanilla
 * directional block behaviour (furnace, dispenser, etc.).
 */
public class DirectionalBlock extends Block {

    // -- Constants --

    public static final MapCodec<DirectionalBlock> CODEC = simpleCodec(DirectionalBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // -- Fields --

    /** Per-direction VoxelShapes. Falls back to full-cube if direction is absent. */
    private final Map<Direction, VoxelShape> shapes;

    // -- Constructors --

    /**
     * Full constructor — accepts a per-facing shape map for asymmetric hitboxes.
     *
     * @param properties block behaviour (hardness, sound, map colour, etc.)
     * @param shapes     map from horizontal direction to the corresponding VoxelShape
     */
    public DirectionalBlock(BlockBehaviour.Properties properties, Map<Direction, VoxelShape> shapes) {
        super(properties);
        this.shapes = shapes;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    } // Constructor: DirectionalBlock ()

    /**
     * No-shape constructor — used by {@link #CODEC} (codec only supplies Properties).
     * Shape defaults to full cube via {@link Block#getShape} fallback.
     *
     * @param properties block behaviour properties
     */
    public DirectionalBlock(BlockBehaviour.Properties properties) {
        this(properties, Map.of());
    } // Constructor: DirectionalBlock ()

    // -- Block contract --

    @Override
    public MapCodec<? extends Block> codec() {
        return CODEC;
    } // codec ()

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    } // createBlockStateDefinition ()

    // -- Placement --

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    } // getStateForPlacement ()

    // -- Shape --

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.getOrDefault(state.getValue(FACING), super.getShape(state, level, pos, context));
    } // getShape ()

    // -- Rotation / Mirror --

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    } // rotate ()

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    } // mirror ()

} // Class: DirectionalBlock
