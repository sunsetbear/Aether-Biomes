package com.sunsette.aetherbiomes.block.portal;

import com.aetherteam.aether.capability.player.AetherPlayerCapability;
import com.aetherteam.aether.client.AetherSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AetherBiomesPortalSoundsTrigger extends AetherPlayerCapability {

    public AetherBiomesPortalSoundsTrigger(Player player) {
        super(player);
    }
    @OnlyIn(Dist.CLIENT)
    private void playPortalSound(Minecraft mc) {
        mc.getSoundManager().play(SimpleSoundInstance.forLocalAmbience(AetherSoundEvents.BLOCK_AETHER_PORTAL_TRIGGER.get(), 1.0F, 1.0F));
    }
}
