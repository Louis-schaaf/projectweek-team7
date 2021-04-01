package domain;

import java.util.ArrayList;

public class WoordenLijst {
    private ArrayList<String> lijst;


    public WoordenLijst() {
        this.lijst = new ArrayList<>();
    }

    public void voegToe(String s) {
        if (s == null) {
            throw new DomainException("string mag niet null zijn.", new IllegalArgumentException());
        }
        if (s.isEmpty()) {
            throw new DomainException("geef een geldige string in.", new IllegalArgumentException());
        }
        if (lijst.contains(s)) {
            throw new DomainException("je mag geen woord toevoegen dat al in de lijst zit.", new IllegalArgumentException());
        }
        this.lijst.add(s);
    }

    public int getAantalWoorden() {
        return lijst.size();
    }

    public String getRandomWoord() {
        if (lijst.size() < 1) {
            throw new DomainException("de lijst is leeg.", new IllegalArgumentException());
        }
        return lijst.get((int) (Math.random() * (lijst.size() - 1)));
    }

    }
