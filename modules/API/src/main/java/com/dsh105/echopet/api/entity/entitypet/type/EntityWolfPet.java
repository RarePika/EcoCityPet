/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.api.entity.entitypet.type;

import com.dsh105.echopet.api.entity.Entity;
import com.dsh105.echopet.api.entity.PetType;
import com.dsh105.echopet.api.entity.attribute.Attributes;
import com.dsh105.echopet.api.entity.entitypet.EntityAgeablePet;
import com.dsh105.echopet.api.entity.pet.type.WolfPet;

@Entity(PetType.WOLF)
public interface EntityWolfPet extends EntityAgeablePet<WolfPet>
{

    int DATAWATCHER_ENTITY_STATUS = 16;
    int DATAWATCHER_OWNER_NAME = 17;
    int DATAWATCHER_HEALTH = 18;
    int DATAWATCHER_BEGGING = 19;
    int DATAWATCHER_COLLAR_COLOUR = 20;

    Attributes.Color getWolfCollarColor();

    void setWolfCollarColor(Attributes.Color color);

    boolean isTamed();

    void setTamed(boolean flag);

    boolean isAngry();

    void setAngry(boolean flag);

    float getTailHealth();
}