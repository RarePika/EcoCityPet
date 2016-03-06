package com.captainbern.reflection.provider.type;

import com.captainbern.reflection.Reflection;
import com.captainbern.reflection.SafeConstructor;

import java.lang.reflect.Constructor;

public interface ConstructorProvider<T>
{

    Reflection getReflection();

    <T> SafeConstructor<T> asSafeConstructor();

    Constructor<T> reflectedConstructor();
}
