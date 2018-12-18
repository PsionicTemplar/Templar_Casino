package me.PsionicTemplar.templarcasino.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SinglePoker extends BaseCommand {

	private static int info = 4;
	private static int money = 1;
	private static int currentBet = 7;
	private static int decreaseBet = 46;
	private static int lowCard = 48;
	private static int highCard = 50;
	private static int dealDouble = 49;
	private static int addBet = 52;
	private static List<Integer> cardSlots = Arrays.asList(18, 20, 22, 24, 26);
	private static List<Integer> cardSelect = Arrays.asList(27, 29, 31, 33, 35);

	public SinglePoker() {
		super("Single Poker", 54);
	}

	@Override
	protected void closeInventory(InventoryCloseEvent e, Player player) {
	}

	@Override
	protected void openGui(Player player) {
		Inventory i = Bukkit.createInventory(null, this.inventorySize, this.name);

		ItemMeta im = null;

		ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		im = none.getItemMeta();
		im.setDisplayName("");
		none.setItemMeta(im);

		for (int slot = 0; slot < 54; slot++) {
			if (cardSlots.contains(slot) || cardSelect.contains(slot) || slot == addBet || slot == dealDouble
					|| slot == highCard || slot == lowCard || slot == decreaseBet || slot == currentBet || slot == money
					|| slot == info) {
				continue;
			}
			i.setItem(slot, none);
		}
		//TODO more work to create the GUI
		
		player.openInventory(i);
	}

	@Override
	protected void inventoryClick(InventoryClickEvent e, Player player) {
	}

}
