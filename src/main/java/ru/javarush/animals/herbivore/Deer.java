package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

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
    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
