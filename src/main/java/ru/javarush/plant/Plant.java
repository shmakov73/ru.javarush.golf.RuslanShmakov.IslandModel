package ru.javarush.plant;

public class Plant {

    private int weight;
    public static int maxCount = 500;

    public Plant(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
