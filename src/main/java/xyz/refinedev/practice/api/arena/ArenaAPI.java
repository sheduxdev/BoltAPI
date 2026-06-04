package xyz.refinedev.practice.api.arena;

import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;

import java.util.Collection;
import java.util.Collections;

/**
 * Public access to Bolt arena/map data.
 */
public interface ArenaAPI {

    default Collection<IArena> getArenas() {
        return Collections.emptyList();
    }

    default Collection<IArena> getAvailableArenas(IKit kit) {
        return Collections.emptyList();
    }

    @Nullable
    default IArena getArena(String name) {
        return null;
    }
}
