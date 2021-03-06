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

import com.dsh105.commodus.bukkit.ItemRegistry;
import com.dsh105.commodus.bukkit.MaterialId;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemStackContainer extends Container<ItemStackContainer>
{

    // TODO: docs
    // TODO: enchantments

    private String id;
    private int meta;
    private int quantity;

    private ItemStackContainer(String id, int meta, int quantity)
    {
        this.id = id;
        this.meta = meta;
        this.quantity = quantity;
    }

    public static ItemStackContainer of(String id, int quantity)
    {
        return of(id, 0, quantity);
    }

    public static ItemStackContainer of(String id, int meta, int quantity)
    {
        return new ItemStackContainer(id, meta, quantity);
    }

    public static ItemStackContainer of(MaterialId id, int quantity)
    {
        return of(ItemRegistry.getId(id), id.getMeta(), quantity);
    }

    public static ItemStackContainer of(org.bukkit.Material bukkitMaterial, int quantity)
    {
        return of(bukkitMaterial, 0, quantity);
    }

    public static ItemStackContainer of(Material bukkitMaterial, int meta, int quantity)
    {
        return of(ItemRegistry.getId(bukkitMaterial, meta), meta, quantity);
    }

    public static ItemStackContainer of(org.bukkit.inventory.ItemStack bukkitItemStack)
    {
        return of(bukkitItemStack.getType(), bukkitItemStack.getDurability(), bukkitItemStack.getAmount());
    }

    public org.bukkit.inventory.ItemStack asBukkit()
    {
        return asBukkit(null);
    }

    public org.bukkit.inventory.ItemStack asBukkit(String displayName, String... lore)
    {
        return asBukkit(displayName, Arrays.asList(lore));
    }

    public org.bukkit.inventory.ItemStack asBukkit(String displayName, List<String> lore)
    {
        MaterialId id = ItemRegistry.getId(this.id, meta);
        org.bukkit.inventory.ItemStack stack = new org.bukkit.inventory.ItemStack(id.getId(), quantity, (short) id.getMeta());
        ItemMeta meta = stack.getItemMeta();
        if (displayName != null)
        {
            meta.setDisplayName(displayName);
        }
        if (lore != null)
        {
            meta.setLore(lore);
        }
        stack.setItemMeta(meta);
        return stack;
    }

    public String getId()
    {
        return id;
    }

    public int getTypeMeta()
    {
        return meta;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public boolean isSimilar(ItemStackContainer stack)
    {
        return stack != null && (stack == this || id.equals(stack.id) && meta == stack.meta && quantity == stack.quantity);
    }
}