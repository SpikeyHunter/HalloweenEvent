package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.clip.placeholderapi.PlaceholderAPI;

public class WeaponryInv implements Listener {
	
	private Plugin plugin = MainClass.getPlugin(MainClass.class);
	
	public void newInventory(Player player) {
	
		
		Inventory i = plugin.getServer().createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&4&lWeaponry"));
		
	/*---------------------------------------------------------------------*/	
		
		ItemStack t1s = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta mt1s = t1s.getItemMeta();
		
		mt1s.setDisplayName("§a§lSpooky Sword I");
		mt1s.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		mt1s.addEnchant(Enchantment.DURABILITY, 10, true);
		mt1s.addEnchant(Enchantment.MENDING, 10, true);
		mt1s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt1s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore1 = new ArrayList<String>();  
		lore1.add("§7Haunted I");
		lore1.add("§7Spooky II");
    	lore1.add("§7Halloween X");
    	lore1.add("");
    	lore1.add("§6Price: §cFree");
    	lore1.add("§8§oToo spooky for me!");
    	mt1s.setLore(lore1);
		t1s.setItemMeta(mt1s);

	/*---------------------------------------------------------------------*/	
		
		ItemStack t2s = new ItemStack(Material.STONE_SWORD);
		ItemMeta mt2s = t2s.getItemMeta();
		
		mt2s.setDisplayName("§d§lSpooky Sword II");
		mt2s.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
		mt2s.addEnchant(Enchantment.DURABILITY, 10, true);
		mt2s.addEnchant(Enchantment.MENDING, 10, true);
		mt2s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt2s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore2 = new ArrayList<String>();  
		lore2.add("§7Haunted II");
		lore2.add("§7Spooky IV");
    	lore2.add("§7Halloween X");
    	lore2.add("");
    	lore2.add("§6Price: §c2000$");
    	lore2.add("§8§oToo spooky for me!");
    	mt2s.setLore(lore2);
		t2s.setItemMeta(mt2s);

	/*---------------------------------------------------------------------*/
		
		ItemStack t3s = new ItemStack(Material.IRON_SWORD);
		ItemMeta mt3s = t3s.getItemMeta();
		
		mt3s.setDisplayName("§e§lSpooky Sword III");
		mt3s.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
		mt3s.addEnchant(Enchantment.DURABILITY, 10, true);
		mt3s.addEnchant(Enchantment.MENDING, 10, true);
		mt3s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt3s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore3 = new ArrayList<String>();  
		lore3.add("§7Haunted III");
		lore3.add("§7Spooky VI");
    	lore3.add("§7Halloween X");
    	lore3.add("");
    	lore3.add("§6Price: §c3000$");
    	lore3.add("§8§oToo spooky for me!");
    	mt3s.setLore(lore3);
		t3s.setItemMeta(mt3s);

	/*---------------------------------------------------------------------*/
		
		ItemStack t4s = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta mt4s = t4s.getItemMeta();
		
		mt4s.setDisplayName("§6§lSpooky Sword IV");
		mt4s.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
		mt4s.addEnchant(Enchantment.DURABILITY, 10, true);
		mt4s.addEnchant(Enchantment.MENDING, 10, true);
		mt4s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt4s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore4 = new ArrayList<String>();  
		lore4.add("§7Haunted IV");
		lore4.add("§7Spooky VIII");
    	lore4.add("§7Halloween X");
    	lore4.add("");
    	lore4.add("§6Price: §c4000$");
    	lore4.add("§8§oToo spooky for me!");
    	mt4s.setLore(lore4);
		t4s.setItemMeta(mt4s);

	/*---------------------------------------------------------------------*/
		
		ItemStack t5s = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta mt5s = t5s.getItemMeta();
		
		mt5s.setDisplayName("§b§lSpooky Sword V");
		mt5s.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		mt5s.addEnchant(Enchantment.DURABILITY, 10, true);
		mt5s.addEnchant(Enchantment.MENDING, 10, true);
		mt5s.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt5s.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore5 = new ArrayList<String>();  
		lore5.add("§7Haunted V");
		lore5.add("§7Spooky X");
    	lore5.add("§7Halloween X");
    	lore5.add("");
    	lore5.add("§6Price: §c5000$");
    	lore5.add("§8§oToo spooky for me!");
    	mt5s.setLore(lore5);
		t5s.setItemMeta(mt5s);

/*---------------------------------------------------------------------------------------------------------------------------*/	
		
		ItemStack t1a = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack t1b = new ItemStack(Material.LEATHER_HELMET);
		ItemStack t1c = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack t1d = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta mt1a = t1a.getItemMeta(); t1b.getItemMeta(); t1c.getItemMeta(); t1d.getItemMeta();
		
		mt1a.setDisplayName("§a§lSpooky Armor I");
		mt1a.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		mt1a.addEnchant(Enchantment.DURABILITY, 10, true);
		mt1a.addEnchant(Enchantment.MENDING, 10, true);
		mt1a.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt1a.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore6 = new ArrayList<String>();  
		lore6.add("§7Haunted I");
		lore6.add("§7Spooky II");
    	lore6.add("§7Halloween X");
    	lore6.add("");
    	lore6.add("§6Price: §cFree");
    	lore6.add("§8§oToo spooky for me!");
    	mt1a.setLore(lore6);
		t1a.setItemMeta(mt1a);
		t1b.setItemMeta(mt1a);
		t1c.setItemMeta(mt1a);
		t1d.setItemMeta(mt1a);

	/*---------------------------------------------------------------------*/	
		
		ItemStack t2a = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta mt2a = t2a.getItemMeta();
		
		mt2a.setDisplayName("§d§lSpooky Armor II");
		mt2a.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		mt2a.addEnchant(Enchantment.DURABILITY, 10, true);
		mt2a.addEnchant(Enchantment.MENDING, 10, true);
		mt2a.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt2a.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore7 = new ArrayList<String>();  
		lore7.add("§7Haunted II");
		lore7.add("§7Spooky IV");
    	lore7.add("§7Halloween X");
    	lore7.add("");
    	lore7.add("§6Price: §c2000$");
    	lore7.add("§8§oToo spooky for me!");
    	mt2a.setLore(lore7);
		t2a.setItemMeta(mt2a);

	/*---------------------------------------------------------------------*/
		
		ItemStack t3a = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta mt3a = t3a.getItemMeta();
		
		mt3a.setDisplayName("§e§lSpooky Armor III");
		mt3a.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		mt3a.addEnchant(Enchantment.DURABILITY, 10, true);
		mt3a.addEnchant(Enchantment.MENDING, 10, true);
		mt3a.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt3a.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore8 = new ArrayList<String>();  
		lore8.add("§7Haunted III");
		lore8.add("§7Spooky VI");
    	lore8.add("§7Halloween X");
    	lore8.add("");
    	lore8.add("§6Price: §c3000$");
    	lore8.add("§8§oToo spooky for me!");
    	mt3a.setLore(lore8);
		t3a.setItemMeta(mt3a);

	/*---------------------------------------------------------------------*/
		
		ItemStack t4a = new ItemStack(Material.GOLDEN_CHESTPLATE);
		ItemMeta mt4a = t4a.getItemMeta();
		
		mt4a.setDisplayName("§6§lSpooky Armor IV");
		mt4a.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		mt4a.addEnchant(Enchantment.DURABILITY, 10, true);
		mt4a.addEnchant(Enchantment.MENDING, 10, true);
		mt4a.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt4a.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore9 = new ArrayList<String>();  
		lore9.add("§7Haunted IV");
		lore9.add("§7Spooky VIII");
    	lore9.add("§7Halloween X");
    	lore9.add("");
    	lore9.add("§6Price: §c4000$");
    	lore9.add("§8§oToo spooky for me!");
    	mt4a.setLore(lore9);
		t4a.setItemMeta(mt4a);

	/*---------------------------------------------------------------------*/
		
		ItemStack t5a = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta mt5a = t5a.getItemMeta();
		
		mt5a.setDisplayName("§b§lSpooky Armor IV");
		mt5a.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		mt5a.addEnchant(Enchantment.DURABILITY, 10, true);
		mt5a.addEnchant(Enchantment.MENDING, 10, true);
		mt5a.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		mt5a.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		ArrayList<String> lore10 = new ArrayList<String>();  
		lore10.add("§7Haunted V");
		lore10.add("§7Spooky X");
    	lore10.add("§7Halloween X");
    	lore10.add("");
    	lore10.add("§6Price: §c5000$");
    	lore10.add("§8§oToo spooky for me!");
    	mt5a.setLore(lore10);
		t5a.setItemMeta(mt5a);

	/*---------------------------------------------------------------------*/
		
		ItemStack upgrades = new ItemStack(Material.NETHER_STAR);
		ItemMeta mupgrades = upgrades.getItemMeta();
		
		ArrayList<String> l = new ArrayList<String>();  
		l.add(ChatColor.translateAlternateColorCodes('&', "&8&oMiddle click to purchase"));
		mupgrades.setLore(l);
		
		mupgrades.setDisplayName("§6§lUpgrade Equipment");
		upgrades.setItemMeta(mupgrades);

	/*---------------------------------------------------------------------*/
		

			ItemStack healer = new ItemStack(Material.PLAYER_HEAD);
			ItemMeta mhealer = healer.getItemMeta();
			setSkull(mhealer, UUID.fromString("4a8ca9a0-454c-4b19-9de1-71360d9c5d35"),"1b15ce823770d9a269c1ebf583d3e4932747a13ef43613cd4f75f804ca4");

			ArrayList<String> l2 = new ArrayList<String>();  
			l2.add(ChatColor.translateAlternateColorCodes('&', "&8&oClick to heal"));
			mhealer.setLore(l2);
			
			mhealer.setDisplayName("§c§lHealer");
			healer.setItemMeta(mhealer);

	/*---------------------------------------------------------------------*/
		
		String bal = "%vault_eco_balance%" ;
		
		ItemStack balance = new ItemStack(Material.GOLD_INGOT);
		ItemMeta mbalance = balance.getItemMeta();
		
		mbalance.setDisplayName("§e§lYour Balance");
		ArrayList<String> lore11 = new ArrayList<String>();  
		lore11.add(ChatColor.GOLD + "$" + ChatColor.GREEN + PlaceholderAPI.setPlaceholders(player, bal) );
		mbalance.setLore(lore11);
		balance.setItemMeta(mbalance);

	/*---------------------------------------------------------------------*/

	        
	    ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
	    ItemMeta meta = skull.getItemMeta();
	    setSkull(meta, UUID.fromString("327d55ca-3137-4269-be29-fa8a7846e765"), "38a971df51e9ca9a5b92e45d3fa547dd3191877929a437d50153892e585a");

	    ArrayList<String> l3 = new ArrayList<String>();  
		l3.add(ChatColor.translateAlternateColorCodes('&', "&8&oClick to eat"));
		meta.setLore(l3);
		
	    meta.setDisplayName("§6§lPumpkin Pie");
	    skull.setItemMeta(meta);


	
		i.setItem(10, t1s);
		i.setItem(11, t2s);
		i.setItem(12, t3s);
		i.setItem(13, t4s);
		i.setItem(14, t5s);
		i.setItem(15, skull);
		i.setItem(17, upgrades);
		i.setItem(19, t1a);
		i.setItem(20, t2a);
		i.setItem(21, t3a);
		i.setItem(22, t4a);
		i.setItem(23, t5a);
		i.setItem(24, healer);
		i.setItem(26, balance);
		
		
		
		player.openInventory(i);
		
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
	
}
