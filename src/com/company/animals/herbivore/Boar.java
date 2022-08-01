package com.company.animals.herbivore;

import com.company.island.Location;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Кабан
public class Boar extends Herbivore{


    public static final int maxCount = 50;
    public static final double weight = 400;
    public static final int movingSpeed = 2;
    public static final double canEat = 50;

    //вероятность, с которой он может съесть другое животное
    public static final int eatWolf = 0;
    public static final int eatAnaconda = 0;
    public static final int eatFox = 0;
    public static final int eatBear = 0;
    public static final int eatEagle = 0;
    public static final int eatHorse = 0;
    public static final int eatDeer = 0;
    public static final int eatRabbit = 0;
    public static final int eatMouse = 50;
    public static final int eatGoat = 0;
    public static final int eatSheep = 0;
    public static final int eatBoar = 0;
    public static final int eatBuffalo = 0;
    public static final int eatDuck = 0;
    public static final int eatCaterpillar = 90;
    public static final int eatPlants = 100;


    private int xLocation;
    private int yLocation;
    private int xMax;
    private int yMax;

    public Boar(int xLocation, int yLocation, int xMax, int yMax) {
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
