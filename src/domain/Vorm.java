package domain;

import java.awt.*;

public abstract class Vorm {
    private Color kleur;

    public Color getKleur() {
        return this.kleur;
    }

    public void setKleur(Color kleur) {
        if (kleur == null) throw new DomainException("Kleur is leeg", new IllegalArgumentException());
        this.kleur = kleur;
    }

    public abstract String toString();

    public abstract Omhullende getOmhullende();
}

