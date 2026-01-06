package notalizard.mediumcore_adventure.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import notalizard.mediumcore_adventure.MediumcoreAdventureMod;
import notalizard.mediumcore_adventure.misc.MediumcoreDataManager;

public class CommonEvents {

    public static void onInitialize(){
        ServerPlayerEvents.AFTER_RESPAWN.register((ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) -> {
            //TODO: check gamerule
            double currentMax = MediumcoreDataManager.getMaxHp(newPlayer.getUuid(), newPlayer.getEntityWorld().getServer());
            applyMaxHp(newPlayer, currentMax);
        });
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if(!(entity instanceof ServerPlayerEntity player)) return;
            //TODO: check gamerule

            double currentMax = MediumcoreDataManager.getMaxHp(player.getUuid(), player.getEntityWorld().getServer());
            double clampedHealth = Math.clamp(currentMax - MediumcoreAdventureMod.CONFIG.healthDecreasePerDeath, MediumcoreAdventureMod.CONFIG.minimumPlayerHealth, MediumcoreAdventureMod.CONFIG.maxPlayerHealth);
            MediumcoreDataManager.setMaxHp(player.getUuid(), player.getEntityWorld().getServer(), clampedHealth);
        });
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            //TODO: check gamerule
            double currentMax = MediumcoreDataManager.getMaxHp(handler.player.getUuid(), handler.player.getEntityWorld().getServer());
            applyMaxHp(handler.player, currentMax);
        });
    }

    public static void applyMaxHp (ServerPlayerEntity player, double health){
        double diff = health - 20.0D;
        EntityAttributeInstance maxHpAttr = player.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        maxHpAttr.overwritePersistentModifier(new EntityAttributeModifier(Identifier.of(MediumcoreAdventureMod.MOD_ID, "mediumcore_max_hp_adjustment"), diff, EntityAttributeModifier.Operation.ADD_VALUE));
        player.setHealth(Math.clamp(player.getHealth(), 0, player.getMaxHealth()));
    }
}
