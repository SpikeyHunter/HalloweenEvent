package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
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

public class TreatsItem implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
		
		if (p.hasPermission("halloween.admin")) {
		
		if (args.length == 1) {
			
			String item = args[0];
			
			switch(item.toLowerCase()) {
			
			case "money1" : 
				p.getInventory().addItem(Money1(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "money2" : 
				p.getInventory().addItem(Money2(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "money3" : 
				p.getInventory().addItem(Money3(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "potion1" : 
				p.getInventory().addItem(Potion1(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "potion2" : 
				p.getInventory().addItem(Potion2(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "potion3" : 
				p.getInventory().addItem(Potion3(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "potion4" : 
				p.getInventory().addItem(Potion4(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			
			case "potion5" : 
				p.getInventory().addItem(Potion5(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "The item was added to your inventory");
			break;
			

			case "all" : 
				p.getInventory().addItem(Potion1(p));
				p.getInventory().addItem(Potion2(p));
				p.getInventory().addItem(Potion3(p));
				p.getInventory().addItem(Potion4(p));
				p.getInventory().addItem(Potion5(p)); 
				p.getInventory().addItem(Money1(p)); 
				p.getInventory().addItem(Money2(p)); 
				p.getInventory().addItem(Money3(p)); 
				p.sendMessage(prefix + ChatColor.GREEN + "All items were added to your inventory");
			break;
			
			
			
			default:
				break;
			
			}
			
			
			
		} else {
			p.sendMessage(prefix + ChatColor.RED + "Incorrect usage. Use /treats <name>");
			
		}
		
		} else {
			p.sendMessage(prefix + ChatColor.RED + "Sorry you don't have permission to use this.");
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
    private ItemStack Money1(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("72b7f2c6-b61b-4971-90c2-560278b717a4"), "a9b906b2155f193787042338d05f840391c05a6d3e81623901b296bee3ffdd2");
        meta.setDisplayName("§6§lGold Bag");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Value: §a1000§6$");
    	lore.add("");
    	lore.add("§8§oClick to redeem");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }
    private ItemStack Money2(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("de9dba36-4133-4db7-9034-fd5889fd094f"), "26a6886e84eae5ba2b2b602432429c6fb28691fc02e9f9ccb5c57f2cdd0f1d8");
        meta.setDisplayName("§b§lDiamond Bag");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Value: §a5000§6$");
    	lore.add("");
    	lore.add("§8§oClick to redeem");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Money3(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("a99d80c3-2a46-47e5-ac78-782901403021"), "31d827a5decb0ae730abb69617776e1894f2bdb46968540433115d3688fbac38");
        meta.setDisplayName("§a§lEmerald Bag");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Value: §a10,000§6$");
    	lore.add("");
    	lore.add("§8§oClick to redeem");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Potion1(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("a45d4907-b417-4e80-962e-2a90a1121a55"), "33fa91de31e2ddda29ca419c08b34a5a2d6b4b1a1b59b236cdc14cb131dcb807");
        meta.setDisplayName("§a§lRabbit Essence I");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Magic X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oClick to consume");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Potion2(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("192b918e-34fc-4c5b-a57c-7a97d34dd01d"), "42f57c9eed9f90b7c33b0a447568150cb7b5ec62afddf280b4f981ffd480a766");
        meta.setDisplayName("§a§lRabbit Essence II");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Magic X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oClick to consume");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Potion3(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("9e8aae06-1842-49f9-b4f2-5c895cea901e"), "10a14a8cf092d0cd16933be2dc9d440fb30b515921fc6b68cdcc19abf8646fcf");
        meta.setDisplayName("§4§lRock Concentrate");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Magic X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oClick to consume");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Potion4(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("473842dc-74fe-4b6d-b0b5-bbd700a243d5"), "b3d356b86118ff8c48c119ef3d2ac90c1ad1392893022f80b9dc168c36db2a56");
        meta.setDisplayName("§d§lHealing Juice I");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Magic X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oClick to consume");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }

    private ItemStack Potion5(Player p) {
        
    	ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    	ItemMeta meta = skull.getItemMeta();
    	setSkull(meta, UUID.fromString("660698fc-7286-43b2-a92f-d3625a91d69c"), "5c05bfae995eada34d14968ddbfb601b6b22c5975b5176e61cd223e31e3aef80");
        meta.setDisplayName("§d§lHealing Juice II");
    	ArrayList<String> lore = new ArrayList<String>();  
    	lore.add("§7Magic X");
    	lore.add("§7Halloween X");
    	lore.add("");
    	lore.add("§8§oClick to consume");
    	meta.setLore(lore);
    	skull.setItemMeta(meta);
		return skull;
    	
    }
	
	
	
}
