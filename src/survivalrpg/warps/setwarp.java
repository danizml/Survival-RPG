package survivalrpg.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;

public class setwarp implements CommandExecutor {
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[RPG] Player only command!");
        } else {
            Player player = (Player) sender;

            if (player.hasPermission("survivalrpg.warp.setwarp")) {

            if (strings.length == 0) {
                player.sendMessage(ChatColor.BLUE + ("[RPG] You need to give me a name"));
            }

            String name = strings[0].toLowerCase();

            if (SurvivalRPG.plugin.getWarps().get(name) != null) {
                player.sendMessage(ChatColor.RED + ("[RPG] There is already a warp whit that name!"));
            }

                SurvivalRPG.plugin.getWarps().set(name + ".World", player.getWorld().getName());
                SurvivalRPG.plugin.getWarps().set(name + ".X", player.getLocation().getX());
                SurvivalRPG.plugin.getWarps().set(name + ".Y", player.getLocation().getY());
                SurvivalRPG.plugin.getWarps().set(name + ".Z", player.getLocation().getZ());
                SurvivalRPG.plugin.getWarps().set(name + ".Pitch", player.getLocation().getPitch());
                SurvivalRPG.plugin.getWarps().set(name + ".Yaw", player.getLocation().getYaw());
                SurvivalRPG.plugin.saveWarps();
                SurvivalRPG.plugin.reloadWarps();
            player.sendMessage(ChatColor.GREEN + ("[RPG] Warp place"));
            } else {
                sender.sendMessage(ChatColor.RED + ("[RPG] You don't have enough permissions!"));
            }
        }return true;
    }
}
