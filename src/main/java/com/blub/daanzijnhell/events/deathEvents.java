package com.blub.daanzijnhell.events;

import com.blub.daanzijnhell.Daanzijnhell;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class deathEvents implements Listener {

    private Daanzijnhell daanzijnhell;
    public deathEvents(Daanzijnhell daanzijnhell) {
        this.daanzijnhell = daanzijnhell;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (daanzijnhell.getIsActive()){
            Player p = e.getEntity().getPlayer();
            p.getWorld().createExplosion(p.getLocation(),10);
            e.setDeathMessage(ChatColor.WHITE + p.getDisplayName() + ChatColor.RED + " died in Daan zijn Hell");

            World world = getServer().getWorld("world");//get the world
            List<Entity> entList = world.getEntities();//get all entities in the world
            for(Entity target : entList) {
                if (target instanceof Item) {
                    target.remove();
                }
            }
        }
    }
}