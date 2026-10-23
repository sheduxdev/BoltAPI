package xyz.refinedev.practice.api.stats.view;

import org.jetbrains.annotations.NotNull;

import xyz.refinedev.practice.api.stats.IStatsCache;

import java.util.Map;

/**
 * Values a {@link StatsViewProvider} fills for a masked player. Totals, ratios, the global elo and the
 * division are derived by Bolt from the per-kit values, the same way they are for real profiles.
 *
 * @version BoltAPI
 * @since 1.2.5
 */
public interface StatsMask {

    /**
     * Empty per-kit statistics to fill, one for every kit, keyed by lower-case kit name.
     *
     * @return kit name → statistics to show
     */
    @NotNull Map<String, IStatsCache> getKitStats();

    /**
     * @param kitName lower-case kit name, as in {@link #getKitStats()}
     * @return whether the kit is ranked (has an elo)
     */
    boolean isRanked(@NotNull String kitName);

    /**
     * @param experience experience to show (decides the shown level)
     */
    void setExperience(int experience);

    /**
     * @param eventWins event wins to show
     */
    void setEventWins(int eventWins);

    /**
     * @param coins coin balance to show in statistics (purchases keep using the real balance)
     */
    void setCoins(int coins);
}
