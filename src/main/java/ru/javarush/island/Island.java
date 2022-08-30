package ru.javarush.island;

import ru.javarush.service.Coordinate;
import ru.javarush.service.Settings;
import ru.javarush.service.Statistics;

public class Island {

    public static int islandLength = Settings.islandLength;
    public static int islandWidth = Settings.islandWidth;

    public static Location[][] locations = new Location[islandLength][islandWidth];

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

        public void migrate() {
            for (Location[] location : locations) {
                for (Location value : location) {
                    value.moveAnimals(locations);
                }
            }
        }

        public void hunt() {
            for (Location[] location : locations) {
                for (Location value : location) {
                    value.eating();
                }
            }
        }

        public void reproduct(){
            for (Location[] location : locations) {
                for (Location value : location) {
                    value.startReproduct();
                }

            }
        }


    }
