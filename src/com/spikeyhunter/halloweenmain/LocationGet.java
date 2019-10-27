package com.spikeyhunter.halloweenmain;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocationGet implements CommandExecutor {
	
	private MainClass plugin;
	public LocationGet(MainClass main) {
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
		Integer y = p.getLocation().getBlockY();
		
		if (args.length == 1) {
			if (p.hasPermission("halloween.admin")) {
				System.out.println("static Location l" + args[0] + " = new Location(world, " + p.getLocation().getBlockX() + ", " + (y-1) + ", " + p.getLocation().getBlockZ() + ");");
			} else {
				p.sendMessage(prefix + ChatColor.RED + "You don't have permission to use this.");
			}
			
			
		} else {
			p.sendMessage(prefix + ChatColor.RED + "Invalid command, try again.");
		}
			
		return true;
	}

}
