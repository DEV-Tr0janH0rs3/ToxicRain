package customevents;

import org.bukkit.Bukkit;

public class ChangeHologramText {
	
	public void ChangeText(boolean raining) {
		if(raining) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline weather 2 &c&l⚠&a&lТОКСИЧНО&c&l⚠");
		} else {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline weather 2 &b&lНОРМАЛНО");
		}
	}

}
