package net.heriazone.monsters_girls.block;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Pre-computed VoxelShape constants for all directional decorative blocks.
 * <p>
 * <b>Design:</b> Each shape constant is a {@code Map<Direction, VoxelShape>} consumed by
 * {@link DirectionalBlock}. All four horizontal directions share the same composite shape —
 * these decorations are symmetric and don't need per-facing rotated geometry; the facing state
 * controls texture orientation via blockstate JSON, not hitbox rotation.
 * <p>
 * Shapes ported from {@code VoxelCollision.java} in the 1.20.1 reference source.
 * Coordinates unchanged — Mojang's coordinate system is version-stable for block shapes.
 */
public class BlockShapes {

    // -- Private helpers --

    private static VoxelShape box(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Shapes.box(x1 / 16, y1 / 16, z1 / 16, x2 / 16, y2 / 16, z2 / 16);
    } // box ()

    private static VoxelShape combine(VoxelShape... parts) {
        return Stream.of(parts)
                .reduce((a, b) -> Shapes.joinUnoptimized(a, b, BooleanOp.OR))
                .map(VoxelShape::optimize)
                .orElse(Shapes.block());
    } // combine ()

    /** Wraps a single shape into an all-directions map (symmetric shapes). */
    private static Map<Direction, VoxelShape> allFacings(VoxelShape shape) {
        return Map.of(
                Direction.NORTH, shape,
                Direction.SOUTH, shape,
                Direction.EAST,  shape,
                Direction.WEST,  shape
        );
    } // allFacings ()

    // -- Shape constants --

    /**
     * Large mushroom cap on a thick stalk — used by Brown, Infernal, Molten, Ender Puffball huge blocks.
     */
    public static final Map<Direction, VoxelShape> HUGE_MUSHROOM = allFacings(combine(
            box(6,  3,  6, 10,  9, 10),
            box(5,  0,  5, 11,  7, 11),
            box(-1, 9, -1, 17, 15, 17),
            box(2, 15,  2, 14, 19, 14)
    ));

    /**
     * Tall funnel-cap fungus on a narrow stalk — used by Crimson, Crimson Rare huge blocks.
     */
    public static final Map<Direction, VoxelShape> HUGE_FUNGUS = allFacings(combine(
            box(5, 21,  5, 11, 23, 11),
            box(2, 13,  2, 14, 21, 14),
            box(-1, 9, -1, 17, 13, 17),
            box(5,  0,  5, 11,  3, 11),
            box(6,  3,  6, 10,  9, 10)
    ));

    /**
     * Wider mid-cap funnel variant — used by Ink Cap huge block.
     */
    public static final Map<Direction, VoxelShape> HUGE_FUNGUS_VARIANT = allFacings(combine(
            box(5,  0,  5, 11,  3, 11),
            box(6,  3,  6, 10,  9, 10),
            box(1, 12,  1, 15, 17, 15),
            box(-1, 6, -1, 17,  9, 17),
            box(-1, 9, -1, 17, 12, 17),
            box(4, 17,  4, 12, 21, 12),
            box(6, 21,  6, 10, 22, 10)
    ));

    /**
     * Medium mushroom — used by Fly Red Agaric and Fly Yellow Agaric huge blocks.
     */
    public static final Map<Direction, VoxelShape> MEDIUM_MUSHROOM = allFacings(combine(
            box(6,  3,  6, 10,  9, 10),
            box(5,  0,  5, 11,  3, 11),
            box(-1, 9, -1, 17, 13, 17),
            box(2, 13,  2, 14, 15, 14),
            box(5, 15,  5, 11, 17, 11)
    ));

    /**
     * Small mushroom — used by Warped and Warped Rare huge blocks.
     */
    public static final Map<Direction, VoxelShape> SMALL_MUSHROOM = allFacings(combine(
            box(6,  3,  6, 10,  9, 10),
            box(5,  0,  5, 11,  3, 11),
            box(-1, 9, -1, 17, 13, 17),
            box(2, 13,  2, 14, 15, 14)
    ));

    /**
     * Glass jar — used by the decorative Jar block.
     */
    public static final Map<Direction, VoxelShape> JAR = allFacings(combine(
            box(2,  0,  2, 14, 15, 14),
            box(4, 15,  4, 12, 16, 12),
            box(2,  0,  2, 14,  1, 14)
    ));

    /**
     * Large urn — used by URN_MOLTEN.
     */
    public static final Map<Direction, VoxelShape> BIG_URN = allFacings(combine(
            box(2,  2,  2, 14, 13, 14),
            box(5, 13,  5, 11, 14, 11),
            box(4, 14,  4, 12, 16, 12),
            box(4,  0,  4, 12,  2, 12)
    ));

    /**
     * Small urn — used by URN_CRIMSON.
     */
    public static final Map<Direction, VoxelShape> SMALL_URN = allFacings(combine(
            box(4,  2,  4, 12, 11, 12),
            box(6, 11,  6, 10, 14, 10),
            box(5, 14,  5, 11, 16, 11),
            box(5,  0,  5, 11,  2, 11)
    ));

} // Class: BlockShapes
