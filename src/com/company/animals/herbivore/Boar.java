package com.company.animals.herbivore;

import com.company.Diet;

//Кабан
@Diet(eatMouse = 50, eatCaterpillar = 90, eatPlants = 100)

public class Boar extends Herbivore{

    public static final int maxCount = 50;
    public static final double weight = 400;
    public static final int movingSpeed = 2;
    public static final double canEat = 50;

    public Boar(int xLocation, int yLocation, int xMax, int yMax) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }

}
