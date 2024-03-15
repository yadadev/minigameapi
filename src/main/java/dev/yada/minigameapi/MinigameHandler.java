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

    public void registerMinigame(Minigame minigame){

    }

    protected void cleanupMinigame(Minigame minigame){
        minigames.remove(minigame);
    }

    protected void cleanupAllMinigames(){
        minigames.forEach(this::cleanupMinigame);
    }
}
