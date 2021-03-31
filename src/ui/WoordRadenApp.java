package ui;

import domain.HintWoord;
import domain.Speler;
import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class WoordRadenApp {
    private Label naamLabel, woordLabel, letterLabel;
    private Label goed = new Label("Super doe zo voort!");
    private Label slecht = new Label("Helaas volgende keer beter.");
    private Label einde = new Label("Proficiat, je hebt het woord geraden!");

    private TextField invoerLetter;
    private TextArea uitvoer;
    private HintWoord woord = new HintWoord("Hangmanspelletje");


    public WoordRadenApp(GridPane root, Speler speler) {

        uitvoer = new TextArea();
        naamLabel = new Label("Rara welk woord zoeken we? ");
        woordLabel = new Label(woord.toString());
        letterLabel = new Label("Geef een letter:");
        invoerLetter = new TextField();


        root.add(naamLabel, 0, 0);
        root.add(woordLabel, 0, 1);
        root.add(letterLabel, 0, 2);
        root.add(invoerLetter, 0, 3);

        invoerLetter.setOnAction(eventIngaveLetter -> {
            String raadLetter = invoerLetter.getText();
            if (raadLetter == null || raadLetter.trim().isEmpty() || raadLetter.length() > 1) {
                toonWaarschuwing("1 letter ingeven aub.");
            } else {
                root.getChildren().clear();
                if (woord.raad(raadLetter.charAt(0))) {
                    if (woord.isGeraden()) {
                        root.add(einde,0,0);
                        return;
                    } else {
                        root.add(goed, 0, 0);
                    }
                } else {
                    root.add(slecht, 0, 0);
                }
                woordLabel.setText(woord.toString());
                invoerLetter.clear();
                root.add(naamLabel, 0, 1);
                root.add(woordLabel, 0, 2);
                root.add(letterLabel, 0, 3);
                root.add(invoerLetter, 0, 4);

            }
        });

    }

    public void toonWaarschuwing(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Waarschuwing");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
