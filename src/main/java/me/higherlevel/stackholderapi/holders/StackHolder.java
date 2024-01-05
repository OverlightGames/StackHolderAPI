package me.higherlevel.stackholderapi.holders;

import me.higherlevel.stackholderapi.StackHolderAPI;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class StackHolder implements InventoryHolder, Listener {
    public Inventory inventory;

    public void registerInventory(String id) {
        StackHolderManager.registerInventory(this, id);
        Bukkit.getPluginManager().registerEvents(this, StackHolderAPI.getInstance());
    }

    public StackHolder(InventoryType type) {
        inventory = Bukkit.createInventory(this, type);
    }

    public StackHolder(InventoryType type, String title) {
        inventory = Bukkit.createInventory(this, type, MiniMessage.miniMessage().deserialize(title));
    }

    public StackHolder(int rowCount) {
        inventory = Bukkit.createInventory(this, rowCount * 9);
    }

    public StackHolder(int rowCount, String title) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));
    }

    public StackHolder(int rowCount, String title, ItemStack fillItem) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, fillItem);
        }
    }

    public StackHolder(int rowCount, String title, ItemStack[] items) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));

        inventory.setContents(items);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
