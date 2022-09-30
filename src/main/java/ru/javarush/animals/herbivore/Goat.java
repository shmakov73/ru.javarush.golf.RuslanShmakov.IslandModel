package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Коза
@Diet(eatPlants = 100)

public class Goat extends Herbivore{

    public static final double weight = 60;
    public static final int movingSpeed = 3;
    public static final double canEat = 10;

    public Goat(int xLocation, int yLocation) {
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