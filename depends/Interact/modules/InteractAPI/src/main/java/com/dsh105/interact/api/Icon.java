package com.dsh105.interact.api;

import com.dsh105.commodus.container.ItemStackContainer;

import java.util.List;

public interface Icon extends Serializable
{

    org.bukkit.Material getBukkitType();


    String getTypeId();

    String getName();

    List<String> getLore();

    int getQuantity();

    ItemStackContainer getStack();

    org.bukkit.inventory.ItemStack asBukkit();


    Icon.Builder builder();

    interface Builder extends InteractBuilder<Icon.Builder>
    {

        Icon.Builder name(String name);

        Icon.Builder lore(String... lore);

        Icon.Builder type(org.bukkit.Material bukkitType);


        Icon.Builder quantity(int quantity);

        Icon.Builder of(org.bukkit.inventory.ItemStack bukkitItemStack);


        Icon.Builder of(ItemStackContainer itemStack);

        Icon.Builder reset();

        Icon build();
    }
}