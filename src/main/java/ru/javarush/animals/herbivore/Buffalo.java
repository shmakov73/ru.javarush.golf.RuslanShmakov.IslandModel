package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Буйвол
@Diet(eatPlants = 100)

public class Buffalo extends Herbivore {

    public static final double weight = 700;
    public static final int movingSpeed = 3;
    public static final double canEat = 100;

    public Buffalo(int xLocation, int yLocation) {
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
