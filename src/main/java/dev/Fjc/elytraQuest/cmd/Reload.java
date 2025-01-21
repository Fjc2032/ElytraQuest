package dev.Fjc.elytraQuest.cmd;

import dev.Fjc.elytraQuest.ElytraQuest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equals("elytraquestapi-reload") && commandSender.hasPermission("odailyquests.admin")) {
            JavaPlugin.getPlugin(ElytraQuest.class).reloadConfig();
            commandSender.sendMessage("Configuration reload success.");
            return true;
        }
        return false;
    }
}
