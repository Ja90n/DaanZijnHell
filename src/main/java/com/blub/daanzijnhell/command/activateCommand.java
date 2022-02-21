package com.blub.daanzijnhell.command;

import com.blub.daanzijnhell.Daanzijnhell;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class activateCommand implements CommandExecutor {

    private Daanzijnhell daanzijnhell;
    public activateCommand(Daanzijnhell daanzijnhell) {
        this.daanzijnhell = daanzijnhell;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            switch (args[0]){
                case "isactive":
                    sender.sendMessage(ChatColor.RED + "Daan zijn hell is " + ChatColor.WHITE + daanzijnhell.getIsActive());
                    break;
                case "start":
                    if (daanzijnhell.getIsActive()) {
                        sender.sendMessage(ChatColor.DARK_RED + "Daan zijn hell is already active");
                    } else {
                        sender.sendMessage(ChatColor.RED + "Activated Daan zijn Hell");
                        daanzijnhell.isActive = true;
                    }
                    break;
                case "stop":
                    if (!daanzijnhell.getIsActive()){
                        sender.sendMessage(ChatColor.DARK_RED + "Daan zijn hell is already inactive");
                    } else {
                        sender.sendMessage(ChatColor.BLUE + "Deactivated Daan zijn Hell");
                        daanzijnhell.isActive = false;
                    }
                    break;
                case "difficulty":
                    switch (daanzijnhell.getDifficulty()){
                        case 0:
                            sender.sendMessage(ChatColor.BLUE + "The difficulty is" + ChatColor.WHITE + " easy!");
                            break;
                        case 1:
                            sender.sendMessage(ChatColor.BLUE + "The difficulty is" + ChatColor.WHITE + " medium!");
                            break;
                        case 2:
                            sender.sendMessage(ChatColor.BLUE + "The difficulty is" + ChatColor.WHITE + " hard!");
                            break;
                        case 3:
                            sender.sendMessage(ChatColor.BLUE + "The difficulty is" + ChatColor.DARK_RED + " impossible!");
                            break;
                        }
            }
        } else if (args.length == 2){
            if (args[0].equals("difficulty")){
                if (args[1].equals("0") || args[1].equals("easy")){
                    sender.sendMessage(ChatColor.BLUE + "You have set the difficulty too" + ChatColor.WHITE + " easy!");
                } else if (args[1].equals("1") || args[1].equals("medium")) {
                    sender.sendMessage(ChatColor.BLUE + "You have set the difficulty too" + ChatColor.WHITE + " medium!");
                } else if (args[1].equals("3") || args[1].equals("hard")){
                    sender.sendMessage(ChatColor.BLUE + "You have set the difficulty too" + ChatColor.WHITE + " hard!");
                } else if (args[1].equals("4") || args[1].equals("impossible")){
                    sender.sendMessage(ChatColor.BLUE + "You have set the difficulty too" + ChatColor.DARK_RED + " impossible!");
                } else {
                    sentHelplist(sender);
                }
            }
        }
        return false;
    }

    public void sentHelplist (CommandSender sender){
        sender.sendMessage(ChatColor.BLUE + "-------------------------" + ChatColor.RED + "+" + ChatColor.BLUE + "-------------------------");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "/daanzijnhell start:" + ChatColor.WHITE + " activates the plugin");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "/daanzijnhell stop:" + ChatColor.WHITE + " deactivates the plugin");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "/daanzijnhell difficulty:" + ChatColor.WHITE + " sets the difficulty for the plugin");
        sender.sendMessage(ChatColor.BLUE + "-------------------------" + ChatColor.RED + "+" + ChatColor.BLUE + "-------------------------");
    }
}