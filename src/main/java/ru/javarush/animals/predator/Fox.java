package ru.javarush.animals.predator;

import ru.javarush.service.Diet;

//Лиса
@Diet(eatRabbit = 70, eatMouse = 90, eatDuck = 60, eatCaterpillar = 40)

public class Fox extends Predator {

    public static final double weight = 8;
    public static final int movingSpeed = 2;
    public static final double canEat = 2;

    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Fox(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
