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
    private int xLength = Island.islandLength;
    private int yLength = Island.islandWidth;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Location() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    public List<Herbivore> herbivores = new ArrayList<>();
    public List<Predator> predators = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public List<Predator> getPredators() {
        return predators;
    }

    public void setPredators(List<Predator> predators) {
        this.predators = predators;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

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
        for (int i = 0; i < randomCount(Plant.maxCount); i++) {
            plants.add(new Plant(1));
        }
    }

    public int calculate(Location location){
        boar = 0;
        buffalo = 0;
        caterpillar = 0;
        deer = 0;
        duck = 0;
        goat = 0;
        horse = 0;
        mouse = 0;
        rabbit = 0;
        sheep = 0;
        anaconda = 0;
        bear = 0;
        eagle = 0;
        fox = 0;
        wolf = 0;

        for (int k = 0; k < location.herbivores.size(); k++) {
            if (location.herbivores.get(k) instanceof Boar) boar++;
            if (location.herbivores.get(k) instanceof Buffalo) buffalo++;
            if (location.herbivores.get(k) instanceof Caterpillar) caterpillar++;
            if (location.herbivores.get(k) instanceof Deer) deer++;
            if (location.herbivores.get(k) instanceof Duck) duck++;
            if (location.herbivores.get(k) instanceof Goat) goat++;
            if (location.herbivores.get(k) instanceof Horse) horse++;
            if (location.herbivores.get(k) instanceof Mouse) mouse++;
            if (location.herbivores.get(k) instanceof Rabbit) rabbit++;
            if (location.herbivores.get(k) instanceof Sheep) sheep++;
        }
        for (int k = 0; k < location.predators.size(); k++) {
            if (location.predators.get(k) instanceof Anaconda) anaconda++;
            if (location.predators.get(k) instanceof Bear) bear++;
            if (location.predators.get(k) instanceof Eagle) eagle++;
            if (location.predators.get(k) instanceof Fox) fox++;
            if (location.predators.get(k) instanceof Wolf) wolf++;
        }
//        System.out.println("boar " + boar);
//        System.out.println("buffalo " + buffalo);
//        System.out.println("caterpillar " + caterpillar);
//        System.out.println("deer " + deer);
//        System.out.println("duck " + duck);
//        System.out.println("goat " + goat);
//        System.out.println("horse " + horse);
//        System.out.println("mouse " + mouse);
//        System.out.println("rabbit " + rabbit);
//        System.out.println("sheep " + sheep);
//        System.out.println("anaconda " + anaconda);
//        System.out.println("bear " + bear);
//        System.out.println("eagle " + eagle);
//        System.out.println("fox " + fox);
//        System.out.println("wolf " + wolf);
        System.out.print("Total animal count on location : " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf));
        System.out.print("  Herbivores: " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep));
        System.out.println("  Predators: " + (anaconda + bear + eagle + fox + wolf));
        //System.out.println();
        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);
    }
    public void eating(){
        this.getLock().lock();
        Iterator<Predator> iterator = predators.iterator();
        Predator nextPredator = iterator.next();
        nextPredator.eat(nextPredator, herbivores);
            nextPredator.checkHealth(nextPredator, predators);

        Iterator<Herbivore> iterator1 = herbivores.iterator();
            Herbivore nextHerbivore = iterator1.next();
            nextHerbivore.eat(herbivores);
            nextHerbivore.eatPlant(plants);
            this.getLock().unlock();


    }

    public void startReproduct(){
        this.getLock().lock();
        for (int i = 0; i < randomCount(boar)/6; i++) {
            herbivores.add(new Boar(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(buffalo)/6; i++) {
            herbivores.add(new Buffalo(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(caterpillar)/6; i++) {
            herbivores.add(new Caterpillar(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(deer)/6; i++) {
            herbivores.add(new Deer(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(duck)/6; i++) {
            herbivores.add(new Duck(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(goat)/6; i++) {
            herbivores.add(new Goat(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(horse)/6; i++) {
            herbivores.add(new Horse(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(mouse)/6; i++) {
            herbivores.add(new Mouse(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(rabbit)/6; i++) {
            herbivores.add(new Rabbit(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(sheep)/6; i++) {
            herbivores.add(new Sheep(x, y, xLength, yLength));
        }
        for (int i = 0; i < randomCount(anaconda)/6; i++) {
            predators.add(new Anaconda(x, y, xLength, yLength));
            hunger(predators);
        }
        for (int i = 0; i < randomCount(bear)/6; i++) {
            predators.add(new Bear(x, y, xLength, yLength));
            hunger(predators);
        }
        for (int i = 0; i < randomCount(eagle)/6; i++) {
            predators.add(new Eagle(x, y, xLength, yLength));
            hunger(predators);
        }
        for (int i = 0; i < randomCount(fox)/6; i++) {
            predators.add(new Fox(x, y, xLength, yLength));
            hunger(predators);
        }
        for (int i = 0; i < randomCount(wolf)/6; i++) {
            predators.add(new Wolf(x, y, xLength, yLength));
            hunger(predators);
        }
        this.getLock().unlock();
    }

    private int randomCount (int animalCount){
        int returnNumber = 1;
        if (animalCount > 2) {
            returnNumber = ThreadLocalRandom.current().nextInt(animalCount);
        }
        return returnNumber;
    }

    private void hunger(List<Predator> predators){
        for (Predator predator : predators) {
            if (predator instanceof Anaconda){
                ((Anaconda) predator).setHunger(((Anaconda) predator).getHunger()/2);
            }
            if (predator instanceof Bear){
                ((Bear) predator).setHunger(((Bear) predator).getHunger()/2);
            }
            if (predator instanceof Eagle){
                ((Eagle) predator).setHunger(((Eagle) predator).getHunger()/2);
            }
            if (predator instanceof Fox){
                ((Fox) predator).setHunger(((Fox) predator).getHunger()/2);
            }
            if (predator instanceof Wolf){
                ((Wolf) predator).setHunger(((Wolf) predator).getHunger()/2);
            }
        }
    }

    public void moveAnimals(Location[][] locations){
        this.getLock().lock();

        List<Predator> predatorsList = new CopyOnWriteArrayList<>(predators);
        List<Herbivore> herbivoresList = new CopyOnWriteArrayList<>(herbivores);

        for (Predator predator : predatorsList) {
            predator.move(this, locations);
        }
        for (Herbivore herbivore : herbivoresList) {
            herbivore.move(this, Island.locations);
        }
        this.getLock().unlock();
    }
}
