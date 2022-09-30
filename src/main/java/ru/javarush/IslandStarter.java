package ru.javarush;

import ru.javarush.island.Island;
import ru.javarush.island.Location;
import ru.javarush.service.PlantGrowther;
import ru.javarush.service.Statistics;
import ru.javarush.service.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandStarter{

    public static void main(String[] args) {
        Island island = new Island();
        island.initialize();
        island.print();

        ScheduledExecutorService executorTasks = Executors.newScheduledThreadPool(8);
        ScheduledExecutorService executorPlantGrowth = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executorStatistics = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < island.getLocations().length; i++) {
            for (int j = 0; j < island.getLocations()[i].length; j++) {
                Location location = island.getLocations()[i][j];
                executorTasks.scheduleWithFixedDelay(new Task(location, island), 1, 1, TimeUnit.SECONDS);
                executorPlantGrowth.scheduleWithFixedDelay(new PlantGrowther(location), 2, 3, TimeUnit.SECONDS);
            }
        }
        executorStatistics.scheduleWithFixedDelay(new Statistics(island.getLocations()), 1500, 1000, TimeUnit.MILLISECONDS);


    }
}
