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
    //List<Plant> plants = new ArrayList<>();

    public void addHerbivoresToList(){
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Boar.maxCount); i++) {
            herbivores.add(new Boar());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Buffalo.maxCount); i++) {
            herbivores.add(new Buffalo());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Caterpillar.maxCount); i++) {
            herbivores.add(new Caterpillar());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Deer.maxCount); i++) {
            herbivores.add(new Deer());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Duck.maxCount); i++) {
            herbivores.add(new Duck());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Goat.maxCount); i++) {
            herbivores.add(new Goat());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Horse.maxCount); i++) {
            herbivores.add(new Horse());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Mouse.maxCount); i++) {
            herbivores.add(new Mouse());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Rabbit.maxCount); i++) {
            herbivores.add(new Rabbit());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Sheep.maxCount); i++) {
            herbivores.add(new Sheep());
        }
    }

    public void addPredatorsToList(){
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Anaconda.maxCount); i++) {
            predators.add(new Anaconda());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Bear.maxCount); i++) {
            predators.add(new Bear());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Eagle.maxCount); i++) {
            predators.add(new Eagle());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Fox.maxCount); i++) {
            predators.add(new Fox());
        }
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(Wolf.maxCount); i++) {
            predators.add(new Wolf());
        }
    }

//    public void addAnimalType(int maxCount){
//        int count = ThreadLocalRandom.current().nextInt(maxCount);
//        for (int i = 0; i < count; i++) {
//            herbivores.add(new Herbivore());
//        }
//    }


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
            predator.move();
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
