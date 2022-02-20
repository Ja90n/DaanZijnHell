package com.blub.daanzijnhell;

import org.bukkit.DyeColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityEvents implements Listener{

    private Daanzijnhell daanzijnhell;
    public EntityEvents(Daanzijnhell daanzijnhell) {
        this.daanzijnhell = daanzijnhell;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){
        if (daanzijnhell.getIsActive()){
            e.getEntity().getType();
            switch (e.getEntity().getType()){
                //When the cow, chicken, pig and sheep spawn they stay baby forever and (mostly) un killable
                case COW:
                    Cow cow = (Cow) e.getEntity();
                    cow.setBaby();
                    cow.setAgeLock(true);
                    cow.setAbsorptionAmount(999999999);
                    break;
                case CHICKEN:
                    Chicken chicken = (Chicken) e.getEntity();
                    chicken.setBaby();
                    chicken.setAgeLock(true);
                    chicken.setAbsorptionAmount(999999999);
                    break;
                case PIG:
                    Pig pig = (Pig) e.getEntity();
                    pig.setBaby();
                    pig.setAgeLock(true);
                    pig.setAbsorptionAmount(999999999);
                case SHEEP:
                    Sheep sheep = (Sheep) e.getEntity();
                    sheep.setBaby();
                    sheep.setAgeLock(true);
                    sheep.setColor(DyeColor.PINK);
                    sheep.setAbsorptionAmount(999999999);
                    //When these hostiles spawn they get effects
                case ZOMBIE:
                    Zombie zombie = (Zombie) e.getEntity();
                    zombie.setInvulnerable(true);
                    zombie.setBaby();
                case SKELETON:
                    Skeleton skeleton = (Skeleton) e.getEntity();
                    skeleton.addPassenger(skeleton.getLocation().getWorld().spawnEntity(e.getLocation(), EntityType.STRAY));
                case CREEPER:
                    Creeper creeper = (Creeper) e.getEntity();
                    creeper.setPowered(true);
                    creeper.setSilent(true);
                    creeper.setInvisible(true);
            }
        }
    }
}
