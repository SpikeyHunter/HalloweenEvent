package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.md_5.bungee.api.ChatColor;

public class StevenDeaths implements Listener {
	
	
	private MainClass plugin;
	public StevenDeaths(MainClass main) {
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
	public void OnEntityDamageEvent(EntityDamageEvent e) {
		
		if (e.getCause() == DamageCause.LIGHTNING || e.getCause() == DamageCause.FIRE) {
			if (e.getEntity() instanceof Player) {
				if (e.getEntity().hasPermission("steven.fighting")){
	        	Player p = (Player) e.getEntity();
	        	World world = Bukkit.getWorld("Halloween");
	    		Location arena = new Location(world, 482.5, 16, 294.5);
	    	    Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
	        	if (e.getDamage() >= p.getHealth()) {
	        		p.setHealth(20);
	        		p.setFoodLevel(15);
	        		if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead1")){
	        			p.teleport(arena);
	            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
	            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 1 life left.");
	            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 true");
	            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 false");
	        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead2")){
	        			p.teleport(arena);
	            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
	            		p.sendMessage(prefix + ChatColor.RED + "You were killed! This is your last chance.");
	            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead3 true");
	            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 false");
	        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead3")){
	        			p.teleport(caveentrance);
	        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.fighting");
	        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead3");
	        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead2");
	        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead1");
	       	         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
	        			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	            			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
	                		p.sendMessage(prefix + ChatColor.RED + "You were killed too many times please try fighting again later");
	        				
	        		}else {
	        			p.teleport(arena);
	            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
	            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 2 lives left.");
	            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 true");
	        		}
	        		}
	        	
				} else {
					e.setCancelled(true);
				}
	        } else {
				e.setCancelled(true);
			}
			
		}
		
		if (e.getCause() == DamageCause.PROJECTILE) {
			if (e.getEntity() instanceof Skeleton) {
				return;
			} else if (e.getEntity() instanceof Spider) {
				return;
			}  else {
				e.setCancelled(true);
			}
			
		}
		
		if (e.getCause() == DamageCause.FIRE) {
			e.setCancelled(true);
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
	private static final Field PROFILE_FIELD;

    static {

        Field profileField = null;

        try {
            profileField = Class.forName("org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + ".inventory.CraftMetaSkull").getDeclaredField("profile");
            profileField.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        PROFILE_FIELD = profileField;
    }

    public static void setSkull(ItemMeta meta, UUID uuid, String minecraftUrl) {
        
        
        final String url = String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/" + minecraftUrl);
        final String base64 = Base64.getEncoder().encodeToString(url.getBytes());
        final GameProfile profile = new GameProfile(uuid, null);

        profile.getProperties().put("textures", new Property("textures", base64));
        try {
            PROFILE_FIELD.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private ItemStack StevenEssence(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("5729c0d1-3972-4044-b0a1-74e35420b1ea"), "e8f16477aeaffc602e2e1d3bb40c272f0f621145fe5219ae62e2a5bbcf67a");

    	skull.setItemMeta(meta);
        
        meta.setDisplayName("§d§lSteven Essence");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Steven X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oMay this llama");
    	lore.add("§8§ofind his way!");
    	
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
    	
		return skull;
    	
    }
/*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @EventHandler
	public void onStevenDeath(EntityDeathEvent event) {

		LivingEntity entity = event.getEntity();
		World world = Bukkit.getWorld("Halloween");
		Location lsteven = new Location(world, 482.5, 19, 331.5);
		Location center = new Location(world, 482.5, 19, 335.5);
		 
		if(entity.getType() == EntityType.LLAMA && entity.hasMetadata("StevenBoss")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + entity.getKiller().getName() + " permission unset steven.fighting");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + entity.getKiller().getName() + " permission unset steven.dead3");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + entity.getKiller().getName() + " permission unset steven.dead2");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + entity.getKiller().getName() + " permission unset steven.dead1");
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
	        
	        int task=Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() { 
				@Override
				  public void run() {
					List<Entity> entityList = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
					List<Entity> CaveSpider2 = entityList.stream().filter(e->e.hasMetadata("CaveSpider2")).collect(Collectors.toList());
					CaveSpider2.forEach(e->e.remove());
						
				  }
				  
			},10, 10);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				  @Override
				  public void run() {
				  Bukkit.getServer().getScheduler().cancelTask(task);
				  
				  }
				  },2000);
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    			@Override public void run() {
    				entity.getKiller().teleport(lsteven);
    				spawnFireworks(center, 1, Color.RED); 
    				} }, 20L);
	        
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    			@Override public void run() {
    				spawnFireworks(entity.getKiller().getLocation(), 1, Color.RED); 
    				spawnFireworks(entity.getKiller().getLocation(), 1, Color.RED); 
    				} }, 40L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    			@Override public void run() {
    				spawnFireworks(center, 1, Color.RED); 
    				spawnFireworks(center, 1, Color.RED); 
    				} }, 80L);	
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {entity.getKiller().sendMessage(prefix + ChatColor.GREEN + "You've saved Steven! May he rest in peace. Here's his essence as a gift.");
        			entity.getKiller().getInventory().addItem(StevenEssence(entity.getKiller()));; } }, 100L);
				
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {entity.getKiller().sendMessage(prefix + ChatColor.GREEN + "You can now take the portal back to the cave.");; } }, 140L);
			
		}
		
	}
	
	
	@EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event){
		
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Spider){
        	Player p = (Player) event.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location arena = new Location(world, 482.5, 16, 294.5);
    	    Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
        	if (event.getDamage() >= p.getHealth()) {
        		p.setHealth(20);
        		p.setFoodLevel(15);
        		if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead1")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 1 life left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead2")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! This is your last chance.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead3 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead3")){
        			p.teleport(caveentrance);
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.fighting");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead3");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead2");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead1");
       	         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
        			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
            			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
                		p.sendMessage(prefix + ChatColor.RED + "You were killed too many times please try fighting again later");
                		
                		List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(Spider.class);
        				List<Entity> Spider1 = entityList1.stream().filter(e->e.hasMetadata("Spider1")).collect(Collectors.toList());
        				Spider1.forEach(e->e.remove());
        				
        				List<Entity> entityList3 = (List<Entity>) world.getEntitiesByClasses(WitherSkeleton.class);
        				List<Entity> Skell1 = entityList3.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
        				Skell1.forEach(e->e.remove());
        				
        				List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Llama.class);
        				List<Entity> Steven = entityList2.stream().filter(e->e.hasMetadata("StevenBoss")).collect(Collectors.toList());
        				Steven.forEach(e->e.remove());
        		}else {
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 2 lives left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 true");
        		}}
        }else if(event.getEntity() instanceof Player && event.getDamager() instanceof CaveSpider){
        	Player p = (Player) event.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location arena = new Location(world, 482.5, 16, 294.5);
    	    Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
        	if (event.getDamage() >= p.getHealth()) {
        		p.setHealth(20);
        		p.setFoodLevel(15);
        		if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead1")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 1 life left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead2")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! This is your last chance.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead3 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead3")){
        			p.teleport(caveentrance);
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.fighting");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead3");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead2");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead1");
       	         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
        			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
            			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
                		p.sendMessage(prefix + ChatColor.RED + "You were killed too many times please try fighting again later");
                		
                		List<Entity> entityList1 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
        				List<Entity> CaveSpider2 = entityList1.stream().filter(e->e.hasMetadata("CaveSpider2")).collect(Collectors.toList());
        				CaveSpider2.forEach(e->e.remove());
        				
        				List<Entity> entityList3 = (List<Entity>) world.getEntitiesByClasses(CaveSpider.class);
        				List<Entity> CaveSpider1 = entityList3.stream().filter(e->e.hasMetadata("CaveSpider1")).collect(Collectors.toList());
        				CaveSpider1.forEach(e->e.remove());
        				
        				List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Llama.class);
        				List<Entity> Steven = entityList2.stream().filter(e->e.hasMetadata("StevenBoss")).collect(Collectors.toList());
        				Steven.forEach(e->e.remove());
        		}else {
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 2 lives left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 true");
        		}}
        }else if(event.getEntity() instanceof Player && event.getDamager() instanceof WitherSkeleton){
        	Player p = (Player) event.getEntity();
        	World world = Bukkit.getWorld("Halloween");
    		Location arena = new Location(world, 482.5, 16, 294.5);
    	    Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
        	if (event.getDamage() >= p.getHealth()) {
        		p.setHealth(20);
        		p.setFoodLevel(15);
        		if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead1")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 1 life left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead2")){
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! This is your last chance.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead3 true");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead2 false");
        		}else if (p.hasPermission("steven.fighting") && p.hasPermission("steven.dead3")){
        			p.teleport(caveentrance);
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.fighting");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead3");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead2");
        			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead1");
       	         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
        			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
            			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
                		p.sendMessage(prefix + ChatColor.RED + "You were killed too many times please try fighting again later");
        				
        				List<Entity> entityList3 = (List<Entity>) world.getEntitiesByClasses(WitherSkeleton.class);
        				List<Entity> Skell1 = entityList3.stream().filter(e->e.hasMetadata("SpiderJockey")).collect(Collectors.toList());
        				Skell1.forEach(e->e.remove());
        				
        				List<Entity> entityList2 = (List<Entity>) world.getEntitiesByClasses(Llama.class);
        				List<Entity> Steven = entityList2.stream().filter(e->e.hasMetadata("StevenBoss")).collect(Collectors.toList());
        				Steven.forEach(e->e.remove());
        		}else {
        			p.teleport(arena);
            		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        			@Override public void run() {spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED); } }, 10L);
            		p.sendMessage(prefix + ChatColor.RED + "You were killed! You have 2 lives left.");
            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user "+ p.getName() +" permission set steven.dead1 true");
        		}}
        } else if(event.getEntity() instanceof Llama && event.getDamager() instanceof CaveSpider){
        	event.setCancelled(true);
        }
		
	}

}
