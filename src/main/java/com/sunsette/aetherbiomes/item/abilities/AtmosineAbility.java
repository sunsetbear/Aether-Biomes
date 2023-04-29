package com.sunsette.aetherbiomes.item.abilities;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.mixin.mixins.common.accessor.ServerGamePacketListenerImplAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.player.Input;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.client.player.Input.*;

public interface AtmosineAbility {
    static void handleJump(LivingEntity entity) {
        if (ABEquipmentUtil.hasFullAtmosineSet(entity)) {
            if (entity instanceof Player player && !player.getAbilities().flying) { // The player can't have creative flight enabled, otherwise it causes issues.
                AetherPlayer.get(player).ifPresent(aetherPlayer -> {
                    Vec3 deltaMovement = player.getDeltaMovement();
                    if (!player.getLevel().isClientSide()) { // Updates the flight modifier and timer values.
                        if (aetherPlayer.isJumping() && !player.isOnGround() && usedDJ) { // Checks if the player is off the ground and holding the jump key (space bar by default).
                            aetherPlayer.setFlightTimer(0);
                            entity.push(0.0, 0.5, 0.0);
                            ABEquipmentUtil.alreadyUsedDoubleJump = true;
                        }
                        if (player.isOnGround()) { // Resets both timer and modifier if the player is on the ground.
                            aetherPlayer.setFlightTimer(0);
                            aetherPlayer.setFlightModifier(1.0F);
                            ABEquipmentUtil.alreadyUsedDoubleJump = false;
                        }
                    }

                    if (player instanceof ServerPlayer serverPlayer) { // Prevents the player from being kicked for flying.
                        ServerGamePacketListenerImplAccessor serverGamePacketListenerImplAccessor = (ServerGamePacketListenerImplAccessor) serverPlayer.connection;
                        serverGamePacketListenerImplAccessor.aether$setAboveGroundTickCount(0);
                    }
                });
            }
        }
    }
    boolean usedDJ = ABEquipmentUtil.alreadyUsedDoubleJump;
}
