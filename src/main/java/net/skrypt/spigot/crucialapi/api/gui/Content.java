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

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * A class responsible for the content of the GUI.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class Content {

	protected HashMap<Slot, ItemStack> content;

	/** Stores the size (number of rows) of the inventory. */
	private int size;

	/**
	 * Instantiates and sets up the content class.
	 *
	 * @param size
	 * 		The size of the inventory (number of rows). Allowed values are 1-6.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	Content(int size) {
		this.size = size;
		this.content = new HashMap<>();
	}


	/**
	 * Sets every slot in the inventory to the specified item.
	 *
	 * @param item
	 * 		The Bukkit ItemStack you want to set.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void set(ItemStack item) {
		for (Row row : Row.values()) {
			set(item, row);
		}
	}

	/**
	 * Sets every slot in the given row/s to the specified item.
	 *
	 * @param item
	 * 		The Bukkit ItemStack you want to set.
	 * @param row
	 * 		The row you want to set the item to.
	 * @param rows
	 * 		Additional row/s you want to set the item to.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void set(ItemStack item, Row row, Row... rows) {
		for (Column column : Column.values())
			set(item, row, column);
		for (Row r : rows)
			for (Column column : Column.values())
				set(item, r, column);
	}

	/**
	 * Sets the slot in the given column/s to the specified item.
	 *
	 * @param item
	 * 		The Bukkit ItemStack you want to set.
	 * @param column
	 * 		The column you want to set the item to.
	 * @param columns
	 * 		Additional column/s you want to set the item to.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void set(ItemStack item, Column column, Column... columns) {
		for (Row row : Row.values())
			set(item, row, column, columns);
	}

	/**
	 * Sets the slot in the given row and column/s to the specified item.
	 *
	 * @param item
	 * 		The Bukkit ItemStack you want to set.
	 * @param row
	 * 		The row you want to set the item to.
	 * @param column
	 * 		The column you want to set the item to.
	 * @param columns
	 * 		Additional column/s you want to set the item to.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void set(ItemStack item, Row row, Column column, Column... columns) {
		content.put(new Slot(row, column), item);
		for (Column col : columns)
			content.put(new Slot(row, col), item);
	}

	/**
	 * Checks whether a slot at the specified row and column is set (Has an assigned item in it.).
	 *
	 * @param row
	 * 		The row to check.
	 * @param column
	 * 		The column to check.
	 *
	 * @return Whether the slot contains an item (true) or not (false).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public boolean contains(Row row, Column column) {
		return contains(new Slot(row, column));
	}

	/**
	 * Checks whether the slot is set (Has an assigned item in it.).
	 *
	 * @param slot
	 * 		The slot to check.
	 *
	 * @return Whether the slot contains an item (true)vvv or not (false).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public boolean contains(Slot slot) {
		return content.containsKey(slot);
	}

	/**
	 * Returns the ItemStack from the slot at the specified row and column. May return null if the slot isn't set.
	 *
	 * @param row
	 * 		The row to check.
	 * @param column
	 * 		The column to check.
	 *
	 * @return The ItemStack in the slot.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public ItemStack get(Row row, Column column) {
		return get(new Slot(row, column));
	}

	/**
	 * Returns the ItemStack from the specified slot. May return null if the slot isn't set.
	 *
	 * @param slot
	 * 		The slot to check.
	 *
	 * @return The ItemStack in the slot.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public ItemStack get(Slot slot) {
		if (contains(slot))
			return content.get(slot);

		// TODO: Throw an exception or add some other handling method
		return null;
	}
}