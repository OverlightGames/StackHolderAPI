package me.higherlevel.stackholderapi;

import me.higherlevel.stackholderapi.holders.StackHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;

public final class StackHolderAPI extends JavaPlugin {
    private static StackHolderAPI instance;

    public static StackHolderAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Commands.onEnable();
        getLogger().info("Enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().severe("Disabled.");
    }

    public static void openInventory(Player player, StackHolder holder) {
        Bukkit.getScheduler().runTaskLater(getInstance(), () -> player.openInventory(holder.getInventory()), 1L);
    }

    public static void closeInventory(Player player) {
        Bukkit.getScheduler().runTaskLater(getInstance(), () -> player.closeInventory(), 1L);
    }

    public static void setCursor(InventoryView view, @Nullable ItemStack item) {
        Bukkit.getScheduler().runTaskLater(getInstance(), () -> view.setCursor(item), 1L);
    }

    public static void updateInventory(Player player) {
        player.updateInventory();
    }

    public static void updateInventory(HumanEntity entity) {
        ((Player) entity).updateInventory();
    }
}