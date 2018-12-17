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
		config.addDefault("Command.Allow_Black_Jack", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Roulette", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Craps", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Keno", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Slots", Boolean.valueOf(true));
		config.addDefault("Command.Allow_Bingo", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Allow_Scratch", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Allow_Lotto", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Scratch", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Lotto", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Single_Poker", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Multiple_Poker", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Black_Jack", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Roulette", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Craps", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Keno", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Slots", Boolean.valueOf(true));
		config.addDefault("Command.Purchase.Admin.Allow_Bingo", Boolean.valueOf(true));
		config.addDefault("Min_Bet.Scratch_Price", (float) 10.0); //Per scratch off
		config.addDefault("Min_Bet.Lotto_Price", (float) 5.0); //Per ticket
		config.addDefault("Min_Bet.Single_Poker", (float) 0.25); //Per round
		config.addDefault("Min_Bet.Multiple_Poker", (float) 3.0); //For first call
		config.addDefault("Min_Bet.Black_Jack", (float) 1.0); //Per round
		config.addDefault("Min_Bet.Roulette", (float) 3.0); //At least this much on the board
		//TODO Look these next 2 up and make sure it's accurate
		config.addDefault("Min_Bet.Craps", (float) 1.0); //Per ?
		config.addDefault("Min_Bet.Keno", (float) 1.0);  //Per ?
		//TODO Maybe make more than one type of slots?
		config.addDefault("Min_Bet.Slots", (float) 0.1); //Per Line
		config.addDefault("Min_Bet.Bingo", (float) 5.0); //Per Card
		config.addDefault("Block.Allow_Single_Poker", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Multiple_Poker", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Black_Jack", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Roulette", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Craps", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Keno", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Slots", Boolean.valueOf(true));
		config.addDefault("Block.Allow_Bingo", Boolean.valueOf(true));
		config.addDefault("Block.Purchase.Allow_Scratch", Boolean.valueOf(true));
		config.addDefault("Block.Purchase.Allow_Lotto", Boolean.valueOf(true));
	}

}
