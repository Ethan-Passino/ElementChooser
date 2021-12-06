package me.TurtlesAreHot.ElementChooser.events;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        BendingPlayer bp = BendingPlayer.getBendingPlayer(p);
        if(bp.hasElement(Element.AVATAR)) {
            if(!(bp.hasElement(Element.FIRE))) {
                bp.addElement(Element.FIRE);
                bp.addSubElement(Element.COMBUSTION);
                bp.addSubElement(Element.LIGHTNING);
            }
            if(!(bp.hasElement(Element.AIR))) {
                bp.addElement(Element.AIR);
                bp.addSubElement(Element.FLIGHT);
                bp.addSubElement(Element.SPIRITUAL);
            }
            if(!(bp.hasElement(Element.WATER))) {
                bp.addElement(Element.WATER);
                bp.addSubElement(Element.PLANT);
                bp.addSubElement(Element.BLOOD);
                bp.addSubElement(Element.ICE);
                bp.addSubElement(Element.HEALING);
            }
            if(!(bp.hasElement(Element.EARTH))) {
                bp.addElement(Element.EARTH);
                bp.addSubElement(Element.METAL);
                bp.addSubElement(Element.LAVA);
                bp.addSubElement(Element.SAND);
            }
        }
        if(bp.hasElement(Element.AIR)) {
            if(!(bp.hasSubElement(Element.FLIGHT))) {
                bp.addSubElement(Element.FLIGHT);
            }
            if (!(bp.hasSubElement(Element.SPIRITUAL))) {
                bp.addSubElement(Element.SPIRITUAL);
            }
        }
        if(bp.hasElement(Element.WATER)) {
            if(!(bp.hasSubElement(Element.PLANT))) {
                bp.addSubElement(Element.PLANT);
            }
            if(!(bp.hasSubElement(Element.BLOOD))) {
                bp.addSubElement(Element.BLOOD);
            }
            if(!(bp.hasSubElement(Element.ICE))) {
                bp.addSubElement(Element.ICE);
            }
            if(!(bp.hasSubElement(Element.HEALING))) {
                bp.addSubElement(Element.HEALING);
            }
        }
        if(bp.hasElement(Element.EARTH)) {
            if(!(bp.hasSubElement(Element.METAL))) {
                bp.addSubElement(Element.METAL);
            }
            if(!(bp.hasSubElement(Element.LAVA))) {
                bp.addSubElement(Element.LAVA);
            }
            if(!(bp.hasSubElement(Element.SAND))) {
                bp.addSubElement(Element.SAND);
            }
        }
        if(bp.hasElement(Element.FIRE)) {
            if(!(bp.hasSubElement(Element.COMBUSTION))) {
                bp.addSubElement(Element.COMBUSTION);
            }
            if(!(bp.hasSubElement(Element.LIGHTNING))) {
                bp.addSubElement(Element.LIGHTNING);
            }
        }
    }
}
