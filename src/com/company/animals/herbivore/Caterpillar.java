package com.company.animals.herbivore;

import com.company.Diet;

//Гусеница
@Diet(eatPlants = 100)

public class Caterpillar extends Herbivore{

    public static final int maxCount = 1000;
    public static final double weight = 400;
    public static final int movingSpeed = 2;
    public static final double canEat = 50;

    public Caterpillar(int xLocation, int yLocation, int xMax, int yMax) {
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
