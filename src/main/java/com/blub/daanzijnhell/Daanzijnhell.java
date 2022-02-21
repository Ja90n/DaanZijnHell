package com.blub.daanzijnhell;

import com.blub.daanzijnhell.command.activateCommand;
import com.blub.daanzijnhell.events.EntityEvents;
import com.blub.daanzijnhell.events.deathEvents;
import com.blub.daanzijnhell.events.sleepEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class Daanzijnhell extends JavaPlugin {

    public boolean isActive = false;
    int difficulty = 0;

    @Override
    public void onEnable() {
        //Get and set config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register Events
        getServer().getPluginManager().registerEvents(new EntityEvents(this), this);
        getServer().getPluginManager().registerEvents(new sleepEvents(this), this);
        getServer().getPluginManager().registerEvents(new deathEvents(this), this);

        //Register Command / TabExecutor
        getCommand("daanzijnhell").setExecutor(new activateCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean getIsActive(){ return this.isActive ;}
    public int getDifficulty(){ return this.difficulty ;}
}
