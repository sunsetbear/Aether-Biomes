package com.sunsette.aetherbiomes.world.feature;

import com.aetherteam.aether.Aether;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AetherBiomesFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Aether.MODID);
    public static RegistryObject<Feature<GeodeConfiguration>> ATMOSINE_GEODE = FEATURES.register("atmosine_geode", () -> new GeodeFeature(GeodeConfiguration.CODEC));
}
