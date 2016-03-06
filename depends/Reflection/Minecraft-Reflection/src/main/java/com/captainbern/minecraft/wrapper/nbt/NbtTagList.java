package com.captainbern.minecraft.wrapper.nbt;

import java.util.Collection;
import java.util.List;

public interface NbtTagList<T> extends NbtTagBase<List<NbtTagBase<T>>>, Iterable<T>
{

    NbtType getListType();

    void setListType(NbtType nbtType);

    void add(NbtTagBase<T> nbtTagBase);

    void add(byte b);

    void add(short s);

    void add(int i);

    void add(long l);

    void add(float f);

    void add(double d);

    void add(byte[] ba);

    void add(String s);

    void add(int[] ia);

    void remove(Object value);

    T getValue(int index);

    Collection<NbtTagBase<T>> toCollection();

    int size();

}
