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
        AtomicBoolean jumpUsed = new AtomicBoolean(ABEquipmentUtil.alreadyUsedDoubleJump);
        boolean isjumpbuttondown = Minecraft.getInstance().options.keyJump.isDown();
        boolean oldJump = ABEquipmentUtil.prevPress;
        if(ABEquipmentUtil.jumpHeldTimer > 1){
            ABEquipmentUtil.prevPress = true;
        } else {
            ABEquipmentUtil.prevPress = false;
        }
        if(!isjumpbuttondown){
            ABEquipmentUtil.jumpHeldTimer = 0;
        } if (isjumpbuttondown) {
            ABEquipmentUtil.jumpHeldTimer += 1;
        }
        if (ABEquipmentUtil.hasFullAtmosineSet(entity)) {
            if (entity instanceof Player player && !player.getAbilities().flying) { // The player can't have creative flight enabled, otherwise it causes issues.
                AetherPlayer.get(player).ifPresent(aetherPlayer -> {
                    Vec3 deltaMovement = player.getDeltaMovement();
                    //AetherBiomes.LOGGER.warn("holy");
                    //if (!player.getLevel().isClientSide()) {
                        //AetherBiomes.LOGGER.warn("fucking");
                        if (!jumpUsed.get() && !oldJump && isjumpbuttondown && !player.isInWater() && !player.isInLava() && !player.isOnGround()) { // Checks if the player is off the ground and holding the jump key (space bar by default).
                            player.jumpFromGround();
                            player.push(0.0, 0.1, 0.0);
                            AetherBiomes.LOGGER.warn("bingle");
                            jumpUsed.set(true);
                        }
                        if (player.isOnGround()) { // Resets both timer and modifier if the player is on the ground.
                            jumpUsed.set(false);
                        }
                    //}

                    if (player instanceof ServerPlayer serverPlayer) { // Prevents the player from being kicked for flying.
                        ServerGamePacketListenerImplAccessor serverGamePacketListenerImplAccessor = (ServerGamePacketListenerImplAccessor) serverPlayer.connection;
                        serverGamePacketListenerImplAccessor.aether$setAboveGroundTickCount(0);
                    }
                });
            }
        }
    }
}
