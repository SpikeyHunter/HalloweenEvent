package com.spikeyhunter.halloweenmain;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PortalListener implements Listener {
	
	private MainClass plugin;
	public PortalListener(MainClass main) {
		this.plugin = main;
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
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns2 = new HashMap<String, Long>();
	
	static World world = Bukkit.getWorld("Halloween");
	static Location loc1 = new Location(world, 539, 50, 163);
    static Location loc2 = new Location(world, 543, 50, 165);
    static Location loc3 = new Location(world, 545, 50, 169);
    static Location loc4 = new Location(world, 543, 50, 173);
    static Location loc5 = new Location(world, 539, 50, 175);
    static Location loc6 = new Location(world, 535, 50, 173);
    static Location loc7 = new Location(world, 533, 50, 169);
    static Location loc8 = new Location(world, 535, 50, 165);

    static Location center = new Location(world, 539.5, 49, 169.5);
    
    static Location sorcery = new Location(world, 539.5, 49, 154.5);

    static Location portal = new Location(world, 358.5, 26, -49.5);
    
    static Location Ophelia = new Location(world, 362, 26, -49);
    
    String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
    
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		
		Player p = (Player) event.getPlayer();
		
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.MAGENTA_CONCRETE_POWDER)) {
			
			int cooldownTime = 20;
			if (cooldowns.containsKey(p.getName())) {
				long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					return;
				}

			}
			cooldowns.put(p.getName(), System.currentTimeMillis());
			
			p.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "You've entered the portal to the Valley Village");
			p.setWalkSpeed(0);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.teleport(center);
					spawnFireworks(loc1, 1, Color.WHITE);
					spawnFireworks(loc2, 1, Color.WHITE);
					spawnFireworks(loc3, 1, Color.WHITE);
					spawnFireworks(loc4, 1, Color.WHITE);
					spawnFireworks(loc5, 1, Color.WHITE);
					spawnFireworks(loc6, 1, Color.WHITE);
					spawnFireworks(loc7, 1, Color.WHITE);
					spawnFireworks(loc8, 1, Color.WHITE);	
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 1);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
					spawnFireworks(p.getLocation(), 1, Color.WHITE);
				} }, 40L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					spawnFireworks(loc1, 1, Color.PURPLE);
					spawnFireworks(loc2, 1, Color.PURPLE);
					spawnFireworks(loc3, 1, Color.PURPLE);
					spawnFireworks(loc4, 1, Color.PURPLE);
					spawnFireworks(loc5, 1, Color.PURPLE);
					spawnFireworks(loc6, 1, Color.PURPLE);
					spawnFireworks(loc7, 1, Color.PURPLE);
					spawnFireworks(loc8, 1, Color.PURPLE);	
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 2);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 2);
					spawnFireworks(p.getLocation(), 1, Color.PURPLE);	
				} }, 60L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					spawnFireworks(loc1, 1, Color.FUCHSIA);
					spawnFireworks(loc2, 1, Color.FUCHSIA);
					spawnFireworks(loc3, 1, Color.FUCHSIA);
					spawnFireworks(loc4, 1, Color.FUCHSIA);
					spawnFireworks(loc5, 1, Color.FUCHSIA);
					spawnFireworks(loc6, 1, Color.FUCHSIA);
					spawnFireworks(loc7, 1, Color.FUCHSIA);
					spawnFireworks(loc8, 1, Color.FUCHSIA);			
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 3);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 3);
					spawnFireworks(p.getLocation(), 1, Color.FUCHSIA);	
				} }, 80L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					spawnFireworks(loc1, 1, Color.PURPLE);
					spawnFireworks(loc2, 1, Color.PURPLE);
					spawnFireworks(loc3, 1, Color.PURPLE);
					spawnFireworks(loc4, 1, Color.PURPLE);
					spawnFireworks(loc5, 1, Color.PURPLE);
					spawnFireworks(loc6, 1, Color.PURPLE);
					spawnFireworks(loc7, 1, Color.PURPLE);
					spawnFireworks(loc8, 1, Color.PURPLE);	
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 4);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 4);
					spawnFireworks(p.getLocation(), 1, Color.PURPLE);	
				} }, 100L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					spawnFireworks(loc1, 1, Color.FUCHSIA);
					spawnFireworks(loc2, 1, Color.FUCHSIA);
					spawnFireworks(loc3, 1, Color.FUCHSIA);
					spawnFireworks(loc4, 1, Color.FUCHSIA);
					spawnFireworks(loc5, 1, Color.FUCHSIA);
					spawnFireworks(loc6, 1, Color.FUCHSIA);
					spawnFireworks(loc7, 1, Color.FUCHSIA);
					spawnFireworks(loc8, 1, Color.FUCHSIA);		
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 5);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 5);
					spawnFireworks(p.getLocation(), 1, Color.FUCHSIA);
				} }, 120L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.teleport(Ophelia);
					
				} }, 140L);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					spawnFireworks(p.getLocation(), 1, Color.FUCHSIA);
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 150, 10, false, false), false);
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1, false, false), false);
					p.setWalkSpeed(0.2f);
					
				} }, 160L);
			
			
			
		} else if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.PURPLE_CONCRETE_POWDER)) {
			
			int cooldownTime = 10;
			if (cooldowns2.containsKey(p.getName())) {
				long secondsLeft = ((cooldowns2.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					return;
				}

			}
			cooldowns2.put(p.getName(), System.currentTimeMillis());
			p.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "You've entered the portal to the Sorcery Village");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 		
					p.setWalkSpeed(0);
					p.teleport(portal);
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 10, false, false), false);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
				} }, 10L);

			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.teleport(sorcery);
				} }, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 10, false, false), false);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 1);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
					spawnFireworks(p.getLocation(), 1, Color.FUCHSIA);
					p.setWalkSpeed(0.2f);
				} }, 110L);
		}
	}
	
}
