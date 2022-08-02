package com.company.animals.predator;

import com.company.Diet;

//Волк
@Diet(eatHorse = 10, eatDeer = 15, eatRabbit = 60, eatMouse = 80, eatGoat = 60, eatSheep = 70,
        eatBoar = 15, eatBuffalo = 10, eatDuck = 40)

public class Wolf extends Predator {

    public static final int maxCount = 30;
    public static final double weight = 50;
    public static final int movingSpeed = 3;
    public static final double canEat = 8;

    public Wolf(int xLocation, int yLocation, int xMax, int yMax) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }
}
