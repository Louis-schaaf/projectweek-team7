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
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root);
    }

    public void teken(Pane root) {

        Cirkel boomkruin = new Cirkel(new Punt(50,50), 40);
        LijnStuk boomstam = new LijnStuk(new Punt(50,90), new Punt(50,240));
        Rechthoek gebouw = new Rechthoek(new Punt(100, 90), 100, 150);
        Driehoek dak = new Driehoek(new Punt(100, 90), new Punt(200, 90), new Punt(150, 45));

        Circle cirkelBoomKruin = new Circle(boomkruin.getMiddelpunt().getX(), boomkruin.getMiddelpunt().getY(), boomkruin.getRadius());
        cirkelBoomKruin.setFill(Color.GREEN);
        cirkelBoomKruin.setStroke(Color.BLACK);
        Line lijnBoomstam = new Line(boomstam.getStartPunt().getX(), boomstam.getStartPunt().getY(), boomstam.getEindPunt().getX(), boomstam.getEindPunt().getY());
        lijnBoomstam.setStrokeWidth(5);
        Rectangle rechthoekGebouw = new Rectangle(gebouw.getLinkerBovenhoek().getX(), gebouw.getLinkerBovenhoek().getY(), gebouw.getBreedte(), gebouw.getHoogte());
        rechthoekGebouw.setFill(Color.WHITE);
        rechthoekGebouw.setStroke(Color.BLACK);
        Polyline driehoekDak = new Polyline();
        driehoekDak.setFill(Color.RED);
        driehoekDak.setStroke(Color.BLACK);
        driehoekDak.getPoints().addAll(new Double[]{(double) dak.getHoekPunt1().getX(), (double) dak.getHoekPunt1().getY(), (double) dak.getHoekPunt2().getX(),
                (double) dak.getHoekPunt2().getY(), (double) dak.getHoekPunt3().getX(), (double) dak.getHoekPunt3().getY()});

        root.getChildren().addAll(cirkelBoomKruin, lijnBoomstam, rechthoekGebouw, driehoekDak);

    }
}
