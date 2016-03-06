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
import com.dsh105.echopet.api.entity.pet.type.HorsePet;

@Entity(PetType.HORSE)
public interface EntityHorsePet extends EntityAgeablePet<HorsePet>
{

    int DATAWATCHER_ANIMATION = 16;
    int DATAWATCHER_HORSE_VARIANT = 19;
    int DATAWATCHER_HORSE_SKIN = 20;
    int DATAWATCHER_OWNER_NAME = 21;
    int DATAWATCHER_HORSE_ARMOUR = 22;

    int ANIMATION_SADDLE = 4;
    int ANIMATION_CHEST = 8;
    int ANIMATION_LOWER_HEAD = 32;
    int ANIMATION_REAR = 64;
    int ANIMATION_OPEN_MOUTH = 128;

    Attributes.HorseVariant getHorseVariant();

    void setHorseVariant(Attributes.HorseVariant variant);

    Attributes.HorseColor getColor();

    void setColor(Attributes.HorseColor color);

    Attributes.HorseStyle getStyle();

    void setStyle(Attributes.HorseStyle style);

    Attributes.HorseArmour getArmour();

    void setArmour(Attributes.HorseArmour armour);

    boolean isSaddled();

    void setSaddled(boolean flag);

    boolean isChested();

    void setChested(boolean flag);

    void animation(int animationId, boolean flag);

    void setTame(boolean flag);
}