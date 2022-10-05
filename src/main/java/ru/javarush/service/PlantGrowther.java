package ru.javarush.service;

import ru.javarush.island.Location;
import ru.javarush.plant.Plant;

import java.util.concurrent.ThreadLocalRandom;

public class PlantGrowther implements Runnable {

    public static int maxCount = Plant.maxCount;
    private final Location location;

    public PlantGrowther(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        growPlant();
    }

    public void growPlant(){
        for (int i = 0; i < random(maxCount); i++) {
            location.getPlants().add(new Plant(1));
        }
    }

    private int random(int maxCount){
        return ThreadLocalRandom.current().nextInt(maxCount);
    }
}
