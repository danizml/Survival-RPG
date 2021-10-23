package survivalrpg.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PrimaryMenu {
    public static Inventory primary;

    public void CreateGuiPrimary() {
        primary.setItem(0, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(1, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(2, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(3, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(4, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(5, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(6, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(7, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        primary.setItem(8, new ItemStack(Material.BARRIER));

        primary.setItem(9, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        ItemStack icon10 = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta10 = icon10.getItemMeta();
        assert meta10 != null;
        meta10.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dNAME"));
        List<String> lore10 = new ArrayList<>();
        lore10.add(ChatColor.translateAlternateColorCodes('&', "&5Description."));
        meta10.setLore(lore10);
        icon10.setItemMeta(meta10);
        primary.setItem(10, icon10);

        primary.setItem(11, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        /*primary.setItem(12, new ItemStack(Material.BOOK));
        primary.setItem(13, new ItemStack(Material.BOOK));
        primary.setItem(14, new ItemStack(Material.BOOK));
        primary.setItem(15, new ItemStack(Material.BOOK));
        primary.setItem(16, new ItemStack(Material.BOOK));*/

        primary.setItem(17, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(18, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        ItemStack icon19 = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta meta19 = icon19.getItemMeta();
        assert meta19 != null;
        meta19.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dCommands"));
        List<String> lore19 = new ArrayList<>();
        lore19.add(ChatColor.translateAlternateColorCodes('&', "&5Click to show the plugin help."));
        meta19.hasEnchant(Enchantment.MENDING);
        meta19.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
        meta19.setLore(lore19);
        icon19.setItemMeta(meta19);
        primary.setItem(19, icon19);

        primary.setItem(20, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        /*primary.setItem(21, new ItemStack(Material.BOOK));
        primary.setItem(22, new ItemStack(Material.BOOK));
        primary.setItem(23, new ItemStack(Material.BOOK));
        primary.setItem(24, new ItemStack(Material.BOOK));
        primary.setItem(25, new ItemStack(Material.BOOK));*/

        primary.setItem(26, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        primary.setItem(27, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        ItemStack icon28 = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta meta28 = icon28.getItemMeta();
        assert meta28 != null;
        meta28.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dSettings"));
        List<String> lore28 = new ArrayList<>();
        lore28.add(ChatColor.translateAlternateColorCodes('&', "&5Click to go the plugins settings."));
        meta28.hasEnchant(Enchantment.MENDING);
        meta28.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
        meta28.setLore(lore28);
        icon28.setItemMeta(meta28);
        primary.setItem(28, icon28);

        primary.setItem(29, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));

        /*primary.setItem(30, new ItemStack(Material.BOOK));
        primary.setItem(31, new ItemStack(Material.BOOK));
        primary.setItem(32, new ItemStack(Material.BOOK));
        primary.setItem(33, new ItemStack(Material.BOOK));
        primary.setItem(34, new ItemStack(Material.BOOK));*/
    }

    static {
        primary = Bukkit.createInventory(null, 27, ChatColor.DARK_BLUE + "Survival-RPG");
    }
}
