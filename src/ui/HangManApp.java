package ui;

import domain.HangMan;
import domain.Speler;
import domain.TekenVenster;
import domain.WoordenLijst;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HangManApp {
    private HBox hbox= new HBox();
    private HBox invoerBox = new HBox();
    private HBox fouteletters = new HBox();

    private Text hintwoordUitvoer = new Text();
    private Button raadButton = new Button("Start");
    private Label raden = new Label("   Welke letter?  ");
    private Label feedback = new Label("   Rara welk woord raden we?   ");
    private Label fout = new Label("");
    private TextField invoerLetter = new TextField();
    private HangMan hangman ;

    private TekenVenster tekening;
    private Pane pane = new Pane();
    private int aantal = 0;

    private StringBuffer fouten = new StringBuffer();
    private String foutstring;



    public HangManApp(VBox root, Speler speler, WoordenLijst woordenlijst) {
        this.hangman = new HangMan(speler, woordenlijst);
        this.tekening = new TekenVenster(pane,this.hangman.getTekening());

        hintwoordUitvoer.setText(this.hangman.getHint());
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().add(feedback);
        hbox.getChildren().add(hintwoordUitvoer);
        hbox.getChildren().add(raadButton);
        fouteletters.getChildren().add(fout);
        invoerBox.getChildren().add(raden);
        invoerBox.getChildren().add(invoerLetter);

        invoerBox.setDisable(true);


        root.getChildren().addAll(pane, hbox, fouteletters,invoerBox);


        raadButton.setOnAction(eventRaad ->{
            aantal++;
            if (hangman.isGewonnen()) {
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("   Goed gedaan " + speler.getNaam() + " je hebt het woord geraden in " + aantal + " stappen!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else if (hangman.isGameOver()){
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("   Jammer " + speler.getNaam() + " je hebt het woord niet geraden!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else{
                invoerBox.setDisable(false);
                raadButton.setVisible(false);
                //invoerLetter.clear();
            }


        });

        invoerLetter.setOnAction(eventIngaveLetter -> {
            if (hangman.raad(invoerLetter.getText().charAt(0))) {
                hintwoordUitvoer.setText(this.hangman.getHint());
                feedback.setText("   Goed zo, doe zo verder!   ");

            }
            else {
                this.tekening = new TekenVenster(pane,this.hangman.getTekening());
                feedback.setText("   Ai, volgende keer beter   ");
                fouten.append(invoerLetter.getText().charAt(0));
                fouten.append(" ");
            }
            invoerBox.setDisable(true);
            invoerLetter.clear();
            raadButton.setText("Volgende poging");
            raadButton.setVisible(true);
            foutstring = fouten.toString();
            fout.setText("   Foute pogingen: "+foutstring);

        }
        );

    }
}
