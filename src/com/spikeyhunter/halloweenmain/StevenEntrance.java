package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Llama.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class StevenEntrance implements Listener {
    
    static World world = Bukkit.getWorld("Halloween");
	static Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
	static Location cave = new Location(world, 482.5, 16, 294.5);
	static Location portal = new Location(world, 459.5, 49, 228);
	
	String prefix = ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> ");
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns2 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns3 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns4 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns5 = new HashMap<String, Long>();

	
	private MainClass plugin;
	public StevenEntrance(MainClass main) {
		this.plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEnterCave(PlayerMoveEvent event){
	    Player p = event.getPlayer();
	    Location Steven = new Location(world, 482.5, 19, 335.5);
	    
	    if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.GOLD_BLOCK)) {
	        
	        if(p.getInventory().contains(this.StevenTrophy(p))){
	        	int cooldownTime = 5;
				if (cooldowns5.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns5.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns5.put(p.getName(), System.currentTimeMillis());

                this.cooldowns5.put(p.getName(), System.currentTimeMillis()); 
	           p.sendMessage(prefix + ChatColor.GREEN + "You've already defeated Steven, you can still watch the fights by using the portal at your right.");
	            
	      } else if (p.hasPermission("steven.tp")){
	    	  int cooldownTime = 10;
				if (cooldowns.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns.put(p.getName(), System.currentTimeMillis());

                this.cooldowns.put(p.getName(), System.currentTimeMillis()); 
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp false");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission set steven.fighting true");
	            p.teleport(cave);
	         

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
	            p.sendMessage(prefix + ChatColor.GREEN + "You've entered the sacred temple. Try to find Steven and release him from this evil spirit."); 
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg addmember arenalock -w Halloween " + p.getName());
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
					  },3000);
	          
	      } else {
	    	  int cooldownTime = 5;
				if (cooldowns2.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns2.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns2.put(p.getName(), System.currentTimeMillis());
	          p.sendMessage(prefix + ChatColor.RED + "Someone is already fighting Steven. You can watch the fight by using the portal at your right or wait until the fight is over.");
	          
	      }
	}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	    Player p = e.getPlayer();
	    
	    if(p.hasPermission("steven.fighting")){
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.fighting");
 			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead3");
 			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead2");
 			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset steven.dead1");
	         p.teleport(caveentrance);
	         p.sendMessage(prefix + ChatColor.RED + "You were kicked out of the fight with Steven because you left it.");
	   }
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
	    Player p = e.getPlayer();
	    if(p.hasPermission("steven.fighting")){
	         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  group default permission set steven.tp true");
	         
	         /*ADD ARENA RESET HERE */
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
    private ItemStack StevenTrophy(Player p) {
        
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

}