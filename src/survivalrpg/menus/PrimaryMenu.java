package survivalrpg.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

@SuppressWarnings("CommentedOutCode")
public class PrimaryMenu implements Listener {
    public static Inventory primary;

    public static void CreateGuiPrimary() {

//----------------------Panels----------------------//

        PrimaryMenu.glassPane(0);
        PrimaryMenu.glassPane(1);
        PrimaryMenu.glassPane(2);
        PrimaryMenu.glassPane(3);
        PrimaryMenu.glassPane(4);
        PrimaryMenu.glassPane(5);
        PrimaryMenu.glassPane(6);
        PrimaryMenu.glassPane(7);
        PrimaryMenu.glassPane(8);
        PrimaryMenu.glassPane(9);
        PrimaryMenu.glassPane(11);
        PrimaryMenu.glassPane(17);
        PrimaryMenu.glassPane(18);
        PrimaryMenu.glassPane(20);
        PrimaryMenu.glassPane(26);
        PrimaryMenu.glassPane(27);
        PrimaryMenu.glassPane(29);
        PrimaryMenu.glassPane(35);
        PrimaryMenu.glassPane(36);
        PrimaryMenu.glassPane(38);
        PrimaryMenu.glassPane(44);
        PrimaryMenu.glassPane(45);
        PrimaryMenu.glassPane(46);
        PrimaryMenu.glassPane(47);
        PrimaryMenu.glassPane(48);
        PrimaryMenu.glassPane(49);
        PrimaryMenu.glassPane(50);
        PrimaryMenu.glassPane(51);
        PrimaryMenu.glassPane(52);

//---------------------Function---------------------//

        ItemStack icon8 = new ItemStack(Material.BARRIER);
        ItemMeta meta8 = icon8.getItemMeta();
        assert meta8 != null;
        meta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dClose menu"));
        List<String> lore8 = new ArrayList<>();
        lore8.add(ChatColor.translateAlternateColorCodes('&', "&5Click for close the menu."));
        meta8.setLore(lore8);
        icon8.setItemMeta(meta8);
        primary.setItem(53, icon8);

        ItemStack icon10 = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta10 = icon10.getItemMeta();
        assert meta10 != null;
        meta10.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dWarps"));
        List<String> lore10 = new ArrayList<>();
        lore10.add(ChatColor.translateAlternateColorCodes('&', "&5Click to open the warps menu."));
        meta10.setLore(lore10);
        icon10.setItemMeta(meta10);
        primary.setItem(10, icon10);

        /*primary.setItem(12, new ItemStack(Material.BOOK));
        primary.setItem(13, new ItemStack(Material.BOOK));
        primary.setItem(14, new ItemStack(Material.BOOK));
        primary.setItem(15, new ItemStack(Material.BOOK));
        primary.setItem(16, new ItemStack(Material.BOOK));*/

        ItemStack icon19 = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta meta19 = icon19.getItemMeta();
        assert meta19 != null;
        meta19.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dCommands"));
        List<String> lore19 = new ArrayList<>();
        lore19.add(ChatColor.translateAlternateColorCodes('&', "&5Click to show the plugin help."));
        meta19.setLore(lore19);
        icon19.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        icon19.setItemMeta(meta19);
        primary.setItem(19, icon19);

        /*primary.setItem(21, new ItemStack(Material.BOOK));
        primary.setItem(22, new ItemStack(Material.BOOK));
        primary.setItem(23, new ItemStack(Material.BOOK));
        primary.setItem(24, new ItemStack(Material.BOOK));
        primary.setItem(25, new ItemStack(Material.BOOK));*/

        ItemStack icon28 = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta28 = icon28.getItemMeta();
        assert meta28 != null;
        meta28.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dSettings"));
        List<String> lore28 = new ArrayList<>();
        lore28.add(ChatColor.translateAlternateColorCodes('&', "&5Click to go the plugin settings."));
        meta28.setLore(lore28);
        icon28.setItemMeta(meta28);
        primary.setItem(28, icon28);

        /*primary.setItem(30, new ItemStack(Material.BOOK));
        primary.setItem(31, new ItemStack(Material.BOOK));
        primary.setItem(32, new ItemStack(Material.BOOK));
        primary.setItem(33, new ItemStack(Material.BOOK));
        primary.setItem(34, new ItemStack(Material.BOOK));*/

        ItemStack icon29 = new ItemStack(Material.BOOK);
        ItemMeta meta29 = icon29.getItemMeta();
        assert meta29 != null;
        meta29.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dComming Soon"));
        List<String> lore29 = new ArrayList<>();
        lore29.add(ChatColor.translateAlternateColorCodes('&', "&5Comming Soon."));
        meta29.setLore(lore29);
        icon29.setItemMeta(meta29);
        primary.setItem(37, icon29);

        /*primary.setItem(39, new ItemStack(Material.BOOK));
        primary.setItem(40, new ItemStack(Material.BOOK));
        primary.setItem(41, new ItemStack(Material.BOOK));
        primary.setItem(42, new ItemStack(Material.BOOK));
        primary.setItem(43, new ItemStack(Material.BOOK));*/
    }

    static {
        primary = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "Survival-RPG");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void InventoryClickPrimaryMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().equals(primary)) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                player.sendMessage(ChatColor.DARK_RED + "Error: inventory.item.null");
            }

            if (event.getCurrentItem().getType() == Material.WRITABLE_BOOK && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dSettings"))) {
                player.sendMessage("You has been opened the setting menu.");
            }

            if (event.getCurrentItem().getType() == Material.BARRIER && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dClose menu"))) {
                player.closeInventory();
            }

            if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dCommands"))) {
                HelpMenu.CreateGuiHelp();
                player.openInventory(HelpMenu.help);
            }

            if (event.getCurrentItem().getType() == Material.BOOK && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dItems"))) {
                ItemsMenu.CreateGuiItems();
                player.openInventory(ItemsMenu.items);
            }

            if (event.getCurrentItem().getType() == Material.FEATHER && Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&dFly"))) {
                if (player.getAllowFlight() == true) {
                    player.setAllowFlight(false);
                }

                if (player.getAllowFlight() == false) {
                    player.setAllowFlight(true);
                }
            }
        }
    }

    public static void glassPane(int icon) {
        ItemStack glass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        assert glassMeta != null;
        glassMeta.setDisplayName(". ");
        glass.setItemMeta(glassMeta);
        primary.setItem(icon, glass);
    }
}
