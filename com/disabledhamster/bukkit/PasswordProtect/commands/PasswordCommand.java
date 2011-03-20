package com.disabledhamster.bukkit.PasswordProtect.commands;

import com.disabledhamster.bukkit.PasswordProtect.PasswordProtect;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PasswordCommand implements CommandExecutor {

    private final PasswordProtect plugin;

    public PasswordCommand(PasswordProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Only server ops can use this command");
            return true;
        }

        String serverPassword = plugin.getPassword();
        if (serverPassword == null) {
            sender.sendMessage(ChatColor.YELLOW + "Server password is not set. Use /setpassword <password>");
        } else {
            sender.sendMessage(ChatColor.YELLOW + "Server password is " + plugin.getPassword());
        }
        return true;
    }
}