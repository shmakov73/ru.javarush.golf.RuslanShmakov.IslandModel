package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Кролик
@Diet(eatPlants = 100)

public class Rabbit extends Herbivore{

    public static final int maxCount = 150;
    public static final double weight = 2;
    public static final int movingSpeed = 2;
    public static final double canEat = 0.45;

    public Rabbit(int xLocation, int yLocation, int xMax, int yMax) {
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
