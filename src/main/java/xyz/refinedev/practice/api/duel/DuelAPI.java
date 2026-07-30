package xyz.refinedev.practice.api.duel;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.arena.IArena;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.party.IParty;

import java.util.Collection;
import java.util.Collections;

/**
 * Public access to Bolt's duel request lifecycle.
 */
public interface DuelAPI {

    @Nullable
    IProfileDuelRequest request(Player sender, Player target, IKit kit);

    @Nullable
    default IProfileDuelRequest request(Player sender, Player target, IKit kit, IArena arena) {
        return this.request(sender, target, kit);
    }

    @Nullable
    IPartyDuelRequest request(IParty sender, IParty target, IKit kit);

    @Nullable
    default IPartyDuelRequest request(IParty sender, IParty target, IKit kit, IArena arena) {
        return this.request(sender, target, kit);
    }

    /**
     * Silent variants suppress Bolt's own request feedback so the calling plugin can send its own.
     * Default to the normal behaviour; the Bolt implementation overrides them to run silently. Adding
     * them as defaults keeps existing API consumers binary-compatible.
     */
    @Nullable
    default IProfileDuelRequest requestSilent(Player sender, Player target, IKit kit) {
        return this.request(sender, target, kit);
    }

    @Nullable
    default IPartyDuelRequest requestSilent(IParty sender, IParty target, IKit kit) {
        return this.request(sender, target, kit);
    }

    @Nullable
    IProfileDuelRequest getRequest(Player sender, Player target);

    @Nullable
    IPartyDuelRequest getRequest(IParty sender, IParty target);

    boolean accept(IDuelRequest request);

    boolean cancel(IDuelRequest request);

    default Collection<IDuelRequest> getActiveRequests() {
        return Collections.emptyList();
    }
}
