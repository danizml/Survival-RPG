package survivalrpg.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;

public class delwarp implements CommandExecutor {

    private final SurvivalRPG plugin;

    public delwarp(SurvivalRPG plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[rpg] Player only command!");
        } else {
            if (sender.hasPermission("survivalrpg.warp.delwarp")) {
                Player player = (Player) sender;

                if (strings.length == 0) {
                    player.sendMessage(ChatColor.BLUE + ("[rpg] Please provide a name!"));
                }

                String name = strings[0].toLowerCase();
                if (plugin.getConfig().get(name) == null) {
                    player.sendMessage(ChatColor.RED + ("[rpg] There is no warp with this name!"));
                }

                plugin.getConfig().set(name, null);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GREEN + ("[rpg] Warp" + name + "asuccessfully deleted!"));

            } else {
                sender.sendMessage(ChatColor.RED + ("[rpg] You don't have enough permissions!"));
            }
        }return true;
    }
}

