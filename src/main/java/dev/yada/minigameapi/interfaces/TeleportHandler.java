package dev.yada.minigameapi.interfaces;

import dev.yada.minigameapi.Minigame;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface TeleportHandler {

    default void teleport(List<Location> spawnLocations, Minigame minigame){
        if (spawnLocations.isEmpty()) return;
        List<Location> availableLocations = new ArrayList<>();
        spawnLocations.addAll(availableLocations);

        minigame.getPlayers().forEach(player -> {
            Location chosenLocation = availableLocations.get(new Random().nextInt(0, availableLocations.size()-1));
            availableLocations.remove(chosenLocation);
            player.teleport(chosenLocation);
        });
    }
}
