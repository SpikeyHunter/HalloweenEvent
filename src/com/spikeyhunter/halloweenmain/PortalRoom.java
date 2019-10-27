package com.spikeyhunter.halloweenmain;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
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

public class PortalRoom implements Listener {
	
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
	   public void onRegionEntered(RegionEnteredEvent e){
		 Player p = Bukkit.getPlayer(e.getUUID());
		 Double x1 = p.getLocation().getX() + 21;
		 Double x2 = p.getLocation().getX() - 21;
		 Double y = p.getLocation().getY();
		 
		 World world = Bukkit.getWorld("Halloween");
		 Location p1 = new Location(world, x1, y, 155.5);
		 Location p2 = new Location(world, x1, y, 163.5);
		 Location p3 = new Location(world, x1, y, 171.5);
		 Location p4 = new Location(world, x1, y, 179.5);
		 Location p5 = new Location(world, x2, y, 155.5);
		 Location p6 = new Location(world, x2, y, 163.5);
		 Location p7 = new Location(world, x2, y, 171.5);
		 Location p8 = new Location(world, x2, y, 179.5);
		
		 ArrayList<Location> left = new ArrayList<Location>();
		    left.add(p1);
		    left.add(p2);
		    left.add(p3);
		    left.add(p4);
		    Random randomLeft = new Random();
		    
		 Location leftloc = left.get(randomLeft.nextInt(left.size()));
		 

		 ArrayList<Location> right = new ArrayList<Location>();
		    right.add(p5);
		    right.add(p6);
		    right.add(p7);
		    right.add(p8);
		    Random randomRight = new Random();
		    
		 Location rightloc = right.get(randomRight.nextInt(right.size()));
		 
		
	    String region = e.getRegionName();
	    
	    if(region.equals("portalroom1") || region.equals("portalroom2") || region.equals("portalroom3") || region.equals("portalroom4")) {
	    	
	    	rightloc.setDirection(p.getLocation().getDirection());
	    	p.teleport(rightloc);
	    	spawnFireworks(p.getLocation(), 1, Color.AQUA);
	    	
	    }else if(region.equals("portalroom5") || region.equals("portalroom6") || region.equals("portalroom7") || region.equals("portalroom8")) {
	    	
	    	leftloc.setDirection(p.getLocation().getDirection());
	    	p.teleport(leftloc);
	    	spawnFireworks(p.getLocation(), 1, Color.AQUA);
	    	
	    }
	  } 
}
