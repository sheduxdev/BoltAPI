package xyz.refinedev.practice.api.arena;

import org.bukkit.inventory.ItemStack;
import xyz.refinedev.practice.api.kit.IKit;

import java.util.Collection;
import java.util.Collections;

/**
 * Public read-only view of a Bolt arena/map.
 */
public interface IArena {

    String getName();

    default String getDisplayName() {
        return this.getName();
    }

    default ItemStack getDisplayIcon() {
        return null;
    }

    default boolean isEnabled() {
        return false;
    }

    default boolean isInUse() {
        return false;
    }

    default boolean isPlayable() {
        return this.isEnabled() && !this.isInUse();
    }

    default Collection<String> getWhitelistedKits() {
        return Collections.emptyList();
    }

    default boolean isWhitelisted(IKit kit) {
        return kit != null && this.isWhitelisted(kit.getName());
    }

    default boolean isWhitelisted(String kitName) {
        return kitName != null && this.getWhitelistedKits().contains(kitName.toLowerCase());
    }

    default String getTypeName() {
        return "UNKNOWN";
    }
}
