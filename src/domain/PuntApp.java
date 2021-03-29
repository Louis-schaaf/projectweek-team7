package ui;

import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PuntApp {
    private Label invoerXLabel, invoerYLabel;
    private TextField invoerX, invoerY;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    
    private Punt punt;

    public PuntApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coördinaat van het punt ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van het punt ");
        invoerY = new TextField();

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

        invoerY.setOnAction(eventIngaveY -> {
            try {
                punt = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(punt.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}
