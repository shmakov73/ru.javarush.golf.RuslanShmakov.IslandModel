package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Кролик
@Diet(eatPlants = 100)

public class Rabbit extends Herbivore{

    public static final double weight = 2;
    public static final int movingSpeed = 2;
    public static final double canEat = 0.45;

    public Rabbit(int xLocation, int yLocation) {
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
