package domain;

import java.util.ArrayList;

public class Tekening {
    private String naam;
    private ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;


    public Tekening(String naam) {
        if (!isValidNaam(naam)) {
            throw new DomainException("Naam mag niet leeg zijn.", new IllegalArgumentException());
        }
        this.naam = naam;
        vormen = new ArrayList<>();
    }

    public static boolean isValidNaam(String naam) {
        return naam != null && !naam.isBlank();
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void voegToe(Vorm vorm) {
        if (vorm == null && this.bevat(vorm)) {
            throw new DomainException("Vorm mag niet leeg zijn en mag niet al voorkomen.",new IllegalArgumentException());
        }
        else {
            vormen.add(vorm);
        }
    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    public Vorm getVorm(int nr) {
        return vormen.get(nr);
    }

    public void verwijder(Vorm vorm) {
        vormen.remove(vorm);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tekening)) {
            return false;
        }
        else {
            if (this.getAantalVormen() == ((Tekening) obj).getAantalVormen()) {
                for (int i = 0; i < vormen.size(); i++) {
                    if (!this.bevat(((Tekening) obj).getVorm(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String uit = "Tekening: " + this.getNaam() + " \nAantal vormen: " + this.getAantalVormen() + "\nVormen: \n";
        for (Vorm v: vormen) {
            uit += v + "\n";
        }
        return uit;
    }
}
