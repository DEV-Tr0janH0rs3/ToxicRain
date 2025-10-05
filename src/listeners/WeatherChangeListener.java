package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import customevents.CustomWeather;
import me.devtrojan.toxicrain.ToxicRainPlugin;

public class WeatherChangeListener implements Listener{
	
	private final ToxicRainPlugin plugin = JavaPlugin.getPlugin(ToxicRainPlugin.class);
	private CustomWeather cw = new CustomWeather();
	private boolean changingWeather = false;
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(e.getWorld() == plugin.dworld) {
			
			if(changingWeather) return;
			
			plugin.isRaining = e.toWeatherState();
			
			if(plugin.isRaining) {
				changingWeather = true;
				cw.CustomStorm();
				changingWeather = false;
			}
		}
	}
}
