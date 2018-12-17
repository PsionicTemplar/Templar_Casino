package me.PsionicTemplar.templarcasino;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin {

	private static Start plugin;

	/**
	 * Return Static instance of class
	 * 
	 * @author Nicholas Braniff
	 * @return
	 */
	
	public static Plugin getPlugin() {
		JavaPlugin plugin = Start.plugin;
		return plugin;
	}
	
	/**
	 * Return Static instance of class
	 * 
	 * @author Nicholas Braniff
	 * @return Start class instance
	 */
	
	public static Start getStart() {
		return plugin;
	}
	
	/**
	 * Run on enable
	 * 
	 * @author Nicholas Braniff
	 */

	public void onEnable() {
		plugin = this;

		try {
			//Load commands
			this.getCommand("test").setExecutor(new CommandExtender());

			//Load the events
			loadEvents();
			loadDefaults();
		} catch (Exception ex) {
			//Crash handler
			System.out.println("[Templar Casino] There was an error with the startup. Please report this:");
			System.out.println("[Templar Casino] --------------------------------------------------------");
			ex.printStackTrace();
			System.out.println("[Templar Casino] --------------------------------------------------------");
			this.setEnabled(false);
		}

		plugin = this;
	}
	
	/**
	 * Load all events
	 * 
	 * @author Nicholas Braniff
	 */

	private void loadEvents() {
		//List of all the events that need loaded
//		getServer().getPluginManager().registerEvents((Listener) CLASS, this);
	}
	
	/**
	 * Run on disable
	 * 
	 * @author Nicholas Braniff
	 */

	public void onDisable() {

		try {
			//Stuff attempted on shutdown

		} catch (Exception ex) {
			//Crash handler
			System.out.println("[Templar Casino] There was an error with the shutdown. Please report this:");
			System.out.println("[Templar Casino] --------------------------------------------------------");
			ex.printStackTrace();
			System.out.println("[Templar Casino] --------------------------------------------------------");
		}
	}
	/**
	 * Load the default settings for the FileConfiguration
	 * 
	 * @author Nicholas Braniff
	 */
	
	private static void loadDefaults() {
		FileConfiguration config = getPlugin().getConfig();
		config.addDefault("Command.Allow_Single_Poker", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Multiple_Poker", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Roulette", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Craps", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Keno", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Slots", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Allow_Scratch", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Allow_Lotto", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Scratch_Price", (float) 10.0);
		config.addDefault("Command.Purchase.Lotto_Price", (float) 5.0);
		config.addDefault("Command.Purchase.Admin.Allow_Scratch", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Lotto", Boolean.valueOf(true));
	}

}
