package com.captainbern.minecraft.wrapper.nbt;

import java.io.DataOutput;

public interface WrappedNbtTag<T> extends NbtTagBase<T>
{

    Object getHandle();

    void write(DataOutput dataOutput);

}
