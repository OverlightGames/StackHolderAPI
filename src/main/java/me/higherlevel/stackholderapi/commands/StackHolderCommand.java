package me.higherlevel.stackholderapi.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.LiteralArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import me.higherlevel.stackapi.commands.StackCommand;
import me.higherlevel.stackholderapi.holders.StackHolderInventoryManager;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class StackHolderCommand extends StackCommand {
    public StackHolderCommand() {
        //stackholder <id> [<player>]
        super(new CommandAPICommand("stackholder")
                .withArguments(new LiteralArgument("id").replaceSuggestions(ArgumentSuggestions.stringsAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> StackHolderInventoryManager.getIds().toArray(new String[0])))),
                        new PlayerArgument("player"))
                .executes((sender, args) -> {
                    String id = (String) args.get("id");
                    Player player = (Player) args.get("player");
                    if (StackHolderInventoryManager.fromId(id) == null) {
                        throw CommandAPI.failWithString("StackHolder with id '" + id + "' not found!");
                    }
                    player.openInventory(StackHolderInventoryManager.fromId(id).inventory);
                }),
                new CommandAPICommand("stackholder")
                        .withArguments(new LiteralArgument("id").replaceSuggestions(ArgumentSuggestions.stringsAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> StackHolderInventoryManager.getIds().toArray(new String[0])))))
                        .executesPlayer((sender, args) -> {
                            String id = (String) args.get("id");
                            if (StackHolderInventoryManager.fromId(id) == null) {
                                throw CommandAPI.failWithString("StackHolder with id '" + id + "' not found!");
                            }
                            sender.openInventory(StackHolderInventoryManager.fromId(id).inventory);
                        })
        );
    }
}
