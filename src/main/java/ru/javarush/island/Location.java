package ru.javarush.island;

import ru.javarush.animals.Animal;

import ru.javarush.animals.herbivore.*;
import ru.javarush.animals.predator.*;
import ru.javarush.plant.Plant;
import ru.javarush.service.Coordinate;
import ru.javarush.service.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {

    private final int x;
    private final int y;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Location(Coordinate coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
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
        for (int i = 0; i < random(Settings.boarMaxCount); i++) {
            herbivores.add(new Boar(x, y));
        }
        for (int i = 0; i < random(Settings.buffaloMaxCount); i++) {
            herbivores.add(new Buffalo(x, y));
        }
        for (int i = 0; i < random(Settings.caterpillarMaxCount); i++) {
            herbivores.add(new Caterpillar(x, y));
        }
        for (int i = 0; i < random(Settings.deerMaxCount); i++) {
            herbivores.add(new Deer(x, y));
        }
        for (int i = 0; i < random(Settings.duckMaxCount); i++) {
            herbivores.add(new Duck(x, y));
        }
        for (int i = 0; i < random(Settings.goatMaxCount); i++) {
            herbivores.add(new Goat(x, y));
        }
        for (int i = 0; i < random(Settings.horseMaxCount); i++) {
            herbivores.add(new Horse(x, y));
        }
        for (int i = 0; i < random(Settings.mouseMaxCount); i++) {
            herbivores.add(new Mouse(x, y));
        }
        for (int i = 0; i < random(Settings.rabbitMaxCount); i++) {
            herbivores.add(new Rabbit(x, y));
        }
        for (int i = 0; i < random(Settings.sheepMaxCount); i++) {
            herbivores.add(new Sheep(x, y));
        }
    }

    public void addPredatorsToList(){
        for (int i = 0; i < random(Settings.anacondaMaxCount); i++) {
            predators.add(new Anaconda(x, y));
        }
        for (int i = 0; i < random(Settings.bearMaxCount); i++) {
            predators.add(new Bear(x, y));
        }
        for (int i = 0; i < random(Settings.eagleMaxCount); i++) {
            predators.add(new Eagle(x, y));
        }
        for (int i = 0; i < random(Settings.foxMaxCount); i++) {
            predators.add(new Fox(x, y));
        }
        for (int i = 0; i < random(Settings.wolfMaxCount); i++) {
            predators.add(new Wolf(x, y));
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

            List<Predator> predatorsList = new CopyOnWriteArrayList<>(predators);
            List<Herbivore> herbivoresList = new CopyOnWriteArrayList<>(herbivores);

            for (Predator predator : predatorsList) {
                predator.eat(predator, herbivores);
                predator.checkHealth(predators);
            }
            for (Herbivore herbivore : herbivoresList) {
                herbivore.eat(herbivores);
                herbivore.eatPlant(plants);
                herbivore.checkHealth(herbivores);
            }

            } finally {
                this.getLock().unlock();
            }
    }

    public void startReproduct(){
        this.getLock().lock();
        try {
            for (int i = 0; i < randomCount(Settings.boarMaxCount/20); i++) {
                herbivores.add(new Boar(x, y));
            }
            for (int i = 0; i < randomCount(Settings.buffaloMaxCount/20); i++) {
                herbivores.add(new Buffalo(x, y));
            }
            for (int i = 0; i < randomCount(Settings.caterpillarMaxCount/200); i++) {
                herbivores.add(new Caterpillar(x, y));
            }
            for (int i = 0; i < randomCount(Settings.deerMaxCount/20); i++) {
                herbivores.add(new Deer(x, y));
            }
            for (int i = 0; i < randomCount(Settings.duckMaxCount/20); i++) {
                herbivores.add(new Duck(x, y));
            }
            for (int i = 0; i < randomCount(Settings.goatMaxCount/20); i++) {
                herbivores.add(new Goat(x, y));
            }
            for (int i = 0; i < randomCount(Settings.horseMaxCount/20); i++) {
                herbivores.add(new Horse(x, y));
            }
            for (int i = 0; i < randomCount(Settings.mouseMaxCount/20); i++) {
                herbivores.add(new Mouse(x, y));
            }
            for (int i = 0; i < randomCount(Settings.rabbitMaxCount/20); i++) {
                herbivores.add(new Rabbit(x, y));
            }
            for (int i = 0; i < randomCount(Settings.sheepMaxCount/20); i++) {
                herbivores.add(new Sheep(x, y));
            }
            for (int i = 0; i < randomCount(Settings.anacondaMaxCount/20); i++) {
                predators.add(new Anaconda(x, y));
            }
            for (int i = 0; i < randomCount(Settings.bearMaxCount/20); i++) {
                predators.add(new Bear(x, y));
            }
            for (int i = 0; i < randomCount(Settings.eagleMaxCount/20); i++) {
                predators.add(new Eagle(x, y));
            }
            for (int i = 0; i < randomCount(Settings.foxMaxCount/20); i++) {
                predators.add(new Fox(x, y));
            }
            for (int i = 0; i < randomCount(Settings.wolfMaxCount/20); i++) {
                predators.add(new Wolf(x, y));
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
        }
        finally {
            this.getLock().unlock();
        }
        return true;
    }
}
