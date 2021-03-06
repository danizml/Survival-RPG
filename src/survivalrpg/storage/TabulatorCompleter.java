package survivalrpg.storage;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabulatorCompleter implements org.bukkit.command.TabCompleter {

    private boolean hasPermission(CommandSender sender) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            return sender.hasPermission("survival-rpg.help");
        }
    }

    @Override
    public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String alias, @Nonnull String[] args) {
        if (cmd.getName().equalsIgnoreCase("rpg")) {
            List<String> argList = new ArrayList<>();
            if (args.length == 1 && hasPermission(sender)) {
                argList.add("reload");
                argList.add("help");
                argList.add("version");
                argList.add("item");
                argList.add("fly");
                argList.add("potion");
                argList.add("menu");
                argList.add("economy");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }
            if (args.length == 2 && (args[0].equals("item"))) {
                argList.add("feather");
                argList.add("tpbow");
                return argList;
            }

            if (args.length == 3 && (args[1].equals("feather"))) {
                argList.add("give");
                return argList;
            }

            if (args.length == 2 && (args[0].equals("economy"))) {
                argList.add("give");
                argList.add("take");
                argList.add("pay");
                return argList;
            }

            if (args.length == 3 && (args[1].equals("tpbow"))) {
                argList.add("give");
                return argList;
            }

            if (args.length == 4 && (args[2].equals("give"))) {
                argList.add("1");
                argList.add("2");
                argList.add("3");
                argList.add("4");
                return argList;
            }

            if (args.length == 5 && args[0].equals("item") || args[0].equals("potion") || args[0].equals("armor")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    argList.add(player.getName());
                }return argList;
            }return argList;
        }return null;
    }
}