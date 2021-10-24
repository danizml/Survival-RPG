package survivalrpg;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import survivalrpg.manager.EconomyManager;
import survivalrpg.manager.RegisterManager;
import survivalrpg.manager.UnregisterManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class SurvivalRPG extends JavaPlugin {
    private FileConfiguration messages = null;
    private FileConfiguration item = null;
    private File messagesFile = null;
    private FileConfiguration warps = null;
    private File warpsFile = null;
    private File itemFile = null;
    public static String rutaConfig;

    PluginDescriptionFile pdfFile = this.getDescription();
    private static SurvivalRPG INSTANCE;
    public static SurvivalRPG plugin;
    public String version;
    public String name;

    @Override
    public void onEnable() {
        this.name = ChatColor.BLACK + "[" + ChatColor.DARK_RED + this.pdfFile.getName() + ChatColor.BLACK + "]" + ChatColor.WHITE;
        this.version = this.pdfFile.getVersion();
        INSTANCE = this;
        EconomyManager.registerEconomy();
        RegisterManager.register();
    }

    @Override
    public void onDisable() {
        UnregisterManager.unregister();
    }

    public static SurvivalRPG getInstance() {
        return INSTANCE;
    }

    public void registerConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        rutaConfig = config.getPath();
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }

    public FileConfiguration getMessages() {
        if (messages == null) {
            reloadMessages();
        }return messages;
    }

    public void reloadMessages() {
        if (messages == null) {
            messagesFile = new File(this.getDataFolder(), "messages.yml");
        }

        messages = YamlConfiguration.loadConfiguration(messagesFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(this.getResource("messages.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        messages.setDefaults(defConfig);
    }

    public void saveMessages() {
        try {
            messages.save(messagesFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void registerMessages() {
        messagesFile = new File(this.getDataFolder(), "messages.yml");
        if (!messagesFile.exists()) {
            getMessages().options().copyDefaults(true);
            saveMessages();
        }
    }

    public FileConfiguration getItems() {
        if (item == null) {
            reloadItems();
        }return item;
    }

    public void reloadItems() {
        if (item == null) {
            itemFile = new File(this.getDataFolder(), "items.yml");
        }

        item = YamlConfiguration.loadConfiguration(itemFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(this.getResource("items.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        item.setDefaults(defConfig);
    }
    public void saveItems() {
        try {
            item.save(itemFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
    public void registerItems() {
        itemFile = new File(this.getDataFolder(), "items.yml");
        if (!itemFile.exists()) {
            getItems().options().copyDefaults(true);
            saveItems();
        }
    }

    public FileConfiguration getWarps() {
        if (warps == null) {
            reloadItems();
        }

        return warps;
    }

    public void reloadWarps() {
        if (warps == null) {
            warpsFile = new File(this.getDataFolder(), "warps.yml");
        }

        warps = YamlConfiguration.loadConfiguration(warpsFile);
        Reader defConfigStream = new InputStreamReader((Objects.requireNonNull(this.getResource("warps.yml"))), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        warps.setDefaults(defConfig);
    }

    public void saveWarps() {
        try {
            warps.save(warpsFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void registerWarps() {
        warpsFile = new File(this.getDataFolder(), "warps.yml");
        if (!warpsFile.exists()) {
            getItems().options().copyDefaults(true);
            saveItems();
        }
    }
}