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
            Location location = new Location(((Player) Objects.requireNonNull(e.getEntity().getShooter())).getWorld(), e.getEntity().getLocation().getBlockX(), e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ(), (int) ((Player) e.getEntity().getShooter()).getLocation().getYaw(), (int) Objects.requireNonNull(((Player) e.getEntity().getShooter())).getLocation().getPitch());
            if (Objects.requireNonNull(((Player) e.getEntity().getShooter()).getItemInHand().getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "TP-Bow")) {
                ((Player) e.getEntity().getShooter()).teleport(location);
                e.getEntity().remove();
                ((Player) e.getEntity().getShooter()).spawnParticle(Particle.ENCHANTMENT_TABLE, 10, 10, 10, 10);
                ((Player) e.getEntity().getShooter()).playSound(location, Sound.ENTITY_ENDER_PEARL_THROW, 20, 20);
            }
        }
    }
}