package com.company;

import com.company.island.Location;
import com.company.plant.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlantGrowther implements Runnable {

    public static int maxCount = 1000;
    private Location location;

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