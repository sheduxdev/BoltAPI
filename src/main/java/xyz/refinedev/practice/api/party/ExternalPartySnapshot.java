package xyz.refinedev.practice.api.party;

import java.util.*;

/** Immutable authoritative network membership. Bolt stores only a match projection of it. */
public final class ExternalPartySnapshot {
    private final UUID id, leader;
    private final String leaderName;
    private final Set<UUID> members;
    private final boolean open, allInvite, mute, duelRequests;
    private final int limit;
    public ExternalPartySnapshot(UUID id, UUID leader, String leaderName, Collection<UUID> members,
            boolean open, boolean allInvite, boolean mute, boolean duelRequests, int limit) {
        this.id = Objects.requireNonNull(id); this.leader = Objects.requireNonNull(leader);
        this.leaderName = Objects.requireNonNull(leaderName);
        this.members = Collections.unmodifiableSet(new LinkedHashSet<>(members));
        if (!this.members.contains(leader)) throw new IllegalArgumentException("Leader must be a member");
        this.open=open; this.allInvite=allInvite; this.mute=mute; this.duelRequests=duelRequests;
        this.limit=Math.max(limit, this.members.size());
    }
    public UUID getId() { return id; }
    public UUID getLeader() { return leader; }
    public String getLeaderName() { return leaderName; }
    public Set<UUID> getMembers() { return members; }
    public boolean isOpen() { return open; }
    public boolean isAllInvite() { return allInvite; }
    public boolean isMute() { return mute; }
    public boolean isDuelRequests() { return duelRequests; }
    public int getLimit() { return limit; }
}
