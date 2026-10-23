package xyz.refinedev.practice.api.stats.view;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Decides which statistics and ping are <b>shown</b> for a player. Game logic (elo changes,
 * matchmaking, ping limits) always uses the real values; only what players read goes through this.
 * <p>
 * Register an implementation in Bukkit's {@link org.bukkit.plugin.ServicesManager} under this class.
 * Bolt uses the highest priority registration; without one every shown value is the real one.
 * A typical implementation masks a disguised player with a generated profile.
 *
 * @version BoltAPI
 * @since 1.2.5
 */
public interface StatsViewProvider {

    /**
     * Identifies the mask currently applied to the player.
     * Bolt rebuilds its cached view whenever the id changes, so a new disguise must return a new id.
     *
     * @param uuid player's real {@link UUID}
     * @return the mask id, or {@code null} when the player's real values are shown
     */
    @Nullable String getMaskId(@NotNull UUID uuid);

    /**
     * Fills the values shown for a masked player. Called once per mask id; Bolt caches the result.
     * Every value starts empty (zero, starting elo), never the real one, so an unset value cannot leak.
     *
     * @param uuid   player's real {@link UUID}
     * @param maskId the id returned by {@link #getMaskId(UUID)}
     * @param mask   the values to fill
     */
    void mask(@NotNull UUID uuid, @NotNull String maskId, @NotNull StatsMask mask);

    /**
     * Ping to show for the player.
     *
     * @param player   the player
     * @param realPing ping the server measured
     * @return ping to display
     */
    int getShownPing(@NotNull Player player, int realPing);
}
