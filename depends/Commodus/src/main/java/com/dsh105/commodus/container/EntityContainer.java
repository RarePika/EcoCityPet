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

package com.dsh105.commodus.container;

import com.dsh105.commodus.ServerUtil;
import org.bukkit.Bukkit;

import java.util.UUID;

public class EntityContainer extends Container<EntityContainer>
{

    private UUID worldUID;
    private UUID entityUID;

    private EntityContainer(UUID worldUID, UUID entityUID)
    {
        this.worldUID = worldUID;
        this.entityUID = entityUID;
    }

    public static EntityContainer of(org.bukkit.entity.Entity entity)
    {
        return new EntityContainer(entity.getWorld().getUID(), entity.getUniqueId());
    }


    public org.bukkit.entity.Entity asBukkit()
    {
        for (org.bukkit.entity.Entity entity : Bukkit.getWorld(worldUID).getEntities())
        {
            if (entity.getUniqueId().equals(entityUID))
            {
                return entity;
            }
        }
        throw new IllegalStateException(String.format("Entity is no longer present (ID=%s)", entityUID));
    }

    public String getName()
    {
        switch (ServerUtil.getServerBrand().getCapsule())
        {
            case BUKKIT:
                return asBukkit().getCustomName();
        }
        throw new IllegalStateException("Entity must be a Bukkit  entity");
    }

    public UUID getUID()
    {
        return entityUID;
    }

    public String getTypeId()
    {
        switch (ServerUtil.getServerBrand().getCapsule())
        {
            case BUKKIT:
                return asBukkit().getType().getName();
        }
        throw new IllegalStateException("Entity must be a Bukkit entity");
    }
}