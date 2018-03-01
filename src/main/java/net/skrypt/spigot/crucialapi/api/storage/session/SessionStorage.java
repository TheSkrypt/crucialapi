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

package net.skrypt.spigot.crucialapi.api.storage.session;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Handles the storage of primitive and other data types during the current session (server life time).
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class SessionStorage {

	private static HashMap<JavaPlugin, Storage> pluginStorage = new HashMap<>();
	private static HashMap<Player, Storage> playerStorage = new HashMap<>();

	/**
	 * Returns the plugin's session storage.
	 *
	 * @param plugin
	 * 		The plugin you want to access the storage of.
	 *
	 * @return The session storage of the plugin.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Storage get(JavaPlugin plugin) {
		return pluginStorage.getOrDefault(plugin, new Storage());
	}

	/**
	 * Returns the player's session storage.
	 *
	 * @param player
	 * 		The player you want to access the storage of.
	 *
	 * @return The session storage of the player.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Storage get(Player player) {
		return playerStorage.getOrDefault(player, new Storage());
	}

}
