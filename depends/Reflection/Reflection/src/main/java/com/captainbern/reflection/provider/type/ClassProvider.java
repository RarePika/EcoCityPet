package com.captainbern.reflection.provider.type;

import com.captainbern.reflection.ClassTemplate;
import com.captainbern.reflection.Reflection;

public interface ClassProvider<T>
{

    Reflection getReflection();

    <T> ClassTemplate<T> asClassTemplate();

    Class<T> reflectedClass();
}
