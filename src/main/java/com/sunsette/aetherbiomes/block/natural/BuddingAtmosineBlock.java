package com.sunsette.aetherbiomes.block.natural;

import com.sunsette.aetherbiomes.block.AetherBiomesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.server.level.*;
import net.minecraftforge.registries.RegistryObject;


public class BuddingAtmosineBlock extends BuddingAmethystBlock {
    public BuddingAtmosineBlock(Properties pProperties) {
        super(pProperties);
    }
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();
    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            RegistryObject<Block> block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = AetherBiomesBlocks.ATMOSINE_BUD_SMALL;
            } else if (blockstate.is(AetherBiomesBlocks.ATMOSINE_BUD_SMALL.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AetherBiomesBlocks.ATMOSINE_BUD_MEDIUM;
            } else if (blockstate.is(AetherBiomesBlocks.ATMOSINE_BUD_MEDIUM.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AetherBiomesBlocks.ATMOSINE_BUD_LARGE;
            } else if (blockstate.is(AetherBiomesBlocks.ATMOSINE_BUD_LARGE.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AetherBiomesBlocks.ATMOSINE_CLUSTER;
            }

            if (block != null) {
                BlockState blockstate1 = block.get().defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }
    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }

}
