package me.TurtlesAreHot.ElementChooser;

import me.TurtlesAreHot.ElementChooser.commands.BlueFire;
import me.TurtlesAreHot.ElementChooser.commands.Choose;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bluefire").setExecutor(new BlueFire());
        getCommand("choose").setExecutor(new Choose());
    }

    @Override
    public void onDisable() {

    }
}
