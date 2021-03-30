package domain;

public class Omhullende {
    private Punt positieLinksBoven;
    private int breedte, hoogte;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
        if (positieLinksBoven == null) {
            throw new DomainException("positielinksboven mag niet null zijn.", new IllegalArgumentException());
        }
        if (breedte < 0) {
            throw new DomainException("breedte moet positief zijn.", new IllegalArgumentException());
        }
        if (hoogte < 0) {
            throw new DomainException("hoogte moet positief zijn.", new IllegalArgumentException());
        }
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.positieLinksBoven = positieLinksBoven;
    }

    public int getMinimumX() {
        return positieLinksBoven.getX()-breedte;
    }
    public int getMinimumY() {
        return positieLinksBoven.getY()-hoogte;
    }
    public int getMaximumX() {
        return positieLinksBoven.getX()+breedte;
    }
    public int getMaximumY() {
        return positieLinksBoven.getY();
    }

    public Punt getLinkerBovenhoek() {
        return positieLinksBoven;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public boolean equals(Object omhullendeToCheck) {
        if (omhullendeToCheck == null) {
            return false;
        }
        if (this.positieLinksBoven.equals(((Omhullende)omhullendeToCheck).positieLinksBoven) &&
                this.hoogte == ((Omhullende)omhullendeToCheck).hoogte && this.breedte == ((Omhullende)omhullendeToCheck).breedte) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Omhullende: (" + this.positieLinksBoven.getX() + ", " + this.positieLinksBoven.getY() + ") - " + this.breedte + " - " + this.hoogte;
    }
}
