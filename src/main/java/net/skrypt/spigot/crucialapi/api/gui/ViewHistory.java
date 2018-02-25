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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

// TODO: Remove history of players who quit from the server to save resources.
// TODO: Or remove it 5 or more minutes after the player has quit. (So rejoining within 5 minutes still keeps the history.).

/**
 * Handles all View History related things. Stores the history of all players.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class ViewHistory {

	protected static HashMap<UUID, ViewHistory> all = new HashMap<>();

	private ArrayList<GUI> history;

	private UUID uuid;

	private ViewHistory(UUID uuid) {
		this.uuid = uuid;
		history = new ArrayList<>();
	}

	/**
	 * Adds the given GUI into the history of the specified player.
	 *
	 * @param uuid
	 * 		The UUID of the player.
	 * @param gui
	 * 		The GUI to store in history.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	protected static void add(UUID uuid, GUI gui) {
		if (!all.containsKey(uuid))
			all.put(uuid, new ViewHistory(uuid));

		ViewHistory vh = all.get(uuid);

		vh.history.add(gui);
	}

	/**
	 * Returns the GUI one step in history.
	 *
	 * @param uuid
	 * 		The UUID of the player of whom to check the history.
	 *
	 * @return The GUI from the history.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static GUI get(UUID uuid) {
		return get(uuid, 1);
	}

	/**
	 * Returns the GUI [step] step/s in history.
	 *
	 * @param uuid
	 * 		The UUID of the player of whom to check the history.
	 * @param step
	 * 		The amount of steps to go in the history. Default and minimum value is 1.
	 *
	 * @return The GUI from the history.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static GUI get(UUID uuid, int step) {
		if (!all.containsKey(uuid))
			all.put(uuid, new ViewHistory(uuid));

		ViewHistory vh = all.get(uuid);

		if (step < 1)
			step = 1;

		return vh.history.get(vh.history.size() - step);
	}

}
