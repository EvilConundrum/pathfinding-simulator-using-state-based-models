module intsy.group7.pathfinder_sim {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens intsy.group7.pathfinder_sim.controller to javafx.fxml;
    exports intsy.group7.pathfinder_sim;
}
