package domain;

import java.util.ArrayList;

public class Tekening {
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;
    private String naam;
    private ArrayList<Vorm> vormen;


    public Tekening(String naam) {
        if (!isValidNaam(naam)) {
            throw new DomainException("Naam mag niet leeg zijn.", new IllegalArgumentException());
        }
        this.naam = naam;
        vormen = new ArrayList<>();
    }

    public static boolean isValidNaam(String naam) {
        return naam != null && !naam.trim().isEmpty();
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void voegToe(Vorm vorm) {
        if (vorm == null || this.bevat(vorm)) {
            throw new DomainException("Vorm mag niet leeg zijn en mag niet al voorkomen.", new IllegalArgumentException());
        }
        Omhullende omhullende = vorm.getOmhullende();
        if (omhullende.getMinimumX()<MIN_X || omhullende.getMinimumY()<MIN_Y || omhullende.getMaximumX()>MAX_X || omhullende.getMaximumY()>MAX_Y){
            throw new DomainException("De vorm die u wilt toevoegen past niet binnen het tekenvenster", new IllegalArgumentException());
        }
        vormen.add(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    public Vorm getVorm(int nr) {
        if (nr < 0 || nr >= vormen.size())
            throw new DomainException("Index mag niet kleiner zijn dan 0, of groter dan het aantal elementen", new IllegalArgumentException());
        return vormen.get(nr);
    }

    public void verwijder(Vorm vorm) {
        if (!this.bevat(vorm)) throw new DomainException("Vorm zit niet in deze tekening.", new IllegalArgumentException());
        vormen.remove(vorm);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tekening)) {
            return false;
        } else {
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
        for (Vorm v : vormen) {
            uit += v + "\n";
        }
        return uit;
    }
}
