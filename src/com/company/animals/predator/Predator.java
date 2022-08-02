package com.company.animals.predator;

import com.company.animals.Animal;
import com.company.animals.herbivore.Herbivore;

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
}
