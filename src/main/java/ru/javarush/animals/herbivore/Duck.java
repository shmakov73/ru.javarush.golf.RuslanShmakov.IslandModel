package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Утка
@Diet(eatCaterpillar = 90, eatPlants = 100)

public class Duck extends Herbivore{

    public static final double weight = 1;
    public static final int movingSpeed = 4;
    public static final double canEat = 0.15;

    public Duck(int xLocation, int yLocation) {
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
