package Domain.model;

import java.util.ArrayList;

public class Woordenlijst {
    private ArrayList<Woord> woorden;

    public Woordenlijst(){
        this.woorden = new ArrayList<>();
    }

    public void verwijder(String woord) {
        if (woord == null || woord.trim().isEmpty()) throw new DomainException("Woord mag niet leeg zijn", new IllegalArgumentException());
        if (vind(woord) == null) throw new DomainException("Het woord dat u probeert te verwijderen staat niet in de woordenlijst", new IllegalArgumentException());
        Woord w = vind(woord);
        woorden.remove(w);
    }

    public void voegToe(Woord woord) {
        if (woord == null) throw new DomainException("Woord mag niet leeg zijn", new IllegalArgumentException());
        if (vind(woord.getWoord()) != null) throw new DomainException("Woord zit al in woordenlijst", new IllegalArgumentException());
        woorden.add(woord);
    }

    public ArrayList<Woord> getAlle() {
        return this.woorden;
    }

    public Woord vind(String woord){
        int index = -1;
        for (Woord w:woorden) {
            if(w.getWoord().equals(woord)){
                index = woorden.indexOf(w);
            }
        }
        if(index == -1) return null;
        return woorden.get(index);
    }

    public int getAantalWoorden(){
        return woorden.size();
    }

    public Woord getLangsteWoord(){
        if (woorden.size() != 0){
            Woord langste = woorden.get(0);
            for (Woord w:woorden) {
                if(langste.getAantalLetters() < w.getAantalLetters()){
                    langste = w;
                }
            }
            return langste;
        } else{
            return null;
        }
    }

    public Woord getKortsteWoord(){
        if (woorden.size() != 0){
            Woord kortste = woorden.get(0);
            for (Woord w:woorden) {
                if(kortste.getAantalLetters() > w.getAantalLetters()){
                    kortste = w;
                }
            }
            return kortste;
        } else{
            return null;
        }
    }

    public int getGemiddeldeVerschillendeLettersVanAlleWoorden(){
        if (woorden.size() == 0){
            return 0;
        }
        int gemiddelde = 0;
        for (Woord w: woorden) {
            gemiddelde += w.getVerschillendeLetters();
        }
        return gemiddelde / woorden.size();
    }

    public ArrayList<Woord> getBeginner() {
        ArrayList<Woord> Beginners = new ArrayList<>();
        for (Woord w:woorden) {
            if (w.getNiveau()!=null && w.getNiveau().equals("Beginner")){
                Beginners.add(w);
            }
        }
        return Beginners;
    }

    public ArrayList<Woord> getExpert() {
        ArrayList<Woord> Experts = new ArrayList<>();
        for (Woord w:woorden) {
            if (w.getNiveau()!=null && w.getNiveau().equals("Expert")){
                Experts.add(w);
            }
        }
        return Experts;
    }
}
