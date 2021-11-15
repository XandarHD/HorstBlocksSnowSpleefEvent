package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;
import de.xandarhd.horstblocks.de.event.snowspleef.Utils;

public class BlockBreakListener implements Listener{
	
	private static final Random random = new Random();
	public static final Random getRandom() {
	    return random;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		if(player.getInventory().getItemInMainHand().getType() == Material.STICK
				|| player.getInventory().getItemInOffHand().getType() == Material.STICK){
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Snow-Spleef " + ChatColor.GRAY + "Region Makierer")
					|| player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Snow-Spleef " + ChatColor.GRAY + "Region Makierer")){
				if(player.hasPermission("snowspleef.setregion") 
						|| player.hasPermission("snowspleef.admin") 
						|| player.isOp()){
					event.setCancelled(true);
				}
			}
		}
		if(SnowSpleef.beakallowdney){
			if(player.getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL
					|| player.getInventory().getItemInOffHand().getType() == Material.IRON_SHOVEL){
				if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("SchneeSchaufel")
						|| player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase("SchneeSchaufel")){
					if(event.getBlock().getType() == Material.SNOW_BLOCK){
						ItemStack snow = new ItemStack(Material.SNOWBALL);
						if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
							if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
								
								SnowSpleef.spleef.blocks.add(event.getBlock());
								
								if (getRandom().nextInt(100) < 35){
									player.getInventory().addItem(snow);
								}
							}
						}
					}
				}
			}
			if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				event.setDropItems(false);
				if(!SnowSpleef.start){
					event.setCancelled(true);
				}else if(!Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					event.setCancelled(true);
				}
			}else{
				if(SnowSpleef.start){
					if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
						event.setCancelled(true);
						event.setDropItems(false);
					}
				}
			}
			if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				event.setDropItems(false);
				if(!SnowSpleef.start){
					event.setCancelled(true);
				}
			}
		}else{
			if(!player.hasPermission("snowspleef.breakblocks") 
					|| player.hasPermission("snowspleef.admin") 
					|| player.isOp()){
				if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
						event.setCancelled(true);
					}
				}
			}
			if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				event.setDropItems(false);
				if(!SnowSpleef.start){
					event.setCancelled(true);
				}else if(!Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					event.setCancelled(true);
				}
			}else{
				if(SnowSpleef.start){
					if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
						event.setCancelled(true);
						event.setDropItems(false);
					}
				}
			}
			if(Utils.isInRegion(event.getBlock().getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
				event.setDropItems(false);
				if(!SnowSpleef.start){
					event.setCancelled(true);
				}
			}
		}
	}
}
