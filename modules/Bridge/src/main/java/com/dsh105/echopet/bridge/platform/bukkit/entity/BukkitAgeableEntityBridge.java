package com.dsh105.echopet.bridge.platform.bukkit.entity;

import com.dsh105.echopet.bridge.entity.AgeableEntityBridge;
import org.bukkit.entity.Ageable;

public class BukkitAgeableEntityBridge<E extends Ageable> extends BukkitLivingEntityBridge<E> implements AgeableEntityBridge
{

    @Override
    public boolean isAdult()
    {
        return getBukkitEntity().isAdult();
    }

    @Override
    public void setAdult(boolean flag)
    {
        if (flag)
        {
            getBukkitEntity().setAdult();
        }
        else
        {
            getBukkitEntity().setBaby();
        }
    }
}