package com.company;

import com.company.animals.herbivore.*;
import com.company.animals.predator.*;
import com.company.island.Island;
import com.company.island.Location;

public class Statistics implements Runnable {

    Location[][] locations;

    public Statistics(Location[][] locations) {
        this.locations = locations;
    }

    @Override
    public void run() {

        int total = 0;

        for (Location[] location : locations) {
            for (Location value : location) {
                value.getLock().lock();
                try {
                    total = total + calculate(value);
                } finally {
                    value.getLock().unlock();
                }

            }
        }
        System.out.println("Total animal count: " + total);
        System.out.println("***********************************************************************************");
        System.out.println();

    }

    public int calculate(Location location){
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

        for (int k = 0; k < location.getHerbivores().size(); k++) {
            if (location.getHerbivores().get(k) instanceof Boar) boar++;
            if (location.getHerbivores().get(k) instanceof Buffalo) buffalo++;
            if (location.getHerbivores().get(k) instanceof Caterpillar) caterpillar++;
            if (location.getHerbivores().get(k) instanceof Deer) deer++;
            if (location.getHerbivores().get(k) instanceof Duck) duck++;
            if (location.getHerbivores().get(k) instanceof Goat) goat++;
            if (location.getHerbivores().get(k) instanceof Horse) horse++;
            if (location.getHerbivores().get(k) instanceof Mouse) mouse++;
            if (location.getHerbivores().get(k) instanceof Rabbit) rabbit++;
            if (location.getHerbivores().get(k) instanceof Sheep) sheep++;
        }
        for (int k = 0; k < location.getPredators().size(); k++) {
            if (location.getPredators().get(k) instanceof Anaconda) anaconda++;
            if (location.getPredators().get(k) instanceof Bear) bear++;
            if (location.getPredators().get(k) instanceof Eagle) eagle++;
            if (location.getPredators().get(k) instanceof Fox) fox++;
            if (location.getPredators().get(k) instanceof Wolf) wolf++;
        }

        System.out.print("Total animal count on location : " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf));
        System.out.print("  Herbivores: " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep));
        System.out.println("  Predators: " + (anaconda + bear + eagle + fox + wolf));
        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);
    }
}