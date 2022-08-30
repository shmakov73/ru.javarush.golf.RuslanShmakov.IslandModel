package ru.javarush.animals.predator;

import ru.javarush.service.Diet;

//Волк
@Diet(eatHorse = 10, eatDeer = 15, eatRabbit = 60, eatMouse = 80, eatGoat = 60, eatSheep = 70,
        eatBoar = 15, eatBuffalo = 10, eatDuck = 40)

public class Wolf extends Predator {

    public static final double weight = 50;
    public static final int movingSpeed = 3;
    public static final double canEat = 8;

    private int hunger;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Wolf(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
