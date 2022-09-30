package ru.javarush.animals.predator;

import ru.javarush.service.Diet;
import ru.javarush.animals.Animal;
import ru.javarush.animals.herbivore.*;

import java.util.List;

public abstract class Predator extends Animal {


    public Predator(int xLocation, int yLocation, int movingSpeed) {
        super(xLocation, yLocation, movingSpeed);
    }


    public void eat (Predator predator, List<Herbivore> herbivores){

        if (predator instanceof Anaconda){
            int appetite = ((Anaconda) predator).getHunger();
            if (appetite < Anaconda.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Anaconda.canEat) {((Anaconda) predator).setHunger((int) Anaconda.canEat);}
                else ((Anaconda) predator).setHunger(((Anaconda) predator).getHunger() + hunt);
            }
        }
        if (predator instanceof Bear){
            int appetite = ((Bear) predator).getHunger();
            if (appetite < Bear.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Bear.canEat) {((Bear) predator).setHunger((int) Bear.canEat);}
                else ((Bear) predator).setHunger(((Bear) predator).getHunger() + hunt);
            }
        }
        if (predator instanceof Eagle){
            int appetite = ((Eagle) predator).getHunger();
            if (appetite < Eagle.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Eagle.canEat) {((Eagle) predator).setHunger((int) Eagle.canEat);}
                else ((Eagle) predator).setHunger(((Eagle) predator).getHunger() + hunt);
            }
        }
        if (predator instanceof Fox){
            int appetite = ((Fox) predator).getHunger();
            if (appetite < Fox.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Fox.canEat) {((Fox) predator).setHunger((int) Fox.canEat);}
                else ((Fox) predator).setHunger(((Fox) predator).getHunger() + hunt);
            }
        }
        if (predator instanceof Wolf){
            int appetite = ((Wolf) predator).getHunger();
            if (appetite < Wolf.canEat){
                int hunt = predator.hunt(predator, herbivores);
                if (hunt > Wolf.canEat) {((Wolf) predator).setHunger((int) Wolf.canEat);}
                else ((Wolf) predator).setHunger(((Wolf) predator).getHunger() + hunt);
            }
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

    public void checkHealth(List<Predator> predators){
        if (this instanceof Anaconda){
            if (((Anaconda) this).getHunger() == 0){this.die(predators);}
            }
        if (this instanceof Eagle){
            if (((Eagle) this).getHunger() == 0){this.die(predators);}
        }
        if (this instanceof Bear){
            if (((Bear) this).getHunger() == 0){this.die(predators);}
        }
        if (this instanceof Fox){
            if (((Fox) this).getHunger() == 0){this.die(predators);}
        }
        if (this instanceof Wolf){
            if (((Wolf) this).getHunger() == 0){this.die(predators);}
        }
    }

    public void hunger(){
            if (this instanceof Anaconda){
                ((Anaconda) this).setHunger(((Anaconda) this).getHunger() - ((Anaconda) this).getHunger()/4);
            }
            if (this instanceof Bear){
                ((Bear) this).setHunger(((Bear) this).getHunger() - ((Bear) this).getHunger()/4);
            }
            if (this instanceof Eagle){
                ((Eagle) this).setHunger(((Eagle) this).getHunger() - ((Eagle) this).getHunger()/4);
            }
            if (this instanceof Fox){
                ((Fox) this).setHunger(((Fox) this).getHunger() - ((Fox) this).getHunger()/4);
            }
            if (this instanceof Wolf){
                ((Wolf) this).setHunger(((Wolf) this).getHunger() - ((Wolf) this).getHunger()/4);
            }
    }

}