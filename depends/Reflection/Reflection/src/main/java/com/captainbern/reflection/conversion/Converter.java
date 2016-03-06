package com.captainbern.reflection.conversion;

public interface Converter<TWrapped>
{

    TWrapped getWrapped(Object object);

    Object getUnwrapped(Class<?> type, TWrapped wrapped);

}
