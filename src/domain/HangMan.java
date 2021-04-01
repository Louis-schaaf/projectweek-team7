package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;

    public HangMan(Speler speler,WoordenLijst woordenLijst) {
        if (speler == null) throw new DomainException("Speler ingeven aub", new IllegalArgumentException());
        this.speler=speler;
        if (woordenLijst==null) throw new DomainException("Woordenlijst ingeven aub", new IllegalArgumentException());
        if(woordenLijst.getAantalWoorden()==0) throw new DomainException("Woordenlijst mag niet leeg zijn", new IllegalStateException());
        this.woordenLijst = woordenLijst;
        tekeningHangMan = new TekeningHangMan();
        hintWoord = new HintWoord(woordenLijst.getRandomWoord());
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintWoord.toString()+"   ";
    }

    public boolean isGameOver() {
        return (tekeningHangMan.getAantalOnzichtBaar() == 0 );
    }

    public boolean isGewonnen() {
        gewonnen = hintWoord.isGeraden();
        return gewonnen;
    }

    public boolean raad(char letter) {
        boolean result = hintWoord.raad(letter);
        if (!result) {
            tekeningHangMan.zetVolgendeZichtbaar();
        }
        return result;
    }
}
