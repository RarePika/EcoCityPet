package com.captainbern.reflection.asm.accessor;

import java.lang.reflect.Field;

public interface FieldAccessor extends Accessor
{

    void set(Object instance, int index, Object value) throws IllegalAccessException;

    void set(Object instance, String fieldName, Object value) throws IllegalAccessException;

    Object get(Object instance, int index) throws IllegalAccessException;

    Object get(Object instance, String fieldName) throws IllegalAccessException;

    Field[] getFieldTable();
}
