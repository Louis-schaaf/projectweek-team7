package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class FXCirkelApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800,600);

        new ui.CirkelApp(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cirkel App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

