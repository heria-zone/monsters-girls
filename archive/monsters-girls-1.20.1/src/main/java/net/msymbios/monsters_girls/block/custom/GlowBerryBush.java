package net.msymbios.monsters_girls.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.Collections;
import java.util.List;

public class GlowBerryBush extends PlantBlock implements Fertilizable {

    // -- Variables --
    public static final IntProperty AGE = Properties.AGE_3;

    // -- Constructor --
    public GlowBerryBush(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
    } // Constructor GlowBerryBush ()

    // -- Inherited Methods --
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(Items.GLOW_BERRIES);
    } // getPickStack ()

    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState blockState = (BlockState)state.with(AGE, i + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    } // randomTick ()

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = (Integer)state.get(AGE);
        boolean bl = i == 3;
        if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(Items.GLOW_BERRIES, j + (bl ? 1 : 0)));
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = (BlockState)state.with(AGE, 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    } // onUse ()

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
    } // appendProperties ()

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    } // isFertilizable ()

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    } // canGrow ()

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, i), 2);
    } // grow ()

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        List<ItemStack> originalDrops = super.getDroppedStacks(state, builder);
        if(!originalDrops.isEmpty()) return originalDrops;
        return Collections.singletonList(new ItemStack(Items.GLOW_BERRIES));
    } // getDroppedStacks ()

} // Class GlowBerryBush