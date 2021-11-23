package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.bukkit.entity.Projectile;
import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;

public class EntityDamageOnEntityListener implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event){
		if(!SnowSpleef.pvpallowdney){
			if(event.getDamager().getType() == EntityType.SNOWBALL && event.getEntity() instanceof Player){
				if(SnowSpleef.spleef.LaunchSnowball.containsKey(event.getEntity().getName())){
					Player damager = Bukkit.getPlayer(SnowSpleef.spleef.LaunchSnowball.get(event.getEntity().getName()));
					if(damager.getInventory().getItemInMainHand().getType() == Material.SNOWBALL
							|| damager.getInventory().getItemInOffHand().getType() == Material.SNOWBALL){
						if(SnowSpleef.spleef.ShootSnowball.contains(damager.getName())){
							SnowSpleef.spleef.LaunchSnowball.remove(event.getEntity().getName());
							SnowSpleef.spleef.ShootSnowball.remove(damager.getName());
							event.setCancelled(false);
						}else{
							event.setCancelled(true);
						}
						return;
					}
				}
			}
			event.setCancelled(true);
		}else{
			/*if(event.getDamager().getType() == EntityType.SNOWBALL && event.getEntity() instanceof Player){
				System.out.println("Scheeball getroffen");
				Player player = (Player)((Projectile)event.getDamager()).getShooter();
				if (SnowSpleef.spleef.Cooldown.containsKey(player.getName())){
			          long secondsLeft = ((Long)SnowSpleef.spleef.Cooldown.get(player.getName())).longValue() / 1000L + 3 - System.currentTimeMillis() / 1000L;
			          if (secondsLeft > 0L) {
			            event.setCancelled(true);
			            System.out.println("Cooldown an");
			            return;
			          } 
			          SnowSpleef.spleef.Cooldown.remove(player.getName());
			        } 
				SnowSpleef.spleef.Cooldown.put(player.getName(), Long.valueOf(System.currentTimeMillis()));
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)SnowSpleef.spleef, new Runnable() {
		            public void run() {
		              Player player = (Player)event.getEntity();
		              Vector plrV = player.getVelocity();
		              Vector velocity = new Vector(plrV.getX() * 2, plrV.getY() * 2, plrV.getZ() * 2);
		              player.setVelocity(velocity);
		              System.out.println("target Player get Knockback");
		            }
				}, 0L);
			}*/
		}
	}
}
