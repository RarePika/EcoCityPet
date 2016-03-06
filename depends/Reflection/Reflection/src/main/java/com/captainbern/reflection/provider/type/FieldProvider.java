package com.captainbern.reflection.provider.type;

import com.captainbern.reflection.Reflection;
import com.captainbern.reflection.SafeField;

import java.lang.reflect.Field;

public interface FieldProvider<T>
{

    Reflection getReflection();

    <T> SafeField<T> asSafeField();

    Field reflectedField();
}
