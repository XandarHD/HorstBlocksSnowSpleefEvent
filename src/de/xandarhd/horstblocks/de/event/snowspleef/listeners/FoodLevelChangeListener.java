package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener{
	
	@EventHandler
	public void onEntityDama(FoodLevelChangeEvent event){
		event.setCancelled(true);
	}
}
