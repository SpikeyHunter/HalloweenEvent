package com.spikeyhunter.halloweenmain;

import java.util.HashMap;

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

public class StevenSpectator implements Listener {
    
    static World world = Bukkit.getWorld("Halloween");
	static Location caveentrance = new Location(world, 4670.5, 49.0, 223.5);
	static Location cave = new Location(world, 482.5, 16, 294.5);
	static Location portal = new Location(world, 459.5, 49, 228);
	
	String prefix = ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> ");
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns2 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns3 = new HashMap<String, Long>();
	public HashMap<String, Long> cooldowns4 = new HashMap<String, Long>();
	
	public static void spawnFireworks(Location location, int amount, Color color){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
    }
	
	private MainClass plugin;
	public StevenSpectator(MainClass main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onEnterCave(PlayerMoveEvent event){
	    Player p = event.getPlayer();
	     if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.REDSTONE_BLOCK)) {
        
		if (p.hasPermission("steven.tp")){
	    	  int cooldownTime = 5;
				if (cooldowns3.containsKey(p.getName())) {
					long secondsLeft = ((cooldowns3.get(p.getName()) / 1000) + cooldownTime)
							- (System.currentTimeMillis() / 1000);
					if (secondsLeft > 0) {
						return;
					}

				}
				cooldowns3.put(p.getName(), System.currentTimeMillis());
	          p.sendMessage(prefix + ChatColor.RED + "No one is fighting Steven, come back later.");
          
      } else {
			int cooldownTime = 10;
			if (cooldowns4.containsKey(p.getName())) {
				long secondsLeft = ((cooldowns4.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					return;
				}

			}
			cooldowns4.put(p.getName(), System.currentTimeMillis());
			p.sendMessage(prefix + ChatColor.YELLOW + "You've entered to watch the fight against Steven.");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 		
					p.setWalkSpeed(0);
					p.teleport(portal);
					p.getLocation().setPitch(-180);
					p.getLocation().setYaw(2);
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 10, false, false), false);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
				} }, 10L);

			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.teleport(cave);
				} }, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() { 
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 50, 10, false, false), false);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1, 1);
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
					spawnFireworks(p.getLocation(), 1, Color.RED);
					p.setWalkSpeed(0.2f);
				} }, 110L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				@Override public void run() {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendTitle(ChatColor.DARK_RED + "Spectating Steven", ChatColor.RED + "Use /leave, to leave.", 40, 80, 40);
				} }, 120L);
          
      }
}
	}
	
}