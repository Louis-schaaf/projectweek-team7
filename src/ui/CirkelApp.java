package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {

    private Label invoerXLabel, invoerYLabel, invoerStraalLabel;
    private TextField invoerX, invoerY, invoerStraal;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Vorm vorm;

    public CirkelApp(GridPane root) {

        init(root,0);
        invoerStraal.setOnAction(eventIngaveStraal -> {
            try {
                Punt middelpunt = new Punt(Integer.parseInt(invoerX.getText()),Integer.parseInt(invoerY.getText()));
                vorm = new Cirkel(middelpunt, Integer.parseInt(invoerStraal.getText()));
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer,0,0);

            }catch (NumberFormatException ne){
                invoerStraal.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                invoerStraal.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }


    public CirkelApp(GridPane root, Tekening tekening) {
        init(root,1);
        invoerStraal.setOnAction(eventIngaveStraal -> {
            try {
                Punt middelpunt = new Punt(Integer.parseInt(invoerX.getText()),Integer.parseInt(invoerY.getText()));
                vorm = new Cirkel(middelpunt, Integer.parseInt(invoerStraal.getText()));
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException ne){
                invoerStraal.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
            catch (DomainException e){
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller){
        invoerXLabel =  new Label("Geef de x-coördinaat van het middelpunt van de cirkel ");
        invoerX= new TextField();

        invoerYLabel = new Label("Geef de y-coördinaat van het middelpunt van de cirkel ");
        invoerY = new TextField();

        invoerStraalLabel = new Label("Geef de straal van de cirkel");
        invoerStraal = new TextField();

        root.add(invoerXLabel,0,teller);
        root.add(invoerX,1,teller);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, teller + 1);
                root.add(invoerY, 1, teller + 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van middelpunt van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerStraalLabel, 0, teller + 2);
                root.add(invoerStraal, 1, teller +  2);
            } catch (NumberFormatException e){
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van middelpunt van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });
    }
    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerXLabel);
        root.getChildren().remove(invoerX);
        root.getChildren().remove(invoerYLabel);
        root.getChildren().remove(invoerY);
        root.getChildren().remove(invoerStraalLabel);
        root.getChildren().remove(invoerStraal);

    }
}
