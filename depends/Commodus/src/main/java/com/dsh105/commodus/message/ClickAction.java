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

import java.net.URL;

public interface ClickAction<R> extends Action<R>
{

    abstract class AbstractClickAction<R> extends AbstractAction<R> implements ClickAction<R>
    {

        @Override
        public String getEventName()
        {
            return "click";
        }
    }

    abstract class PerformCommand extends AbstractClickAction<String>
    {

        @Override
        public String getId()
        {
            return Actions.Click.PERFORM_COMMAND;
        }

    }

    abstract class SuggestCommand extends AbstractClickAction<String>
    {

        @Override
        public String getId()
        {
            return Actions.Click.SUGGEST_COMMAND;
        }

    }

    abstract class ChangePage extends AbstractClickAction<Integer>
    {

        @Override
        public String getId()
        {
            return Actions.Click.CHANGE_PAGE;
        }


    }

    abstract class OpenUrl extends AbstractClickAction<URL>
    {

        @Override
        public String getId()
        {
            return Actions.Click.OPEN_URL;
        }


    }


}