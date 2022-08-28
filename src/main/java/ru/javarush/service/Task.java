package ru.javarush.service;

import ru.javarush.plant.island.Island;
import ru.javarush.plant.island.Location;

public class Task implements Runnable {

    private final Location location;
    private final Island island;

    public Task(Location location, Island island) {
        this.location = location;
        this.island = island;
        location.addPlantsToList();
    }

    @Override
    public void run() {
        taskRunner();
    }

    private void taskRunner(){
        if (location.moveAnimals(island.getLocations())) {
            location.eating();
            location.startReproduct();
        }
        //island.print();
    }

    }
