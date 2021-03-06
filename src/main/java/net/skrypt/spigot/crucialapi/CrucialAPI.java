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

package net.skrypt.spigot.crucialapi;

import net.skrypt.spigot.crucialapi.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is the main class of the Crucial API. It is only used to activate and set up the API.
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class CrucialAPI extends JavaPlugin {

	/**
	 * Called once when the plugin is enabled.
	 *
	 * @author Lukas Frey
	 * @see CrucialAPI
	 * @since 1.0
	 */
	@Override
	public void onEnable() {
		Message message = new Message();
		message.addLine(new MessageLine().addFormatting(ChatColor.BLUE).addText("Crucial API was enabled."))
		       .addLine(new MessageLine().addFormatting(ChatColor.BLUE)
		                                 .addText(
				                                 "If you are a developer, visit www.lukasfrey.net/spigot/crucialapi to learn more about the API."))
		       .addLine(new MessageLine().addFormatting(ChatColor.BLUE)
		                                 .addText(
				                                 "If not, you most likely installed the API as a dependency for another plugin. To avoid any trouble, it is best to keep the API installed. However, if you are absolutely sure you do not need it, you can safely remove it. The API alone is of no use."));
		message.setType(MessageType.CONSOLE).send();
	}

	/**
	 * Called once when the plugin is disabled.
	 *
	 * @author Lukas Frey
	 * @see CrucialAPI
	 * @since 1.0
	 */
	@Override
	public void onDisable() {
		Message message = new Message();
		message.addLine(new MessageLine().addFormatting(ChatColor.BLUE).addText("Crucial API was disabled."));
		message.setType(MessageType.CONSOLE).send();
	}

}