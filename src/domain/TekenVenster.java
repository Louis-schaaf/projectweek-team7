package domain;

import javafx.scene.layout.GridPane;
import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import ui.UiException;


public class TekenVenster {
    private Tekening tekening;

    public TekenVenster(Pane root, Tekening tekening){
        Cirkel boomkruin = new Cirkel(new Punt(50,50), 40);
        LijnStuk boomstam = new LijnStuk(new Punt(50,90), new Punt(50,240));
        Rechthoek gebouw = new Rechthoek(new Punt(100, 90), 100, 150);
        Driehoek dak = new Driehoek(new Punt(100, 90), new Punt(200, 90), new Punt(150, 45));


        dak.setKleur(Color.RED);
        boomkruin.setKleur(Color.GREEN);
        gebouw.setKleur(Color.WHITE);


        if (tekening == null) throw new UiException();
        this.tekening = tekening;

        tekening.voegToe(boomstam);
        tekening.voegToe(boomkruin);
        tekening.voegToe(gebouw);
        tekening.voegToe(dak);

        tekening.teken(root);
    }
}
