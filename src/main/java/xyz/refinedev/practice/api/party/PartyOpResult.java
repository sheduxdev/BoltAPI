package xyz.refinedev.practice.api.party;

/**
 * Outcome of a party operation requested through {@link PartyAPI}'s {@code try*} methods.
 * <p>
 * The {@code try*} family never sends chat feedback; callers translate these reasons into
 * their own messages. New constants may be added in future versions — callers should treat
 * unknown values like {@link #UNKNOWN_FAILURE}.
 */
public enum PartyOpResult {

    SUCCESS,

    // general
    /** The acting player has no party. */
    NO_PARTY,
    /** The acting player is not the party leader (and the action requires it). */
    NOT_LEADER,
    /** The acting player targeted themselves. */
    SELF_TARGET,
    /** The target player is offline or could not be resolved. */
    TARGET_OFFLINE,

    // invite
    /** The sender is not in the lobby (in match, queue, tournament, ...). */
    SENDER_NOT_IN_LOBBY,
    /** The target has party requests disabled in their settings. */
    TARGET_NOT_ACCEPTING,
    /** The target is not in the lobby, is following someone, or is in a tournament. */
    TARGET_BUSY,
    /** The target is already in a party. */
    TARGET_IN_PARTY,
    /** The target already has a pending invite to this party. */
    ALREADY_INVITED,
    /** The party is at its member limit. */
    PARTY_FULL,

    // join
    /** The joining player is already in a party (possibly this one). */
    ALREADY_IN_PARTY,
    /** The party is invite-only and the player has no pending invite. */
    NOT_INVITED,
    /** The party is busy (queueing or in a tournament). */
    PARTY_BUSY,
    /** The referenced party no longer exists or the target left it. */
    PARTY_EXPIRED,
    /** The joining player is busy (queue, match, tournament, following). */
    JOINER_BUSY,

    // leave
    /** The party leader cannot leave their own party; they must disband or promote first. */
    LEADER_CANNOT_LEAVE,

    // kick / promote
    /** The target is not a member of the acting player's party. */
    NOT_MEMBER,

    /** The operation failed for a reason this API version cannot express. */
    UNKNOWN_FAILURE;

    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
