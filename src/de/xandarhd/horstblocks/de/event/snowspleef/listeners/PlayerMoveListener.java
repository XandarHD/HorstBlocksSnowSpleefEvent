package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;
import de.xandarhd.horstblocks.de.event.snowspleef.Utils;

public class PlayerMoveListener implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(SnowSpleef.spleef.lm.isSetLocation("pos1")){
			if(SnowSpleef.spleef.lm.isSetLocation("pos2")){
				if(Utils.isInRegion(player.getLocation(), SnowSpleef.spleef.lm.getLocation("pos1"), SnowSpleef.spleef.lm.getLocation("pos2"))){
					if(player.getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.BEDROCK){
			            if(player.getLocation().subtract(0D, 2D, 0D).getBlock().getType() == Material.REDSTONE_BLOCK){
			            	if(SnowSpleef.start){
			            		player.sendMessage(SnowSpleef.prefix + "Du bist ausgeschieden!");
			            		player.teleport(SnowSpleef.spleef.lm.getLocation("spectator"));
			            		Utils.ClearPlayer(player);
			            		if(SnowSpleef.spleef.AlivePlayers.size() == 3){
			            			if(!SnowSpleef.spleef.Platz2.containsKey("Platz3")){
			            				SnowSpleef.spleef.Platz2.put("Platz3", player.getName());
			            				for(Player players : Bukkit.getOnlinePlayers()){
			            					players.sendMessage(SnowSpleef.prefix + "Der Spieler " + ChatColor.GOLD + ChatColor.BOLD + player.getName() + ChatColor.RESET  + ChatColor.GRAY + " hat den" 
		        				+ ChatColor.GOLD + ChatColor.BOLD + " dirtten " + ChatColor.RESET + ChatColor.GRAY + "Platz ergattert!");
			            				}
			            			}
			            		}else if(SnowSpleef.spleef.AlivePlayers.size() == 2){
			            			if(!SnowSpleef.spleef.Platz2.containsKey("Platz2")){
			            				SnowSpleef.spleef.Platz2.put("Platz2", player.getName());
			            				for(Player players : Bukkit.getOnlinePlayers()){
			            					players.sendMessage(SnowSpleef.prefix + "Der Spieler " + ChatColor.GOLD + ChatColor.BOLD + player.getName() + ChatColor.RESET  + ChatColor.GRAY + " hat den" 
		        				+ ChatColor.GOLD + ChatColor.BOLD + " zweiten " + ChatColor.RESET + ChatColor.GRAY + "Platz ergattert!");
			            				}
			            			}
			            		}else if(SnowSpleef.spleef.AlivePlayers.size() == 1){
			            			if(!SnowSpleef.spleef.Platz2.containsKey("Platz1")){
			            				SnowSpleef.spleef.Platz2.put("Platz1", player.getName());
			            				for(Player players : Bukkit.getOnlinePlayers()){
			            					players.sendMessage(SnowSpleef.prefix + "Der Spieler " + ChatColor.GOLD + ChatColor.BOLD + player.getName() + ChatColor.RESET  + ChatColor.GRAY + " hat den" 
		        				+ ChatColor.GOLD + ChatColor.BOLD + " ersten " + ChatColor.RESET + ChatColor.GRAY + "Platz ergattert!");
			            					players.sendMessage(ChatColor.GREEN + "----------------------------------------------------");
			            					if(SnowSpleef.spleef.Platz1.containsKey("Platz1")){
			            						players.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + SnowSpleef.spleef.Platz1.get("Platz1") + ChatColor.GRAY + " hat den "+ ChatColor.GOLD + "ersten" + ChatColor.GRAY + " Platz belegt!");
			            					}
			            					if(SnowSpleef.spleef.Platz2.containsKey("Platz2")){
			            						players.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + SnowSpleef.spleef.Platz2.get("Platz2") + ChatColor.GRAY + " hat den "+ ChatColor.GOLD + "zweiten" + ChatColor.GRAY + " Platz belegt!");
			            					}
			            					if(SnowSpleef.spleef.Platz3.containsKey("Platz3")){
			            						players.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + SnowSpleef.spleef.Platz3.get("Platz3") + ChatColor.GRAY + " hat den "+ ChatColor.GOLD + "dritten" + ChatColor.GRAY + " Platz belegt!");
			            					}
			            					players.sendMessage(ChatColor.GREEN + "----------------------------------------------------");
			            					SnowSpleef.beakallowdney = false;
			            				}
			            			}
			            		}
			            	}
			            }
					}
				}
			}
		}
	}
}
