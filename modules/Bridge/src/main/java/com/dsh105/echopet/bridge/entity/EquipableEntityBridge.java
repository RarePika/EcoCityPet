package com.dsh105.echopet.bridge.entity;

import com.dsh105.commodus.container.ItemStackContainer;

public interface EquipableEntityBridge extends LivingEntityBridge
{

    ItemStackContainer getWeapon();

    void setWeapon(ItemStackContainer itemStack);
}