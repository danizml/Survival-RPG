package survivalrpg.warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;

@SuppressWarnings("ConstantConditions")
public class warp implements CommandExecutor {

    private final SurvivalRPG plugin;

    public warp (SurvivalRPG plugin) {
        this.plugin = plugin;
    }

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
                if (plugin.getConfig().get(name) == null) {
                    sender.sendMessage(ChatColor.RED + ("[RPG] No warp with that name!"));
                }

                player.teleport(new Location(Bukkit.getWorld(Objects.requireNonNull(plugin.getConfig().getString(name + ".World"))), plugin.getConfig().getDouble(name + ".X"), plugin.getConfig().getDouble(name + ".Y"), plugin.getConfig().getDouble(name + ".Z"), (float) plugin.getConfig().getDouble(name + ".Yaw"), (float) plugin.getConfig().getDouble(name + ".Pitch")));
                sender.sendMessage(ChatColor.DARK_BLUE + ("[RPG] Teleporting to " + name));
            } else {
                sender.sendMessage(ChatColor.RED + ("[RPG] You don't have enough permissions!"));
            }
        }return true;
    }
}
