package ui;

import domain.Cirkel;
import domain.DomainException;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp1 {
    private Label invoerXLabel, invoerYLabel, invoerRadiusLabel;
    private TextField invoerX, invoerY, invoerRadius;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Cirkel cirkel;
    private Punt middelpunt;

    public CirkelApp1(GridPane root) {
        invoerXLabel =  new Label("Geef de x-coördinaat van het middelpunt ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van het middelpunt ");
        invoerY = new TextField();
        invoerRadiusLabel = new Label("Geef de straal van de cirkel ");
        invoerRadius = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY ->{
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerRadiusLabel, 0, 2);
                root.add(invoerRadius, 1, 2);
            }
            catch(NumberFormatException e){
                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerRadius.setOnAction(eventIngaveRadius ->{
            try {
                int radius = Integer.parseInt(invoerRadius.getText());
                if (radius<= 0 ) throw new DomainException("Radius moet positief zijn.", new IllegalArgumentException());
                middelpunt = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                cirkel = new Cirkel (middelpunt, radius);


                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(cirkel.toString());
                root.add(uitvoer, 0, 0);
            }
            catch(NumberFormatException e){
                invoerRadius.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Radius moet groter zijn dan 0");
                foutenboodschap.showAndWait();
            } catch (DomainException de){
                invoerRadius.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();
            }
        });

    }
}
