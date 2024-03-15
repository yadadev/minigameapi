package dev.yada.minigameapi;

import lombok.Getter;

import java.util.ArrayList;

public class MinigameHandler {

    @Getter
    static MinigameHandler instance;


    public ArrayList<Minigame> minigames = new ArrayList<>();

    public MinigameHandler(){
        instance = this;
    }

    public Minigame registerMinigame(Minigame minigame){
        minigames.add(minigame);
        return minigame;
    }

    protected void cleanupMinigame(Minigame minigame){
        minigames.remove(minigame);
    }

    protected void cleanupAllMinigames(){
        minigames.forEach(this::cleanupMinigame);
    }
}
