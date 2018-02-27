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

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class DefaultToolbar extends Toolbar {

	public DefaultToolbar(GUI gui) {
		super(gui);
	}

	/**
	 * Called each time the user opens a GUI.
	 *
	 * @param content
	 * 		Current content of the GUI.
	 *
	 * @author Lukas Frey
	 * @since 1:0
	 */
	@Override
	public void setContent(ToolbarContent content) {
		ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
		ItemMeta meta = pane.getItemMeta();
		meta.setDisplayName(" ");
		pane.setItemMeta(meta);

		ItemStack previous = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
		ItemMeta previousMeta = pane.getItemMeta();
		previousMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Previous <");
		previous.setItemMeta(previousMeta);

		ItemStack close = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta closeMeta = pane.getItemMeta();
		closeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close");
		close.setItemMeta(closeMeta);

		ItemStack next = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
		ItemMeta nextMeta = pane.getItemMeta();
		nextMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "> Next");
		next.setItemMeta(nextMeta);

		content.add(pane);
		content.add(previous, Column.FOUR);
		content.add(close, Column.middle());
		content.add(next, Column.SIX);
	}

	@Override
	public void onClick(ClickAction click) {
		if (click.getInventoryType() != InventoryType.CHEST)
			return;

		click.cancel(true);

		if (click.getSlot().column == Column.FOUR)
			getGUI().previousPage();

		if (click.getSlot().column == Column.middle())
			click.getPlayer().closeInventory();

		if (click.getSlot().column == Column.SIX)
			getGUI().nextPage();
	}
}
