package com.spikeyhunter.halloweenmain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class WeaponryItems implements Listener {
	
	public HashMap<String, Long> healer = new HashMap<String, Long>();
	public HashMap<String, Long> pie = new HashMap<String, Long>();
	String prefix = (ChatColor.translateAlternateColorCodes('&', "&6&lHalloween &8>> "));
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInMainHand().equals(Healer(p))) {
			int cooldownTime = 60;
			if (healer.containsKey(p.getName())) {
				long secondsLeft = ((healer.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					p.sendMessage(prefix + ChatColor.RED + "Wait " + secondsLeft + " seconds before healing again!");
					return;
				}

			}
			healer.put(p.getName(), System.currentTimeMillis());
			p.sendMessage(prefix + ChatColor.GREEN + "Your health was fully restored");
			spawnFireworks(p.getLocation(), 1, Color.RED);
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1000, false, false), true);
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1, 1);
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_WITCH_DRINK, 1, 1);
			return;
		} 
		else if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInMainHand().equals(Pie(p))) {
			int cooldownTime = 30;
			if (pie.containsKey(p.getName())) {
				long secondsLeft = ((pie.get(p.getName()) / 1000) + cooldownTime)
						- (System.currentTimeMillis() / 1000);
				if (secondsLeft > 0) {
					p.sendMessage(prefix + ChatColor.RED + "Wait " + secondsLeft + " seconds before feeding again!");
					return;
				}

			}
			pie.put(p.getName(), System.currentTimeMillis());
			p.sendMessage(prefix + ChatColor.GREEN + "Your hunger was fully restored");
			spawnFireworks(p.getLocation(), 1, Color.LIME);
			p.setFoodLevel(20);
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);
			return;
		}
	}
	
	
    public static void spawnFireworks(Location location, int amount, Color color){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        
        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
        

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
}
