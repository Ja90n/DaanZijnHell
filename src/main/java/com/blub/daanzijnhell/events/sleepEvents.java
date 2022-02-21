package com.blub.daanzijnhell.events;

import com.blub.daanzijnhell.Daanzijnhell;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class sleepEvents implements Listener {

    private Daanzijnhell daanzijnhell;
    public sleepEvents(Daanzijnhell daanzijnhell) {
        this.daanzijnhell = daanzijnhell;
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e){
        if (daanzijnhell.getIsActive()){
            Player p = e.getPlayer();
            p.getWorld().createExplosion(p.getLocation(), 25);
        }
    }
}
