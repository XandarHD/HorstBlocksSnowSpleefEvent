package de.xandarhd.horstblocks.de.event.snowspleef.listeners;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;

public class PlayerInteractListener implements Listener{
	
	@EventHandler
	public void onPLayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		final ItemStack currentItem = event.getItem();
		if(player.hasPermission("snowspleef.setregion") 
				|| player.hasPermission("snowspleef.admin") 
				|| player.isOp()){
			if(currentItem != null && currentItem.hasItemMeta() && currentItem.getItemMeta().getDisplayName() != null && (event.getAction() == Action.LEFT_CLICK_BLOCK)){
		    	 if(currentItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Snow-Spleef " + ChatColor.GRAY + "Region Makierer")){
		    		 SnowSpleef.spleef.lm.setLocation("pos1", event.getClickedBlock().getLocation());
						player.sendMessage(SnowSpleef.prefix + "Pos1 gesetzt!");
		    	 }
		     }else if(currentItem != null && currentItem.hasItemMeta() && currentItem.getItemMeta().getDisplayName() != null && (event.getAction() == Action.RIGHT_CLICK_BLOCK)){
		    	 if(currentItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Snow-Spleef " + ChatColor.GRAY + "Region Makierer")){
		    		 SnowSpleef.spleef.lm.setLocation("pos2", event.getClickedBlock().getLocation());
						player.sendMessage(SnowSpleef.prefix + "Pos2 gesetzt!");
		    	 }
			}
		}
	}
}
