package de.xandarhd.horstblocks.de.event.snowspleef.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.xandarhd.horstblocks.de.event.snowspleef.Countdown;
import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;
import de.xandarhd.horstblocks.de.event.snowspleef.Utils;

public class SnowSpleef_Command implements CommandExecutor{
	
	public static int taskID;

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if((sender instanceof Player)){
			Player player = (Player)sender;
			if(args.length == 0){
				if(player.hasPermission("snowspleef.help") 
						|| player.hasPermission("snowspleef.admin") 
						|| player.isOp()){
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef start" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Startet das Event");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef stop" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Stopt das Event");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef pvp" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Schlatet das PVP an/aus");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef region" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Zeigt dir die Positionen der Arena an");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef region set" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Erhaltest einen Makierstick");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef spectator" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Zeigt dir die Positionen des Spectators an");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef spectator set" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Setzt den Zuschauerspawn");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef spawn" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Zeigt dir die Positionen des Spawnes an");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef spawn set" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Setzt den Spawn");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef reset platform" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Setzt die Platform zurück");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef reset players" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Setzt alle Spieler zurück");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef reset player <PlayerName>" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Setzt einen bestimmten Spieler zurück");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef break allow" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Erlaubt das abbauen von Schnee");
					player.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "/snowspleef break deny" + ChatColor.GREEN + "->" + ChatColor.GRAY + "Verbietet das abbauen von Schnee");
				}
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("region")){
					if(player.hasPermission("snowspleef.region") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						player.sendMessage(SnowSpleef.prefix + "POS1: " + SnowSpleef.spleef.lm.getLocation("pos1").getWorld().getName() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos1").getBlockX() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos1").getBlockY() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos1").getBlockZ());
						player.sendMessage(SnowSpleef.prefix + "POS2: " + SnowSpleef.spleef.lm.getLocation("pos2").getWorld().getName() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos2").getBlockX() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos2").getBlockY() + ", "
								+ SnowSpleef.spleef.lm.getLocation("pos2").getBlockZ());
					}
				}
				if(args[0].equalsIgnoreCase("pvp")){
					if(player.hasPermission("snowspleef.region") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						if(SnowSpleef.pvpallowdney){
							player.sendMessage(SnowSpleef.prefix + ChatColor.RED + "PVP ist nun augeschaltet!");
							SnowSpleef.pvpallowdney = false;
						}else{
							player.sendMessage(SnowSpleef.prefix + ChatColor.GREEN + "PVP ist nun angeschaltet!");
							SnowSpleef.pvpallowdney = true;
						}
					}
				}
				if(args[0].equalsIgnoreCase("start")){
					if(player.hasPermission("snowspleef.start") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						if(!SnowSpleef.start){
							SnowSpleef.start = true;
							//SnowSpleef.beakallowdney = true;
							SnowSpleef.spleef.AlivePlayers.clear();
							SnowSpleef.spleef.Platz1.clear();
							SnowSpleef.spleef.Platz2.clear();
							SnowSpleef.spleef.Platz3.clear();
							for(Player players : Bukkit.getOnlinePlayers()){
								if(!players.hasPermission("snowspleef.bypass") 
										|| !players.hasPermission("snowspleef.eventteam") 
										|| !players.isOp()){
									SnowSpleef.spleef.AlivePlayers.add(players.getName());
									players.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "Das Event startet in 30 Sekunden!");
									players.sendMessage(SnowSpleef.prefix + ChatColor.GOLD + "Bereitet euch vor und verteilt euch!");
									players.setGameMode(GameMode.SURVIVAL);
									ItemStack itemStack = new ItemStack(Material.IRON_SHOVEL);
									ItemMeta itemMeta = itemStack.getItemMeta();
									itemMeta.setUnbreakable(true);
									itemMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "SchneeSchaufel");
									itemStack.setItemMeta(itemMeta);
									players.getInventory().setItemInMainHand(itemStack);
									players.teleport( SnowSpleef.spleef.lm.getLocation("spawn"));
									players.setHealth(20);
									players.setFoodLevel(20);
									
								}
							}
							Countdown.Countdown(player);
						}else{
							player.sendMessage(SnowSpleef.prefix + "Das Event wurde schon gestartet!");
						}
					}
				}
				if(args[0].equalsIgnoreCase("spectator")){
					if(player.hasPermission("snowspleef.spectator") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						player.sendMessage(SnowSpleef.prefix + "Spectator: " + SnowSpleef.spleef.lm.getLocation("spectator").getWorld().getName() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spectator").getBlockX() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spectator").getBlockY() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spectator").getBlockZ());
					}
				}
				if(args[0].equalsIgnoreCase("spawn")){
					if(player.hasPermission("snowspleef.spawn") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						player.sendMessage(SnowSpleef.prefix + "Spawn: " + SnowSpleef.spleef.lm.getLocation("spawn").getWorld().getName() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spawn").getBlockX() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spawn").getBlockY() + ", "
								+ SnowSpleef.spleef.lm.getLocation("spawn").getBlockZ());
					}
				}
				if(args[0].equalsIgnoreCase("stop")){
					if(player.hasPermission("snowspleef.stop") 
							|| player.hasPermission("snowspleef.admin") 
							|| player.isOp()){
						if(SnowSpleef.start){
							Bukkit.getScheduler().cancelTask(Countdown.taskID);
							SnowSpleef.start = false;
							SnowSpleef.beakallowdney = false;
							SnowSpleef.pvpallowdney = false;
							SnowSpleef.spleef.AlivePlayers.clear();
							SnowSpleef.spleef.Platz1.clear();
							SnowSpleef.spleef.Platz2.clear();
							SnowSpleef.spleef.Platz3.clear();
							SnowSpleef.spleef.LaunchSnowball.clear();
							SnowSpleef.spleef.ShootSnowball.clear();
							for(Player players : Bukkit.getOnlinePlayers()){
								players.sendMessage(SnowSpleef.prefix + "Das Event wurde beendet!");
								Utils.ClearPlayer(players);
								players.teleport( SnowSpleef.spleef.lm.getLocation("spectator"));
							}
							
							for (Block block : SnowSpleef.spleef.blocks)
							      block.setType(Material.SNOW_BLOCK); 
							SnowSpleef.spleef.blocks.clear();
							
						}else{
							player.sendMessage(SnowSpleef.prefix + "Das Event wurde schon beendet!");
						}
					}
				}
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("region")){
					if(args[1].equalsIgnoreCase("set")){
						if(player.hasPermission("snowspleef.setregion") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							final ItemStack RegionMarker = Utils.createItemStack(Material.STICK, ChatColor.WHITE + "Snow-Spleef " + ChatColor.GRAY + "Region Makierer", null);
							player.getInventory().setItemInMainHand(RegionMarker);
						}
					}
				}
				if(args[0].equalsIgnoreCase("spectator")){
					if(args[1].equalsIgnoreCase("set")){
						if(player.hasPermission("snowspleef.setspectator") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							SnowSpleef.spleef.lm.setLocation("spectator", player.getLocation());
							player.sendMessage(SnowSpleef.prefix + "Spectator gesetzt!");
						}
					}
				}
				if(args[0].equalsIgnoreCase("spawn")){
					if(args[1].equalsIgnoreCase("set")){
						if(player.hasPermission("snowspleef.setspawn") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							SnowSpleef.spleef.lm.setLocation("spawn", player.getLocation());
							player.sendMessage(SnowSpleef.prefix + "Spawn gesetzt!");
						}
					}
				}
				if(args[0].equalsIgnoreCase("reset")){
					if(args[1].equalsIgnoreCase("platform")){
						if(player.hasPermission("snowspleef.resetplatform") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							for (Block block : SnowSpleef.spleef.blocks)
							      block.setType(Material.SNOW_BLOCK); 
							SnowSpleef.spleef.blocks.clear();
							player.sendMessage(SnowSpleef.prefix + "Platform zurückgesetzt!");
						}
					}
					if(args[1].equalsIgnoreCase("players")){
						if(player.hasPermission("snowspleef.resetplayers") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							if(SnowSpleef.start){
								for(Player players : Bukkit.getOnlinePlayers()){
									if(!players.hasPermission("snowspleef.bypass") 
											|| !players.hasPermission("snowspleef.eventteam") 
											|| !players.isOp()){
										
									}
									if(!players.hasPermission("snowspleef.bypass") 
											|| !players.hasPermission("snowspleef.eventteam") 
											|| !players.isOp()){
										Utils.ClearPlayer(players);
										ItemStack itemStack = new ItemStack(Material.IRON_SHOVEL);
										ItemMeta itemMeta = itemStack.getItemMeta();
										itemMeta.setUnbreakable(true);
										itemMeta.setDisplayName("SchneeSchaufel");
										itemStack.setItemMeta(itemMeta);
										players.getInventory().setItemInMainHand(itemStack);
									}
								}
								player.sendMessage(SnowSpleef.prefix + "Spieler wurden zurückgesetzt!");
							}
						}
					}
				}
				if(args[0].equalsIgnoreCase("break")){
					if(args[1].equalsIgnoreCase("allow")){
						if(player.hasPermission("snowspleef.breakallow") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							SnowSpleef.beakallowdney = true;
							//player.sendMessage(SnowSpleef.prefix + "Das abbauen wurde freigegeben!");
							Bukkit.broadcastMessage(SnowSpleef.prefix + ChatColor.GREEN + "Das abbauen von Schneeblöcken wurde aktiviert!");
						}
					}
					if(args[1].equalsIgnoreCase("deny")){
						if(player.hasPermission("snowspleef.breakdeny") 
								|| player.hasPermission("snowspleef.admin") 
								|| player.isOp()){
							SnowSpleef.beakallowdney = false;
							//player.sendMessage(SnowSpleef.prefix + "Das abbauen wurde gesperrt!");
							Bukkit.broadcastMessage(SnowSpleef.prefix + ChatColor.RED + "Das abbauen von Schneeblöcken wurde deaktiviert!");
						}
					}
				}
			}
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("reset")){
					if(args[1].equalsIgnoreCase("player")){
						String PlayerName = args[2];
						if(args[2].equalsIgnoreCase(PlayerName)){
							if(Bukkit.getPlayer(PlayerName).isOnline()){
								if(SnowSpleef.start){
									Utils.ClearPlayer(Bukkit.getPlayer(PlayerName));
									ItemStack itemStack = new ItemStack(Material.IRON_SHOVEL);
									ItemMeta itemMeta = itemStack.getItemMeta();
									itemMeta.setUnbreakable(true);
									itemMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "SchneeSchaufel");
									itemStack.setItemMeta(itemMeta);
									Bukkit.getPlayer(PlayerName).getInventory().setItemInMainHand(itemStack);
									player.sendMessage(SnowSpleef.prefix + "Der Spieler: " + ChatColor.GOLD + PlayerName + ChatColor.GRAY + " wurden zurückgesetzt!");
									Bukkit.getPlayer(PlayerName).sendMessage(SnowSpleef.prefix + "Du wurdest vom " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + " zurückgesetzt!");
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
