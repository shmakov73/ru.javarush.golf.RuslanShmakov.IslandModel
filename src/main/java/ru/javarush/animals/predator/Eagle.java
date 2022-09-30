package ru.javarush.animals.predator;

import ru.javarush.service.Diet;

//Орел
@Diet(eatFox = 10, eatRabbit = 90, eatMouse = 90, eatDuck = 80)

public class Eagle extends Predator {

    public static final double weight = 6;
    public static final int movingSpeed = 3;
    public static final double canEat = 1;


    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Eagle(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}