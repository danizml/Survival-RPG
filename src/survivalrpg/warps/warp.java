package survivalrpg.warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalrpg.SurvivalRPG;

import javax.annotation.Nonnull;
import java.util.Objects;

@SuppressWarnings("ConstantConditions")
public class warp implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] strings) {
        if (sender instanceof Player) {
            sender.sendMessage("[RPG] Player only command!");
        } else {
            Player player = (Player) sender;

            if (sender.hasPermission("survivalrpg.warp." + strings[0])) {
                if (strings.length == 0) {
                    sender.sendMessage(ChatColor.GREEN + ("[RPG] Please provide a warp name!"));
                }

                String name = strings[0].toLowerCase();
                if (SurvivalRPG.plugin.getWarps().get(name) == null) {
                    sender.sendMessage(ChatColor.RED + ("[RPG] No warp with that name!"));
                }

                player.teleport(new Location(Bukkit.getWorld(Objects.requireNonNull(SurvivalRPG.plugin.getWarps().getString(name + ".World"))), SurvivalRPG.plugin.getWarps().getDouble(name + ".X"), SurvivalRPG.plugin.getWarps().getDouble(name + ".Y"), SurvivalRPG.plugin.getWarps().getDouble(name + ".Z"), (float) SurvivalRPG.plugin.getWarps().getDouble(name + ".Yaw"), (float) SurvivalRPG.plugin.getWarps().getDouble(name + ".Pitch")));
                sender.sendMessage(ChatColor.DARK_BLUE + ("[RPG] Teleporting to " + name));
            } else {
                sender.sendMessage(ChatColor.RED + ("[RPG] You don't have enough permissions!"));
            }
        }return true;
    }
}
