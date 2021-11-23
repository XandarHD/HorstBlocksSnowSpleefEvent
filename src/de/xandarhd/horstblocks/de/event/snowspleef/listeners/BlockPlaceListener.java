package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;
import de.xandarhd.horstblocks.de.event.snowspleef.Utils;

public class BlockPlaceListener implements Listener{
	
	@EventHandler
	public void onBLockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		if(!player.hasPermission("snowspleef.breakblocks") 
				|| player.hasPermission("snowspleef.admin") 
				|| player.isOp()){
			if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					event.setCancelled(true);
				}
			}
		}
		if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
			if(!SnowSpleef.start){
				event.setCancelled(true);
			}else if(!Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				event.setCancelled(true);
			}
		}else{
			if(SnowSpleef.start){
				if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					event.setCancelled(true);
				}
			}
		}
		if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
			if(!SnowSpleef.start){
				event.setCancelled(true);
			}
		}
	}
}
