package Util;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;

public class PlayerData {
    String name;
    long lastDeath = 0;

    private static final HashMap<String, PlayerData> players = new HashMap<>();

    public PlayerData(String name, long lastDeath) {
        this.name = name;
        this.lastDeath = lastDeath;
    }

    public void setLastDeath() {
        this.lastDeath = System.currentTimeMillis();
    }

    public long getLastDeath() {
        return this.lastDeath;
    }

    public static long getLastDeathByName(String name) {
        return players.get(name).getLastDeath();
    }

    public static void setLastDeathByName(String name) {
        players.get(name).setLastDeath();
    }

    public static void onPlayerJoin(ServerPlayer player) {
        if (!PlayerData.players.containsKey(player.getName().getString())) {
            players.put(player.getName().getString(), new PlayerData(player.getName().getString(), 0));
        }
    }
}
