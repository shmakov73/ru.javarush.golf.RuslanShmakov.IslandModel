package com.company.animals.predator;

import com.company.Diet;
import com.company.animals.Animal;
import com.company.animals.herbivore.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    private int xLocation;
    private int yLocation;
    private int xMax;
    private int yMax;
    private int movingSpeed;

    //@Override
    //public abstract void eat(List<Herbivore> herbivores);

    public Predator(int xLocation, int yLocation, int xMax, int yMax, int movingSpeed) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xMax = xMax;
        this.yMax = yMax;
        this.movingSpeed = movingSpeed;
    }

    @Override
    public int[] move() {
        int[] returnCoordinates = new int[2];
        int direction = ThreadLocalRandom.current().nextInt(3);
        int newXLocation = 0;
        int newYLocation = 0;

        if (direction == 0){
            newXLocation = xLocation + movingSpeed;
            newYLocation = yLocation;
        }
        else if (direction == 1){
            newXLocation = xLocation;
            newYLocation = yLocation + movingSpeed;
        }
        else if (direction == 2){
            newXLocation = xLocation - movingSpeed;
            newYLocation = yLocation;
        }
        else if (direction == 3){
            newXLocation = xLocation;
            newYLocation = yLocation - movingSpeed;
        }
        int x = (newXLocation + xMax)%xMax;
        int y = (newYLocation + yMax)%yMax;
        returnCoordinates[0] = x;
        returnCoordinates[1] = y;

        return returnCoordinates;
    }

    public void die(List<Predator> predators, Predator predator){
        predators.remove(predator);
    }
    @Override
    public void eat(Predator predator, List<Herbivore> herbivores){
        Diet annotation = predator.getClass().getAnnotation(Diet.class);
        Iterator<Herbivore> iterator = herbivores.iterator();
        Herbivore nextHerbivore = iterator.next();
        if (predator.eatOrNot(annotation.eatBoar()) && nextHerbivore instanceof Boar) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatBuffalo()) && nextHerbivore instanceof Buffalo) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatCaterpillar()) && nextHerbivore instanceof Caterpillar) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatDeer()) && nextHerbivore instanceof Deer) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatDuck()) && nextHerbivore instanceof Duck) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatGoat()) && nextHerbivore instanceof Goat) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatHorse()) && nextHerbivore instanceof Horse) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatMouse()) && nextHerbivore instanceof Mouse) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatRabbit()) && nextHerbivore instanceof Rabbit) nextHerbivore.die(herbivores, nextHerbivore);
        if (predator.eatOrNot(annotation.eatSheep()) && nextHerbivore instanceof Sheep) nextHerbivore.die(herbivores, nextHerbivore);

    }

    public boolean eatOrNot(int chance){
        int random = ThreadLocalRandom.current().nextInt(101);
        return random <= chance;
    }
}
