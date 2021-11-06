package survivalrpg.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@SuppressWarnings("unused")
public class JoinPlayer implements Listener {

    @EventHandler
    public void onJoinPlayer(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.GRAY + ("] %player% join the server").replace("%player%", event.getPlayer().getName()));
    }
}
