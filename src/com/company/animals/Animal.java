package com.company.animals;

import com.company.animals.herbivore.Herbivore;

import java.util.List;

public abstract class Animal {

    public void eat(List<Herbivore> herbivores){}
    public abstract int[] move();
    public void reproduction(){}
}
