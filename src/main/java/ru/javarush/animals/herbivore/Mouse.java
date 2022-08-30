package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Мышь
@Diet(eatCaterpillar = 90, eatPlants = 100)

public class Mouse extends Herbivore{

    public static final double weight = 0.05;
    public static final int movingSpeed = 1;
    public static final double canEat = 0.01;

    public Mouse(int xLocation, int yLocation) {
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
