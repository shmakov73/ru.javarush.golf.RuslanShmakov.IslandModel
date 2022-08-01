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

    public void print(){

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int boar = 0;
                int buffalo = 0;
                int caterpillar = 0;
                int deer = 0;
                int duck = 0;
                int goat = 0;
                int horse = 0;
                int mouse = 0;
                int rabbit = 0;
                int sheep = 0;
                int anaconda = 0;
                int bear = 0;
                int eagle = 0;
                int fox = 0;
                int wolf = 0;
                for (int k = 0; k < locations[i][j].herbivores.size(); k++) {
                    if (locations[i][j].herbivores.get(k) instanceof Boar) boar++;
                    if (locations[i][j].herbivores.get(k) instanceof Buffalo) buffalo++;
                    if (locations[i][j].herbivores.get(k) instanceof Caterpillar) caterpillar++;
                    if (locations[i][j].herbivores.get(k) instanceof Deer) deer++;
                    if (locations[i][j].herbivores.get(k) instanceof Duck) duck++;
                    if (locations[i][j].herbivores.get(k) instanceof Goat) goat++;
                    if (locations[i][j].herbivores.get(k) instanceof Horse) horse++;
                    if (locations[i][j].herbivores.get(k) instanceof Mouse) mouse++;
                    if (locations[i][j].herbivores.get(k) instanceof Rabbit) rabbit++;
                    if (locations[i][j].herbivores.get(k) instanceof Sheep) sheep++;
                }
                for (int k = 0; k < locations[i][j].predators.size(); k++) {
                    if (locations[i][j].predators.get(k) instanceof Anaconda) anaconda++;
                    if (locations[i][j].predators.get(k) instanceof Bear) bear++;
                    if (locations[i][j].predators.get(k) instanceof Eagle) eagle++;
                    if (locations[i][j].predators.get(k) instanceof Fox) fox++;
                    if (locations[i][j].predators.get(k) instanceof Wolf) wolf++;
                }
                System.out.println("boar " + boar + "| |");
                System.out.println("buffalo " + buffalo + "| |");
                System.out.println("caterpillar " + caterpillar + "| |");
                System.out.println("deer " + deer + "| |");
                System.out.println("duck " + duck + "| |");
                System.out.println("goat " + goat + "| |");
                System.out.println("horse " + horse + "| |");
                System.out.println("mouse " + mouse + "| |");
                System.out.println("rabbit " + rabbit + "| |");
                System.out.println("sheep " + sheep + "| |");
                System.out.println("anaconda " + anaconda + "| |");
                System.out.println("bear " + bear + "| |");
                System.out.println("eagle " + eagle + "| |");
                System.out.println("fox " + fox + "| |");
                System.out.println("wolf " + wolf + "| |");

                //System.out.print(locations[i][j]);
                System.out.println();
            }

        }
    }

    public void migrate(){
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
