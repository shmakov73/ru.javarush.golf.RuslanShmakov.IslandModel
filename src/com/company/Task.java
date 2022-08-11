package com.company;

import com.company.island.Island;
import com.company.island.Location;

public class Task implements Runnable {

    private final Location location;
    private final Island island;

    public Task(Location location, Island island) {
        this.location = location;
        this.island = island;
    }

    @Override
    public void run(){
        location.addPlantsToList();
        island.print();
        location.eating();
        island.print();
        location.startReproduct();
        System.out.println("***************************** migrate **********************************");
        location.moveAnimals(island.getLocations());
        island.print();
    }
}
