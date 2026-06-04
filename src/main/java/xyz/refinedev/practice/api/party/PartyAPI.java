package xyz.refinedev.practice.api.party;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.IMatch;

import java.util.Collection;
import java.util.UUID;

/**
 * Public access to Bolt's party system.
 */
public interface PartyAPI {

    @Nullable
    IParty getParty(UUID uuid);

    @Nullable
    IParty getParty(Player player);

    Collection<IParty> getParties();

    int getPartyCount();

    @Nullable
    default IParty createParty(Player leader) {
        return null;
    }

    default boolean invite(Player sender, Player target) {
        return false;
    }

    default boolean isInvited(IParty party, Player target) {
        return party != null && target != null && party.isInvited(target.getUniqueId());
    }

    default boolean revokeInvite(IParty party, Player target) {
        return false;
    }

    default int clearInvites(Player target) {
        return 0;
    }

    default boolean join(Player player, IParty party) {
        return false;
    }

    default boolean leave(Player player) {
        return false;
    }

    default boolean kick(Player sender, Player target) {
        return false;
    }

    default boolean promote(Player sender, Player target) {
        return false;
    }

    default boolean disband(Player leader) {
        return false;
    }

    default boolean canQueue(IParty party, boolean ranked) {
        return false;
    }

    @Nullable
    default IMatch startFFA(IParty party, IKit kit) {
        return null;
    }

    @Nullable
    default IMatch startSplit(IParty party, IKit kit) {
        return null;
    }

    @Nullable
    default IMatch startMatch(IParty partyA, IParty partyB, IKit kit, boolean ranked) {
        return null;
    }

    default boolean spectatePartyMatch(Player spectator, IParty party) {
        return false;
    }

    default boolean setOpen(IParty party, boolean open) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setOpen(open);
        return settings.isOpen() == open;
    }

    default boolean setAllInvite(IParty party, boolean allInvite) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setAllInvite(allInvite);
        return settings.isAllInvite() == allInvite;
    }

    default boolean setMute(IParty party, boolean mute) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setMute(mute);
        return settings.isMute() == mute;
    }

    default boolean setDuelRequests(IParty party, boolean duelRequests) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setDuelRequests(duelRequests);
        return settings.isDuelRequests() == duelRequests;
    }

    default boolean setLimit(IParty party, int limit) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null || limit < 2 || limit < party.getMembers().size()) {
            return false;
        }

        settings.setLimit(limit);
        return settings.getLimit() == limit;
    }
}
