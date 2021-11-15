package de.xandarhd.horstblocks.de.event.snowspleef;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Countdown {
	
	public static int taskID;
	
	public static void Countdown(final Player player) {
		Countdown.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(SnowSpleef.thisp(), (Runnable)new Runnable() {
            int count = 30;
            
            @Override
            public void run() {
                switch (this.count) {
                    case 1: {
                        Bukkit.broadcastMessage("\n \n" + SnowSpleef.prefix + "Das Event startet in: " + ChatColor.GOLD + "1 " + ChatColor.GRAY + "Sekunden");
                        for (final Player players : Bukkit.getOnlinePlayers()) {
                        	players.getWorld().playSound(players.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10, 1);
                        }
                        break;
                    }
                    case 2: {
                        Bukkit.broadcastMessage("\n \n" + SnowSpleef.prefix + "Das Event startet in: " + ChatColor.GOLD + "2 " + ChatColor.GRAY + "Sekunden");
                        for (final Player players : Bukkit.getOnlinePlayers()) {
                        	players.getWorld().playSound(players.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10, 1);
                        }
                        break;
                    }
                    case 3: {
                        Bukkit.broadcastMessage("\n \n" + SnowSpleef.prefix + "Das Event startet in: " + ChatColor.GOLD + "3 " + ChatColor.GRAY + "Sekunden");
                        for (final Player players : Bukkit.getOnlinePlayers()) {
                        	players.getWorld().playSound(players.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10, 1);
                        }
                        break;
                    }
                    case 10: {
                        Bukkit.broadcastMessage("\n \n" + SnowSpleef.prefix + "Das Event startet in: " + ChatColor.GOLD + "10 " + ChatColor.GRAY + "Sekunden");
                        for (final Player players : Bukkit.getOnlinePlayers()) {
                        	players.getWorld().playSound(players.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10, 1);
                        }
                        break;
                    }
                    case 0: {
                        Bukkit.broadcastMessage("\n \n" + SnowSpleef.prefix + "Das Event wurde gestartet!");
                        SnowSpleef.beakallowdney = true;
                        this.count = 60;
                        for (final Player a : Bukkit.getOnlinePlayers()) {
                            a.getWorld().playSound(a.getLocation(), Sound.BLOCK_END_GATEWAY_SPAWN, 10, 1);
                        }
                        //
                        Bukkit.getScheduler().cancelTask(Countdown.taskID);
                        break;
                    }
                }
                --this.count;
            }
        }, 0L, 20L);
	}
}
