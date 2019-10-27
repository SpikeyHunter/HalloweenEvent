package com.spikeyhunter.halloweenmain;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class MainClass extends JavaPlugin implements Listener{
	
	  private final CommandSender console = Bukkit.getConsoleSender();
	  private final PluginManager pluginManager = Bukkit.getPluginManager();
	  private final String KEY_KILLS = "monsters_killed";
	  private FileConfiguration config;
	  private MonsterDeathListener monsterDeathListener;
	  private long kills;
	  
	  public double kills2() {
		  int x = getConfig().getInt(KEY_KILLS);
		  return ((x * 100f) / 500000f) / 10f;
		  }
	  
	  /*Integer x = (int) getConfig().getLong(KEY_KILLS);
	  double kills2 = ((x * 100f) / 10000f) / 10f;*/
	  
	  private final String 
	    enableMessage = ChatColor.GREEN + "HalloweenMain - TownyOrigins by SpipkeyHunter has been enabled!",
	    disableMessage= ChatColor.RED + ".HalloweenMain - TownyOrigins by SpipkeyHunter has been disabled!.";


	  @Override public void onEnable(){
	        if (!setupEconomy() ) {
	            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
	            getServer().getPluginManager().disablePlugin(this);
	            return;
	        }
	    console.sendMessage(enableMessage);
	    pluginManager.registerEvents(new BossZombie(this),this);
	    pluginManager.registerEvents(new BossSkeleton(this),this);
	    pluginManager.registerEvents(new KillListener(this),this);
	    pluginManager.registerEvents(new WeaponryInv(),this);
	    pluginManager.registerEvents(new WeaponryListener(),this);
	    pluginManager.registerEvents(new WeaponryItems(),this);
	    pluginManager.registerEvents(new PortalListener(this),this);
	    pluginManager.registerEvents(new WorldGuardPortal(this),this);
	    pluginManager.registerEvents(new StevenEntrance(this), this);
	    pluginManager.registerEvents(new StevenProjectile(), this);
	    pluginManager.registerEvents(new StevenBoss(this), this);
	    pluginManager.registerEvents(new StevenDeaths(this), this);
	    pluginManager.registerEvents(new StevenSpectator(this), this);
	    pluginManager.registerEvents(new StevenHealer(this), this);
	    

	    pluginManager.registerEvents(new HealRegions(),this);
	    pluginManager.registerEvents(new PortalRoom(),this);
	    
	    getCommand("event").setExecutor(new CustomCreatures(this));
	    getCommand("weaponry").setExecutor(new WeaponryCmd(this));
	    getCommand("ghost").setExecutor(new GhostReward(this));
	    getCommand("loc").setExecutor(new LocationGet(this));
	    getCommand("leave").setExecutor(new Arena());
	    getCommand("treats").setExecutor(new TreatsItem());
	    getCommand("talk").setExecutor(new TalkingCMD());
	    getCommand("sb").setExecutor(new Scoreboards(this));
	    
	    pluginManager.registerEvents(this, this);
	    
	    this.config = getConfig();
	    this.monsterDeathListener = new MonsterDeathListener(config.getLong(KEY_KILLS, 0));
	    pluginManager.registerEvents(monsterDeathListener, this);
	    
	   
	    
	    
	    /*this.getServer().getScheduler().runTaskLater(this, new Runnable() {
			public void run() {	
				UpdateProgress();
			}}, 100L);*/
	  }

	  @Override public void onDisable(){
	    console.sendMessage(disableMessage);
	    config.set(KEY_KILLS, monsterDeathListener.getKills());
	    saveConfig();
	    log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
	  }
	  
	  	private static final Logger log = Logger.getLogger("Minecraft");
	    private static Economy econ = null;
	    
	    private boolean setupEconomy() {
	        if (getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	    }
 
	    public static Economy getEconomy() {
	        return econ;
	    }
	    
	    
	
	  
	  
	  @EventHandler private void onZombieDeath(EntityDeathEvent event){
		    final LivingEntity entity = event.getEntity();
		    if (entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.PIG_ZOMBIE || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.WITHER_SKELETON) {
		    	if (entity.getKiller() instanceof Player) kills++;
		    } else return;
		    config.set(KEY_KILLS, monsterDeathListener.getKills());
		    saveConfig();
		    
		  }
	  
	  
	 BossBar bar = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', "&6&lHalloween Goal"), BarColor.YELLOW, BarStyle.SOLID);

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		bar.addPlayer(p);
		bar.setProgress(kills2());
		bar.setVisible(true);
		
		p.performCommand("sb on");
		
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		bar.removePlayer(p);
		bar.setVisible(false);
	}
	  
	}


	
    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/	
