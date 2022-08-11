package com.company;

import com.company.island.Island;
import com.company.island.Location;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandStarter extends Thread {

    public static void main(String[] args) {
        Island island = new Island();
        island.initialize();
        island.print();

        ScheduledExecutorService executorTasks = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorPlantGrowth = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                Location location = island.getLocations()[i][j];
                executorTasks.scheduleWithFixedDelay(new Task(location, island), 1, 1, TimeUnit.SECONDS);
                executorPlantGrowth.scheduleWithFixedDelay(new PlantGrowther(location), 2, 3, TimeUnit.SECONDS);
            }
        }


    }
}
