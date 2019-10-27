package com.spikeyhunter.halloweenmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Llama.Color;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class CustomCreatures implements CommandExecutor, Listener {

	private MainClass plugin;
	public CustomCreatures(MainClass main) {
		this.plugin = main;
	}
	
    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	static World world = Bukkit.getWorld("Halloween");
	static Location location1 = new Location(world, 432, 53, 147);
	static Location location2 = new Location(world, 418, 53, 147);
	static Location location3 = new Location(world, 425, 53, 155);
	static Location location4 = new Location(world, 432, 53, 167);
	static Location location5 = new Location(world, 418, 53, 167);
	static Location location6 = new Location(world, 425, 53, 179);
	static Location location7 = new Location(world, 418, 53, 187);
	static Location location8 = new Location(world, 432, 53, 187);

	static Location location9 = new Location(world, 394, 54, 140);
	static Location location10 = new Location(world, 374, 53, 140);
	static Location location11 = new Location(world, 354, 53, 140);
	static Location location12 = new Location(world, 354, 53, 123);
	static Location location13 = new Location(world, 354, 53, 106);
	static Location location14 = new Location(world, 374, 53, 106);
	static Location location15 = new Location(world, 394, 53, 106);
	static Location location16 = new Location(world, 394, 53, 123);


	static Location location17 = new Location(world, 394, 63, 140);
	static Location location18 = new Location(world, 374, 63, 140);
	static Location location19 = new Location(world, 354, 63, 140);
	static Location location20 = new Location(world, 354, 63, 123);
	static Location location21 = new Location(world, 354, 63, 106);
	static Location location22 = new Location(world, 374, 63, 106);
	static Location location23 = new Location(world, 394, 63, 106);
	static Location location24 = new Location(world, 394, 63, 123);
    

    static Location Steven = new Location(world, 482.5, 19, 335.5);
    
    String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
    String worldname = "Halloween";
    
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
	    
	    
	
			
			Player p = (Player) sender;
			
			/*
			 * Commands for /event
			 * 
			 * 0- /event help
			 * 1- /event zombie reset
			 * 2- /event zombie spawn
			 * 
			 */
			
		if (p.hasPermission("halloween.admin")) {
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("zombie")) { 		/* command /event zombie */
					if (args[1].equalsIgnoreCase("clear")) {
						
						List<Entity> entityList = (List<Entity>) world.getEntitiesByClasses(Zombie.class);
						List<Entity> angryZombies = entityList.stream().filter(e->e.hasMetadata("Angry")).collect(Collectors.toList());
						List<Entity> normalZombies = entityList.stream().filter(e->e.hasMetadata("Normal")).collect(Collectors.toList());
						
						List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(PigZombie.class);
						List<Entity> angryPigman = entityList2.stream().filter(e->e.hasMetadata("AngryPigman")).collect(Collectors.toList());
						List<Entity> angryMinion = entityList2.stream().filter(e->e.hasMetadata("AngryMinion")).collect(Collectors.toList());
						
								
						angryZombies.forEach(e->e.remove());
						normalZombies.forEach(e->e.remove());
						angryPigman.forEach(e->e.remove());
						angryMinion.forEach(e->e.remove());
						
						p.sendMessage(prefix + ChatColor.GREEN + "All zombies were cleared from the event.");
						
						
				  } else if (args[1].equalsIgnoreCase("normal")) {			  
					  for (int i2 = 0; i2 < 50; i2++) {
					  	Zombie zombie2 = (Zombie) p.getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.ZOMBIE);
						zombie2.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lDead Walker"));
					  	zombie2.setCustomNameVisible(true);
					  	zombie2.setRemoveWhenFarAway(false);
			            zombie2.setMetadata("Normal",new FixedMetadataValue(plugin,"normal"));
					  }  
			            p.sendMessage(prefix + ChatColor.GREEN + "You have spawned 50x Normal Zombies"); 
			            
				  } else if (args[1].equalsIgnoreCase("boss")) {
					  for (int i2 = 0; i2 < 10; i2++) {
					  	
						Zombie zombie = (Zombie) p.getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.ZOMBIE);
					  	zombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lDead Walker"));
					  	zombie.setCustomNameVisible(true);
					  	zombie.setRemoveWhenFarAway(false);
			            zombie.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
			            zombie.setMetadata("Angry",new FixedMetadataValue(plugin,"angry"));
					  }
					  
					  p.sendMessage(prefix + ChatColor.GREEN + "You have spawned 10x Boss Zombies"); 
				  }
					
					
			}else if (args[0].equalsIgnoreCase("skeleton")) { 		/* command /event skeleton */
				if (args[1].equalsIgnoreCase("clear")) {
					
					List<Entity> entityList = (List<Entity>) world.getEntitiesByClasses(Skeleton.class);
					List<Entity> Skelboss = entityList.stream().filter(e->e.hasMetadata("Skelboss")).collect(Collectors.toList());
					List<Entity> Skelnormal = entityList.stream().filter(e->e.hasMetadata("Skelnormal")).collect(Collectors.toList());
					
					List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(WitherSkeleton.class);
					List<Entity> Witherboss = entityList2.stream().filter(e->e.hasMetadata("WitherBoss")).collect(Collectors.toList());
					
					List<Entity> entityList3 = (List<Entity>) world.getEntitiesByClasses(Zombie.class);
					List<Entity> Witherminion = entityList3.stream().filter(e->e.hasMetadata("Witherminion")).collect(Collectors.toList());
					
							
					Skelboss.forEach(e->e.remove());
					Skelnormal.forEach(e->e.remove());
					Witherboss.forEach(e->e.remove());
					Witherminion.forEach(e->e.remove());
					
					p.sendMessage(prefix + ChatColor.GREEN + "All skeletons were cleared from the event.");
					
					
			  } else if (args[1].equalsIgnoreCase("normal")) {			  
				  for (int i2 = 0; i2 < 50; i2++) {
				  	Skeleton skel = (Skeleton) p.getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.SKELETON);
					skel.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lDead Spirit"));
				  	skel.setCustomNameVisible(true);
				  	skel.setRemoveWhenFarAway(false);
		            skel.setMetadata("Skelnormal",new FixedMetadataValue(plugin,"skelnormal"));
				  }  
		            p.sendMessage(prefix + ChatColor.GREEN + "You have spawned 50x Normal Skeletons"); 
		            
			  } else if (args[1].equalsIgnoreCase("boss")) {
				  for (int i2 = 0; i2 < 10; i2++) {
				  	
					Skeleton skel2 = (Skeleton) p.getWorld().spawnEntity(list.get(randomGenerator.nextInt(list.size())), EntityType.SKELETON);
				  	skel2.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lDead Spirit"));
				  	skel2.setCustomNameVisible(true);
				  	skel2.setRemoveWhenFarAway(false);
		            skel2.getEquipment().setHelmet(new ItemStack(Material.WITHER_SKELETON_SKULL));
		            skel2.setMetadata("Skelboss",new FixedMetadataValue(plugin,"skelboss"));
				  }
				  
				  p.sendMessage(prefix + ChatColor.GREEN + "You have spawned 10x Boss Skeletons"); 
			  }
				
				
		} else if (args[0].equalsIgnoreCase("steven")) {
			if (args[1].equalsIgnoreCase("spawn")) {
				
				Llama steven = (Llama) p.getWorld().spawnEntity(Steven, EntityType.LLAMA);
				steven.setCustomName(ChatColor.translateAlternateColorCodes('&', "&d&lSteven"));
			  	steven.setCustomNameVisible(true);
			  	steven.setRemoveWhenFarAway(false);
			  	steven.setMaxHealth(40.0);
			  	steven.setHealth(40.0);
			  	steven.setBaby();
			  	steven.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 10000, false, false), false);
			  	steven.setColor(Color.CREAMY);
	            steven.setMetadata("Steven",new FixedMetadataValue(plugin,"steven"));
	            p.sendMessage(prefix + ChatColor.GREEN + "You have spawned Steven The Llama"); 
			}else if (args[1].equalsIgnoreCase("clear")) {
				
				List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
				List<Entity> CaveSpider1 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider1")).collect(Collectors.toList());
				List<Entity> CaveSpider2 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider2")).collect(Collectors.toList());
				CaveSpider1.forEach(e->e.remove());
				CaveSpider2.forEach(e->e.remove());
				
				List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
				List<Entity> Spider1 = entityList2.stream().filter(e->e.hasMetadata("Spider1")).collect(Collectors.toList());
				List<Entity> Spider2 = entityList2.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
				Spider1.forEach(e->e.remove());
				Spider2.forEach(e->e.remove());
				
				List<Entity> entityList3 = (List<Entity>) world.getEntitiesByClasses(Skeleton.class);
				List<Entity> Skell1 = entityList3.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
				Skell1.forEach(e->e.remove());
				
				List<Entity> entityList4 = (List<Entity>) world.getEntitiesByClasses(Llama.class);
				List<Entity> Steven = entityList4.stream().filter(e->e.hasMetadata("StevenBoss")).collect(Collectors.toList());
				Steven.forEach(e->e.remove());
				
	            p.sendMessage(prefix + ChatColor.GREEN + "Steven arena was cleared"); 
			}  else {

	            p.sendMessage(prefix + ChatColor.RED + "Wrong Command"); 
			}
			} else if (args[0].equalsIgnoreCase("admin")) { 
				if (args[1].equalsIgnoreCase("all")) {
					/* All admin mode */
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user SpikeyHunter permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user SpikeyHunter permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user SpikeyHunter permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user SpikeyHunter permission set thorne.talk false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user SpikeyHunter permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Issemir permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Issemir permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Issemir permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Issemir permission set thorne.talk false");
					
					
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user DysonHoover permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user DysonHoover permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user DysonHoover permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user DysonHoover permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user MoCaveman permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user MoCaveman permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user MoCaveman permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user MoCaveman permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Livvy1205 permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Livvy1205 permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Livvy1205 permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Livvy1205 permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Thomasims permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Thomasims permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Thomasims permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Thomasims permission set thorne.talk false");
					
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Deptak_ permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Deptak_ permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Deptak_ permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Deptak_ permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Varhagna permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Varhagna permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Varhagna permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Varhagna permission set thorne.talk false");

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Apollo32 permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Apollo32 permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Apollo32 permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user Apollo32 permission set thorne.talk false");
					
				} else {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + args[1] + " permission set ghost.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + args[1] + " permission set ghost.talked false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + args[1] + " permission set portal.use false");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + args[1] + " permission set thorne.talk false");
				}
				
				
				
			} else {p.sendMessage(prefix + ChatColor.RED + "Incorrect usage. Use /event help");}

	} else {p.sendMessage(prefix + ChatColor.RED + "Incorrect usage. Use /event help");}

		} else {p.sendMessage(prefix + ChatColor.RED + "Sorry, you don't have permission to use this.");}
			
			
			
		
		
		
		return true;
	}

}
