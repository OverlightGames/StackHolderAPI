package me.higherlevel.stackholderapi.holders;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StackHolderManager {
    private static Map<String, StackHolder> inventories = new HashMap<>();

    public static void registerInventory(@NotNull StackHolder inventory, @NotNull String id) {
        inventories.put(id, inventory);
    }

    public static StackHolder fromId(String id) {
        return inventories.get(id);
    }

    public static Collection<String> getIds() {
        return inventories.keySet();
    }
}