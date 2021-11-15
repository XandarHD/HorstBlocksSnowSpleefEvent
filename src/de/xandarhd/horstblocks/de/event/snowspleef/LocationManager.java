package de.xandarhd.horstblocks.de.event.snowspleef;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationManager {
	public File locationsFile;
    public FileConfiguration locationsFileConfiguration;
    
    public LocationManager(){
        this.locationsFile = new File(SnowSpleef.spleef.getDataFolder(), "location.yml");
        this.locationsFileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.locationsFile);
    }
    
    public String setLocation(final String name, final Location loc){
        this.locationsFileConfiguration.set(String.valueOf(name) + ".world", (Object)loc.getWorld().getName());
        this.locationsFileConfiguration.set(String.valueOf(name) + ".x", (Object)loc.getX());
        this.locationsFileConfiguration.set(String.valueOf(name) + ".y", (Object)loc.getY());
        this.locationsFileConfiguration.set(String.valueOf(name) + ".z", (Object)loc.getZ());
        this.saveCfg();
		return name;
    }
    
    public Location getLocation(final String name){
        Location location = null;
        if (this.locationsFileConfiguration.isSet(name)){
            final World world = Bukkit.getWorld(this.locationsFileConfiguration.getString(String.valueOf(name) + ".world"));
            final double x = this.locationsFileConfiguration.getDouble(String.valueOf(name) + ".x");
            final double y = this.locationsFileConfiguration.getDouble(String.valueOf(name) + ".y");
            final double z = this.locationsFileConfiguration.getDouble(String.valueOf(name) + ".z");
            location = new Location(world, x, y, z);
        }
        return location;
    }
    public boolean isSetLocation(final String name){
    	return this.locationsFileConfiguration.isSet(name);
    }
    public void removeLocation(final String name){
    	 if (this.locationsFileConfiguration.isSet(name)){
    		 this.locationsFileConfiguration.setDefaults(null);
    	 }	
    }
    
    public void saveCfg(){
        try {
            this.locationsFileConfiguration.save(this.locationsFile);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
