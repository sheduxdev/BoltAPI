package xyz.refinedev.practice.api.bot;
import java.util.Collection;
import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.kit.IKit;
/** Main-thread entry points for solo Boxing training. */
public interface BotAPI {
    boolean isBoxingAvailable();
    Collection<IKit> getBoxingKits();
    /** Returns true only when a match has been created; failures are explained to the player. */
    boolean startBoxing(Player player, String kitName, BotDifficulty difficulty);
}
