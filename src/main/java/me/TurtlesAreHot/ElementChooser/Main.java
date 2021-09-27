package me.TurtlesAreHot.ElementChooser;

import me.TurtlesAreHot.ElementChooser.commands.BlueFire;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bluefire").setExecutor(new BlueFire());
    }

    @Override
    public void onDisable() {

    }
}
