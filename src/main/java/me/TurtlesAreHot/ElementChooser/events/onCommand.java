package me.TurtlesAreHot.ElementChooser.events;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCommand implements Listener {

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().equalsIgnoreCase("/wild") ||
                event.getMessage().equalsIgnoreCase("/rtp")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wild " + event.getPlayer().getName() + " bending");
        } else if(event.getMessage().substring(0, "/b choose".length()).equalsIgnoreCase("/b choose")) {
            if(event.getMessage().length() <= "/b choose".length()) {
                Bukkit.dispatchCommand(event.getPlayer(), "choose");
            } else {
                Bukkit.dispatchCommand(event.getPlayer(), "choose" + event.getMessage().substring("/b choose".length() + 1));
            }
            event.setCancelled(true);
        }

    }
}
