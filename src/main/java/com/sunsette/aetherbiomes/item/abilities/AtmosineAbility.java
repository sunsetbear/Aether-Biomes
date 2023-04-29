package com.sunsette.aetherbiomes.item.abilities;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.mixin.mixins.common.accessor.ServerGamePacketListenerImplAccessor;
import com.sunsette.aetherbiomes.AetherBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.concurrent.atomic.AtomicBoolean;

public interface AtmosineAbility {

    static void handleJump(LivingEntity entity) {
        boolean jumpUsed = (ABEquipmentUtil.alreadyUsedDoubleJump);
        boolean isjumpbuttondown = Minecraft.getInstance().options.keyJump.isDown();
        boolean oldJump = ABEquipmentUtil.canJump;
        //debugs

        if (jumpUsed){
            AetherBiomes.LOGGER.warn("jumpUsed");
        }
        if (ABEquipmentUtil.hasFullAtmosineSet(entity)) {
            Player player = Minecraft.getInstance().player;
                if (player != null && !player.getAbilities().flying) { // The player can't have creative flight enabled, otherwise it causes issues.
                    //AetherPlayer.get(player).ifPresent(aetherPlayer -> {
                        Vec3 deltaMovement = player.getDeltaMovement();
                        //if (!player.getLevel().isClientSide()) { // Updates the flight modifier and timer values.
                            if(isjumpbuttondown){
                                ABEquipmentUtil.jumpHeldTimer++;
                            } else {
                                ABEquipmentUtil.jumpHeldTimer = 0;
                            }
                            if(ABEquipmentUtil.jumpHeldTimer < 2){
                                ABEquipmentUtil.canJump = true;
                                AetherBiomes.LOGGER.warn("canJump");
                            } else {
                                ABEquipmentUtil.canJump = false;
                            }
                            if (!ABEquipmentUtil.alreadyUsedDoubleJump && isjumpbuttondown && !player.isOnGround() && !player.isInWater() && !player.isInLava()) { // Checks if the player is off the ground and holding the jump key (space bar by default).
                                if (ABEquipmentUtil.timeSinceGround > 3) { // Starts allowing the player to jump after a 3 tick delay of being off the ground.
                                    if (ABEquipmentUtil.canJump) { // Allows the player to fly until the maximum value is hit.
                                        player.jumpFromGround();
                                        player.push(0.0, 0.1, 0.0);
                                        AetherBiomes.LOGGER.warn("bingle");
                                        ABEquipmentUtil.alreadyUsedDoubleJump = true;
                                    }
                                }
                            }
                            if (player.isOnGround()) { // Resets both timer and modifier if the player is on the ground.
                                //aetherPlayer.setFlightTimer(0);
                                //aetherPlayer.setFlightModifier(1.0F);
                                ABEquipmentUtil.alreadyUsedDoubleJump = false;
                                ABEquipmentUtil.timeSinceGround = 0;
                            } else {
                                ABEquipmentUtil.timeSinceGround++;
                            }
                        //}
                        // Modifies the player's upwards movement based on the set flight modifier and timer values.
                        //if (aetherPlayer.isJumping() && !player.isOnGround() && aetherPlayer.getFlightTimer() > 2 && aetherPlayer.getFlightTimer() < aetherPlayer.getFlightTimerMax() && aetherPlayer.getFlightModifier() > 1.0F) {
                        //    player.setDeltaMovement(deltaMovement.x(), 0.025F * aetherPlayer.getFlightModifier(), deltaMovement.z());
                        //}
                        if (player instanceof ServerPlayer serverPlayer) { // Prevents the player from being kicked for flying.
                            ServerGamePacketListenerImplAccessor serverGamePacketListenerImplAccessor = (ServerGamePacketListenerImplAccessor) serverPlayer.connection;
                            serverGamePacketListenerImplAccessor.aether$setAboveGroundTickCount(0);
                        }
                    //});
                }

        }
    }
}
