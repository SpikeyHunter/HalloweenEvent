package com.spikeyhunter.halloweenmain;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Llama;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class StevenProjectile implements Listener {

	
	@EventHandler
	public void onLlamaSpit(ProjectileLaunchEvent e){
		final Projectile projectile = e.getEntity();	  
		  if (!(projectile instanceof LlamaSpit)) return;
		  final ProjectileSource shooter = projectile.getShooter();
		  if (!(shooter instanceof Llama)) return;
		  final Vector velocity = projectile.getVelocity();
		  shooter.launchProjectile(Fireball.class, velocity);
		  e.setCancelled(true);
		
	}

	
}
