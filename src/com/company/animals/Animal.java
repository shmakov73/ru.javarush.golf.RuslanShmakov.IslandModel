package com.company.animals;

import com.company.animals.herbivore.Herbivore;
import com.company.animals.predator.Predator;

import java.util.List;

public abstract class Animal {

    public void eat(Predator predator, List<Herbivore> herbivores){};

    public abstract int[] move();
    //public abstract void reproduction(List<? super Animal> animal);
}
