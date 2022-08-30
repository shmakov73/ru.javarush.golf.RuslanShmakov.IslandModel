package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Гусеница
@Diet(eatPlants = 100)

public class Caterpillar extends Herbivore{

    public static final double weight = 400;
    public static final int movingSpeed = 2;
    public static final double canEat = 50;

    public Caterpillar(int xLocation, int yLocation) {
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
