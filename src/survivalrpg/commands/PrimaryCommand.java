package survivalrpg.commands;
//---------------------------------imports---------------------------
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import survivalrpg.SurvivalRPG;
import survivalrpg.manager.MessageManager;
import survivalrpg.menus.PrimaryMenu;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrimaryCommand implements CommandExecutor {
    private final SurvivalRPG plugin;


    public PrimaryCommand(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender,@Nonnull Command cmd,@Nonnull String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("survivalrpg.reload")) {
                    this.plugin.reloadPlugin();
                    this.plugin.registerConfig();
                    sender.sendMessage(ChatColor.GREEN + "Config Reloaded");
                }
            } else if (args[0].equalsIgnoreCase("help")) {
                if (sender.hasPermission("survivalrpg.help")) {
                    sender.sendMessage(ChatColor.DARK_GREEN + "-----<" + this.plugin.name + ChatColor.DARK_RED + "Help" + ChatColor.DARK_GREEN + ">-----");
                    sender.sendMessage(ChatColor.GOLD + "/rpg item <type> give <player> <amount> ");
                    sender.sendMessage(ChatColor.GOLD + "/rpg version ");
                    sender.sendMessage(ChatColor.GOLD + "/rpg help ");
                    sender.sendMessage(ChatColor.DARK_GREEN + "-----<" + this.plugin.name + ChatColor.DARK_RED + "Help" + ChatColor.DARK_GREEN + ">-----");
                }
            } else if (args[0].equalsIgnoreCase("version")) {
                sender.sendMessage(this.plugin.name + " " + this.plugin.version);
            } else if (args[0].equalsIgnoreCase("item")) {
//----------------------------------------------------------------------------------------------------------------------
                if (args[1].equalsIgnoreCase("feather")) {
                    if (args[2].equalsIgnoreCase("give")) {
                        int amount = Integer.parseInt(args[3]);
                        Player target = Bukkit.getPlayer(args[4]);
                        if (target == null) {
                            sender.sendMessage(this.plugin.name + ChatColor.DARK_RED + " [ERROR]: " + ChatColor.WHITE + "The player not found");
                        } else {
                            ItemStack item = new ItemStack(Material.FEATHER, amount);
                            ItemMeta itemMeta = item.getItemMeta();
                            Objects.requireNonNull(itemMeta).setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.plugin.getItems().getString("Fly-Feather.name"))));
                            List<String> itemLore = new ArrayList<>();
                            itemLore.add(ChatColor.translateAlternateColorCodes('&', String.valueOf(this.plugin.getItems().getStringList("Fly-Feather.lore"))));
                            itemMeta.setLore(itemLore);
                            item.setItemMeta(itemMeta);
                            target.getInventory().addItem(item);
                        }
                    } else {
                        sender.sendMessage(this.plugin.name + ChatColor.DARK_RED + " [ERROR]: " + ChatColor.WHITE + "Please use: /rpg item <type> give <player> <amount>");
                    }
                } else if (args[1].equalsIgnoreCase("tpbow")) {
                    if (args[2].equalsIgnoreCase("give")) {
                        int amount = Integer.parseInt(args[3]);
                        Player target = Bukkit.getPlayer(args[4]);
                        if (target == null) {
                            sender.sendMessage(ChatColor.DARK_RED + " [ERROR]: " + ChatColor.WHITE + "The player not found");
                        } else {
                            ItemStack item = new ItemStack(Material.BOW, amount);
                            ItemMeta meta = item.getItemMeta();
                            Objects.requireNonNull(meta).setDisplayName(ChatColor.DARK_PURPLE + "TP_Bow");
                            ArrayList<String> lore = new ArrayList<>();
                            lore.add("This bow can teleport you");
                            lore.add("where the arrow falls");
                            meta.setLore(lore);
                            item.addEnchantment(Enchantment.DURABILITY, 3);
                            meta.setUnbreakable(true);
                            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                            item.setItemMeta(meta);
                            target.getInventory().addItem(item);
                        }
                    } else {
                        sender.sendMessage(this.plugin.name + ChatColor.DARK_RED + " [ERROR]: " + ChatColor.WHITE + "Please use: /rpg item <type> give <player> <amount>");
                    }
                }
//----------------------------------------------------------------------------------------------------------------------
            } else if (args[0].equalsIgnoreCase("menu")) {
                Player player= (Player) sender;
                p
            }
        }return true;
    }
}

