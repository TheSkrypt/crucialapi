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

import java.util.Objects;

/**
 * A simple class representing a Slot in the GUI.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class Slot {
	/** The row where the slot is located. */
	protected Row row;
	/** The column where the slot is located. */
	protected Column column;

	/**
	 * Creates a slot located at the specified row and column.
	 *
	 * @param row
	 * 		The row where the slot should be located.
	 * @param column
	 * 		The column where the slot should be located.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public Slot(Row row, Column column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * Overrides the equals method to compare the values inside the classes rather than the classes themselves. Required
	 * to compare 2 different instances of the class with exact same value (e.g. 2 different Slot instances with both
	 * having set Row.ONE and Slot.ONE.
	 *
	 * @param obj
	 * 		The other object to compare equality with..
	 *
	 * @return True/false whether the objects are equal or not.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (!(obj instanceof Slot)) {
			return false;
		}
		Slot other = (Slot) obj;
		return Objects.equals(row, other.row) && Objects.equals(column, other.column);
	}

	/**
	 * Uses JDK7's Objects class to create a hash based off of the values in this class. This is required in order for
	 * equality checks within HashMaps, Arrays and similar to work.
	 *
	 * @return hash code based off of the values in the class.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	@Override
	public int hashCode() {
		return Objects.hash(row, column);
	}
}