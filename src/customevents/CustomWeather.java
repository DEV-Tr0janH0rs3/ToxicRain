package customevents;

import java.util.Random;

import org.bukkit.plugin.java.JavaPlugin;

import me.devtrojan.toxicrain.ToxicRainPlugin;

public class CustomWeather {
	
	ToxicRainPlugin plugin = JavaPlugin.getPlugin(ToxicRainPlugin.class);
	Random rand = new Random();
	int minraintime = Integer.parseInt(plugin.config.getString("min-rain-time"));
	int maxraintime = Integer.parseInt(plugin.config.getString("max-rain-time"));
	
	public void CustomStorm() {
		int duration = rand.nextInt(maxraintime - minraintime + 1) + minraintime;
		plugin.dworld.setStorm(true);
		plugin.dworld.setThundering(true);
		plugin.dworld.setWeatherDuration(duration);
		System.out.println(duration);
	}
}
