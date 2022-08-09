package com.company.animals;

import com.company.Diet;
import com.company.animals.herbivore.*;
import com.company.animals.predator.Predator;

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

    public void eat(Predator predator, List<Herbivore> herbivores){}

    public int[] move() {
        int[] returnCoordinates = new int[2];
        int direction = ThreadLocalRandom.current().nextInt(3);
        int newXLocation;
        int newYLocation;

        if (direction == 0){
            newXLocation = xLocation + movingSpeed;
            newYLocation = yLocation;
        }
        else if (direction == 1){
            newXLocation = xLocation;
            newYLocation = yLocation + movingSpeed;
        }
        else {
            newXLocation = xLocation - movingSpeed;
            newYLocation = yLocation;
        }
        int x = (newXLocation + xMax)%xMax;
        int y = (newYLocation + yMax)%yMax;
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

//        if (animal.eatOrNot(annotation.eatBoar()) && nextVictim instanceof Boar) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatBuffalo()) && nextVictim instanceof Buffalo) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatCaterpillar()) && nextVictim instanceof Caterpillar) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatDeer()) && nextVictim instanceof Deer) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatDuck()) && nextVictim instanceof Duck) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatGoat()) && nextVictim instanceof Goat) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatHorse()) && nextVictim instanceof Horse) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatMouse()) && nextVictim instanceof Mouse) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatRabbit()) && nextVictim instanceof Rabbit) nextVictim.die(victims, nextVictim);
//        if (animal.eatOrNot(annotation.eatSheep()) && nextVictim instanceof Sheep) nextVictim.die(victims, nextVictim);

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

