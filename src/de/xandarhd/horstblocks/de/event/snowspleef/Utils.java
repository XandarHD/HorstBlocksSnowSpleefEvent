package de.xandarhd.horstblocks.de.event.snowspleef;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
	
	public static ItemStack createItemStack(final Material material, String displayName,  final List<String> lore) {
        return createItemStack16(material, displayName, lore);
    }
    
    public static ItemStack createItemStack16(final Material material, final String displayName, final List<String> lore) {
    	final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore((List<String>)lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    public static boolean isInRegion(Location loc, Location loc1, Location loc2){
    	Double maxX = (loc1.getX() > loc2.getX() ? loc1.getX() : loc2.getX());
    	Double minX = (loc1.getX() < loc2.getX() ? loc1.getX() : loc2.getX());
    	
    	//Double maxY = (loc1.getY() > loc2.getY() ? loc1.getY() : loc2.getY());
    	//Double minY = (loc1.getY() < loc2.getY() ? loc1.getY() : loc2.getY());
    	
    	Double maxZ = (loc1.getZ() > loc2.getZ() ? loc1.getZ() : loc2.getZ());
    	Double minZ = (loc1.getZ() < loc2.getZ() ? loc1.getZ() : loc2.getZ());
    	
    	if(loc.getX() <= maxX && loc.getX() >= minX){
    		//if(loc.getY() <= maxY && loc.getY() >= minY){
    			if(loc.getZ() <= maxZ && loc.getZ() >= minZ){
    				return true;
    			}
    		//}
    		
    	}
    	
		return false;
    }
    
    public static void SetBlocksInRegion(Location loc, Location loc1, Location loc2){
    	Double maxX = (loc1.getX() > loc2.getX() ? loc1.getX() : loc2.getX());
    	Double minX = (loc1.getX() < loc2.getX() ? loc1.getX() : loc2.getX());
    	
    	//Double maxY = (loc1.getY() > loc2.getY() ? loc1.getY() : loc2.getY());
    	//Double minY = (loc1.getY() < loc2.getY() ? loc1.getY() : loc2.getY());
    	
    	Double maxZ = (loc1.getZ() > loc2.getZ() ? loc1.getZ() : loc2.getZ());
    	Double minZ = (loc1.getZ() < loc2.getZ() ? loc1.getZ() : loc2.getZ());
    	
    	if(loc.getX() <= maxX && loc.getX() >= minX){
    		//if(loc.getY() <= maxY && loc.getY() >= minY){
    			if(loc.getZ() <= maxZ && loc.getZ() >= minZ){
    				
    			}
    		//}
    		
    	}
    }
    public static void ClearPlayer(Player player){
    	//player.setGameMode(GameMode.ADVENTURE);
		player.getInventory().clear();
		player.setHealth(20);
		player.setFoodLevel(20);
    }
}
