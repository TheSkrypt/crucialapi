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

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public enum Column {
	ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8);

	private int index;

	Column(int index) {
		this.index = index;
	}

	/**
	 * Returns the index of the column.
	 *
	 * @return Index(0 - 8) of the column.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * Returns the first column.
	 *
	 * @return The first column (Column.ONE).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Column first() {
		return Column.ONE;
	}

	/**
	 * Returns the middle column.
	 *
	 * @return The middle column (Column.FIVE).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Column middle() {
		return Column.FIVE;
	}

	/**
	 * Returns the last column.
	 *
	 * @return The last column (Column.NINE).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Column last() {
		return Column.NINE;
	}
}
