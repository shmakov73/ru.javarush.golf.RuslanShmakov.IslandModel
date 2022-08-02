package com.company.animals.herbivore;

import com.company.Diet;

//Олень
@Diet(eatPlants = 100)

public class Deer extends Herbivore{

    public static final int maxCount = 20;
    public static final double weight = 300;
    public static final int movingSpeed = 4;
    public static final double canEat = 50;

    public Deer(int xLocation, int yLocation, int xMax, int yMax) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }
}
