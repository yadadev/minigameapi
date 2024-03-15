package dev.yada.minigameapi.events;

import dev.yada.minigameapi.Minigame;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class MinigameEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    @Getter
    Minigame minigame;

    public MinigameEvent(Minigame minigame){
        this.minigame = minigame;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
