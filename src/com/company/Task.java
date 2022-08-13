package com.company;

import com.company.island.Island;
import com.company.island.Location;

import java.util.concurrent.BrokenBarrierException;

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
        try {
            try {
                taskRunner();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void taskRunner() throws InterruptedException, BrokenBarrierException {
        if (location.moveAnimals(island.getLocations())) {
            location.eating();
            location.startReproduct();
        }
        island.print();
        //else taskRunner();
    }

//        if (location.eating()) {
//            island.print();
//            location.startReproduct();
//        }
        //location.moveAnimals(island.getLocations());


        //island.print();
        //location.eating();
        //System.out.println("***************************** eat **********************************");
        //island.print();
        //System.out.println("***************************** reproduct **********************************");
        //location.startReproduct();


        //System.out.println("***************************** migrate **********************************");
//        if (location.moveAnimals(island.getLocations())) {
//
//            island.print();
//        }

    }
