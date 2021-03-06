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

import com.dsh105.echopet.api.entity.entitypet.type.EntityCowPet;
import com.dsh105.echopet.api.entity.pet.EchoAgeablePet;
import com.dsh105.echopet.bridge.entity.type.CowEntityBridge;

import java.util.UUID;

public class EchoCowPet<T extends CowEntityBridge, S extends EntityCowPet> extends EchoAgeablePet<T, S> implements CowPet<T, S>
{

    public EchoCowPet(UUID playerUID)
    {
        super(playerUID);
    }
}