package me.TurtlesAreHot.ElementChooser;

import me.TurtlesAreHot.ElementChooser.commands.BlueFire;
import me.TurtlesAreHot.ElementChooser.commands.Choose;
import me.TurtlesAreHot.ElementChooser.commands.DarkSpirit;
import me.TurtlesAreHot.ElementChooser.commands.LightSpirit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bluefire").setExecutor(new BlueFire());
        getCommand("choose").setExecutor(new Choose());
        getCommand("darkspirit").setExecutor(new DarkSpirit());
        getCommand("lightspirit").setExecutor(new LightSpirit());
    }

    @Override
    public void onDisable() {

    }
}
