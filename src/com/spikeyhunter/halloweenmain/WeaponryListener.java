package com.spikeyhunter.halloweenmain;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.milkbowl.vault.economy.EconomyResponse;

public class WeaponryListener implements Listener {

	
	
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
	String joey = (ChatColor.translateAlternateColorCodes('&', "&6&lJoey &8>> "));

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
	public void InvClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();	
		ClickType click = e.getClick();
		InventoryView view = e.getView();
		ItemStack item = e.getCurrentItem();
		
		
		if(view == null) {
			return;
		}
		
		if (view.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&4&lWeaponry"))) {
			
			e.setCancelled(true);
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			if(item.getItemMeta().getDisplayName().equals("§6§lUpgrade Equipment") && click.isCreativeAction() && p.getInventory().contains(Material.WOODEN_SWORD)) {
				EconomyResponse r = MainClass.getEconomy().withdrawPlayer(p, 2000);
				if(r.transactionSuccess()) {
					p.closeInventory();
	                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aYou've upgraded your Equipment to &eTier II"));
	                p.getInventory().removeItem(Tier1(p));
					p.getInventory().addItem(Tier2(p));
					p.getEquipment().setHelmet(H2(p));
					p.getEquipment().setChestplate(C2(p));
					p.getEquipment().setLeggings(L2(p));
					p.getEquipment().setBoots(B2(p));
					spawnFireworks(p.getLocation(), 1, Color.ORANGE);
	                
	            } else {
	            	p.sendMessage(joey + ChatColor.RED + "Sorry, you don't have enough money to purchase this equipment upgrade." );
					p.closeInventory();
	            }
	            
				
			}else if(item.getItemMeta().getDisplayName().equals("§6§lUpgrade Equipment") && click.isCreativeAction() && p.getInventory().contains(Material.STONE_SWORD)) {
				EconomyResponse r = MainClass.getEconomy().withdrawPlayer(p, 3000);
				if(r.transactionSuccess()) {
					p.closeInventory();
	                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aYou've upgraded your Equipment to &eTier III"));
	                p.getInventory().removeItem(Tier2(p));
					p.getInventory().addItem(Tier3(p));
					p.getEquipment().setHelmet(H3(p));
					p.getEquipment().setChestplate(C3(p));
					p.getEquipment().setLeggings(L3(p));
					p.getEquipment().setBoots(B3(p));
					spawnFireworks(p.getLocation(), 1, Color.ORANGE);
	                
	            } else {
	            	p.sendMessage(joey + ChatColor.RED + "Sorry, you don't have enough money to purchase this equipment upgrade." );
					p.closeInventory();
	            }
	            
				
			}else if(item.getItemMeta().getDisplayName().equals("§6§lUpgrade Equipment") && click.isCreativeAction() && p.getInventory().contains(Material.IRON_SWORD)) {
				EconomyResponse r = MainClass.getEconomy().withdrawPlayer(p, 4000);
				if(r.transactionSuccess()) {
					p.closeInventory();
	                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aYou've upgraded your Equipment to &eTier IV"));
	                p.getInventory().removeItem(Tier3(p));
					p.getInventory().addItem(Tier4(p));
					p.getEquipment().setHelmet(H4(p));
					p.getEquipment().setChestplate(C4(p));
					p.getEquipment().setLeggings(L4(p));
					p.getEquipment().setBoots(B4(p));
					spawnFireworks(p.getLocation(), 1, Color.ORANGE);
	                
	            } else {
	            	p.sendMessage(joey + ChatColor.RED + "Sorry, you don't have enough money to purchase this equipment upgrade." );
					p.closeInventory();
	            }
	            
				
			} else if(item.getItemMeta().getDisplayName().equals("§6§lUpgrade Equipment") && click.isCreativeAction() && p.getInventory().contains(Material.GOLDEN_SWORD)) {
				EconomyResponse r = MainClass.getEconomy().withdrawPlayer(p, 5000);
				if(r.transactionSuccess()) {
					p.closeInventory();
	                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aYou've upgraded your Equipment to &eTier V"));
	                p.getInventory().removeItem(Tier4(p));
					p.getInventory().addItem(Tier5(p));
					p.getEquipment().setHelmet(H5(p));
					p.getEquipment().setChestplate(C5(p));
					p.getEquipment().setLeggings(L5(p));
					p.getEquipment().setBoots(B5(p));
					spawnFireworks(p.getLocation(), 1, Color.ORANGE);
	                
	            } else {
	            	p.sendMessage(joey + ChatColor.RED + "Sorry, you don't have enough money to purchase this equipment upgrade." );
					p.closeInventory();
	            }
	            
				
			} else if(item.getItemMeta().getDisplayName().equals("§6§lUpgrade Equipment") && click.isCreativeAction() && p.getInventory().contains(Material.DIAMOND_SWORD)) {
					p.closeInventory();
	            	p.sendMessage(joey + ChatColor.RED + "You already purchased the last upgrade." );
	            
	            
				
			}
		}
				
		
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

	private ItemStack Tier2(Player p) {

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
		lore2.add("§8§oToo spooky for me!");
		mt2s.setLore(lore2);
		t2s.setItemMeta(mt2s);

		return t2s;
	}

	/*---------------------------------------------------------------------*/	
	
	private ItemStack Tier3(Player p) {

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
		lore3.add("§8§oToo spooky for me!");
		mt3s.setLore(lore3);
		t3s.setItemMeta(mt3s);
		
		return t3s;
	}	

/*---------------------------------------------------------------------*/
	
	private ItemStack Tier4(Player p) {

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
		lore4.add("§8§oToo spooky for me!");
		mt4s.setLore(lore4);
		t4s.setItemMeta(mt4s);
		
		return t4s;
	}	

/*---------------------------------------------------------------------*/
	
	private ItemStack Tier5(Player p) {

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
		lore5.add("§8§oToo spooky for me!");
		mt5s.setLore(lore5);
		t5s.setItemMeta(mt5s);
		
		return t5s;
	}	




/*---------------------------------------------------------------------*/
	private ItemStack H2(Player p) {
	
	ItemStack t2a = new ItemStack(Material.CHAINMAIL_HELMET);
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
	lore7.add("§8§oToo spooky for me!");
	mt2a.setLore(lore7);
	t2a.setItemMeta(mt2a);
	
	return t2a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack H3(Player p) {
	
	ItemStack t3a = new ItemStack(Material.IRON_HELMET);
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
	lore8.add("§8§oToo spooky for me!");
	mt3a.setLore(lore8);
	t3a.setItemMeta(mt3a);
	
	return t3a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack H4(Player p) {
	
		ItemStack t4a = new ItemStack(Material.GOLDEN_HELMET);
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
		lore9.add("§8§oToo spooky for me!");
		mt4a.setLore(lore9);
		t4a.setItemMeta(mt4a);
		
		return t4a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack H5(Player p) {
	
	ItemStack t5a = new ItemStack(Material.DIAMOND_HELMET);
	ItemMeta mt5a = t5a.getItemMeta();
	
	mt5a.setDisplayName("§b§lSpooky Armor V");
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
	lore10.add("§8§oToo spooky for me!");
	mt5a.setLore(lore10);
	t5a.setItemMeta(mt5a);
	
	return t5a;
	
	}	



/*---------------------------------------------------------------------*/
	private ItemStack C2(Player p) {
	
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
	lore7.add("§8§oToo spooky for me!");
	mt2a.setLore(lore7);
	t2a.setItemMeta(mt2a);
	
	return t2a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack C3(Player p) {
	
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
	lore8.add("§8§oToo spooky for me!");
	mt3a.setLore(lore8);
	t3a.setItemMeta(mt3a);
	
	return t3a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack C4(Player p) {
	
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
		lore9.add("§8§oToo spooky for me!");
		mt4a.setLore(lore9);
		t4a.setItemMeta(mt4a);
		
		return t4a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack C5(Player p) {
	
	ItemStack t5a = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemMeta mt5a = t5a.getItemMeta();
	
	mt5a.setDisplayName("§b§lSpooky Armor V");
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
	lore10.add("§8§oToo spooky for me!");
	mt5a.setLore(lore10);
	t5a.setItemMeta(mt5a);
	
	return t5a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack L2(Player p) {
	
	ItemStack t2a = new ItemStack(Material.CHAINMAIL_LEGGINGS);
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
	lore7.add("§8§oToo spooky for me!");
	mt2a.setLore(lore7);
	t2a.setItemMeta(mt2a);
	
	return t2a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack L3(Player p) {
	
	ItemStack t3a = new ItemStack(Material.IRON_LEGGINGS);
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
	lore8.add("§8§oToo spooky for me!");
	mt3a.setLore(lore8);
	t3a.setItemMeta(mt3a);
	
	return t3a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack L4(Player p) {
	
		ItemStack t4a = new ItemStack(Material.GOLDEN_LEGGINGS);
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
		lore9.add("§8§oToo spooky for me!");
		mt4a.setLore(lore9);
		t4a.setItemMeta(mt4a);
		
		return t4a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack L5(Player p) {
	
	ItemStack t5a = new ItemStack(Material.DIAMOND_LEGGINGS);
	ItemMeta mt5a = t5a.getItemMeta();
	
	mt5a.setDisplayName("§b§lSpooky Armor V");
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
	lore10.add("§8§oToo spooky for me!");
	mt5a.setLore(lore10);
	t5a.setItemMeta(mt5a);
	
	return t5a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack B2(Player p) {
	
	ItemStack t2a = new ItemStack(Material.CHAINMAIL_BOOTS);
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
	lore7.add("§8§oToo spooky for me!");
	mt2a.setLore(lore7);
	t2a.setItemMeta(mt2a);
	
	return t2a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack B3(Player p) {
	
	ItemStack t3a = new ItemStack(Material.IRON_BOOTS);
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
	lore8.add("§8§oToo spooky for me!");
	mt3a.setLore(lore8);
	t3a.setItemMeta(mt3a);
	
	return t3a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack B4(Player p) {
	
		ItemStack t4a = new ItemStack(Material.GOLDEN_BOOTS);
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
		lore9.add("§8§oToo spooky for me!");
		mt4a.setLore(lore9);
		t4a.setItemMeta(mt4a);
		
		return t4a;
	
	}	


/*---------------------------------------------------------------------*/
	private ItemStack B5(Player p) {
	
	ItemStack t5a = new ItemStack(Material.DIAMOND_BOOTS);
	ItemMeta mt5a = t5a.getItemMeta();
	
	mt5a.setDisplayName("§b§lSpooky Armor V");
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
	lore10.add("§8§oToo spooky for me!");
	mt5a.setLore(lore10);
	t5a.setItemMeta(mt5a);
	
	return t5a;
	
	}
}
