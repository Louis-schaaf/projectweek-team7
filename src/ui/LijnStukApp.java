package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnStukApp {
    private Label invoerX1Label, invoerY1Label, invoerX2Label, invoerY2Label;
    private TextField invoerX1, invoerY1, invoerX2, invoerY2;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private LijnStuk lijnstuk;
    private Punt p1, p2;

    public LijnStukApp(GridPane root) {
        invoerX1Label = new Label("Geef de x-coördinaat van het eerste punt in ");
        invoerX1 = new TextField();
        invoerY1Label = new Label("Geef de y-coördinaat van het eerste punt in ");
        invoerY1 = new TextField();
        invoerX2Label = new Label("Geef de x-coördinaat van het tweede punt in ");
        invoerX2 = new TextField();
        invoerY2Label = new Label("Geef de y-coördinaat van het tweede punt in ");
        invoerY2 = new TextField();


        root.add(invoerX1Label, 0, 0);
        root.add(invoerX1, 1, 0);

        invoerX1.setOnAction(eventIngaveX1 -> {
            try {
                Integer.parseInt(invoerX1.getText());
                root.add(invoerY1Label, 0, 1);
                root.add(invoerY1, 1, 1);
            } catch (NumberFormatException e) {
                invoerX1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY1.setOnAction(eventIngaveY1 -> {
            try {
                Integer.parseInt(invoerY1.getText());

                p1 = new Punt(Integer.parseInt(invoerX1.getText()), Integer.parseInt(invoerY1.getText()));

                root.add(invoerX2Label, 0, 2);
                root.add(invoerX2, 1, 2);
            } catch (NumberFormatException e) {
                invoerY1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException de) {
                invoerY1.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();
            }
        });

        invoerX2.setOnAction(eventIngaveX2 -> {
            try {
                Integer.parseInt(invoerX2.getText());
                root.add(invoerY2Label, 0, 3);
                root.add(invoerY2, 1, 3);
            } catch (NumberFormatException e) {
                invoerX2.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY2.setOnAction(eventIngaveY2 -> {
            try {
                p2 = new Punt(Integer.parseInt(invoerX2.getText()), Integer.parseInt(invoerY2.getText()));

                lijnstuk = new LijnStuk(p1, p2);

                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnstuk.toString());
                root.add(uitvoer, 0, 0);
            } catch (NumberFormatException e) {
                invoerY2.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException de) {
                invoerY2.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(de.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
}
