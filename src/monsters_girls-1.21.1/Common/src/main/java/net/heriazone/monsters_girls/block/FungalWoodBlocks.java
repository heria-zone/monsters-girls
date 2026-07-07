package net.heriazone.monsters_girls.block;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

/**
 * Open subclasses for vanilla block types whose constructors are {@code protected} in 1.21.1.
 * <p>
 * <b>Why protected:</b> Mojang intentionally restricted direct instantiation to push mod authors
 * toward subclassing or builder patterns. The concrete subclasses here add no behaviour —
 * they exist solely to widen visibility so {@link net.heriazone.monsters_girls.source.MonstersBlocks}
 * can instantiate them without reflection hacks.
 * <p>
 * All five classes are grouped here rather than split into separate files because they are
 * trivial adapters with no independent logic — grouping keeps the diff surface minimal.
 */
public final class FungalWoodBlocks {

    private FungalWoodBlocks() {} // utility class

    // -------------------------------------------------------------------------
    // Stairs
    // -------------------------------------------------------------------------

    /** Open subclass of {@link StairBlock} — constructor is protected in 1.21.1. */
    public static class Stairs extends StairBlock {
        public Stairs(BlockState baseState, BlockBehaviour.Properties properties) {
            super(baseState, properties);
        }
    } // Class: Stairs

    // -------------------------------------------------------------------------
    // Pressure plate
    // -------------------------------------------------------------------------

    /** Open subclass of {@link PressurePlateBlock} — constructor is protected in 1.21.1. */
    public static class PressurePlate extends PressurePlateBlock {
        public PressurePlate(BlockSetType type, BlockBehaviour.Properties properties) {
            super(type, properties);
        }
    } // Class: PressurePlate

    // -------------------------------------------------------------------------
    // Button
    // -------------------------------------------------------------------------

    /** Open subclass of {@link ButtonBlock} — constructor is protected in 1.21.1. */
    public static class Button extends ButtonBlock {
        public Button(BlockSetType type, int ticksToStayPressed, BlockBehaviour.Properties properties) {
            super(type, ticksToStayPressed, properties);
        }
    } // Class: Button

    // -------------------------------------------------------------------------
    // Door
    // -------------------------------------------------------------------------

    /** Open subclass of {@link DoorBlock} — constructor is protected in 1.21.1. */
    public static class Door extends DoorBlock {
        public Door(BlockSetType type, BlockBehaviour.Properties properties) {
            super(type, properties);
        }
    } // Class: Door

    // -------------------------------------------------------------------------
    // Trapdoor
    // -------------------------------------------------------------------------

    /** Open subclass of {@link TrapDoorBlock} — constructor is protected in 1.21.1. */
    public static class Trapdoor extends TrapDoorBlock {
        public Trapdoor(BlockSetType type, BlockBehaviour.Properties properties) {
            super(type, properties);
        }
    } // Class: Trapdoor

    // -------------------------------------------------------------------------
    // Leaves
    // -------------------------------------------------------------------------

    /** Open subclass of {@link LeavesBlock} — constructor is protected in 1.21.1. */
    public static class Leaves extends LeavesBlock {
        public Leaves(BlockBehaviour.Properties properties) {
            super(properties);
        }
    } // Class: Leaves

} // Class: FungalWoodBlocks
