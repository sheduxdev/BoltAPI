/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena;

import com.cryptomorin.xseries.XEntityType;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Read-only, third-party-facing surface of the arena service.
 *
 * @author Drizzy
 * @version BoltRecode
 * @since 2/3/2026
 */
public interface ArenaAPI {

    /**
     * Count how many duplicates a given arena has.
     *
     * @param arena arena instance
     * @return number of duplicates
     */
    default int countDuplicates(IArena arena) {
        return this.countDuplicates(arena, null);
    }

    /**
     * Count duplicates matching a filter.
     *
     * @param arena     arena instance
     * @param predicate filter predicate
     * @return number of duplicates matching the filter
     */
    int countDuplicates(IArena arena, @Nullable Predicate<IArena> predicate);

    /**
     * Get all duplicate IDs of a given arena.
     *
     * @param arena arena instance
     * @return set of duplicate IDs
     */
    Set<Integer> getDuplicateIds(IArena arena);

    /**
     * Get all duplicates of a given arena.
     *
     * @param arena arena instance
     * @return map of duplicate ID to arena instance
     */
    Map<Integer, IArena> getDuplicates(IArena arena);

    /**
     * Get a duplicate arena by ID.
     *
     * @param arena parent arena
     * @param id    duplicate ID
     * @return duplicate arena or null
     */
    Optional<IArena> getDuplicateByID(IArena arena, int id);

    /**
     * Get an arena by its internal name.
     *
     * @param name arena name
     * @return An optional containing the arena if found, or empty if not found.
     */
    Optional<IArena> getArenaByName(String name);

    /**
     * Get all arenas including duplicates.
     *
     * @return list of all arenas
     */
    List<IArena> getAllArenasAndDuplicates();

    /**
     * Get all registered (non-duplicate) arenas.
     *
     * @return immutable list of arenas
     */
    List<IArena> getAllArenas();

    /**
     * Get all registered arenas matching a filter. (Excluding duplicates)
     *
     * @param predicate filter predicate
     * @return list of arenas matching the filter
     */
    List<IArena> getArenas(Predicate<IArena> predicate);

    /**
     * Check if a kit is present in standard arenas.
     *
     * @param kit kit instance
     * @return true if supported
     */
    boolean isKitInStandard(IKit kit);

    /**
     * Get the current global grid index used for FAWE placements.
     *
     * @return grid index
     */
    int getGlobalGridIndex();

    /**
     * Get the world that stores all arena instances.
     *
     * @return arena world
     */
    World getArenaWorld();

    /**
     * Get the set of entity types that should be removed from arenas during resets.
     *
     * @return set of entity types to remove
     */
    Set<XEntityType> getRemovingEntities();

}
