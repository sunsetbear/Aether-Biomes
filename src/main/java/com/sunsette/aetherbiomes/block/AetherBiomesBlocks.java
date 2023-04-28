package com.sunsette.aetherbiomes.block;
import com.aetherteam.aether.block.construction.SkyrootSignBlock;
import com.aetherteam.aether.block.construction.SkyrootWallSignBlock;
import com.aetherteam.aether.block.natural.AetherLogBlock;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.block.BurnableBlockItem;
import com.sunsette.aetherbiomes.block.construction.CrystalSignBlock;
import com.sunsette.aetherbiomes.block.construction.CrystalWallSignBlock;
import com.sunsette.aetherbiomes.block.construction.HolystoneFurnaceBlock;
import com.sunsette.aetherbiomes.block.construction.SkyrootCraftingTableBlock;
import com.sunsette.aetherbiomes.block.natural.BuddingAtmosineBlock;
import com.sunsette.aetherbiomes.world.treegrower.CrystalTree;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.level.block.state.properties.WoodType;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;

import net.minecraft.world.level.block.Block;

import com.sunsette.aetherbiomes.block.natural.AetherBiomesGrassBlock;
import com.sunsette.aetherbiomes.AetherBiomes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.aetherteam.aether.block.AetherBlocks.BLOCKS;
import static net.minecraft.world.level.block.Blocks.AMETHYST_CLUSTER;

public class AetherBiomesBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AetherBiomes.MOD_ID);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            AetherBiomesGrassBlock.blockColorLoad(event);
        }

        @SubscribeEvent
        public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
            AetherBiomesGrassBlock.itemColorLoad(event);
        }
    }
    public static final RegistryObject<SaplingBlock> CRYSTAL_SAPLING = register("crystal_sapling", () -> new SaplingBlock(new CrystalTree(), Block.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SKYROOT_CRAFTING_TABLE = register("skyroot_crafting_table", () -> new SkyrootCraftingTableBlock(Block.Properties.copy(Blocks.CRAFTING_TABLE)));

    public static final RegistryObject<Block> ATMOSINE_BLOCK = register("atmosine_block", () -> new AmethystBlock(Block.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> BUDDING_ATMOSINE = register("budding_atmosine", () -> new BuddingAtmosineBlock(Block.Properties.copy(Blocks.BUDDING_AMETHYST)));
    public static final RegistryObject<Block> ATMOSINE_CLUSTER = register("atmosine_cluster", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel((p_152632_) -> {
        return 5;
    })));
    public static final RegistryObject<Block> ATMOSINE_BUD_LARGE = register("atmosine_bud_large", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152629_) -> {
        return 4;
    })));
    public static final RegistryObject<Block> ATMOSINE_BUD_MEDIUM = register("atmosine_bud_medium", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152617_) -> {
        return 2;
    })));
    public static final RegistryObject<Block> ATMOSINE_BUD_SMALL = register("atmosine_bud_small", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_187409_) -> {
        return 1;
    })));
    public static final RegistryObject<Block> HOLYSTONE_FURNACE = register("holystone_furnace", () -> new HolystoneFurnaceBlock(Block.Properties.copy(Blocks.FURNACE)));
    public static final RegistryObject<Block> SKYROOT_LADDER = register("skyroot_ladder", () -> new LadderBlock(Block.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> AETHER_BIOMES_GRASS_BLOCK = register("aether_biomes_grass_block", () -> new AetherBiomesGrassBlock(Block.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).randomTicks().strength(0.2F).sound(SoundType.GRASS)));
    public static final RegistryObject<FenceBlock> CRYSTAL_FENCE = register("crystal_fence", () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> CRYSTAL_FENCE_GATE = register("crystal_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), AetherBiomesWoodTypes.CRYSTAL));
    public static final RegistryObject<DoorBlock> CRYSTAL_DOOR = register("crystal_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), AetherBiomesWoodTypes.CRYSTAL_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> CRYSTAL_TRAPDOOR = register("crystal_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), AetherBiomesWoodTypes.CRYSTAL_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> CRYSTAL_BUTTON = register("crystal_button", () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), AetherBiomesWoodTypes.CRYSTAL_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> CRYSTAL_PRESSURE_PLATE = register("crystal_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), AetherBiomesWoodTypes.CRYSTAL_BLOCK_SET));
    public static final RegistryObject<RotatedPillarBlock> CRYSTAL_LOG = register("crystal_log", () -> new AetherLogBlock(Block.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CRYSTAL_LOG = register("stripped_crystal_log", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> CRYSTAL_WOOD = register("crystal_wood", () -> new AetherLogBlock(Block.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CRYSTAL_WOOD = register("stripped_crystal_wood", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CRYSTAL_PLANKS = register("crystal_planks", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<StandingSignBlock> CRYSTAL_SIGN = register("crystal_sign", () -> new CrystalSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).noCollission().strength(1.0F).sound(SoundType.WOOD), AetherBiomesWoodTypes.CRYSTAL));
    public static final RegistryObject<WallSignBlock> CRYSTAL_WALL_SIGN = BLOCKS.register("crystal_wall_sign", () -> new CrystalWallSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(CRYSTAL_SIGN), AetherBiomesWoodTypes.CRYSTAL));
    public static final RegistryObject<StairBlock> CRYSTAL_STAIRS = register("crystal_stairs",
            () -> new StairBlock(() -> CRYSTAL_PLANKS.get().defaultBlockState(), Block.Properties.copy(AetherBiomesBlocks.CRYSTAL_PLANKS.get())));
    public static final RegistryObject<SlabBlock> CRYSTAL_SLAB = register("crystal_slab",
            () -> new SlabBlock(Block.Properties.copy(AetherBiomesBlocks.CRYSTAL_PLANKS.get()).strength(0.5F)));
    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.SKYROOT_CRAFTING_TABLE.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.STRIPPED_CRYSTAL_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.STRIPPED_CRYSTAL_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AetherBiomesBlocks.CRYSTAL_SLAB.get(), 5, 20);
    }
    private static <T extends Block> RegistryObject<T> baseRegister(String name, Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> register = BLOCKS.register(name, block);
        AetherItems.ITEMS.register(name, item.apply(register));
        return register;
    }

    @SuppressWarnings("unchecked")
    private static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends Block> block) {
        return (RegistryObject<B>) baseRegister(name, block, AetherBiomesBlocks::registerBlockItem);
    }
    public static void registerWoodTypes() {
        WoodType.register(AetherBiomesWoodTypes.CRYSTAL);
    }
    private static <B extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<B> blockRegistryObject) {
        return () -> {
            B block = Objects.requireNonNull(blockRegistryObject.get());
            if (block == CRYSTAL_SIGN.get()) {
                return new SignItem((new Item.Properties()).stacksTo(16), CRYSTAL_SIGN.get(), CRYSTAL_WALL_SIGN.get());
            } else if (block == CRYSTAL_PLANKS.get()
                    || block == CRYSTAL_FENCE_GATE.get()
                    || block == CRYSTAL_FENCE.get()) {
                return new BurnableBlockItem(block, new Item.Properties());
            } else {
                return new BlockItem(block, new Item.Properties());
            }
        };
    }
}
