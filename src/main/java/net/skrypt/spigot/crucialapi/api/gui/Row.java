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
 * Represents a row in the GUI.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public enum Row {
	ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4);

	private int index;

	Row(int index) {
		this.index = index;
	}

	/**
	 * Returns the index of the row.
	 *
	 * @return Index(0 - 4) of the row.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * Returns the first row.
	 *
	 * @return The first row (Row.ONE).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Row first() {
		return Row.ONE;
	}

	/**
	 * Returns the last row.
	 *
	 * @return The last row (Row.SIX).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static Row last() {
		return Row.FIVE;
	}

	public static Row fromIndex(int index) {
		switch (index) {
			case 1:
				return Row.TWO;
			case 2:
				return Row.THREE;
			case 3:
				return Row.FOUR;
			case 4:
				return Row.FIVE;
			default:
				return Row.ONE;
		}
	}
}