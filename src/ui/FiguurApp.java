package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FiguurApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root) {
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek","Lijnstuk");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu,0,0);
        keuzeMenu.setOnAction(eventKeuze -> {
                    keuzeMenu.setVisible(false);
                    if (keuzeMenu.getValue()!=null){
						if (keuzeMenu.getValue().equals("Cirkel")) {
                            new CirkelApp1(root);
                        }else if (keuzeMenu.getValue().equals("Rechthoek")) {
							new RechthoekApp(root);
						} else if (keuzeMenu.getValue().equals("Lijnstuk")){
						    new LijnStukApp(root);
                        }

                }
		});
    }
}
