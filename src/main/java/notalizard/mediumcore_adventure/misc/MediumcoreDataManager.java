package notalizard.mediumcore_adventure.misc;

import eu.pb4.playerdata.api.PlayerDataApi;
import eu.pb4.playerdata.api.storage.JsonDataStorage;
import eu.pb4.playerdata.api.storage.PlayerDataStorage;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import notalizard.mediumcore_adventure.MediumcoreAdventureMod;

import java.util.UUID;

import static notalizard.mediumcore_adventure.event.CommonEvents.applyMaxHp;

public class MediumcoreDataManager
{
    public static final PlayerDataStorage<MediumcoreData> MEDIUMCORE_DATA_STORAGE = new JsonDataStorage<>("mediumcore", MediumcoreData.class);

    public static void init() {
        PlayerDataApi.register(MEDIUMCORE_DATA_STORAGE);
    }

    public static double getMaxHp(UUID uuid, MinecraftServer server) {
        MediumcoreData data = PlayerDataApi.getCustomDataFor(server, uuid, MEDIUMCORE_DATA_STORAGE);
        return data != null ? data.mediumcoreHealth : MediumcoreAdventureMod.CONFIG.startingPlayerHealth;
    }

    public static boolean setMaxHp(UUID uuid, MinecraftServer server, double health) {
        if (getMaxHp(uuid, server) == health) return false;
        ServerPlayerEntity player = server.getPlayerManager().getPlayer(uuid);
        boolean isOnline = player != null;
        if (isOnline) {
            applyMaxHp(player, health);
        }
        MediumcoreData data = PlayerDataApi.getCustomDataFor(server, uuid, MEDIUMCORE_DATA_STORAGE);
        if (data == null) data = new MediumcoreData();
        data.mediumcoreHealth = health;
        PlayerDataApi.setCustomDataFor(server, uuid, MEDIUMCORE_DATA_STORAGE, data);
        return true;
    }


}

