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

package com.dsh105.commodus;

import junit.framework.Assert;
import org.junit.Test;

import java.util.UUID;

public class UUIDFetcherTest
{

    @Test
    public void testFetching() throws Exception
    {
        Assert.assertEquals(UUID.fromString("2d762d9c-2a1a-4d99-9821-8f6b5e11a51a"), UUIDFetcher.getUUIDOf("stuntguy3000"));
    }
}
