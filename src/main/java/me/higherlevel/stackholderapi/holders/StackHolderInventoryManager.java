package me.higherlevel.stackholderapi.holders;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StackHolderInventoryManager {
    private static Map<String, StackHolderInventory> inventories = new HashMap<>();

    public static void registerInventory(@NotNull StackHolderInventory inventory, @NotNull String id) {
        inventories.put(id, inventory);
    }
}