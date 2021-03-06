package com.dsh105.echopet.bridge.platform;


import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class TaskId
{

    // Bukkit
    private int intId;

    // Sponge
    private UUID uuid;

    private TaskId(int intId)
    {
        this.intId = intId;
    }

    private TaskId(UUID uuid)
    {
        this.uuid = uuid;
    }

    public static TaskId from(BukkitRunnable bukkitRunnable)
    {
        return new TaskId(bukkitRunnable.getTaskId());
    }

    public int getBukkitId()
    {
        return intId;
    }

    public UUID getSpongeId()
    {
        return uuid;
    }

    public void cancel()
    {
        if (uuid == null)
        {
            Bukkit.getScheduler().cancelTask(intId);
        }
    }
}