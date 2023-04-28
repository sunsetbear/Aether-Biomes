package com.sunsette.aetherbiomes;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.AetherTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AetherBiomesTags extends AetherTags {
    public static class Items {
        public static final TagKey<Item> ATMOSINE_REPAIRING = tag("atmosine_repairing");
        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(Aether.MODID, name));
        }
    }

}
