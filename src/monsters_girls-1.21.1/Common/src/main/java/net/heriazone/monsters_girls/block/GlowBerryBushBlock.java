package net.heriazone.monsters_girls.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * A ground bush that grows over time and grants Regeneration to entities walking through it.
 * <p>
 * <b>Design:</b> Extends {@link BushBlock} for correct placement rules (solid floor required,
 * no collision box enforced by super). Adds an {@code AGE} property (0–3) matching vanilla
 * {@link net.minecraft.world.level.block.SweetBerryBushBlock} — loot table conditionally
 * drops glow berries when fully grown ({@code age >= 2}).
 * <p>
 * <b>Effect source:</b> The Regeneration buff applied on {@link #entityInside} is short (20 ticks,
 * level I, no particles) so it functions as a subtle passive buff rather than a noticeable effect
 * — consistent with the 1.20.1 reference behaviour.
 */
public class GlowBerryBushBlock extends BushBlock {

    // -- Constants --

    public static final MapCodec<GlowBerryBushBlock> CODEC = simpleCodec(GlowBerryBushBlock::new);

    /** Growth stage 0 = sprout, 3 = mature/berry-bearing. */
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    /** Bounding box: slim cross-shape covering the full block column (no collision — noCollission() on properties). */
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 13, 14);

    // -- Constructors --

    public GlowBerryBushBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    } // Constructor: GlowBerryBushBlock ()

    // -- Block contract --

    @Override
    public MapCodec<? extends BushBlock> codec() {
        return CODEC;
    } // codec ()

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    } // createBlockStateDefinition ()

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    } // getShape ()

    // -- Entity interaction --

    /**
     * Applies a brief Regeneration I effect to living entities walking through the bush.
     * <p>
     * Effect duration (20 ticks = 1 s) is intentionally short — re-applies each tick the entity
     * remains inside, effectively maintaining the buff while in contact without an overwhelming
     * visual effect (ambient=true suppresses particles).
     */
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(
                    MobEffects.REGENERATION,
                    20,    // duration: 1 s — re-applies each tick for continuous buff while inside
                    0,     // amplifier: level I
                    false, // ambient: false — show particles
                    false  // visible: no HUD icon (subtle)
            ));
        }
    } // entityInside ()

} // Class: GlowBerryBushBlock
