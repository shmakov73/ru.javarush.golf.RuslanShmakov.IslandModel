package com.company.island;

import com.company.animals.herbivore.*;
import com.company.animals.predator.*;

import java.util.Arrays;

public class Island {

    Location[][] locations = new Location[5][5];

    public void initialize(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
                locations[i][j].addHerbivoresToList(i, j, locations.length, locations[i].length);
                locations[i][j].addPredatorsToList(i, j, locations.length, locations[i].length);
            }
        }
    }

    public void print() {

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].calculate(locations[i][j]);
            }
        }
    }

        public void migrate() {
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    for (int s = 0; s < locations[i][j].herbivores.size(); s++) {
                        locations[i][j].herbivores.get(s).move();
                        int[] newCoordinates = locations[i][j].herbivores.get(s).move();
                        locations[newCoordinates[0]][newCoordinates[1]].herbivores.add(locations[i][j].herbivores.get(s));
                        locations[i][j].herbivores.remove(locations[i][j].herbivores.get(s));
                    }
                    for (int s = 0; s < locations[i][j].predators.size(); s++) {
                        locations[i][j].predators.get(s).move();
                        int[] newCoordinates = locations[i][j].predators.get(s).move();
                        locations[newCoordinates[0]][newCoordinates[1]].predators.add(locations[i][j].predators.get(s));
                        locations[i][j].predators.remove(locations[i][j].predators.get(s));
                    }
                }
            }
        }


    }
