package domain;

public class Cirkel {
    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int radius) {
        setMiddelpunt(middelpunt);
        setRadius(radius);
    }

    private void setMiddelpunt(Punt middelpunt) {
        if (middelpunt == null) {
            throw new DomainException("Middelpunt mag niet leeg zijn",new IllegalArgumentException());
        }
        this.middelpunt = middelpunt;
    }

    private void setRadius(int radius) {
        if (radius <= 0) {
            throw new DomainException("Ongeldige radius", new IllegalArgumentException());
        }
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public int getRadius() {
        return radius;
    }

    public boolean equals(Object andereCirkel) {
        if (andereCirkel == null || !(andereCirkel instanceof Cirkel))  {
            return false;
        }
        Cirkel cirkel = (Cirkel) andereCirkel;
        if (cirkel.getMiddelpunt() == this.getMiddelpunt() && cirkel.getRadius()== this.getRadius()){
            return true;
        }
        return false;
    }

    public String toString() {
        return this.getClass().getSimpleName()+": middelpunt: "+getMiddelpunt()+" - straal: "+getRadius()+"\n";
    }
}
