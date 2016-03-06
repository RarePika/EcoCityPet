package com.captainbern.minecraft.error;

public interface ErrorReporter
{

    void report(Object sender, String method, Throwable throwable);

    void report(Object sender, String method, Object... params);

    void reportDebug(Object sender, Report report);

    void reportWarning(Object sender, Report report);

}
