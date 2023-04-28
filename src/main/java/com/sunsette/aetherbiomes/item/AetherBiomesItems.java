package com.sunsette.aetherbiomes.item;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.item.combat.AetherArmorItem;
import net.minecraft.world.item.*;
import com.sunsette.aetherbiomes.item.tools.*;
import com.sunsette.aetherbiomes.item.armor.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AetherBiomesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Aether.MODID);
    public static final RegistryObject<PickaxeItem> ATMOSINE_PICKAXE = ITEMS.register("atmosine_pickaxe", AtmosinePickaxeItem::new);
    public static final RegistryObject<AxeItem> ATMOSINE_AXE = ITEMS.register("atmosine_axe",AtmosineAxeItem::new);
    public static final RegistryObject<ShovelItem> ATMOSINE_SHOVEL = ITEMS.register("atmosine_shovel", AtmosineShovelItem::new);
    public static final RegistryObject<HoeItem> ATMOSINE_HOE = ITEMS.register("atmosine_hoe", AtmosineHoeItem::new);
    public static final RegistryObject<SwordItem> ATMOSINE_SWORD = ITEMS.register("atmosine_sword", AtmosineSwordItem::new);
    public static final RegistryObject<Item> ATMOSINE_HELMET = ITEMS.register("atmosine_helmet", () -> new AetherArmorItem(AetherBiomesArmorMaterials.ATMOSINE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ATMOSINE_CHESTPLATE = ITEMS.register("atmosine_chestplate", () -> new AetherArmorItem(AetherBiomesArmorMaterials.ATMOSINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ATMOSINE_LEGGINGS = ITEMS.register("atmosine_leggings", () -> new AetherArmorItem(AetherBiomesArmorMaterials.ATMOSINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ATMOSINE_BOOTS = ITEMS.register("atmosine_boots", () -> new AetherArmorItem(AetherBiomesArmorMaterials.ATMOSINE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> ATMOSINE_SHARD = ITEMS.register("atmosine_shard", () -> new Item(new Item.Properties()));

}
