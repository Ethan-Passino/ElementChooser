package me.TurtlesAreHot.ElementChooser.commands;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.xnuminousx.spirits.elements.SpiritElement;


public class DarkSpirit implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.getServer().getLogger().info("You cannot use this plugin in console!");
            return false;
        }
        Player p = (Player) sender;
        if(label.equalsIgnoreCase("darkspirit")) {
            if(p.hasPermission("elementchooser.darkspirit")) {
                BendingPlayer bp = BendingPlayer.getBendingPlayer(p);
                // Check if the player has more than 1 element. They can only have one and it cannot be avatar.
                if(bp.hasElement(SpiritElement.DARK_SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " darkspirit");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " spirit");
                    p.sendMessage(ChatColor.GREEN + "We have removed darkspirit!");
                    return false;
                }
                if(bp.hasElement(SpiritElement.LIGHT_SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " lightspirit");
                    p.sendMessage(ChatColor.GREEN + "In order to get darkspirit we removed your lightspirit.");
                }
                if(bp.hasElement(SpiritElement.SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " spirit");
                    p.sendMessage(ChatColor.GREEN + "In order to get darkspirit we removed your spirit.");
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
                bp.addElement(SpiritElement.DARK_SPIRIT);
                bp.addElement(SpiritElement.SPIRIT);
                p.sendMessage(ChatColor.GREEN + "You have been given the element for darkspirit!");
                return false;
            }
        }

        return false;
    }


}
