package ui;

import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TekeningApp {
    private Label naamTekeningLabel;
    private TextField invoerNaamTekening;

    private ComboBox<String> keuzeMenu;
    private ObservableList<String> opties;

    private TextArea uitvoer;

    private Tekening tekening;

    public TekeningApp(GridPane root) {
        uitvoer = new TextArea();
        naamTekeningLabel = new Label("Geef de naam van je tekening: ");
        invoerNaamTekening = new TextField();

        opties = FXCollections.observableArrayList("Vorm maken","Tekening tonen","stop","");
        keuzeMenu = new ComboBox<>(opties);

        root.add(naamTekeningLabel,0,0);
        root.add(invoerNaamTekening,1,0);

        invoerNaamTekening.setOnAction(eventIngaveNaamTekening ->{
            String naamTekening = invoerNaamTekening.getText();
            if (!Tekening.isValidNaam(naamTekening)) {
                toonWaarschuwing("Naam van een tekening moet minimum 1 niet spatie bevatten");
            }else {
                tekening = new Tekening(naamTekening);

                root.getChildren().clear();
                root.add(keuzeMenu,0,0);
                root.add(uitvoer, 3, 0);

                uitvoer.setPrefRowCount(1);
                uitvoer.setPrefColumnCount(40);
                uitvoer.setVisible(false);
            }});

        keuzeMenu.setOnAction(eventKeuze -> {
            uitvoer.setVisible(false);
            if (keuzeMenu.getValue() != null) {

                if (keuzeMenu.getValue().equals("Vorm maken")) {
                    keuzeMenu.setValue("");
                    new VormMakenApp(root, tekening);

                } else if (keuzeMenu.getValue().equals("Tekening tonen")) {
                    keuzeMenu.setValue("");
                    uitvoer.setPrefRowCount(tekening.getAantalVormen()*2);
                    uitvoer.setText(tekening.toString());
                    uitvoer.setVisible(true);


                } else if (keuzeMenu.getValue().equals("stop")) {

                }

            }
        });


    }

    public void toonWaarschuwing(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Waarschuwing");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
