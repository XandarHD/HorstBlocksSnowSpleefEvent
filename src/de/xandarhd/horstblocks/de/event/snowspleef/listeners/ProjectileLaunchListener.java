package de.xandarhd.horstblocks.de.event.snowspleef.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import de.xandarhd.horstblocks.de.event.snowspleef.SnowSpleef;

public class ProjectileLaunchListener implements Listener{
	
	@EventHandler
	public void onEntityDamage11(ProjectileHitEvent event){
		if(event.getEntity().getShooter() instanceof Player){
			if(event.getHitEntity() instanceof Player){
				Player shooter = (Player) event.getEntity().getShooter();
				Player damager = (Player) event.getHitEntity();
				if(!SnowSpleef.spleef.LaunchSnowball.containsKey(damager.getName())){
					SnowSpleef.spleef.LaunchSnowball.put(damager.getName(), shooter.getName());
				}
			}
		}
	}
}
