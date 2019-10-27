package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class WeaponryCmd implements CommandExecutor {

	WeaponryInv weaponryInv = new WeaponryInv();
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	private MainClass plugin;
	public WeaponryCmd(MainClass main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		
		Player p = (Player) sender;
		String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
		String joey = (ChatColor.translateAlternateColorCodes('&', "&6&lJoey &8>> "));

		if (p.hasPermission("weaponry.open")) {
			if (p.getInventory().contains(Material.WOODEN_SWORD, 1)
					|| p.getInventory().contains(Material.STONE_SWORD, 1)
					|| p.getInventory().contains(Material.IRON_SWORD, 1)
					|| p.getInventory().contains(Material.GOLDEN_SWORD, 1)
					|| p.getInventory().contains(Material.DIAMOND_SWORD, 1)) {

				WeaponryInv i = new WeaponryInv();

				i.newInventory(p);
			} else {
 
				  int cooldownTime = 12;
					if (cooldowns.containsKey(p.getName())) {
						long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime)
								- (System.currentTimeMillis() / 1000);
						if (secondsLeft > 0) {
							p.sendMessage(prefix + ChatColor.RED + "Please stop interrupting Joey the Blacksmith");
							return true;
						}

					}   
					cooldowns.put(p.getName(), System.currentTimeMillis());
						
						p.sendMessage(joey + ChatColor.YELLOW + "Hi there! I'm Joey the Blacksmith. I'll be glad to make you a sword and an armor.");
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { p.sendMessage( joey + ChatColor.YELLOW + "Go kill those evil creatures who have invaded the mansion and come back to me when you have enough money so I can upgrade your sword and armor!"); } }, 80L);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override public void run() { 
							p.sendMessage( joey + ChatColor.YELLOW + "Here's your sword and armor with the available upgrades for it.");
							p.getInventory().addItem(Tier1(p));
							p.getInventory().addItem(Healer(p));
							p.getInventory().addItem(Pie(p));
							p.getEquipment().setHelmet(H1(p));
							p.getEquipment().setChestplate(C1(p));
							p.getEquipment().setLeggings(L1(p));
							p.getEquipment().setBoots(B1(p));
							} }, 200L);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							@Override public void run() { 
							WeaponryInv i = new WeaponryInv();
							i.newInventory(p); } }, 260L);
						
						
					return true;
				

			}

		} else {
			p.sendMessage(prefix + ChatColor.RED + "Sorry, you don't have permission to use this.");
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
    
	/*---------------------------------------------------------------------*/
    private ItemStack Healer(Player p) {

		ItemStack healer = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta mhealer = healer.getItemMeta();
		setSkull(mhealer, UUID.fromString("4a8ca9a0-454c-4b19-9de1-71360d9c5d35"),"1b15ce823770d9a269c1ebf583d3e4932747a13ef43613cd4f75f804ca4");

		ArrayList<String> l2 = new ArrayList<String>();  
		l2.add(ChatColor.translateAlternateColorCodes('&', "&8&oClick to heal"));
		mhealer.setLore(l2);
		
		mhealer.setDisplayName("§c§lHealer");
		healer.setItemMeta(mhealer);
		return healer;
	}

	/*---------------------------------------------------------------------*/
	private ItemStack Pie(Player p) {

		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta meta = skull.getItemMeta();
		setSkull(meta, UUID.fromString("327d55ca-3137-4269-be29-fa8a7846e765"),"38a971df51e9ca9a5b92e45d3fa547dd3191877929a437d50153892e585a");

		meta.setDisplayName("§6§lPumpkin Pie");
		meta.addEnchant(Enchantment.SILK_TOUCH, 2, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		skull.setItemMeta(meta);
		return skull;
	}	
	private ItemStack Tier1(Player p) {

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
		lore1.add("§8§oToo spooky, for me!");
		mt1s.setLore(lore1);
		t1s.setItemMeta(mt1s);

		return t1s;
	}
	/*---------------------------------------------------------------------*/	

	private ItemStack H1(Player p) {
	
	ItemStack t1a = new ItemStack(Material.LEATHER_HELMET);
	ItemMeta mt1a = t1a.getItemMeta();
	
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
	lore6.add("§8§oToo spooky for me!");
	mt1a.setLore(lore6);
	t1a.setItemMeta(mt1a);
	
	return t1a;
	
	}	


	/*---------------------------------------------------------------------*/
	private ItemStack C1(Player p) {
	
	ItemStack t1a = new ItemStack(Material.LEATHER_CHESTPLATE);
	ItemMeta mt1a = t1a.getItemMeta();
	
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
	lore6.add("§8§oToo spooky for me!");
	mt1a.setLore(lore6);
	t1a.setItemMeta(mt1a);
	
	return t1a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack L1(Player p) {
	
	ItemStack t1a = new ItemStack(Material.LEATHER_LEGGINGS);
	ItemMeta mt1a = t1a.getItemMeta();
	
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
	lore6.add("§8§oToo spooky for me!");
	mt1a.setLore(lore6);
	t1a.setItemMeta(mt1a);
	
	return t1a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack B1(Player p) {
	
	ItemStack t1a = new ItemStack(Material.LEATHER_BOOTS);
	ItemMeta mt1a = t1a.getItemMeta();
	
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
	lore6.add("§8§oToo spooky for me!");
	mt1a.setLore(lore6);
	t1a.setItemMeta(mt1a);
	
	return t1a;
	
	}	


/*---------------------------------------------------------------------*/

}
