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
	/** Stores the name of the GUI (displayed at the top of the GUI.). */
	private String name;
	/** Stores the size (number of rows) of the inventory. Allowed values are 1-5. */
	private Row size;
	/** Stores the current page of the GUI. */
	private Page page;

	/** Stores a reference to the toolbar class. */
	private Toolbar toolbar;

	/** Stores a reference to the Bukkit's Inventory instance. */
	private Inventory inventory;

	/** Stores a reference to the content class. */
	private Content content;
	private ToolbarContent toolbarContent;

	/**
	 * Instantiates and sets up the GUI.
	 *
	 * @param plugin A reference to the JavaPlugin this GUI belongs to.
	 * @param size The size (number of rows) the GUI should have.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public GUI(JavaPlugin plugin, String name, Row size) {
		init(plugin, name, size, new DefaultToolbar(this));
	}

	public GUI(JavaPlugin plugin, String name, Row size, Toolbar toolbar) {
		init(plugin, name, size, toolbar);
	}

	private void init(JavaPlugin plugin, String name, Row size, Toolbar toolbar) {
		this.plugin = plugin;
		this.name = name;
		this.size = size;
		this.page = Page.get(1);

		this.toolbar = toolbar;

		this.inventory = Bukkit.createInventory(null, 9 + (this.size.getIndex() + 1) * 9, this.name);
		this.content = new Content(this.size);
		this.toolbarContent = new ToolbarContent();
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

		this.clear();
		this.redraw();

		this.onOpen();
	}

	public void clear() {
		inventory.clear();
	}

	public void redraw() {
		this.setContent(this.content);
		this.toolbar.setContent(this.toolbarContent);

		/*System.out.println("This.page: " + this.page.page);
		System.out.println(this.content.content);
		for (Map.Entry<Page, HashMap<Slot, ItemStack>> entry : this.content.content.entrySet()) {
			if (!this.page.equals(entry.getKey()))
				continue;

			for (Map.Entry<Slot, ItemStack> e : entry.getValue().entrySet()) {

				int index = (e.getKey().row.getIndex() * 9) + e.getKey().column.getIndex();

				System.out.println("Setting Item");
				this.inventory.setItem(index, e.getValue());
			}
			break;
		}*/
		for (Map.Entry<Slot, ItemStack> entry : this.content.content.getOrDefault(this.page, new HashMap<>())
		                                                            .entrySet()) {
			int index = (entry.getKey().row.getIndex() * 9) + entry.getKey().column.getIndex();

			System.out.println("Setting Item");
			this.inventory.setItem(index, entry.getValue());
		}

		for (Map.Entry<Column, ItemStack> entry : this.toolbarContent.content.entrySet()) {
			int index = 9 + this.size.getIndex() * 9 + entry.getKey().getIndex();

			this.inventory.setItem(index, entry.getValue());
		}
	}

	protected Toolbar getToolbar() {
		return this.toolbar;
	}

	public boolean is(Inventory inventory) {
		return inventory.equals(this.inventory);
	}

	public Page getMaxPage() {
		return Page.get(content.content.size());
	}

	public void nextPage() {
		this.page(Page.get(this.page.page + 1));
	}

	public void previousPage() {
		this.page(Page.get(this.page.page - 1));
	}

	public void page(Page page) {
		this.page = page;
		if (this.page.page > getMaxPage().page)
			this.page = getMaxPage();
		this.clear();
		this.redraw();
	}

	public Page getLastPage() {
		return getMaxPage();
	}
}
