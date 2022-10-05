package ru.javarush.service;

import ru.javarush.IslandStarter;
import ru.javarush.animals.herbivore.*;
import ru.javarush.animals.predator.*;
import ru.javarush.island.Island;
import ru.javarush.island.Location;

public class Statistics implements Runnable {

    Location[][] locations;
    Island island;


    public Statistics(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        locations = island.getLocations();

        int total = 0;

        for (Location[] location : locations) {
            for (Location value : location) {
                total = total + calculate(value);
            }
        }

        if (total > 0){
        System.out.println("Total animal count: " + total);
        System.out.println("***********************************************************************************");
        System.out.println();
        }
        else IslandStarter.stop();
    }

    public int calculate(Location location){
        int boar = location.getHerbivores().stream().filter(animal -> animal instanceof Boar).toList().size();
        int buffalo = location.getHerbivores().stream().filter(animal -> animal instanceof Buffalo).toList().size();
        int caterpillar = location.getHerbivores().stream().filter(animal -> animal instanceof Caterpillar).toList().size();
        int deer = location.getHerbivores().stream().filter(animal -> animal instanceof Deer).toList().size();
        int duck = location.getHerbivores().stream().filter(animal -> animal instanceof Duck).toList().size();
        int goat = location.getHerbivores().stream().filter(animal -> animal instanceof Goat).toList().size();
        int horse = location.getHerbivores().stream().filter(animal -> animal instanceof Horse).toList().size();
        int mouse = location.getHerbivores().stream().filter(animal -> animal instanceof Mouse).toList().size();
        int rabbit = location.getHerbivores().stream().filter(animal -> animal instanceof Rabbit).toList().size();
        int sheep = location.getHerbivores().stream().filter(animal -> animal instanceof Sheep).toList().size();
        int anaconda = location.getPredators().stream().filter(animal -> animal instanceof Anaconda).toList().size();
        int bear = location.getPredators().stream().filter(animal -> animal instanceof Bear).toList().size();
        int eagle = location.getPredators().stream().filter(animal -> animal instanceof Eagle).toList().size();
        int fox = location.getPredators().stream().filter(animal -> animal instanceof Fox).toList().size();
        int wolf = location.getPredators().stream().filter(animal -> animal instanceof Wolf).toList().size();

        System.out.print("Total animal count on location : " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf + " |"));
        System.out.print(": 🐗 Boar=" + boar);
        System.out.print("| \uD83D\uDC03 Buffalo=" + buffalo);
        System.out.print("| \uD83D\uDC1B Caterpillar=" + caterpillar);
        System.out.print("| \uD83E\uDD8C Deer" + deer);
        System.out.print("| \uD83E\uDD86 Duck=" + duck);
        System.out.print("| \uD83D\uDC10 Goat=" + goat);
        System.out.print("| \uD83D\uDC0E Horse=" + horse);
        System.out.print("| \uD83D\uDC01 Mouse=" + mouse);
        System.out.print("| \uD83D\uDC07 Rabbit=" + rabbit);
        System.out.print("| \uD83D\uDC11 Sheep=" + sheep);
        System.out.print("| \uD83D\uDC0D Anaconda=" + anaconda);
        System.out.print("| \uD83D\uDC3B Bear=" + bear);
        System.out.print("| \uD83E\uDD85 Eagle=" + eagle);
        System.out.print("| \uD83E\uDD8A Fox=" + fox);
        System.out.print("| \uD83D\uDC3A Wolf=" + wolf);
        System.out.println();

        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + anaconda + bear + eagle + fox + wolf);
    }
}
