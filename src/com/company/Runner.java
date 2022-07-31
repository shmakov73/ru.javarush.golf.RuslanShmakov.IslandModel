package com.company;

import com.company.animals.herbivore.Herbivore;
import com.company.island.Island;
import com.company.island.Location;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Island island = new Island();
        //island.print();
        island.initialize();
        island.print();
        island.migrate();
        Thread.sleep(3000);
        System.out.println("**********************************************************************************************");
        island.print();

    }
}
