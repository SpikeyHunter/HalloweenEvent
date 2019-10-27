package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.raidstone.wgevents.events.RegionEnteredEvent;
import net.raidstone.wgevents.events.RegionLeftEvent;

public class WorldGuardPortal implements Listener {
	
	private MainClass plugin;
	public WorldGuardPortal(MainClass main) {
		this.plugin = main;
	}
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
	static World world = Bukkit.getWorld("Halloween");
	static Location Ophelia = new Location(world, 362, 26, -49);
	static Location Village = new Location(world, 476, 26, -114);
	static Location Evanora = new Location(world, 539.5, 49, 154.5);
    static Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
    static Location lportalarena = new Location(world, 482.5, 16, 277.5);

	public HashMap<String, Long> cooldowns4 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns5 = new HashMap<String, Long>();
	
	@EventHandler
	public void onRegionLeft(RegionLeftEvent event)
	   {
		Player p = Bukkit.getPlayer(event.getUUID());
	       String region = event.getRegionName();
	       if(region.equals("stevenarena")) { 
	    	   int cooldownTime = 10;
				if (cooldowns5.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns5.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns5.put(p.getName(), System.currentTimeMillis());
	       if (p.getGameMode() == GameMode.SPECTATOR) {
				p.teleport(caveentrance);
				p.sendMessage(prefix + ChatColor.RED + "You've left the arena spectating mode.");
				p.setGameMode(GameMode.SURVIVAL);
				spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED);
			} else {
				return;
			}
	       } 
	   }
	   @EventHandler
	   public void onRegionEntered(RegionEnteredEvent event) {
	       Player p = Bukkit.getPlayer(event.getUUID());
	       String region = event.getRegionName();
	       
	       if(region.equals("portalspawn")) {
	    	   if (p.hasPermission("portal.use")) {
	    		   return;
	    	   } else {
	    		   p.sendMessage(prefix + ChatColor.RED + "You can't enter this portal yet. Go talk with Ophelia");
	    		   p.teleport(Ophelia);
	    	   }
	    	   
	       } else if (region.equals("mansion")) {
	    	   if (p.hasPermission("halloween.admin") || p.getInventory().contains(Material.WOODEN_SWORD, 1)
						|| p.getInventory().contains(Material.STONE_SWORD, 1)
						|| p.getInventory().contains(Material.IRON_SWORD, 1)
						|| p.getInventory().contains(Material.GOLDEN_SWORD, 1)
						|| p.getInventory().contains(Material.DIAMOND_SWORD, 1)) {

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg addmember arenalock -w Halloween " + p.getName());
					
	    	   } else {
	    		   p.sendMessage(prefix + ChatColor.RED + "You need your Equipment to enter the mansion. Go talk to Joey the Blacksmith to get yours.");
	    		   p.teleport(Village);
	    		   spawnFireworks(p.getLocation(), 1, Color.ORANGE); 
	    	   }
	       } else if (region.equals("portalwitch")) {
	    	   if (p.hasPermission("portal.use")) {
	    		   return;
	    	   } else {
	    		   p.sendMessage(prefix + ChatColor.RED + "You can't enter this portal yet. Go talk with Evanora");
	    		   p.teleport(Evanora);
	    	   }
	       } else if (region.equals("portalarena")) {
	    	   if (p.getInventory().contains(StevenEssence(p))) {
	   			int cooldownTime = 10;
				if (cooldowns4.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns4.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns4.put(p.getName(), System.currentTimeMillis());
				p.sendMessage(prefix + ChatColor.YELLOW + "You've entered the portal to Steven's Cave.");
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 		
						p.setWalkSpeed(0);
						p.teleport(lportalarena);
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 10, false, false), false);
						p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
					} }, 10L);

				
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						p.teleport(caveentrance);
					} }, 100L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					@Override public void run() { 
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 50, 10, false, false), false);
						p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 1);
						p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
						spawnFireworks(p.getLocation(), 1, Color.RED);
						p.setWalkSpeed(0.2f);
					} }, 110L);
	    		   return;
	    	   } else {
	    		   p.sendMessage(prefix + ChatColor.RED + "You need to defeat Steven before leaving.");
	    	   }
	       }
	   }
	   
		public static void spawnFireworks(Location location, int amount, Color color){
	        Location loc = location;
	        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
	        FireworkMeta fwm = fw.getFireworkMeta();
	        
	        fwm.setPower(1);
	        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
	        fw.setFireworkMeta(fwm);
	        fw.detonate();
	        

	    }
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
	
	
}
