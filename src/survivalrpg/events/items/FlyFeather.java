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

@SuppressWarnings({"EqualsBetweenInconvertibleTypes", "deprecation"})
public class FlyFeather implements Listener {
    private final SurvivalRPG plugin;

    public FlyFeather(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickFeather(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(Material.FEATHER)) {
                if (Objects.requireNonNull(player.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(SurvivalRPG.getInstance().getItems().getString("Fly-Feather.name"))))) {
                    player.sendMessage(this.plugin.name + ChatColor.DARK_GREEN + " " + SurvivalRPG.getInstance().getItems().getString("Fly-Feather.message"));

                    player.setAllowFlight(true);

                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);

                    }player.getItemInHand().setType(Material.PAPER);
                }
            }
        }
    }
}
