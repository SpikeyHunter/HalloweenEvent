package com.spikeyhunter.halloweenmain;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class MonsterDeathListener implements Listener {
	  private long kills;

	  public MonsterDeathListener(long kills){
	    this.kills = kills;
	  }


	@EventHandler private void onZombieDeath(EntityDeathEvent event){
	    final LivingEntity entity = event.getEntity();
	    if (entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.PIG_ZOMBIE || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.WITHER_SKELETON) {
	    	if (entity.getKiller() instanceof Player) kills++;
	    } else return;
	    
	  }

	  public long getKills(){ return kills; }
	}
