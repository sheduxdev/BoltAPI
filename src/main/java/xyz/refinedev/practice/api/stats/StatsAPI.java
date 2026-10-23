package xyz.refinedev.practice.api.stats;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.ToIntFunction;

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
public interface StatsAPI {

    /**
     * Get the stats profile of a player
     *
     * @param player {@link Player} to get the stats profile of
     * @return {@link IStatsProfile} of the player
     */
    IStatsProfile getStatsProfile(Player player);

    /**
     * Get the stats profile of a player by their UUID.
     * If the player is online, this will return the same instance as {@link #getStatsProfile(Player)}.
     * Otherwise, it will fetch the data from the database asynchronously.
     *
     * @param uuid {@link UUID} to get the stats profile of
     * @return {@link CompletableFuture} of the player's {@link IStatsProfile}
     */
    CompletableFuture<IStatsProfile> getStatsProfile(UUID uuid);

    /**
     * Save the stats profile of a player.
     *
     * @param statsProfile {@link IStatsProfile} to save
     * @param async        whether to save the stats profile asynchronously or not
     */
    void saveStatsProfile(IStatsProfile statsProfile, boolean async);

    /**
     * Replace the formula that turns a profile's kit elos into its global elo.
     * Bolt applies it wherever it recalculates a global elo: after ranked matches,
     * elo commands and when a profile loads. A formula that throws falls back to the default.
     *
     * @param formula profile → global elo, or {@code null} for the default (average elo of the ranked kits)
     */
    void setGlobalEloFormula(@Nullable ToIntFunction<IStatsProfile> formula);

    /**
     * Recalculate every saved profile's global elo with the current formula and store it,
     * so leaderboards and positions match after the formula changes. Online profiles are
     * recalculated on the main thread and saved as usual.
     *
     * @return {@link CompletableFuture} with the number of stored profiles whose global elo changed
     */
    CompletableFuture<Integer> recalculateGlobalElo();

    /**
     * The statistics to <b>show</b> for an online player: a detached, generated profile while a
     * {@link xyz.refinedev.practice.api.stats.view.StatsViewProvider} masks the player (e.g. disguised),
     * otherwise the same instance as {@link #getStatsProfile(Player)}. Never modify or save the result.
     *
     * @param player {@link Player} to get the shown statistics of
     * @return {@link IStatsProfile} to display, {@code null} if the player's statistics are not loaded
     * @since 1.2.5
     */
    @Nullable
    default IStatsProfile getShownStatsProfile(Player player) {
        return getStatsProfile(player);
    }

    /**
     * Whether the values shown for the player are masked (not the real ones).
     *
     * @param uuid player's real {@link UUID}
     * @return {@code true} while a {@link xyz.refinedev.practice.api.stats.view.StatsViewProvider} masks the player
     * @since 1.2.5
     */
    default boolean isMasked(UUID uuid) {
        return false;
    }

    /**
     * The ping to <b>show</b> for an online player, masked the same way as {@link #getShownStatsProfile(Player)}.
     *
     * @param player {@link Player}
     * @return ping in milliseconds to display
     * @since 1.2.5
     */
    default int getShownPing(Player player) {
        return 0;
    }

    //TODO: Leaderboards
}
