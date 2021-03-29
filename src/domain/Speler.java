package domain;

import domain.DomainException;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) {
        if (naam == null) {
            throw new DomainException("naam mag niet null zijn.",new IllegalArgumentException());
        }
        if (naam.trim().isEmpty()) {
            throw new DomainException("De naam van de speler is niet correct.\nDe naam moet minstens 1 niet spatie bevatten.",new IllegalArgumentException());
        }
        this.naam = naam;
        this.score = 0;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }
    public void addToScore(int score) {
        if (this.score+score < 0) {
            throw new DomainException("de score moet positief zijn.",new IllegalArgumentException());
        }
        this.score += score;
    }
    public boolean equals(Object speler) {
        if (speler == null) {
            return false;
        }
        if (this.getScore() == ((Speler)speler).getScore() && this.getNaam().equals(((Speler) speler).getNaam())) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        String result = "";
        result += "Speler: " + this.getNaam() + "\n" + "Score: " + this.getScore();
        return result;
    }
}
