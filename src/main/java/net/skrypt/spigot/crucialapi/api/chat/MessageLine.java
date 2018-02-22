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

package net.skrypt.spigot.crucialapi.api.chat;

import org.bukkit.ChatColor;

import java.util.ArrayList;

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class MessageLine {

	private StringBuilder sb;
	private ChatColor color;
	private ArrayList<ChatColor> formatting;

	public MessageLine addText(String text) {
		if (this.sb == null)
			this.sb = new StringBuilder();

		this.sb.append(text);

		return this;
	}

	public MessageLine addFormatting(ChatColor formatting) {
		if (this.sb == null)
			this.sb = new StringBuilder();

		if (this.formatting == null)
			this.formatting = new ArrayList<>();

		if (formatting.isColor())
			this.color = formatting;

		if (formatting.isFormat())
			if (!this.formatting.contains(formatting))
				this.formatting.add(formatting);
			else
				return this;

		this.sb.append(ChatColor.COLOR_CHAR).append(formatting.getChar());

		return this;
	}

	public MessageLine resetColors() {
		if (this.sb == null)
			this.sb = new StringBuilder();

		this.color = null;
		this.sb.append(ChatColor.RESET);

		if (this.formatting != null)
			for (ChatColor cc : this.formatting)
				this.sb.append(cc);

		return this;
	}

	public MessageLine resetFormatting() {
		if (this.sb == null)
			this.sb = new StringBuilder();

		if (this.formatting == null)
			this.formatting = new ArrayList<>();

		this.formatting.clear();
		this.sb.append(ChatColor.RESET);

		if (this.color != null)
			this.sb.append(this.color);

		return this;
	}

	public MessageLine resetAll() {
		if (this.sb == null)
			this.sb = new StringBuilder();

		if (this.formatting == null)
			this.formatting = new ArrayList<>();

		this.color = null;
		this.formatting.clear();
		this.sb.append(ChatColor.RESET);

		return this;
	}

	protected String getString() {
		if (this.sb == null)
			this.sb = new StringBuilder();
		return ChatColor.translateAlternateColorCodes('&', this.sb.toString());
	}
}
