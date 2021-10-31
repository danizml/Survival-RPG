package survivalrpg.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import survivalrpg.SurvivalRPG;
import survivalrpg.storage.LoggerMessage;

import java.io.File;

import static survivalrpg.storage.LoggerMessage.log;

public class MessageManager {
    public static File configFile = new File(SurvivalRPG.getInstance().getDataFolder(), "config.yml");

    public static void register() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-------------------------------------------------+");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE +      "+     The plugin version: " + SurvivalRPG.getInstance().version + "         +");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE +      "+     The plugin " + SurvivalRPG.getInstance().name + " was Enable          +");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-------------------------------------------------+");
    }

    public static void reloadPlugin() {
        if (configFile.exists()) {
            SurvivalRPG.getInstance().reloadItems();
            SurvivalRPG.getInstance().reloadMessages();
            SurvivalRPG.getInstance().reloadWarps();
            SurvivalRPG.plugin.reloadConfig();
            log(LoggerMessage.LogLevel.SUCCESS, "Messages.yml has been reloaded.");
            log(LoggerMessage.LogLevel.SUCCESS, "Config.yml has been reloaded.");
        }
    }

    public static void startPlugin() {
        if (configFile.exists()) {
            log(LoggerMessage.LogLevel.SUCCESS, "Messages.yml has been initialised.");
            log(LoggerMessage.LogLevel.SUCCESS, "Config.yml has been initialised.");
        }
    }

    public static void unregister() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+----------------------------------------------+");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE +      "+                  See you leter               +");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+----------------------------------------------+");
    }
}
