package me.higherlevel.stackholderapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class StackHolderAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        Commands.onEnable();
        getLogger().info("Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().severe("Disabled.");
    }
}