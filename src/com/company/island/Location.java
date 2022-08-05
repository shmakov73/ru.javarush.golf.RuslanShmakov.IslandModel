package com.company.island;

import com.company.animals.Animal;
import com.company.animals.herbivore.*;
import com.company.animals.predator.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    // Списки где будут хранитсья находящиеся на локации сущности
    List<Herbivore> herbivores = new ArrayList<>();
    List<Predator> predators = new ArrayList<>();
    //List<Plant> plants = new ArrayList<>();

    int boar = 0;
    int buffalo = 0;
    int caterpillar = 0;
    int deer = 0;
    int duck = 0;
    int goat = 0;
    int horse = 0;
    int mouse = 0;
    int rabbit = 0;
    int sheep = 0;
    int anaconda = 0;
    int bear = 0;
    int eagle = 0;
    int fox = 0;
    int wolf = 0;

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

    public int calculate(Location location){
        boar = 0;
        buffalo = 0;
        caterpillar = 0;
        deer = 0;
        duck = 0;
        goat = 0;
        horse = 0;
        mouse = 0;
        rabbit = 0;
        sheep = 0;
        anaconda = 0;
        bear = 0;
        eagle = 0;
        fox = 0;
        wolf = 0;

        for (int k = 0; k < location.herbivores.size(); k++) {
            if (location.herbivores.get(k) instanceof Boar) boar++;
            if (location.herbivores.get(k) instanceof Buffalo) buffalo++;
            if (location.herbivores.get(k) instanceof Caterpillar) caterpillar++;
            if (location.herbivores.get(k) instanceof Deer) deer++;
            if (location.herbivores.get(k) instanceof Duck) duck++;
            if (location.herbivores.get(k) instanceof Goat) goat++;
            if (location.herbivores.get(k) instanceof Horse) horse++;
            if (location.herbivores.get(k) instanceof Mouse) mouse++;
            if (location.herbivores.get(k) instanceof Rabbit) rabbit++;
            if (location.herbivores.get(k) instanceof Sheep) sheep++;
        }
        for (int k = 0; k < location.predators.size(); k++) {
            if (location.predators.get(k) instanceof Anaconda) anaconda++;
            if (location.predators.get(k) instanceof Bear) bear++;
            if (location.predators.get(k) instanceof Eagle) eagle++;
            if (location.predators.get(k) instanceof Fox) fox++;
            if (location.predators.get(k) instanceof Wolf) wolf++;
        }
//        System.out.println("boar " + boar + "| |");
//        System.out.println("buffalo " + buffalo + "| |");
//        System.out.println("caterpillar " + caterpillar + "| |");
//        System.out.println("deer " + deer + "| |");
//        System.out.println("duck " + duck + "| |");
//        System.out.println("goat " + goat + "| |");
//        System.out.println("horse " + horse + "| |");
//        System.out.println("mouse " + mouse + "| |");
//        System.out.println("rabbit " + rabbit + "| |");
//        System.out.println("sheep " + sheep + "| |");
//        System.out.println("anaconda " + anaconda + "| |");
//        System.out.println("bear " + bear + "| |");
//        System.out.println("eagle " + eagle + "| |");
//        System.out.println("fox " + fox + "| |");
//        System.out.println("wolf " + wolf + "| |");
        //System.out.println(boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);

        //System.out.println();
        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);
    }
    public void eating(){
        for (Predator predator : predators) {
            predator.eat(predator, herbivores);
        }
        Iterator<Herbivore> iterator = herbivores.iterator();
            Herbivore nextHerbivore = iterator.next();
            nextHerbivore.eat(nextHerbivore, herbivores);
    }




//    // ОПИСЫВАЕМ СОБЫТИЯ НА ЛОКАЦИИ
//    public void calculate() {
//
//        // В ЦИКЛЕ ПЕРЕБИРАЕМ ХИЩНИКОВ ИЗ ЛИСТА
//        // И КАЖДОМУ ПО ОЧЕРЕДИ СУЕМ СПИСОК ТРАВОЯДНЫХ
//        for (int i = 0; i < predators.size(); i++) {
//            Predator predator = predators.get(i);
//            predator.eat(herbivores);
//
//            // РАЗМНОЖАЕМСЯ
//            predator.reproduction();
//
//            // ДВИГАЕМСЯ
//            //predator.move();
//        }
//
//        // ТО ЖЕ САМОЕ ДЕЛАЕМ ДЛЯ ТРАВОЯДНЫХ
//
//        for (int i = 0; i < herbivores.size(); i++) {
//            // ... //
//        }
//
//    }


    @Override
    public String toString() {
        return " | | ";
    }
}
