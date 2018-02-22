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

import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Abstract GUI class containing many methods to use and modify Bukkit Inventories as well as built-in event listeners.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public abstract class GUI {

	/** Holds a reference to the plugin the GUI was created by. */
	private JavaPlugin plugin;
	/** Holds a reference to Bukkit's Inventory instance. */
	private Inventory inventory;

	/**
	 * Creates a new instance of this class.
	 *
	 * @param plugin
	 * 		A reference to plugin's main class this GUI should belong to.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	protected GUI(JavaPlugin plugin) {
		this.plugin = plugin;
	}


}