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

public class ItemsMenu implements Listener {
    public static Inventory items;

    public static void CreateGuiItems() {

//------------------------------------------------------Panels--------------------------------------------------------//

        ItemsMenu.glassPane(0);
        ItemsMenu.glassPane(1);
        ItemsMenu.glassPane(2);
        ItemsMenu.glassPane(3);
        ItemsMenu.glassPane(4);
        ItemsMenu.glassPane(5);
        ItemsMenu.glassPane(6);
        ItemsMenu.glassPane(7);
        ItemsMenu.glassPane(8);
        ItemsMenu.glassPane(9);
        ItemsMenu.glassPane(17);
        ItemsMenu.glassPane(18);
        ItemsMenu.glassPane(26);
        ItemsMenu.glassPane(27);
        ItemsMenu.glassPane(35);
        ItemsMenu.glassPane(36);
        ItemsMenu.glassPane(44);
        ItemsMenu.glassPane(46);
        ItemsMenu.glassPane(47);
        ItemsMenu.glassPane(48);
        ItemsMenu.glassPane(49);
        ItemsMenu.glassPane(50);
        ItemsMenu.glassPane(51);
        ItemsMenu.glassPane(52);

        //------------------------------------------------Function----------------------------------------------------//

        ItemStack icon10 = new ItemStack(Material.BOW);
        ItemMeta meta10 = icon10.getItemMeta();
        assert meta10 != null;
        meta10.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dGive TP-Bow"));
        List<String> lore10 = new ArrayList<>();
        lore10.add(ChatColor.translateAlternateColorCodes('&', "&5Click to get the tp-bow"));
        meta10.setLore(lore10);
        icon10.setItemMeta(meta10);
        items.setItem(10, icon10);

        ItemStack icon53 = new ItemStack(Material.BARRIER);
        ItemMeta meta53 = icon53.getItemMeta();
        assert meta53 != null;
        meta53.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dClose menu"));
        List<String> lore53 = new ArrayList<>();
        lore53.add(ChatColor.translateAlternateColorCodes('&', "&5Click for close the menu."));
        meta53.setLore(lore53);
        icon53.setItemMeta(meta53);
        items.setItem(53, icon53);

        ItemStack icon45 = new ItemStack(Material.ARROW);
        ItemMeta meta45 = icon45.getItemMeta();
        assert meta45 != null;
        meta45.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dBack"));
        List<String> lore45 = new ArrayList<>();
        lore45.add(ChatColor.translateAlternateColorCodes('&', "&5Return to the previous menu."));
        meta45.setLore(lore45);
        icon45.setItemMeta(meta45);
        items.setItem(45, icon45);



    }

    static {
        items = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "Survival-RPG Items");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void InventoryClickPrimaryMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().equals(items)) {
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
        items.setItem(icon, glass);
    }
}
