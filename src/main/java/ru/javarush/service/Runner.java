package ru.javarush.service;

import ru.javarush.island.Island;

public class Runner {
    public static void main(String[] args) throws InterruptedException{

        Island island = new Island();
        island.initialize();
        System.out.println("*************************** Initialization *******************************************************************");



        while (true){


            System.out.println("**************************** Migrate ******************************************************************");
            island.migrate();
            System.out.println("**************************** Hunt ******************************************************************");
            island.hunt();
            System.out.println("**************************** Reproduction ******************************************************************");
            island.reproduct();
            Thread.sleep(1000);
        }

    }
}
