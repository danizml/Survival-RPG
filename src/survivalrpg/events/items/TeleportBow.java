package survivalrpg.events.items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class TeleportBow implements Listener {

    @EventHandler
    public void onBowShoot(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow ) {
            Player playershoot = (Player) e.getEntity().getShooter();
            int pitch = (int) Objects.requireNonNull(playershoot).getLocation().getPitch();
            int yaw = (int) playershoot.getLocation().getYaw();
            int x = e.getEntity().getLocation().getBlockX();
            int y = e.getEntity().getLocation().getBlockY();
            int z = e.getEntity().getLocation().getBlockZ();
            Location location = new Location(playershoot.getWorld(), x, y, z, yaw, pitch);
            if (Objects.requireNonNull(playershoot.getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "TP_Bow")) {
                playershoot.teleport(location);
                e.getEntity().remove();
                playershoot.spawnParticle(Particle.ENCHANTMENT_TABLE, 10, 10, 10, 10);
                playershoot.playSound(location, Sound.ENTITY_ENDER_PEARL_THROW, 20, 20);
            }
        }
    }
}