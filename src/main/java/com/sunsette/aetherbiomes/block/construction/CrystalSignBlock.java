package com.sunsette.aetherbiomes.block.construction;

import com.aetherteam.aether.blockentity.SkyrootSignBlockEntity;
import com.sunsette.aetherbiomes.blockentity.CrystalSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.entity.BlockEntity;


public class CrystalSignBlock extends StandingSignBlock {
    public CrystalSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrystalSignBlockEntity(pos, state);
    }

}
