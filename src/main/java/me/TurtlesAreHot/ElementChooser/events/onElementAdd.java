package me.TurtlesAreHot.ElementChooser.events;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.event.PlayerChangeElementEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onElementAdd implements Listener {

    @EventHandler
    public void onElementAdd(PlayerChangeElementEvent e) {
        if(e.getResult() == PlayerChangeElementEvent.Result.ADD) {
            BendingPlayer bp = BendingPlayer.getBendingPlayer(e.getTarget());
            if(e.getElement() == Element.AIR) {
                bp.addSubElement(Element.SPIRITUAL);
                bp.addSubElement(Element.FLIGHT);
            }
            if(e.getElement() == Element.FIRE) {
                bp.addSubElement(Element.LIGHTNING);
                bp.addSubElement(Element.COMBUSTION);
            }
            if(e.getElement() == Element.WATER) {
                bp.addSubElement(Element.HEALING);
                bp.addSubElement(Element.BLOOD);
                bp.addSubElement(Element.ICE);
                bp.addSubElement(Element.PLANT);
            }
            if(e.getElement() == Element.EARTH) {
                bp.addSubElement(Element.METAL);
                bp.addSubElement(Element.LAVA);
                bp.addSubElement(Element.SAND);
            }
        }
    }
}
