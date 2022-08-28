package ru.javarush.island;

import ru.javarush.animals.Animal;

import ru.javarush.animals.herbivore.*;
import ru.javarush.animals.predator.*;
import ru.javarush.plant.Plant;

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
        for (int i = 0; i < random(Boar.maxCount); i++) {
            herbivores.add(new Boar(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Buffalo.maxCount); i++) {
            herbivores.add(new Buffalo(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Caterpillar.maxCount); i++) {
            herbivores.add(new Caterpillar(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Deer.maxCount); i++) {
            herbivores.add(new Deer(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Duck.maxCount); i++) {
            herbivores.add(new Duck(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Goat.maxCount); i++) {
            herbivores.add(new Goat(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Horse.maxCount); i++) {
            herbivores.add(new Horse(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Mouse.maxCount); i++) {
            herbivores.add(new Mouse(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Rabbit.maxCount); i++) {
            herbivores.add(new Rabbit(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Sheep.maxCount); i++) {
            herbivores.add(new Sheep(x, y, xLength, yLength));
        }
    }

    public void addPredatorsToList(){
        for (int i = 0; i < random(Anaconda.maxCount); i++) {
            predators.add(new Anaconda(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Bear.maxCount); i++) {
            predators.add(new Bear(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Eagle.maxCount); i++) {
            predators.add(new Eagle(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Fox.maxCount); i++) {
            predators.add(new Fox(x, y, xLength, yLength));
        }
        for (int i = 0; i < random(Wolf.maxCount); i++) {
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

    private int random(int animalCount){
        return ThreadLocalRandom.current().nextInt(animalCount);
    }

    private int randomCount (int animalCount){
        int returnNumber;
        if (animalCount >= 2) {
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
