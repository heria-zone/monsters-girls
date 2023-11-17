package net.msymbios.monsters_girls.block.internal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DirectionalBlock extends HorizontalFacingBlock {

    // -- Variable --
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    private VoxelShape SHAPE = VoxelCollision.DEFAULT_BLOCK;

    // -- Constructor --
    public DirectionalBlock(Settings settings) {
        super(settings);
    } // Constructor DirectionalBlock ()

    public DirectionalBlock(Settings settings, VoxelShape shape) {
        super(settings);
        this.SHAPE = shape;
    } // Constructor DirectionalBlock ()

    // -- Inherited Methods --
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    } // appendProperties ()

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    } // getOutlineShape ()

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerLookDirection());
    } // getPlacementState ()

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    } // rotate ()

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    } // mirror ()

} // Class DirectionalBlock