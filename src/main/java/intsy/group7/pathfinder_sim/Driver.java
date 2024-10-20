package intsy.group7.pathfinder_sim;


import intsy.group7.pathfinder_sim.model.*;
import intsy.group7.pathfinder_sim.controller.*;
import intsy.group7.pathfinder_sim.controller.MainController;
import intsy.group7.pathfinder_sim.view.*;

public class Driver{
    public static void main(String[] args) {
        System.out.println("Test Print");
        
        ViewAlgorithmPage view = new ViewAlgorithmPage();

        new MainController(view);

    }
}