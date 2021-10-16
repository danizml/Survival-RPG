package survivalrpg.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;

public class setwarp implements CommandExecutor {

    private final SurvivalRPG plugin;

    public setwarp(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[rpg] Player only command!");
        } else {
            Player player = (Player) sender;

            if (!player.hasPermission("survivalrpg.warp.setwarp")) {
                player.sendMessage(ChatColor.RED + ("[rpg] You don't have enough permissions!"));
            }

            if (strings.length == 0) {
                player.sendMessage(ChatColor.BLUE + ("[rpg] You need to give me a name"));
            }

            String name = strings[0].toLowerCase();

            if (plugin.getConfig().get(name) != null) {
                player.sendMessage(ChatColor.RED + ("[rpg] There is already a warp whit that name!"));
            }

            plugin.getConfig().set(name + ".World", player.getWorld().getName());
            plugin.getConfig().set(name + ".X", player.getLocation().getX());
            plugin.getConfig().set(name + ".Y", player.getLocation().getY());
            plugin.getConfig().set(name + ".Z", player.getLocation().getZ());
            plugin.getConfig().set(name + ".Pitch", player.getLocation().getPitch());
            plugin.getConfig().set(name + ".Yaw", player.getLocation().getYaw());
            plugin.saveConfig();
            plugin.reloadConfig();
            player.sendMessage(ChatColor.GREEN + ("[rpg] Warp place"));

        }return true;
    }
}
