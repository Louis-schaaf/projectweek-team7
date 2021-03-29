package domain;

public class Driehoek {
    private Punt hoekPunt1,hoekPunt2,hoekPunt3;

    public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
        if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
            throw new DomainException("Hoekpunten mogen niet null zijn", new IllegalArgumentException());
        }
        if (liggenOp1Lijn(hoekPunt1,hoekPunt2,hoekPunt3)) {
            throw new DomainException("Hoekpunten mogen niet op 1 lijn liggen", new IllegalArgumentException());
        }
        if (hoekPunt1.equals(hoekPunt2) || hoekPunt1.equals(hoekPunt3)|| hoekPunt2.equals(hoekPunt3)) {
            throw new DomainException("Er mogen geen twee dezelfde hoekpunten zijn",new IllegalArgumentException());
        }
        this.hoekPunt1=hoekPunt1;
        this.hoekPunt2=hoekPunt2;
        this.hoekPunt3=hoekPunt3;
    }

    public boolean liggenOp1Lijn(Punt a, Punt b, Punt c) {
        return ((b.getX()-a.getX())*(c.getY()-a.getY())==(c.getX()-a.getX())*(b.getY()-a.getY()));
    }

    public Punt getHoekPunt1() {
        return hoekPunt1;
    }
    public Punt getHoekPunt2() {
        return hoekPunt2;
    }
    public Punt getHoekPunt3() {
        return hoekPunt3;
    }

    private void sorteerHoekpunten() {
        if (this.hoekPunt1.getX()<this.hoekPunt2.getX() && this.hoekPunt2.getX() < this.hoekPunt3.getX()) {
            return;
        }
        if (this.hoekPunt1.getX() > this.hoekPunt2.getX()) {
            Punt hoekpunt = this.hoekPunt1;
            this.hoekPunt1 = this.hoekPunt2;
            this.hoekPunt2 = hoekpunt;
            sorteerHoekpunten();
        }
        if (this.hoekPunt1.getX() > this.hoekPunt3.getX()) {
            Punt hoekpunt = this.hoekPunt1;
            this.hoekPunt1 = this.hoekPunt3;
            this.hoekPunt3 = hoekpunt;
            sorteerHoekpunten();
        }
        if (this.hoekPunt2.getX() > this.hoekPunt3.getX()) {
            Punt hoekpunt = this.hoekPunt2;
            this.hoekPunt2 = this.hoekPunt3;
            this.hoekPunt3 = hoekpunt;
            sorteerHoekpunten();
        }
        if (this.hoekPunt1.getX()==this.hoekPunt2.getX()) {
            if (this.hoekPunt1.getY()>this.hoekPunt2.getY()) {
                Punt hoekpunt = this.hoekPunt2;
                this.hoekPunt2 = this.hoekPunt1;
                this.hoekPunt1 = hoekpunt;
            }
            return;
        }
        if (this.hoekPunt2.getX()==this.hoekPunt3.getX()) {
            if (this.hoekPunt2.getY()>this.hoekPunt3.getY()) {
                Punt hoekpunt = this.hoekPunt2;
                this.hoekPunt2 = this.hoekPunt3;
                this.hoekPunt2 = hoekpunt;
            }
            return;
        }

    }

    public boolean equals(Object driehoek) {
        if (driehoek == null || !(driehoek instanceof  Driehoek)) {
            return false;
        }
        Driehoek d = (Driehoek) driehoek;
        this.sorteerHoekpunten();
        d.sorteerHoekpunten();
        if (d.getHoekPunt1().equals(this.hoekPunt1)&& d.getHoekPunt2().equals(this.hoekPunt2) && d.getHoekPunt3().equals(this.hoekPunt3)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.getClass().getSimpleName()+": hoekpunt 1: "+hoekPunt1+" - hoekpunt 2: "+hoekPunt2+" - hoekpunt 3: "+hoekPunt3+"\n";

    }

}
