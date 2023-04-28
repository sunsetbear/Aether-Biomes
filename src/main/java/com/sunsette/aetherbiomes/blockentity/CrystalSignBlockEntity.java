package com.sunsette.aetherbiomes.blockentity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
public class CrystalSignBlockEntity extends SignBlockEntity {
    public CrystalSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<CrystalSignBlockEntity> getType()
    {
        return AetherBiomesBlockEntityTypes.CRYSTAL_SIGN.get();
    }

}
