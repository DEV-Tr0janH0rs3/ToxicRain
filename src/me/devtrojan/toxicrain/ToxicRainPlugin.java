package me.devtrojan.toxicrain;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import listeners.WeatherChangeListener;
import listeners.ZombieSpawnEvent;

public class ToxicRainPlugin extends JavaPlugin{
	
	public FileConfiguration config;
	public World dworld;
	public boolean isRaining;
    public PotionEffect poteffect;
	
	@Override
	public void onEnable() {
		System.out.println("ToxicRain has been loaded!");
		saveDefaultConfig();
		config = getConfig();
		GetEffectFromConfig();
		
		//Checking if the world exists so there are no null exceptions.
		dworld = Bukkit.getWorld(config.getString("world-name"));
		
	    if (dworld == null) {
	        getLogger().severe("The world '" + config.getString("world-name") + "' does NOT exist! Disabling plugin.");
	        getServer().getPluginManager().disablePlugin(this);
	        return;
	    }
		
		isRaining = Bukkit.getWorld(config.getString("world-name")).hasStorm();
		getServer().getPluginManager().registerEvents(new ZombieSpawnEvent(), this);
		getServer().getPluginManager().registerEvents(new WeatherChangeListener(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("ToxicRain has been unloaded!");
	}
	
	public void GetEffectFromConfig() {
		String effectName;
		int duration;
		int amplifier;
		String configEffectLine = config.getString("zombie-effect");
		String[] parts = configEffectLine.split(" ");
        if (parts.length != 3) {
            getLogger().warning("Invalid zombie-effect format! Use: EFFECT DURATION AMPLIFIER");
            return;
        }
        
        effectName = parts[0].toUpperCase();
        PotionEffectType pottype = PotionEffectType.getByName(effectName);
        
        try {
            duration = Integer.parseInt(parts[1]);
            amplifier = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            getLogger().warning("Invalid numbers in zombie-effect config!");
            return;
        }
        poteffect = new PotionEffect(pottype, duration, amplifier);
		
	}
	
}
