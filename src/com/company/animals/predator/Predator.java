package com.company.animals.predator;

import com.company.animals.Animal;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public abstract int[] move();
}
