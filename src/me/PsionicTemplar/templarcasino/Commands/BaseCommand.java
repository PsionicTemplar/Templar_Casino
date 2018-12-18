package me.PsionicTemplar.templarcasino.Commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import me.PsionicTemplar.templarcasino.ConfigObject;
import me.PsionicTemplar.templarcasino.Util.GambleType;

public abstract class BaseCommand implements Listener{
	
	protected HashMap<UUID, GambleType> inGui = new HashMap<UUID, GambleType>();
	protected int inventorySize;
	protected String name;
	protected ConfigObject co;
	protected int id;
	
	/**
	 * Constructor for BaseCommand. It takes in the name of a command and the inventory size you'd like
	 * for that command.
	 * 
	 * Put 0 for unclickable.
	 * @param name
	 * @param inventorySize
	 * @author Nicholas Braniff
	 */

	public BaseCommand(String name, int inventorySize){
		this.name = name;
		this.inventorySize = inventorySize;
//		HashMap<String, Object> defaults = new HashMap<String, Object>();
//		defaults.put("id", 0);
//		defaults.put("open", new ArrayList<Integer>());
//		String path = Start.getPlugin().getDataFolder() + "/Command_Data";
//		String finalName = name + ".yml";
//		this.co = new ConfigObject(path, finalName, defaults);
	}
	
//	/**
//	 * Easy to use method for the blocks to increase the latest id by one and then write that to the fileconfiguration
//	 * 
//	 * @author Nicholas Braniff
//	 */
//
//	protected void increaseId() {
//		this.id = this.id + 1;
//		FileConfiguration config = co.getConfig();
//		config.set("id", this.id);
//		co.setConfigWrite(config);
//	}
//	
//	/**
//	 * Removing an Id from the list of open Id's
//	 * 
//	 * @author Nicholas Braniff
//	 */
//
//	protected void removeIdFromOpen() {
//		try {
//			this.openIdSlots.remove(0);
//			FileConfiguration config = co.getConfig();
//			config.set("open", this.openIdSlots);
//			co.setConfigWrite(config);
//		} catch (Exception ex) {
//			return;
//		}
//	}
//	
//	/**
//	 * Adding an Id to the list of reusable Id's
//	 * 
//	 * @author Nicholas Braniff
//	 * @param id
//	 */
//	
//	protected void addIdToOpen(int id){
//		this.openIdSlots.add(id);
//		FileConfiguration config = co.getConfig();
//		config.set("open", this.openIdSlots);
//		co.setConfigWrite(config);
//	}
	
	/**
	 * Event to remove the person from the gui hashmap once the inventory is closed. 
	 * 
	 * @author Nicholas Braniff
	 * @param e
	 */

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if (!inGui.containsKey(e.getPlayer().getUniqueId())) {
			return;
		}
		closeInventory(e, Bukkit.getPlayer(e.getPlayer().getUniqueId()));
		inGui.remove(e.getPlayer().getUniqueId());
	}
	
	/**
	 * Abstract method called when inventory is closed so extended classes can manipulate it.
	 * 
	 * @author Nicholas Braniff
	 * @param e
	 * @param player
	 */

	protected abstract void closeInventory(InventoryCloseEvent e, Player player);
	
	/**
	 * Abstract method used so the extended classes can design the openable gui
	 * 
	 * @author Nicholas Braniff
	 * @param location
	 * @param player
	 */

	protected abstract void openGui(Location location, Player player);
	
	/**
	 * Inventory click event used to call the abstract method for inventory clicks.
	 * 
	 * @author Nicholas Braniff
	 * @param e
	 */
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		//Check if person is in gui
		if(!this.inGui.containsKey(e.getWhoClicked().getUniqueId())){
			return;
		}
		//Make sure the person is clicking inside of the inventory
		if(e.getClickedInventory() == null){
			return;
		}
		//Call the abstract method
		inventoryClick(e, Bukkit.getPlayer(e.getWhoClicked().getUniqueId()));
	}
	
	/**
	 * Abstract method used to let extended classes choose what happens when something is clicked in an inventory
	 * 
	 * @author Nicholas Braniff
	 * @param e
	 * @param player
	 */
	
	protected abstract void inventoryClick(InventoryClickEvent e, Player player);
}
