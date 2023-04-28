package com.sunsette.aetherbiomes.item.tools;

import com.sunsette.aetherbiomes.item.AetherBiomesItemTiers;
import com.sunsette.aetherbiomes.procedures.AtmosineSwordHitProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public class AtmosineSwordItem extends SwordItem {
    public AtmosineSwordItem() {
        super(AetherBiomesItemTiers.ATMOSINE, 3, -2.4F, new Item.Properties());
    }
    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        AtmosineSwordHitProcedure.execute(entity);
        return retval;
    }
}
