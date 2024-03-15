package dev.yada.minigameapi;

import dev.yada.minigameapi.events.MinigameEndEvent;
import dev.yada.minigameapi.events.MinigamePreGameEvent;
import dev.yada.minigameapi.events.MinigameStartEvent;
import dev.yada.minigameapi.interfaces.TeleportHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class Minigame {

    @Getter
    List<Player> players;
    @Getter
    int maxPlayers;

    @Getter
    MinigameState gameState;


    public Minigame(int maxPlayers, List<Player> players){
        this.players = players;
        gameState = MinigameState.INITIALIZE;
        this.maxPlayers = maxPlayers;
    }

    public Minigame(int maxPlayers){
        gameState = MinigameState.INITIALIZE;
        this.maxPlayers = maxPlayers;
    }

    public void sendToPreGame(){
        Bukkit.getPluginManager().callEvent(new MinigamePreGameEvent(this));
        gameState = MinigameState.PRE_GAME;
    }

    public void startGame(){
        Bukkit.getPluginManager().callEvent(new MinigameStartEvent(this));
        gameState = MinigameState.STARTED;
    }

    public void endGame(){
        Bukkit.getPluginManager().callEvent(new MinigameEndEvent(this));
        gameState = MinigameState.ENDED;
    }

    public void cleanup(){
        gameState = MinigameState.OVER;
        MinigameHandler.getInstance().cleanupMinigame(this);
    }



}
