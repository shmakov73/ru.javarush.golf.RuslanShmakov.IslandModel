package com.company.animals.predator;

import com.company.Diet;

//Лиса
@Diet(eatRabbit = 70, eatMouse = 90, eatDuck = 60, eatCaterpillar = 40)

public class Fox extends Predator {

    public static final int maxCount = 30;
    public static final double weight = 8;
    public static final int movingSpeed = 2;
    public static final double canEat = 2;

    public Fox(int xLocation, int yLocation, int xMax, int yMax) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }
}
