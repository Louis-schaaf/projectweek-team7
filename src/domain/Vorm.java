package domain;

import java.awt.*;

public abstract class Vorm {
//    public abstract Punt getMiddelPunt();
    private Color kleur;

    public Color getKleur() {
        return this.kleur;
    }

    public abstract String toString();
//    public abstract Omhullende getOmhullende();
}

