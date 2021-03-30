package domain;

import java.awt.*;

public abstract class Vorm {
    private Color kleur;

    public Color getKleur() {
        return this.kleur;
    }

    public abstract String toString();
    public abstract Omhullende getOmhullende();
    public abstract Punt getMiddelPunt();
}

