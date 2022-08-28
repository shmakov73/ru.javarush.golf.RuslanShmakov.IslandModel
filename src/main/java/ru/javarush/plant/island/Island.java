package ru.javarush.plant.island;

import ru.javarush.service.Statistics;

public class Island {

    public static int islandLength = 4;
    public static int islandWidth = 4;

    public static Location[][] locations = new Location[islandLength][islandWidth];

    public Location[][] getLocations() {
        return locations;
    }

    public void initialize(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                locations[i][j] = new Location();
                locations[i][j].setX(i);
                locations[i][j].setY(j);
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
