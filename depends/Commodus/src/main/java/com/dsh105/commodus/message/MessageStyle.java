/*
 * This file is part of Commodus.
 *
 * Commodus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Commodus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Commodus.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.commodus.message;

import org.bukkit.ChatColor;

import java.util.Arrays;

public enum MessageStyle
{

    OBFUSCATED('k', ChatColor.MAGIC),
    BOLD('l', ChatColor.BOLD),
    STRIKETHROUGH('m', ChatColor.STRIKETHROUGH),
    UNDERLINE('n', ChatColor.UNDERLINE),
    ITALIC('o', ChatColor.ITALIC),
    RESET('r', ChatColor.RESET);

    private static String[] styles;

    static
    {
        styles = new String[values().length];
        for (int i = 0; i < styles.length; i++)
        {
            styles[i] = values()[i].name().toLowerCase();
        }
    }

    private char legacyChar;
    private ChatColor bukkitStyle;

    MessageStyle(char legacyChar, ChatColor bukkitStyle)
    {
        this.legacyChar = legacyChar;
        this.bukkitStyle = bukkitStyle;
    }

    public static String[] styles()
    {
        return Arrays.copyOf(styles, styles.length);
    }

    public char getLegacyChar()
    {
        return legacyChar;
    }

    public ChatColor getBukkitStyle()
    {
        return bukkitStyle;
    }
}