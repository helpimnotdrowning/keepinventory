package org.crysis.keepitems;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class InventoryHandler {
	private static InventoryHandler instance = new InventoryHandler();
	private HashMap<Player, ItemStack[]> inventories;
	private HashMap<Player, ItemStack[]> armors;

	private InventoryHandler() {
		inventories = new HashMap<Player, ItemStack[]>();
		armors = new HashMap<Player, ItemStack[]>();
	}

	void saveInventoryAndArmor(Player _player) {
		ItemStack[] tmpinv = new ItemStack[_player.getInventory().getSize()];
		ItemStack[] tmpArmor = new ItemStack[_player.getInventory().getArmorContents().length];
		tmpArmor = _player.getInventory().getArmorContents();
		tmpinv = _player.getInventory().getContents();
		inventories.put(_player, tmpinv);
		armors.put(_player, tmpArmor);
	}

	ItemStack[] loadInventory(Player _player) {
		return inventories.get(_player);
	}

	ItemStack[] loadArmor(Player _player) {
		return armors.get(_player);
	}

	void removeInventoryAndArmor(Player _player) {
		inventories.remove(_player);
		armors.remove(_player);
	}

	boolean hasInventorySaved(Player _player) {
		return inventories.containsKey(_player);
	}

	boolean hasArmorSaved(Player _player) {
		return armors.containsKey(_player);
	}

	static InventoryHandler getInstance() {
		return instance;
	}
}