package me.TurtlesAreHot.ElementChooser.commands;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import me.xnuminousx.spirits.elements.SpiritElement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightSpirit implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.getServer().getLogger().info("You cannot use this plugin in console!");
            return false;
        }
        Player p = (Player) sender;
        if(label.equalsIgnoreCase("lightspirit")) {
            if(p.hasPermission("elementchooser.lightspirit")) {
                BendingPlayer bp = BendingPlayer.getBendingPlayer(p);
                if (bp.hasElement(SpiritElement.LIGHT_SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " lightspirit");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " spirit");
                    p.sendMessage(ChatColor.GREEN + "We have removed lightspirit!");
                    return false;
                }
                if (bp.hasElement(SpiritElement.DARK_SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " darkspirit");
                    p.sendMessage(ChatColor.GREEN + "In order to get lightspirit we removed your darkspirit.");
                }
                if(bp.hasElement(SpiritElement.SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " spirit");
                    p.sendMessage(ChatColor.GREEN + "In order to get lightspirit we removed your spirit.");
                }
                if(bp.getElements().size() != 1) {
                    p.sendMessage(ChatColor.RED + "You can only have one element with any spirits element.");
                    return false;
                }
                if(bp.getElements().get(0) == Element.AVATAR) {
                    p.sendMessage(ChatColor.RED + "You cannot combine spirits with avatar.");
                    return false;
                }
                if(bp.getElements().get(0) == Element.CHI) {
                    p.sendMessage(ChatColor.RED + "You cannot combine spirits with chi.");
                    return false;
                }
                bp.addElement(SpiritElement.LIGHT_SPIRIT);
                bp.addElement(SpiritElement.SPIRIT);
                p.sendMessage(ChatColor.GREEN + "You have been given the element for lightspirit!");
                return false;
            }
        }

        return false;
    }
}
