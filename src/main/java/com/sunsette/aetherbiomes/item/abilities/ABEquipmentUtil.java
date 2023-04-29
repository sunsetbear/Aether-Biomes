package com.sunsette.aetherbiomes.item.abilities;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import com.sunsette.aetherbiomes.item.AetherBiomesItems;
import net.minecraft.world.entity.LivingEntity;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

public class ABEquipmentUtil {
    public static boolean hasFullAtmosineSet(LivingEntity entity) {
        return hasArmorSet(entity, AetherBiomesItems.ATMOSINE_HELMET.get(), AetherBiomesItems.ATMOSINE_CHESTPLATE.get(), AetherBiomesItems.ATMOSINE_LEGGINGS.get(), AetherBiomesItems.ATMOSINE_BOOTS.get(), AetherBiomesItems.ATMOSINE_GLOVES.get());
    }
    static boolean alreadyUsedDoubleJump = false;
    private static boolean hasArmorSet(LivingEntity entity, Item helmet, Item chestplate, Item leggings, Item boots, Item gloves) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(helmet)
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(chestplate)
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(leggings)
                && entity.getItemBySlot(EquipmentSlot.FEET).is(boots)
                && CuriosApi.getCuriosHelper().findFirstCurio(entity, gloves).isPresent();
    }

}
