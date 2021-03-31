package domain;


import javafx.scene.paint.Color;

public abstract class Vorm {
    private Color kleur;
    private boolean isZichtbaar = true;

    public Color getKleur() {
        return this.kleur;
    }

    public void setKleur(Color kleur) {
        if (kleur == null) throw new DomainException("Kleur is leeg", new IllegalArgumentException());
        this.kleur = kleur;
    }

    public abstract String toString();

    public abstract Omhullende getOmhullende();

    public boolean isZichtbaar(){
        return this.isZichtbaar;
    }

    public void setZichtbaar(boolean bool){
        this.isZichtbaar = bool;
    }



}

