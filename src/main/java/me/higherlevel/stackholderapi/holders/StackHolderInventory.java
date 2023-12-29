package me.higherlevel.stackholderapi.holders;

import me.higherlevel.stackapi.items.StackItem;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class StackHolderInventory implements InventoryHolder {
    public Inventory inventory;

    public void registerInventory(String id) {
        StackHolderInventoryManager.registerInventory(this, id);
    }

    public StackHolderInventory(int rowCount, String title) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));
    }

    public StackHolderInventory(int rowCount, String title, ItemStack fillItem) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, fillItem);
        }
    }

    public StackHolderInventory(int rowCount, String title, List<ItemStack> items) {
        inventory = Bukkit.createInventory(this, rowCount * 9, MiniMessage.miniMessage().deserialize(title));

        for (int i = 0; i < items.size(); i++) {
            inventory.setItem(i, items.get(i));
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
