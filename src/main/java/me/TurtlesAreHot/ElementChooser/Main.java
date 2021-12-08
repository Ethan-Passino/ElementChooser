package me.TurtlesAreHot.ElementChooser;

import me.TurtlesAreHot.ElementChooser.commands.BlueFire;
import me.TurtlesAreHot.ElementChooser.commands.Choose;
import me.TurtlesAreHot.ElementChooser.commands.DarkSpirit;
import me.TurtlesAreHot.ElementChooser.commands.LightSpirit;
import me.TurtlesAreHot.ElementChooser.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bluefire").setExecutor(new BlueFire());
        getCommand("choose").setExecutor(new Choose());
        getCommand("darkspirit").setExecutor(new DarkSpirit());
        getCommand("lightspirit").setExecutor(new LightSpirit());
        this.getServer().getPluginManager().registerEvents(new onElementAdd(), this);
        this.getServer().getPluginManager().registerEvents(new onJoin(), this);
    }

    @Override
    public void onDisable() {

    }
}
