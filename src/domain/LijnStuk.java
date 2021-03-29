package domain;

public class LijnStuk extends Vorm {
    private Punt startPunt, eindPunt;

    public LijnStuk (Punt startPunt, Punt eindPunt){
        setStartEnEindPunt(startPunt,eindPunt);
    }

    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        if(startPunt == null ) throw new DomainException("Startpunt mag niet leeg zijn", new IllegalArgumentException());
        if(eindPunt == null ) throw new DomainException("Eindpunt mag niet leeg zijn", new IllegalArgumentException());
        if(startPunt.equals(eindPunt)) throw new DomainException("Start en eindpunt mogen niet hetzelfde punt zijn.", new IllegalArgumentException());

        this.eindPunt = eindPunt;
        this.startPunt = startPunt;
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof LijnStuk)) return false;
        else {
            LijnStuk l = (LijnStuk) obj;
            return (this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())) ||
                    (this.getEindPunt().equals(l.getStartPunt()) && this.getStartPunt().equals(l.getEindPunt())) ;
        }
    }

    @Override
    public String toString() {
        return "Lijn: " +
                "startpunt: " + startPunt +
                " - eindpunt: " + eindPunt;
    }
}
