package ru.javarush.island;

import ru.javarush.service.Coordinate;
import ru.javarush.service.Settings;
import ru.javarush.service.Statistics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Island {

    public static int islandLength = Settings.islandLength;
    public static int islandWidth = Settings.islandWidth;

    public static Location[][] locations = new Location[islandLength][islandWidth];
    private final Lock lock = new ReentrantLock(true);
    public Lock getLock() {
        return lock;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void initialize(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                locations[i][j] = new Location(new Coordinate(i, j));
                locations[i][j].addHerbivoresToList();
                locations[i][j].addPredatorsToList();
                locations[i][j].addPlantsToList();
            }
        }
    }

    public void print() {
        int total = 0;
        Statistics statistics = new Statistics(locations);
        for (Location[] location : locations) {
            for (Location value : location) {
                value.getLock().lock();
                try {
                    total = total + statistics.calculate(value);
                } finally {
                    value.getLock().unlock();
                }

            }
        }
        System.out.println("Total animal count: " + total);
    }
    }
