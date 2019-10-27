package com.spikeyhunter.halloweenmain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BossZombie implements Listener {

	private MainClass plugin;
	public BossZombie(MainClass main) {
		this.plugin = main;
	}
	   
	    
	    
	    @EventHandler
	    public void onDamageEntity(EntityDamageByEntityEvent e){
	        if(e.getEntity() instanceof Zombie && e.getDamager() instanceof Player){
	            if(e.getEntity().hasMetadata("Angry")){
	                Location location = e.getEntity().getLocation();
	                e.getEntity().remove();
	                location.getWorld().strikeLightning(location);
	                PigZombie pigZombie = (PigZombie)location.getWorld().spawnEntity(location, EntityType.PIG_ZOMBIE);
		            pigZombie.setMetadata("AngryPigman",new FixedMetadataValue(plugin,"angrypigman"));
		            pigZombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&6&lDead Walker Boss"));
				  	pigZombie.setCustomNameVisible(true);
				  	pigZombie.setRemoveWhenFarAway(false);
	                pigZombie.getEquipment().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
	                pigZombie.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_SWORD));
	                pigZombie.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
	                pigZombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, false, false), false);
	                pigZombie.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100000, 2, false, false), false);
	                
	                startMinionSpawn(pigZombie,(Player)e.getDamager());
	            }
	            
	            if(e.getDamager() instanceof PigZombie && e.getEntity() instanceof Player){
	                if(e.getDamager().hasMetadata("AngryMinion")){
	                    e.getDamager().getWorld().playEffect(e.getEntity().getLocation(), Effect.MOBSPAWNER_FLAMES, 10);;
	                }
	            }
	        }
	    }
	    
	    

		private void startMinionSpawn(PigZombie pigZombie, Player damager) {
			
			
	        
			if(pigZombie.isDead()) {
				 return;
			 
			}
			/* new BukkitRunnable() {
	            @Override
	            public void run() {
	                if(pigZombie.isDead()){
	                    cancel();
	                    return;
	                }
	                PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
		            babyZombie.setAngry(true);
		            babyZombie.setBaby(true);
		            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
		            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
		            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
		            babyZombie.setTarget(damager);
		            
	            }
	        }.runTaskTimer(plugin,100,120);*/

				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(pigZombie.isDead()) {
							 return;
						} else {
						PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
			            babyZombie.setAngry(true);
			            babyZombie.setBaby(true);
					  	babyZombie.setRemoveWhenFarAway(false);
			            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
			            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
			            babyZombie.setTarget(damager);
						}} }, 100L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(pigZombie.isDead()) {
							 return;
						} else {
						PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
			            babyZombie.setAngry(true);
			            babyZombie.setBaby(true);
					  	babyZombie.setRemoveWhenFarAway(false);
			            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
			            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
			            babyZombie.setTarget(damager);
						}} }, 200L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() {  
						if(pigZombie.isDead()) {
							 return;
						} else {
						PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
			            babyZombie.setAngry(true);
			            babyZombie.setBaby(true);
					  	babyZombie.setRemoveWhenFarAway(false);
			            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
			            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
			            babyZombie.setTarget(damager);
						}} }, 300L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						if(pigZombie.isDead()) {
							 return;
						} else {
						PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
			            babyZombie.setAngry(true);
			            babyZombie.setBaby(true);
					  	babyZombie.setRemoveWhenFarAway(false);
			            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
			            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
			            babyZombie.setTarget(damager);
						}} }, 400L);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() {
						if(pigZombie.isDead()) {
							 return;
						} else {
						PigZombie babyZombie = (PigZombie)pigZombie.getLocation().getWorld().spawnEntity(pigZombie.getLocation(), EntityType.PIG_ZOMBIE);
			            babyZombie.setAngry(true);
			            babyZombie.setBaby(true);
					  	babyZombie.setRemoveWhenFarAway(false);
			            babyZombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            babyZombie.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_AXE));
			            babyZombie.setMetadata("AngryMinion",new FixedMetadataValue(plugin,"AngryMinion"));
			            babyZombie.setTarget(damager);
						}} }, 500L);
				
	            
			  
			
			
			new BukkitRunnable() {
	            @Override
	            public void run() {
	            	if(pigZombie.isDead()){
	                    cancel();
	                    return;
	                }
	            	pigZombie.getWorld().playEffect(pigZombie.getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
	            }
	        }.runTaskTimer(plugin,20,20);
		
	    }
		
    
	
}

