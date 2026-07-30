/*
 * Copyright (c) 2026 Aman Farooqui
 *
 * All rights reserved.
 *
 * The software is the confidential and proprietary information of Aman Farooqui.
 * Redistribution and use in source and binary forms, with or without
 * modification, are strictly prohibited without prior written permission.
 */

package xyz.refinedev.practice.api.arena.schematic;

import java.nio.file.Path;

/**
 * @author Drizzy
 * @version BoltRecode
 * @since 8/17/2025
 */
public interface IArenaSchematic {

    /**
     * The name of the schematic (usually the arena name)
     *
     * @return the name of the schematic
     */
    String getName();

    /**
     * The schematic type
     *
     * @return the clipboard
     */
    SchematicType getExtension();

    /**
     * The
     *
     * @return the clipboard
     */
    default Path getSchematicFile(Path schematicsFolder) {
        return schematicsFolder.resolve(getName() + "." + getExtension());
    }
}
