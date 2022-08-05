package com.company;

import com.company.animals.herbivore.Herbivore;
import com.company.island.Island;
import com.company.island.Location;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Island island = new Island();
        island.initialize();


        while (true){

            island.print();
            System.out.println("**********************************************************************************************");
            island.migrate();
            island.print();
            System.out.println("**********************************************************************************************");
            island.hunt();
            island.print();
            Thread.sleep(1000);
        }

    }
}
