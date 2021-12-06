package me.TurtlesAreHot.ElementChooser.events;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.event.PlayerChangeElementEvent;
import me.TurtlesAreHot.ElementChooser.commands.DarkSpirit;
import me.xnuminousx.spirits.elements.SpiritElement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sun.security.provider.ConfigFile;

public class onElementAdd implements Listener {

    @EventHandler
    public void onElementAdd(PlayerChangeElementEvent e) {
        if(e.getResult() == PlayerChangeElementEvent.Result.ADD) {

        }
    }
}
