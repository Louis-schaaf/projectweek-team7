package domain;

public class Rechthoek {
     private int breedte, hoogte;
     private Punt linkerBovenHoek;


    public Rechthoek(Punt linkerBovenHoek, int breedte, int hoogte) {
        if (breedte <= 0) throw new DomainException("Breedte moet groter zijn dan 0");
        if (hoogte <= 0) throw new DomainException("Hoogte moet groter zijn dan 0");
        if (linkerBovenHoek == null) throw new DomainException("Punt mag niet leeg zijn");

        this.breedte = breedte;
        this.hoogte = hoogte;
        this.linkerBovenHoek = linkerBovenHoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rechthoek){
            Rechthoek r = (Rechthoek) obj;
            return (this.getBreedte() == r.getBreedte() && this.getHoogte() == r.getHoogte() && this.getLinkerBovenhoek().equals(r.getLinkerBovenhoek()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rechthoek: " +
                "linkerbovenhoek: " + linkerBovenHoek +
                " - breedte: " + breedte +
                " - hoogte: " + hoogte;

    }
}
