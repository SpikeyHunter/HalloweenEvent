package com.spikeyhunter.halloweenmain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BossSkeleton implements Listener {

	private MainClass plugin;
	public BossSkeleton(MainClass main) {
		this.plugin = main;
	}

	    
	    @EventHandler
	    public void onDamageEntity(EntityDamageByEntityEvent e){
	        if(e.getEntity() instanceof Skeleton && e.getDamager() instanceof Player){
	            if(e.getEntity().hasMetadata("Skelboss")){
	                Location location = e.getEntity().getLocation();
	                e.getEntity().remove();
	                location.getWorld().strikeLightning(location);
	                WitherSkeleton Wither = (WitherSkeleton)location.getWorld().spawnEntity(location, EntityType.WITHER_SKELETON);
		            Wither.setMetadata("WitherBoss",new FixedMetadataValue(plugin,"witherboss"));
		            Wither.setCustomName(ChatColor.translateAlternateColorCodes('&', "&6&lDead Spirit Boss"));
				  	Wither.setCustomNameVisible(true);
				  	Wither.setRemoveWhenFarAway(false);
	                Wither.getEquipment().setHelmet(new ItemStack(Material.BLACK_STAINED_GLASS));
	                Wither.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
	                Wither.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	                Wither.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, false, false), false);
	                Wither.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100000, 2, false, false), false);
	                
	                startMinionSpawn(Wither,(Player)e.getDamager());
	            }
	            
	            if(e.getDamager() instanceof WitherSkeleton && e.getEntity() instanceof Player){
	                if(e.getDamager().hasMetadata("Witherminion")){
	                    e.getDamager().getWorld().playEffect(e.getEntity().getLocation(), Effect.MOBSPAWNER_FLAMES, 10);;
	                }
	            }
	        }
	    }
	    
	    

		private void startMinionSpawn(WitherSkeleton Wither, Player damager) {
			
			
	        
			if(Wither.isDead()) {
				 return;
			 
			}

				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(Wither.isDead()) {
							 return;
						} else {
						Zombie babySkel = (Zombie)Wither.getLocation().getWorld().spawnEntity(Wither.getLocation(), EntityType.ZOMBIE);
			            babySkel.setBaby(true);
					  	babySkel.setRemoveWhenFarAway(false);
			            babySkel.getEquipment().setHelmet(new ItemStack(Material.CHORUS_PLANT));
			            babySkel.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SHOVEL));
			            babySkel.setMetadata("Witherminion",new FixedMetadataValue(plugin,"witherminion"));
			            babySkel.setTarget(damager);
						}} }, 100L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(Wither.isDead()) {
							 return;
						} else {
						Zombie babySkel = (Zombie)Wither.getLocation().getWorld().spawnEntity(Wither.getLocation(), EntityType.ZOMBIE);
			            babySkel.setBaby(true);
					  	babySkel.setRemoveWhenFarAway(false);
			            babySkel.getEquipment().setHelmet(new ItemStack(Material.CHORUS_PLANT));
			            babySkel.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SHOVEL));
			            babySkel.setMetadata("Witherminion",new FixedMetadataValue(plugin,"witherminion"));
			            babySkel.setTarget(damager);
						}} }, 200L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() {  
						if(Wither.isDead()) {
							 return;
						} else {
						Zombie babySkel = (Zombie)Wither.getLocation().getWorld().spawnEntity(Wither.getLocation(), EntityType.ZOMBIE);
			            babySkel.setBaby(true);
					  	babySkel.setRemoveWhenFarAway(false);
			            babySkel.getEquipment().setHelmet(new ItemStack(Material.CHORUS_PLANT));
			            babySkel.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SHOVEL));
			            babySkel.setMetadata("Witherminion",new FixedMetadataValue(plugin,"witherminion"));
			            babySkel.setTarget(damager);
						}} }, 300L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(Wither.isDead()) {
							 return;
						} else {
						Zombie babySkel = (Zombie)Wither.getLocation().getWorld().spawnEntity(Wither.getLocation(), EntityType.ZOMBIE);
			            babySkel.setBaby(true);
					  	babySkel.setRemoveWhenFarAway(false);
			            babySkel.getEquipment().setHelmet(new ItemStack(Material.CHORUS_PLANT));
			            babySkel.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SHOVEL));
			            babySkel.setMetadata("Witherminion",new FixedMetadataValue(plugin,"witherminion"));
			            babySkel.setTarget(damager);
						}} }, 400L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() {
						if(Wither.isDead()) {
							 return;
						} else {
						Zombie babySkel = (Zombie)Wither.getLocation().getWorld().spawnEntity(Wither.getLocation(), EntityType.ZOMBIE);
			            babySkel.setBaby(true);
					  	babySkel.setRemoveWhenFarAway(false);
			            babySkel.getEquipment().setHelmet(new ItemStack(Material.CHORUS_PLANT));
			            babySkel.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SHOVEL));
			            babySkel.setMetadata("Witherminion",new FixedMetadataValue(plugin,"witherminion"));
			            babySkel.setTarget(damager);
						}} }, 500L);
				
	            
			  
			
			
			new BukkitRunnable() {
	            @Override
	            public void run() {
	            	if(Wither.isDead()){
	                    cancel();
	                    return;
	                }
	            	Wither.getWorld().playEffect(Wither.getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
	            }
	        }.runTaskTimer(plugin,20,20);
		
	    }
		
    
	
}

