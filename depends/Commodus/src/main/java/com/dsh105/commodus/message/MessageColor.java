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

public enum MessageColor
{

    BLACK('0', ChatColor.BLACK),
    DARK_BLUE('1', ChatColor.DARK_BLUE),
    DARK_GREEN('2', ChatColor.DARK_GREEN),
    DARK_AQUA('3', ChatColor.DARK_AQUA),
    DARK_RED('4', ChatColor.DARK_RED),
    DARK_PURPLE('5', ChatColor.DARK_PURPLE),
    GOLD('6', ChatColor.GOLD),
    GRAY('7', ChatColor.GRAY),
    DARK_GRAY('8', ChatColor.DARK_GRAY),
    BLUE('9', ChatColor.BLUE),
    GREEN('a', ChatColor.GREEN),
    AQUA('b', ChatColor.AQUA),
    RED('c', ChatColor.RED),
    LIGHT_PURPLE('d', ChatColor.LIGHT_PURPLE),
    YELLOW('e', ChatColor.YELLOW),
    WHITE('f', ChatColor.WHITE);

    private char legacyChar;
    private ChatColor bukkitColor;


    MessageColor(char legacyChar, ChatColor bukkitColor)
    {
        this.legacyChar = legacyChar;
        this.bukkitColor = bukkitColor;
    }

    public char getLegacyChar()
    {
        return legacyChar;
    }

    public ChatColor getBukkitColor()
    {
        return bukkitColor;
    }
}