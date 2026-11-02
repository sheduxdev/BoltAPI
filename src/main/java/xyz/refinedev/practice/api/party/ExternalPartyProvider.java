package xyz.refinedev.practice.api.party;

import java.util.UUID;
import org.bukkit.entity.Player;

/** Owns membership and settings; Bolt retains responsibility for queues and matches. */
public interface ExternalPartyProvider {
    PartyOpResult perform(Player actor, String action, UUID target, Object value);
    void openMenu(Player player, String section);
    /** Must reject stale, offline or split-server membership before a match/queue begins. */
    boolean canStart(UUID partyId);

    default void sendChat(Player player, String message) { openMenu(player, "chat"); }
}
