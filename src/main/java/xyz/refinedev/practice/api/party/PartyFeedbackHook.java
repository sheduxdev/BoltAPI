package xyz.refinedev.practice.api.party;

import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Opt-in hook letting an external plugin OWN party chat feedback. When a hook is installed via
 * {@link PartyAPI#setFeedbackHook(PartyFeedbackHook)}, Bolt calls the matching method before it
 * would send its own broadcast/notice; if the method returns {@code true}, Bolt stays silent for
 * that event (the hook handled the messaging).
 * <p>
 * No hook installed → Bolt behaves exactly as before, so existing consumers are unaffected. New
 * methods are added as {@code default false} so older hook implementations keep compiling.
 */
public interface PartyFeedbackHook {

    default boolean onCreate(IParty party) {
        return false;
    }

    default boolean onInvite(IParty party, UUID targetId, String targetName) {
        return false;
    }

    default boolean onJoin(IParty party, Player player) {
        return false;
    }

    default boolean onLeave(IParty party, Player player) {
        return false;
    }

    default boolean onKick(IParty party, Player player) {
        return false;
    }

    default boolean onPromote(IParty party, UUID oldLeaderId, Player newLeader) {
        return false;
    }

    default boolean onDisband(IParty party) {
        return false;
    }
}
