
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import domain.*;

public class FxTekenHangManApp extends Application {
    private Button maakVolgendeZichtbaarKnop = new Button("maak volgende zichtbaar");

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,400,400);
        TekeningHangMan tekening = new TekeningHangMan();
        primaryStage.setScene(scene);
        root.getChildren().add(maakVolgendeZichtbaarKnop);

        primaryStage.setTitle("hangman");
        primaryStage.show();
        TekenVenster t = new TekenVenster(root,tekening);

        maakVolgendeZichtbaarKnop.setOnAction(eventMaakVolgendeZichtbaar -> {
               try {
                   tekening.zetVolgendeZichtbaar();
                   new TekenVenster(root, tekening);
               } catch (DomainException e){
                   maakVolgendeZichtbaarKnop.setDisable(true);
               }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
