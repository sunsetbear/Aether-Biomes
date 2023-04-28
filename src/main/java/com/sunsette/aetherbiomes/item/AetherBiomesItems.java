package com.sunsette.aetherbiomes.item;

import com.aetherteam.aether.Aether;
import net.minecraft.world.item.*;
import com.sunsette.aetherbiomes.item.tools.*;
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

    public static final RegistryObject<Item> ATMOSINE_SHARD = ITEMS.register("atmosine_shard", () -> new Item(new Item.Properties()));

}
