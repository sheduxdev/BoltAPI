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

/**
 * Represents directions that can be applied to certain faces and actions of a Cuboid
 */
public enum CuboidDirection {

	NORTH,
	EASY,
	SOUTH,
	WEST,
	UP,
	DOWN,
	HORIZONTAL,
	VERTICAL,
	BOTH,
	UNKNOWN;

	public CuboidDirection opposite() {
		switch (this) {
			case NORTH:
				return SOUTH;
			case EASY:
				return WEST;
			case SOUTH:
				return NORTH;
			case WEST:
				return EASY;
			case HORIZONTAL:
				return VERTICAL;
			case VERTICAL:
				return HORIZONTAL;
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			case BOTH:
				return BOTH;
			default:
				return UNKNOWN;
		}
	}
}