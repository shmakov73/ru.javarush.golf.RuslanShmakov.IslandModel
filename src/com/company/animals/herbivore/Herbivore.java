package com.company.animals.herbivore;

import com.company.animals.Animal;
import com.company.animals.predator.*;
import com.company.island.Location;
import com.company.plant.Plant;

import java.util.Iterator;
import java.util.List;

public abstract class Herbivore extends Animal {

    public Herbivore(int xLocation, int yLocation, int xMax, int yMax, int movingSpeed) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }

// ДОДЕЛАТЬ
    public void eat(Location location){
    List<Plant> plants = location.getPlants();
        if (this instanceof Boar){
        int appetite = ((Boar) this).getHunger();
        while (appetite < Boar.canEat){
            ((Boar) this).setHunger(((Boar) this).getHunger() + eatCount(plants));
        }

        if (appetite < Boar.canEat){
            int count = this.eatCount(plants);
            if (count > Boar.canEat) {((Boar) this).setHunger((int) Boar.canEat);}
            else ((Boar) this).setHunger(((Boar) this).getHunger() + count);
        }
        else System.out.println("Boar is full");
    }

}
private int eatCount(List<Plant> plants){
        return 0;
}
}
