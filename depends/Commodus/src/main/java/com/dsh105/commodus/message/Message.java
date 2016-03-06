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

import com.dsh105.commodus.container.PlayerContainer;

import java.util.Collection;
import java.util.List;

public interface Message extends JsonWritable
{

    void send(PlayerContainer player);

    void send(PlayerContainer... players);

    void send(Iterable<PlayerContainer> players);

    String getContent();

    List<Message> getChildren();

    Collection<Message> children();

    MessageColor getColor();

    MessageStyle[] getStyles();

    HoverAction<?> getHoverAction();

    ClickAction<?> getClickAction();

    ShiftClickAction<?> getShiftClickAction();

    String toLegacy();

    String toJson();

}