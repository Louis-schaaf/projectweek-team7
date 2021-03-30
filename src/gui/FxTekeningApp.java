package gui;

import domain.Tekening;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.TekeningApp;
import ui.VormMakenApp;

public class FxTekeningApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root,800,600);
        Tekening tekening = new Tekening("test");
        new VormMakenApp(root, tekening);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Almost hangman :) ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
