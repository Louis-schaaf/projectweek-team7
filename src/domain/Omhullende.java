package domain;

public class Omhullende {
    private Punt positieLinksBoven;
    private int Breedte, Hoogte;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
        if (positieLinksBoven == null) {
            throw new DomainException("positielinksboven mag nietn ull zijn.", new IllegalArgumentException());
        }
        if ()
    }

}
