package me.TurtlesAreHot.ElementChooser.commands;

import com.projectkorra.projectkorra.BendingPlayer;
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
                    p.sendMessage(ChatColor.GREEN + "We have removed lightspirit!");
                    return false;
                }
                if (bp.hasElement(SpiritElement.DARK_SPIRIT)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " darkspirit");
                    p.sendMessage(ChatColor.GREEN + "In order to get lightspirit we removed your darkspirit.");
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add lightspirit " + p.getName());
                p.sendMessage(ChatColor.GREEN + "You have been given the element for lightspirit!");
                return false;
            }
        }

        return false;
    }
}
