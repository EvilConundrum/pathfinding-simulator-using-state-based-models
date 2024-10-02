package intsy.group7.pathfinder_sim;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String  fxmlPath = "/view/MainView.fxml";
        URL     resource = getClass().getResource(fxmlPath);
        assert  resource != null;
        Parent  root = FXMLLoader.load(resource);
        Scene   scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            Platform.exit();         // Shuts down the JavaFX application cleanly, including all threads
            System.exit(0);   // Ensures that the JVM shuts down completely
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}