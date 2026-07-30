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

import com.cryptomorin.xseries.reflection.XReflection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Drizzy
 * @version BoltRecode
 * @since 11/29/2025
 */
@Getter
@RequiredArgsConstructor
public enum SchematicType {

    SCHEMATIC("schematic"),
    FAST_V3("fastv3"),
    SCHEM("schem");

    private final String extension;

    public String toString() {
        return this.extension;
    }

    public static SchematicType getByVersion() {
        return XReflection.supports(1, 9) ? SchematicType.FAST_V3 : SchematicType.SCHEMATIC;
    }

    public static SchematicType fromString(String value) {
        for (SchematicType type : values()) {
            if (type.getExtension().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
