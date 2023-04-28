package com.sunsette.aetherbiomes.blockentity;

import com.aetherteam.aether.blockentity.AbstractAetherFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class HolystoneFurnaceBlockEntity extends FurnaceBlockEntity {
    public HolystoneFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    public BlockEntityType<HolystoneFurnaceBlockEntity> getType()
    {
        return AetherBiomesBlockEntityTypes.HOLYSTONE_FURNACE.get();
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return null;
    }
}
