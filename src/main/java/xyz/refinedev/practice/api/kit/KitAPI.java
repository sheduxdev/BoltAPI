package xyz.refinedev.practice.api.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.queue.IQueue;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
public interface KitAPI {

    /**
     * Create a new Kit Builder instance
     *
     * @return {@link IKitBuilder} instance
     */
    IKitBuilder builder();

    /**
     * Save all kits to the storage asynchronously.
     */
    void save();

    /**
     * Register a kit to the storage. This will also handle
     * creation of the {@link IQueue}s for all valid types.
     *
     * @param kit  {@link IKit} to register
     * @param save Should the kit also be saved?
     */
    void registerKit(@NotNull IKit kit, boolean save);

    /**
     * Unregister a kit from the storage. This will also handle
     * removal of all {@link IQueue}s associated with the kit.
     *
     * @param kit {@link IKit}
     */
    void unregisterKit(@NotNull IKit kit);

    /**
     * Get a kit by name
     *
     * @param name of the kit
     * @return {@link IKit} if found, null otherwise
     */
    @Nullable IKit getKit(@NotNull String name);

    /**
     * Get all registered kits
     *
     * @return {@link List} of {@link IKit}
     */
    List<IKit> getKits();

    /**
     * Check if a player has any custom inventories for a specific kit.
     *
     * @param player to check
     * @param kit    to check
     * @return true if the player has custom inventories, false otherwise
     */
    boolean hasCustomInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Get all custom inventories a player has for a specific kit.
     * Returns null if the player has no custom inventories for the kit.
     *
     * @param player to get for
     * @param kit    to get for
     * @return       {@link IKitInventory} array if the player has custom inventories, empty array
     *                                    if none exist, null if the player has no custom inventories for the kit
     */
    @Nullable IKitInventory[] getKitInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Wipe all custom inventories a player has for a specific kit.
     * This will remove all custom inventories from memory and storage.
     *
     * @param player to wipe for
     * @param kit    to wipe for
     */
    void wipeCustomInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Wipe all custom inventories a player has for every kit.
     *
     * @param player to wipe for
     */
    default void wipeCustomInventories(@NotNull Player player) {
    }

    /**
     * Wipe all custom inventories for all players for a specific kit.
     * This will remove all custom inventories from memory and storage.
     *
     * @param kit to wipe for
     * @return    {@link CompletableFuture} with the number of wiped inventories
     */
    CompletableFuture<Long> wipeKitsForKit(@NotNull IKit kit);

    /**
     * Wipe all custom inventories for every player and every kit.
     *
     * @return {@link CompletableFuture} with the number of wiped player documents
     */
    default CompletableFuture<Long> wipeAllCustomInventories() {
        return CompletableFuture.completedFuture(0L);
    }

    /**
     * Get the selection items for a player for a specific kit.
     * This will return the items that will be given to the player.
     * If not custom inventories exist, it will return the default item on the 0 index.
     * Otherwise, the default item will appear on 8th index.
     *
     * @param player to get for
     * @param kit    to get for
     * @return       {@link Map} of slot to {@link ItemStack}
     */
    Map<Integer, ItemStack> getSelectionItems(@NotNull Player player, @NotNull IKit kit);

    /**
     * Get the maximum amount of custom inventories a player can create per kit.
     *
     * @return maximum custom inventory count
     */
    default int getMaxCustomInventories() {
        return 5;
    }

    /**
     * Get a single custom inventory by slot.
     *
     * @param player to get for
     * @param kit    to get for
     * @param slot   zero-based custom inventory slot
     * @return       {@link IKitInventory} if found, null otherwise
     */
    @Nullable
    default IKitInventory getKitInventory(@NotNull Player player, @NotNull IKit kit, int slot) {
        IKitInventory[] inventories = this.getKitInventories(player, kit);
        if (inventories == null || slot < 0 || slot >= inventories.length) return null;
        return inventories[slot];
    }

    /**
     * Create a custom kit inventory from the kit defaults.
     *
     * @param player to create for
     * @param kit    to create for
     * @param slot   zero-based custom inventory slot
     * @param name   optional custom name
     * @return       true when created, false when invalid or already present
     */
    default boolean createKitInventory(@NotNull Player player, @NotNull IKit kit, int slot, @Nullable String name) {
        return false;
    }

    /**
     * Save the contents of a custom kit inventory.
     *
     * @param player   to save for
     * @param kit      to save for
     * @param slot     zero-based custom inventory slot
     * @param contents inventory contents
     * @return         true when saved, false when invalid
     */
    default boolean saveKitInventory(@NotNull Player player, @NotNull IKit kit, int slot, @NotNull ItemStack[] contents) {
        return false;
    }

    /**
     * Rename a custom kit inventory.
     *
     * @param player to rename for
     * @param kit    to rename for
     * @param slot   zero-based custom inventory slot
     * @param name   new custom name
     * @return       true when renamed, false when invalid
     */
    default boolean renameKitInventory(@NotNull Player player, @NotNull IKit kit, int slot, @NotNull String name) {
        return false;
    }

    /**
     * Delete a custom kit inventory.
     *
     * @param player to delete for
     * @param kit    to delete for
     * @param slot   zero-based custom inventory slot
     * @return       true when deleted, false when invalid or empty
     */
    default boolean deleteKitInventory(@NotNull Player player, @NotNull IKit kit, int slot) {
        return false;
    }

    /**
     * Open Bolt's native custom kit slot manager for a kit.
     *
     * @param player to open for
     * @param kit    to manage
     * @return       true when opened, false when invalid
     */
    default boolean openKitEditManageMenu(@NotNull Player player, @NotNull IKit kit) {
        return false;
    }

    /**
     * Open Bolt's native kit editor for a custom inventory slot.
     *
     * @param player          to open for
     * @param kit             to edit
     * @param slot            zero-based custom inventory slot
     * @param createIfMissing create a default inventory when the slot is empty
     * @return                true when opened, false when invalid
     */
    default boolean openKitEditor(@NotNull Player player, @NotNull IKit kit, int slot, boolean createIfMissing) {
        return false;
    }
}
