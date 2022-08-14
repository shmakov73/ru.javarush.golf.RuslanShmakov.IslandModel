package com.company;

import com.company.animals.herbivore.Herbivore;
import com.company.island.Island;
import com.company.island.Location;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Runner {
    public static void main(String[] args) throws InterruptedException{

        Island island = new Island();
        island.initialize();
        System.out.println("*************************** Initialization *******************************************************************");
        //island.print();



        while (true){


            System.out.println("**************************** Migrate ******************************************************************");
            island.migrate();
            //island.print();
            System.out.println("**************************** Hunt ******************************************************************");
            island.hunt();
            //island.print();
            System.out.println("**************************** Reproduction ******************************************************************");
            island.reproduct();
            //island.print();
            Thread.sleep(1000);
        }

    }
}
