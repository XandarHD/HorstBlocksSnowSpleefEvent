package de.xandarhd.horstblocks.de.event.snowspleef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.xandarhd.horstblocks.de.event.snowspleef.commands.SnowSpleef_Command;
import de.xandarhd.horstblocks.de.event.snowspleef.listeners.BlockBreakListener;
import de.xandarhd.horstblocks.de.event.snowspleef.listeners.PlayerInteractListener;
import de.xandarhd.horstblocks.de.event.snowspleef.listeners.PlayerMoveListener;

public class SnowSpleef extends JavaPlugin{
	
	public static SnowSpleef spleef;
	public LocationManager lm;
	public static String prefix = "§9[§fSnow§bSpleef§9]§7 ";
	public static Boolean start;
	public static Boolean beakallowdney;
	public final List<Block> blocks;
	
	public ArrayList<String> AlivePlayers;
	public HashMap<String, String> Platz1;
	public HashMap<String, String> Platz2;
	public HashMap<String, String> Platz3;
	public static Plugin m;
	
	public SnowSpleef(){
		this.blocks = new ArrayList<Block>();
		
		this.AlivePlayers = new ArrayList<String>();
		this.Platz1 = new HashMap<String, String>();
		this.Platz2 = new HashMap<String, String>();
		this.Platz3 = new HashMap<String, String>();
	}

	public void onEnable(){
		spleef = this;
		
		this.lm = new LocationManager();
		this.lm.saveCfg();
		
		SnowSpleef.m = (Plugin)this;
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new PlayerInteractListener(), this);
		pluginManager.registerEvents(new BlockBreakListener(), this);
		pluginManager.registerEvents(new PlayerMoveListener(), this);
		getCommand("snowspleef").setExecutor(new SnowSpleef_Command());
	}
	
	public void onDisable(){
		
	}
	
	public static Plugin thisp() {
        return SnowSpleef.m;
    }
	
	static{
		SnowSpleef.start = false;
		SnowSpleef.beakallowdney = false;
	}
}