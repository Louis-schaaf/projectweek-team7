package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxPuntApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root,200,100);
        new PuntApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Punt App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
