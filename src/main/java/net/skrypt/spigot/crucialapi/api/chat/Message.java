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

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class Message {

	private ArrayList<MessageLine> lines;
	private ArrayList<Player> players;
	private MessageType type;

    /*public Message(ArrayList<MessageLine> lines, ArrayList<Player> players, MessageType type) {
        this.lines = lines;
        this.players = players;
        this.type = type;
    }*/

	public Message addLine(MessageLine... lines) {
		if (this.lines == null)
			this.lines = new ArrayList<>();

		this.lines.addAll(Arrays.asList(lines));

		return this;
	}

	public Message addBlankLine() {
		if (this.lines == null)
			this.lines = new ArrayList<>();

		this.lines.add(new MessageLine());
		return this;
	}

	public Message removeLine(int line) {
		if (lines != null && !lines.isEmpty())
			lines.remove(line);

		return this;
	}

	public Message addPlayer(Player player) {
		if (players == null)
			players = new ArrayList<>();

		players.add(player);

		return this;
	}

	public Message removePlayer(Player player) {
		if (players != null && !players.isEmpty())
			players.remove(player);

		return this;
	}

	public Message setType(MessageType type) {
		this.type = type;

		return this;
	}

	public void send() {
		if (this.type == MessageType.PLAYER)
			for (Player player : players)
				for (MessageLine line : lines)
					player.sendMessage(line.getString());

		if (this.type == MessageType.SERVER)
			for (Player player : Bukkit.getServer().getOnlinePlayers())
				for (MessageLine line : lines)
					if (!players.contains(player))
						player.sendMessage(line.getString());

		if (this.type == MessageType.CONSOLE || this.type == MessageType.DEBUG)
			for (MessageLine line : lines)
				Bukkit.getServer().getConsoleSender().sendMessage(line.getString());
	}
}
