/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena.events;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.arena.IArena;

/**
 * @author Drizzy
 * @version Bolt
 * @since 5/13/2022
 */

@Getter
@RequiredArgsConstructor
public class ArenaReleaseEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IArena arena;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
