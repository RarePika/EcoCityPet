package com.captainbern.reflection.asm.accessor;

public interface MethodAccessor extends Accessor
{

    Object invoke(int index, Object... args);
}
