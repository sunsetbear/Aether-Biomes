package com.sunsette.aetherbiomes.data.generators;
import com.aetherteam.aether.Aether;
import com.aetherteam.aether.api.AetherMoaTypes;
import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.data.providers.AetherRecipeProvider;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.AetherTags;
import com.sunsette.aetherbiomes.block.AetherBiomesBlocks;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraftforge.common.Tags;

import java.util.Map;
import java.util.function.Consumer;

public class AetherBiomesRecipeData extends AetherRecipeProvider {
    public AetherBiomesRecipeData(PackOutput output) {
        super(output, Aether.MODID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        woodFromLogs(consumer, AetherBiomesBlocks.CRYSTAL_WOOD.get(), AetherBiomesBlocks.CRYSTAL_LOG.get());
        woodFromLogs(consumer, AetherBiomesBlocks.STRIPPED_CRYSTAL_WOOD.get(), AetherBiomesBlocks.STRIPPED_CRYSTAL_LOG.get());
        planksFromLogs(consumer, AetherBiomesBlocks.CRYSTAL_PLANKS.get(), AetherTags.Items.CRAFTS_SKYROOT_PLANKS, 4);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AetherBiomesBlocks.CRYSTAL_SIGN.get(), 3)
                .group("wooden_sign")
                .define('P', AetherBiomesBlocks.CRYSTAL_PLANKS.get().asItem())
                .define('/', Tags.Items.RODS_WOODEN)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .save(consumer);

        fence(AetherBiomesBlocks.CRYSTAL_FENCE, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);
        fenceGate(AetherBiomesBlocks.CRYSTAL_FENCE_GATE, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);

        stairs(AetherBiomesBlocks.CRYSTAL_STAIRS, AetherBiomesBlocks.CRYSTAL_PLANKS).group("wooden_stairs").save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AetherBiomesBlocks.CRYSTAL_SLAB.get(), Ingredient.of(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .group("wooden_slab")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AetherBlocks.SKYROOT_BOOKSHELF.get(), 1)
                .define('P', AetherBiomesBlocks.CRYSTAL_PLANKS.get())
                .define('B', Items.BOOK)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AetherBlocks.SKYROOT_BED.get(), 1)
                .define('W', ItemTags.WOOL)
                .define('P', AetherBiomesBlocks.CRYSTAL_PLANKS.get())
                .pattern("WWW")
                .pattern("PPP")
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(consumer);


        makePickaxeWithBlock(AetherItems.SKYROOT_PICKAXE, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);
        makeAxeWithBlock(AetherItems.SKYROOT_AXE, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);
        makeShovelWithBlock(AetherItems.SKYROOT_SHOVEL, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);
        makeHoeWithBlock(AetherItems.SKYROOT_HOE, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);

        makeSwordWithBlock(AetherItems.SKYROOT_SWORD, AetherBiomesBlocks.CRYSTAL_PLANKS).save(consumer);

                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AetherItems.GOLDEN_DART_SHOOTER.get(), 1)
                .define('P', AetherBiomesBlocks.CRYSTAL_PLANKS.get())
                .define('G', AetherItems.GOLDEN_AMBER.get())
                .pattern("P")
                .pattern("P")
                .pattern("G")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                        .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .save(consumer);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AetherItems.SKYROOT_STICK.get(), 4)
                .group("sticks")
                .define('#', AetherBiomesBlocks.CRYSTAL_PLANKS.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AetherItems.SKYROOT_BUCKET.get(), 1)
                .define('#', AetherBiomesBlocks.CRYSTAL_PLANKS.get())
                .pattern("# #")
                .pattern(" # ")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .save(consumer);


        doorBuilder(AetherBiomesBlocks.CRYSTAL_DOOR.get(), Ingredient.of(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).group("wooden_door").save(consumer);
        trapdoorBuilder(AetherBiomesBlocks.CRYSTAL_TRAPDOOR.get(), Ingredient.of(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).group("wooden_trapdoor").save(consumer);
        buttonBuilder(AetherBiomesBlocks.CRYSTAL_BUTTON.get(), Ingredient.of(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, AetherBiomesBlocks.CRYSTAL_PRESSURE_PLATE.get(), Ingredient.of(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

         ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.BARREL, 1)
                .group("minecraft:barrel")
                .define('P', AetherTags.Items.PLANKS_CRAFTING)
                .define('H', ItemTags.WOODEN_SLABS)
                .pattern("PHP")
                .pattern("P P")
                .pattern("PHP")
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_PLANKS.get()), has(AetherBiomesBlocks.CRYSTAL_PLANKS.get()))
                .unlockedBy(getHasName(AetherBiomesBlocks.CRYSTAL_SLAB.get()), has(AetherBiomesBlocks.CRYSTAL_SLAB.get()))
                .save(consumer, name("crystal_barrel"));



    }
}
