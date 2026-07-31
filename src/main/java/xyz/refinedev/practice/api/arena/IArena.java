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

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.arena.cuboid.ICuboid;
import xyz.refinedev.practice.api.arena.schematic.IArenaSchematic;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author Drizzy
 * @version Bolt
 * @since 1/16/2025
 */
public interface IArena {

    /**
     * Get the arena's name
     *
     * @return {@link String}
     */
    String getName();

    /**
     * Get the display name of the arena.
     * This is used for displaying the arena in menus or lists.
     *
     * @return {@link String} The display name of the arena.
     */
    String getDisplayName();

    /**
     * Get the type of the arena.
     * This is used to determine the arena's behavior and properties.
     *
     * @return {@link ArenaType} The type of the arena.
     */
    ArenaType getType();

    /**
     * Get the display icon of the arena.
     * This is used for displaying the arena in menus or lists.
     *
     * @return {@link ItemStack} The display icon of the arena.
     */
    ItemStack getDisplayIcon();

    /**
     * Get the grid ID of the arena.
     *
     * @return {@link Integer}
     */
    int getId();

    /**
     * Is the arena currently scaling?
     * This means that the arena is in the process of being duplicated or resized.
     *
     * @return {@link Boolean}
     */
    boolean isScaling();

    /**
     * Is the arena fully setup?
     * This means that the arena has been scanned for special locations
     * and the arena's schematic has been registered.
     *
     * @return {@link Boolean}
     */
    boolean isSetup();

    /**
     * Is the arena in-use?
     * This means that the arena is currently being played in a match.
     *
     * @return {@link Boolean}
     */
    boolean isInUse();

    /**
     * Is the arena enabled?
     *
     * @return {@link Boolean}
     */
    boolean isEnabled();

    /**
     * Checks if arena is in-use and type aren't
     * standalone or duplicate, because then it's a build-allowed
     * arena which would destroy the entity hiders in spigots
     *
     * @return {@link Boolean}
     */
    boolean isPlayable();

    /**
     * Are ender pearls allowed in this arena?
     *
     * @return {@link Boolean}
     */
    boolean isPearlsAllowed();

    /**
     * Does the arena need to be reset before its next use?
     *
     * @return {@link Boolean}
     */
    boolean isPendingReset();

    /**
     * Set whether the arena needs to be reset before its next use
     *
     * @param pendingReset {@link Boolean}
     */
    void setPendingReset(boolean pendingReset);

    /**
     * Is the arena pending an initial reset?
     * This is used to determine if the arena needs to be reset
     * for the first time after being created or loaded.
     *
     * @return {@link Boolean}
     */
    boolean isPendingInitialReset();

    /**
     * Set whether the arena is pending an initial reset
     *
     * @param pendingInitialReset {@link Boolean}
     */
    void setPendingInitialReset(boolean pendingInitialReset);

    /**
     * Whitelist a kit to this arena, and make the arena
     * non-global for kits
     *
     * @param kit {@link String kit}
     */
    void whitelistKit(String kit);

    /**
     * Remove a kit from this arena
     *
     * @param kit {@link String kit}
     */
    void removeKit(String kit);

    /**
     * Is the given kit whitelisted to this arena?
     *
     * @param kit {@link String} The kit being checked.
     * @return    {@link Boolean} Returns true if this arena has it whitelisted.
     */
    boolean isWhitelisted(String kit);

    /**
     * Returns an immutable set of whitelisted kits
     *
     * @return {@link Set}
     */
    Set<String> getWhitelistedKits();

    /**
     * Get the arena's death height.
     * This is the y-level where players are automatically killed.
     *
     * @return {@link Integer}
     */
    int getDeathHeight();

    /**
     * Get the arena's build height.
     * This is the y-level where players are allowed to build.
     *
     * @return {@link Integer}
     */
    int getBuildHeight();

    /**
     * Get the arena's portal radius
     *
     * @return {@link Integer}
     */
    int getPortalRadius();

    /**
     * Get the arena's protection radius
     *
     * @return {@link Integer}
     */
    int getProtectionRadius();

    /**
     * Set the arena's protection radius
     *
     * @param radius {@link Integer}
     */
    void setProtectionRadius(int radius);

    /**
     * Get the arena's FFA spawn radius
     *
     * @return {@link Integer}
     */
    int getFFASpawnRadius();

    /**
     * Set the arena's FFA spawn radius
     *
     * @param radius {@link Integer}
     */
    void setFFASpawnRadius(int radius);

    /**
     * Get the arena's grid index
     *
     */
    int getGridIndex();

    /**
     * Set the arena's grid index
     *
     * @param index {@link Integer}
     */
    void setGridIndex(int index);

    /**
     * Run a callable for each chunk present
     * inside the bounds provided
     *
     * @param callback {@link Consumer callback}
     */
    void forEachChunk(Consumer<Chunk> callback);

    /**
     * Set the type of the arena.
     * This is used to determine the arena's behavior and properties.
     *
     * @param type {@link ArenaType} The new type of the arena.
     */
    void setType(ArenaType type);

    /**
     * Set the display icon of the arena.
     * This is used for displaying the arena in menus or lists.
     *
     * @param itemStack {@link ItemStack} The new display icon of the arena.
     */
    void setDisplayIcon(ItemStack itemStack);

    /**
     * Set the display name of the arena.
     *
     * @param displayName {@link String} The new display name of the arena.
     */
    void setDisplayName(String displayName);

    /**
     * Set the arena's enabled state
     *
     * @param enabled {@link Boolean}
     */
    void setEnabled(boolean enabled);

    /**
     * Set the arena's scaling state
     *
     * @param scaling {@link Boolean}
     */
    void setScaling(boolean scaling);

    /**
     * Set the arena's in-use state
     *
     * @param inUse {@link Boolean}
     */
    void setInUse(boolean inUse);

    /**
     * Set whether ender pearls are allowed in this arena
     *
     * @param allowed {@link Boolean}
     */
    void setPearlsAllowed(boolean allowed);

    /**
     * Set the arena's bounds
     *
     * @param cuboid {@link ICuboid}
     */
    void setBounds(ICuboid cuboid);

    /**
     * Set the arena's death height
     *
     * @param height {@link Integer}
     */
    void setDeathHeight(int height);

    /**
     * Set the arena's death height
     *
     * @param height {@link Integer}
     */
    void setBuildHeight(int height);

    /**
     * Set the arena's portal radius
     *
     * @param radius {@link Integer}
     */
    void setPortalRadius(int radius);

    /**
     * Get the arena's middle spawn location
     *
     * @return {@link Location}
     */
    Location getMidSpawn();

    /**
     * Get the arena's spawn1 location
     *
     * @return {@link Location}
     */
    Location getSpawn1();

    /**
     * Get the arena's spawn2 location
     *
     * @return {@link Location}
     */
    Location getSpawn2();

    /**
     * Get the arena's bounds
     *
     * @return {@link ICuboid}
     */
    ICuboid getBounds();

    /**
     * Set the arena's spawn1 location
     *
     * @param location {@link Location}
     */
    void setSpawn1(Location location);

    /**
     * Set the arena's spawn2 location
     *
     * @param location {@link Location}
     */
    void setSpawn2(Location location);

    /**
     * Set the arena's middle spawn location
     *
     * @param location {@link Location}
     */
    void setMidSpawn(Location location);

    /**
     * Get the arena's blue special locations
     *
     * @return {@code List<Location>}
     */
    List<Location> getBlueSpecial();

    /**
     * Get the arena's red special locations
     *
     * @return {@code List<Location>}
     */
    List<Location> getRedSpecial();

    /**
     * Get the arena's blue special bounds
     *
     * @return {@link ICuboid}
     */
    ICuboid getBlueSpecialBounds();

    /**
     * Get the arena's red special bounds
     *
     * @return {@link ICuboid}
     */
    ICuboid getRedSpecialBounds();

    /**
     * Set the arena's blue special locations
     *
     * @param locations {@code List<Location>}
     */
    void setBlueSpecial(List<Location> locations);

    /**
     * Set the arena's red special locations
     *
     * @param locations {@code List<Location>}
     */
    void setRedSpecial(List<Location> locations);

    /**
     * Set the arena's blue special bounds
     *
     * @param cuboid {@link ICuboid}
     */
    void setBlueSpecialBounds(ICuboid cuboid);

    /**
     * Set the arena's red special bounds
     *
     * @param cuboid {@link ICuboid}
     */
    void setRedSpecialBounds(ICuboid cuboid);

    /**
     * Get the arena's schematic
     *
     * @return {@link IArenaSchematic}
     */
    IArenaSchematic getSchematic();

    /**
     * Set the arena's schematic
     *
     * @param schematic {@link IArenaSchematic}
     */
    void setSchematic(@Nullable IArenaSchematic schematic);

    /**
     * Get the arena's extra protected zones. These are hand-drawn no-build/no-break
     * cuboids stacked on top of whatever the arena's own portal and spawn protection
     * radii already cover. Unlike the single portal special-cuboid, an arena can have
     * any number of these.
     *
     * @return {@link List} an immutable view of this arena's protected zones
     */
    List<ICuboid> getProtectedZones();

    /**
     * Add a protected zone to this arena.
     *
     * @param zone {@link ICuboid} the zone to add
     */
    void addProtectedZone(ICuboid zone);

    /**
     * Remove a protected zone from this arena by index.
     *
     * @param index {@link Integer} the zero-based index of the zone
     * @return      {@link Boolean} true if a zone existed at that index and was removed
     */
    boolean removeProtectedZone(int index);

    /**
     * Remove every protected zone from this arena.
     */
    void clearProtectedZones();

    /**
     * Check whether a location falls inside any of this arena's protected zones.
     *
     * @param location {@link Location} the location to test
     * @return         {@link Boolean} true if the location is inside a protected zone
     */
    default boolean isProtected(Location location) {
        if (location == null) {
            return false;
        }

        for ( ICuboid zone : this.getProtectedZones() ) {
            if (zone != null && zone.contains(location)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if arena type is standard
     *
     * @return {@link Boolean}
     */
    default boolean isStandard() {
        return getType() == ArenaType.STANDARD;
    }

    /**
     * Checks if arena type is stand-alone
     *
     * @return {@link Boolean}
     */
    default boolean isStandalone() {
        return getType() == ArenaType.STANDALONE;
    }

    /**
     * Checks if arena type is duplicate
     *
     * @return {@link Boolean}
     */
    default boolean isDuplicate() {
        return getType() == ArenaType.DUPLICATE;
    }

    /**
     * Checks if arena type is either duplicate or stand-alone
     *
     * @return {@link Boolean}
     */
    default boolean isDuplicateOrStandalone() {
        return isDuplicate() || isStandalone();
    }
}
