/*
 * MIT License
 *
 * Copyright (c) 2018 Lukas Frey. All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.skrypt.spigot.crucialapi.api.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A collection of GUI related methods.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public abstract class GUI implements IGUI {

	/** A collection of UUID<->GUI key-pairs of players with an open GUI. */
	protected static HashMap<UUID, GUI> players = new HashMap<>();

	/** Stores a reference to the JavaPlugin instance this GUI was made by. */
	private JavaPlugin plugin;
	/** Stores the size (number of rows) of the inventory. Allowed values are 1-6. */
	private int size;

	/** Stores a reference to the Bukkit's Inventory instance. */
	private Inventory inventory;

	/** Stores a reference to the content class. */
	private Content content;

	/**
	 * Instantiates and sets up the GUI.
	 *
	 * @param plugin A reference to the JavaPlugin this GUI belongs to.
	 * @param size The size (number of rows) the GUI should have.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	protected GUI(JavaPlugin plugin, int size) {
		this.plugin = plugin;
		this.size = size;

		this.inventory = Bukkit.createInventory(null, this.size * 9);
		this.content = new Content(this.size);
	}

	/**
	 * Opens the GUI to the specified player.
	 *
	 * @param player
	 * 		Reference to a Bukkit Player.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void open(Player player) {
		player.openInventory(inventory);

		players.put(player.getUniqueId(), this);

		ViewHistory.add(player.getUniqueId(), this);

		this.setContent(this.content);

		for (Map.Entry<Slot, ItemStack> entry : this.content.content.entrySet()) {
			int index = (entry.getKey().row.getIndex() * 9) + entry.getKey().column.getIndex();

			this.inventory.setItem(index, entry.getValue());
		}

		this.onOpen();
	}

}
