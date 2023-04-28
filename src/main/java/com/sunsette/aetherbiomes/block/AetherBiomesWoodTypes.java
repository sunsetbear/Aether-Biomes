package com.sunsette.aetherbiomes.block;

import com.aetherteam.aether.Aether;
import com.sunsette.aetherbiomes.AetherBiomes;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
public class AetherBiomesWoodTypes {
    public static final BlockSetType CRYSTAL_BLOCK_SET = new BlockSetType(Aether.MODID + ":crystal");
    public static final WoodType CRYSTAL = new WoodType(Aether.MODID + ":crystal", CRYSTAL_BLOCK_SET);
}
