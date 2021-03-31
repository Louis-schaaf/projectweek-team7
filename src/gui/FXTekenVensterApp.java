package gui;

import domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXTekenVensterApp extends Application {

    private TextField invoerNaam;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,300,300);
        invoerNaam = new TextField("Geef de naam van de tekening");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
                    primaryStage.setTitle(invoerNaam.getText());
                    root.getChildren().clear();
                    Tekening tekening = new Tekening(invoerNaam.getText());

                    Cirkel boomkruin = new Cirkel(new Punt(50, 50), 40);
                    LijnStuk boomstam = new LijnStuk(new Punt(50, 90), new Punt(50, 240));
                    Rechthoek gebouw = new Rechthoek(new Punt(100, 90), 100, 150);
                    Driehoek dak = new Driehoek(new Punt(100, 90), new Punt(200, 90), new Punt(150, 45));


                    dak.setKleur(Color.RED);
                    boomkruin.setKleur(Color.GREEN);
                    gebouw.setKleur(Color.WHITE);
                    tekening.voegToe(boomstam);
                    tekening.voegToe(boomkruin);
                    tekening.voegToe(gebouw);
                    tekening.voegToe(dak);

                    new TekenVenster(root, tekening);
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
