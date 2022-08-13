package com.company.animals.herbivore;

import com.company.Diet;

//Овца
@Diet(eatPlants = 100)

public class Sheep extends Herbivore {

    public static final int maxCount = 140;
    public static final double weight = 70;
    public static final int movingSpeed = 3;
    public static final double canEat = 15;

    public Sheep(int xLocation, int yLocation, int xMax, int yMax) {
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
