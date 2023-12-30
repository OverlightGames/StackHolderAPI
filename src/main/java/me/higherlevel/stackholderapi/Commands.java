package me.higherlevel.stackholderapi;

import me.higherlevel.stackholderapi.commands.StackHolderCommand;

public class Commands {
    public static void onEnable() {
        new StackHolderCommand();
    }
}
