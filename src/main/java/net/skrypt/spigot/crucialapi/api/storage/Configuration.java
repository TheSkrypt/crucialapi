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

package net.skrypt.spigot.crucialapi.api.storage;

import net.skrypt.spigot.crucialapi.api.chat.Message;
import net.skrypt.spigot.crucialapi.api.chat.MessageLine;
import net.skrypt.spigot.crucialapi.api.chat.MessageType;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * [Short Description Here]
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public abstract class Configuration implements IConfiguration {

	protected JavaPlugin plugin;
	protected String id;
	protected File file;

	protected Configuration(JavaPlugin plugin, String id, File file) {
		this.plugin = plugin;
		this.id = id;
		this.file = file;
	}


	/**
	 * Registers the plugin to the Storage API.
	 *
	 * @param plugin
	 * 		The plugin you want to register.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static void register(JavaPlugin plugin) {
		register(plugin, "files");
	}

	/**
	 * Registers the plugin to the Storage API.
	 *
	 * @param plugin
	 * 		The plugin you want to register.
	 * @param fileName
	 * 		The name of the file containing your file structure configuration. By default 'files' is used.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static void register(JavaPlugin plugin, String fileName) {
		register(plugin, fileName, StorageType.JSON);
	}

	/**
	 * Registers the plugin to the Storage API.
	 *
	 * @param plugin
	 * 		The plugin you want to register.
	 * @param fileName
	 * 		The name of the file containing your file structure configuration. By default 'files' is used.
	 * @param storageType
	 * 		The storage type of the file. By default 'JSON' is used.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static void register(JavaPlugin plugin, String fileName, StorageType storageType) {
		if (storageType == StorageType.TEXT) {
			new Message().setType(MessageType.CONSOLE)
			             .addLine(new MessageLine().addText("Unsupported storage type ('" + storageType.name() + "') selected for the file structure configuration file. Stopping the plugin..."))
			             .send();
			plugin.getPluginLoader().disablePlugin(plugin);
			return;
		}

		if (storageType == StorageType.JSON) {
			//try {
			JSONParser parser = new JSONParser();
			InputStreamReader reader;

			try {
				reader = new InputStreamReader(plugin.getResource(fileName + "." + storageType.getExtension()));
			} catch (NullPointerException e) {
				new Message().setType(MessageType.CONSOLE)
				             .addLine(new MessageLine().addFormatting(ChatColor.RED)
				                                       .addText("File structure configuration file ('" + fileName + "." + storageType
						                                       .getExtension() + "') not found. Stopping the plugin..."))
				             .send();
				plugin.getPluginLoader().disablePlugin(plugin);
				return;
			}

			JSONObject object = null;

			try {
				object = (JSONObject) parser.parse(reader);
			} catch (ParseException e) {
				new Message().setType(MessageType.CONSOLE)
				             .addLine(new MessageLine().addFormatting(ChatColor.RED)
				                                       .addText(
						                                       "File structure configuration file contains invalid syntax. Stopping the plugin..."))
				             .send();
				plugin.getPluginLoader().disablePlugin(plugin);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}

			JSONArray files = (JSONArray) object.get("files");

			if (files == null) {
				new Message().setType(MessageType.CONSOLE)
				             .addLine(new MessageLine().addFormatting(ChatColor.RED)
				                                       .addText(
						                                       "File structure configuration file is invalid. Stopping the plugin..."))
				             .send();
				plugin.getPluginLoader().disablePlugin(plugin);
				return;
			}

			Iterator<JSONObject> iterator = files.iterator();
			while (iterator.hasNext()) {
				JSONObject obj = iterator.next();
				StorageType type;
				String id;
				JSONObject origin;
				String originDir;
				String originFile;
				JSONObject target;
				String targetDir;
				String targetFile;
				try {
					type = StorageType.valueOf((String) obj.get("type"));
					id = (String) obj.get("id");
					origin = (JSONObject) obj.get("origin");
					originDir = (String) origin.get("directory");
					originFile = (String) origin.get("file");
					target = (JSONObject) obj.get("target");
					targetDir = (String) target.get("directory");
					targetFile = (String) target.get("file");
				} catch (NullPointerException e) {
					new Message().setType(MessageType.CONSOLE)
					             .addLine(new MessageLine().addFormatting(ChatColor.RED)
					                                       .addText(
							                                       "File structure configuration file is invalid. Stopping the plugin..."))
					             .send();
					plugin.getPluginLoader().disablePlugin(plugin);
					return;
				}

				if (!originDir.endsWith("/") && !originDir.isEmpty())
					originDir += "/";

				if (!targetDir.startsWith("/"))
					targetDir = "/" + targetDir;

				if (!targetDir.endsWith("/"))
					targetDir += "/";

				InputStream in = plugin.getResource(originDir + originFile + "." + type.getExtension());

				File directory = new File(plugin.getDataFolder() + targetDir);
				directory.mkdirs();
				File file = new File(plugin.getDataFolder() + targetDir + targetFile + "." + type.getExtension());

				copy(in, file);

				if (type == StorageType.TEXT) {

				}

				if (type == StorageType.JSON) {
					new JSON(plugin, id, file);
				}

				if (type == StorageType.YAML) {
					new YAML(plugin, id, file);
				}
			}
		}
	}

	private static void copy(InputStream in, File file) {
		try {

			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {

				out.write(buf, 0, len);

			}

			out.close();
			in.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
