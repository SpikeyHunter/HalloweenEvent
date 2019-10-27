package com.spikeyhunter.halloweenmain;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
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

public class StevenHealer implements Listener {
	private MainClass plugin;
	public StevenHealer(MainClass main) {
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

	public HashMap<String, Long> heal = new HashMap<String, Long>();
	public HashMap<String, Long> heal2 = new HashMap<String, Long>();
	public HashMap<String, Long> heal3 = new HashMap<String, Long>();
	
	@EventHandler
	public void onEnterCave(PlayerMoveEvent event){
	    Player p = event.getPlayer();
	     if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.RED_STAINED_GLASS)) {
        
		if (p.hasPermission("steven.fighting")){
			int cooldownTime = 2;
			if (heal.containsKey(p.getName())) {
				long secondsLeft = ((heal.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					return;
				}

			}
			heal.put(p.getName(), System.currentTimeMillis());
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 		
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 2, true, true), true);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1, 1);
					spawnFireworks(p.getLocation(), 1, Color.RED);
		         
				} }, 5L);
			
			} else {
				return;
			}
	} else if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.LIME_STAINED_GLASS)) {
		int cooldownTime = 2;
		if (heal2.containsKey(p.getName())) {
			long secondsLeft = ((heal2.get(p.getName()) / 1000) + cooldownTime)
					- (System.currentTimeMillis() / 1000);
			if (secondsLeft > 0) {
				return;
			}

		}
		heal2.put(p.getName(), System.currentTimeMillis());
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			@Override public void run() { 		
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 2, true, true), true);
				p.getLocation().getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
				spawnFireworks(p.getLocation(), 1, Color.LIME);
	         
			} }, 5L);
	} else if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.PINK_STAINED_GLASS)) {
		int cooldownTime = 10;
		if (heal3.containsKey(p.getName())) {
			long secondsLeft = ((heal3.get(p.getName()) / 1000) + cooldownTime)
					- (System.currentTimeMillis() / 1000);
			if (secondsLeft > 0) {
				return;
			}

		}
		heal3.put(p.getName(), System.currentTimeMillis());
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			@Override public void run() { 		
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0, true, true), true);
				p.getLocation().getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
				spawnFireworks(p.getLocation(), 1, Color.PURPLE);
	         
			} }, 5L);
	} else if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.ORANGE_STAINED_GLASS)) {
		int cooldownTime = 5;
		if (heal3.containsKey(p.getName())) {
			long secondsLeft = ((heal3.get(p.getName()) / 1000) + cooldownTime)
					- (System.currentTimeMillis() / 1000);
			if (secondsLeft > 0) {
				return;
			}

		}
		heal3.put(p.getName(), System.currentTimeMillis());
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			@Override public void run() { 		
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*60, 0, true, true), true);
				p.getLocation().getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
				spawnFireworks(p.getLocation(), 1, Color.ORANGE);
	         
			} }, 5L);
	}
	     
	     
			
}
	
	
}