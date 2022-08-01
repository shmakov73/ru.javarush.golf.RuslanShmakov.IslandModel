package com.company.animals.predator;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Орел
public class Eagle extends Predator {
    public final static int maxCount = 2;
    public static final double weight = 6;
    public static final int movingSpeed = 3;
    public static final double canEat = 1;

    public static final int eatWolf = 0;
    public static final int eatAnaconda = 0;
    public static final int eatFox = 10;
    public static final int eatBear = 0;
    public static final int eatEagle = 0;
    public static final int eatHorse = 0;
    public static final int eatDeer = 0;
    public static final int eatRabbit = 90;
    public static final int eatMouse = 90;
    public static final int eatGoat = 0;
    public static final int eatSheep = 0;
    public static final int eatBoar = 0;
    public static final int eatBuffalo = 0;
    public static final int eatDuck = 80;
    public static final int eatCaterpillar = 0;
    public static final int eatPlants = 0;

    private int xLocation;
    private int yLocation;
    private int xMax;
    private int yMax;


    public Eagle(int xLocation, int yLocation, int xMax, int yMax) {
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

        //System.out.println(Arrays.toString(returnCoordinates));

        return returnCoordinates;
    }
}
