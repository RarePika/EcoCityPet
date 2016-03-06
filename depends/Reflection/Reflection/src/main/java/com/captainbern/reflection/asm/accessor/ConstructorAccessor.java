package com.captainbern.reflection.asm.accessor;

public interface ConstructorAccessor extends Accessor
{

    Object newInstance(Object... args);
}
