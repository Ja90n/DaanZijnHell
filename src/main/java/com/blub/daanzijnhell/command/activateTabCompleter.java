package com.blub.daanzijnhell.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class activateTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> result = new ArrayList<>();
        if (args.length == 1){
        } if (args.length == 2){
            if (args[1].equals("difficulty")){
                result.add("easy");
                result.add("medium");
                result.add("hard");
                result.add("impossible");
            }
        }
        return result;
    }
}
