package ru.javarush.animals.herbivore;

import ru.javarush.service.Diet;

//Овца
@Diet(eatPlants = 100)

public class Sheep extends Herbivore {

    public static final double weight = 70;
    public static final int movingSpeed = 3;
    public static final double canEat = 15;

    public Sheep(int xLocation, int yLocation) {
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
