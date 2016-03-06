package com.dsh105.echopet.bridge.entity;

import com.dsh105.commodus.container.PositionContainer;
import com.dsh105.echopet.bridge.PlatformBridge;

public interface LivingEntityBridge extends PlatformBridge
{

    Object getBridgedEntity();

    boolean isAlive();

    float getHealth();

    void setHealth(float health);

    float getMaxHealth();

    void setMaxHealth(double maxHealth);

    void setName(String name);

    void setNameVisibility(boolean flag);

    void removeEntity();

    void setPassenger(LivingEntityBridge livingEntityBridge);

    void setPassenger(Object passenger);

    PositionContainer getPassengerLocation();

    void eject();

    boolean move(PositionContainer to);


    PositionContainer getLocation();
}