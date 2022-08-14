package com.company.animals;

import com.company.Diet;
import com.company.animals.herbivore.*;
import com.company.animals.predator.*;
import com.company.island.Location;
import com.company.plant.Plant;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {

    private final int xLocation;
    private final int yLocation;
    private final int xMax;
    private final int yMax;
    private final int movingSpeed;

    public Animal(int xLocation, int yLocation, int xMax, int yMax, int movingSpeed) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xMax = xMax;
        this.yMax = yMax;
        this.movingSpeed = movingSpeed;
    }

    public void move(Location location, Location[][] locations) {
        location.getLock().lock();
        int[] newCoordinates = this.getNewCoordinates();
        if (isLocationFree(location)) {
            locations[newCoordinates[0]][newCoordinates[1]].addAnimal(this);
            if (this instanceof Predator) {
                location.getPredators().remove(this);
            }
            if (this instanceof Herbivore) {
                location.getHerbivores().remove(this);
            }
        }
        else move(location, locations);
        location.getLock().unlock();
    }

    private boolean isLocationFree(Location location){
        int maxCount = 0;
        boolean returnValue;
        if (this instanceof Boar){maxCount = Boar.maxCount;}
        if (this instanceof Buffalo){maxCount = Buffalo.maxCount;}
        if (this instanceof Caterpillar){maxCount = Caterpillar.maxCount;}
        if (this instanceof Deer){maxCount = Deer.maxCount;}
        if (this instanceof Duck){maxCount = Duck.maxCount;}
        if (this instanceof Goat){maxCount = Goat.maxCount;}
        if (this instanceof Horse){maxCount = Horse.maxCount;}
        if (this instanceof Mouse){maxCount = Mouse.maxCount;}
        if (this instanceof Rabbit){maxCount = Rabbit.maxCount;}
        if (this instanceof Sheep){maxCount = Sheep.maxCount;}
        if (this instanceof Anaconda){maxCount = Anaconda.maxCount;}
        if (this instanceof Bear){maxCount = Bear.maxCount;}
        if (this instanceof Eagle){maxCount = Eagle.maxCount;}
        if (this instanceof Fox){maxCount = Fox.maxCount;}
        if (this instanceof Wolf){maxCount = Wolf.maxCount;}

        int herbivoresCountOnLocation = (int) location.getHerbivores().stream().filter(this::equals).count();
        int predatorsCountOnLocation = (int) location.getPredators().stream().filter(this::equals).count();
        if (this instanceof Predator && predatorsCountOnLocation < maxCount) returnValue = true;
        else returnValue = this instanceof Herbivore && herbivoresCountOnLocation < maxCount;
        return returnValue;
    }

    public int[] getNewCoordinates () {
        int[] returnCoordinates = new int[2];
        int direction = ThreadLocalRandom.current().nextInt(4);
        int newXLocation;
        int newYLocation;

        if (direction == 0) {
            newXLocation = xLocation + movingSpeed;
            newYLocation = yLocation;
        }else if (direction == 1) {
            newXLocation = xLocation;
            newYLocation = yLocation + movingSpeed;
        }else if (direction == 2){
            newXLocation = xLocation - movingSpeed;
            newYLocation = yLocation;
        }else {
            newXLocation = xLocation;
            newYLocation = yLocation - movingSpeed;
        }
        int x = (newXLocation + xMax) % xMax;
        int y = (newYLocation + yMax) % yMax;
        returnCoordinates[0] = x;
        returnCoordinates[1] = y;

        return returnCoordinates;
    }

    public void die(List<? extends Animal> animals){
        animals.remove(this);
    }

    public boolean eatOrNot(int chance){
        int random = ThreadLocalRandom.current().nextInt(101);
        return random <= chance;
    }

    public int random(int count){
        return ThreadLocalRandom.current().nextInt(count);
    }

    public void eat(List<? extends Animal> victims){
        Diet annotation = this.getClass().getAnnotation(Diet.class);
        Iterator<? extends Animal> iterator =  victims.iterator();
        Animal nextVictim = iterator.next();

        if (this.eatOrNot(annotation.eatBoar())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatBuffalo())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatCaterpillar())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatDeer())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatDuck())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatGoat())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatHorse())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatMouse())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatRabbit())) nextVictim.die(victims);
        if (this.eatOrNot(annotation.eatSheep())) nextVictim.die(victims);
    }
}

