package com.captainbern.minecraft.wrapper.nbt;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public interface NbtTagCompound extends NbtTagBase<Map<String, NbtTagBase<?>>>, Iterable<NbtTagBase<?>>
{

    boolean containsKey(String key);

    Set<String> getKeys();

    <T> NbtTagBase<T> getValue(String key);

    <T> NbtTagCompound putObject(String key, Object value);

    <T> NbtTagCompound put(String key, NbtTagBase<?> value);

    byte getByte(String key);

    NbtTagCompound put(String key, byte value);

    short getShort(String key);

    NbtTagCompound put(String key, short value);

    int getInt(String key);

    NbtTagCompound put(String key, int value);

    long getLong(String key);

    NbtTagCompound put(String key, long value);

    float getFloat(String key);

    NbtTagCompound put(String key, float value);

    double getDouble(String key, double value);

    NbtTagCompound put(String key, double value);

    byte[] getByteArray(String key);

    NbtTagCompound put(String key, byte[] value);

    String getString(String key);

    NbtTagCompound put(String key, String value);

    <T> NbtTagList<T> getList(String key);

    <T> NbtTagCompound put(String key, NbtTagList<T> value);

    NbtTagCompound getTagCompound(String key);

    NbtTagCompound put(String key, NbtTagCompound value);

    int[] getIntArray(String key);

    NbtTagCompound put(String key, int[] value);

    <T> NbtTagBase<?> remove(String key);

    Iterator<NbtTagBase<?>> iterator();

}
