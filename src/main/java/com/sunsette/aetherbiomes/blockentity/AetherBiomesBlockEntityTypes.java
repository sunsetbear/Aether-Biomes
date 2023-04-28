package com.sunsette.aetherbiomes.blockentity;

import com.aetherteam.aether.Aether;
import com.sunsette.aetherbiomes.AetherBiomes;
import com.sunsette.aetherbiomes.block.AetherBiomesBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class AetherBiomesBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Aether.MODID);
    public static final RegistryObject<BlockEntityType<CrystalSignBlockEntity>> CRYSTAL_SIGN = BLOCK_ENTITY_TYPES.register("crystal_sign", () ->
            BlockEntityType.Builder.of(CrystalSignBlockEntity::new, AetherBiomesBlocks.CRYSTAL_WALL_SIGN.get(), AetherBiomesBlocks.CRYSTAL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<HolystoneFurnaceBlockEntity>> HOLYSTONE_FURNACE = BLOCK_ENTITY_TYPES.register("holystone_furnace", () ->
            BlockEntityType.Builder.of(HolystoneFurnaceBlockEntity::new, AetherBiomesBlocks.HOLYSTONE_FURNACE.get()).build(null));
}
