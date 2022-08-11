package com.company.island;

import com.company.animals.herbivore.*;
import com.company.animals.predator.*;

import java.util.Arrays;

public class Island {

    public static int islandLength = 4;
    public static int islandWidth = 4;

    Location[][] locations = new Location[islandLength][islandWidth];

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

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                total = total + locations[i][j].calculate(locations[i][j]);
            }
        }
        System.out.println("Total animal count: " + total);
    }

        public void migrate() {
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    for (int k = 0; k < locations[i][j].getPredators().size(); k++) {
                        locations[i][j].getPredators().get(k).move(locations[i][j], locations);
                    }
                    for (int k = 0; k < locations[i][j].getHerbivores().size(); k++) {
                        locations[i][j].getHerbivores().get(k).move(locations[i][j], locations);
                    }
//                    for (int s = 0; s < locations[i][j].predators.size(); s++) {
//                        locations[i][j].predators.get(s).move();
//                        int[] newCoordinates = locations[i][j].predators.get(s).move();
//                        locations[newCoordinates[0]][newCoordinates[1]].predators.add(locations[i][j].predators.get(s));
//                        locations[i][j].predators.remove(locations[i][j].predators.get(s));
//                    }
                }
            }
        }

        public void hunt(){
            for (Location[] locationLine : locations) {
                for (Location location : locationLine) {
                    location.eating();
                }
            }
        }

        public void reproduct(){
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    locations[i][j].startReproduct();
                }

            }
        }


    }
