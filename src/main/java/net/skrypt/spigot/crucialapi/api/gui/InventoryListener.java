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

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

/**
 * An event that listens to inventory related events for the GUIs created with the API.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class InventoryListener implements Listener {

	/**
	 * Fired each time the user clicks while an inventory is opened (Can also be outside of the GUI.).
	 *
	 * @param event
	 * 		Bukkit's InventoryClickEvent
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player))
			return;

		if (!GUI.players.containsKey(event.getWhoClicked().getUniqueId()))
			return;

		GUI gui = GUI.players.get(event.getWhoClicked().getUniqueId());
		ClickAction action = new ClickAction(event);
		if (event.getSlot() < Row.values().length * 9)
			gui.onClick(action);
		else
			gui.getToolbar().onClick(action);
	}

	/**
	 * Fired each time the user closes an inventory.
	 *
	 * @param event
	 * 		Bukkit's InventoryCloseEvent
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if (!(event.getPlayer() instanceof Player))
			return;

		if (!GUI.players.containsKey(event.getPlayer().getUniqueId()))
			return;

		GUI gui = GUI.players.get(event.getPlayer().getUniqueId());
		gui.onClose(event);

		GUI.players.remove(event.getPlayer().getUniqueId());
	}

}
