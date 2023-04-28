package com.sunsette.aetherbiomes.item.tools;

import com.sunsette.aetherbiomes.item.AetherBiomesItemTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class AtmosineAxeItem extends AxeItem {
    public AtmosineAxeItem() {
        super(AetherBiomesItemTiers.ATMOSINE, 5.0F, -3.0F, new Item.Properties());
    }
}
