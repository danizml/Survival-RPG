package survivalrpg.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;

public class delwarp implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[RPG] Player only command!");
        } else {
            if (sender.hasPermission("survivalrpg.warp.delwarp")) {
                Player player = (Player) sender;

                if (strings.length == 0) {
                    player.sendMessage(ChatColor.BLUE + ("[RPG] Please provide a name!"));
                }

                String name = strings[0].toLowerCase();

                if (SurvivalRPG.getInstance().getWarps().get(name) == null) {
                    player.sendMessage(ChatColor.RED + ("[RPG] There is no warp with this name!"));
                }

                SurvivalRPG.getInstance().getWarps().set(name, null);
                SurvivalRPG.getInstance().saveWarps();
                SurvivalRPG.getInstance().reloadWarps();
                player.sendMessage(ChatColor.GREEN + ("[RPG] Warp" + name + "asuccessfully deleted!"));
            } else {
                sender.sendMessage(ChatColor.RED + ("[RPG] You don't have enough permissions!"));
            }
        }return true;
    }
}

