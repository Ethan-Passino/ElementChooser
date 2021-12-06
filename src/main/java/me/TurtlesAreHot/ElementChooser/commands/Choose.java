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

import java.util.List;

public class Choose implements CommandExecutor {

    public String[] getValidElements(Player p) {
        String[] elements = new String[9];
        if(p.hasPermission("elementchooser.choose.water")) {
            elements[0] = ChatColor.AQUA + "water";
        }
        if(p.hasPermission("elementchooser.choose.air")) {
            elements[1] = ChatColor.GRAY + "air";
        }
        if(p.hasPermission("elementchooser.choose.fire")) {
            elements[2] = ChatColor.RED + "fire";
        }
        if(p.hasPermission("elementchooser.choose.earth")) {
            elements[3] = ChatColor.GREEN + "earth";
        }
        if(p.hasPermission("elementchooser.choose.chi")) {
            elements[4] = ChatColor.GOLD + "chi";
        }
        if(p.hasPermission("elementchooser.choose.avatar")) {
            elements[5] = ChatColor.DARK_PURPLE + "avatar";
        }
        if(p.hasPermission("elementchooser.choose.spirit")) {
            elements[6] = ChatColor.DARK_AQUA + "spirit";
        }
        if(p.hasPermission("elementchooser.choose.darkspirit")) {
            elements[7] = ChatColor.BLUE + "darkspirit";
        }
        if(p.hasPermission("elementchooser.choose.lightspirit")) {
            elements[8] = ChatColor.YELLOW + "lightspirit";
        }
        return elements;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.getServer().getLogger().info("You cannot use this plugin in console!");
            return false;
        }
        Player p = (Player) sender;
        BendingPlayer bp = BendingPlayer.getBendingPlayer(p);
        if(label.equalsIgnoreCase("choose")) {
            //Permissions are: elementchooser.choose.element
            if(args.length != 1) {
                String[] elements = getValidElements(p);
                String elementString = "";
                for(int i = 0; i < elements.length; i++) {
                    if(elements[i] == null) {
                        continue;
                    }
                    if(i == 8) {
                        elementString += elements[i];
                        break;
                    }
                    elementString += elements[i] + ChatColor.WHITE + ", ";

                }
                p.sendMessage("Valid Elements: " + elementString);
                return false;
            }
            else {
                String element = args[0].toLowerCase();
                if(!(p.hasPermission("elementchooser.choose." + element))) {
                    p.sendMessage(ChatColor.RED + "You either do not have permission to use this element or this element doesn't exist.");
                    return false;
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b choose " + element + " " + p.getName());
                p.sendMessage(ChatColor.GREEN + "You have been given the element(s) for " + element);
                if(element.equals("darkspirit") || element.equals("lightspirit")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add spirit " + p.getName());
                }
                if(element.equals("avatar")) {
                    if(bp.hasElement(Element.CHI)) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " chi");
                    }
                    if(bp.hasElement(SpiritElement.LIGHT_SPIRIT)) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " lightspirit");
                    }
                    if(bp.hasElement(SpiritElement.DARK_SPIRIT)) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " darkspirit");
                    }
                    if(bp.hasElement(SpiritElement.SPIRIT)) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b remove " + p.getName() + " spirit");
                    }
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add water " + p.getName());
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add air " + p.getName());
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add fire " + p.getName());
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "b add earth " + p.getName());
                    bp.addSubElement(Element.FLIGHT);
                    bp.addSubElement(Element.SPIRITUAL);
                    bp.addSubElement(Element.PLANT);
                    bp.addSubElement(Element.BLOOD);
                    bp.addSubElement(Element.ICE);
                    bp.addSubElement(Element.HEALING);
                    bp.addSubElement(Element.METAL);
                    bp.addSubElement(Element.LAVA);
                    bp.addSubElement(Element.SAND);
                    bp.addSubElement(Element.COMBUSTION);
                    bp.addSubElement(Element.LIGHTNING);
                }
                return false;

            }

        }
        return false;
    }
}
