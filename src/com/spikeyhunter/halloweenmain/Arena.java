package com.spikeyhunter.halloweenmain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class Arena implements CommandExecutor {
	
	public static void spawnFireworks(Location location, int amount, Color color){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
	     World world = Bukkit.getWorld("Halloween");
		 Location caveentrance = new Location(world, 467.5, 49.0, 223.5);
		
		if (args.length == 0) {
			if (p.getGameMode() == GameMode.SPECTATOR) {
				p.teleport(caveentrance);
				p.setGameMode(GameMode.SURVIVAL);
				spawnFireworks(p.getLocation(), 1, Color.RED); spawnFireworks(p.getLocation(), 1, Color.RED);
			} else {
				p.sendMessage(prefix + ChatColor.RED + "Sorry, you don't have access to that command while in survival.");
			}
				
			
		}
			
		return true;
	}
}
