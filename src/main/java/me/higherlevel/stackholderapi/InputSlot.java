package me.higherlevel.stackholderapi;

import me.higherlevel.stackapi.items.StackItem;
import me.higherlevel.stackholderapi.holders.StackHolder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryHolder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InputSlot {
    public int index;
    public StackHolder holder;
    public boolean isBlacklist;
    public List<Material> materials = new ArrayList<>();
    public List<StackItem> items = new ArrayList<>();

    public InputSlot(int index, @Nullable Collection<Material> materials, @Nullable Collection<StackItem> items, boolean isBlacklist) {
        this.index = index;
        this.isBlacklist = isBlacklist;
        if (materials != null) this.materials.addAll(materials);
        if (items != null) this.items.addAll(items);
    }
}
