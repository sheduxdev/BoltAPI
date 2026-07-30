/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena.cuboid;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a cuboid region in a world defined by two corners.
 *
 * @author Drizzy
 * @version BoltRecode
 * @since 1/18/2026
 */
public interface ICuboid extends Cloneable, Iterable<Block> {

    /**
     * Get the Location of the lower northeast corner of the Cuboid (minimum XYZ coords).
     *
     * @return Location of the lower northeast corner
     */
    Location getLowerCorner();

    /**
     * Get the Location of the upper southwest corner of the Cuboid (maximum XYZ coords).
     *
     * @return Location of the upper southwest corner
     */
    Location getUpperCorner();

    /**
     * Get the center of the Cuboid.
     *
     * @return Location at the centre of the Cuboid
     */
    Location getCenter();

    /**
     * Get the Cuboid's world.
     *
     * @return the World object representing this Cuboid's world
     * @throws IllegalStateException if the world is not loaded
     */
    World getWorld();

    /**
     * Get the size of this Cuboid along the X axis.
     *
     * @return Size of Cuboid along the X axis
     */
    int getSizeX();

    /**
     * Get the size of this Cuboid along the Y axis.
     *
     * @return Size of Cuboid along the Y axis
     */
    int getSizeY();

    /**
     * Get the size of this Cuboid along the Z axis.
     *
     * @return Size of Cuboid along the Z axis
     */
    int getSizeZ();

    /**
     * Get the minimum X coord of this Cuboid.
     *
     * @return the minimum X coord
     */
    int getLowerX();

    /**
     * Get the minimum Y coord of this Cuboid.
     *
     * @return the minimum Y coord
     */
    int getLowerY();

    /**
     * Get the minimum Z coord of this Cuboid.
     *
     * @return the minimum Z coord
     */
    int getLowerZ();

    /**
     * Get the maximum X coord of this Cuboid.
     *
     * @return the maximum X coord
     */
    int getUpperX();

    /**
     * Get the maximum Y coord of this Cuboid.
     *
     * @return the maximum Y coord
     */
    int getUpperY();

    /**
     * Get the maximum Z coord of this Cuboid.
     *
     * @return the maximum Z coord
     */
    int getUpperZ();

    /**
     * Get the Blocks at the four corners of the Cuboid, without respect to y-value.
     *
     * @return array of Location objects representing the Cuboid corners
     */
    Location[] getCorners();

    /**
     * Expand the Cuboid in the given direction by the given amount.
     *
     * @param dir    the direction in which to expand
     * @param amount the number of blocks by which to expand
     * @return a new ICuboid expanded by the given direction and amount
     */
    ICuboid expand(CuboidDirection dir, int amount);

    /**
     * Shift the Cuboid in the given direction by the given amount.
     *
     * @param dir    the direction in which to shift
     * @param amount the number of blocks by which to shift
     * @return a new ICuboid shifted by the given direction and amount
     */
    ICuboid shift(CuboidDirection dir, int amount);

    /**
     * Outset (grow) the Cuboid in the given direction by the given amount.
     *
     * @param dir    the direction in which to outset (must be HORIZONTAL, VERTICAL, or BOTH)
     * @param amount the number of blocks by which to outset
     * @return a new ICuboid outset by the given direction and amount
     */
    ICuboid outset(CuboidDirection dir, int amount);

    /**
     * Inset (shrink) the Cuboid in the given direction by the given amount.
     *
     * @param dir    the direction in which to inset (must be HORIZONTAL, VERTICAL, or BOTH)
     * @param amount the number of blocks by which to inset
     * @return a new ICuboid inset by the given direction and amount
     */
    ICuboid inset(CuboidDirection dir, int amount);

    /**
     * Add the given amount to the Cuboid's coordinates.
     *
     * @param x the amount to add to the X coord
     * @param y the amount to add to the Y coord
     * @param z the amount to add to the Z coord
     * @return this ICuboid, after adding the given amounts
     */
    ICuboid add(int x, int y, int z);

    /**
     * Subtract the given amount from the Cuboid's coordinates.
     *
     * @param x the amount to subtract from the X coord
     * @param y the amount to subtract from the Y coord
     * @param z the amount to subtract from the Z coord
     * @return this ICuboid, after subtracting the given amounts
     */
    ICuboid subtract(int x, int y, int z);

    /**
     * Return true if the point at (x,y,z) is contained within this Cuboid.
     *
     * @param x the X coord
     * @param y the Y coord
     * @param z the Z coord
     * @return true if the given point is within this Cuboid, false otherwise
     */
    boolean contains(int x, int y, int z);

    /**
     * Return true if the point at (x,z) is contained within this Cuboid.
     *
     * @param x the X coord
     * @param z the Z coord
     * @return true if the given point is within this Cuboid, false otherwise
     */
    boolean contains(int x, int z);

    /**
     * Check if the given Entity is contained within this Cuboid.
     *
     * @param entity the Entity to check for
     * @return true if the Entity is within this Cuboid, false otherwise
     */
    boolean contains(Entity entity);

    /**
     * Check if the given Chunk is contained within this Cuboid.
     *
     * @param chunk the chunk to check for
     * @return true if the Chunk is within this Cuboid, false otherwise
     */
    boolean contains(Chunk chunk);

    /**
     * Check if the given Location is contained within this Cuboid.
     *
     * @param l the Location to check for
     * @return true if the Location is within this Cuboid, false otherwise
     */
    boolean contains(Location l);

    /**
     * Check if the given Block is contained within this Cuboid.
     *
     * @param b the Block to check for
     * @return true if the Block is within this Cuboid, false otherwise
     */
    boolean contains(Block b);

    /**
     * Get the volume of this Cuboid.
     *
     * @return the Cuboid volume, in blocks
     */
    int volume();

    /**
     * Get the area of this Cuboid.
     *
     * @return the Cuboid area, in blocks
     */
    int arena();

    /**
     * Get the Cuboid representing the face of this Cuboid.
     *
     * @param dir which face of the Cuboid to get
     * @return the ICuboid representing this Cuboid's requested face
     */
    ICuboid getFace(CuboidDirection dir);

    /**
     * Get the Cuboid big enough to hold both this Cuboid and the given one.
     *
     * @param other the other Cuboid
     * @return a new ICuboid large enough to hold this Cuboid and the given Cuboid
     */
    ICuboid getBoundingCuboid(ICuboid other);

    /**
     * Get a block relative to the lower NE point of the Cuboid.
     *
     * @param x the X coord
     * @param y the Y coord
     * @param z the Z coord
     * @return the block at the given position
     */
    Block getRelativeBlock(int x, int y, int z);

    /**
     * Get a block relative to the lower NE point of the Cuboid in the given World.
     *
     * @param w the World
     * @param x the X coord
     * @param y the Y coord
     * @param z the Z coord
     * @return the block at the given position
     */
    Block getRelativeBlock(World w, int x, int y, int z);

    /**
     * Get a list of the chunks which are fully or partially contained in this cuboid.
     *
     * @return a list of Chunk objects
     */
    List<Chunk> getChunks();

    /**
     * Loads the chunks within this cuboid synchronously.
     */
    void loadChunks();

    /**
     * Loads the chunks within this cuboid asynchronously.
     *
     * @return a CompletableFuture that completes when chunks are loaded
     */
    CompletableFuture<Void> loadAsync();

    /**
     * Get the horizontal walls of the cuboid.
     *
     * @return horizontal walls of the cuboid
     */
    ICuboid[] getWalls();

    /**
     * Gets an iterator for all locations within this cuboid.
     *
     * @return an iterator of locations
     */
    Iterator<Location> locationIterator();

    /**
     * Clone the Cuboid.
     *
     * @return a clone of this Cuboid
     */
    ICuboid clone();
}
