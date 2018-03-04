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

package net.skrypt.spigot.crucialapi.api.storage.session;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

/**
 * Handles the storage of primitive and other data types during the current session (server life time).
 *
 * @author Lukas Frey
 * @version 1.0
 * @since 1.0
 */
public class SessionStorage {

	private static HashMap<JavaPlugin, SessionStorage> pluginStorage = new HashMap<>();
	private static HashMap<Player, SessionStorage> playerStorage = new HashMap<>();

	public static void set(JavaPlugin plugin, SessionStorage storage) {
		pluginStorage.put(plugin, storage);
	}

	public static void set(Player player, SessionStorage storage) {
		playerStorage.put(player, storage);
	}

	private HashMap<String, Byte> bytes;
	private HashMap<String, Short> shorts;
	private HashMap<String, Integer> ints;
	private HashMap<String, Long> longs;
	private HashMap<String, Float> floats;
	private HashMap<String, Double> doubles;
	private HashMap<String, Boolean> booleans;
	private HashMap<String, Character> chars;
	private HashMap<String, String> strings;
	private HashMap<String, UUID> uuids;

	protected SessionStorage() {
		this.bytes = new HashMap<>();
		this.shorts = new HashMap<>();
		this.ints = new HashMap<>();
		this.longs = new HashMap<>();
		this.floats = new HashMap<>();
		this.doubles = new HashMap<>();
		this.booleans = new HashMap<>();
		this.chars = new HashMap<>();
		this.strings = new HashMap<>();
		this.uuids = new HashMap<>();
	}

	/**
	 * Stores a byte under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the byte.
	 * @param value
	 * 		The byte you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setByte(String key, byte value) {
		setByte(key, value, true);
	}

	/**
	 * Stores a byte under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the byte.
	 * @param value
	 * 		The byte you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setByte(String key, byte value, boolean override) {
		if (override)
			bytes.put(key, value);
		else if (!bytes.containsKey(key))
			bytes.put(key, value);
	}

	/**
	 * Returns the byte stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the byte is stored under.
	 *
	 * @return The byte stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public byte getByte(String key) {
		return bytes.getOrDefault(key, null);
	}

	/**
	 * Returns the byte stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the byte is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The byte stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public byte getByte(String key, byte defaultValue) {
		return bytes.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the short stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the short is stored under.
	 *
	 * @return The short stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public short getShort(String key) {
		return shorts.getOrDefault(key, null);
	}

	/**
	 * Returns the short stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the short is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The short stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public short getShort(String key, short defaultValue) {
		return shorts.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the integer stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the integer is stored under.
	 *
	 * @return The integer stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public int getInt(String key) {
		return ints.getOrDefault(key, null);
	}

	/**
	 * Returns the integer stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the integer is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The integer stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public int getInt(String key, int defaultValue) {
		return ints.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the long stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the long is stored under.
	 *
	 * @return The long stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public long getLong(String key) {
		return longs.getOrDefault(key, null);
	}

	/**
	 * Returns the long stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the long is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The long stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public long getLong(String key, long defaultValue) {
		return longs.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the float stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the float is stored under.
	 *
	 * @return The float stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public float getFloat(String key) {
		return floats.getOrDefault(key, null);
	}

	/**
	 * Returns the float stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the float is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The float stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public float getFloat(String key, float defaultValue) {
		return floats.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the double stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the double is stored under.
	 *
	 * @return The double stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public double getDouble(String key) {
		return doubles.getOrDefault(key, null);
	}

	/**
	 * Returns the double stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the double is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The double stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public double getDouble(String key, double defaultValue) {
		return doubles.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the boolean stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the boolean is stored under.
	 *
	 * @return The boolean stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public boolean getBoolean(String key) {
		return booleans.getOrDefault(key, null);
	}

	/**
	 * Returns the boolean stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the boolean is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The boolean stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public boolean getBoolean(String key, boolean defaultValue) {
		return booleans.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the character stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the character is stored under.
	 *
	 * @return The character stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public char getChar(String key) {
		return chars.getOrDefault(key, null);
	}

	/**
	 * Returns the character stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the character is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The character stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public char getChar(String key, char defaultValue) {
		return chars.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the string stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the string is stored under.
	 *
	 * @return The string stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public String getString(String key) {
		return strings.getOrDefault(key, null);
	}

	/**
	 * Returns the string stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the string is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The string stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public String getString(String key, String defaultValue) {
		return strings.getOrDefault(key, defaultValue);
	}

	/**
	 * Returns the UUID stored under the specified key. If not found, returns null.
	 *
	 * @param key
	 * 		The key the UUID is stored under.
	 *
	 * @return The UUID stored under the specified key or null if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public UUID getUUID(String key) {
		return uuids.getOrDefault(key, null);
	}

	/**
	 * Returns the UUID stored under the specified key. If not found, returns the given default value.
	 *
	 * @param key
	 * 		The key the UUID is stored under.
	 * @param defaultValue
	 * 		The default value to return if the stored value wasn't found.
	 *
	 * @return The UUID stored under the specified key or default value if not found.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public UUID getUUID(String key, UUID defaultValue) {
		return uuids.getOrDefault(key, defaultValue);
	}

	/**
	 * Stores a short under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the short.
	 * @param value
	 * 		The short you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setShort(String key, short value) {
		setShort(key, value, true);
	}

	/**
	 * Stores a short under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the short.
	 * @param value
	 * 		The short you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setShort(String key, short value, boolean override) {
		if (override)
			shorts.put(key, value);
		else if (!shorts.containsKey(key))
			shorts.put(key, value);
	}

	/**
	 * Stores an integer under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the integer.
	 * @param value
	 * 		The integer you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setInt(String key, int value) {
		setInt(key, value, true);
	}

	/**
	 * Stores an integer under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the integer.
	 * @param value
	 * 		The integer you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setInt(String key, int value, boolean override) {
		if (override)
			ints.put(key, value);
		else if (!ints.containsKey(key))
			ints.put(key, value);
	}

	/**
	 * Stores a long under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the long.
	 * @param value
	 * 		The long you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setLong(String key, long value) {
		setLong(key, value, true);
	}

	/**
	 * Stores a long under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the long.
	 * @param value
	 * 		The longbyou want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setLong(String key, long value, boolean override) {
		if (override)
			longs.put(key, value);
		else if (!longs.containsKey(key))
			longs.put(key, value);
	}

	/**
	 * Stores a float under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the float.
	 * @param value
	 * 		The float you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setFloat(String key, float value) {
		setFloat(key, value, true);
	}

	/**
	 * Stores a float under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the float.
	 * @param value
	 * 		The float you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setFloat(String key, float value, boolean override) {
		if (override)
			floats.put(key, value);
		else if (!floats.containsKey(key))
			floats.put(key, value);
	}

	/**
	 * Stores a double under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the double.
	 * @param value
	 * 		The double you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setDouble(String key, double value) {
		setDouble(key, value, true);
	}

	/**
	 * Stores a byte under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the double.
	 * @param value
	 * 		The double you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setDouble(String key, double value, boolean override) {
		if (override)
			doubles.put(key, value);
		else if (!doubles.containsKey(key))
			doubles.put(key, value);
	}

	/**
	 * Stores a boolean under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the boolean.
	 * @param value
	 * 		The boolean you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setBoolean(String key, boolean value) {
		setBoolean(key, value, true);
	}

	/**
	 * Stores a boolean under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the boolean.
	 * @param value
	 * 		The boolean you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setBoolean(String key, boolean value, boolean override) {
		if (override)
			booleans.put(key, value);
		else if (!booleans.containsKey(key))
			booleans.put(key, value);
	}

	/**
	 * Stores a character under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the character.
	 * @param value
	 * 		The character you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setChar(String key, char value) {
		setChar(key, value, true);
	}

	/**
	 * Stores a character under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the character.
	 * @param value
	 * 		The character you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setChar(String key, char value, boolean override) {
		if (override)
			chars.put(key, value);
		else if (!chars.containsKey(key))
			chars.put(key, value);
	}

	/**
	 * Stores a string under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the string.
	 * @param value
	 * 		The string you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setString(String key, String value) {
		setString(key, value, true);
	}

	/**
	 * Stores a string under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the string.
	 * @param value
	 * 		The string you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setString(String key, String value, boolean override) {
		if (override)
			strings.put(key, value);
		else if (!strings.containsKey(key))
			strings.put(key, value);
	}

	/**
	 * Stores an UUID under the specified key. The value will be overwritten if the key already exists.
	 *
	 * @param key
	 * 		An unique key under which you want to store the string.
	 * @param value
	 * 		The UUID you want to store.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setUUID(String key, UUID value) {
		setUUID(key, value, true);
	}

	/**
	 * Stores an UUID under the specified key.
	 *
	 * @param key
	 * 		An unique key under which you want to store the string.
	 * @param value
	 * 		The UUID you want to store.
	 * @param override
	 * 		If true, the value will be overwritten if the key already exists. (default)
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public void setUUID(String key, UUID value, boolean override) {
		if (override)
			uuids.put(key, value);
		else if (!uuids.containsKey(key))
			uuids.put(key, value);
	}

	/**
	 * Returns the plugin's session storage.
	 *
	 * @param plugin
	 * 		The plugin you want to access the storage of.
	 *
	 * @return The session storage of the plugin.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static SessionStorage get(JavaPlugin plugin) {
		return pluginStorage.getOrDefault(plugin, new SessionStorage());
	}

	/**
	 * Returns the player's session storage.
	 *
	 * @param player
	 * 		The player you want to access the storage of.
	 *
	 * @return The session storage of the player.
	 *
	 * @author Lukas Frey
	 * @since 1.0
	 */
	public static SessionStorage get(Player player) {
		return playerStorage.getOrDefault(player, new SessionStorage());
	}

}
