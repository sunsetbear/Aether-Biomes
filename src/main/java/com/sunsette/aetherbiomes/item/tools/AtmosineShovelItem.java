package com.sunsette.aetherbiomes.item.tools;

import com.sunsette.aetherbiomes.item.AetherBiomesItemTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class AtmosineShovelItem extends ShovelItem {
    public AtmosineShovelItem() {
        super(AetherBiomesItemTiers.ATMOSINE, 1.5f, -3.0f, new Item.Properties());
    }
}
