package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxFiguurApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800,600);
        new FiguurApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Figuur App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
