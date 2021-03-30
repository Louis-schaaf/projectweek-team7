package ui;

import domain.DomainException;
import domain.Driehoek;
import domain.Punt;
import domain.Tekening;
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
        init(root, 0);
        invoerY3.setOnAction(eventIngaveY3 ->{
            try {
                Integer.parseInt(invoerY3.getText());
                hoekPunt1 = new Punt(Integer.parseInt(invoerX1.getText()),Integer.parseInt(invoerY1.getText()));
                hoekPunt2 = new Punt(Integer.parseInt(invoerX2.getText()),Integer.parseInt(invoerY2.getText()));
                hoekPunt3 = new Punt(Integer.parseInt(invoerX3.getText()),Integer.parseInt(invoerY3.getText()));
                Driehoek driehoek = new Driehoek(hoekPunt1,hoekPunt2,hoekPunt3);

                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0,0);

            }
            catch(NumberFormatException e){
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch(DomainException de) {
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();

            }
        });
    }

    public DriehoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerY3.setOnAction(eventIngaveY3 ->{
            try {
                Integer.parseInt(invoerY3.getText());
                hoekPunt1 = new Punt(Integer.parseInt(invoerX1.getText()),Integer.parseInt(invoerY1.getText()));
                hoekPunt2 = new Punt(Integer.parseInt(invoerX2.getText()),Integer.parseInt(invoerY2.getText()));
                hoekPunt3 = new Punt(Integer.parseInt(invoerX3.getText()),Integer.parseInt(invoerY3.getText()));
                Driehoek driehoek = new Driehoek(hoekPunt1,hoekPunt2,hoekPunt3);

                tekening.voegToe(driehoek);
                cleanUp(root);

            }
            catch(NumberFormatException e){
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch(DomainException de) {
                invoerY3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();

            }
        });
    }

    public void init(GridPane root, int teller) {
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

        root.add(invoerX1Label,0,teller);
        root.add(invoerX1,1,teller);

        invoerX1.setOnAction(eventIngaveX1 -> {
            try {
                Integer.parseInt(invoerX1.getText());
                root.add(invoerY1Label, 0, teller+1);
                root.add(invoerY1, 1, teller+1);
            }
            catch (NumberFormatException e) {
                invoerX1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("X coördinaat van punt 1 moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY1.setOnAction(eventIngaveY1 -> {
            try {
                Integer.parseInt(invoerY1.getText());
                root.add(invoerX2Label, 0, teller + 2);
                root.add(invoerX2, 1, teller + 2);
            } catch (NumberFormatException e) {
                invoerY1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Y coördinaat van punt 1 moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerX2.setOnAction(eventIngaveX2 -> {
            try {
                Integer.parseInt(invoerX2.getText());
                root.add(invoerY2Label, 0, teller+3);
                root.add(invoerY2, 1, teller+3);
            }
            catch (NumberFormatException e) {
                invoerX2.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("X coördinaat van punt 2 moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY2.setOnAction(eventIngaveY2 -> {
            try {
                Integer.parseInt(invoerY2.getText());
                root.add(invoerX3Label, 0, teller + 4);
                root.add(invoerX3, 1, teller + 4);
            } catch (NumberFormatException e) {
                invoerY1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Y coördinaat van punt 2 moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerX3.setOnAction(eventIngaveX3 -> {
            try {
                Integer.parseInt(invoerX3.getText());
                root.add(invoerY3Label, 0, teller+5);
                root.add(invoerY3, 1, teller+5);
            }
            catch (NumberFormatException e) {
                invoerX3.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("X coördinaat van punt 3 moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerX1Label);
        root.getChildren().remove(invoerX1);
        root.getChildren().remove(invoerY1Label);
        root.getChildren().remove(invoerY1);
        root.getChildren().remove(invoerX2Label);
        root.getChildren().remove(invoerX2);
        root.getChildren().remove(invoerY2Label);
        root.getChildren().remove(invoerY2);
        root.getChildren().remove(invoerX3Label);
        root.getChildren().remove(invoerX3);
        root.getChildren().remove(invoerY3Label);
        root.getChildren().remove(invoerY3);
    }
}
