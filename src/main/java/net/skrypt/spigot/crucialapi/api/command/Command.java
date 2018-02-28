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

package net.skrypt.spigot.crucialapi.api.command;

import net.skrypt.spigot.crucialapi.CrucialAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public abstract class Command extends org.bukkit.command.Command {
	protected Command(String name) {
		super(name);
	}

	public static void register(Command... commands) {
		try {
			Class<?> craftServer = CrucialAPI.getCraftbukkitClass("CraftServer");
			final Field f = craftServer.getDeclaredField("commandMap");
			f.setAccessible(true);
			CommandMap cm = (CommandMap) f.get(Bukkit.getServer());
			for (Command command : commands) {
				cm.register("", command);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
