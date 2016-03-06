package com.captainbern.minecraft.wrapper.nbt;

public interface NbtTagBase<T>
{

    NbtType getType();

    T getValue();

    void setValue(T value);

    int hashCode();

    String toString();
}
