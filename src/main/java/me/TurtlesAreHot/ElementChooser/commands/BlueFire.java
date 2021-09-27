package me.TurtlesAreHot.ElementChooser.commands;

import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.BendingPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlueFire implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.getServer().getLogger().info("You cannot use this plugin in console!");
            return false;
        }
        Player p = (Player) sender;
        if(label.equalsIgnoreCase("bluefire"))  {
            if(p.hasPermission("elementchooser.bluefire")) {
                BendingPlayer bp = BendingPlayer.getBendingPlayer(p);
                if(bp.hasSubElement(Element.SubElement.BLUE_FIRE)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " bluefire");
                    p.sendMessage(ChatColor.RED + "Bluefire removed!");
                    return false;
                }
                else if(bp.hasElement(Element.FIRE)){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add bluefire " + p.getName());
                    p.sendMessage(ChatColor.RED + "Bluefire added!");
                    return false;
                }
                else {
                    p.sendMessage(ChatColor.RED + "You must have the Fire element in order to add bluefire.");
                    return false;
                }
            } else {
                p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return false;
            }
        }
        return false;
    }
}
