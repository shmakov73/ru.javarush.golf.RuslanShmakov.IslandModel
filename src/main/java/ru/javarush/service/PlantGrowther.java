package ru.javarush.service;

import ru.javarush.plant.island.Location;
import ru.javarush.plant.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlantGrowther implements Runnable {

    public static int maxCount = 10000;
    private final Location location;

    public PlantGrowther(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        growPlant();
    }

    public void growPlant(){
        List<Plant> plants = location.getPlants();
        for (int i = 0; i < random(maxCount); i++) {
            location.getPlants().add(new Plant(1));
        }
    }

    private int random(int maxCount){
        return ThreadLocalRandom.current().nextInt(maxCount);
    }
}
