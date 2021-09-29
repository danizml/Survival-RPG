package survivalrpg;

//----------------------------------------------------------------------------------------------------------------------

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import survivalrpg.commands.PrimaryCommand;
import survivalrpg.events.items.Fly;
import survivalrpg.events.items.TeleportBow;
import survivalrpg.storage.TabulatorCompleter;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static survivalrpg.storage.LoggerMessage.LogLevel;
import static survivalrpg.storage.LoggerMessage.log;

//----------------------------------------------------------------------------------------------------------------------

public final class SurvivalRPG extends JavaPlugin {

    File configFile = new File(this.getDataFolder(), "config.yml");
    PluginDescriptionFile pdfFile = this.getDescription();
    private FileConfiguration messages = null;
    private FileConfiguration item = null;
    private File messagesFile = null;
    private File itemFile = null;
    public String rutaConfig;
    public String version;
    public String name;

    //-------------------------------------------------Enable-----------------------------------------------------------

    @Override
    public void onEnable() {
        this.version = this.pdfFile.getVersion();
        this.name = ChatColor.BLACK + "[" + ChatColor.DARK_RED + this.pdfFile.getName() + ChatColor.BLACK + "]" + ChatColor.WHITE;
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-----------------------{=}-----------------------+");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "The plugin version: " + version + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "The plugin " + name + " was Enable");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-----------------------{=}-----------------------+");
        this.registerCommands();
        this.registerMessages();
        this.registerEvents();
        this.registerItems();
        this.startPlugin();
    }
    //-------------------------------------------------Disable----------------------------------------------------------
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-----------------------{=}-----------------------+");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "The plugin version: " + version + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "The plugin " + name + " was Disable");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "+-----------------------{=}-----------------------+");
    }

    public void registerConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        this.rutaConfig = config.getPath();
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }

    public void startPlugin() {
        if (this.configFile.exists()) {
            log(LogLevel.SUCCESS, "Messages.yml has been initialised.");
            log(LogLevel.SUCCESS, "Config.yml has been initialised.");
        }
    }

    public void reloadPlugin() {
        if (this.configFile.exists()) {
            log(LogLevel.SUCCESS, "Messages.yml has been reloaded.");
            log(LogLevel.SUCCESS, "Config.yml has been reloaded.");
        }
    }

    public void registerCommands() {
        Objects.requireNonNull(this.getCommand("rpg")).setExecutor(new PrimaryCommand(this));
        Objects.requireNonNull(this.getCommand("rpg")).setTabCompleter(new TabulatorCompleter());
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Fly(this),this);
        pm.registerEvents(new TeleportBow(), this);
    }

    public FileConfiguration getMessages() {
        if (this.messages == null) {
            this.reloadMessages();
        }

        return this.messages;
    }
    public void reloadMessages() {
        if (this.messages == null) {
            this.messagesFile = new File(this.getDataFolder(), "messages.yml");
        }

        this.messages = YamlConfiguration.loadConfiguration(this.messagesFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(this.getResource("messages.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        this.messages.setDefaults(defConfig);
    }
    public void saveMessages() {
        try {
            this.messages.save(this.messagesFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
    public void registerMessages() {
        this.messagesFile = new File(this.getDataFolder(), "messages.yml");
        if (!this.messagesFile.exists()) {
            this.getMessages().options().copyDefaults(true);
            this.saveMessages();
        }
    }
    public FileConfiguration getItems() {
        if (this.item == null) {
            this.reloadItems();
        }

        return this.item;
    }
    public void reloadItems() {
        if (this.item == null) {
            this.itemFile = new File(this.getDataFolder(), "items.yml");
        }

        this.item = YamlConfiguration.loadConfiguration(this.itemFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(this.getResource("items.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        this.item.setDefaults(defConfig);
    }
    public void saveItems() {
        try {
            this.item.save(this.itemFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
    public void registerItems() {
        this.itemFile = new File(this.getDataFolder(), "items.yml");
        if (!this.itemFile.exists()) {
            this.getItems().options().copyDefaults(true);
            this.saveItems();
        }
    }
}
