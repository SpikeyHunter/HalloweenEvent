package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class GhostReward implements CommandExecutor {
	
	private MainClass plugin;
	public GhostReward(MainClass main) {
		this.plugin = main;
	}
	
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
	String thorne = (ChatColor.translateAlternateColorCodes('&', "&6&lThorne &8>> "));
	public HashMap<String, Long> thornedone = new HashMap<String, Long>();
	public HashMap<String, Long> ghost = new HashMap<String, Long>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		if (p.hasPermission("thorne.talk")) {
		if (p.getInventory().contains(GhostReward(p))) {
			/*Already has the reward, thanks message*/
			
			int cooldownTime = 5;
			if (thornedone.containsKey(p.getName())) {
				long secondsLeft = ((thornedone.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					p.sendMessage(thorne + ChatColor.RED + "I already gave you the reward.");
					return true;
				}

			}   
			thornedone.put(p.getName(), System.currentTimeMillis());
			p.sendMessage(thorne  + ChatColor.YELLOW + "Thanks again for capturing all those ghosts!");
			
			
		} else if (p.hasPermission("ghost.use")) {
			
			/*Give the reward and remove all perms*/
			
			p.sendMessage(thorne  + ChatColor.YELLOW + "Thank you for capturing all those ghosts. Here's your reward!");
			p.getInventory().addItem(GhostReward(p));
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset ghost.use");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission unset ghost.talked");
			
			
		} else if (p.hasPermission("ghost.talked")) {
			/*After 1st talk message*/
			p.sendMessage(thorne  + ChatColor.YELLOW + "Continue hunting, you still have some ghosts left.");
			
		} else {
			/*First time talking + add permission ghost talked*/
			  
			int cooldownTime = 20;
			if (ghost.containsKey(p.getName())) {
				long secondsLeft = ((ghost.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					p.sendMessage(prefix + ChatColor.RED + "Please stop interrupting Thorne the Hunter.");
					return true;
				}

			}
			ghost.put(p.getName(), System.currentTimeMillis());
			
			p.sendMessage(thorne + ChatColor.YELLOW + "Hi, I'm Thorne the village Hunter");
		
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.sendMessage(thorne + ChatColor.YELLOW + "I've sadly broken my leg recently and " + ChatColor.RED + "50 ghosts " + ChatColor.YELLOW + "invaded the forest.");
				} }, 40L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.sendMessage(thorne + ChatColor.YELLOW + "They look like the one next to me. If you can find all of them, I'll give you a reward");
				} }, 130L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.sendMessage(thorne + ChatColor.YELLOW + "Good luck and be careful!");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission set ghost.talked true");
				} }, 250L);
		}
		} else {
			p.sendMessage(prefix  + ChatColor.RED + "You don't have permission to use this.");
		}
		
		
		return true;
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
    private ItemStack GhostReward(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("31152fb2-cb1e-45c3-86dd-b23f7a20a6f8"), "68d2183640218ab330ac56d2aab7e29a9790a545f691619e38578ea4a69ae0b6");

    	skull.setItemMeta(meta);
        
        meta.setDisplayName("§f§lGhost Skull");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Ghostly X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oWe say BOO!");
    	lore.add("§8§oTo scare you!");
    	
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
    	
		return skull;
    	
    }
	
}
