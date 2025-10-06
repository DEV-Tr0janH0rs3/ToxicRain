package listeners;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import customevents.EntityEvents;
import me.devtrojan.toxicrain.ToxicRainPlugin;

public class ZombieSpawnEvent implements Listener{
	
	ToxicRainPlugin plugin = JavaPlugin.getPlugin(ToxicRainPlugin.class);
	EntityEvents entityEvents = new EntityEvents();
	
	@EventHandler
	public void onZombieSpawn(CreatureSpawnEvent e) {
		if(e.getEntity() instanceof Zombie) {
			Ageable babyZ = (Ageable)e.getEntity();
			if(plugin.isRaining) {
				if(e.getEntity() != babyZ) {
					entityEvents.StartEvent(e.getEntity());
				}
			}
		}
	}
	
}
