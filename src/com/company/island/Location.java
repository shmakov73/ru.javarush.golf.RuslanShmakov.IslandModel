package com.company.island;

import com.company.animals.Animal;
import com.company.animals.herbivore.*;
import com.company.animals.predator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    // Списки где будут хранитсья находящиеся на локации сущности
    List<Herbivore> herbivores = new ArrayList<>();
    List<Predator> predators = new ArrayList<>();
    List<Animal> animals = new ArrayList<>();
    //List<Plant> plants = new ArrayList<>();

    public void addHerbivoresToList(int x, int y, int xLength, int yLength){
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Boar.maxCount); i++) {
            herbivores.add(new Boar(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Buffalo.maxCount); i++) {
            herbivores.add(new Buffalo(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Caterpillar.maxCount); i++) {
            herbivores.add(new Caterpillar(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Deer.maxCount); i++) {
            herbivores.add(new Deer(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Duck.maxCount); i++) {
            herbivores.add(new Duck(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Goat.maxCount); i++) {
            herbivores.add(new Goat(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Horse.maxCount); i++) {
            herbivores.add(new Horse(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Mouse.maxCount); i++) {
            herbivores.add(new Mouse(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Rabbit.maxCount); i++) {
            herbivores.add(new Rabbit(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Sheep.maxCount); i++) {
            herbivores.add(new Sheep(x, y, xLength, yLength));
        }
    }

    public void addPredatorsToList(int x, int y, int xLength, int yLength){
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Anaconda.maxCount); i++) {
            predators.add(new Anaconda(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Bear.maxCount); i++) {
            predators.add(new Bear(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Eagle.maxCount); i++) {
            predators.add(new Eagle(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Fox.maxCount); i++) {
            predators.add(new Fox(x, y, xLength, yLength));
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Wolf.maxCount); i++) {
            predators.add(new Wolf(x, y, xLength, yLength));
        }
    }

    public void addAnimalsToList(){
        animals.addAll(predators);
        animals.addAll(herbivores);
    }


    // ОПИСЫВАЕМ СОБЫТИЯ НА ЛОКАЦИИ
    public void calculate() {

        // В ЦИКЛЕ ПЕРЕБИРАЕМ ХИЩНИКОВ ИЗ ЛИСТА
        // И КАЖДОМУ ПО ОЧЕРЕДИ СУЕМ СПИСОК ТРАВОЯДНЫХ
        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            predator.eat(herbivores);

            // РАЗМНОЖАЕМСЯ
            predator.reproduction();

            // ДВИГАЕМСЯ
            //predator.move();
        }

        // ТО ЖЕ САМОЕ ДЕЛАЕМ ДЛЯ ТРАВОЯДНЫХ

        for (int i = 0; i < herbivores.size(); i++) {
            // ... //
        }

    }


    @Override
    public String toString() {
        return " | | ";
    }
}
