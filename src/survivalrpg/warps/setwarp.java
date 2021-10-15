package survivalrpg.warps;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;

public class setwarp implements CommandExecutor {

    public final SurvivalRPG plugin;

    public setwarp(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("[c] Player only command!");
        }

        Player p = (Player) commandSender;
        if (p.hasPermission("survivalrpg.warp.setwarp")) {
            p.sendMessage(ChatColor.GREEN + ("[c] You don`t have enough permission!"));
        }

        if (strings.length == 0) {

            p.sendMessage(ChatColor.GRAY + ("[c] You need to give me a name"));
        }

        String name =strings[0].toLowerCase();
        if (plugin.getConfig().get(name) != null) {
            p.sendMessage(ChatColor.RED + ("[c] There is already a warp whit that name!"));
        }

        Location loc =p.getLocation();
        plugin.getConfig().set(name + ".Word",loc.getWorld().toString());
        plugin.getConfig().set(name + ".X",  loc.getX());
        plugin.getConfig().set(name + ".Y", loc.getY());
        plugin.getConfig().set(name + ".Z", loc.getZ());
        plugin.getConfig().set(name + ".Pitch", loc.getPitch());
        plugin.getConfig().set(name + ".Yaw", loc.getYaw());
        plugin.saveConfig();
        p.sendMessage(ChatColor.GREEN + ("[c] Warp place"));

        return true;
    }
}
