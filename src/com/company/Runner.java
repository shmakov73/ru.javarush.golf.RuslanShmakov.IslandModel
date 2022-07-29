package com.company;

import com.company.animals.herbivore.Herbivore;
import com.company.island.Island;
import com.company.island.Location;

public class Runner {
    public static void main(String[] args) {

        Island island = new Island();
        //island.print();
        island.initialize();
        island.print();

    }
}
