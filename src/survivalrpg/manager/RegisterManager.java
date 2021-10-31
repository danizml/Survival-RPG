package survivalrpg.manager;

import org.bukkit.plugin.PluginManager;
import survivalrpg.SurvivalRPG;
import survivalrpg.commands.PrimaryCommand;
import survivalrpg.events.items.FlyFeather;
import survivalrpg.events.items.TeleportBow;
import survivalrpg.menus.HelpMenu;
import survivalrpg.menus.PrimaryMenu;
import survivalrpg.storage.TabulatorCompleter;
import survivalrpg.warps.delwarp;
import survivalrpg.warps.setwarp;
import survivalrpg.warps.warp;

import java.util.Objects;

public class RegisterManager {


    public static void register() {
        registerYML();
        registerCommands();
        registerEvents();
        registerMenus();
        MessageManager.register();
        MessageManager.startPlugin();
    }

    public static void registerYML() {
        SurvivalRPG.getInstance().registerConfig();
        SurvivalRPG.getInstance().registerWarps();
        SurvivalRPG.getInstance().registerMessages();
        SurvivalRPG.getInstance().registerItems();
    }

    public static void registerCommands() {
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("rpgs")).setExecutor(new EconomyManager());
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("rpg")).setExecutor(new PrimaryCommand(SurvivalRPG.getInstance()));
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("rpg")).setTabCompleter(new TabulatorCompleter());
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("delwarp")).setExecutor(new delwarp());
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("warp")).setExecutor(new warp());
        Objects.requireNonNull(SurvivalRPG.getInstance().getCommand("setwarp")).setExecutor(new setwarp());
    }

    public static void registerEvents() {
        PluginManager pm = SurvivalRPG.getInstance().getServer().getPluginManager();
        pm.registerEvents(new FlyFeather(SurvivalRPG.getInstance()),SurvivalRPG.getInstance());
        pm.registerEvents(new TeleportBow(), SurvivalRPG.getInstance());
    }

    public static void registerMenus() {
        PluginManager pm = SurvivalRPG.getInstance().getServer().getPluginManager();
        pm.registerEvents(new PrimaryMenu(), SurvivalRPG.getInstance());
        pm.registerEvents(new HelpMenu(), SurvivalRPG.getInstance());
    }
}
