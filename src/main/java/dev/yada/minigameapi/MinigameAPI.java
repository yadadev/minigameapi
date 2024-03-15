package dev.yada.minigameapi;

import org.bukkit.plugin.java.JavaPlugin;

public class MinigameAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        new MinigameHandler();

    }

    @Override
    public void onDisable() {
        MinigameHandler.getInstance().cleanupAllMinigames();
    }
}
