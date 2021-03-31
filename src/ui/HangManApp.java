package ui;

import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HangManApp {
    private HBox hbox= new HBox();
    private HBox invoerBox = new HBox();

    private Text hintwoordUitvoer = new Text();
    private Button raadButton = new Button("raad");
    private TextField invoerLetter = new TextField("Welke letter?");
    private HangMan hangman ;

    private TekenVenster tekening;
    private Pane pane = new Pane();
    private int aantal = 0;


    public HangManApp(VBox root, Speler speler, WoordenLijst woordenlijst) {
        this.hangman = new HangMan(speler, woordenlijst);
        this.tekening = new TekenVenster(pane,this.hangman.getTekening());

        hintwoordUitvoer.setText(this.hangman.getHint());
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().add(hintwoordUitvoer);
        hbox.getChildren().add(raadButton);
        invoerBox.getChildren().add(invoerLetter);
        invoerBox.setDisable(true);


        root.getChildren().addAll(pane, hbox, invoerBox);


        raadButton.setOnAction(eventRaad ->{
            aantal++;
            if (hangman.isGewonnen()) {
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("Goed gedaan " + speler.getNaam() + " je hebt het woord geraden in " + aantal + " stappen!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else if (hangman.isGameOver()){
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("Jammer " + speler.getNaam() + " je hebt het woord niet geraden!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else{
                invoerBox.setDisable(false);
                invoerLetter.clear();
            }

        });

        invoerLetter.setOnAction(eventIngaveLetter -> {
            if (hangman.raad(invoerLetter.getText().charAt(0))) {
                hintwoordUitvoer.setText(this.hangman.getHint());
            }
            else {
                this.tekening = new TekenVenster(pane,this.hangman.getTekening());
            }
            invoerBox.setDisable(true);
        });

    }
}
