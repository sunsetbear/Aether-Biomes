package com.sunsette.aetherbiomes.item.armor;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.client.AetherSoundEvents;
import com.sunsette.aetherbiomes.AetherBiomesTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import net.minecraft.Util;
import java.util.EnumMap;
import java.util.function.Supplier;

public enum AetherBiomesArmorMaterials implements ArmorMaterial {
    ATMOSINE("atmosine", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 1);
        map.put(ArmorItem.Type.LEGGINGS, 4);
        map.put(ArmorItem.Type.CHESTPLATE, 5);
        map.put(ArmorItem.Type.HELMET, 2);
    }), 9, AetherSoundEvents.ITEM_ARMOR_EQUIP_ZANITE, 0.0F, () -> Ingredient.of(AetherBiomesTags.Items.ATMOSINE_REPAIRING));

    private static final EnumMap<ArmorItem.Type, Integer> DURABILITY_MAP = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });

    private final String name;
    private final int maxDamageFactor;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmountMap;
    private final int enchantability;
    private final Supplier<SoundEvent> soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    AetherBiomesArmorMaterials(String name, int maxDamageFactor, EnumMap<ArmorItem.Type, Integer> protectionAmountMap, int enchantability, Supplier<SoundEvent> soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.protectionAmountMap = protectionAmountMap;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }
    @Override
    public int getDurabilityForType(ArmorItem.@NotNull Type type) {
        return DURABILITY_MAP.get(type) * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForType(ArmorItem.@NotNull Type type) {
        return this.protectionAmountMap.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.soundEvent.get();
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
