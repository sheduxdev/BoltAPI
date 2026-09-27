package xyz.refinedev.practice.api.profile.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.profile.IProfile;

/** Fired synchronously after the native hotbar is applied. Addons may fill reserved slots. */
@Getter
@RequiredArgsConstructor
public class ProfileHotbarRefreshEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final IProfile profile;
    public static HandlerList getHandlerList() { return handlers; }
    @Override public HandlerList getHandlers() { return handlers; }
}
