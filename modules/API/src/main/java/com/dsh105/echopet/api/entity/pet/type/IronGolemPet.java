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

package com.dsh105.echopet.api.entity.pet.type;

import com.dsh105.echopet.api.entity.PetType;
import com.dsh105.echopet.api.entity.Size;
import com.dsh105.echopet.api.entity.SizeCategory;
import com.dsh105.echopet.api.entity.Traits;
import com.dsh105.echopet.api.entity.attribute.AttributeGetter;
import com.dsh105.echopet.api.entity.attribute.AttributeSetter;
import com.dsh105.echopet.api.entity.attribute.Attributes;
import com.dsh105.echopet.api.entity.entitypet.type.EntityIronGolemPet;
import com.dsh105.echopet.api.entity.pet.Hostility;
import com.dsh105.echopet.api.entity.pet.Pet;
import com.dsh105.echopet.bridge.entity.type.IronGolemEntityBridge;

@Traits(type = PetType.IRON_GOLEM, hositility = Hostility.NEUTRAL, width = 1.4F, height = 2.9F, health = 100.0D, attackDamage = 7.0D)
@Size(SizeCategory.REGULAR)
public interface IronGolemPet extends Pet<IronGolemEntityBridge, EntityIronGolemPet>
{

    @AttributeGetter(Attributes.Attribute.ROSE)
    boolean getHoldingRose();

    @AttributeSetter(Attributes.Attribute.ROSE)
    void setHoldingRose(boolean flag);
}