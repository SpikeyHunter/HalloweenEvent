 package com.spikeyhunter.halloweenmain;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Llama.Color;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

		public class StevenBoss implements Listener {

			
			private MainClass plugin;
		
			public StevenBoss(MainClass main) {
				this.plugin = main;
			}
		
		
			static World world = Bukkit.getWorld("Halloween");

    		static Location fight = new Location(world, 482.5, 16, 294.5);
			static Location l1 = new Location(world, 494, 16, 287);
			static Location l2 = new Location(world, 494, 16, 291);
			static Location l3 = new Location(world, 494, 16, 295);
			static Location l4 = new Location(world, 494, 16, 299);
			static Location l5 = new Location(world, 494, 16, 303);
			static Location l6 = new Location(world, 494, 16, 307);
			static Location l7 = new Location(world, 490, 16, 285);
			static Location l8 = new Location(world, 490, 16, 289);
			static Location l9 = new Location(world, 490, 16, 293);
			static Location l10 = new Location(world, 490, 16, 297);
			static Location l11 = new Location(world, 490, 16, 301);
			static Location l12 = new Location(world, 490, 16, 305);
			static Location l13 = new Location(world, 490, 16, 309);
			static Location l14 = new Location(world, 486, 16, 283);
			static Location l15 = new Location(world, 486, 16, 287);
			static Location l16 = new Location(world, 486, 16, 291);
			static Location l17 = new Location(world, 486, 16, 295);
			static Location l18 = new Location(world, 486, 16, 299);
			static Location l19 = new Location(world, 486, 16, 303);
			static Location l20 = new Location(world, 482, 16, 281);
			static Location l21 = new Location(world, 482, 16, 285);
			static Location l22 = new Location(world, 482, 16, 289);
			static Location l23 = new Location(world, 482, 16, 293);
			static Location l24 = new Location(world, 482, 16, 298);
			static Location l25 = new Location(world, 482, 16, 301);
			static Location l26 = new Location(world, 482, 16, 305);
			static Location l27 = new Location(world, 478, 16, 283);
			static Location l28 = new Location(world, 478, 16, 287);
			static Location l29 = new Location(world, 478, 16, 291);
			static Location l30 = new Location(world, 478, 16, 295);
			static Location l31 = new Location(world, 478, 16, 299);
			static Location l32 = new Location(world, 478, 16, 303);
			static Location l33 = new Location(world, 474, 16, 285);
			static Location l34 = new Location(world, 474, 16, 289);
			static Location l35 = new Location(world, 474, 16, 293);
			static Location l36 = new Location(world, 474, 16, 297);
			static Location l37 = new Location(world, 474, 16, 301);
			static Location l38 = new Location(world, 474, 16, 305);
			static Location l39 = new Location(world, 474, 16, 309);
			static Location l40 = new Location(world, 470, 16, 287);
			static Location l41 = new Location(world, 470, 16, 291);
			static Location l42 = new Location(world, 470, 16, 295);
			static Location l43 = new Location(world, 470, 16, 299);
			static Location l44 = new Location(world, 470, 16, 303);
			static Location l45 = new Location(world, 470, 16, 307);
			
			static Location lm1 = new Location(world, 492, 16, 287);
			static Location lm2 = new Location(world, 492, 16, 295);
			static Location lm3 = new Location(world, 492, 16, 305);
			static Location lm4 = new Location(world, 488, 16, 290);
			static Location lm5 = new Location(world, 488, 16, 300);
			static Location lm6 = new Location(world, 484, 16, 287);
			static Location lm7 = new Location(world, 484, 16, 305);
			static Location lm8 = new Location(world, 480, 16, 287);
			static Location lm9 = new Location(world, 480, 16, 305);
			static Location lm10 = new Location(world, 475, 16, 290);
			static Location lm11 = new Location(world, 475, 16, 300);
			static Location lm12 = new Location(world, 472, 16, 287);
			static Location lm13 = new Location(world, 472, 16, 295);
			static Location lm14 = new Location(world, 472, 16, 305);
			
			static Location ls1 = new Location(world, 482, 19, 325);
			static Location ls2 = new Location(world, 492, 19, 335);
			static Location ls3 = new Location(world, 482, 19, 345);
			static Location ls4 = new Location(world, 472, 19, 335);
			
			
			
			@SuppressWarnings("deprecation")
			@EventHandler
			public void onDamageEntity(EntityDamageByEntityEvent e) {
			
				
				
				if (e.getEntity() instanceof Llama && e.getDamager() instanceof Player) {
					if (e.getEntity().hasMetadata("Steven")) {
						Location location = e.getEntity().getLocation();
						Player p = (Player) e.getDamager();
						e.getEntity().remove();
						location.getWorld().strikeLightning(location);
		
						Llama boss = (Llama) location.getWorld().spawnEntity(location, EntityType.LLAMA);
						boss.setCustomName(ChatColor.translateAlternateColorCodes('&', "&d&lSteven"));
						boss.setCustomNameVisible(true);
						boss.setRemoveWhenFarAway(false);
						boss.setMaxHealth(120.0);
						boss.setHealth(120.0);
						boss.setAdult();
						boss.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100000, 1, false, false), false);
					  	boss.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 10000, false, false), false);
						boss.setColor(Color.CREAMY);
						boss.setMetadata("StevenBoss", new FixedMetadataValue(plugin, "stevenboss"));
						p.teleport(fight);
		
						wave1(boss, (Player) e.getDamager());
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							@Override public void run() { 
									boss.setTarget(p);
									boss.removePotionEffect(PotionEffectType.SLOW);
									boss.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100000, 1, false, false), false);
						            boss.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false), false);
								}} , 6500L);
						
						new BukkitRunnable() {
				            @Override
				            public void run() {
				            	if(boss.isDead()){
				                    cancel();
				                    return;
				                }
				            	boss.getWorld().playEffect(boss.getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
				            }
				        }.runTaskTimer(plugin,20,20);
					}
		
				}
			}
			private void wave1(Llama boss, Player damager) {
				ArrayList<Location> s1r = new ArrayList<Location>();
				s1r.add(lm1);s1r.add(lm2);s1r.add(lm3);s1r.add(lm4);s1r.add(lm5);s1r.add(lm6);s1r.add(lm7);s1r.add(lm8);s1r.add(lm9);
				s1r.add(lm10);s1r.add(lm11);s1r.add(lm12);s1r.add(lm13);s1r.add(lm14);
				Player p = (Player) damager;
				String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
				String steven = (ChatColor.translateAlternateColorCodes('&', "&d&lSteven &8>> "));
				String servant = (ChatColor.translateAlternateColorCodes('&', "&4&lServant"));
				Location redstoneleft = new Location(Bukkit.getWorld("Halloween"), 497, 13, 310);
				Location redstoneright = new Location(Bukkit.getWorld("Halloween"), 467, 13, 310);
				
				if (boss.isDead()) {
					return;
				} else {
					if (redstoneleft.getBlock().getType().equals(Material.AIR) && redstoneright.getBlock().getType().equals(Material.AIR)) {
						redstoneleft.getBlock().setType(Material.REDSTONE_BLOCK);
						redstoneright.getBlock().setType(Material.REDSTONE_BLOCK);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg removemember arenalock -w Halloween " + p.getName());
				  } else {
						return;
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "How dare you try fighting me! Servants, protect me!");
							}} , 50L);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Wave 1 has started. Fight Steven's servants!");
							}} , 50L);
					
					int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() { 
						  @Override
						  public void run() {
					      Random randomSpider1 = new Random();	
						  Location spider1 = s1r.get(randomSpider1.nextInt(s1r.size()));
						  Location spider2 = s1r.get(randomSpider1.nextInt(s1r.size()));
						  Location spider3 = s1r.get(randomSpider1.nextInt(s1r.size()));
						  Location spider4 = s1r.get(randomSpider1.nextInt(s1r.size()));
						  Location spider5 = s1r.get(randomSpider1.nextInt(s1r.size()));
						  Spider s1 = (Spider) p.getWorld().spawnEntity(spider1, EntityType.SPIDER);
						  	s1.setRemoveWhenFarAway(false);
				            s1.setMetadata("Spider1",new FixedMetadataValue(plugin,"spider1"));
				            s1.setCustomName(servant);
				            s1.setCustomNameVisible(true);
				            s1.setTarget(damager);
				            s1.removePassenger(s1);
						  Spider s2 = (Spider) p.getWorld().spawnEntity(spider2, EntityType.SPIDER);
						  	s2.setRemoveWhenFarAway(false);
				            s2.setMetadata("Spider1",new FixedMetadataValue(plugin,"spider1"));
				            s2.setCustomName(servant);
				            s2.setCustomNameVisible(true);
				            s2.setTarget(damager);
				            s2.removePassenger(s2);
						  Spider s3 = (Spider) p.getWorld().spawnEntity(spider3, EntityType.SPIDER);
						  	s3.setRemoveWhenFarAway(false);
				            s3.setMetadata("Spider1",new FixedMetadataValue(plugin,"spider1"));
				            s3.setCustomName(servant);
				            s3.setCustomNameVisible(true);
				            s3.setTarget(damager);
				            s3.removePassenger(s3);
						  Spider s4 = (Spider) p.getWorld().spawnEntity(spider4, EntityType.SPIDER);
						  	s4.setRemoveWhenFarAway(false);
				            s4.setMetadata("Spider1",new FixedMetadataValue(plugin,"spider1"));
				            s4.setCustomName(servant);
				            s4.setCustomNameVisible(true);
				            s4.setTarget(damager);
				            s4.removePassenger(s4);
						  Spider s5 = (Spider) p.getWorld().spawnEntity(spider5, EntityType.SPIDER);
						  	s5.setRemoveWhenFarAway(false);
				            s5.setMetadata("Spider1",new FixedMetadataValue(plugin,"spider1"));
				            s5.setCustomName(servant);
				            s5.setCustomNameVisible(true);
				            s5.setTarget(damager);
				            s5.removePassenger(s5);
						  	
						  }
						  },20, 200);
						  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						  @Override
						  public void run() {
						  Bukkit.getServer().getScheduler().cancelTask(task);
						  }
						  },1500);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
									List<Entity> Spider1 = entityList1.stream().filter(e->e.hasMetadata("Spider1")).collect(Collectors.toList());
									Spider1.forEach(e->e.getWorld().strikeLightning(e.getLocation()));
								}} , 1600L); //One minute later
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
									List<Entity> Spider1 = entityList1.stream().filter(e->e.hasMetadata("Spider1")).collect(Collectors.toList());
									Spider1.forEach(e->e.remove());
									p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "It's not because you defeated them, that you'll win!!");
								}} , 1640L); //Despawning 
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
										p.sendMessage(prefix + ChatColor.GRAY + "Wave 2 will start soon. Get ready!");
									}} , 1680L);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									wave2(boss, damager);
									}} , 1800L);
				}
				
			}
			
			private void wave2(Llama boss, Player damager) {
				ArrayList<Location> s2r = new ArrayList<Location>();
				s2r.add(lm1);s2r.add(lm2);s2r.add(lm3);s2r.add(lm4);s2r.add(lm5);s2r.add(lm6);s2r.add(lm7);s2r.add(lm8);s2r.add(lm9);
				s2r.add(lm10);s2r.add(lm11);s2r.add(lm12);s2r.add(lm13);s2r.add(lm14);
				Player p = (Player) damager;
				String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
				String steven = (ChatColor.translateAlternateColorCodes('&', "&d&lSteven &8>> "));
				String servant2 = (ChatColor.translateAlternateColorCodes('&', "&4&lDeadly Servant"));
				
				if (boss.isDead()) {
					return;
				} else {
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "Arghh!! INVOKING my Deadly Servants!");
							}} , 50L);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Wave 2 has started. Fight Steven's servants!");
							}} , 50L);
					
					int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() { 
						  @Override
						  public void run() {
					      Random randomCaveSpider1 = new Random();	
						  Location spider6 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider7 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider8 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider9 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider10 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  CaveSpider s6 = (CaveSpider) p.getWorld().spawnEntity(spider6, EntityType.CAVE_SPIDER);
						  	s6.setRemoveWhenFarAway(false);
				            s6.setMetadata("CaveSpider1",new FixedMetadataValue(plugin,"cavespider1"));
				            s6.setCustomName(servant2);
				            s6.setCustomNameVisible(true);
				            s6.setTarget(damager);
				            s6.removePassenger(s6);
						  CaveSpider s7 = (CaveSpider) p.getWorld().spawnEntity(spider7, EntityType.CAVE_SPIDER);
						  	s7.setRemoveWhenFarAway(false);
				            s7.setMetadata("CaveSpider1",new FixedMetadataValue(plugin,"cavespider1"));
				            s7.setCustomName(servant2);
				            s7.setCustomNameVisible(true);
				            s7.setTarget(damager);
				            s7.removePassenger(s7);
						  CaveSpider s8 = (CaveSpider) p.getWorld().spawnEntity(spider8, EntityType.CAVE_SPIDER);
						  	s8.setRemoveWhenFarAway(false);
				            s8.setMetadata("CaveSpider1",new FixedMetadataValue(plugin,"cavespider1"));
				            s8.setCustomName(servant2);
				            s8.setCustomNameVisible(true);
				            s8.setTarget(damager);
				            s8.removePassenger(s8);
						  CaveSpider s9 = (CaveSpider) p.getWorld().spawnEntity(spider9, EntityType.CAVE_SPIDER);
						  	s9.setRemoveWhenFarAway(false);
				            s9.setMetadata("CaveSpider1",new FixedMetadataValue(plugin,"cavespider1"));
				            s9.setCustomName(servant2);
				            s9.setCustomNameVisible(true);
				            s9.setTarget(damager);
				            s9.removePassenger(s9);
						  CaveSpider s10 = (CaveSpider) p.getWorld().spawnEntity(spider10, EntityType.CAVE_SPIDER);
						  	s10.setRemoveWhenFarAway(false);
				            s10.setMetadata("CaveSpider1",new FixedMetadataValue(plugin,"cavespider1"));
				            s10.setCustomName(servant2);
				            s10.setCustomNameVisible(true);
				            s10.setTarget(damager);
				            s10.removePassenger(s10);
						  	
						  }
						  },20, 200);
						  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						  @Override
						  public void run() {
						  Bukkit.getServer().getScheduler().cancelTask(task);
						  }
						  },1500);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
									List<Entity> CaveSpider1 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider1")).collect(Collectors.toList());
									CaveSpider1.forEach(e->e.getWorld().strikeLightning(e.getLocation()));
								}} , 1700L); //One minute later
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
									List<Entity> CaveSpider1 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider1")).collect(Collectors.toList());
									CaveSpider1.forEach(e->e.remove());
									p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "How!? I swear, you can't defeat my warriors!!");
								}} , 1740L); //Despawning 
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
										p.sendMessage(prefix + ChatColor.GRAY + "Wave 3 will start soon. Get ready!");
									}} , 1780L);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									wave3(boss, damager);
									}} , 1800L);
				}
				
			}
			private void wave3(Llama boss, Player damager) {
				ArrayList<Location> s2r = new ArrayList<Location>();
				s2r.add(lm1);s2r.add(lm2);s2r.add(lm3);s2r.add(lm4);s2r.add(lm5);s2r.add(lm6);s2r.add(lm7);s2r.add(lm8);s2r.add(lm9);
				s2r.add(lm10);s2r.add(lm11);s2r.add(lm12);s2r.add(lm13);s2r.add(lm14);
				Player p = (Player) damager;
				String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
				String steven = (ChatColor.translateAlternateColorCodes('&', "&d&lSteven &8>> "));
				String servant3 = (ChatColor.translateAlternateColorCodes('&', "&4&lWarriors"));
				
				if (boss.isDead()) {
					return;
				} else {
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "Warriors! Come to me and fight!");
							}} , 50L);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Wave 3 has started. Fight Steven's warriors!");
							}} , 50L);
					
					int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() { 
						  @Override
						  public void run() {
					      Random randomCaveSpider1 = new Random();	
						  Location spider11 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider12 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider13 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider14 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Location spider15 = s2r.get(randomCaveSpider1.nextInt(s2r.size()));
						  Skeleton s11s = (Skeleton) p.getWorld().spawnEntity(spider11, EntityType.WITHER_SKELETON);
						  	s11s.setRemoveWhenFarAway(false);
				            s11s.setMetadata("SpiderJockey",new FixedMetadataValue(plugin,"spiderjockey"));
				            s11s.setTarget(damager);
				            s11s.setCustomName(servant3);
				            s11s.setCustomNameVisible(true);
						  Skeleton s12s = (Skeleton) p.getWorld().spawnEntity(spider12, EntityType.WITHER_SKELETON);
						  	s12s.setRemoveWhenFarAway(false);
				            s12s.setMetadata("SpiderJockey",new FixedMetadataValue(plugin,"spiderjockey"));
				            s12s.setTarget(damager);
				            s12s.setCustomName(servant3);
				            s12s.setCustomNameVisible(true);
						  Skeleton s13s = (Skeleton) p.getWorld().spawnEntity(spider13, EntityType.WITHER_SKELETON);
						  	s13s.setRemoveWhenFarAway(false);
				            s13s.setMetadata("SpiderJockey",new FixedMetadataValue(plugin,"spiderjockey"));
				            s13s.setTarget(damager);
				            s13s.setCustomName(servant3);
				            s13s.setCustomNameVisible(true);
						  Skeleton s14s = (Skeleton) p.getWorld().spawnEntity(spider14, EntityType.WITHER_SKELETON);
						  	s14s.setRemoveWhenFarAway(false);
				            s14s.setMetadata("SpiderJockey",new FixedMetadataValue(plugin,"spiderjockey"));
				            s14s.setTarget(damager);
				            s14s.setCustomName(servant3);
				            s14s.setCustomNameVisible(true);
						  Skeleton s15s = (Skeleton) p.getWorld().spawnEntity(spider15, EntityType.WITHER_SKELETON);
						  	s15s.setRemoveWhenFarAway(false);
				            s15s.setMetadata("SpiderJockey",new FixedMetadataValue(plugin,"spiderjockey"));
				            s15s.setTarget(damager);
				            s15s.setCustomName(servant3);
				            s15s.setCustomNameVisible(true);
						  	
						  }
						  },20, 200);
						  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						  @Override
						  public void run() {
						  Bukkit.getServer().getScheduler().cancelTask(task);
						  }
						  },1700);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
									List<Entity> SpiderJockey = entityList1.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
									SpiderJockey.forEach(e->e.getWorld().strikeLightning(e.getLocation()));
									
									List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Skeleton.class);
									List<Entity> Skeleton = entityList2.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
									Skeleton.forEach(e->e.getWorld().strikeLightning(e.getLocation()));
								}} , 1800L); //One minute later
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
									List<Entity> SpiderJockey = entityList1.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
									SpiderJockey.forEach(e->e.remove());
									List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Skeleton.class);
									List<Entity> Skeleton = entityList2.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
									Skeleton.forEach(e->e.remove());
									
									p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "Ahhhhh!! You're still not enough strong to defeat my powers!");
								}} , 1840L); //Despawning 
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
										p.sendMessage(prefix + ChatColor.GRAY + "Wave 4 will start soon. Get ready!");
									}} , 1880L);
						  
						  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
								@Override public void run() { 
									wave4(boss, damager);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "killall arrows Halloween");
									}} , 2000L);
				}
				
			}
			private void wave4(Llama boss, Player damager) {
				Player p = (Player) damager;
				String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
				String steven = (ChatColor.translateAlternateColorCodes('&', "&d&lSteven &8>> "));
				ArrayList<Location> w1 = new ArrayList<Location>();
				w1.add(l1); w1.add(l2); w1.add(l3);w1.add(l4);w1.add(l5);w1.add(l6);w1.add(l7);w1.add(l8);w1.add(l9);w1.add(l10);w1.add(l11);w1.add(l12);w1.add(l13);w1.add(l14);
				w1.add(l15);w1.add(l16);w1.add(l17);w1.add(l18);w1.add(l19);w1.add(l20);w1.add(l21);w1.add(l22);w1.add(l23);w1.add(l24);w1.add(l25);w1.add(l26);w1.add(l27);w1.add(l28);
				w1.add(l29);w1.add(l30);w1.add(l31);w1.add(l32);w1.add(l33);w1.add(l34);w1.add(l35);w1.add(l36);w1.add(l37);w1.add(l38);w1.add(l39);w1.add(l40);w1.add(l41);w1.add(l42);
				w1.add(l43);w1.add(l44);w1.add(l45);

				if (boss.isDead()) {
					return;
		
				} else {
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "May the power of the lighting destroy you!");
							}} , 50L);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Wave 4 has started. Try to avoid the lightning!");
							}} , 50L);
					
				  int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				  
				  @Override
				  public void run() {
				  Random randomSmite = new Random();	
				  Location radius = w1.get(randomSmite.nextInt(w1.size()));
				  Location radius2 = w1.get(randomSmite.nextInt(w1.size()));
				  Location radius3 = w1.get(randomSmite.nextInt(w1.size()));
				  Location radius4 = w1.get(randomSmite.nextInt(w1.size()));
				  Location radius5 = w1.get(randomSmite.nextInt(w1.size()));
				  radius.getWorld().strikeLightning(radius);
				  radius2.getWorld().strikeLightning(radius2);
				  radius3.getWorld().strikeLightning(radius3);
				  radius4.getWorld().strikeLightning(radius4);
				  radius5.getWorld().strikeLightning(radius5);
				  radius.getWorld().spawnEntity(radius, EntityType.LIGHTNING);
				  radius2.getWorld().spawnEntity(radius2, EntityType.LIGHTNING);
				  radius3.getWorld().spawnEntity(radius3, EntityType.LIGHTNING);
				  radius4.getWorld().spawnEntity(radius4, EntityType.LIGHTNING);
				  radius5.getWorld().spawnEntity(radius5, EntityType.LIGHTNING);
				  }
				  },20, 10);
				  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				  @Override
				  public void run() {
				  Bukkit.getServer().getScheduler().cancelTask(task);
				  p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "I see you're quick! Come up here and let's fight!");
				  
				  }
				  },600);
				  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Wave 5 will start soon. Go up and get ready to fight Steven!");
							}} , 740L);
				  
				  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
							wave5(boss, damager);
							Location redstoneleft = new Location(Bukkit.getWorld("Halloween"), 497, 13, 310);
							Location redstoneright = new Location(Bukkit.getWorld("Halloween"), 467, 13, 310);
							
							if (redstoneleft.getBlock().getType().equals(Material.REDSTONE_BLOCK) && redstoneright.getBlock().getType().equals(Material.REDSTONE_BLOCK)) {
									redstoneleft.getBlock().setType(Material.AIR);
									redstoneright.getBlock().setType(Material.AIR);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg addmember arenalock -w Halloween " + p.getName());
							  } else {
									return;
								}
						}} , 760L);
				 
			}}
			private void wave5(Llama boss, Player damager) {
				
				Player p = (Player) damager;
				String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
				String steven = (ChatColor.translateAlternateColorCodes('&', "&d&lSteven &8>> "));
				String servant5 = (ChatColor.translateAlternateColorCodes('&', "&3&lDeadly Spirit"));
				
				if (boss.isDead()) {
					return;
				} else {
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(steven + ChatColor.LIGHT_PURPLE + "Deadly Spirits I command you to fight!");
							}} , 100L);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
								p.sendMessage(prefix + ChatColor.GRAY + "Final wave has started. Fight Steven them and free Steven from the evil spirit");
							}} , 100L);
					
					int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() { 
						@Override
						  public void run() {
						  CaveSpider ss6 = (CaveSpider) p.getWorld().spawnEntity(ls1, EntityType.CAVE_SPIDER);
						  	ss6.setRemoveWhenFarAway(false);
				            ss6.setMetadata("CaveSpider2",new FixedMetadataValue(plugin,"cavespider2"));
				            ss6.setCustomName(servant5);
				            ss6.setCustomNameVisible(true);
				            ss6.setTarget(damager);
				            ss6.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false), false);
						  CaveSpider ss7 = (CaveSpider) p.getWorld().spawnEntity(ls2, EntityType.CAVE_SPIDER);
						  	ss7.setRemoveWhenFarAway(false);
				            ss7.setMetadata("CaveSpider2",new FixedMetadataValue(plugin,"cavespider2"));
				            ss7.setCustomName(servant5);
				            ss7.setCustomNameVisible(true);
				            ss7.setTarget(damager);
				            ss7.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false), false);
						  CaveSpider ss8 = (CaveSpider) p.getWorld().spawnEntity(ls3, EntityType.CAVE_SPIDER);
						  	ss8.setRemoveWhenFarAway(false);
				            ss8.setMetadata("CaveSpider2",new FixedMetadataValue(plugin,"cavespider2"));
				            ss8.setCustomName(servant5);
				            ss8.setCustomNameVisible(true);
				            ss8.setTarget(damager);
				            ss8.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false), false);
						  CaveSpider ss9 = (CaveSpider) p.getWorld().spawnEntity(ls4, EntityType.CAVE_SPIDER);
						  	ss9.setRemoveWhenFarAway(false);
				            ss9.setMetadata("CaveSpider2",new FixedMetadataValue(plugin,"cavespider2"));
				            ss9.setCustomName(servant5);
				            ss9.setCustomNameVisible(true);
				            ss9.setTarget(damager);
				            ss9.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1, false, false), false);	
						  }
						  
					},20, 150);
					
					 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						  @Override
						  public void run() {
						  Bukkit.getServer().getScheduler().cancelTask(task);
						  
						  }
						  },6000);
					 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						  @Override
						  public void run() {
							  List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
								List<Entity> CaveSpider2 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider2")).collect(Collectors.toList());
								CaveSpider2.forEach(e->e.remove());
						  
						  }
						  },6000);
					 
					 
				}
				
			}

		}
