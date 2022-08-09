package com.company.animals.predator;

import com.company.Diet;
import com.company.animals.Animal;
import com.company.animals.herbivore.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {


    public Predator(int xLocation, int yLocation, int xMax, int yMax, int movingSpeed) {
        super(xLocation, yLocation, xMax, yMax, movingSpeed);
    }


    @Override
    public void eat (Predator predator, List<Herbivore> herbivores){

        if (predator instanceof Anaconda){
            int appetite = ((Anaconda) predator).getHunger();
            if (appetite < Anaconda.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Anaconda.canEat) {((Anaconda) predator).setHunger((int) Anaconda.canEat);}
                else ((Anaconda) predator).setHunger(((Anaconda) predator).getHunger() + hunt);
            }
            else System.out.println("Anaconda is full");
        }
        if (predator instanceof Bear){
            int appetite = ((Bear) predator).getHunger();
            if (appetite < Bear.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Bear.canEat) {((Bear) predator).setHunger((int) Bear.canEat);}
                else ((Bear) predator).setHunger(((Bear) predator).getHunger() + hunt);
            }
            else System.out.println("Bear is full");
        }
        if (predator instanceof Eagle){
            int appetite = ((Eagle) predator).getHunger();
            if (appetite < Eagle.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Eagle.canEat) {((Eagle) predator).setHunger((int) Eagle.canEat);}
                else ((Eagle) predator).setHunger(((Eagle) predator).getHunger() + hunt);
            }
            else System.out.println("Eagle is full");
        }
        if (predator instanceof Fox){
            int appetite = ((Fox) predator).getHunger();
            if (appetite < Fox.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Fox.canEat) {((Fox) predator).setHunger((int) Fox.canEat);}
                else ((Fox) predator).setHunger(((Fox) predator).getHunger() + hunt);
            }
            else System.out.println("Fox is full");
        }
        if (predator instanceof Wolf){
            int appetite = ((Wolf) predator).getHunger();
            if (appetite < Wolf.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Wolf.canEat) {((Wolf) predator).setHunger((int) Wolf.canEat);}
                else ((Wolf) predator).setHunger(((Wolf) predator).getHunger() + hunt);
            }
            else System.out.println("Wolf is full");
        }
    }

    public int hunt(Predator predator, List<Herbivore> herbivores){
        int hungerCount = 0;
        Diet annotation = predator.getClass().getAnnotation(Diet.class);
        Herbivore herbivore = herbivores.get(random(herbivores.size()));
        if (predator.eatOrNot(annotation.eatBoar()) && herbivore instanceof Boar) {herbivore.die(herbivores);
            hungerCount = (int) Bear.weight;
        }
        if (predator.eatOrNot(annotation.eatBuffalo()) && herbivore instanceof Buffalo) {herbivore.die(herbivores);
            hungerCount = (int) Buffalo.weight;
        }
        if (predator.eatOrNot(annotation.eatCaterpillar()) && herbivore instanceof Caterpillar) {herbivore.die(herbivores);
            hungerCount = (int) Caterpillar.weight;
        }
        if (predator.eatOrNot(annotation.eatDeer()) && herbivore instanceof Deer) {herbivore.die(herbivores);
            hungerCount = (int) Deer.weight;
        }
        if (predator.eatOrNot(annotation.eatDuck()) && herbivore instanceof Duck) {herbivore.die(herbivores);
            hungerCount = (int) Duck.weight;
        }
        if (predator.eatOrNot(annotation.eatGoat()) && herbivore instanceof Goat) {herbivore.die(herbivores);
            hungerCount = (int) Goat.weight;
        }
        if (predator.eatOrNot(annotation.eatHorse()) && herbivore instanceof Horse) {herbivore.die(herbivores);
            hungerCount = (int) Horse.weight;
        }
        if (predator.eatOrNot(annotation.eatMouse()) && herbivore instanceof Mouse) {herbivore.die(herbivores);
            hungerCount = 1;
        }
        if (predator.eatOrNot(annotation.eatRabbit()) && herbivore instanceof Rabbit) {herbivore.die(herbivores);
            hungerCount = (int) Rabbit.weight;
        }
        if (predator.eatOrNot(annotation.eatSheep()) && herbivore instanceof Sheep) {herbivore.die(herbivores);
            hungerCount = (int) Sheep.weight;
        }
        return hungerCount;
    }

    public void checkHealth(Predator predator, List<Predator> predators){
        if (predator instanceof Anaconda){
            if (((Anaconda) predator).getHunger() == 0){predator.die(predators);}
            }
            else System.out.println("Anaconda is dead");
        if (predator instanceof Eagle){
            if (((Eagle) predator).getHunger() == 0){predator.die(predators);}
        }
        else System.out.println("Eagle is dead");
        if (predator instanceof Bear){
            if (((Bear) predator).getHunger() == 0){predator.die(predators);}
        }
        else System.out.println("Bear is dead");
        if (predator instanceof Fox){
            if (((Fox) predator).getHunger() == 0){predator.die(predators);}
        }
        else System.out.println("Fox is dead");
        if (predator instanceof Wolf){
            if (((Wolf) predator).getHunger() == 0){predator.die(predators);}
        }
        else System.out.println("Wolf is dead");
    }

}
