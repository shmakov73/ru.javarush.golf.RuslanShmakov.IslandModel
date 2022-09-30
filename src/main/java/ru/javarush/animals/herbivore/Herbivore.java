package ru.javarush.animals.herbivore;

import ru.javarush.animals.Animal;
import ru.javarush.plant.Plant;

import java.util.List;

public abstract class Herbivore extends Animal {

    public Herbivore(int xLocation, int yLocation, int movingSpeed) {
        super(xLocation, yLocation, movingSpeed);
    }


    public void eatPlant(List<Plant> plants) {
        if (this instanceof Boar) {
            int hunger = ((Boar) this).getHunger();
            while (hunger < Boar.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Boar) this).setHunger(hunger);
        }
        if (this instanceof Buffalo) {
            int hunger = ((Buffalo) this).getHunger();
            while (hunger < Buffalo.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Buffalo) this).setHunger(hunger);
        }
        if (this instanceof Caterpillar) {
            int hunger = ((Caterpillar) this).getHunger();
            while (hunger < Caterpillar.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Caterpillar) this).setHunger(hunger);
        }
        if (this instanceof Deer) {
            int hunger = ((Deer) this).getHunger();
            while (hunger < Deer.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Deer) this).setHunger(hunger);
        }
        if (this instanceof Duck) {
            int hunger = ((Duck) this).getHunger();
            while (hunger < Duck.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Duck) this).setHunger(hunger);
        }
        if (this instanceof Goat) {
            int hunger = ((Goat) this).getHunger();
            while (hunger < Goat.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Goat) this).setHunger(hunger);
        }
        if (this instanceof Horse) {
            int hunger = ((Horse) this).getHunger();
            while (hunger < Horse.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Horse) this).setHunger(hunger);
        }
        if (this instanceof Mouse) {
            int hunger = ((Mouse) this).getHunger();
            while (hunger < Mouse.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Mouse) this).setHunger(hunger);
        }
        if (this instanceof Rabbit) {
            int hunger = ((Rabbit) this).getHunger();
            while (hunger < Rabbit.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Rabbit) this).setHunger(hunger);
        }
        if (this instanceof Sheep) {
            int hunger = ((Sheep) this).getHunger();
            while (hunger < Sheep.canEat) {
                hunger++;
                plants.remove(0);
            }
            ((Sheep) this).setHunger(hunger);
        }
    }
    public void checkHealth(List<Herbivore> herbivores){
        if (this instanceof Boar){
            if (((Boar) this).getHunger() == 0){this.die(herbivores);
            }
        }
        if (this instanceof Buffalo){
            if (((Buffalo) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Caterpillar){
            if (((Caterpillar) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Deer){
            if (((Deer) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Duck){
            if (((Duck) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Goat){
            if (((Goat) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Horse){
            if (((Horse) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Mouse){
            if (((Mouse) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Rabbit){
            if (((Rabbit) this).getHunger() == 0){this.die(herbivores);
                }
        }
        if (this instanceof Sheep){
            if (((Sheep) this).getHunger() == 0){this.die(herbivores);
                }
        }
    }
    public void hunger(){
            if (this instanceof Boar){
                ((Boar) this).setHunger(((Boar) this).getHunger()/2);
            }
            if (this instanceof Buffalo){
                ((Buffalo) this).setHunger(((Buffalo) this).getHunger()/2);
            }
            if (this instanceof Caterpillar){
                ((Caterpillar) this).setHunger(((Caterpillar) this).getHunger()/2);
            }
            if (this instanceof Deer){
                ((Deer) this).setHunger(((Deer) this).getHunger()/2);
            }
            if (this instanceof Duck){
                ((Duck) this).setHunger(((Duck) this).getHunger()/2);
            }
            if (this instanceof Goat){
                ((Goat) this).setHunger(((Goat) this).getHunger()/2);
            }
            if (this instanceof Horse){
                ((Horse) this).setHunger(((Horse) this).getHunger()/2);
            }
            if (this instanceof Mouse){
                ((Mouse) this).setHunger(((Mouse) this).getHunger()/2);
            }
            if (this instanceof Rabbit){
                ((Rabbit) this).setHunger(((Rabbit) this).getHunger()/2);
            }
            if (this instanceof Sheep){
                ((Sheep) this).setHunger(((Sheep) this).getHunger()/2);
            }
    }

}
