package net.msymbios.monsters_girls.block.internal;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.stream.Stream;

public class VoxelCollision {

    // -- Variables --
    public static VoxelShape DEFAULT_BLOCK = Block.createCuboidShape(0,0,0,16,16,16);

    public static VoxelShape HUGE_FUNGUS = Stream.of(
            Block.createCuboidShape(5, 21, 5, 11, 23, 11),
            Block.createCuboidShape(2, 13, 2, 14, 21, 14),
            Block.createCuboidShape(-1, 9, -1, 17, 13, 17),
            Block.createCuboidShape(5, 0, 5, 11, 3, 11),
            Block.createCuboidShape(6, 3, 6, 10, 9, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape HUGE_FUNGUS_VARIANT = Stream.of(
            Block.createCuboidShape(5, 0, 5, 11, 3, 11),
            Block.createCuboidShape(6, 3, 6, 10, 9, 10),
            Block.createCuboidShape(1, 12, 1, 15, 17, 15),
            Block.createCuboidShape(-1, 6, -1, 17, 9, 17),
            Block.createCuboidShape(-1, 9, -1, 17, 12, 17),
            Block.createCuboidShape(4, 17, 4, 12, 21, 12),
            Block.createCuboidShape(6, 21, 6, 10, 22, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape HUGE_MUSHROOM = Stream.of(
            Block.createCuboidShape(6, 3, 6, 10, 9, 10),
            Block.createCuboidShape(5, 0, 5, 11, 7, 11),
            Block.createCuboidShape(-1, 9, -1, 17, 15, 17),
            Block.createCuboidShape(2, 15, 2, 14, 19, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape MEDIUM_MUSHROOM = Stream.of(
            Block.createCuboidShape(6, 3, 6, 10, 9, 10),
            Block.createCuboidShape(5, 0, 5, 11, 3, 11),
            Block.createCuboidShape(-1, 9, -1, 17, 13, 17),
            Block.createCuboidShape(2, 13, 2, 14, 15, 14),
            Block.createCuboidShape(5, 15, 5, 11, 17, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape SMALL_MUSHROOM = Stream.of(
            Block.createCuboidShape(6, 3, 6, 10, 9, 10),
            Block.createCuboidShape(5, 0, 5, 11, 3, 11),
            Block.createCuboidShape(-1, 9, -1, 17, 13, 17),
            Block.createCuboidShape(2, 13, 2, 14, 15, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape JAR = Stream.of(
            Block.createCuboidShape(2, 0, 2, 14, 15, 14),
            Block.createCuboidShape(4, 15, 4, 12, 16, 12),
            Block.createCuboidShape(2, 0, 2, 14, 1, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

    public static VoxelShape BIG_URN = Stream.of(
            Block.createCuboidShape(2, 2, 2, 14, 13, 14),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(4, 14, 4, 12, 16, 12),
            Block.createCuboidShape(4, 0, 4, 12, 2, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

    public static VoxelShape SMALL_URN = Stream.of(
            Block.createCuboidShape(4, 2, 4, 12, 11, 12),
            Block.createCuboidShape(6, 11, 6, 10, 14, 10),
            Block.createCuboidShape(5, 14, 5, 11, 16, 11),
            Block.createCuboidShape(5, 0, 5, 11, 2, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

} // Class VoxelCollision