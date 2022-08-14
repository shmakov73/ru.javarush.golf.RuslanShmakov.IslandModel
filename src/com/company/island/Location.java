package com.company.island;

import com.company.animals.Animal;
import com.company.animals.herbivore.*;
import com.company.animals.predator.*;
import com.company.plant.Plant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    private int x;
    private int y;
    private final int xLength = Island.islandLength;
    private final int yLength = Island.islandWidth;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Location() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private final List<Herbivore> herbivores = new ArrayList<>();
    private final List<Predator> predators = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public List<Predator> getPredators() {
        return predators;
    }

    public List<Plant> getPlants() {
        return plants;
    }


    public void addHerbivoresToList(){
        for (int i = 0; i < randomCount(Boar.maxCount); i++) {
            herbivores.add(new Boar(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Buffalo.maxCount); i++) {
            herbivores.add(new Buffalo(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Caterpillar.maxCount); i++) {
            herbivores.add(new Caterpillar(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Deer.maxCount); i++) {
            herbivores.add(new Deer(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Duck.maxCount); i++) {
            herbivores.add(new Duck(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Goat.maxCount); i++) {
            herbivores.add(new Goat(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Horse.maxCount); i++) {
            herbivores.add(new Horse(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Mouse.maxCount); i++) {
            herbivores.add(new Mouse(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Rabbit.maxCount); i++) {
            herbivores.add(new Rabbit(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Sheep.maxCount); i++) {
            herbivores.add(new Sheep(x, y, xLength, yLength));
        }
    }

    public void addPredatorsToList(){
        for (int i = 0; i < randomCount(Anaconda.maxCount); i++) {
            predators.add(new Anaconda(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Bear.maxCount); i++) {
            predators.add(new Bear(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Eagle.maxCount); i++) {
            predators.add(new Eagle(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Fox.maxCount); i++) {
            predators.add(new Fox(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(Wolf.maxCount); i++) {
            predators.add(new Wolf(x, y, xLength, yLength));
        }
    }

    public void addAnimal(Animal animal){
        if (animal instanceof Predator){
            predators.add((Predator) animal);
        }
        if (animal instanceof Herbivore){
            herbivores.add((Herbivore) animal);
        }
    }

    public void addPlantsToList(){
        for (int i = 0; i < 10000; i++) {
            plants.add(new Plant(1));
        }
    }

//    public int calculate(Location location){
//        int boar = 0;
//        int buffalo = 0;
//        int caterpillar = 0;
//        int deer = 0;
//        int duck = 0;
//        int goat = 0;
//        int horse = 0;
//        int mouse = 0;
//        int rabbit = 0;
//        int sheep = 0;
//        int anaconda = 0;
//        int bear = 0;
//        int eagle = 0;
//        int fox = 0;
//        int wolf = 0;
//
//        for (int k = 0; k < location.herbivores.size(); k++) {
//            if (location.herbivores.get(k) instanceof Boar) boar++;
//            if (location.herbivores.get(k) instanceof Buffalo) buffalo++;
//            if (location.herbivores.get(k) instanceof Caterpillar) caterpillar++;
//            if (location.herbivores.get(k) instanceof Deer) deer++;
//            if (location.herbivores.get(k) instanceof Duck) duck++;
//            if (location.herbivores.get(k) instanceof Goat) goat++;
//            if (location.herbivores.get(k) instanceof Horse) horse++;
//            if (location.herbivores.get(k) instanceof Mouse) mouse++;
//            if (location.herbivores.get(k) instanceof Rabbit) rabbit++;
//            if (location.herbivores.get(k) instanceof Sheep) sheep++;
//        }
//        for (int k = 0; k < location.predators.size(); k++) {
//            if (location.predators.get(k) instanceof Anaconda) anaconda++;
//            if (location.predators.get(k) instanceof Bear) bear++;
//            if (location.predators.get(k) instanceof Eagle) eagle++;
//            if (location.predators.get(k) instanceof Fox) fox++;
//            if (location.predators.get(k) instanceof Wolf) wolf++;
//        }
//
//        System.out.print("Total animal count on location : " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf));
//        System.out.print("  Herbivores: " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep));
//        System.out.println("  Predators: " + (anaconda + bear + eagle + fox + wolf));
//        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);
//    }
    public void eating(){
        this.getLock().lock();
        try {
            Iterator<Predator> iterator = predators.iterator();
            Predator nextPredator = iterator.next();
            nextPredator.eat(nextPredator, herbivores);
            nextPredator.checkHealth(predators);

            Iterator<Herbivore> iterator1 = herbivores.iterator();
            Herbivore nextHerbivore = iterator1.next();
            nextHerbivore.eat(herbivores);
            nextHerbivore.eatPlant(plants);
            nextHerbivore.checkHealth(herbivores);
        }
        finally {
            this.getLock().unlock();
        }
    }

    public void startReproduct(){
        this.getLock().lock();
        try {
            for (int i = 0; i < randomCount(Boar.maxCount/100); i++) {
                herbivores.add(new Boar(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Buffalo.maxCount/100); i++) {
                herbivores.add(new Buffalo(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Caterpillar.maxCount/100); i++) {
                herbivores.add(new Caterpillar(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Deer.maxCount/100); i++) {
                herbivores.add(new Deer(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Duck.maxCount/100); i++) {
                herbivores.add(new Duck(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Goat.maxCount/100); i++) {
                herbivores.add(new Goat(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Horse.maxCount/100); i++) {
                herbivores.add(new Horse(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Mouse.maxCount/100); i++) {
                herbivores.add(new Mouse(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Rabbit.maxCount/100); i++) {
                herbivores.add(new Rabbit(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Sheep.maxCount/100); i++) {
                herbivores.add(new Sheep(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Anaconda.maxCount/4); i++) {
                predators.add(new Anaconda(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Bear.maxCount/4); i++) {
                predators.add(new Bear(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Eagle.maxCount/4); i++) {
                predators.add(new Eagle(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Fox.maxCount/4); i++) {
                predators.add(new Fox(x, y, xLength, yLength));
            }
            for (int i = 0; i < randomCount(Wolf.maxCount/4); i++) {
                predators.add(new Wolf(x, y, xLength, yLength));
            }
            for (Herbivore herbivore : herbivores) {
                herbivore.hunger();
            }
            for (Predator predator : predators) {
                predator.hunger();
            }
        }
        finally {
            this.getLock().unlock();
        }
    }

    private int randomCount (int animalCount){
        int returnNumber;
        if (animalCount > 2) {
            returnNumber = ThreadLocalRandom.current().nextInt(animalCount);
        }
        else returnNumber = 0;
        return returnNumber;
    }

    public boolean moveAnimals(Location[][] locations){
        this.getLock().lock();
        try {
            List<Predator> predatorsList = new CopyOnWriteArrayList<>(predators);
            List<Herbivore> herbivoresList = new CopyOnWriteArrayList<>(herbivores);

            for (Predator predator : predatorsList) {
                predator.move(this, locations);
            }
            for (Herbivore herbivore : herbivoresList) {
                herbivore.move(this, Island.locations);
            }
            //calculate(this);
        }
        finally {
            this.getLock().unlock();
        }
        return true;
    }
}
