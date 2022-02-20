package com.blub.daanzijnhell;

import org.bukkit.plugin.java.JavaPlugin;

public class Daanzijnhell extends JavaPlugin {

    boolean isActive = false;

    @Override
    public void onEnable() {
        //Get and set config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register Events
        getServer().getPluginManager().registerEvents(new EntityEvents(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean getIsActive(){ return this.isActive ;}
}
