package survivalrpg.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *    +PrimaryMenu+
 * File created by TonimatasMC
 * Links:
 *  - Discord: https://discord.com/invite/VYqEtT36U9
 *  - GitHub: https://github.com/TonimatasMCDEV
 *  - SpigotMC: https://www.spigotmc.org/members/tonimatas.803111/
 *  - CurseForge: https://www.curseforge.com/members/x_tonimatasmc_x/projects
 *
 */

public class HelpMenu implements Listener {
    public static Inventory help;

    public static void CreateGuiHelp() {

//----------------------Panels----------------------//

        HelpMenu.glassPane(0);
        HelpMenu.glassPane(1);
        HelpMenu.glassPane(2);
        HelpMenu.glassPane(3);
        HelpMenu.glassPane(4);
        HelpMenu.glassPane(5);
        HelpMenu.glassPane(6);
        HelpMenu.glassPane(7);
        HelpMenu.glassPane(8);
        HelpMenu.glassPane(9);
        HelpMenu.glassPane(17);
        HelpMenu.glassPane(18);
        HelpMenu.glassPane(26);
        HelpMenu.glassPane(27);
        HelpMenu.glassPane(35);
        HelpMenu.glassPane(36);
        HelpMenu.glassPane(44);
        HelpMenu.glassPane(46);
        HelpMenu.glassPane(47);
        HelpMenu.glassPane(48);
        HelpMenu.glassPane(49);
        HelpMenu.glassPane(50);
        HelpMenu.glassPane(51);
        HelpMenu.glassPane(52);

//---------------------Function---------------------//

        ItemStack icon53 = new ItemStack(Material.BARRIER);
        ItemMeta meta53 = icon53.getItemMeta();
        assert meta53 != null;
        meta53.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dClose menu"));
        List<String> lore53 = new ArrayList<>();
        lore53.add(ChatColor.translateAlternateColorCodes('&', "&5Click for close the menu."));
        meta53.setLore(lore53);
        icon53.setItemMeta(meta53);
        help.setItem(53, icon53);

        ItemStack icon45 = new ItemStack(Material.ARROW);
        ItemMeta meta45 = icon45.getItemMeta();
        assert meta45 != null;
        meta45.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dBack"));
        List<String> lore45 = new ArrayList<>();
        lore45.add(ChatColor.translateAlternateColorCodes('&', "&5Return to the previous menu."));
        meta45.setLore(lore45);
        icon45.setItemMeta(meta45);
        help.setItem(45, icon45);

        ItemStack icon10 = new ItemStack(Material.PAPER);
        ItemMeta meta10 = icon10.getItemMeta();
        assert meta10 != null;
        meta10.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d/rpg reload"));
        List<String> lore10 = new ArrayList<>();
        lore10.add(ChatColor.translateAlternateColorCodes('&', "&5Reload the plugin config."));
        meta10.setLore(lore10);
        icon10.setItemMeta(meta10);
        help.setItem(10, icon10);

        ItemStack icon11 = new ItemStack(Material.PAPER);
        ItemMeta meta11 = icon11.getItemMeta();
        assert meta11 != null;
        meta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d/rpg help"));
        List<String> lore11 = new ArrayList<>();
        lore11.add(ChatColor.translateAlternateColorCodes('&', "&5Reload the plugin config."));
        meta11.setLore(lore11);
        icon11.setItemMeta(meta11);
        help.setItem(11, icon11);

        ItemStack icon12 = new ItemStack(Material.PAPER);
        ItemMeta meta12 = icon12.getItemMeta();
        assert meta12 != null;
        meta12.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d/rpg item <type> give <amount> <player>"));
        List<String> lore12 = new ArrayList<>();
        lore12.add(ChatColor.translateAlternateColorCodes('&', "&5Give the item to a player"));
        meta12.setLore(lore12);
        icon12.setItemMeta(meta12);
        help.setItem(12, icon12);

        ItemStack icon13 = new ItemStack(Material.PAPER);
        ItemMeta meta13 = icon13.getItemMeta();
        assert meta13 != null;
        meta13.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d/rpg potion <type> give <amount> <player>"));
        List<String> lore13 = new ArrayList<>();
        lore13.add(ChatColor.translateAlternateColorCodes('&', "&5Give the potion to a player"));
        meta13.setLore(lore13);
        icon13.setItemMeta(meta13);
        help.setItem(13, icon13);

        ItemStack icon14 = new ItemStack(Material.PAPER);
        ItemMeta meta14 = icon14.getItemMeta();
        assert meta14 != null;
        meta14.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d/rpg armor <type> give <amount> <player>"));
        List<String> lore14 = new ArrayList<>();
        lore14.add(ChatColor.translateAlternateColorCodes('&', "&5Give the armor to a player"));
        meta14.setLore(lore14);
        icon14.setItemMeta(meta14);
        help.setItem(14, icon14);

    }

    static {
        help = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "Survival-RPG Help");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void InventoryClickPrimaryMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().equals(help)) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                player.sendMessage(ChatColor.DARK_RED + "Error: inventory.item.null");
            }

            if (event.getCurrentItem().getType() == Material.BARRIER && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dClose menu"))) {
                player.closeInventory();
            }

            if (event.getCurrentItem().getType() == Material.ARROW && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dBack"))) {
                PrimaryMenu.CreateGuiPrimary();
                player.openInventory(PrimaryMenu.primary);
            }


        }
    }

    public static void glassPane(int icon) {
        ItemStack glass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        assert glassMeta != null;
        glassMeta.setDisplayName(". ");
        glass.setItemMeta(glassMeta);
        help.setItem(icon, glass);
    }
}