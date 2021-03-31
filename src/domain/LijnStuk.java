package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable {
    private Punt startPunt, eindPunt;

    public LijnStuk (Punt startPunt, Punt eindPunt){
        setStartEnEindPunt(startPunt,eindPunt);
    }

    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        if(startPunt == null ) throw new DomainException("Startpunt mag niet leeg zijn", new IllegalArgumentException());
        if(eindPunt == null ) throw new DomainException("Eindpunt mag niet leeg zijn", new IllegalArgumentException());
        if(startPunt.equals(eindPunt)) throw new DomainException("Start en eindpunt mogen niet hetzelfde punt zijn.", new IllegalArgumentException());

        this.eindPunt = eindPunt;
        this.startPunt = startPunt;
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof LijnStuk)) return false;
        else {
            LijnStuk l = (LijnStuk) obj;
            return (this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())) ||
                    (this.getEindPunt().equals(l.getStartPunt()) && this.getStartPunt().equals(l.getEindPunt())) ;
        }
    }

    @Override
    public String toString() {
        return "Lijn: " +
                "startpunt: " + startPunt +
                " - eindpunt: " + eindPunt;
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinksbovenPunt(),getBreedte(),getHoogte());
    }

    public Punt getLinkerPunt() {
        if (startPunt.getX() < eindPunt.getX()) {
            return startPunt;
        } else {
            return eindPunt;
        }
    }

    private Punt getAnderPunt(Punt punt) {
        if (punt.equals(startPunt)) {
            return eindPunt;
        } else {
            return startPunt;
        }
    }

    private Punt getLinksbovenPunt() {
        if (getLinkerPunt().getY() > getAnderPunt(getLinkerPunt()).getY()) {
            return new Punt(getLinkerPunt().getX(),getAnderPunt(getLinkerPunt()).getY());
        } else {
            return getLinkerPunt();
        }
    }

    public int getHoogte() {
        if (getLinkerPunt().getY() < getAnderPunt(getLinkerPunt()).getY()) {
            return getAnderPunt(getLinkerPunt()).getY()-getLinkerPunt().getY();
        } else {
            return getLinkerPunt().getY()-getAnderPunt(getLinkerPunt()).getY();
        }
    }

    public int getBreedte() {
        return getAnderPunt(getLinkerPunt()).getX()-getLinkerPunt().getX();
    }

    @Override
    public void teken(Pane root) {
        Line lijn = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
        lijn.setStrokeWidth(5);
        root.getChildren().add(lijn);
    }
}
