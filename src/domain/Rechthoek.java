package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rechthoek extends Vorm implements Drawable {
     private int breedte, hoogte;
     private Punt linkerBovenHoek;


    public Rechthoek(Punt linkerBovenHoek, int breedte, int hoogte) {
        if (breedte <= 0) throw new DomainException("Breedte moet groter zijn dan 0", new IllegalArgumentException());
        if (hoogte <= 0) throw new DomainException("Hoogte moet groter zijn dan 0", new IllegalArgumentException());
        if (linkerBovenHoek == null) throw new DomainException("Punt mag niet leeg zijn", new IllegalArgumentException());

        this.breedte = breedte;
        this.hoogte = hoogte;
        this.linkerBovenHoek = linkerBovenHoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    @Override
    public void teken(Pane root) {
        Rectangle rechthoek = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(), this.getHoogte());
        root.getChildren().addAll(rechthoek);
        rechthoek.setStroke(Color.BLACK);
        rechthoek.setFill(super.getKleur());

    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(linkerBovenHoek,breedte,hoogte);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Rechthoek){
            Rechthoek r = (Rechthoek) obj;
            return (this.getBreedte() == r.getBreedte() && this.getHoogte() == r.getHoogte() && this.getLinkerBovenhoek().equals(r.getLinkerBovenhoek()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rechthoek: " +
                "linkerbovenhoek: " + linkerBovenHoek +
                " - breedte: " + breedte +
                " - hoogte: " + hoogte+
                "\nOmhullende: "+linkerBovenHoek+" - "+breedte+" - "+hoogte;

    }
}
