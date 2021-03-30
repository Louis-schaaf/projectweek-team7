package ui;

import domain.DomainException;
import domain.Driehoek;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoerX1Label, invoerY1Label,invoerX2Label, invoerY2Label,invoerX3Label, invoerY3Label ;
    private TextField invoerX1, invoerY1,invoerX2, invoerY2,invoerX3, invoerY3 ;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Driehoek driehoek;
    private Punt hoekPunt1,hoekPunt2,hoekPunt3;

    public DriehoekApp(GridPane root) {
        invoerX1Label =  new Label("Geef de x-coördinaat van een hoekpunt 1 ");
        invoerX1= new TextField();
        invoerY1Label = new Label("Geef de y-coördinaat van het hoekpunt 1");
        invoerY1 = new TextField();
        invoerX2Label =  new Label("Geef de x-coördinaat van een hoekpunt 2");
        invoerX2= new TextField();
        invoerY2Label = new Label("Geef de y-coördinaat van het hoekpunt 2");
        invoerY2 = new TextField();
        invoerX3Label =  new Label("Geef de x-coördinaat van een hoekpunt 3");
        invoerX3= new TextField();
        invoerY3Label = new Label("Geef de y-coördinaat van het hoekpunt 3");
        invoerY3 = new TextField();


        root.add(invoerX1Label,0,0);
        root.add(invoerX1,1,0);
        root.add(invoerY1Label,0,1);
        root.add(invoerY1,1,1);
        root.add(invoerX2Label,0,2);
        root.add(invoerX2,1,2);
        root.add(invoerY2Label,0,3);
        root.add(invoerY2,1,3);
        root.add(invoerX3Label,0,4);
        root.add(invoerX3,1,4);
        root.add(invoerY3Label,0,5);
        root.add(invoerY3,1,5);

        invoerX1.setOnAction(eventIngaveX ->{
            try {
                hoekPunt1 = new Punt(Integer.parseInt(invoerX1.getText()),Integer.parseInt(invoerY1.getText()));
                hoekPunt2 = new Punt(Integer.parseInt(invoerX2.getText()),Integer.parseInt(invoerY2.getText()));
                hoekPunt3 = new Punt(Integer.parseInt(invoerX3.getText()),Integer.parseInt(invoerY3.getText()));
                Driehoek driehoek = new Driehoek(hoekPunt1,hoekPunt2,hoekPunt3);

            }
            catch(NumberFormatException e){
                invoerX1.clear();
                invoerY1.clear();
                invoerX2.clear();
                invoerY2.clear();
                invoerX3.clear();
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch(DomainException de) {
                invoerX1.clear();
                invoerY1.clear();
                invoerX2.clear();
                invoerY2.clear();
                invoerX3.clear();
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();

            }
        });

    }
}
