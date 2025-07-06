package com.euphony.fungus_stew.neoforge.datagen;

import com.euphony.fungus_stew.FungusStew;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {
    private static HolderLookup.RegistryLookup<Item> registry = null;
    protected RecipeGenerator(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
        registry = registries.lookupOrThrow(Registries.ITEM);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new RecipeGenerator(registries, output);
        }

        @Override
        public String getName() {
            return "Fungus Stew's Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        ShapelessRecipeBuilder.shapeless(registry, RecipeCategory.FOOD, FungusStew.FUNGUS_STEW_ITEM.get())
                .requires(Items.CRIMSON_FUNGUS)
                .requires(Items.WARPED_FUNGUS)
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", has(Items.BOWL))
                .save(output, createKey("fungus_stew"));
    }

    protected ResourceKey<Recipe<?>> createKey(String name) {
        return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(FungusStew.MOD_ID, name));
    }
}