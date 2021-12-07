package me.TurtlesAreHot.ElementChooser.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCommand implements Listener {

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().equalsIgnoreCase("/wild") ||
                event.getMessage().equalsIgnoreCase("/rtp")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wild " + event.getPlayer().getName() + " bending");
        }
    }
}
