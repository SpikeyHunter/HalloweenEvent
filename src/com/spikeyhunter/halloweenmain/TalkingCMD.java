package com.spikeyhunter.halloweenmain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TalkingCMD implements CommandExecutor {
	
	
	private Random randomText = new Random();
    private <T> T getRandom(List<T> list) {
	    return list.get(randomText.nextInt(list.size()));
	}

	public HashMap<String, Long> delay1 = new HashMap<String, Long>();
	public HashMap<String, Long> delay2 = new HashMap<String, Long>();
	public HashMap<String, Long> delay3 = new HashMap<String, Long>();
	public HashMap<String, Long> delay4 = new HashMap<String, Long>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		ArrayList<String> random = new ArrayList<String>();
		random.add("I think I saw Liv doing some witchcraft earlier!");
		random.add("Happy Halloween! Enjoy the spooky season!");
		random.add("Those pumpkins make me shudder...");
		random.add("Mmmh, I'm craving a good pumpkin pie right now.");
		random.add("The windmill is turning sooo fast!");
		random.add("Don't forget to brush your teeth after trick-or-treating.");
		random.add("Boo!");
		random.add("Keep your eyes open... you never know...");
		random.add("It's full moon tonight! Watch out...");
		
		random.add("I think I've seen a bat cave somewhere in the haunted forest...");
		random.add("Robert killed a zombie this morning, he might have some zombie flesh...");
		random.add("I've heard the water in the mansion fountain, gives you eternal life!");
		random.add("The farmer of the village recently captured a ghost and he was dusty after that ;)");
		random.add("Mmhh! Have you tasted Angela's apple? They're so tasty.");
		random.add("I remember seing Lucie with a juicy carrot earlier...");
		random.add("I've seen Alexander from the sorcery village grow some brown mushrooms last month...");
		random.add("Frankie makes THE best pumpkin pie in the village! You have to try them!!");
		random.add("Have you seen Julius? Oh never mind, he went in the forest to get some berries.");
		
		
		
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
		
		if (p.hasPermission("npc.use")) {
			if (args.length >= 2) {
			
				int length = args.length;
				String message = "";
				for (int i = 1; i < length; i++) {
					message += args[i] + " ";
				}
				
				String npc = args[0].substring(0, 1).toUpperCase() + args[0].substring(1);
				
				switch (args[1].toLowerCase()) {
				
				case "random" :	
					if (p.hasPermission("halloween.admin")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l" + npc + " &8>> &e" + getRandom(random)));
						p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1, 1);
					
					} else {
					int cooldownTime = 3;
					if (delay1.containsKey(p.getName())) {
						long secondsLeft = ((delay1.get(p.getName()) / 1000) + cooldownTime)
								- (System.currentTimeMillis() / 1000);
						if (secondsLeft > 0) {
							return true;
						}

					}   
					delay1.put(p.getName(), System.currentTimeMillis());
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l" + npc + " &8>> &e" + getRandom(random)));
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1, 1);
					}
				break;
				
				case "ophelia":
					if (p.hasPermission("portal.use")){
						int cooldownTime2 = 3;
						if (delay3.containsKey(p.getName())) {
							long secondsLeft = ((delay3.get(p.getName()) / 1000) + cooldownTime2)
									- (System.currentTimeMillis() / 1000);
							if (secondsLeft > 0) {
								return true;
							}

						}
						delay3.put(p.getName(), System.currentTimeMillis());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lOphelia &8>> &eYou can teleport to the Sorcery Village by entering the portal."));

					} else {
						int cooldownTime2 = 3;
						if (delay3.containsKey(p.getName())) {
							long secondsLeft = ((delay3.get(p.getName()) / 1000) + cooldownTime2)
									- (System.currentTimeMillis() / 1000);
							if (secondsLeft > 0) {
								return true;
							}

						}
						delay3.put(p.getName(), System.currentTimeMillis());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lOphelia &8>> &eGo talk to my sister Evanora in the Sorcery Village, she'll activate the portal for you."));
					}
				break;
				
				case "evanora":
					if (p.hasPermission("portal.use")){
						int cooldownTime2 = 3;
						if (delay4.containsKey(p.getName())) {
							long secondsLeft = ((delay4.get(p.getName()) / 1000) + cooldownTime2)
									- (System.currentTimeMillis() / 1000);
							if (secondsLeft > 0) {
								return true;
							}

						}
						delay4.put(p.getName(), System.currentTimeMillis());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lEvanora &8>> &eYou can teleport to the Valley Village by entering the portal."));

					} else {
						int cooldownTime2 = 3;
						if (delay4.containsKey(p.getName())) {
							long secondsLeft = ((delay4.get(p.getName()) / 1000) + cooldownTime2)
									- (System.currentTimeMillis() / 1000);
							if (secondsLeft > 0) {
								return true;
							}

						}
						delay4.put(p.getName(), System.currentTimeMillis());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lEvanora &8>> &eOphelia already told me you were coming. The portal is ready for you to use!"));
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp  user " + p.getName() + " permission set portal.use true");
					}
				break;
				
				default:
					if (p.hasPermission("halloween.admin")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l" + npc + " &8>> &e" +  message));
						p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1, 1);
					
					} else {
					int cooldownTime2 = 3;
					if (delay2.containsKey(p.getName())) {
						long secondsLeft = ((delay2.get(p.getName()) / 1000) + cooldownTime2)
								- (System.currentTimeMillis() / 1000);
						if (secondsLeft > 0) {
							return true;
						}

					}   
					delay2.put(p.getName(), System.currentTimeMillis());
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l" + npc + " &8>> &e" +  message));
					p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 1, 1);
					}
				break;
					
				}
				
				
			} else {
				p.sendMessage(prefix + ChatColor.RED + "Wrong usage. Use /talk <name> <message>");
			}
		} else {
			p.sendMessage(prefix + ChatColor.RED + "Sorry you can't use this command.");
		}
		
		return true;
	}

}
