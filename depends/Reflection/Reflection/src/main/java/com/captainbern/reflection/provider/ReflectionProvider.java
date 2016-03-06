package com.captainbern.reflection.provider;

import com.captainbern.reflection.EnumModifier;
import com.captainbern.reflection.Reflection;
import com.captainbern.reflection.provider.type.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ReflectionProvider
{

    <T> ClassProvider<T> getClassProvider(final Reflection reflection, final Class<T> clazz, final boolean forceAccess);

    <T> ClassProvider<T> getClassProvider(final Reflection reflection, final String className, final boolean forceAccess) throws ClassNotFoundException;

    <T> ConstructorProvider<T> getConstructorProvider(final Reflection reflection, final Constructor<T> constructor);

    <T> ConstructorProvider<T> getConstructorProvider(final Reflection reflection, final Class<T> clazz, final Class... args);

    <T> FieldProvider<T> getFieldProvider(final Reflection reflection, final Field field);

    <T> FieldProvider<T> getFieldProvider(final Reflection reflection, final Class<?> clazz, final String fieldName);

    <T> MethodProvider<T> getMethodProvider(final Reflection reflection, final Method method);

    <T> MethodProvider<T> getMethodProvider(final Reflection reflection, final Class<?> clazz, final String methodName, final Class... args);

    <T extends Enum<T>> EnumModifier<T> createNewEnumModifier(final Reflection reflection, final Class<T> enumClass);

    Class<?> loadClass(final String className);
}
