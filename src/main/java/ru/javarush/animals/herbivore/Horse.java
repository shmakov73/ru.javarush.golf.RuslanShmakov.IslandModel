package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Лошадь
@Diet(eatPlants = 100)

public class Horse extends Herbivore{

    public static final double weight = 400;
    public static final int movingSpeed = 4;
    public static final double canEat = 60;

    public Horse(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
