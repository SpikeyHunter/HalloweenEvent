package com.spikeyhunter.halloweenmain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

import net.raidstone.wgevents.events.RegionEnteredEvent;

public class HealRegions implements Listener {
	
	public static void spawnFireworks(Location location, int amount, Color color){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
    }
	
	static World world = Bukkit.getWorld("Halloween");
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));

	static Location heal1a = new Location(world, 357.5, 53, 123.5);
	static Location heal1b = new Location(world, 362.5, 53, 123.5);
	static Location heal2a = new Location(world, 391.5, 53, 123.5);
	static Location heal2b = new Location(world, 386.5, 53, 123.5);
	

	static Location fight1a = new Location(world, 425.5, 53, 141.5);
	static Location fight1b = new Location(world, 425.5, 53, 145.5);
	static Location fight2a = new Location(world, 404.5, 53, 140.5);
	static Location fight2b = new Location(world, 400.5, 53, 140.5);
	
	 @EventHandler
	   public void onRegionEntered(RegionEnteredEvent e){
		 
		Player p = Bukkit.getPlayer(e.getUUID());
	    String region = e.getRegionName();
	    
	    if(region.equals("heal1a")) {
	    	heal1b.setDirection(p.getLocation().getDirection());
	    	p.teleport(heal1b);
			p.sendTitle(ChatColor.DARK_GREEN + "Healing Zone", ChatColor.GREEN + "Jump to heal!", 20, 60, 20);
	  } else if (region.equals("heal1b")) {
	    	heal1a.setDirection(p.getLocation().getDirection());
	    	p.teleport(heal1a);
	  }
	    
   /*-------------------------------------------*/	    	
	    	
	   else if (region.equals("heal2a")) {
	    	heal2b.setDirection(p.getLocation().getDirection());
	    	p.teleport(heal2b);
			p.sendTitle(ChatColor.DARK_GREEN + "Healing Zone", ChatColor.GREEN + "Jump to heal!", 20, 60, 20);
	  } else if (region.equals("heal2b")) {
	    	heal2a.setDirection(p.getLocation().getDirection());
	    	p.teleport(heal2a);
	  }
	    
   /*-------------------------------------------*/	    	
	    	
	   else if (region.equals("fight1a")) {
		   fight1b.setDirection(p.getLocation().getDirection());
	    	p.teleport(fight1b);
			p.sendTitle(ChatColor.DARK_AQUA + "Haunted Zone", ChatColor.AQUA + "Get ready to fight!", 20, 40, 20);
	  } else if (region.equals("fight1b")) {
		  fight1a.setDirection(p.getLocation().getDirection());
	    	p.teleport(fight1a);
			p.sendTitle(ChatColor.GOLD + "Safe Zone", ChatColor.YELLOW + "Get some rest and heal!", 20, 40, 20);
	  }
	    
   /*-------------------------------------------*/	    	
	    	
	   else if (region.equals("figth2a")) {
		   fight2b.setDirection(p.getLocation().getDirection());
	    	p.teleport(fight2b);
			p.sendTitle(ChatColor.DARK_PURPLE + "Haunted Zone", ChatColor.LIGHT_PURPLE + "Get ready to fight!", 20, 40, 20);
	  } else if (region.equals("fight2b")) {
		  fight2a.setDirection(p.getLocation().getDirection());
	    	p.teleport(fight2a);
			p.sendTitle(ChatColor.GOLD + "Safe Zone", ChatColor.YELLOW + "Get some rest and heal!", 20, 40, 20);
	  }
		
		
		
		 
	   }
}
