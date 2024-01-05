package me.higherlevel.stackholderapi.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import me.higherlevel.stackapi.commands.StackCommand;
import me.higherlevel.stackholderapi.holders.StackHolderManager;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class StackHolderCommand extends StackCommand {
    public StackHolderCommand() {
        //stackholder <id> [<player>]
        super(new CommandAPICommand("stackholder")
                .withArguments(new StringArgument("id").replaceSuggestions(ArgumentSuggestions.stringsAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> StackHolderManager.getIds().toArray(new String[0])))),
                        new PlayerArgument("player"))
                .executes((sender, args) -> {
                    String id = (String) args.get("id");
                    Player player = (Player) args.get("player");
                    if (StackHolderManager.fromId(id) == null) {
                        throw CommandAPI.failWithString("StackHolder with id '" + id + "' not found!");
                    }
                    player.openInventory(StackHolderManager.fromId(id).inventory);
                }),
                new CommandAPICommand("stackholder")
                        .withArguments(new StringArgument("id").replaceSuggestions(ArgumentSuggestions.stringsAsync(commandSenderSuggestionInfo -> CompletableFuture.supplyAsync(() -> StackHolderManager.getIds().toArray(new String[0])))))
                        .executesPlayer((sender, args) -> {
                            String id = (String) args.get("id");
                            if (StackHolderManager.fromId(id) == null) {
                                throw CommandAPI.failWithString("StackHolder with id '" + id + "' not found!");
                            }
                            sender.openInventory(StackHolderManager.fromId(id).inventory);
                        })
        );
    }
}
