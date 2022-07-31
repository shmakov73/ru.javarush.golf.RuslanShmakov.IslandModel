package com.company.animals.predator;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Волк
public class Wolf extends Predator {
    public final static int maxCount = 30;
    public static final double weight = 50;
    public static final int movingSpeed = 3;
    public static final double canEat = 8;


    private int xLocation;
    private int yLocation;
    private int xMax;
    private int yMax;

    public Wolf(int xLocation, int yLocation, int xMax, int yMax) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xMax = xMax;
        this.yMax = yMax;
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

        //ystem.out.println(Arrays.toString(returnCoordinates));

        return returnCoordinates;
    }
}
