package survivalrpg.events.potions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import survivalrpg.SurvivalRPG;

public class Spawn implements Listener {
    private final SurvivalRPG plugin;

    public Spawn(SurvivalRPG plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrink(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.POTION) {
            Player consumer = event.getPlayer();
            if (consumer.getBedSpawnLocation() != null) {
                consumer.getBedSpawnLocation().getChunk().load();
                this.teleportDelay(consumer, consumer.getBedSpawnLocation());
            } else {
                consumer.getWorld().getSpawnLocation().getChunk().load();
                this.teleportDelay(consumer, consumer.getWorld().getSpawnLocation());
            }
        }
    }

    private void teleportDelay(Player target, Location location) {
        Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
            target.teleport(location);
            target.getWorld().playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
        }, 10L);
    }
}

