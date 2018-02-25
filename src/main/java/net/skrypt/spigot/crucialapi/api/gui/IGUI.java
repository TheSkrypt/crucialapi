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
 * A collection of GUI related methods.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public interface IGUI {

	/**
	 * Called each time the user opens a GUI.
	 *
	 * @param content
	 * 		Current content of the GUI.
	 *
	 * @author Lukas Frey
	 * @since 1:0
	 */
	void setContent(Content content);

	/**
	 * Called each time the user opens a GUI.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	void onOpen();

	/**
	 * Called each time the user clicks while the GUI is opened (Can also be outside of the GUI.).
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	void onClick();

	/**
	 * Called each time the user closes a GUI.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	void onClose();

}
