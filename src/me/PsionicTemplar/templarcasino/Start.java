package me.PsionicTemplar.templarcasino;

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

	private void loadEvents() {
		//List of all the events that need loaded
//		getServer().getPluginManager().registerEvents((Listener) CLASS, this);
	}

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

}
