package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Коза
@Diet(eatPlants = 100)

public class Goat extends Herbivore{

    public static final int maxCount = 140;
    public static final double weight = 60;
    public static final int movingSpeed = 3;
    public static final double canEat = 10;

    public Goat(int xLocation, int yLocation, int xMax, int yMax) {
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
