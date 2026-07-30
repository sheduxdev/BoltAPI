/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena.reset;

import org.jetbrains.annotations.NotNull;
import xyz.refinedev.practice.api.arena.IArena;
import xyz.refinedev.practice.api.match.IMatch;

import java.util.concurrent.CompletableFuture;

/**
 * @author Drizzy
 * @version Bolt
 * @since 1/16/2025
 */
public interface IResetStrategy {

    /**
     * Get the name of this reset strategy.
     *
     * @return The name of the strategy.
     */
    String getName();

    /**
     * Check if this reset strategy requires preloading.
     *
     * @return True if preloading is required, false otherwise.
     */
    boolean requiresPreload();

    /**
     * Check if this reset strategy preloads duplicates.
     *
     * @return True if duplicates are preloaded, false otherwise.
     */
    boolean preloadsDuplicates();

    /**
     * Prepare any resources needed for resetting the arena.
     * This method is called once when the arena is created/loaded.
     * The arena supplied here must only be the parent arena, duplicates will not call this method.
     *
     * @param arena The arena to preload resources for.
     * @return      A CompletableFuture that completes when preloading is done.
     */
    CompletableFuture<Void> preload(@NotNull IArena arena);

    /**
     * Reset the arena to its original state.
     * This method may be called multiple times during a {@link IMatch}
     *
     * @param arena The arena to reset.
     * @return      A CompletableFuture that completes when the reset is done.
     */
    CompletableFuture<Void> reset(@NotNull IArena arena);

    /**
     * Cleanup any resources used by the reset strategy.
     * This method is called once when the arena is unloaded/deleted.
     *
     * @param arena The arena to clean up resources for.
     */
    void cleanup(@NotNull IArena arena);
}
