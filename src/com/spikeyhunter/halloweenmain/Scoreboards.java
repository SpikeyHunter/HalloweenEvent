package com.spikeyhunter.halloweenmain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.placeholderapi.PlaceholderAPI;

public class Scoreboards implements CommandExecutor{

	private MainClass plugin;
	
	public Scoreboards(MainClass main) {
		this.plugin = main;
	}
	
	 private BukkitTask runnable;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
		String bal = "%vault_eco_balance%" ;
		
 

		if (args.length == 0) {
			p.sendMessage(prefix + ChatColor.RED + "Wrong usage. Use /sb <on/off>");
            return false;
        }

        

        if (args[0].equalsIgnoreCase("on")) {

            if (runnable != null) {
            	p.sendMessage(prefix + ChatColor.RED + "The scoreboard is already turned on.");
                return true;
            }
            runnable = new BukkitRunnable() {
                @Override
                public void run() {
            		final ScoreboardManager m = Bukkit.getScoreboardManager();
            		final Scoreboard board = m.getNewScoreboard();
            		
            		@SuppressWarnings("deprecation")
            		final Objective o = board.registerNewObjective("Money", "");
            		o.setDisplaySlot(DisplaySlot.SIDEBAR);
            		o.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lHalloween Event"));
            		
            		Score empty = o.getScore("");
            		Score empty2 = o.getScore(ChatColor.translateAlternateColorCodes('&', " &r"));
            		Score money = o.getScore(ChatColor.YELLOW + "Money" + ChatColor.DARK_GRAY + ": " + ChatColor.GREEN + PlaceholderAPI.setPlaceholders(p, bal) + "$");
            		Score cmds = o.getScore(ChatColor.translateAlternateColorCodes('&', "&7&oUse /sb <on/off>"));
            		empty2.setScore(4); 
            		money.setScore(3); 
            		empty.setScore(2); 
            		cmds.setScore(1);
            		p.setScoreboard(board);
                }

            }.runTaskTimer(plugin, 0, 10);
			p.sendMessage(prefix + ChatColor.GREEN + "You've turned on the Event Scoreboard.");
			
        } else if (args[0].equalsIgnoreCase("off")) {

            if (runnable == null) {
            	p.sendMessage(prefix + ChatColor.RED + "The scoreboard is already turned off.");
                return true;
            }

            runnable.cancel();
            runnable = null;
            

			p.sendMessage(prefix + ChatColor.RED + "You've turned off the Event Scoreboard.");
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			
        } else {
        	p.sendMessage(prefix + ChatColor.RED + "Wrong usage. Use /sb <on/off>");
        }

        return true;
	   
	}
	

}
