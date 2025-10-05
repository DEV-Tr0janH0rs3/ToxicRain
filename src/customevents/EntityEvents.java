package customevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.devtrojan.toxicrain.ToxicRainPlugin;

public class EntityEvents implements Listener{
	
	ToxicRainPlugin plugin = JavaPlugin.getPlugin(ToxicRainPlugin.class);

	public void StartEvent(LivingEntity zombie) {
		zombie.addPotionEffect(plugin.poteffect);
	}
}
