package com.spikeyhunter.halloweenmain;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;

public class KillListener implements Listener {
	
	private MainClass plugin;
	public KillListener(MainClass main) {
		this.plugin = main;
	}   
	
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));	
	
	public static void spawnFireworks(Location location, int amount, Color color){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
        

    }
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		 
		 World world = Bukkit.getWorld("Halloween");
		 Location location1 = new Location(world, 432, 53, 147);
		 Location location2 = new Location(world, 418, 53, 147);
		 Location location3 = new Location(world, 425, 53, 155);
		 Location location4 = new Location(world, 432, 53, 167);
		 Location location5 = new Location(world, 418, 53, 167);
		 Location location6 = new Location(world, 425, 53, 179);
		 Location location7 = new Location(world, 418, 53, 187);
		 Location location8 = new Location(world, 432, 53, 187);

		 Location location9 = new Location(world, 394, 54, 140);
		 Location location10 = new Location(world, 374, 53, 140);
		 Location location11 = new Location(world, 354, 53, 140);
		 Location location12 = new Location(world, 354, 53, 123);
		 Location location13 = new Location(world, 354, 53, 106);
		 Location location14 = new Location(world, 374, 53, 106);
		 Location location15 = new Location(world, 394, 53, 106);
		 Location location16 = new Location(world, 394, 53, 123);


		 Location location17 = new Location(world, 394, 63, 140);
		 Location location18 = new Location(world, 374, 63, 140);
		 Location location19 = new Location(world, 354, 63, 140);
		 Location location20 = new Location(world, 354, 63, 123);
		 Location location21 = new Location(world, 354, 63, 106);
		 Location location22 = new Location(world, 374, 63, 106);
		 Location location23 = new Location(world, 394, 63, 106);
		 Location location24 = new Location(world, 394, 63, 123);
	     
	     
	     
	    
	    ArrayList<Location> list = new ArrayList<Location>();
	    list.add(location1);
	    list.add(location2);
	    list.add(location3);
	    list.add(location4);
	    list.add(location5);
	    list.add(location6);
	    list.add(location7);
	    list.add(location8);
	    list.add(location9);
	    list.add(location10);
	    list.add(location11);
	    list.add(location12);
	    list.add(location13);
	    list.add(location14);
	    list.add(location15);
	    list.add(location16);
	    list.add(location17);
	    list.add(location18);
	    list.add(location19);
	    list.add(location20);
	    list.add(location21);
	    list.add(location22);
	    list.add(location23);
	    list.add(location24);
	    
	    Random randomGenerator = new Random();
		
		
		
		LivingEntity entity = e.getEntity();
		
		if(entity.getType() == EntityType.PIG_ZOMBIE && entity.hasMetadata("AngryPigman")) {
			
		  	Zombie zombie = (Zombie) entity.getKiller().getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.ZOMBIE);;
		  	zombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lDead Walker"));
		  	zombie.setCustomNameVisible(true);
            zombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
            zombie.setMetadata("Angry",new FixedMetadataValue(plugin,"angry"));
            MainClass.getEconomy().depositPlayer(entity.getKiller(), 5);
			
		}
		
		else if(entity.getType() == EntityType.ZOMBIE && entity.hasMetadata("Normal")) {
			
			Zombie zombie2 = (Zombie) entity.getKiller().getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.ZOMBIE);
			zombie2.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lDead Walker"));
		  	zombie2.setCustomNameVisible(true);
            zombie2.setMetadata("Normal",new FixedMetadataValue(plugin,"normal"));
            MainClass.getEconomy().depositPlayer(entity.getKiller(), 5);
			
		}
		
		else if(entity.getType() == EntityType.SKELETON && entity.hasMetadata("Skelnormal")) { 
			
			Skeleton skel = (Skeleton) entity.getKiller().getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.SKELETON);
			skel.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lDead Spirit"));
			skel.setCustomNameVisible(true);
			skel.setRemoveWhenFarAway(false);
			skel.setMetadata("Skelnormal",new FixedMetadataValue(plugin,"skelnormal"));
            MainClass.getEconomy().depositPlayer(entity.getKiller(), 5);
			
		}
		
		else if(entity.getType() == EntityType.WITHER_SKELETON && entity.hasMetadata("Skelboss")) { 
			
			Skeleton skel2 = (Skeleton) entity.getKiller().getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.SKELETON);
			skel2.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lDead Spirit"));
		  	skel2.setCustomNameVisible(true);
		  	skel2.setRemoveWhenFarAway(false);
            skel2.getEquipment().setHelmet(new ItemStack(Material.WITHER_SKELETON_SKULL));
            skel2.setMetadata("Skelboss",new FixedMetadataValue(plugin,"skelboss"));
            MainClass.getEconomy().depositPlayer(entity.getKiller(), 5);
			
		}
	
	}
	@EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
		
		
		
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Zombie){
        	Player p = (Player) e.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location cemetery = new Location(world, 674.5, 49, 135.5);
        	if (e.getDamage() >= p.getHealth()) {
        		
        		p.setHealth(20);
        		p.setFoodLevel(20);
        		p.teleport(cemetery);
        		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 150, 10, false, false), false);
        		
        		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    				@Override public void run() { 
    					p.sendMessage(prefix + ChatColor.RED + "You've been killed, but you came back from the deads!");
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    					
    					
    				} }, 10L);
        		
				
        	}
  
        } else if(e.getEntity() instanceof Player && e.getDamager() instanceof PigZombie){
        	Player p = (Player) e.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location cemetery = new Location(world, 674.5, 49, 135.5);
        	if (e.getDamage() >= p.getHealth()) {
        		
        		p.setHealth(20);
        		p.setFoodLevel(20);
        		p.teleport(cemetery);
        		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 150, 10, false, false), false);
        		
        		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    				@Override public void run() { 
    					p.sendMessage(prefix + ChatColor.RED + "You've been killed, but you came back from the dead!");
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    					
    					
    				} }, 10L);
        	}
				
        } else if(e.getEntity() instanceof Player && e.getDamager() instanceof Arrow){
        	Player p = (Player) e.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location cemetery = new Location(world, 674.5, 49, 135.5);
    		if (p.hasPermission("steven.fighting")) {
    			return;
    		} else {
            	if (e.getDamage() >= p.getHealth()) {
            		
            		p.setHealth(20);
            		p.setFoodLevel(20);
            		p.teleport(cemetery);
            		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 150, 10, false, false), false);
            		
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        				@Override public void run() { 
        					p.sendMessage(prefix + ChatColor.RED + "You've been killed, but you came back from the dead!");
        	        		spawnFireworks(p.getLocation(), 1, Color.RED);
        	        		spawnFireworks(p.getLocation(), 1, Color.RED);
        					
        					
        				} }, 10L);
            		
    				
            }    			
    		}
      
        } else if(e.getEntity() instanceof Player && e.getDamager() instanceof WitherSkeleton){
        	Player p = (Player) e.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location cemetery = new Location(world, 674.5, 49, 135.5);
    		if (p.hasPermission("steven.fighting")) {
    			return;
    		}
        	if (e.getDamage() >= p.getHealth()) {
        		
        		p.setHealth(20);
        		p.setFoodLevel(20);
        		p.teleport(cemetery);
        		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 150, 10, false, false), false);
        		
        		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    				@Override public void run() { 
    					p.sendMessage(prefix + ChatColor.RED + "You've been killed, but you came back from the dead!");
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    	        		spawnFireworks(p.getLocation(), 1, Color.RED);
    					
    					
    				} }, 10L);
        		
				
        }
       
            
        }
    }
	
	/*@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		World world = Bukkit.getWorld("Halloween");
		Location cemetery = new Location(world, 674.5, 49, 135.5);
		Player p = e.getEntity();
		
		if(e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent nEvent = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
			
			if (nEvent.getDamager() instanceof Zombie) {
				
				p.teleport(cemetery);
				
		  } if (nEvent.getDamager() instanceof PigZombie) {
			  	p.teleport(cemetery);
		  }
		} else {
			return;
		}
	}*/
	
}
