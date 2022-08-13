package com.company.animals.herbivore;

import com.company.Diet;

//Лошадь
@Diet(eatPlants = 100)

public class Horse extends Herbivore{

    public static final int maxCount = 20;
    public static final double weight = 400;
    public static final int movingSpeed = 4;
    public static final double canEat = 60;

    public Horse(int xLocation, int yLocation, int xMax, int yMax) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }
    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
