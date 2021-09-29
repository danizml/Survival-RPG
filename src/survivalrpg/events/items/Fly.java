package survivalrpg.events.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import survivalrpg.SurvivalRPG;

import java.util.Objects;

@SuppressWarnings({"deprecation", "EqualsBetweenInconvertibleTypes"})
public class Fly implements Listener {
    private final SurvivalRPG plugin;

    public Fly(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickFeather(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) | (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) | (event.getAction().equals(Action.LEFT_CLICK_AIR)) | (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) {
            if (player.getItemInHand().equals(Material.FEATHER)) {
                if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(this.plugin.getItems().getString("Fly-Feather.name"))) {
                    if (Objects.equals(player.getItemInHand().getItemMeta().getLore(), this.plugin.getItems().getStringList("Fly-Feather.lore"))) {
                        player.sendMessage(this.plugin.name + ChatColor.DARK_GREEN + " " + this.plugin.getItems().getString("Fly-Feather.message"));
                        player.setAllowFlight(true);
                        player.getItemInHand().setType(Material.PAPER);
                        player.sendMessage(this.plugin.name + ChatColor.DARK_GREEN + "You has been fly disabled");
                    }
                }
            }
        }
    }
}
