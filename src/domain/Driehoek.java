package domain;

public class Driehoek {
    private Punt hoekPunt1,hoekPunt2,hoekPunt3;

    public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
        if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
            throw new DomainException("Hoekpunten mogen niet null zijn", new IllegalArgumentException());
        }
        this.hoekPunt1=hoekPunt1;
        this.hoekPunt2=hoekPunt2;
        this.hoekPunt3=hoekPunt3;
    }
}
