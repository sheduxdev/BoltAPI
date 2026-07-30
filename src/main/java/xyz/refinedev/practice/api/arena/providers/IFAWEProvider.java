/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena.providers;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.arena.IArena;
import xyz.refinedev.practice.api.arena.cuboid.ICuboid;
import xyz.refinedev.practice.api.arena.schematic.IArenaSchematic;

import java.util.concurrent.CompletableFuture;

/**
 * @author Drizzy
 * @version Bolt
 * @since 9/13/2023
 */
public interface IFAWEProvider {

    Vector STARTING_POINT = new Vector(1000, 0, 1000);

    /**
     * Update the schematic if it has new changes.
     *
     * @param arena {@link IArena arena}
     */
    CompletableFuture<Void> writeSchematic(@NotNull IArena arena);

    /**
     * Paste a schematic at the given location.
     *
     * @param arena     {@link IArena arena} The arena to paste for
     * @param schematic {@link IArenaSchematic schematic} to paste
     * @param pasteAt   {@link Location} The minimum point of the cuboid to paste at
     */
    CompletableFuture<Void> pasteSchematic(@NotNull IArena arena, @NotNull IArenaSchematic schematic, @NotNull Location pasteAt);

    /**
     * Paste a schematic at the given location synchronously.
     *
     * @param arenaSchematic {@link IArenaSchematic schematic} to paste
     * @param pasteAt        {@link Location} The minimum point of the cuboid to paste at
     */
    void pasteSchematicSync(@NotNull IArenaSchematic arenaSchematic, @NotNull Location pasteAt) throws Exception;

    /**
     * Clear blocks in the given bounds.
     *
     * @param bounds {@link ICuboid} Bounds
     */
    CompletableFuture<Void> clear(@NotNull ICuboid bounds);

    /**
     * Clear blocks in the given bounds synchronously.
     *
     * @param bounds {@link ICuboid} Bounds
     */
    void clearSync(@NotNull ICuboid bounds);

    /**
     * Cut the parent arena and then paste it properly according to grid.
     *
     * @param arena {@link IArena}
     */
    CompletableFuture<Void> moveToGrid(@NotNull IArena arena);

    /**
     * Scale an arena's duplicates according to your needs.
     *
     * @param arena         {@link IArena standalone arena}
     * @param desiredCopies {@link Integer desired amount}
     */
    CompletableFuture<Void> scaleCopies(@NotNull IArena arena, int desiredCopies);

    /**
     * Paste an arena's duplicate to the specified cords.
     *
     * @param arena      {@link IArena arena being pasted}
     * @param copyNumber {@link Integer copyNumber}
     */
    @NotNull IArena createDuplicate(@NotNull IArena arena, int copyNumber) throws RuntimeException;

    /**
     * Remove an arena's duplicate from the world.
     *
     * @param arena      {@link IArena arena being removed}
     * @param copyNumber {@link Integer copyNumber}
     */
    @Nullable IArena removeDuplicate(@NotNull IArena arena, int copyNumber) throws RuntimeException;

    /**
     * Clear the cache for an arena.
     *
     * @param arena {@link IArena arena}
     */
    void clearCache(IArena arena);

    /**
     * Get the grid spacing in the X direction.
     *
     * @return {@link Integer grid spacing in X}
     */
    int getGridSpacingX();

    /**
     * Get the grid spacing in the Z direction.
     *
     * @return {@link Integer grid spacing in Z}
     */
    int getGridSpacingZ();
}
